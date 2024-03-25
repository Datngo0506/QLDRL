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
    private String hoTen, maCoVan, ngaySinh, queQuan;
    
    private Account taiKhoan;

    public CoVan(String hoTen, String maCoVan, String ngaySinh, String queQuan, Account taiKhoan) {
        this.hoTen = hoTen;
        this.maCoVan = maCoVan;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.taiKhoan = taiKhoan;
    }

    public Account getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(Account taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public CoVan() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMaCoVan() {
        return maCoVan;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMaCoVan(String maCoVan) {
        this.maCoVan = maCoVan;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    
    
    
}
