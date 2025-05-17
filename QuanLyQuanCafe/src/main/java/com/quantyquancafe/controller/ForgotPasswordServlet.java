package com.quantyquancafe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.quantyquancafe.model.UserDAO;
import com.quantyquancafe.util.PasswordUtil;


public class ForgotPasswordServlet extends HttpServlet {
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
        // Chuyển hướng đến trang forgotPass.jsp
        response.sendRedirect("forgotPass.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Thiết lập response type
        response.setContentType("text/html;charset=UTF-8");
        
        // Lấy email từ request
        String email = request.getParameter("email");
        
        // Thêm log để debug
        System.out.println("Password reset attempt for email: " + email);
        
        // Kiểm tra email
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Empty email");
            response.sendRedirect("forgotPass.jsp?error=empty");
            return;
        }
        
        // Kiểm tra email có tồn tại trong hệ thống không
        if (!userDAO.isEmailExists(email)) {
            System.out.println("Email not found: " + email);
            response.sendRedirect("forgotPass.jsp?error=notfound");
            return;
        }
        
        // Tạo mật khẩu mới ngẫu nhiên
        String newPassword = PasswordUtil.generateRandomPassword(8);
        System.out.println("Generated new password for " + email + ": " + newPassword);
        
        // Cập nhật mật khẩu mới vào cơ sở dữ liệu
        boolean updated = userDAO.updatePassword(email, newPassword);
        
        if (updated) {
            System.out.println("Password reset successful for: " + email);
            // Hiển thị mật khẩu mới cho người dùng
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Đặt lại mật khẩu</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f4f4f4; }");
            out.println(".container { max-width: 600px; margin: 0 auto; background: white; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
            out.println("h1 { color: #333; }");
            out.println(".password { font-size: 18px; padding: 10px; background-color: #f8f8f8; border: 1px solid #ddd; margin: 15px 0; }");
            out.println(".btn { display: inline-block; padding: 10px 15px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 4px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>New password has been created</h1>");
            out.println("<p>Your new password is:</p>");
            out.println("<div class='password'>" + newPassword + "</div>");
            out.println("<p>Please use this password to log in and change your password after logging in.</p>");
            out.println("<a href='login.jsp' class='btn'>Sign in now</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } else {
            System.out.println("Password reset failed for: " + email);
            response.sendRedirect("forgotPass.jsp?error=failed");
        }
    }
}