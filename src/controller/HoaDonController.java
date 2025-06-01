/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CTDichVuDAO;
import dao.HoaDonDAO;
import java.util.ArrayList;
import model.HoaDon;
import model.KhachHang;

/**
 *
 * @author ASUS
 */
public class HoaDonController {
    private HoaDonDAO HoaDonModel;
    
    public HoaDonController(){
        HoaDonModel = new HoaDonDAO();
    }
     public boolean addHoaDonIntoModel(String maHoaDon,String maDatPhong, String ngayLap,int thanhTien){
        if(maHoaDon.trim().isEmpty() || maDatPhong.trim().isEmpty() || ngayLap.trim().isEmpty()){
            return false;
        }
        else{            
            //Trạng thái mặc định khi thêm khách hàng sẽ là "vắng mặt"
            int trangThai = 2;
            
            try{
                //Khi sử dụng truy xuất SQL thì nên sử dụng trong Try Catch.
                HoaDonModel.addHoaDon(maHoaDon,maDatPhong,ngayLap,thanhTien);
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
    }
    public int deleteHoaDon(String maHoaDon) {
        if (maHoaDon == null || maHoaDon.trim().isEmpty()) {
            return -1;
        }
    try {
            return HoaDonModel.deleteHoaDon(maHoaDon);
         } catch (Exception e) {
        // Bạn có thể log lỗi tại đây nếu cần
            return -1;
        }
    }
    
    public boolean updateHoaDonModel(String maHoaDon,String maDatPhong,String ngayLap,int thanhTien){
        if(maHoaDon.trim().isEmpty()){
            return false;
        }
        else{
            try{
                //Khi sử dụng truy xuất SQL thì nên sử dụng trong Try Catch.
                HoaDonModel.updateHoaDon(maHoaDon,maDatPhong,ngayLap,thanhTien);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }
    public Object[][] getHoaDonFromModel() {
        ArrayList<HoaDon> hoaDonList = HoaDonModel.getAllHoaDon();
        
        int columnNum = 3; //"Mã khách hàng","Họ và tên","Tên đăng nhập","Email","Trạng thái"
        int rowNum = hoaDonList.size();
        
        Object[][] hoaDonTableData = new Object[rowNum][columnNum];
        for(int i = 0 ; i<rowNum;i++){
            hoaDonTableData[i][0] = hoaDonList.get(i).getMaHoaDon();
            hoaDonTableData[i][1] = hoaDonList.get(i).getNgayLap();
            hoaDonTableData[i][2] = hoaDonList.get(i).getThanhTien();
         
        }
        return hoaDonTableData;
    }
}
