
package controller;

import dao.HoaDonDAO;
import java.util.ArrayList;
import model.HoaDon;

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
            int trangThai = 2;
            
            try{
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
            hoaDonTableData[i][1] = hoaDonList.get(i).getNgayLap().substring(0, 10);
            hoaDonTableData[i][2] = hoaDonList.get(i).getThanhTien();
         
        }
        return hoaDonTableData;
    }
    
    public int getTongTienTatCaHoaDon() {
    try {
        return HoaDonDAO.tinhTongTienTatCaHoaDon();
    } catch (Exception e) {
        e.printStackTrace();
        return 0; 
    }
}

    public String getMaHoaDonByMaDatPhong(String maDatPhong) {
        if (maDatPhong == null || maDatPhong.trim().isEmpty()) {
            return null;
        }

        try {
            return HoaDonModel.getMaHoaDonByMaDatPhong(maDatPhong);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
