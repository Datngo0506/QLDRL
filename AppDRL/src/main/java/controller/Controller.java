/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CoVan;
import models.HocKy;
import models.Khoa;
import models.KhoaHoc;
import models.Lop;
import models.NoiDungTieuChi;
import models.TaiKhoan;
import models.TieuChi;

/**
 *
 * @author Dat
 */
public class Controller {
    public static Connection getConnection(){
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDRL;user=sa;password=123;encrypt=true;trustServerCertificate=true;";
        Connection con = null;        
        try {
            con = DriverManager.getConnection(url);
            //System.out.println("Thanh cong");
            
        }
        catch (SQLException e) {
            //System.out.println("Khong the ket noi den CSDL \n" );
        }
        return con;
    }
    
    public static String changePass(String pass){
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < pass.length(); i++) {
            stars.append("*");
        }
        return stars.toString();
    }
    
    public static void doiMatKhau(ArrayList<TaiKhoan> dsTaiKhoan, String tenDn, String newMk){
        for(TaiKhoan tk: dsTaiKhoan){
            if(tk.getTenTK().equals(tenDn)){
                tk.setMatKhau(newMk);
                return;
            }
        }
    }
    
    public static String getMatKhau(ArrayList<TaiKhoan> dsTaiKhoan, String tenDn){
        for(TaiKhoan tk: dsTaiKhoan){
            if(tk.getTenTK().equals(tenDn)){
                return tk.getMatKhau();
            }
        }
        return "";
    }
    
    public static void addTaiKhoanToList(ArrayList<TaiKhoan> dsTaiKhoan){
        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM TaiKhoan");
                 ResultSet resultSet = statement.executeQuery()) {

                // Duyệt qua kết quả từ câu truy vấn
                while (resultSet.next()) {
                    // Đọc dữ liệu từ ResultSet
                    String maTK = resultSet.getString("MaTK").trim();
                    String tenTK = resultSet.getString("TenTK").trim();
                    String matKhau = resultSet.getString("MatKhau").trim();
                    String loaiTK = resultSet.getString("LoaiTK").trim();

                    // Tạo đối tượng TaiKhoan và thêm vào ArrayList
                    dsTaiKhoan.add(new TaiKhoan(maTK, tenTK, matKhau, loaiTK));
                }
            }
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            //e.printStackTrace();
        }
    }
    
    public static void addListToTaiKhoan(ArrayList<TaiKhoan> dsTaiKhoan){
        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            try (Connection connection = getConnection()) {
                // Xóa hết dữ liệu từ bảng TaiKhoan trước khi chèn
                String deleteQuery = "DELETE FROM TaiKhoan";

                // Tạo đối tượng PreparedStatement và thực hiện lệnh xóa
                PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
                pstmt.executeUpdate();

                // Chuẩn bị câu lệnh SQL cho việc chèn dữ liệu
                String insertQuery = "INSERT INTO TaiKhoan (MaTK, TenTK, MatKhau, LoaiTK) VALUES (?, ?, ?, ?)";
                pstmt = connection.prepareStatement(insertQuery);

                // Duyệt qua danh sách và chèn dữ liệu vào cơ sở dữ liệu
                for (TaiKhoan taiKhoan : dsTaiKhoan) {
                    pstmt.setString(1, taiKhoan.getMaTK().trim());
                    pstmt.setString(2, taiKhoan.getTenTK().trim());
                    pstmt.setString(3, taiKhoan.getMatKhau().trim());
                    pstmt.setString(4, taiKhoan.getLoaiTK().trim());

                    // Thực hiện lệnh chèn
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
            //ex.printStackTrace();
        }
    }
    
    public static void addKhoaToList(ArrayList<Khoa> khoa) {
        if (!khoa.isEmpty()) {
            khoa.clear();
        }
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM khoa")) {

            // Lặp qua kết quả từ câu truy vấn
            while (resultSet.next()) {
                // Đọc dữ liệu từ ResultSet
                String maKhoa = resultSet.getString("MaKhoa").trim();
                String tenKhoa = resultSet.getString("TenKhoa").trim();
                String ngayThanhLap = resultSet.getDate("NgayThanhLap").toString().trim(); // Chuyển ngày thành lập về dạng String

              
                //mk = changePass(mk);

                // Tạo đối tượng Khoa và thêm vào ArrayList
                khoa.add(new Khoa(maKhoa, tenKhoa, ngayThanhLap));
            }
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            //e.printStackTrace();
        }
    }
    
    public static void addListToKhoa(ArrayList<Khoa> dsKhoa) {
        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            try (Connection con = getConnection()) {
                // Xóa hết dữ liệu từ bảng Khoa trước khi cập nhật
                String deleteQuery = "DELETE FROM Khoa";

                // Tạo đối tượng PreparedStatement và thực hiện lệnh xóa
                PreparedStatement pstmt = con.prepareStatement(deleteQuery);
                pstmt.executeUpdate();

                // Chuẩn bị câu lệnh SQL cho việc chèn dữ liệu
                String insertQuery = "INSERT INTO Khoa (MaKhoa, TenKhoa, NgayThanhLap) VALUES (?, ?, ?)";
                pstmt = con.prepareStatement(insertQuery);
                // Duyệt qua danh sách và chèn dữ liệu vào cơ sở dữ liệu
                for (Khoa khoa : dsKhoa) {
                    pstmt.setString(1, khoa.getMaKhoa().trim());
                    pstmt.setString(2, khoa.getTenKhoa().trim());
                    pstmt.setString(3, khoa.getNgayThanhLap().trim());

                    // Thực hiện lệnh chèn
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
            //ex.printStackTrace();
        }
    }
    
     public static void addOneKhoaToTable(Khoa khoa, JTable tableKhoa, ArrayList<TaiKhoan> dsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tableKhoa.getModel();

        // Xóa dữ liệu cũ trong bảng
        //model.setRowCount(0);

        Object[] row = {khoa.getMaKhoa(), khoa.getTenKhoa(), khoa.getNgayThanhLap(), khoa.getMaKhoa() ,Controller.changePass(Controller.getMatKhau(dsTaiKhoan, khoa.getMaKhoa()))};
        model.addRow(row);
        //System.out.println(Controller.changePass(Controller.getMatKhau(dsTaiKhoan, khoa.getMaKhoa())));
    }
    
    public static void addListKhoaToTable(ArrayList<Khoa> dsKhoa, JTable tableKhoa, ArrayList<TaiKhoan> dsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tableKhoa.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);

        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (Khoa khoa: dsKhoa) {
            Object[] row = {khoa.getMaKhoa(), khoa.getTenKhoa(), khoa.getNgayThanhLap(), khoa.getMaKhoa() ,Controller.changePass(Controller.getMatKhau(dsTaiKhoan, khoa.getMaKhoa()))};
            model.addRow(row);
        }
    }
    
    
    public static void suaKhoaTrongLop(ArrayList<Lop> dsLop, String maKhoaCu, String maKhoaMoi){
        for(Lop lop: dsLop){
            if(lop.getMaKhoa().equals(maKhoaCu)){
                lop.setMaKhoa(maKhoaMoi);
            }
        }
    }
    
    public static void suaKhoaTrongCoVan(ArrayList<CoVan> dsCoVan, String maKhoaCu, String maKhoaMoi){
        for(CoVan covan: dsCoVan){
            if(covan.getKhoa().equals(maKhoaCu)){
                covan.setKhoa(maKhoaMoi);
            }
        }
    }
    
    public static String inHoaChuCaiDau(String word) {
        // Nếu từ rỗng hoặc null, trả về từ ban đầu
        if (word == null || word.isEmpty()) {
            return word;
        }
        // Chuyển chữ cái đầu của từ thành chữ hoa
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
    
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
    
    public static void addCoVanToList(ArrayList<CoVan> coVan) {
        if (!coVan.isEmpty()) {
            coVan.clear();
        }
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM CoVan")) {

            // Lặp qua kết quả từ câu truy vấn
            while (resultSet.next()) {
                // Đọc dữ liệu từ ResultSet
                String maCV = resultSet.getString("MaCoVan").trim();
                String tenCV = resultSet.getString("TenCoVan").trim();
                String khoa = resultSet.getString("Khoa").trim();
                String gioiTinh = resultSet.getBoolean("GioiTinh") ? "true" : "false";
                String ngaySinh = resultSet.getDate("NgaySinh").toString().trim(); // Chuyển ngày thành lập về dạng String
                String sdt = resultSet.getString("Sdt").trim();
                String email = resultSet.getString("Email").trim();
                String queQuan = resultSet.getString("QueQuan").trim();
                String diaChi = resultSet.getString("DiaChi").trim();
                String mk = ""; // Mật khẩu mặc định nếu không tìm thấy
                try (PreparedStatement ps = connection.prepareStatement("SELECT MatKhau FROM TaiKhoan WHERE TenTK = ?")) {
                    ps.setString(1, maCV);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            mk = rs.getString("MatKhau");
                        }
                    }
                }
                
                // Tạo đối tượng Khoa và thêm vào ArrayList
                coVan.add(new CoVan(maCV, tenCV, khoa, gioiTinh, ngaySinh, sdt, email, queQuan, diaChi, mk));
            }
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            //e.printStackTrace();
        }
    }
    
    
    public static void addListToCoVan(ArrayList<CoVan> dsCoVan) {
        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            try (Connection connection = getConnection()) {
                // Xóa hết dữ liệu từ bảng CoVan trước khi chèn
                String deleteQuery = "DELETE FROM CoVan";

                // Tạo đối tượng PreparedStatement và thực hiện lệnh xóa
                PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
                pstmt.executeUpdate();

                // Chuẩn bị câu lệnh SQL cho việc chèn dữ liệu
                String insertQuery = "INSERT INTO CoVan (MaCoVan, TenCoVan, Khoa, GioiTinh, NgaySinh, Sdt, Email, QueQuan, DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                pstmt = connection.prepareStatement(insertQuery);

                // Duyệt qua danh sách và chèn dữ liệu vào cơ sở dữ liệu
                for (CoVan coVan : dsCoVan) {
                    pstmt.setString(1, coVan.getMaCV().trim());
                    pstmt.setString(2, coVan.getTenCV().trim());
                    pstmt.setString(3, coVan.getKhoa().trim());
                    pstmt.setBoolean(4, Boolean.parseBoolean(coVan.getGioiTinh()));
                    pstmt.setString(5, coVan.getNgaySinh().trim());
                    pstmt.setString(6, coVan.getSdt().trim());
                    pstmt.setString(7, coVan.getEmail().trim());
                    pstmt.setString(8, coVan.getQueQuan().trim());
                    pstmt.setString(9, coVan.getDiaChi().trim());

                    // Thực hiện lệnh chèn
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy 
            //ra khi thực hiện truy vấn SQL
            //ex.printStackTrace();
        }
    }
    
    public static String doiBoolToGioiTinh(String text){
        if(text.equals("true")){
            return "Nam";
        }
        else{
            return "Nữ";
        }
    }
    
    public static String doiGioiTinhToBool(String text){
        if(text.equals("Nam")){
            return "true";
        }
        else{
            return "false";
        }
    }
    
    public static String doiMaKhoaThanhTenKhoa(String ma, ArrayList<Khoa> dsKhoa){
        for(Khoa kh:dsKhoa){
            if((kh.getMaKhoa().trim()).equals(ma)){
                return kh.getTenKhoa();
            }
        }
        return "";
    }
    
    public static String doiTenKhoaThanhMaKhoa(String ten, ArrayList<Khoa> dsKhoa){
        for(Khoa kh:dsKhoa){
            if(kh.getTenKhoa().equals(ten)){
                return kh.getMaKhoa();
            }
        }
        return "";
    }
    
    public static String doiMaCVThanhTen(String maCv, ArrayList<CoVan> dsCoVan){
        for(CoVan cv:dsCoVan){
            if(cv.getMaCV().equals(maCv)){
                return cv.getTenCV();
            }
        }
        return "";
    }
    
    public static String doiTenCVThanhMa(String ten, ArrayList<CoVan> dsCoVan){
        for(CoVan cv: dsCoVan){
            if(cv.getTenCV().equals(ten)){
                return cv.getMaCV();
            }
        }
        return "";
    }
    
    
    public static void addChoiceMonths(Choice ch){
        for(int i=1; i<=12; i++){
            ch.add(""+i);
        }
    }
    
    public static void addChoiceDay(Choice ch, int day){
        for(int i=1; i<=day; i++){
            ch.add(""+i);
        }
    }
    
    

    public static void addListCoVanToTable(ArrayList<CoVan> dsCoVan, JTable tableCoVan, ArrayList<Khoa> dsKhoa) {
        DefaultTableModel model = (DefaultTableModel) tableCoVan.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        

        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (int i = 0; i < dsCoVan.size(); i++) {
            CoVan cv = dsCoVan.get(i);

            Object[] row = {Integer.toString(i+1), cv.getMaCV(), cv.getTenCV(), cv.getEmail(), doiMaKhoaThanhTenKhoa(cv.getKhoa(), dsKhoa)};
            model.addRow(row);
        }
    }
    
    public static void addListCoVanToTable_MaKhoa(ArrayList<CoVan> dsCoVan, JTable tableCoVan, ArrayList<Khoa> dsKhoa, String maKhoa) {
        DefaultTableModel model = (DefaultTableModel) tableCoVan.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        
        int k = 0;
        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (int i = 0; i < dsCoVan.size(); i++) {
            if(dsCoVan.get(i).getKhoa().equals(maKhoa)){
                CoVan cv = dsCoVan.get(i);
                k++;
                Object[] row = {Integer.toString(k), cv.getMaCV(), cv.getTenCV(), cv.getEmail(), doiMaKhoaThanhTenKhoa(cv.getKhoa(), dsKhoa)};
                model.addRow(row);
            }            
        }
    }
    
    public static boolean isRepeatMaKhoa(ArrayList<Khoa>dsKhoa, String s){
        for(Khoa khoa: dsKhoa){
            if(khoa.getMaKhoa().equals(s)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isRepeatLop(ArrayList<Lop>dsLop, String s){
        for(Lop lop: dsLop){
            if(lop.getLop().equals(s)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isRepeatMaCoVan(ArrayList<CoVan>dsCoVan, String s){
        for(CoVan ds: dsCoVan){
            if(ds.getMaCV().equals(s)){
                return true;
            }
        }
        return false;
    }
    
    public static void addChoiceKhoa(Choice choice, ArrayList <Khoa> dsKhoa){
        
        choice.removeAll();
        choice.add("Tất cả");
        for(Khoa khoa : dsKhoa){
            choice.add(khoa.getTenKhoa());
        }

        
    }
    
    public static void addChoiceKhoaHoc(Choice choice, ArrayList <KhoaHoc> dsKhoaHoc){
        
        choice.removeAll();
        //choice.add("");
        for(KhoaHoc khoaHoc : dsKhoaHoc){
            choice.add(khoaHoc.getMaKhoaHoc());
        }
    }
    
    public static void addChoiceCoVan(Choice choice, ArrayList <CoVan> dsCoVan){
        
        choice.removeAll();
        //choice.add("");
        for(CoVan coVan : dsCoVan){
            choice.add(coVan.getTenCV());
        }
    }
    
    public static void addChoiceCoVanTheoTen(Choice choice, ArrayList <CoVan> dsCoVan,  ArrayList <Khoa> dsKhoa, String ten){
        
        choice.removeAll();
        //choice.add("");
        for(CoVan coVan : dsCoVan){
            if(Controller.doiMaKhoaThanhTenKhoa(coVan.getKhoa(), dsKhoa).equals(ten)){
                choice.add(coVan.getMaCV());
            } else {
            }
        }

        
    }
    
    public static boolean kiemTraDangNhap(String user, String pass){
        boolean isValid = false;
    
        try {
        // Kết nối tới cơ sở dữ liệu
        Connection con = getConnection();
        
        // Truy vấn kiểm tra tên đăng nhập và mật khẩu
        String query = "SELECT * FROM TaiKhoan WHERE TenTK = ? AND MatKhau = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        
        // Nếu có kết quả trả về, đăng nhập thành công
        if(rs.next()) {
            isValid = true;
        }
        } catch(SQLException e) {
            //e.printStackTrace();
        } 
        return isValid;
    }
    
    public static String getRole(String user){
        String role = null; // Khởi tạo role là null

        try {
            // Truy vấn kiểm tra tên đăng nhập và mật khẩu
            try ( // Kết nối tới cơ sở dữ liệu
                    Connection con = getConnection()) {
                // Truy vấn kiểm tra tên đăng nhập và mật khẩu
                String query = "SELECT LoaiTk FROM TaiKhoan WHERE TenTK = ?";
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setString(1, user);
                    // Lấy giá trị của cột LoaiTk từ ResultSet
                    try (ResultSet rs = ps.executeQuery()) {
                        // Lấy giá trị của cột LoaiTk từ ResultSet
                        if (rs.next()) {
                            role = rs.getString("LoaiTk");
                        }
                        // Đóng các tài nguyên
                    }
                }
            }
        } catch(SQLException e) {
        } 

        // Trả về role
        return role;
    }
    
    public static void addHocKyToList(ArrayList <HocKy> dsHocKy){
        try {
            try ( // Tạo kết nối tới cơ sở dữ liệu và thực hiện truy vấn
                Connection con = Controller.getConnection()) {
                String query = "SELECT * FROM HK_NK";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();
                // Duyệt qua kết quả trả về và thêm vào dsHocKy
                while (rs.next()) {
                    String maHK_NK = rs.getString("MaHK_NK").trim();
                    String hocKy = rs.getString("HocKy").trim();
                    String nienKhoa = rs.getString("NienKhoa").trim();
                    boolean xet = rs.getBoolean("Xet"); // Sử dụng boolean để lưu giá trị Xet
                    // Tạo đối tượng HocKy và thêm vào dsHocKy
                    HocKy hk = new HocKy(maHK_NK, hocKy, nienKhoa, xet ? "Đang xét" : "x");
                    dsHocKy.add(hk);
                }
                // Đóng kết nối
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
            //ex.printStackTrace();
        }
    }
    
    public static void addListHocKyToTable(ArrayList<HocKy> dsHocKy, JTable tableHocKy) {
        DefaultTableModel model = (DefaultTableModel) tableHocKy.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        //String hkxet;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        int i=0;
        for (HocKy hk: dsHocKy) {
            if (hk != null) { // Kiểm tra hk có null không
                
                String HK ;
                if(hk.getHocKy().equals("1")) HK = "I";
                else HK = "II";
                Object[] row = {Integer.toString(i + 1), HK ,hk.getNienKhoa(), hk.getXet()};
                i++;
                model.addRow(row);
            }
        }
    }
    
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
    
    public static void addKhoaHocToList(ArrayList <KhoaHoc> dsKhoaHoc){
        try {
            try ( // Tạo kết nối tới cơ sở dữ liệu và thực hiện truy vấn
                Connection con = Controller.getConnection()) {
                String query = "SELECT * FROM KhoaHoc";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();
                // Duyệt qua kết quả trả về và thêm vào dsHocKy
                while (rs.next()) {
                    String maKhoaHoc = rs.getString("MaKhoaHoc").trim();
                    String namBD = rs.getString("NamBD").trim();
                    String namKT = rs.getString("MamKT").trim();
                    float thoiGian = rs.getFloat("TGHoc"); 
                    // Tạo đối tượng HocKy và thêm vào dsHocKy
                    KhoaHoc kh = new KhoaHoc(maKhoaHoc, namBD, namKT, thoiGian);
                    dsKhoaHoc.add(kh);
                }
                // Đóng kết nối
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
            //ex.printStackTrace();
        }
    }
    
    public static void addListToKhoaHoc(ArrayList <KhoaHoc> dsKhoaHoc){
        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            try (Connection con = Controller.getConnection()) {
                // Xóa hết dữ liệu từ bảng KhoaHoc trước khi chèn
                String deleteQuery = "DELETE FROM KhoaHoc";

                // Tạo đối tượng PreparedStatement và thực hiện lệnh xóa
                PreparedStatement pstmt = con.prepareStatement(deleteQuery);
                pstmt.executeUpdate();

                // Chuẩn bị câu lệnh SQL cho việc chèn dữ liệu
                String insertQuery = "INSERT INTO KhoaHoc (MaKhoaHoc, NamBD, NamKT, TGHoc) VALUES (?, ?, ?, ?)";
                pstmt = con.prepareStatement(insertQuery);

                // Duyệt qua danh sách và chèn dữ liệu vào cơ sở dữ liệu
                for (KhoaHoc kh : dsKhoaHoc) {
                    pstmt.setString(1, kh.getMaKhoaHoc().trim());
                    pstmt.setString(2, kh.getNamBD().trim());
                    pstmt.setString(3, kh.getMamKT().trim());
                    pstmt.setFloat(4, kh.getTGHoc());

                    // Thực hiện lệnh chèn
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
            //ex.printStackTrace();
        }
    }
    
    public static void addListKhoaHocToTable(ArrayList<KhoaHoc> dsKhoaHoc, JTable tableKhoaHoc) {
        DefaultTableModel model = (DefaultTableModel) tableKhoaHoc.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i = 0;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        for (KhoaHoc kh: dsKhoaHoc) {
            if (kh != null) { // Kiểm tra hk có null không

                Object[] row = {Integer.toString(i + 1),kh.getNamBD()+"-"+kh.getMamKT()+"", Float.toString(kh.getTGHoc())};
                i++;
                model.addRow(row);
            }
        }
    }
    
    
    public static void addLopToList(ArrayList <Lop> dsLop){
        try (Connection connection = getConnection()) {
            // Tạo câu truy vấn SQL
            String sql = "SELECT * FROM Lop";

            // Tạo một đối tượng Statement
            try (Statement statement = connection.createStatement()) {
                // Thực thi câu truy vấn SQL
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    // Lặp qua kết quả và thêm dữ liệu vào danh sách dsLop
                    while (resultSet.next()) {
                        String lop = resultSet.getString("Lop").trim();
                        String maKhoa = resultSet.getString("MaKhoa").trim();
                        String maCoVan = resultSet.getString("MaCoVan").trim();
                        String maKhoaHoc = resultSet.getString("MaKhoaHoc").trim();

                        // Tạo một đối tượng Lop và thêm vào danh sách
                        Lop lopObj = new Lop(lop, maKhoa, maCoVan, maKhoaHoc);
                        dsLop.add(lopObj);
                    }
                }
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
    
    public static void addListToLop(ArrayList <Lop> dsLop){
         try (Connection connection = getConnection()) {
            // Xóa hết dữ liệu từ bảng Lop
            String deleteSql = "DELETE FROM Lop";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(deleteSql);
            }
            
            // Chuẩn bị câu lệnh SQL cho việc chèn dữ liệu
            String insertSql = "INSERT INTO Lop (Lop, MaKhoa, MaCoVan, MaKhoaHoc) VALUES (?, ?, ?, ?)";

            // Tạo một PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                // Duyệt qua danh sách và chèn dữ liệu vào cơ sở dữ liệu
                for (Lop lop : dsLop) {
                    preparedStatement.setString(1, lop.getLop().trim());
                    preparedStatement.setString(2, lop.getMaKhoa().trim());
                    preparedStatement.setString(3, lop.getMaCoVan().trim());
                    preparedStatement.setString(4, lop.getMaKhoaHoc().trim());
                    
                    // Thực hiện lệnh chèn
                    preparedStatement.executeUpdate();
                }
                
                //System.out.println("Dữ liệu đã được chèn vào cơ sở dữ liệu sau khi xóa.");
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
    
    public static void addListLopToTable(ArrayList<Lop> dsLop, JTable tableLop, ArrayList<Khoa> dsKhoa, ArrayList<CoVan> dsCoVan) {
        DefaultTableModel model = (DefaultTableModel) tableLop.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i=0;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        for (Lop kh :dsLop) {
            if (kh != null) { // Kiểm tra hk có null không
                String khoa = doiMaKhoaThanhTenKhoa(kh.getMaKhoa(), dsKhoa);
                String coVan = doiMaCVThanhTen(kh.getMaCoVan(), dsCoVan) + " (" + kh.getMaCoVan() + ") ";
                Object[] row = {Integer.toString(i + 1), kh.getLop(), khoa, coVan, kh.getMaKhoaHoc()};
                i++;
                model.addRow(row);
            }
        }
    }
    
    
    
    
    public static void addListLopToTable_Khoa(ArrayList<Lop> dsLop, JTable tableLop, ArrayList<Khoa> dsKhoa, ArrayList<CoVan> dsCoVan, String ten) {
        DefaultTableModel model = (DefaultTableModel) tableLop.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i=0;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        for (Lop kh :dsLop) {
            if (kh != null) { // Kiểm tra hk có null không
                if(ten.equals(kh.getMaKhoa())){
                    String khoa = doiMaKhoaThanhTenKhoa(kh.getMaKhoa(), dsKhoa);
                    String coVan = doiMaCVThanhTen(kh.getMaCoVan(), dsCoVan) + " (" + kh.getMaCoVan() + ") ";
                    Object[] row = {Integer.toString(i + 1), kh.getLop(), khoa, coVan, kh.getMaKhoaHoc()};
                    i++;
                    model.addRow(row);
                }
                
            }
        }
    }
    
    public static void addTieuChiToList(ArrayList<TieuChi> dsTieuChi){
        
        try (Connection conn = getConnection()) {
            // Lấy dữ liệu từ bảng TieuChiDanhGia
            String query = "SELECT MaTieuChi, NoiDung, DiemQD FROM TieuChiDanhGia";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            // Thêm dữ liệu vào danh sách dsTieuChi và dsNoiDung
            while (rs.next()) {
                int i = 0;
                String maTieuChi = rs.getString("MaTieuChi");
                String noiDung = rs.getString("NoiDung");
                int diemQD = rs.getInt("DiemQD");
                
                // Thêm vào danh sách dsTieuChi
                
                ArrayList<NoiDungTieuChi> dsNoiDung = new ArrayList<>();
                // Lấy nội dung từ bảng GiaiThichTieuChi
                //ArrayList<String> noiDungList = new ArrayList<>();
                query = "SELECT NoiDung, DiemQD FROM GiaiThichTieuChi WHERE MaTieuChi = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, maTieuChi);
                ResultSet rsNoiDung = pstmt.executeQuery();
                // Thêm vào danh sách dsNoiDung
                while (rsNoiDung.next()) {
                    //noiDungList.add(rsNoiDung.getString("NoiDung"));
                    String giaiThich = rsNoiDung.getString("NoiDung");
                    int diemGiaiThich = rsNoiDung.getInt("DiemQD");
                    dsNoiDung.add(new NoiDungTieuChi(giaiThich, diemGiaiThich));
                }
                dsTieuChi.add(new TieuChi(maTieuChi, noiDung, diemQD, dsNoiDung));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveTieuChiToDatabase(ArrayList<TieuChi> dsTieuChi) {
        try (Connection conn = getConnection()) {
            // Xóa dữ liệu cũ trong bảng GiaiThichTieuChi để chuẩn bị cho việc thêm mới
            String deleteQuery = "DELETE FROM GiaiThichTieuChi";
            PreparedStatement deletePstmt = conn.prepareStatement(deleteQuery);
            deletePstmt.executeUpdate();

            // Xóa dữ liệu cũ trong bảng TieuChiDanhGia để chuẩn bị cho việc thêm mới
            deleteQuery = "DELETE FROM TieuChiDanhGia";
            deletePstmt = conn.prepareStatement(deleteQuery);
            deletePstmt.executeUpdate();

            // Thêm dữ liệu mới vào bảng TieuChiDanhGia và GiaiThichTieuChi
            for (TieuChi tieuChi : dsTieuChi) {
                // Thêm dữ liệu vào bảng TieuChiDanhGia
                String insertTieuChiQuery = "INSERT INTO TieuChiDanhGia (MaTieuChi, NoiDung, DiemQD) VALUES (?, ?, ?)";
                PreparedStatement insertTieuChiPstmt = conn.prepareStatement(insertTieuChiQuery);
                insertTieuChiPstmt.setString(1, tieuChi.getMaTieuChi());
                insertTieuChiPstmt.setString(2, tieuChi.getNoiDung());
                insertTieuChiPstmt.setInt(3, tieuChi.getDiem());
                insertTieuChiPstmt.executeUpdate();

                // Thêm dữ liệu vào bảng GiaiThichTieuChi
                for (NoiDungTieuChi noiDung : tieuChi.getDsNoiDung()) {
                    String insertGiaiThichQuery = "INSERT INTO GiaiThichTieuChi (MaTieuChi, NoiDung, DiemQD) VALUES (?, ?, ?)";
                    PreparedStatement insertGiaiThichPstmt = conn.prepareStatement(insertGiaiThichQuery);
                    insertGiaiThichPstmt.setString(1, tieuChi.getMaTieuChi());
                    insertGiaiThichPstmt.setString(2, noiDung.getNoiDung());
                    insertGiaiThichPstmt.setInt(3, noiDung.getDiem());
                    insertGiaiThichPstmt.executeUpdate();
                }
            }
            System.out.println("Dữ liệu đã được lưu vào cơ sở dữ liệu.");
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
    
    public static void addListTieuChiToTable(ArrayList<TieuChi> dsTieuChi, JTable tableTieuChi) {
        DefaultTableModel model = (DefaultTableModel) tableTieuChi.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i = 0;
        // Duyệt qua danh sách các tiêu chí và thêm vào bảng
        for (TieuChi tieuChi : dsTieuChi) {
            if (tieuChi != null) { // Kiểm tra tiêu chí có null không
                Object[] row = {Integer.toString(i + 1), tieuChi.getNoiDung(), tieuChi.getDiem()};
                i++;
                model.addRow(row);
            }
        }
    }
    
}
