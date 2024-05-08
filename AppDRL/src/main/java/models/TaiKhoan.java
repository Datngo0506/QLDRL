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
    private String maTK, tenTK, matKhau, loaiTK;

    public TaiKhoan() {
    }

    public TaiKhoan(String maTK, String tenTK, String matKhau, String loaiTK) {
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
    }

    public String getMaTK() {
        return maTK;
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

    public void setMaTK(String maTK) {
        this.maTK = maTK;
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
