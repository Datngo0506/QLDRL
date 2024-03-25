/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;

/**
 *
 * @author Dat
 */
public class Lop {
    private List<SinhVien> dssv;
    private String tenLop, nienKhoa, nganh, maCoVan;

    public Lop(List<SinhVien> ds, String tenLop, String nienKhoa, String nganh, String maCoVan) {
        this.dssv = ds;
        this.tenLop = tenLop;
        this.nienKhoa = nienKhoa;
        this.nganh = nganh;
        this.maCoVan = maCoVan;
    }

    public Lop() {
    }

    public List<SinhVien> getDs() {
        return dssv;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public String getNganh() {
        return nganh;
    }

    public String getMaCoVan() {
        return maCoVan;
    }

    public void setDs(List<SinhVien> ds) {
        this.dssv = ds;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public void setMaCoVan(String maCoVan) {
        this.maCoVan = maCoVan;
    }
    
    
    
}
