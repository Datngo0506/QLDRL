/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
                
                mk = changePass(mk);

                // Tạo đối tượng Khoa và thêm vào ArrayList
                khoa.add(new Khoa(maKhoa, tenKhoa, ngayThanhLap, mk));
            }
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
        }
    }
    
        public static void addListKhoaToTable(ArrayList<Khoa> dsKhoa, JTable tableKhoa) {
            DefaultTableModel model = (DefaultTableModel) tableKhoa.getModel();

            // Xóa dữ liệu cũ trong bảng
            model.setRowCount(0);

            // Duyệt qua danh sách các khoa và thêm vào bảng
            for (int i = 0; i < dsKhoa.size(); i++) {
                Khoa khoa = dsKhoa.get(i);
                Object[] row = {khoa.getMaKhoa(), khoa.getTenKhoa(), khoa.getNgayThanhLap(), khoa.getMaKhoa() ,khoa.getMk()};
                model.addRow(row);
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
