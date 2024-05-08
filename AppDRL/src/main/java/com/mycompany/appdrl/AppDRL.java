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
import models.Lop;
import models.TaiKhoan;
import models.TieuChi;
import views.FormDangNhap;
import views.FormQuanLy;
import views.FormSinhVien;

/**
 *
 * @author Dat
 */
public class AppDRL {
    

    public static void main(String[] args) throws SQLException {
        
        ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();
        Controller.addTaiKhoanToList(dsTaiKhoan);
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
        
        ArrayList<Lop> dsLop = new ArrayList<>();
        Controller.addLopToList(dsLop);
        
        ArrayList<TieuChi> dsTieuChi = new ArrayList<>();
        Controller.addTieuChiToList(dsTieuChi);
        // Hiển thị giao diện người dùng với dữ liệu từ dsKhoa
        new FormQuanLy(dsTaiKhoan, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, dsTieuChi).setVisible(true);
    }


    public AppDRL() {
        
    }
}
