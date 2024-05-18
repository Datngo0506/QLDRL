/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class HocKy {
    private String MaHK_NK, HocKy, NienKhoa;
    private boolean xet;

    public void setXet(boolean xet) {
        this.xet = xet;
    }

    public boolean getXet() {
        return xet;
    }

    public HocKy(String MaHK_NK, String HocKy, String NienKhoa, boolean xet) {
        this.MaHK_NK = MaHK_NK;
        this.HocKy = HocKy;
        this.NienKhoa = NienKhoa;
        this.xet = xet;
    }
    

    public HocKy(String MaHK_NK, String HocKy, String NienKhoa) {
        this.MaHK_NK = MaHK_NK;
        this.HocKy = HocKy;
        this.NienKhoa = NienKhoa;
    }

    public HocKy() {
    }

    public String getMaHK_NK() {
        return MaHK_NK;
    }

    public String getHocKy() {
        return HocKy;
    }

    public String getNienKhoa() {
        return NienKhoa;
    }

    public void setMaHK_NK(String MaHK_NK) {
        this.MaHK_NK = MaHK_NK;
    }

    public void setHocKy(String HocKy) {
        this.HocKy = HocKy;
    }

    public void setNienKhoa(String NienKhoa) {
        this.NienKhoa = NienKhoa;
    }
    
}
