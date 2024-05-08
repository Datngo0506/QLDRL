/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class NoiDungTieuChi{
    private String noiDung;
    private int diem;

    public NoiDungTieuChi(String noiDung, int diem) {
        this.noiDung = noiDung;
        this.diem = diem;
    }

    public NoiDungTieuChi() {
    }

    public String getNoiDung() {
        return noiDung;
    }

    public int getDiem() {
        return diem;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
    
    
    
}
