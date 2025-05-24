/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CTDichVu {
    private String maDatPhong;
    private String maDichVu;
    private int soLuong;

    public CTDichVu(String maDatPhong, String maDichVu, int soLuong) {
        this.maDatPhong = maDatPhong;
        this.maDichVu = maDichVu;
        this.soLuong = soLuong;
    }

    public CTDichVu() {
    }

    public String getMaDatPhong() {
        return maDatPhong;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaDatPhong(String maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public int calculator(ArrayList<DichVu> dv) {
        for(DichVu x : dv) {
            if(this.maDichVu==x.getMaDichVu()) {
                return this.soLuong*x.donGia;
            }
        }
        return 0;
    }
}
