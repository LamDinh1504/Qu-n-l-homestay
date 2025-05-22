/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ASUS
 */
public class CTDichVuDAO {
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
    public static int deleteCTDichVu(String maDatPhong,String maDichVu){
        int i=0;
        try(Connection con=ConnectionUtils.getMyConnection()) {
            String query="DELETE FROM DICHVU WHERE MADP= ? AND MADV= ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,maDatPhong.trim());
            ps.setString(2,maDichVu.trim());
            i=ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public void updateCTDichVu(String maDatPhong,String maDichVu, int soLuong){
        String query = "UPDATE DICHVU SET MADP=?,MADV=?,SOLUONG=?,";
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
}
