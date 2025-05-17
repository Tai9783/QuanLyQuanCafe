package com.quantyquancafe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.quantyquancafe.model.User;
import com.quantyquancafe.model.UserDAO;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserDAO userDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Chuyển hướng đến trang login.jsp
        response.sendRedirect("login.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Thiết lập response type
        response.setContentType("text/html;charset=UTF-8");
        
        // Lấy thông tin đăng nhập từ request
        String usernameOrEmail = request.getParameter("usernameOrEmail");
        String password = request.getParameter("password");
        boolean keepSignedIn = "true".equals(request.getParameter("keepSignedIn"));
        
        // Thêm log để debug
        System.out.println("Login attempt - Username/Email: " + usernameOrEmail);
        System.out.println("Password: " + password);
        System.out.println("Keep signed in: " + keepSignedIn);
        
        // Kiểm tra thông tin đăng nhập
        if (usernameOrEmail == null || usernameOrEmail.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            
            System.out.println("Empty username or password");
            response.sendRedirect("login.jsp?error=empty");
            return;
        }
        
        // Kiểm tra đăng nhập
        User user = userDAO.checkLogin(usernameOrEmail, password);
        
        if (user != null) {
            // Đăng nhập thành công
            System.out.println("Login successful for: " + usernameOrEmail);
            System.out.println("User details: " + user.getUsername() + ", " + user.getEmail());
            System.out.println("Is admin: " + user.isAdmin());
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            // Nếu người dùng chọn "Keep me signed in", thiết lập thời gian session dài hơn
            if (keepSignedIn) {
                session.setMaxInactiveInterval(7 * 24 * 60 * 60); // 7 ngày
            }
            
            // Kiểm tra nếu là admin
            if (user.isAdmin()) {
                System.out.println("Redirecting to admin dashboard");
                response.sendRedirect("admin/dashboard.jsp");
            } else {
                System.out.println("Redirecting to user home page");
                response.sendRedirect("index.jsp");
            }
        } else {
            // Đăng nhập thất bại
            System.out.println("Login failed for: " + usernameOrEmail);
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
    
}