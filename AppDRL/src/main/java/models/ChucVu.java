/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class ChucVu {
    private String maChucVu, TenChucVu;

    public ChucVu(String maChucVu, String TenChucVu) {
        this.maChucVu = maChucVu;
        this.TenChucVu = TenChucVu;
    }

    public ChucVu() {
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }
    
    
    
}
