/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appdrl;
import icons.Icon;
import java.util.ArrayList;
import views.FormSinhVien;
import views.FormQuanLy;
/**
 *
 * @author Dat
 */
public class AppDRL {

    public static void main(String[] args) {

        new FormQuanLy().setVisible(true);
        // In ra đường dẫn
        System.out.println("La: " + Icon.getUrlIcon("a.png"));
    }
}
