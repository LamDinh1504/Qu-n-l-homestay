/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class DatPhong {
    private String maDatPhong;
    private String maKhachHang;
    private String maPhong;
    private String ngayBatDau;
    private String ngayTra;
    private String trangThai;

    public DatPhong(String maDatPhong, String maKhachHang, String maPhong, String ngayBatDau, String ngayTra, String trangThai) {
        this.maDatPhong = maDatPhong;
        this.maKhachHang = maKhachHang;
        this.maPhong = maPhong;
        this.ngayBatDau = ngayBatDau;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public DatPhong() {
    }

    public String getMaDatPhong() {
        return maDatPhong;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setMaDatPhong(String maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public int soNgayO() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Parse chuỗi thành LocalDate
            LocalDate date1 = LocalDate.parse(ngayBatDau, formatter);
            LocalDate date2 = LocalDate.parse(ngayTra, formatter);

        if (date1.isAfter(date2)) {
            return 0; // hoặc throw new IllegalArgumentException("Ngày bắt đầu lớn hơn ngày trả");
        }

    return (int) ChronoUnit.DAYS.between(date1, date2);
    }
}
