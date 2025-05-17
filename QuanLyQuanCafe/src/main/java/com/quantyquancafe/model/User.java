package com.quantyquancafe.model;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
    private boolean admin; // Thêm trường admin
    
    // Constructors
    public User() {
        this.admin = false; // Mặc định không phải admin
    }
    
    public User(String username, String email, String password, String phone, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.admin = false; // Mặc định không phải admin
    }
    
    // Getters và setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    // Phương thức kiểm tra admin
    public boolean isAdmin() {
        // Nếu username là "admin" hoặc email là "admin123@gmail.com"
        if (this.username != null && (this.username.equals("admin") || 
            (this.email != null && this.email.equals("admin123@gmail.com")))) {
            return true;
        }
        return this.admin; // Trả về giá trị của trường admin
    }
    
    // Thêm phương thức setAdmin
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}