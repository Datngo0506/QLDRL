/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class SinhVien {
    private String hoTen, MSSV, ngaySinh, queQuan, email, sdt; // Thông tin cá nhân
    private DRL drl;
    private Account taiKhoan;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String MSSV, String ngaySinh, String queQuan, String email, String sdt, DRL drl, Account taiKhoan) {
        this.hoTen = hoTen;
        this.MSSV = MSSV;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.email = email;
        this.sdt = sdt;
        this.drl = drl;
        this.taiKhoan = taiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMSSV() {
        return MSSV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public DRL getDrl() {
        return drl;
    }

    public Account getTaiKhoan() {
        return taiKhoan;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDrl(DRL drl) {
        this.drl = drl;
    }

    public void setTaiKhoan(Account taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    
    
    
}
