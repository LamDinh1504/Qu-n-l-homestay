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
import model.DichVu;
import model.NhanVien;

/**
 *
 * @author ASUS
 */
public class DichVuDAO {
    public static ArrayList<DichVu> getAllDichVu()   {
        ArrayList<DichVu> dsDichVu = new ArrayList<>();
        String query = "SELECT*FROM DICHVU";
        try(Connection conn = ConnectionUtils.getMyConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DichVu currentDichVu = new DichVu(
                    rs.getString("MADV"),
                    rs.getString("TENDV"),
                    rs.getInt("DONGIA"),
                    rs.getString("DONVITINH")
                ) {
                };
    dsDichVu.add(currentDichVu);
}
            } catch (SQLException e) {
        System.err.println("Lỗi khi truy vấn dữ liệu dịch vụ: " + e.getMessage());
} catch (ClassNotFoundException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return dsDichVu;
    }
    
    
    public int addDichVu(String maDichVu,String tenDichVu,int donGia,String donViTinh) {
       int i=0;
        try(Connection con = ConnectionUtils.getMyConnection()) {
        
            String query="INSERT INTO DICHVU VALUES(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maDichVu);
            ps.setString(2,tenDichVu);
            ps.setInt(3,donGia);
            ps.setString(4,donViTinh);
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public static int deleteDichVu(String maDichVu){
        int i=0;
        try(Connection con=ConnectionUtils.getMyConnection()) {
            String query="DELETE FROM DICHVU WHERE MADV= ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maDichVu.trim());
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public void updateDichVu(String maDichVu,String tenDichVu, int donGia, String donViTinh){
        String query = "UPDATE DICHVU SET MADV=?,TENDV=?,DONGIA=?, DONVITINH=?";
        try(Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,maDichVu);
            ps.setString(2, tenDichVu);
            ps.setDouble(3,donGia);
            ps.setString(4, donViTinh);

            ps.executeUpdate();
        }catch(Exception e){
            System.out.print(e);
        }
    }
     public static DichVu getDichVu(String maDichVu){
        String query = "SELECT * FROM DICHVU WHERE MADV = ?";
        try(Connection conn = ConnectionUtils.getMyConnection()) {
             PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, maDichVu);
            ResultSet rs = ps.executeQuery();
            DichVu currentDichVu = new DichVu() {};
            while(rs.next()){
                currentDichVu = new DichVu(
                        rs.getString("MADV"),
                        rs.getString("TENDV"),
                        rs.getInt("DONGIA"),
                        rs.getString("DONVITINH")
                ) {} 
                ;}
            return currentDichVu;
        }
        catch(Exception e){
            System.out.print(e);
            return null;
        }
    }
     public static DichVu getDichVuByTen(String tenDichVu) {
    ArrayList<DichVu> danhSach = getAllDichVu();
    for (DichVu dv : danhSach) {
        if (dv.getTenDichVu().equals(tenDichVu)) {
            return dv;
        }
    }
    return null;
}
     
}
