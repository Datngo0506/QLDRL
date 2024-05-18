/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class ThongBao {
    private String maHocKy, ngayBD, ngayKTSV, ngayKTCS, ngayKTCV, ngayKTKhoa;

    public ThongBao() {
    }

    public ThongBao(String maHocKy, String ngayBD, String ngayKTSV, String ngayKTCS, String ngayKTCV, String ngayKTKhoa) {
        this.maHocKy = maHocKy;
        this.ngayBD = ngayBD;
        this.ngayKTSV = ngayKTSV;
        this.ngayKTCS = ngayKTCS;
        this.ngayKTCV = ngayKTCV;
        this.ngayKTKhoa = ngayKTKhoa;
    }

    public String getMaHocKy() {
        return maHocKy;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public String getNgayKTSV() {
        return ngayKTSV;
    }

    public String getNgayKTCS() {
        return ngayKTCS;
    }

    public String getNgayKTCV() {
        return ngayKTCV;
    }

    public String getNgayKTKhoa() {
        return ngayKTKhoa;
    }

    public void setMaHocKy(String maHocKy) {
        this.maHocKy = maHocKy;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKTSV(String ngayKTSV) {
        this.ngayKTSV = ngayKTSV;
    }

    public void setNgayKTCS(String ngayKTCS) {
        this.ngayKTCS = ngayKTCS;
    }

    public void setNgayKTCV(String ngayKTCV) {
        this.ngayKTCV = ngayKTCV;
    }

    public void setNgayKTKhoa(String ngayKTKhoa) {
        this.ngayKTKhoa = ngayKTKhoa;
    }
    
    
}
