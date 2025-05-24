/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DatPhongDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import model.DatPhong;
import model.KhachHang;
import model.NhanVien;

/**
 *
 * @author ASUS
 */
public class PhongController {
    
    private KhachHangDAO khachHangModel;
    private DatPhongDAO datPhongModel;
    
    public PhongController(){
        khachHangModel = new KhachHangDAO();
        datPhongModel=new DatPhongDAO();
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
    
    public int deleteDatPhong(String maDatPhong) {
    if (maDatPhong == null || maDatPhong.trim().isEmpty()) {
        return -1;
    }
    try {
        return datPhongModel.deleteDatPhong(maDatPhong);
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}
    public boolean updateDatPhongModel(String maDatPhong, String maKhachHang, String maPhong,
                                   String ngayBatDau, String ngayTra, String trangThai) {
    if (maKhachHang.trim().isEmpty() || maPhong.trim().isEmpty() ||
        ngayBatDau.trim().isEmpty() || ngayTra.trim().isEmpty() || trangThai.trim().isEmpty()) {
        return false;
    } else {
        try {
            datPhongModel.updateDatPhong(maDatPhong, maKhachHang, maPhong, ngayBatDau, ngayTra, trangThai);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
     public DatPhong getDatPhong(String maDatPhong){
        DatPhong datPhong = new DatPhong();
        try{
            datPhong = datPhongModel.getDatPhong(maDatPhong);
            return datPhong;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }   
}
