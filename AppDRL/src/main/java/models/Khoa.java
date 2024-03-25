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
public class Khoa {
    private String maKhoa, tenKhoa, ngayThanhLap;
    private List <Lop> dsLop;
    private List <CoVan> dsCoVan;
    private List <BanCanSu> dsCanSu;

    public Khoa(String maKhoa, String tenKhoa, String ngayThanhLap, List<Lop> dsLop, List<CoVan> dsCoVan, List<BanCanSu> dsCanSu) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.ngayThanhLap = ngayThanhLap;
        this.dsLop = dsLop;
        this.dsCoVan = dsCoVan;
        this.dsCanSu = dsCanSu;
    }

    public void setDsCanSu(List<BanCanSu> dsCanSu) {
        this.dsCanSu = dsCanSu;
    }

    public List<BanCanSu> getDsCanSu() {
        return dsCanSu;
    }
    

    public Khoa() {
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

    public List<Lop> getDsLop() {
        return dsLop;
    }

    public List<CoVan> getDsCoVan() {
        return dsCoVan;
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

    public void setDsLop(List<Lop> dsLop) {
        this.dsLop = dsLop;
    }

    public void setDsCoVan(List<CoVan> dsCoVan) {
        this.dsCoVan = dsCoVan;
    }
    
    
    
}
