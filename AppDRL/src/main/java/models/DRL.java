/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;

/**
 *
 * @author Dat
 */


class cotDRL{
    private String noiDung;
    private int diem;

    public cotDRL() {
    }

    public cotDRL(String noiDung, int diem) {
        this.noiDung = noiDung;
        this.diem = diem;
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


public class DRL {
    private List <cotDRL> dsDRL;

    public DRL(List cotDRL) {
        this.dsDRL = cotDRL;
    }

    public DRL() {
    }

    public List getCotDRL() {
        return dsDRL;
    }

    public void setCotDRL(List cotDRL) {
        this.dsDRL = cotDRL;
    }

    
    
}
