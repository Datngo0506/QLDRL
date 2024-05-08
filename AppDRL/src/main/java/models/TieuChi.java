/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author Dat
 */



public class TieuChi {
    private String maTieuChi, noiDung;
    private int diem;
    private ArrayList <NoiDungTieuChi> dsNoiDung;

    public TieuChi() {
    }

    public TieuChi(String maTieuChi, String noiDung, int diem, ArrayList<NoiDungTieuChi> dsNoiDung) {
        this.maTieuChi = maTieuChi;
        this.noiDung = noiDung;
        this.diem = diem;
        this.dsNoiDung = dsNoiDung;
    }

    public String getMaTieuChi() {
        return maTieuChi;
    }

    public void setMaTieuChi(String maTieuChi) {
        this.maTieuChi = maTieuChi;
    }


    public String getNoiDung() {
        return noiDung;
    }

    public int getDiem() {
        return diem;
    }

    public ArrayList<NoiDungTieuChi> getDsNoiDung() {
        return dsNoiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public void setDsNoiDung(ArrayList<NoiDungTieuChi> dsNoiDung) {
        this.dsNoiDung = dsNoiDung;
    }
    
    
}
