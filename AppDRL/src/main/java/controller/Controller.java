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
import models.Khoa;

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
                String maKhoa = resultSet.getString("MaKhoa");
                String tenKhoa = resultSet.getString("TenKhoa");
                String ngayThanhLap = resultSet.getDate("NgayThanhLap").toString(); // Chuyển ngày thành lập về dạng String

                String mk = ""; // Mật khẩu mặc định nếu không tìm thấy
                try (PreparedStatement ps = connection.prepareStatement("SELECT MatKhau FROM TaiKhoan WHERE TenTK = ?")) {
                    ps.setString(1, maKhoa);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            mk = rs.getString("MatKhau");
                        }
                    }
                }
                
                //mk = changePass(mk);

                // Tạo đối tượng Khoa và thêm vào ArrayList
                khoa.add(new Khoa(maKhoa, tenKhoa, ngayThanhLap, mk));
            }
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            //e.printStackTrace();
        }
    }
    
    public static void addListKhoaToTable(ArrayList<Khoa> dsKhoa, JTable tableKhoa) {
        DefaultTableModel model = (DefaultTableModel) tableKhoa.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);

        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (int i = 0; i < dsKhoa.size(); i++) {
            Khoa khoa = dsKhoa.get(i);
            Object[] row = {khoa.getMaKhoa(), khoa.getTenKhoa(), khoa.getNgayThanhLap(), khoa.getMaKhoa() ,Controller.changePass(khoa.getMk())};
            model.addRow(row);
        }
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
                String maCV = resultSet.getString("MaCoVan");
                String tenCV = resultSet.getString("TenCoVan");
                String khoa = resultSet.getString("Khoa");
                String gioiTinh = resultSet.getBoolean("GioiTinh") ? "true" : "false";
                String ngaySinh = resultSet.getDate("NgaySinh").toString(); // Chuyển ngày thành lập về dạng String
                String sdt = resultSet.getString("Sdt");
                String email = resultSet.getString("Email");
                String queQuan = resultSet.getString("QueQuan");
                String diaChi = resultSet.getString("DiaCHi");
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
        for(int i=0; i<dsKhoa.size(); i++){
            if(dsKhoa.get(i).getMaKhoa().equals(ma)){
                return dsKhoa.get(i).getTenKhoa();
            }
        }
        return "";
    }
    
    public static String doiTenKhoaThanhMaKhoa(String ten, ArrayList<Khoa> dsKhoa){
        for(int i=0; i<dsKhoa.size(); i++){
            if(dsKhoa.get(i).getTenKhoa().equals(ten)){
                return dsKhoa.get(i).getMaKhoa();
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

            Object[] row = {cv.getMaCV(), cv.getTenCV(), cv.getEmail(), doiMaKhoaThanhTenKhoa(cv.getKhoa(), dsKhoa) ,changePass(cv.getMk())};
            model.addRow(row);
        }
    }
    
    public static void addListCoVanToTable_MaKhoa(ArrayList<CoVan> dsCoVan, JTable tableCoVan, ArrayList<Khoa> dsKhoa, String maKhoa) {
        DefaultTableModel model = (DefaultTableModel) tableCoVan.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        

        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (int i = 0; i < dsCoVan.size(); i++) {
            if(dsCoVan.get(i).getKhoa().equals(maKhoa)){
                CoVan cv = dsCoVan.get(i);

                Object[] row = {cv.getMaCV(), cv.getTenCV(), cv.getEmail(), doiMaKhoaThanhTenKhoa(cv.getKhoa(), dsKhoa) ,changePass(cv.getMk())};
                model.addRow(row);
            }            
        }
    }
    
    public static void addChoiceKhoa(Choice choice, ArrayList <Khoa> dsKhoa){
        
        choice.removeAll();
        choice.add("Tất cả");
        for(int i=0; i<dsKhoa.size(); i++){
            choice.add(dsKhoa.get(i).getTenKhoa());
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

}
