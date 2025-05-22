/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class HoaDon {
    private String maHoaDon;
    private String maDatPhong;
    private String maNhanVien;
    private String ngayLap;
    private int thanhTien;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String maDatPhong, String maNhanVien, String ngayLap, int thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maDatPhong = maDatPhong;
        this.maNhanVien = maNhanVien;
        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getMaDatPhong() {
        return maDatPhong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaDatPhong(String maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
