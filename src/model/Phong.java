/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Phong {
    private String maPhong;
    private String kieuPhong;
    private String trangThai;
    private int tang;
    private String maLoai;

    public Phong() {
    }

    public Phong(String maPhong, String kieuPhong, String trangThai, int tang, String maLoai) {
        this.maPhong = maPhong;
        this.kieuPhong = kieuPhong;
        this.trangThai = trangThai;
        this.tang = tang;
        this.maLoai = maLoai;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getKieuPhong() {
        return kieuPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public int getTang() {
        return tang;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setKieuPhong(String kieuPhong) {
        this.kieuPhong = kieuPhong;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    
}
