/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class DRL {
    private String MSSV, maHK;
    private int diem1, diem2, diem3;
    private boolean trangThai;

    public DRL() {
    }

    public DRL(String MSSV, String maHK, int diem1, int diem2, int diem3, boolean trangThai) {
        this.MSSV = MSSV;
        this.maHK = maHK;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.trangThai = trangThai;
    }

    public String getMSSV() {
        return MSSV;
    }

    public String getMaHK() {
        return maHK;
    }

    public int getDiem1() {
        return diem1;
    }

    public int getDiem2() {
        return diem2;
    }

    public int getDiem3() {
        return diem3;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setMaHK(String maHK) {
        this.maHK = maHK;
    }

    public void setDiem1(int diem1) {
        this.diem1 = diem1;
    }

    public void setDiem2(int diem2) {
        this.diem2 = diem2;
    }

    public void setDiem3(int diem3) {
        this.diem3 = diem3;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
