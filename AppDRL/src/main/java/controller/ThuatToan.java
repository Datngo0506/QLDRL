/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Choice;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import models.ChucVu;
import models.CoVan;
import models.DRL;
import models.HocKy;
import models.Khoa;
import models.KhoaHoc;
import models.Lop;
import models.SinhVien;
import models.TaiKhoan;
import models.ThongBao;
import models.TieuChi;

/**
 *
 * @author Dat
 */
public class ThuatToan {
    
    //Từ một sinh viên biết sinh viên đó khoa nào
    public static String getKhoaFromSinhVien(ArrayList<Lop> dsLop, String maLop){
        for(Lop lop: dsLop){
            if(lop.getLop().equals(maLop)){
                return lop.getMaKhoa();
            }
        }
        return "";
    }
    
    //ẩn mật khẩu thành ****
    public static String anMatKhau(String pass){
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < pass.length(); i++) {
            stars.append("*");
        }
        return stars.toString();
    }
    
    //đổi mật khẩu
    public static void doiMatKhau(ArrayList<TaiKhoan> dsTaiKhoan, String tenDn, String newMk){
        for(TaiKhoan tk: dsTaiKhoan){
            if(tk.getTenTK().equals(tenDn)){
                tk.setMatKhau(newMk);
                return;
            }
        }
    }
    
    //lấy mật khẩu từ username
    public static String getMatKhau(ArrayList<TaiKhoan> dsTaiKhoan, String tenDn){
        for(TaiKhoan tk: dsTaiKhoan){
            if(tk.getTenTK().equals(tenDn)){
                return tk.getMatKhau();
            }
        }
        return "";
    }
    
    public static String getTrangThai(ArrayList<TaiKhoan> dsTaiKhoan, String tenDn){
        for(TaiKhoan tk: dsTaiKhoan){
            if(tk.getTenTK().equals(tenDn)){
                if(tk.isTrangThai() == true){
                    return "Hoạt động";
                }
            }
        }
        return "Đã khóa";
    }
    
    //Đổi từ danh sách sinh viên mã lớp cũ thành mã lớp mới
    public static void doiLopDsSV(ArrayList<SinhVien> dsSinhVien, String lopCu, String lopMoi){
        for(SinhVien ds: dsSinhVien){
            if(ds.getLop().equals(lopCu)){
                ds.setLop(lopMoi);
            }
        }
    }
    
    
    
    public static void sapXepTheoDRL(ArrayList<DRL> danhSachDRL) {
        Collections.sort(danhSachDRL, (DRL drl1, DRL drl2) -> drl1.getMSSV().compareTo(drl2.getMSSV()));
    }
    
    public static void sapXepTheoDRL_HK(ArrayList<DRL> danhSachDRL) {
        Collections.sort(danhSachDRL, (DRL drl1, DRL drl2) -> drl1.getMaHK().compareTo(drl2.getMaHK()));
    }
    
    public static void sapXepTheoMSSV(ArrayList<SinhVien> dsSV) {
        Collections.sort(dsSV, (SinhVien sv1, SinhVien sv2) -> {
            return sv1.getMaSV().compareTo(sv2.getMaSV());
        });
    }
    
    public static void sapXepTheoMaKhoa(ArrayList<Khoa> dsKhoa) {
        Collections.sort(dsKhoa, (Khoa khoa1, Khoa khoa2) -> khoa1.getMaKhoa().compareTo(khoa2.getMaKhoa()));
    }
    
    public static void sapXepTheoLop(ArrayList<Lop> dsLop) {
        Collections.sort(dsLop, (Lop lop1, Lop lop2) -> {
            return lop1.getLop().compareTo(lop2.getLop());
        });
    }
    
    public static void sapXepTheoCoVan(ArrayList<CoVan> dsCoVan) {
        Collections.sort(dsCoVan, (CoVan covan1, CoVan covan2) -> covan1.getMaCV().compareTo(covan2.getMaCV()));
    }
    
    //đổi khoa cũ thành khoa mới trong danh sách lớp
    public static void suaKhoaTrongLop(ArrayList<Lop> dsLop, String maKhoaCu, String maKhoaMoi){
        for(Lop lop: dsLop){
            if(lop.getMaKhoa().equals(maKhoaCu)){
                lop.setMaKhoa(maKhoaMoi);
            }
        }
    }
    
    //đổi khoa cũ thành khoa mới trong danh sách cố vấn
    public static void suaKhoaTrongCoVan(ArrayList<CoVan> dsCoVan, String maKhoaCu, String maKhoaMoi){
        for(CoVan covan: dsCoVan){
            if(covan.getKhoa().equals(maKhoaCu)){
                covan.setKhoa(maKhoaMoi);
            }
        }
    }
    
    public static void suaCoVanTrongLop(ArrayList<Lop> dsLop, String maCVCu, String maCVMoi){
        for(Lop lop: dsLop){
            if(lop.getMaCoVan().equals(maCVCu)){
                lop.setMaCoVan(maCVMoi);
            }
        }
    }
    
    //In hoa chữ cái đầu
    public static String inHoaChuCaiDau(String word) {
        // Nếu từ rỗng hoặc null, trả về từ ban đầu
        if (word == null || word.isEmpty()) {
            return word;
        }
        // Chuyển chữ cái đầu của từ thành chữ hoa
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
    
    //Chuẩn hóa tên đúng định dạng
    public static String chuanHoaTen(String input) {
        // Chuyển chuỗi thành mảng các từ
        String[] words = input.split("\\s+");
        StringBuilder normalizedBuilder = new StringBuilder();

        // Duyệt qua từng từ trong mảng
        for (String word : words) {
            // Chuyển chữ cái đầu của từ thành chữ hoa
            String capitalizedWord = inHoaChuCaiDau(word);
            // Thêm từ đã chuẩn hóa vào chuỗi kết quả
            normalizedBuilder.append(capitalizedWord).append(" ");
        }

        // Trả về chuỗi kết quả đã chuẩn hóa (loại bỏ dấu cách cuối cùng nếu có)
        return normalizedBuilder.toString().trim();
    }
    
    //Đổi True False to nam nữ
    public static String doiBoolToGioiTinh(String text){
        if(text.equals("true")){
            return "Nam";
        }
        else{
            return "Nữ";
        }
    }
    
    //Đổi nam nữ to true false
    public static String doiGioiTinhToBool(String text){
        if(text.equals("Nam")){
            return "true";
        }
        else{
            return "false";
        }
    }
    
    //doi ma khoa thành tên khoa
    public static String doiMaKhoaThanhTenKhoa(String ma, ArrayList<Khoa> dsKhoa){
        for(Khoa kh:dsKhoa){
            if((kh.getMaKhoa().trim()).equals(ma)){
                return kh.getTenKhoa();
            }
        }
        return "";
    }
    
    //đổi tên khoa thành mã khoa
    public static String doiTenKhoaThanhMaKhoa(String ten, ArrayList<Khoa> dsKhoa){
        for(Khoa kh:dsKhoa){
            if(kh.getTenKhoa().equals(ten)){
                return kh.getMaKhoa();
            }
        }
        return "";
    }
    
    public static boolean isStrongPassword(String password) {
        // Kiểm tra độ dài mật khẩu, cần ít nhất 8 ký tự
        if (password.length() < 8) {
            return false;
        }

        // Kiểm tra xem mật khẩu có chứa số không
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Kiểm tra xem mật khẩu có chứa ký tự viết hoa không
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Kiểm tra xem mật khẩu có chứa ký tự viết thường không
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Kiểm tra xem mật khẩu có chứa ký tự đặc biệt không
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = specialCharPattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        // Nếu mật khẩu thỏa mãn tất cả các điều kiện, trả về true
        return true;
    }
    
    // đổi mã cố vấn thành tên cố vấn
    public static String doiMaCVThanhTen(String maCv, ArrayList<CoVan> dsCoVan){
        for(CoVan cv:dsCoVan){
            if(cv.getMaCV().equals(maCv)){
                return cv.getTenCV();
            }
        }
        return "";
    }
    
//    //đổi lại tên cố vấn thành mã
//    public static String doiTenCVThanhMa(String ten, ArrayList<CoVan> dsCoVan){
//        for(CoVan cv: dsCoVan){
//            if(cv.getTenCV().equals(ten)){
//                return cv.getMaCV();
//            }
//        }
//        return "";
//    }
    
    //Mã khoa đã tồn tại trên hệ thống chưa?
    public static boolean isRepeatMaKhoa(ArrayList<Khoa>dsKhoa, String s){
        for(Khoa khoa: dsKhoa){
            if(khoa.getMaKhoa().equals(s)){
                return true;
            }
        }
        return false;
    }
    
    //Mã lớp đã tồn tại trên hệ thống chưa
    public static boolean isRepeatLop(ArrayList<Lop>dsLop, String s){
        for(Lop lop: dsLop){
            if(lop.getLop().equals(s)){
                return true;
            }
        }
        return false;
    }
    
    //Mã cố vấn đã tồn tại trên hệ thống chưa
    public static boolean isRepeatMaCoVan(ArrayList<CoVan>dsCoVan, String s){
        for(CoVan ds: dsCoVan){
            if(ds.getMaCV().equals(s)){
                return true;
            }
        }
        return false;
    }
    
    //Mã sinh viên đã tồn tại trên hệ thống chưa
    public static boolean isRepeatMaSV(ArrayList<SinhVien>dsSV, String s){
        for(SinhVien ds: dsSV){
            if(ds.getMaSV().equals(s)){
                return true;
            }
        }
        return false;
    }
    
    //Thêm danh sách khoa vào choice
    public static void addChoiceKhoa(Choice choice, ArrayList <Khoa> dsKhoa){
        
        choice.removeAll();
        choice.add("Tất cả");
        for(Khoa khoa : dsKhoa){
            choice.add(khoa.getTenKhoa());
        }
        
    }
    
    //thêm danh sách chức vụ vào choice
    public static void addChoiceChucVu(Choice choice, ArrayList <ChucVu> dsChucVu){
        
        choice.removeAll();
        choice.add("Tất cả");
        for(ChucVu cv : dsChucVu){
            choice.add(cv.getTenChucVu());
        }        
    }
    
    //đổi tên chức vụ thành mã chức vụ
    public static String doiTenChucVuThanhMa(String ten, ArrayList<ChucVu> dsChucVu){
        for(ChucVu cv: dsChucVu){
            if(cv.getTenChucVu().trim().equals(ten.trim())){
                return cv.getMaChucVu();
            }
        }
        return "";
    }
    
    public static String doiMaChucVuThanhTen(String ten, ArrayList<ChucVu> dsChucVu){
        for(ChucVu cv: dsChucVu){
            if(cv.getMaChucVu().trim().equals(ten.trim())){
                return cv.getTenChucVu();
            }
        }
        return "";
    }
    
    //thêm danh sách khóa học vào choice
    public static void addChoiceKhoaHoc(Choice choice, ArrayList <KhoaHoc> dsKhoaHoc){
        
        choice.removeAll();
        //choice.add("");
        for(KhoaHoc khoaHoc : dsKhoaHoc){
            choice.add(khoaHoc.getMaKhoaHoc());
        }
    }
    
    //thêm danh sách cố vấn vào choice
    public static void addChoiceCoVan(Choice choice, ArrayList <CoVan> dsCoVan){
        
        choice.removeAll();
        //choice.add("");
        for(CoVan coVan : dsCoVan){
            choice.add(coVan.getTenCV());
        }
    }
    
    //Thêm danh sách cố vấn vào choice(tên cố vấn)
    public static void addChoiceCoVanTheoTen(Choice choice, ArrayList <CoVan> dsCoVan,  ArrayList <Khoa> dsKhoa, String tenKhoa){
        
        choice.removeAll();
        //choice.add("");
        for(CoVan coVan : dsCoVan){
            if(ThuatToan.doiMaKhoaThanhTenKhoa(coVan.getKhoa(), dsKhoa).equals(tenKhoa)){
                choice.add(coVan.getMaCV());
            } else {
            }
        }        
    }
    
    
    //đổi học kỳ hiện tại thành học kỳ mới
    public static String tangHocKy(String input) {
        // Tách chuỗi thành các phần tử
        String[] parts = input.split("-");
        
        // Lấy năm và số kỳ học
        int year1 = Integer.parseInt(parts[0]);
        int year2 = Integer.parseInt(parts[1]);
        int term = Integer.parseInt(parts[2]);
        
        // Kiểm tra nếu kỳ học là 1 thì tăng năm thứ 2, nếu không thì tăng kỳ học
        if (term == 1) {
            term++;
        } else {
            term--;
            year1++;
            year2++;
        }
        
        // Tạo chuỗi kết quả và trả về
        return year1 + "-" + year2 + "-" + term;
    }
    
    public static String getHKXet(ArrayList<HocKy>dsHocKy){
        for(HocKy hk: dsHocKy){
            if(hk.getXet()==true){
                return hk.getMaHK_NK();
            }
        }
        return "";
    }
    
    public static ThongBao getThongBao(ArrayList<ThongBao>dsTB, String hkxet){
        for(ThongBao tb: dsTB){
            if(tb.getMaHocKy().equals(hkxet)){
                return tb;
            }
        }
        return null;
        
    }
    //Lấy tên chức vụ từ mã chức vụ
    public static String getTenChucVu(ArrayList<ChucVu> dsChucVu, String ten){
        for(ChucVu cv: dsChucVu){
            if(cv.getMaChucVu().equals(ten)){
                return cv.getTenChucVu();
            }
        }
        return "";
    }

    
    //Thêm danh sách lớp vào choice
    public static void addChoiceLop(Choice ch, ArrayList<Lop>dsLop, String tenKhoa, ArrayList<Khoa> dsKhoa){
        String maKhoa = doiTenKhoaThanhMaKhoa(tenKhoa, dsKhoa);
        ch.removeAll();
        if(dsLop !=null){
            for(Lop lop: dsLop){
                if(lop.getMaKhoa().equals(maKhoa)){
                    ch.add(lop.getLop());
                }
            }
        }
        
    }
    
    public static void addChoiceLop2(Choice ch, ArrayList<Lop>dsLop, String tenKhoa, ArrayList<Khoa> dsKhoa){
        String maKhoa = doiTenKhoaThanhMaKhoa(tenKhoa, dsKhoa);
        if(dsLop !=null){
            for(Lop lop: dsLop){
                if(lop.getMaKhoa().equals(maKhoa)){
                    ch.add(lop.getLop());
                }
            }
        }
        
    }
    
    //Thêm danh sách lớp vào choice với choice có thêm "Tất cả"
    public static void addChoiceLopTatCa(Choice ch, ArrayList<Lop>dsLop, String tenKhoa, ArrayList<Khoa> dsKhoa){
        String maKhoa = doiTenKhoaThanhMaKhoa(tenKhoa, dsKhoa);
        ch.removeAll();
        ch.add("Tất cả");
        if(dsLop !=null){
            for(Lop lop: dsLop){
                if(lop.getMaKhoa().equals(maKhoa)){
                    ch.add(lop.getLop());
                }
            }
        }
        
    }
    
    //đổi yyyy-MM-dd thành dd-MM-yyyy và ngược lại
    public static String doiNgay(String s ){
        String[] parts = s.split("-");        
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }
    
    //reset mã tiêu chí trong danh sách tiêu chí từ TC001........
    public static void resetMaTC(ArrayList<TieuChi> dsTieuChi){
        int i=1;
        String s;
        for(TieuChi tc:dsTieuChi){
            if(i<10){
                s = "TC00" + i;
            }
            else if(i<100 && i>=10){
                s = "TC0" + i;
            }
            else{
                s = "TC" + i;
            }
            tc.setMaTieuChi(s);
            i++;
        }
        Database.saveTieuChiToDB(dsTieuChi);
    }
    
    
    //Tạo mã tiêu chí từ danh sách tiêu chí
    public static String taoMaTC(ArrayList<TieuChi> dsTieuChi){
        int i = dsTieuChi.size() + 1;
        if(i<10){
            return "TC00" + i;
        }
        else if(dsTieuChi.size()<100 && i>=10){
            return "TC0" + i;
        }
        return "TC" + i;
    }
    
        public static String getDate(Date date){
        String day = "";
        if(date!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            day = sdf.format(date);
        }
        return day;
    }
        
    public static String getKhoaHocFromSV(ArrayList<Lop> dsLop, String tenLop){
        for(Lop lop: dsLop){
            if(lop.getLop().equals(tenLop)){
                return lop.getMaKhoaHoc();
            }
        }
        return "";
    }
    
    public static int randomDiem() {
        // Khởi tạo một đối tượng Random
        Random random = new Random();

        // Tạo một số ngẫu nhiên trong phạm vi từ 0 đến 40
        int diemRange = random.nextInt(41);

        // Dịch chuyển phạm vi từ 0-40 thành 60-100 bằng cách cộng thêm 60
        int diem = diemRange + 60;

        return diem;
    }
    
    public static String doiKhoaHocSangHKCuoi(String khoaHoc, double soNam){
        String[] parts = khoaHoc.split("-");
        int namBatDau = Integer.parseInt(parts[0]);
        int namKetThuc = Integer.parseInt(parts[1]);
        int hocKyCuoi;
        int soNamInt = (int) soNam;
        if (soNam - soNamInt == 0.5) {
            hocKyCuoi = 1;
        } else {
            hocKyCuoi = 2;
        }

        String kyCuoi = ((int)(namKetThuc - 1)) + "-" + (int)(namKetThuc) + "-" + hocKyCuoi;
        return kyCuoi;
    }
    
    public static void addChoiceHocKy(ArrayList<HocKy>dsHK, String khoaHoc, double soNam, Choice choice){
        String[] parts = khoaHoc.split("-");
        choice.removeAll();
        int namBatDau = Integer.parseInt(parts[0]);
        int namKetThuc = Integer.parseInt(parts[1]);
        
        String hkDau = namBatDau + "-"+ (namBatDau+1)+"-1";
        // Chuyển đổi số năm từ double sang int, làm tròn xuống
        int soNamInt = (int) soNam;

        // Tính toán học kỳ cuối cùng
        int hocKyCuoi;
        if (soNam - soNamInt == 0.5) {
            hocKyCuoi = 1;
        } else {
            hocKyCuoi = 2;
        }

        String kyCuoi = ((int)(namKetThuc - 1)) + "-" + (int)(namKetThuc) + "-" + hocKyCuoi;
        
        String chuoi1 = kyCuoi;

        // Ví dụ: chuỗi 2
        String chuoi2 = dsHK.getLast().getMaHK_NK();

        // Tách chuỗi 1 thành các phần tử số
        String[] phanTu1 = chuoi1.split("-");
        int nam1 = Integer.parseInt(phanTu1[0]);
        int namKetThuc1 = Integer.parseInt(phanTu1[1]);
        int hocKy1 = Integer.parseInt(phanTu1[2]);

        // Tách chuỗi 2 thành các phần tử số
        String[] phanTu2 = chuoi2.split("-");
        int nam2 = Integer.parseInt(phanTu2[0]);
        int namKetThuc2 = Integer.parseInt(phanTu2[1]);
        int hocKy2 = Integer.parseInt(phanTu2[2]);

        // So sánh từng phần tử của các chuỗi
        if (nam1 < nam2 || (nam1 == nam2 && namKetThuc1 < namKetThuc2) || (nam1 == nam2 && namKetThuc1 == namKetThuc2 && hocKy1 < hocKy2)) {
            // Các phần tử của chuỗi 1 nhỏ hơn chuỗi 2
        } else if (nam1 > nam2 || (nam1 == nam2 && namKetThuc1 > namKetThuc2) || (nam1 == nam2 && namKetThuc1 == namKetThuc2 && hocKy1 > hocKy2)) {
            kyCuoi = chuoi2;
        } else {
            // Hai chuỗi bằng nhau
        }
        choice.add(doiMaHKSangHK(hkDau));
        while(true){
            hkDau = tangHocKy(hkDau);
            choice.add(doiMaHKSangHK(hkDau));
            if(hkDau.equals(kyCuoi)){
                break;
            }
        }
        

        // Tiếp tục với việc thêm các học kỳ vào choice theo logic của bạn
    }
    
    public static float getSoNamHoc(ArrayList<KhoaHoc>dsKhoaHoc, String khoaHoc){
        for(KhoaHoc kh: dsKhoaHoc){
            if(kh.getMaKhoaHoc().equals(khoaHoc)){
                return kh.getTGHoc();
            }
        }
        return 0;
    }
    
    public static String doiMaHKSangHK(String maHK){ //2023-2024-1
        String parts[] = maHK.split("-");
        String hk;
        if(parts[2].equals("1")){
            hk = "I";
        }else hk = "II";
        return " " +hk + " " + parts[0] + "-" + parts[1]; //I 2023-2024
    }
    
    public static String doiHKSangMaHK(String maHK){ //I 2023-2024
        String[] parts = maHK.trim().split(" ");
        String hk;
        if(parts[0].equals("I")){
            hk = "1";
        }else hk = "2";
        return parts[1] + "-" + hk;
    }
    
    public static String getLopFromDRL(String msv, ArrayList<SinhVien> dsSV){
        for(SinhVien sv: dsSV){
            if(sv.getMaSV().equals(msv)){
                
                return sv.getLop();
            }
        }
        return "";
    }
    
    public static String getTenFromMSV(String msv, ArrayList<SinhVien> dsSV){
        for(SinhVien sv: dsSV){
            if(sv.getMaSV().equals(msv)){
                
                return sv.getHoTen();
            }
        }
        return "";
    }
    
    //public static 
    public static boolean isValidDateFormat(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false); // Không cho phép chuyển đổi mềm dẻo

        try {
            // Cố gắng chuyển đổi chuỗi thành đối tượng Date
            Date date = sdf.parse(dateStr);
            return true; // Nếu không có ngoại lệ nào xảy ra, chuỗi có định dạng hợp lệ
        } catch (ParseException e) {
            // Nếu có ngoại lệ ParseException xảy ra, chuỗi không có định dạng hợp lệ
            return false;
        }
    }
    
    public static ThongBao addNewThongBaoHK1(String maHK, String nam){
        ThongBao tb = new ThongBao();
        tb.setMaHocKy(maHK);
        tb.setNgayBD(nam + "-02-01");
        tb.setNgayKTSV(nam + "-02-10");
        tb.setNgayKTCS(nam + "-02-20");
        tb.setNgayKTCV(nam + "-03-01");
        tb.setNgayKTKhoa(nam + "-03-10");
        return tb;
    }
    
    public static ThongBao addNewThongBaoHK2(String maHK, String nam){
        ThongBao tb = new ThongBao();
        tb.setMaHocKy(maHK);
        tb.setNgayBD(nam + "-07-01");
        tb.setNgayKTSV(nam + "-07-10");
        tb.setNgayKTCS(nam + "-07-20");
        tb.setNgayKTCV(nam + "-07-30");
        tb.setNgayKTKhoa(nam + "-08-10");
        return tb;
    }
    
    public static void addDRLSV1HocKy(ArrayList<TaiKhoan>dsTaiKhoan, ArrayList<SinhVien>dsSinhVien, ArrayList<Lop>dsLop, ArrayList<KhoaHoc>dsKhoaHoc, String maHocKy, ArrayList<DRL>dsDRL){
        
        
        for(SinhVien sv: dsSinhVien){
            boolean flag = false;
            for(TaiKhoan tk: dsTaiKhoan){
                if(tk.getTenTK().equals(sv.getMaSV())){
                    if(tk.isTrangThai() == false){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag == false){
                String khoaHoc = getKhoaHocFromSV(dsLop, sv.getLop());
                float soNamHoc = getSoNamHoc(dsKhoaHoc, khoaHoc);
                String hkCuoi = doiKhoaHocSangHKCuoi(khoaHoc, soNamHoc);
                int soSanh = soSanhHocKy(maHocKy, hkCuoi);
                if(soSanh<=0){
                    DRL drl = new DRL();
                    drl.setMSSV(sv.getMaSV());
                    drl.setMaHK(maHocKy);
                    drl.setTrangThai(false);
                    drl.setDiem1(0);
                    drl.setDiem2(0);
                    drl.setDiem3(0);
                    dsDRL.add(drl);
                    //Database.saveOneDRLToDB(drl);
                }
            }
            
        }
        Database.saveListDRLToDB(dsDRL);
    }
    
    public static boolean kTraTGXetKhoa(ArrayList<ThongBao> dsThongBao, ArrayList<HocKy> dsHocKy){
        LocalDate currentDate = LocalDate.now();
        LocalDate date1 = null, date2 = null;
        for(ThongBao tb: dsThongBao){
            if(tb.getMaHocKy().equals(ThuatToan.getHKXet(dsHocKy))){
                date1 = LocalDate.parse(tb.getNgayBD());
                date2 = LocalDate.parse(tb.getNgayKTKhoa());
                break;
            }
        }
        return !(date1.compareTo(currentDate)>0 || date2.compareTo(currentDate) <0);
    }
    
    public static boolean kTraTGXetSV(ArrayList<ThongBao> dsThongBao, ArrayList<HocKy> dsHocKy){
        LocalDate currentDate = LocalDate.now();
        LocalDate date1 = null, date2 = null;
        for(ThongBao tb: dsThongBao){
            if(tb.getMaHocKy().equals(ThuatToan.getHKXet(dsHocKy))){
                date1 = LocalDate.parse(tb.getNgayBD());
                date2 = LocalDate.parse(tb.getNgayKTSV());
                break;
            }
        }
        return !(date1.compareTo(currentDate)>0 || date2.compareTo(currentDate) <0);
    }
    
    public static boolean kTraTGXetCS(ArrayList<ThongBao> dsThongBao, ArrayList<HocKy> dsHocKy){
        LocalDate currentDate = LocalDate.now();
        LocalDate date1 = null, date2 = null;
        for(ThongBao tb: dsThongBao){
            if(tb.getMaHocKy().equals(ThuatToan.getHKXet(dsHocKy))){
                date1 = LocalDate.parse(tb.getNgayBD());
                date2 = LocalDate.parse(tb.getNgayKTCS());
                break;
            }
        }
        return !(date1.compareTo(currentDate)>0 || date2.compareTo(currentDate) <0);
    }
    
    public static boolean kTraTGXetCV(ArrayList<ThongBao> dsThongBao, ArrayList<HocKy> dsHocKy){
        LocalDate currentDate = LocalDate.now();
        LocalDate date1 = null, date2 = null;
        for(ThongBao tb: dsThongBao){
            if(tb.getMaHocKy().equals(ThuatToan.getHKXet(dsHocKy))){
                date1 = LocalDate.parse(tb.getNgayBD());
                date2 = LocalDate.parse(tb.getNgayKTCV());
                break;
            }
        }
        return !(date1.compareTo(currentDate)>0 || date2.compareTo(currentDate) <0);
    }
    
    public static int soSanhHocKy(String hocKy1, String hocKy2) {
        // Tách các phần của chuỗi học kỳ
        String[] parts1 = hocKy1.split("-");
        String[] parts2 = hocKy2.split("-");

        // So sánh năm học
        int nam1 = Integer.parseInt(parts1[0]);
        int nam2 = Integer.parseInt(parts2[0]);
        if (nam1 != nam2) {
            return nam1 - nam2;
        }

        // So sánh học kỳ
        int hocKy1Number = Integer.parseInt(parts1[1]);
        int hocKy2Number = Integer.parseInt(parts2[1]);
        if (hocKy1Number != hocKy2Number) {
            return hocKy1Number - hocKy2Number;
        }

        // So sánh số thứ tự của học kỳ
        int stt1 = Integer.parseInt(parts1[2]);
        int stt2 = Integer.parseInt(parts2[2]);
        return stt1 - stt2;
    }
    
    public static boolean kTraHKTrongKhoaHoc(String khoaHoc,  String hocKy){
        String parts[] = khoaHoc.split("-");
        String hkDau = parts[0] + "-" + (Integer.parseInt(parts[0]) + 1) + "-1";
        String hkCuoi = doiKhoaHocSangHKCuoi(khoaHoc, 4.5);
        return soSanhHocKy(hkDau, hocKy) <= 0 && soSanhHocKy(hkCuoi, hocKy) >=0;
    }
    
    public static void showWaitMessage(int seconds) {
        // Hiển thị thông báo
        JOptionPane optionPane = new JOptionPane("Vui lòng chờ trong " + seconds + " giây.", JOptionPane.INFORMATION_MESSAGE);
        final JOptionPane message = new JOptionPane(optionPane, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        // Tạo và khởi chạy một Timer để tự đóng JOptionPane sau khi hết thời gian
        Timer timer = new Timer(seconds * 1000, e -> {
            message.setVisible(false);
            message.getParent().setVisible(false); // Đóng cả cửa sổ cha của JOptionPane
        });
        timer.setRepeats(false); // Đặt Timer không lặp lại
        timer.start(); // Bắt đầu Timer

        // Hiển thị JOptionPane
        JOptionPane.showMessageDialog(null, "Vui lòng chờ...", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Kiểm tra mã sinh viên đã có trong điểm rèn luyện chưa
    public static boolean kTraTonTaiMSSV(String msv, ArrayList<DRL>dsDRL, String maHK){
        for(DRL drl: dsDRL){
            if(drl.getMSSV().equals(msv) && maHK.equals(drl.getMaHK())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isPhoneNumber(String str) {
        // Kiểm tra xem chuỗi có đủ 10 ký tự không
        if (str.length() != 10) {
            return false;
        }
        
        // Kiểm tra xem tất cả các ký tự trong chuỗi có phải là số không
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        // Kiểm tra xem số điện thoại có bắt đầu bằng 0 không
        
        return str.charAt(0) == '0';
    }
    
    public static boolean isEmail(String str) {
        // Mẫu regex để kiểm tra định dạng email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Tạo Pattern từ regex
        Pattern pattern = Pattern.compile(emailRegex);
        
        // Tạo Matcher để kiểm tra chuỗi với Pattern
        Matcher matcher = pattern.matcher(str);
        
        // Trả về kết quả kiểm tra
        return matcher.matches();
    }
    
    public static boolean containsDigit(String str) {
        // Kiểm tra từng ký tự trong chuỗi
        for (int i = 0; i < str.length(); i++) {
            // Nếu ký tự hiện tại là một chữ số
            if (Character.isDigit(str.charAt(i))) {
                return true; // Trả về true ngay lập tức
            }
        }
        // Nếu không có chữ số nào được tìm thấy
        return false;
    }
    
    public static String chuanHoaDiaDanh(String name) {
        // Tách chuỗi thành các từ
        String[] words = name.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        // Chuẩn hóa từng từ
        for (String word : words) {
            // Nếu từ không rỗng
            if (!word.isEmpty()) {
                // Chuẩn hóa chữ cái đầu của từ
                char firstChar = Character.toUpperCase(word.charAt(0));
                
                // Kiểm tra xem từ có phải là số La Mã như I hoặc II không
                if (word.equalsIgnoreCase("i")) {
                    // Nếu là "i", giữ nguyên chữ i
                    result.append("I");
                } else if (word.equalsIgnoreCase("ii")) {
                    // Nếu là "ii", giữ nguyên chữ ii
                    result.append("II");
                } else {
                    // Nếu không, viết hoa chữ cái đầu của từ và thêm vào chuỗi kết quả
                    result.append(firstChar);
                    result.append(word.substring(1).toLowerCase());
                }
                
                // Thêm dấu cách giữa các từ
                result.append(" ");
            }
        }
        
        // Xóa dấu cách cuối cùng nếu có
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        
        return result.toString();
    }
    
    public static boolean isInteger(String str) {
        // Kiểm tra xem chuỗi có rỗng không
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        // Kiểm tra từng ký tự trong chuỗi
        for (int i = 0; i < str.length(); i++) {
            // Nếu ký tự hiện tại không phải là số và không phải là dấu trừ đầu tiên
            if (!Character.isDigit(str.charAt(i)) && !(i == 0 && str.charAt(i) == '-')) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void addChoiceLop_1Khoa(ArrayList<Lop> dsLop, String maKhoa, Choice ch){
        for(Lop lop: dsLop){
            if(lop.getMaKhoa().equals(maKhoa)){
                ch.add(lop.getLop());
            }
        }
    }
    
    public static String getMaChucVuFromTen(String ten, ArrayList<ChucVu> dsChucVu){
        for(ChucVu cv: dsChucVu){
            if(cv.getTenChucVu().toLowerCase().equals(ten.toLowerCase())){
                return cv.getMaChucVu();
            }
        }
        return "";
    }
    
}
