/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
import java.util.ArrayList;
import java.util.List;
import model.DatPhong;
import model.KhachHang;

/**
 *
 * @author ASUS
 */
public class KhachHangController {
    private KhachHangDAO khachHangModel;
    
    public KhachHangController(){
        khachHangModel = new KhachHangDAO();
    }
    
    public Object[][] getKhachHangFromModel() {
        ArrayList<KhachHang> khachHangList = khachHangModel.getAllKhachHang();
        
        int columnNum = 7; //"Mã khách hàng","Họ và tên","Tên đăng nhập","Email","Trạng thái"
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
//        PhongController phongModel=new PhongController();
//        CTDichVuController ctDichVuModel=new CTDichVuController();
//        DatPhong dp=phongModel.getDatPhong(maKhachHang);
//        ctDichVuModel.deleteCTDichVu(dp.getMaDatPhong());
//        phongModel.deleteDatPhong(maKhachHang);
//        
//        if (maKhachHang == null || maKhachHang.trim().isEmpty()) {
//            return -1;
//        }
//        try {
//            return khachHangModel.deleteKhachHang(maKhachHang);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return -1;
//        }
        if (maKhachHang == null || maKhachHang.trim().isEmpty()) {
        return -1;
    }

    try {
        PhongController phongModel = new PhongController();
        CTDichVuController ctDichVuModel = new CTDichVuController();

        // Lấy danh sách tất cả các đơn đặt phòng của khách hàng này
        DatPhong listDP = phongModel.getDatPhong(maKhachHang);
            ctDichVuModel.deleteCTDichVu(listDP.getMaDatPhong()); // Xóa chi tiết dịch vụ
            phongModel.deleteDatPhong(listDP.getMaKhachHang());    // Xóa đặt phòng

        // Cuối cùng xóa khách hàng
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
