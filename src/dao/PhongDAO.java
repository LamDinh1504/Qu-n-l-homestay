/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConnectDB.ConnectionUtils;
import java.util.ArrayList;
import model.Phong;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class PhongDAO {
     public static ArrayList<Phong> getAllPhong() {
        ArrayList<Phong> dsPhong = new ArrayList<>();
        String query = "SELECT * FROM PHONG";
        try (Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Phong p = new Phong(
                    rs.getString("MAPHONG"),
                    rs.getString("KIEUPHONG"),
                    rs.getString("TRANGTHAI"),
                    rs.getInt("TANG"),
                    rs.getString("MALOAI")
                );
                dsPhong.add(p);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Lỗi khi truy vấn dữ liệu phòng: " + e.getMessage());
        }
        return dsPhong;
    }

    public int addPhong(String maPhong, String kieuPhong, String trangThai, int tang, String maLoai) {
        int i = 0;
        try (Connection con = ConnectionUtils.getMyConnection()) {
            String query = "INSERT INTO PHONG VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maPhong);
            ps.setString(2, kieuPhong);
            ps.setString(3, trangThai);
            ps.setInt(4, tang);
            ps.setString(5, maLoai);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }

    public static int deletePhong(String maPhong) {
        int i = 0;
        try (Connection con = ConnectionUtils.getMyConnection()) {
            String query = "DELETE FROM PHONG WHERE MAPHONG = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maPhong.trim());
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }

    public void updatePhong(String maPhong, String kieuPhong, String trangThai, int tang, String maLoai) {
        String query = "UPDATE PHONG SET KIEUPHONG=?, TRANGTHAI=?, TANG=?, MALOAI=? WHERE MAPHONG=?";
        try (Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, kieuPhong);
            ps.setString(2, trangThai);
            ps.setInt(3, tang);
            ps.setString(4, maLoai);
            ps.setString(5, maPhong);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static Phong getPhong(String maPhong) {
        String query = "SELECT * FROM PHONG WHERE MAPHONG = ?";
        try (Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Phong(
                    rs.getString("MAPHONG"),
                    rs.getString("KIEUPHONG"),
                    rs.getString("TRANGTHAI"),
                    rs.getInt("TANG"),
                    rs.getString("MALOAI")
                );
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    public static Phong getPhongByKieu(String kieuPhong) {
        ArrayList<Phong> danhSach = getAllPhong();
        for (Phong p : danhSach) {
            if (p.getKieuPhong().equals(kieuPhong)) {
                return p;
            }
        }
        return null;
    }
}
