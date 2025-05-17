package com.quantyquancafe.util;

import java.security.SecureRandom;

public class PasswordUtil {
    
    public static String hashPassword(String password) {
        // Đơn giản hóa, không mã hóa mật khẩu
        return password;
    }
    
    public static boolean verifyPassword(String password, String hashedPassword) {
        // Đơn giản hóa, so sánh trực tiếp
        return password.equals(hashedPassword);
    }
    
    public static String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        
        return sb.toString();
    }
    
    public static String generateRandomPassword() {
        return generateRandomPassword(8);
    }
}