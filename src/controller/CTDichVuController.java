/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CTDichVuDAO;
import dao.DichVuDAO;
import java.util.ArrayList;
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
    public int deleteCTDichVu(String maDatPhong,String maDichVu) {
        if (maDatPhong == null || maDatPhong.trim().isEmpty()) {
            return -1;
        }
    try {
            return CTdichvuModel.deleteCTDichVu(maDatPhong,maDichVu);
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
    public int tongTienDichVu(ArrayList<CTDichVu> ctDichVu,ArrayList<DichVu> dv,String maDatPhong) {
        int sum=0;
        for(CTDichVu ctdv :ctDichVu) {
            if(ctdv.getMaDatPhong()==maDatPhong) {
                sum+=ctdv.calculator(dv);
            }
        }
        return sum;
    }
}
