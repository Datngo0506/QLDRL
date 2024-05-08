/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class CoVan {
    private String maCV, tenCV, khoa, gioiTinh, ngaySinh, sdt, email, queQuan, diaChi;

    public CoVan() {
    }

    public CoVan(String maCV, String tenCV, String khoa, String gioiTinh, String ngaySinh, String sdt, String email, String queQuan, String diaChi, String mk) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.khoa = khoa;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
    }

    public String getMaCV() {
        return maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public String getKhoa() {
        return khoa;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }


    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    
}
