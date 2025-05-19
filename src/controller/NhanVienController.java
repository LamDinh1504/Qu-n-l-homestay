/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.NhanVienDAO;
import java.util.ArrayList;
import model.NhanVien;

/**
 *
 * @author ASUS
 */
public class NhanVienController {
    private NhanVienDAO nhanVienModel;
    
    public NhanVienController(){
        nhanVienModel = new NhanVienDAO();
    }
    
    public Object[][] getNhanVienFromModel() {
        ArrayList<NhanVien> nhanVienList = nhanVienModel.getAllNhanVien();
        
        int columnNum = 7; //"Mã khách hàng","Họ và tên","Tên đăng nhập","Email","Trạng thái"
        int rowNum = nhanVienList.size();
        
        Object[][] khachHangTableData = new Object[rowNum][columnNum];
        for(int i = 0 ; i<rowNum;i++){
            khachHangTableData[i][0] = nhanVienList.get(i).getMaNhanVien();
            khachHangTableData[i][1] = nhanVienList.get(i).getHoTen();
            khachHangTableData[i][2] = nhanVienList.get(i).getGioiTinh();
            khachHangTableData[i][3] = nhanVienList.get(i).getSoDienThoai();
            khachHangTableData[i][4] = nhanVienList.get(i).getDiaChi();
            khachHangTableData[i][5] = nhanVienList.get(i).getEmail();
            khachHangTableData[i][6] = nhanVienList.get(i).getChucVu();
        }
        return khachHangTableData;
    }
    
    public boolean addNhanVienIntoModel(String maNhanVien,String hoTen, String gioiTinh, String soDienThoai,String diaChi,String email,String chucVu){
        if(maNhanVien.trim().isEmpty() || hoTen.trim().isEmpty() || gioiTinh.trim().isEmpty() || soDienThoai.trim().isEmpty() 
                || diaChi.trim().isEmpty() || email.trim().isEmpty() || chucVu.trim().isEmpty()){
            return false;
        }
        else{            
            //Trạng thái mặc định khi thêm khách hàng sẽ là "vắng mặt"
            int trangThai = 2;
            
            try{
                //Khi sử dụng truy xuất SQL thì nên sử dụng trong Try Catch.
                nhanVienModel.addNhanVien(maNhanVien,hoTen, gioiTinh, soDienThoai, diaChi, email,chucVu);
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
    }
    public int deleteNhanVien(String maNhanVien) {
        if (maNhanVien == null || maNhanVien.trim().isEmpty()) {
            return -1;
        }
    try {
            return nhanVienModel.deleteNhanVien(maNhanVien);
         } catch (Exception e) {
        // Bạn có thể log lỗi tại đây nếu cần
            return -1;
        }
    }
    
    public boolean updateNhanVienModel(String maNhanVien, String hoTen, String gioiTinh, String soDienThoai,String diaChi, String email,String chucVu){
        if(hoTen.trim().isEmpty() || gioiTinh.trim().isEmpty() || soDienThoai.trim().isEmpty() 
                || diaChi.trim().isEmpty() || email.trim().isEmpty() || chucVu.trim().isEmpty()){
            return false;
        }
        else{
            try{
                //Khi sử dụng truy xuất SQL thì nên sử dụng trong Try Catch.
                nhanVienModel.updateNhanVien(maNhanVien, hoTen, gioiTinh, soDienThoai, diaChi,email,chucVu);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }
    
    public NhanVien getNhanVien(String maNhanVien){
        NhanVien nhanVien = new NhanVien();
        try{
            nhanVien = nhanVienModel.getNhanVien(maNhanVien);
            return nhanVien;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }   
}

