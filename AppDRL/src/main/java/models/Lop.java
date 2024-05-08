/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class Lop {
    private String Lop, maKhoa, maCoVan, maKhoaHoc;

    public Lop(String Lop, String maKhoa, String maCoVan, String maKhoaHoc) {
        this.Lop = Lop;
        this.maKhoa = maKhoa;
        this.maCoVan = maCoVan;
        this.maKhoaHoc = maKhoaHoc;
    }

    public Lop() {
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setMaCoVan(String maCoVan) {
        this.maCoVan = maCoVan;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getLop() {
        return Lop;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public String getMaCoVan() {
        return maCoVan;
    }

    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }
    
    
    
}
