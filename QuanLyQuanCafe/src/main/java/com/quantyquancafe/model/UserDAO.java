package com.quantyquancafe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.quantyquancafe.util.DBConnection;
import com.quantyquancafe.util.PasswordUtil;

public class UserDAO {
    
    // Phương thức kiểm tra đăng nhập
	public User checkLogin(String usernameOrEmail, String password) {
	    System.out.println("Checking login for: " + usernameOrEmail);
	    System.out.println("With password: " + password);
	    
	    // Kiểm tra nếu là tài khoản admin
	    if ((usernameOrEmail.equals("admin") || usernameOrEmail.equals("admin123@gmail.com")) 
	            && password.equals("admin123")) {
	        System.out.println("Admin account detected!");
	        // Tạo đối tượng User cho admin
	        User adminUser = new User();
	        adminUser.setId(0); // ID đặc biệt cho admin
	        adminUser.setUsername("admin");
	        adminUser.setEmail("admin123@gmail.com");
	        adminUser.setPassword("admin123");
	        adminUser.setAdmin(true); // Đặt quyền admin
	        return adminUser;
	    }
	    
	    // Nếu không phải admin, tiếp tục kiểm tra trong database
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    User user = null;
	    
	    try {
	        conn = DBConnection.getConnection();
	        
	        // SQL query để tìm user theo username hoặc email
	        String sql = "SELECT * FROM taikhoannguoidung WHERE username = ? OR email = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, usernameOrEmail);
	        stmt.setString(2, usernameOrEmail);
	        
	        System.out.println("Executing SQL: " + sql);
	        System.out.println("With parameters: " + usernameOrEmail);
	        
	        rs = stmt.executeQuery();
	        
	        // Nếu tìm thấy user
	        if (rs.next()) {
	            user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("username"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setPhone(rs.getString("phone"));
	            user.setAddress(rs.getString("address"));
	            
	            // In ra thông tin để debug
	            System.out.println("Found user: " + user.getUsername());
	            System.out.println("Stored password: " + user.getPassword());
	            System.out.println("Input password: " + password);
	            
	            // Kiểm tra mật khẩu trực tiếp (không mã hóa)
	            if (user.getPassword().equals(password)) {
	                System.out.println("Password matches!");
	                return user;
	            } else {
	                System.out.println("Password does not match!");
	            }
	        } else {
	            System.out.println("User not found in database");
	        }
	    } catch (SQLException e) {
	        System.out.println("SQL Error: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        // Đóng các kết nối
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) DBConnection.closeConnection(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    System.out.println("Login failed for: " + usernameOrEmail);
	    return null;
	}
    
    // Phương thức đăng ký người dùng mới
	public boolean registerUser(User user) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    
	    try {
	        conn = DBConnection.getConnection();
	        
	        // In ra thông tin kết nối để debug
	        System.out.println("Database connected: " + conn);
	        
	        // SQL query để thêm user mới
	        String sql = "INSERT INTO taikhoannguoidung (username, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, user.getUsername());
	        stmt.setString(2, user.getEmail());
	        stmt.setString(3, user.getPassword());
	        stmt.setString(4, user.getPhone());
	        stmt.setString(5, user.getAddress());
	        
	        // In ra câu SQL để debug (không bao gồm giá trị thực)
	        System.out.println("SQL Query: " + sql);
	        System.out.println("Username: " + user.getUsername());
	        System.out.println("Email: " + user.getEmail());
	        
	        // Thực thi query
	        int rowsAffected = stmt.executeUpdate();
	        
	        // In ra kết quả để debug
	        System.out.println("Rows affected: " + rowsAffected);
	        
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        System.out.println("SQL Error: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    } finally {
	        // Đóng các kết nối
	        try {
	            if (stmt != null) stmt.close();
	            if (conn != null) DBConnection.closeConnection(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
    
    // Phương thức lấy user theo username
    public User getUserByUsername(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        
        try {
            conn = DBConnection.getConnection();
            
            // SQL query để tìm user theo username
            String sql = "SELECT * FROM taikhoannguoidung WHERE username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            
            rs = stmt.executeQuery();
            
            // Nếu tìm thấy user
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các kết nối
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return user;
    }
    
    // Phương thức lấy user theo email
    public User getUserByEmail(String email) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        
        try {
            conn = DBConnection.getConnection();
            
            // SQL query để tìm user theo email
            String sql = "SELECT * FROM taikhoannguoidung WHERE email = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            
            rs = stmt.executeQuery();
            
            // Nếu tìm thấy user
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các kết nối
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return user;
    }
    
    // Phương thức kiểm tra email tồn tại
    public boolean isEmailExists(String email) {
        return getUserByEmail(email) != null;
    }
    
    // Phương thức cập nhật mật khẩu
    public boolean updatePassword(String email, String newPassword) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DBConnection.getConnection();
            
            // Mã hóa mật khẩu mới
            String hashedPassword = PasswordUtil.hashPassword(newPassword);
            
            // SQL query để cập nhật mật khẩu
            String sql = "UPDATE taikhoannguoidung SET password = ? WHERE email = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, hashedPassword);
            stmt.setString(2, email);
            
            // Thực thi query
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng các kết nối
            try {
                if (stmt != null) stmt.close();
                if (conn != null) DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}