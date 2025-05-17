package com.quantyquancafe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.quantyquancafe.util.DBConnection;

@WebServlet("/test-db")
public class TestDatabaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Database Test</title>");
        out.println("</head>");
        out.println("<body>");
        
        try {
            out.println("<h2>Đang kết nối đến cơ sở dữ liệu...</h2>");
            Connection conn = DBConnection.getConnection();
            out.println("<h2>Kết nối cơ sở dữ liệu thành công!</h2>");
            
            // Kiểm tra metadata của database
            DatabaseMetaData metaData = conn.getMetaData();
            out.println("<h3>Thông tin Database:</h3>");
            out.println("<p>Database: " + metaData.getDatabaseProductName() + " " + metaData.getDatabaseProductVersion() + "</p>");
            out.println("<p>Driver: " + metaData.getDriverName() + " " + metaData.getDriverVersion() + "</p>");
            out.println("<p>URL: " + metaData.getURL() + "</p>");
            out.println("<p>User: " + metaData.getUserName() + "</p>");
            
            // Kiểm tra bảng taikhoannguoidung
            out.println("<h3>Kiểm tra bảng taikhoannguoidung:</h3>");
            ResultSet tables = metaData.getTables(null, null, "taikhoannguoidung", null);
            
            if (tables.next()) {
                out.println("<p>Bảng taikhoannguoidung tồn tại!</p>");
                
                // Hiển thị cấu trúc bảng
                out.println("<h4>Cấu trúc bảng:</h4>");
                ResultSet columns = metaData.getColumns(null, null, "taikhoannguoidung", null);
                out.println("<table border='1'>");
                out.println("<tr><th>Tên cột</th><th>Kiểu dữ liệu</th><th>Kích thước</th><th>Nullable</th></tr>");
                
                while (columns.next()) {
                    out.println("<tr>");
                    out.println("<td>" + columns.getString("COLUMN_NAME") + "</td>");
                    out.println("<td>" + columns.getString("TYPE_NAME") + "</td>");
                    out.println("<td>" + columns.getInt("COLUMN_SIZE") + "</td>");
                    out.println("<td>" + (columns.getInt("NULLABLE") == 1 ? "Yes" : "No") + "</td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
                
                // Hiển thị dữ liệu trong bảng
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM taikhoannguoidung");
                
                out.println("<h4>Dữ liệu trong bảng:</h4>");
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Username</th><th>Email</th><th>Password</th><th>Phone</th><th>Address</th></tr>");
                
                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("id") + "</td>");
                    out.println("<td>" + rs.getString("username") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getString("password") + "</td>");
                    out.println("<td>" + rs.getString("phone") + "</td>");
                    out.println("<td>" + rs.getString("address") + "</td>");
                    out.println("</tr>");
                }
                
                if (!hasData) {
                    out.println("<tr><td colspan='6'>Không có dữ liệu</td></tr>");
                }
                
                out.println("</table>");
                
                // Thêm form để thêm user mới
                out.println("<h4>Thêm user mới:</h4>");
                out.println("<form action='test-db' method='post'>");
                out.println("<table>");
                out.println("<tr><td>Username:</td><td><input type='text' name='username' required></td></tr>");
                out.println("<tr><td>Email:</td><td><input type='email' name='email' required></td></tr>");
                out.println("<tr><td>Password:</td><td><input type='password' name='password' required></td></tr>");
                out.println("<tr><td>Phone:</td><td><input type='text' name='phone'></td></tr>");
                out.println("<tr><td>Address:</td><td><input type='text' name='address'></td></tr>");
                out.println("<tr><td colspan='2'><input type='submit' value='Thêm user'></td></tr>");
                out.println("</table>");
                out.println("</form>");
                
                rs.close();
                stmt.close();
            } else {
                out.println("<p>Bảng taikhoannguoidung không tồn tại!</p>");
                
                // Tạo bảng nếu chưa tồn tại
                out.println("<h4>Tạo bảng taikhoannguoidung:</h4>");
                Statement stmt = conn.createStatement();
                String createTableSQL = "CREATE TABLE taikhoannguoidung (" +
                                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                       "username VARCHAR(50) NOT NULL UNIQUE, " +
                                       "email VARCHAR(100) NOT NULL UNIQUE, " +
                                       "password VARCHAR(100) NOT NULL, " +
                                       "phone VARCHAR(20), " +
                                       "address VARCHAR(255)" +
                                       ")";
                stmt.executeUpdate(createTableSQL);
                out.println("<p>Đã tạo bảng taikhoannguoidung thành công!</p>");
                stmt.close();
            }
            
            DBConnection.closeConnection(conn);
        } catch (Exception e) {
            out.println("<h2>Lỗi kết nối cơ sở dữ liệu:</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            e.printStackTrace(out);
        }
        
        out.println("</body>");
        out.println("</html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add User Result</title>");
        out.println("</head>");
        out.println("<body>");
        
        try {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            
            Connection conn = DBConnection.getConnection();
            
            // Thêm user mới
            String sql = "INSERT INTO taikhoannguoidung (username, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, phone);
            stmt.setString(5, address);
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                out.println("<h2>Thêm user thành công!</h2>");
            } else {
                out.println("<h2>Thêm user thất bại!</h2>");
            }
            
            out.println("<a href='test-db'>Quay lại</a>");
            
            stmt.close();
            DBConnection.closeConnection(conn);
        } catch (Exception e) {
            out.println("<h2>Lỗi khi thêm user:</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            e.printStackTrace(out);
            out.println("<a href='test-db'>Quay lại</a>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}