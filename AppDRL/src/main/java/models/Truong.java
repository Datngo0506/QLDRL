/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dat
 */
public class Truong {
    private List<Khoa> dsKhoa;
    
    public Truong(){
        dsKhoa = new ArrayList<Khoa>();
        
    }
    
    public static void view(){
        System.out.println("Data.Truong.<init>()");
    }
    
}
