/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import ConnectDB.ConnectionUtils;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import model.KhachHang;
import java.sql.*;
import model.DichVu;

/**
 *
 * @author ASUS
 */
public class KhachHangDAO {

    // Lấy danh sách tất cả khách hàng
    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> dsKhachHang = new ArrayList<>();
        String query = "SELECT * FROM KHACHHANG";
        try (Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang currentKhachHang = new KhachHang(
                    rs.getString("MAKH"),
                    rs.getString("TENKH"),
                    rs.getString("SODIENTHOAI"),
                    rs.getString("CMND_PASSPORT"),
                    rs.getString("EMAIL"),
                    rs.getString("DIACHI"),
                    rs.getString("GIOITINH")
                );
                dsKhachHang.add(currentKhachHang);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi truy vấn dữ liệu khách hàng: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHangDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return dsKhachHang;
    }

    // Thêm một khách hàng mới
    public int addKhachHang(String maKhachHang, String hoTen, String soDienThoai, String cmnd, String email, String diaChi,String gioiTinh) {
        int i = 0;
        try (Connection con = ConnectionUtils.getMyConnection()) {
            String query = "INSERT INTO KHACHHANG VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maKhachHang);
            ps.setString(2, hoTen);
            ps.setString(3, soDienThoai);
            ps.setString(4, cmnd);
            ps.setString(5, email);
            ps.setString(6, diaChi);
            ps.setString(7, gioiTinh);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }

    // Xóa một khách hàng theo mã
    public static int deleteKhachHang(String maKhachHang) {
        
        
        int i = 0;
        try (Connection con = ConnectionUtils.getMyConnection()) {
            String query = "DELETE FROM KHACHHANG WHERE MAKH = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maKhachHang.trim());
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }
    
     public static KhachHang getKhachHang(String maKhachHang){
        String query = "SELECT * FROM KHACHHANG WHERE MAKH = ?";
        try(Connection conn = ConnectionUtils.getMyConnection()) {
             PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, maKhachHang);
            ResultSet rs = ps.executeQuery();
            KhachHang currentKhachHang = new KhachHang();
            while(rs.next()){
                currentKhachHang = new KhachHang(
                        rs.getString("MAKH"),
                        rs.getString("TENKH"),
                        rs.getString("SODIENTHOAI"),
                        rs.getString("CMND_PASSPORT"),
                        rs.getString("EMAIL"),
                        rs.getString("DIACHI"),
                        rs.getString("GIOITINH")
                );}
            return currentKhachHang;
        }
        catch(Exception e){
            System.out.print(e);
            return null;
        }
    }
     public void updateKhachHang(String maKhachHang, String hoTen, String gioiTinh, String soDienThoai, String cmnd, String diaChi, String email) {
    String query = "UPDATE KHACHHANG SET HOTEN = ?, GIOITINH = ?, SODIENTHOAI = ?, CMND = ?, DIACHI = ?, EMAIL = ? WHERE MAKHACHHANG = ?";
    
    try (Connection conn = ConnectionUtils.getMyConnection()) {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, maKhachHang);
        ps.setString(2, hoTen);
        ps.setString(3, gioiTinh);
        ps.setString(4, soDienThoai);
        ps.setString(5, cmnd);
        ps.setString(6, diaChi);
        ps.setString(7, email);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.print(e);
    }
}
     public static int demSoKhachHang() {
        String sql = "SELECT COUNT(*) FROM KHACHHANG";
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
