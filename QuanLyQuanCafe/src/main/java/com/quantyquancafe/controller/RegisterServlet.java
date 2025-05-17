package com.quantyquancafe.controller;

import com.quantyquancafe.model.User;
import com.quantyquancafe.model.UserDAO;
import com.quantyquancafe.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    
    private UserDAO userDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        try {
            // Lấy thông tin từ form
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            
            // In ra console để debug
            System.out.println("RegisterServlet - Received data:");
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Address: " + address);
            System.out.println("Phone: " + phone);
            
            // Kiểm tra dữ liệu
            if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                email == null || email.trim().isEmpty()) {
                
                System.out.println("Missing required fields");
                response.sendRedirect("createAccount.jsp?error=empty");
                return;
            }
            
            // Kiểm tra username và email đã tồn tại chưa
            if (userDAO.getUserByUsername(username) != null) {
                System.out.println("Username already exists: " + username);
                response.sendRedirect("createAccount.jsp?error=username_exists");
                return;
            }
            
            if (userDAO.getUserByEmail(email) != null) {
                System.out.println("Email already exists: " + email);
                response.sendRedirect("createAccount.jsp?error=email_exists");
                return;
            }
            
            // Mã hóa mật khẩu (trong trường hợp này không mã hóa)
            String hashedPassword = password; // PasswordUtil.hashPassword(password);
            
            // Tạo đối tượng User
            User user = new User();
            user.setUsername(username);
            user.setPassword(hashedPassword);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);
            
            System.out.println("Attempting to register user: " + username);
            
            // Lưu vào cơ sở dữ liệu
            boolean result = userDAO.registerUser(user);
            
            if (result) {
                System.out.println("Registration successful for: " + username);
                response.sendRedirect("login.jsp?registered=true&username=" + username);
            } else {
                System.out.println("Registration failed for: " + username);
                response.sendRedirect("createAccount.jsp?error=failed");
            }
            
        } catch (Exception e) {
            System.out.println("Error in RegisterServlet: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("createAccount.jsp?error=system&message=" + e.getMessage());
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Chuyển hướng đến trang đăng ký
        request.getRequestDispatcher("createAccount.jsp").forward(request, response);
    }
}