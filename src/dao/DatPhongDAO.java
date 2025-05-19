/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import ConnectDB.ConnectionUtils;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class DatPhongDAO {
    public int addDatPhong(String maDatPhong, String maKhachHang, String maPhong, String ngayBatDau, String ngayTra, String trangThai) {
    int i = 0;
    String query = "INSERT INTO DATPHONG (MADATPHONG, MAKHACHHANG, MAPHONG, NGAYBATDAU, NGAYTRA, TRANGTHAI) " +
                   "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ?)";

    try (Connection con = ConnectionUtils.getMyConnection()) {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, maDatPhong);
        ps.setString(2, maKhachHang);
        ps.setString(3, maPhong);
        ps.setString(4, ngayBatDau); // ví dụ: "2025-05-20"
        ps.setString(5, ngayTra);    // ví dụ: "2025-05-25"
        ps.setString(6, trangThai);
        i = ps.executeUpdate();
    } catch (Exception e) {
        System.out.print(e);
    }
        return i;
    }
    
    public void updateDatPhong(String maDatPhong, String maKhachHang, String maPhong, String ngayBatDau, String ngayTra, String trangThai) {
    String query = "UPDATE DATPHONG SET MAKHACHHANG = ?, MAPHONG = ?, " +
                   "NGAYBATDAU = TO_DATE(?, 'YYYY-MM-DD'), NGAYTRA = TO_DATE(?, 'YYYY-MM-DD'), TRANGTHAI = ? " +
                   "WHERE MADATPHONG = ?";

    try (Connection conn = ConnectionUtils.getMyConnection()) {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, maKhachHang);
        ps.setString(2, maPhong);
        ps.setString(3, ngayBatDau); // dạng "yyyy-MM-dd"
        ps.setString(4, ngayTra);
        ps.setString(5, trangThai);
        ps.setString(6, maDatPhong);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.print(e);
        }
    }
    public static int deleteDatPhong(String maDatPhong) {
    int i = 0;
    try (Connection con = ConnectionUtils.getMyConnection()) {
        String query = "DELETE FROM DATPHONG WHERE MADATPHONG = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, maDatPhong.trim());
        i = ps.executeUpdate();
    } catch (Exception e) {
        System.out.print(e);
    }
    return i;
}
    public static int demSoDatPhong() {
        String sql = "SELECT COUNT(*) FROM DATPHONG";
        try (Connection conn =ConnectionUtils.getMyConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1); // số lượng KH hiện có
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
