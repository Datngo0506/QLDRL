/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appdrl;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Khoa;
import controller.Controller;
import views.FormDangNhap;
import views.FormQuanLy;
import views.FormSinhVien;

/**
 *
 * @author Dat
 */
public class AppDRL {
    

    public static void main(String[] args) throws SQLException {
        
        ArrayList<Khoa> dsKhoa = new ArrayList<>();
        // Thêm dữ liệu vào dsKhoa từ cơ sở dữ liệu
        Controller.addKhoaToList(dsKhoa);
        
        

        // Hiển thị giao diện người dùng với dữ liệu từ dsKhoa
        new FormQuanLy(dsKhoa).setVisible(true);
    }


    public AppDRL() {
        
    }
}
