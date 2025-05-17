package com.quantyquancafe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.quantyquancafe.util.DBConnection;

@WebServlet("/check-admin")
public class CheckAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Check Admin Account</title>");
        out.println("</head>");
        out.println("<body>");
        
        try {
            Connection conn = DBConnection.getConnection();
            out.println("<h2>Kết nối cơ sở dữ liệu thành công!</h2>");
            
            // Kiểm tra tài khoản admin
            String sql = "SELECT * FROM taikhoannguoidung WHERE username = 'admin'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                out.println("<h3>Tài khoản admin đã tồn tại:</h3>");
                out.println("<p>Username: " + rs.getString("username") + "</p>");
                out.println("<p>Email: " + rs.getString("email") + "</p>");
                out.println("<p>Password: " + rs.getString("password") + "</p>");
            } else {
                out.println("<h3>Tài khoản admin chưa tồn tại!</h3>");
                out.println("<p>Đang tạo tài khoản admin...</p>");
                
                // Tạo tài khoản admin
                sql = "INSERT INTO taikhoannguoidung (username, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "admin");
                stmt.setString(2, "admin123@gmail.com");
                stmt.setString(3, "admin");
                stmt.setString(4, "");
                stmt.setString(5, "");
                
                int rowsAffected = stmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    out.println("<p>Tạo tài khoản admin thành công!</p>");
                } else {
                    out.println("<p>Tạo tài khoản admin thất bại!</p>");
                }
            }
            
            // Hiển thị tất cả người dùng
            sql = "SELECT * FROM taikhoannguoidung";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            out.println("<h3>Danh sách tất cả người dùng:</h3>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Username</th><th>Email</th><th>Password</th><th>Phone</th><th>Address</th></tr>");
            
            boolean hasUsers = false;
            while (rs.next()) {
                hasUsers = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("username") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("</tr>");
            }
            
            if (!hasUsers) {
                out.println("<tr><td colspan='6'>Không có người dùng nào!</td></tr>");
            }
            
            out.println("</table>");
            
            // Kiểm tra cấu trúc bảng
            out.println("<h3>Cấu trúc bảng taikhoannguoidung:</h3>");
            rs = conn.getMetaData().getColumns(null, null, "taikhoannguoidung", null);
            
            out.println("<table border='1'>");
            out.println("<tr><th>Tên cột</th><th>Kiểu dữ liệu</th><th>Kích thước</th><th>Nullable</th></tr>");
            
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("COLUMN_NAME") + "</td>");
                out.println("<td>" + rs.getString("TYPE_NAME") + "</td>");
                out.println("<td>" + rs.getInt("COLUMN_SIZE") + "</td>");
                out.println("<td>" + (rs.getInt("NULLABLE") == 1 ? "Yes" : "No") + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            
            rs.close();
            stmt.close();
            DBConnection.closeConnection(conn);
        } catch (Exception e) {
            out.println("<h2>Lỗi kết nối cơ sở dữ liệu:</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            e.printStackTrace(out);
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}