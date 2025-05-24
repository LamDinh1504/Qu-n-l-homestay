/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public  abstract class DichVu {
    protected String maDichVu;
    protected String tenDichVu;
    protected int donGia;
    protected String donViTinh;

    public DichVu() {
    }

    public DichVu(String maDichVu, String tenDichVu, int donGia, String donViTinh) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public int getDonGia() {
        return donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
}

