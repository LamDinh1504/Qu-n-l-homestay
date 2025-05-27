/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DatPhongDAO;
import dao.KhachHangDAO;
import dao.LoaiPhongDAO;
import dao.NhanVienDAO;
import dao.PhongDAO;
import java.util.ArrayList;
import model.DatPhong;
import model.KhachHang;
import model.LoaiPhong;
import model.NhanVien;
import model.Phong;

/**
 *
 * @author ASUS
 */
public class PhongController {
    
    private KhachHangDAO khachHangModel;
    private DatPhongDAO datPhongModel;
    private PhongDAO phongModel;
    private LoaiPhongDAO loaiPhongModel;
    
    public PhongController(){
        khachHangModel = new KhachHangDAO();
        datPhongModel=new DatPhongDAO();
    }
    
    public int soNgayO(String maDatPhong) {
        ArrayList<DatPhong> dh=datPhongModel.getAllDatPhong();
        for(DatPhong x : dh) {
            if(x.getMaDatPhong().equals(maDatPhong)) {
                return x.soNgayO();
            }
        }
        return 0;
    }
    
    public int tongTienPhong(DatPhong datPhong) {
        Phong phong = phongModel.getPhong(datPhong.getMaPhong());
        if (phong == null) return 0;

        LoaiPhong loai = loaiPhongModel.getLoaiPhong(phong.getMaLoai());
        if (loai == null) return 0;

        return loai.getGiaCoBan() * datPhong.soNgayO();
        }
    
    public boolean addKhachHangIntoModel(String maKhachHang, String hoTen, String soDienThoai, String cmnd, String email,String diaChi,String gioiTinh) {
        if (maKhachHang.trim().isEmpty() || hoTen.trim().isEmpty() || soDienThoai.trim().isEmpty() || 
            cmnd.trim().isEmpty() || email.trim().isEmpty() || diaChi.trim().isEmpty() || gioiTinh.trim().isEmpty()) {
            return false;
        } else {
            try {
                khachHangModel.addKhachHang(maKhachHang, hoTen, soDienThoai, cmnd,email, diaChi, gioiTinh);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    // Xoá khách hàng
    public int deleteKhachHang(String maKhachHang) {
        if (maKhachHang == null || maKhachHang.trim().isEmpty()) {
            return -1;
        }
        try {
            return khachHangModel.deleteKhachHang(maKhachHang);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Cập nhật khách hàng
    public boolean updateKhachHangModel(String maKhachHang, String hoTen, String gioiTinh, String soDienThoai,String cmnd,String diaChi, String email) {
        if (hoTen.trim().isEmpty() || gioiTinh.trim().isEmpty() || soDienThoai.trim().isEmpty() ||
            diaChi.trim().isEmpty() || email.trim().isEmpty()) {
            return false;
        } else {
            try {
                khachHangModel.updateKhachHang(maKhachHang, hoTen, soDienThoai, cmnd,email, diaChi, gioiTinh);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    // Lấy thông tin khách hàng theo mã
    public KhachHang getKhachHang(String maKhachHang) {
        try {
            return khachHangModel.getKhachHang(maKhachHang);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean addDatPhongIntoModel(String maDatPhong, String maKhachHang, String maPhong,
                                    String ngayBatDau, String ngayTra, String trangThai) {
    if (maDatPhong.trim().isEmpty() || maKhachHang.trim().isEmpty() || maPhong.trim().isEmpty() ||
        ngayBatDau.trim().isEmpty() || ngayTra.trim().isEmpty() || trangThai.trim().isEmpty()) {
        return false;
    } else {
        try {
            datPhongModel.addDatPhong(maDatPhong, maKhachHang, maPhong, ngayBatDau, ngayTra, trangThai);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    }
    
    public int deleteDatPhong(String maKhachHang) {
    if (maKhachHang == null || maKhachHang.trim().isEmpty()) {
        return -1;
    }
    try {
        return datPhongModel.deleteDatPhong(maKhachHang);
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}
    public boolean updateDatPhongModel(String maDatPhong, String trangThai) {
    if (trangThai.trim().isEmpty()) {
        return false;
    } else {
        try {
            datPhongModel.updateDatPhong(maDatPhong,trangThai);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
     public DatPhong getDatPhong(String maKhachHang){
        DatPhong datPhong = new DatPhong();
        try{
            datPhong = datPhongModel.getDatPhong(maKhachHang);
            return datPhong;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    } 
    
    public boolean check(String maPhong) {
        ArrayList<DatPhong> dp=datPhongModel.getAllDatPhong();
        for(DatPhong x:dp) {
            if(x.getMaPhong().equals(maPhong)&&x.getTrangThai().equals("Đang sử dụng")) {
                return true;
            }
        }
        return false;
    }
    
    public DatPhong getPhongDangSuDung(String maPhong) {
        ArrayList<DatPhong> dp=datPhongModel.getAllDatPhong();
        for(DatPhong x : dp) {
            if(x.getMaPhong().equals(maPhong)&&x.getTrangThai().equals("Đang sử dụng")) {
                return x;
            }
        }
        return null;
    }
}
