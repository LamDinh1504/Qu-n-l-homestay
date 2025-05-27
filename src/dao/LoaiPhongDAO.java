/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConnectDB.ConnectionUtils;
import java.util.ArrayList;
import model.LoaiPhong;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class LoaiPhongDAO {
    public ArrayList<LoaiPhong> getAllLoaiPhong() {
        ArrayList<LoaiPhong> dsLoaiPhong = new ArrayList<>();
        String query = "SELECT * FROM LOAIPHONG";
        try (Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong(
                    rs.getString("MALOAI"),
                    rs.getString("TENLOAI"),
                    rs.getInt("GIACOBAN"),
                    rs.getString("MOTA")
                );
                dsLoaiPhong.add(lp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Lỗi khi truy vấn dữ liệu loại phòng: " + e.getMessage());
        }
        return dsLoaiPhong;
    }

    public int addLoaiPhong(String maLoai, String tenLoai, int giaCoBan, String moTa) {
        int i = 0;
        try (Connection con = ConnectionUtils.getMyConnection()) {
            String query = "INSERT INTO LOAIPHONG VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maLoai);
            ps.setString(2, tenLoai);
            ps.setInt(3, giaCoBan);
            ps.setString(4, moTa);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }

    public static int deleteLoaiPhong(String maLoai) {
        int i = 0;
        try (Connection con = ConnectionUtils.getMyConnection()) {
            String query = "DELETE FROM LOAIPHONG WHERE MALOAI = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maLoai.trim());
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }

    public void updateLoaiPhong(String maLoai, String tenLoai, int giaCoBan, String moTa) {
        String query = "UPDATE LOAIPHONG SET TENLOAI=?, GIACOBAN=?, MOTA=? WHERE MALOAI=?";
        try (Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, tenLoai);
            ps.setInt(2, giaCoBan);
            ps.setString(3, moTa);
            ps.setString(4, maLoai);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static LoaiPhong getLoaiPhong(String maLoai) {
        String query = "SELECT * FROM LOAIPHONG WHERE MALOAI = ?";
        try (Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maLoai);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new LoaiPhong(
                    rs.getString("MALOAI"),
                    rs.getString("TENLOAI"),
                    rs.getInt("GIACOBAN"),
                    rs.getString("MOTA")
                );
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    public LoaiPhong getLoaiPhongByTen(String tenLoai) {
        ArrayList<LoaiPhong> danhSach = getAllLoaiPhong();
        for (LoaiPhong lp : danhSach) {
            if (lp.getTenLoai().equals(tenLoai)) {
                return lp;
            }
        }
        return null;
    }
}
