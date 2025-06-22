
package controller;

import dao.KhachHangDAO;
import java.util.ArrayList;
import model.DatPhong;
import model.KhachHang;


public class KhachHangController {
    private KhachHangDAO khachHangModel;
    
    public KhachHangController(){
        khachHangModel = new KhachHangDAO();
    }
    
    public Object[][] getKhachHangFromModel() {
        ArrayList<KhachHang> khachHangList = khachHangModel.getAllKhachHang();
        
        int columnNum = 7; 
        int rowNum = khachHangList.size();
        
        Object[][] khachHangTableData = new Object[rowNum][columnNum];
        for(int i = 0 ; i<rowNum;i++){
            khachHangTableData[i][0] = khachHangList.get(i).getMaKhachHang();
            khachHangTableData[i][1] = khachHangList.get(i).getHoTen();
            khachHangTableData[i][2] = khachHangList.get(i).getSoDienThoai();
            khachHangTableData[i][3] = khachHangList.get(i).getCmnd();
            khachHangTableData[i][4] = khachHangList.get(i).getEmail();
            khachHangTableData[i][5] = khachHangList.get(i).getDiaChi();
            khachHangTableData[i][6] = khachHangList.get(i).getGioiTinh();
        }
        return khachHangTableData;
    }
    
    public boolean addKhachHangIntoModel(String maKhachHang, String hoTen, String gioiTinh,
                                         String soDienThoai, String diaChi, String email, String cmnd) {
        if (maKhachHang.trim().isEmpty() || hoTen.trim().isEmpty() || gioiTinh.trim().isEmpty()
                || soDienThoai.trim().isEmpty() || diaChi.trim().isEmpty()
                || email.trim().isEmpty() || cmnd.trim().isEmpty()) {
            return false;
        } else {
            try {
                khachHangModel.addKhachHang(maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi, email, cmnd);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public int deleteKhachHang(String maKhachHang) {

        if (maKhachHang == null || maKhachHang.trim().isEmpty()) {
        return -1;
    }

    try {
        PhongController phongModel = new PhongController();
        CTDichVuController ctDichVuModel = new CTDichVuController();
        HoaDonController hoaDonModel=new HoaDonController();

        DatPhong dp = phongModel.getDatPhong(maKhachHang);
        String maDP = dp.getMaDatPhong();

        ctDichVuModel.deleteCTDichVu(maDP); // 1. Xóa dịch vụ
        String maHD = hoaDonModel.getMaHoaDonByMaDatPhong(maDP); // 2. Lấy mã hóa đơn
        hoaDonModel.deleteHoaDon(maHD); // 3. Xóa hóa đơn
        phongModel.deleteDatPhong(maDP); // 4. Cuối cùng xóa đặt phòng

        return khachHangModel.deleteKhachHang(maKhachHang);

    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
    }

    public boolean updateKhachHangModel(String maKhachHang, String hoTen, String gioiTinh,
                                        String soDienThoai, String diaChi, String email, String cmnd) {
        if (hoTen.trim().isEmpty() || gioiTinh.trim().isEmpty() || soDienThoai.trim().isEmpty()
                || diaChi.trim().isEmpty() || email.trim().isEmpty() || cmnd.trim().isEmpty()) {
            return false;
        } else {
            try {
                khachHangModel.updateKhachHang(maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi, email, cmnd);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public KhachHang getKhachHang(String maKhachHang) {
        try {
            return khachHangModel.getKhachHang(maKhachHang);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
