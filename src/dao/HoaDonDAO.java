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
                    rs.getString("MANHANVIEN"),
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
    
    
    public int addHoaDon(String maHoaDon,String maDatPhong,String maNhanVien,String ngayLap,int thanhTien) {
       int i=0;
        try(Connection con = ConnectionUtils.getMyConnection()) {
        
            String query="INSERT INTO HOADON VALUES(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maHoaDon);
            ps.setString(2,maDatPhong);
            ps.setString(3,maNhanVien);
            ps.setString(4,ngayLap);
            ps.setInt(5,thanhTien);
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
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
    public void updateHoaDon(String maHoaDon,String maDatPhong, String maNhanVien, String ngayLap, int soLuong){
        String query = "UPDATE HOADON SET MAHD=?,MADP=?,MANHANVIEN=?, NGAYLAP=?, SOLUONG=? Where MAHD=?";
        try(Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,maHoaDon);
            ps.setString(2, maDatPhong);
            ps.setString(3,maNhanVien);
            ps.setString(4, ngayLap);
            ps.setInt(5, soLuong);

            ps.executeUpdate();
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
