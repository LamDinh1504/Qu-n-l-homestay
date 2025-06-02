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
import model.CTDichVu;
import model.DichVu;
import model.NhanVien;

public class CTDichVuDAO {
    
    public static ArrayList<CTDichVu> getAllCTDichVu()   {
        ArrayList<CTDichVu> dsCTDichVu = new ArrayList<>();
        String query = "SELECT*FROM CTDV";
        try(Connection conn = ConnectionUtils.getMyConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                CTDichVu currentCTDichVu = new CTDichVu(
                    rs.getString("MADP"),
                    rs.getString("MADV"),
                    rs.getInt("SOLUONG")

                ) {
                };
    dsCTDichVu.add(currentCTDichVu);
}
            } catch (SQLException e) {
        System.err.println("Lỗi khi truy vấn dữ liệu dịch vụ: " + e.getMessage());
} catch (ClassNotFoundException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return dsCTDichVu;
    }
    public int addCTDichVu(String maDatPhong,String maDichVu,int soLuong) {
       int i=0;
        try(Connection con = ConnectionUtils.getMyConnection()) {
        
            String query="INSERT INTO CTDV VALUES(?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maDatPhong);
            ps.setString(2,maDichVu);
            ps.setInt(3,soLuong);
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public static int deleteCTDichVu(String maDatPhong){
        int i=0;
        try(Connection con=ConnectionUtils.getMyConnection()) {
            String query="DELETE FROM CTDV WHERE MADP= ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maDatPhong.trim());
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public void updateCTDichVu(String maDatPhong,String maDichVu, int soLuong){
        String query = "UPDATE CTDV SET MADP=?,MADV=?,SOLUONG=?,";
        try(Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,maDatPhong);
            ps.setString(2, maDichVu);
            ps.setInt(3,soLuong);

            ps.executeUpdate();
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public ArrayList<CTDichVu> getAllDichVu(String maDatPhong)   {
        ArrayList<CTDichVu> dsCTDichVu = new ArrayList<>();
        String query = "SELECT * FROM CTDV WHERE MADP=?";
        try(Connection conn = ConnectionUtils.getMyConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,maDatPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                CTDichVu currentCTDichVu = new CTDichVu(
                    rs.getString("MADP"),
                    rs.getString("MADV"),
                    rs.getInt("SOLUONG")
                );
    dsCTDichVu.add(currentCTDichVu);
}
            } catch (SQLException e) {
        System.err.println("Lỗi khi truy vấn dữ liệu nhân viên: " + e.getMessage());
} catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      return dsCTDichVu;
    }
    
}
