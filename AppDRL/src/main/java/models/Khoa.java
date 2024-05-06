/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class Khoa {
    private String maKhoa, tenKhoa, ngayThanhLap, mk;

    public Khoa() {
    }


    public Khoa(String maKhoa, String tenKhoa, String ngayThanhLap, String mk) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.ngayThanhLap = ngayThanhLap;
        this.mk = mk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    
    
    public String getMaKhoa() {
        return maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public String getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public void setNgayThanhLap(String ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }
    
    
    
}
