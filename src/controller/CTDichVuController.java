/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CTDichVuDAO;
import dao.DichVuDAO;

/**
 *
 * @author ASUS
 */
public class CTDichVuController {
    private CTDichVuDAO CTdichvuModel;
    
    public CTDichVuController(){
        CTdichvuModel = new CTDichVuDAO();
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
    public int deleteCTDichVu(String maDatPhong,String maDichVu) {
        if (maDatPhong == null || maDatPhong.trim().isEmpty()) {
            return -1;
        }
    try {
            return CTdichvuModel.deleteCTDichVu(maDatPhong,maDichVu);
         } catch (Exception e) {
        // Bạn có thể log lỗi tại đây nếu cần
            return -1;
        }
    }
    
    public boolean updateDichVuModel(String maDatPhong,String maDichVu,int soLuong){
        if(maDatPhong.trim().isEmpty() || maDichVu.trim().isEmpty()){
            return false;
        }
        else{
            try{
                //Khi sử dụng truy xuất SQL thì nên sử dụng trong Try Catch.
                CTdichvuModel.updateCTDichVu(maDatPhong,maDichVu,soLuong);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }
}
