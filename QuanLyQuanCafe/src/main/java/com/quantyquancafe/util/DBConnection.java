package com.quantyquancafe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Thông tin kết nối MySQL
	private static final String DB_URL = "jdbc:mysql://localhost:3306/db_coffeshop?useSSL=false&serverTimezone=UTC";

    private static final String DB_USER = "root"; // Sử dụng người dùng root như trong hình
    private static final String DB_PASSWORD = ""; // Điền mật khẩu của root nếu có
    
    public static Connection getConnection() throws SQLException {
        try {
            // Đăng ký MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // In ra thông tin kết nối để debug
            System.out.println("Connecting to database: " + DB_URL);
            System.out.println("With user: " + DB_USER);
            
            // Tạo kết nối
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connection successful!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
            throw new SQLException("MySQL JDBC Driver không tìm thấy", e);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            throw e;
        }
    }
    
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}