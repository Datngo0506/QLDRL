/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class BanCanSu {
    private String ten, lop, msv, khoa, chucVu;

    public BanCanSu() {
    }

    public BanCanSu(String ten, String lop, String msv, String khoa, String chucVu) {
        this.ten = ten;
        this.lop = lop;
        this.msv = msv;
        this.khoa = khoa;
        this.chucVu = chucVu;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public String getMsv() {
        return msv;
    }

    public String getKhoa() {
        return khoa;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    
    
}
