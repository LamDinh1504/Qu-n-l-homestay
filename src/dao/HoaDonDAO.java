/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.NhanVien;

/**
 *
 * @author ASUS
 */
public class HoaDonDAO {
    public ArrayList<HoaDon> getAllHoaDon()   {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
        String query = "SELECT * FROM HOADON";
        try(Connection conn = ConnectionUtils.getMyConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                HoaDon currentHoaDon = new HoaDon(
                    rs.getString("MAHD"),
                    rs.getString("MADP"),
                    rs.getString("NGAYLAP"),
                    rs.getInt("THANHTIEN")
                );
    dsHoaDon.add(currentHoaDon);
}
            } catch (SQLException e) {
        System.err.println("Lỗi khi truy vấn dữ liệu nhân viên: " + e.getMessage());
} catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      return dsHoaDon;
    }
  
    
    public int addHoaDon(String maHoaDon,String maDatPhong,String ngayLap,int thanhTien) {
            int i = 0;
        try (Connection con = ConnectionUtils.getMyConnection()) {
            String query = "INSERT INTO HOADON VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maHoaDon);
            ps.setString(2, maDatPhong);

            // Chuyển String "dd-MM-yyyy" sang java.sql.Date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(ngayLap, formatter);
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

            ps.setDate(3, sqlDate);  // <-- đúng kiểu dữ liệu DATE
            ps.setInt(4, thanhTien);
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi chi tiết ra console
        }
        return i;
    }
    public static int deleteHoaDon(String maHoaDon){
        int i=0;
        try(Connection con=ConnectionUtils.getMyConnection()) {
            String query="DELETE FROM HOADON WHERE MAHD= ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maHoaDon.trim());
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public void updateHoaDon(String maHoaDon,String maDatPhong,String ngayLap, int thanhTien){
        String query = "UPDATE HOADON SET MAHD=?,MADP=?, NGAYLAP=?, THANHTIEN=? Where MAHD=?";
        try(Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,maHoaDon);
            ps.setString(2, maDatPhong);
            ps.setString(3, ngayLap);
            ps.setInt(4, thanhTien);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public static int demSoHoaDon() {
        String sql = "SELECT COUNT(*) FROM HOADON";
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
    public static int tinhTongTienTatCaHoaDon() {
    String sql = "SELECT SUM(THANHTIEN) FROM HOADON";
    try (Connection conn = ConnectionUtils.getMyConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            return rs.getInt(1); // Tổng tiền
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Trường hợp lỗi hoặc không có hóa đơn
}

}
