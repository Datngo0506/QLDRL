/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appdrl;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Khoa;
import controller.Controller;
import models.CoVan;
import models.HocKy;
import models.KhoaHoc;
import views.FormDangNhap;
import views.FormQuanLy;
import views.FormSinhVien;

/**
 *
 * @author Dat
 */
public class AppDRL {
    

    public static void main(String[] args) throws SQLException {
        
        
        //Khoa
        ArrayList<Khoa> dsKhoa = new ArrayList<>();
        // Thêm dữ liệu vào dsKhoa từ cơ sở dữ liệu
        Controller.addKhoaToList(dsKhoa);
        
        ArrayList<CoVan> dsCoVan = new ArrayList<>();
        // Thêm dữ liệu vào dsKhoa từ cơ sở dữ liệu
        Controller.addCoVanToList(dsCoVan);
        
        ArrayList<HocKy> dsHocKy = new ArrayList<>();
        Controller.addHocKyToList(dsHocKy);
        
        ArrayList<KhoaHoc> dsKhoaHoc = new ArrayList<>();
        Controller.addKhoaHocToList(dsKhoaHoc);
        //System.out.println(dsKhoaHoc.get(1).getMaKhoaHoc());

        // Hiển thị giao diện người dùng với dữ liệu từ dsKhoa
        new FormQuanLy(dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc).setVisible(true);
    }


    public AppDRL() {
        
    }
}
