/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class LoaiPhong {
    private String maLoai;
    private String tenLoai;
    private int giaCoBan;
    private String moTa;

    public LoaiPhong() {
    }

    public LoaiPhong(String maLoai, String tenLoai, int giaCoBan, String moTa) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.giaCoBan = giaCoBan;
        this.moTa = moTa;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public int getGiaCoBan() {
        return giaCoBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public void setGiaCoBan(int giaCoBan) {
        this.giaCoBan = giaCoBan;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}
