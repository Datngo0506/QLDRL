/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class KhoaHoc {
    private String MaKhoaHoc, NamBD, MamKT;
    private float TGHoc;

    public KhoaHoc(String MaKhoaHoc, String NamBD, String MamKT, float TGHoc) {
        this.MaKhoaHoc = MaKhoaHoc;
        this.NamBD = NamBD;
        this.MamKT = MamKT;
        this.TGHoc = TGHoc;
    }

    public KhoaHoc() {
    }

    public String getMaKhoaHoc() {
        return MaKhoaHoc;
    }

    public String getNamBD() {
        return NamBD;
    }

    public String getMamKT() {
        return MamKT;
    }

    public float getTGHoc() {
        return TGHoc;
    }



    public void setMaKhoaHoc(String MaKhoaHoc) {
        this.MaKhoaHoc = MaKhoaHoc;
    }

    public void setNamBD(String NamBD) {
        this.NamBD = NamBD;
    }

    public void setMamKT(String MamKT) {
        this.MamKT = MamKT;
    }

    public void setTGHoc(int TGHoc) {
        this.TGHoc = TGHoc;
    }

    
    
}
