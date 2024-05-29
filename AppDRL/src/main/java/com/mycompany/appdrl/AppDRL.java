/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appdrl;
import java.util.ArrayList;
import models.Khoa;
import controller.Database;
import controller.ThuatToan;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import models.ChucVu;
import models.CoVan;
import models.DRL;
import models.HocKy;
import models.KhoaHoc;
import models.Lop;
import models.SinhVien;
import models.TaiKhoan;
import models.ThongBao;
import models.TieuChi;
import views.FormBanCanSu;
import views.FormCoVanHT;
import views.FormDangNhap;
import views.FormHoiDongKhoa;
import views.FormQuanLy;
import views.FormSinhVien;
/**
 *
 * @author Dat
 */
public class AppDRL {
       


    
    
     public static void main(String[] args) {
        ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();
        ArrayList<Khoa> dsKhoa = new ArrayList<>();
        ArrayList<CoVan> dsCoVan = new ArrayList<>();
        ArrayList<HocKy> dsHocKy = new ArrayList<>();
        ArrayList<KhoaHoc> dsKhoaHoc = new ArrayList<>();
        ArrayList<Lop> dsLop = new ArrayList<>();
        ArrayList<TieuChi> dsTieuChi = new ArrayList<>();
        ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
        ArrayList<ChucVu> dsChucVu = new ArrayList<>();
        ArrayList<ThongBao> dsThongBao = new ArrayList<>();
        ArrayList<DRL> dsDRL = new ArrayList<>();

        // Tạo một ExecutorService để thực hiện các tác vụ bất đồng bộ
         ExecutorService executor = Executors.newFixedThreadPool(1);

        // Tạo một Future để theo dõi tiến trình của tác vụ
         Future<?> future = executor.submit(() -> {
            Database.saveTaiKhoanToList(dsTaiKhoan);
            Database.saveKhoaToList(dsKhoa);
            Database.saveCoVanToList(dsCoVan);
            Database.saveHocKyToList(dsHocKy);
            Database.saveKhoaHocToList(dsKhoaHoc);
            Database.saveLopToList(dsLop);
            Database.saveTieuChiToList(dsTieuChi);
            Database.saveSinhVienToList(dsSinhVien);
            Database.saveChucVuToList(dsChucVu);
            Database.saveThongBaoToList(dsThongBao);
            Database.saveDRLToList(dsDRL);
        });

        try {
            // Chờ tác vụ hoàn thành
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            //e.printStackTrace();
        } finally {
            // Kết thúc ExecutorService sau khi tất cả các tác vụ đã hoàn thành
            executor.shutdown();
        }

        // Sau khi tất cả các tác vụ đã hoàn thành, bạn có thể thực hiện xử lý tiếp theo
        ThuatToan.sapXepTheoDRL(dsDRL);
        Khoa khoa = dsKhoa.get(1);
        
        Lop lop = new Lop();
        String mcv = "";
        for(Lop l: dsLop){
            if(l.getMaKhoa().equals(khoa.getMaKhoa()) & l.getLop().equals("D21CQAT01-N")){
                lop = l;
                mcv = l.getMaCoVan();
            }
        }
        SinhVien sv = new SinhVien();
        for(SinhVien s: dsSinhVien){
            if(ThuatToan.getKhoaFromSinhVien(dsLop, s.getLop()).equals(khoa.getMaKhoa()) && s.getLop().equals(lop.getLop())){
                sv = s;
                break;
            }
        }
        
        TaiKhoan tk = new TaiKhoan();
        for(TaiKhoan t: dsTaiKhoan){
            if(t.getTenTK().equals(sv.getMaSV())){
                tk = t;
                break;
            }
        }
        CoVan cv = new CoVan();
        for(CoVan c: dsCoVan){
            if(c.getMaCV().equals(mcv)){
                cv = c;
            }
        }
        TaiKhoan tk2 = new TaiKhoan();
        for(TaiKhoan t: dsTaiKhoan){
            if(t.getTenTK().equals(cv.getMaCV())){
                tk2 = t;
                break;
            }
        }
//        for(DRL drl: dsDRL){
//            System.out.println(drl.isTrangThai());
//        }
        
//        for(TaiKhoan tk: dsTaiKhoan){
//            System.out.println(tk.isTrangThai());
//        }

        // Hiển thị form với dữ liệu đã tải
//        new FormSinhVien(khoa, sv, lop, tk, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, 
//                dsChucVu, dsTaiKhoan, dsSinhVien, dsThongBao, dsDRL, dsTieuChi).setVisible(true);
//        new FormBanCanSu(khoa, sv, lop, tk, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, dsChucVu, 
//                dsTaiKhoan, dsSinhVien, dsThongBao, dsDRL, dsTieuChi).setVisible(true);
//        new FormCoVanHT(khoa, cv, tk2, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, 
//                dsChucVu, dsTaiKhoan, dsSinhVien, dsThongBao, dsDRL, dsTieuChi).setVisible(true);
//        new FormQuanLy(dsTaiKhoan, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, 
//                dsTieuChi, dsChucVu, dsSinhVien, dsThongBao, dsDRL).setVisible(true);
        new FormHoiDongKhoa(khoa, dsTaiKhoan, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop,
                dsChucVu, dsSinhVien, dsThongBao, dsDRL).setVisible(true);
    }


    public AppDRL() {
        
    }
}


//        for(SinhVien sv: dsSinhVien){
//        
//            String khoaHoc = ThuatToan.getKhoaHocFromSV(dsLop, sv.getLop());
//            String hienTai = "2023-2024-2";
//            String parts[] = khoaHoc.split("-");
//            String hkDau = parts[0] + "-" + (Integer.parseInt(parts[0])+1) + "-1";
//
//            for(int i=0; i<9; i++){
//                
//                
//                DRL drl = new DRL();
//                drl.setMSSV(sv.getMaSV());
//                drl.setMaHK(hkDau);
//                drl.setTrangThai(true);
//                drl.setDiem1(ThuatToan.randomDiem());
//                drl.setDiem2(ThuatToan.randomDiem());
//                drl.setDiem3(ThuatToan.randomDiem());
//                drl.setTrangThai(true);
//                dsDRL.add(drl);
//                //System.out.println(hkDau);
//                hkDau = ThuatToan.tangHocKy(hkDau);
//                
//                if(hkDau.equals(hienTai)){
//                    DRL drl2 = new DRL();
//                    drl2.setMSSV(sv.getMaSV());
//                    drl2.setMaHK(hkDau);
//                    drl2.setTrangThai(true);
//                    drl2.setDiem1(0);
//                    drl2.setDiem2(0);
//                    drl2.setDiem3(0);
//                    drl2.setTrangThai(false);
//                    dsDRL.add(drl2);
//                    break;
//                }
//                
//            }
//            
//       }
//        
//        Database.saveListDRLToDB(dsDRL);
