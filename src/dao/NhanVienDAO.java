 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

//import ConnectDB.Connection;
import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;

/**
 *
 * @author ASUS
 */
public class NhanVienDAO {
    public ArrayList<NhanVien> getAllNhanVien()   {
        ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
        String query = "SELECT * FROM NHANVIEN";
        try(Connection conn = ConnectionUtils.getMyConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                NhanVien currentNhanVien = new NhanVien(
                    rs.getString("MANHANVIEN"),
                    rs.getString("HOTEN"),
                    rs.getString("GIOITINH"),
                    rs.getString("SODIENTHOAI"),
                    rs.getString("DIACHI"),
                    rs.getString("EMAIL"),
                    rs.getString("CHUCVU")
                );
    dsNhanVien.add(currentNhanVien);
}
            } catch (SQLException e) {
        System.err.println("Lỗi khi truy vấn dữ liệu nhân viên: " + e.getMessage());
} catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      return dsNhanVien;
    }
    
    
    public int addNhanVien(String maNhanVien,String hoTen,String gioiTinh,String soDienThoai,String diaChi,String email,String chucVu) {
       int i=0;
        try(Connection con = ConnectionUtils.getMyConnection()) {
        
            String query="INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maNhanVien);
            ps.setString(2,hoTen);
            ps.setString(3,gioiTinh);
            ps.setString(4,soDienThoai);
            ps.setString(5,diaChi);
            ps.setString(6,email);
            ps.setString(7,chucVu);
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public static int deleteNhanVien(String maKhachHang){
        int i=0;
        try(Connection con=ConnectionUtils.getMyConnection()) {
            String query="DELETE FROM NHANVIEN WHERE MANHANVIEN= ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maKhachHang.trim());
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public void updateNhanVien(String maNhanVien,String hoTen, String gioiTinh, String soDienThoai, String diaChi, String email,String chucVu){
        String query = "UPDATE NHANVIEN SET HOTEN=?,GIOITINH=?,SODIENTHOAI=?, DIACHI=?, EMAIL=?, CHUCVU=? Where MANHANVIEN=?";
        try(Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,hoTen);
            ps.setString(2, gioiTinh);
            ps.setString(3,soDienThoai);
            ps.setString(4, diaChi);
            ps.setString(5, email);
            ps.setString(6,chucVu);
            ps.setString(7, maNhanVien);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    public static NhanVien getNhanVien(String maNhanVien){
        String query = "SELECT * FROM NHANVIEN WHERE MANHANVIEN = ?";
        try(Connection conn = ConnectionUtils.getMyConnection()) {
             PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, maNhanVien);
            ResultSet rs = ps.executeQuery();
            NhanVien currentNhanVien = new NhanVien();
            while(rs.next()){
                currentNhanVien = new NhanVien(
                        rs.getString("MANHANVIEN"),
                        rs.getString("HOTEN"),
                        rs.getString("GIOITINH"),
                        rs.getString("SODIENTHOAI"),
                        rs.getString("DIACHI"),
                        rs.getString("Email"),
                        rs.getString("CHUCVU")
                );
            }
            return currentNhanVien;
        }
        catch(Exception e){
            System.out.print(e);
            return null;
        }
    }
    
    public static int demSoNhanVien() {
        String sql = "SELECT COUNT(*) FROM NHANVIEN";
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
