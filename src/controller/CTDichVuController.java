/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CTDichVuDAO;
import dao.DichVuDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.CTDichVu;
import model.DichVu;

/**
 *
 * @author ASUS
 */
public class CTDichVuController {
    private CTDichVuDAO CTdichvuModel;
    private DichVuDAO dichvuModel;
    
    public CTDichVuController(){
        CTdichvuModel = new CTDichVuDAO();
        dichvuModel =new DichVuDAO();
    }

    
    
    public ArrayList<DichVu> getAllDichVu() {
        return dichvuModel.getAllDichVu();
    } 
     public ArrayList<CTDichVu> getAllCTDichVu() {
        return CTdichvuModel.getAllCTDichVu();
    } 
     public boolean addCTDichVuIntoModel(String maDatPhong,String maDichVu,int soLuong){
        if(maDatPhong.trim().isEmpty() || maDichVu.trim().isEmpty()){
            return false;
        }
        else{            
            //Trạng thái mặc định khi thêm khách hàng sẽ là "vắng mặt"
            int trangThai = 2;
            
            try{
                //Khi sử dụng truy xuất SQL thì nên sử dụng trong Try Catch.
                CTdichvuModel.addCTDichVu(maDatPhong,maDichVu,soLuong);
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
    }
    public int deleteCTDichVu(String maDatPhong) {
        if (maDatPhong == null || maDatPhong.trim().isEmpty()) {
            return -1;
        }
    try {
            return CTdichvuModel.deleteCTDichVu(maDatPhong);
         } catch (Exception e) {
            return -1;
        }
    }
    
    public boolean updateDichVuModel(String maDatPhong,String maDichVu,int soLuong){
        if(maDatPhong.trim().isEmpty() || maDichVu.trim().isEmpty()){
            return false;
        }
        else{
            try{
                CTdichvuModel.updateCTDichVu(maDatPhong,maDichVu,soLuong);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }
    public int tongTienDichVu(ArrayList<DichVu> dsDichVu, String maDatPhong) {
        int tong = 0;
        ArrayList<CTDichVu> dsCTDichVu = CTdichvuModel.getAllDichVu(maDatPhong); // Lấy danh sách CTDV từ DB

        for (CTDichVu ctdv : dsCTDichVu) {
            tong += ctdv.calculator(dsDichVu); // Tính tiền từng dịch vụ
        }

        return tong;
    }
    
    public JTable createCTDichVuTable(String maDatPhong) {
        String[] columnNames = {"Tên dịch vụ", "Đơn giá", "Số lượng"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        ArrayList<CTDichVu> dsCTDichVu = CTdichvuModel.getAllDichVu(maDatPhong);
        ArrayList<DichVu> dsDichVu = dichvuModel.getAllDichVu();

        for (CTDichVu ct : dsCTDichVu) {
            String tenDichVu = "";
            int donGia = 0;

            for (DichVu dv : dsDichVu) {
                if (dv.getMaDichVu().equals(ct.getMaDichVu())) {
                    tenDichVu = dv.getTenDichVu();
                    donGia = dv.getDonGia();
                    break;
                }
            }

            Object[] rowData = {tenDichVu, donGia, ct.getSoLuong()};
            model.addRow(rowData);
        }

        return new JTable(model);
    }
}
