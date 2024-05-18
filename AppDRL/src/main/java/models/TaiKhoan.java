/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class TaiKhoan {
    private String tenTK, matKhau, loaiTK;
    private boolean trangThai;

    public TaiKhoan() {
    }

    //abcc

    public TaiKhoan( String tenTK, String matKhau, String loaiTK, boolean TrangThai) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
        this.trangThai = trangThai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    

    public String getTenTK() {
        return tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getLoaiTK() {
        return loaiTK;
    }


    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }
    
    
}
