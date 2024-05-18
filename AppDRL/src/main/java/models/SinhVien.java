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
    private String maSV, hoTen, lop, chucVu, sdt, email, ngaySinh, queQuan, diaChi;
    private boolean gioiTinh;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, String lop, String chucVu, String sdt, String email, String ngaySinh, String queQuan, String diaChi, boolean gioiTinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.chucVu = chucVu;
        this.sdt = sdt;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getLop() {
        return lop;
    }

    public String getChucVu() {
        return chucVu;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    
    
}
