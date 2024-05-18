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
import views.FormDangNhap;
import views.FormHoiDongKhoa;
import views.FormQuanLy;
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
        ThuatToan.sapXepTheoMSSV(dsDRL);
        Khoa khoa = null;
        if (!dsKhoa.isEmpty()) {
            khoa = dsKhoa.get(1);
        }

        // Hiển thị form với dữ liệu đã tải
        new FormHoiDongKhoa(khoa, dsTaiKhoan, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, dsChucVu, dsSinhVien, dsThongBao, dsDRL).setVisible(true);
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
