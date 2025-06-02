/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DichVuDAO;

import java.util.ArrayList;
import model.DichVu;


/**
 *
 * @author ASUS
 */
public class DichVuController {
    private DichVuDAO dichvuModel;
    
    public DichVuController(){
        dichvuModel = new DichVuDAO();
    }

    public Object[][] getDichVuFromModel() {
        ArrayList<DichVu> dichVuList = dichvuModel.getAllDichVu();
        
        int columnNum = 4; //"Mã khách hàng","Họ và tên","Tên đăng nhập","Email","Trạng thái"
        int rowNum = dichVuList.size();
        
        Object[][] dichVuTableData = new Object[rowNum][columnNum];
        for(int i = 0 ; i<rowNum;i++){
            dichVuTableData[i][0] = dichVuList.get(i).getMaDichVu();
            dichVuTableData[i][1] = dichVuList.get(i).getTenDichVu();
            dichVuTableData[i][2] = dichVuList.get(i).getDonGia();
            dichVuTableData[i][3] = dichVuList.get(i).getDonViTinh();

        }
        return dichVuTableData;
    }
    
    public boolean addDichVuIntoModel(String maDichVu,String tenDichVu, int donGia, String donViTinh){
        if(maDichVu.trim().isEmpty() || tenDichVu.trim().isEmpty() || donViTinh.trim().isEmpty()){
            return false;
        }
        else{            
            //Trạng thái mặc định khi thêm khách hàng sẽ là "vắng mặt"
            int trangThai = 2;
            
            try{
                //Khi sử dụng truy xuất SQL thì nên sử dụng trong Try Catch.
                dichvuModel.addDichVu(maDichVu,tenDichVu,donGia,donViTinh);
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
    }
    public int deleteDichVu(String maDichVu) {
        if (maDichVu == null || maDichVu.trim().isEmpty()) {
            return -1;
        }
    try {
            return dichvuModel.deleteDichVu(maDichVu);
         } catch (Exception e) {
        // Bạn có thể log lỗi tại đây nếu cần
            return -1;
        }
    }
    
    public boolean updateDichVuModel(String maDichVu, String tenDichVu,int donGia,String donViTinh){
        if(maDichVu.trim().isEmpty() || tenDichVu.trim().isEmpty() || donViTinh.trim().isEmpty()){
            return false;
        }
        else{
            try{
                //Khi sử dụng truy xuất SQL thì nên sử dụng trong Try Catch.
                dichvuModel.updateDichVu(maDichVu, tenDichVu, donGia, donViTinh);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }
}
