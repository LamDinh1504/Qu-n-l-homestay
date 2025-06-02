/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author Admin
 */
public class TaiKhoanData1 {
    public static boolean kiemTraDangNhap(String email, String password) {
        try (Connection conn = ConnectDB.Connection.getOracleConnection()) {
            String sql = "SELECT * FROM TAIKHOAN WHERE EMAIL = ? AND PASSWORD = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean themTaiKhoan(String email, String password) {
            Connection conn = null;
            PreparedStatement stmt = null;

    try {
        conn = ConnectDB.Connection.getOracleConnection();
        conn.setAutoCommit(false); // Bắt buộc với Oracle
        String sql = "INSERT INTO TAIKHOAN (EMAIL, PASSWORD) VALUES (?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, password);
        int rows = stmt.executeUpdate();
        conn.commit(); // Chắc chắn commit trước khi đóng
        return rows > 0;
    } catch (SQLIntegrityConstraintViolationException e) {
        System.out.println("Tài khoản đã tồn tại.");
        return false;
    } catch (Exception e) {
        e.printStackTrace();
        try {
            if (conn != null) conn.rollback(); // rollback nếu lỗi
        } catch (Exception rollbackEx) {
            rollbackEx.printStackTrace();
        }
        return false;
    } finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception closeEx) {
            closeEx.printStackTrace();
        }
    }

}
}
