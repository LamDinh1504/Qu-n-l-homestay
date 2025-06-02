
package controller;

import dao.NhanVienDAO;
import java.util.ArrayList;
import model.NhanVien;

public class NhanVienController {
    private NhanVienDAO nhanVienModel;
    
    public NhanVienController(){
        nhanVienModel = new NhanVienDAO();
    }
    
    public Object[][] getNhanVienFromModel() {
        ArrayList<NhanVien> nhanVienList = nhanVienModel.getAllNhanVien();
        
        int columnNum = 7;
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
            int trangThai = 2;
            
            try{
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

