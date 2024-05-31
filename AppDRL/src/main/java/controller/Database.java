/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.ChucVu;
import models.CoVan;
import models.DRL;
import models.HocKy;
import models.Khoa;
import models.KhoaHoc;
import models.Lop;
import models.NoiDungTieuChi;
import models.SinhVien;
import models.TaiKhoan;
import models.ThongBao;
import models.TieuChi;

/**
 *
 * @author Dat
 */
public class Database {
    public static Connection getConnection(){
        
        String url = "jdbc:sqlserver://localhost;databaseName=QLDRL;user=sa;password=123;encrypt=true;trustServerCertificate=true;";
        Connection con = null;        
        try {
            con = DriverManager.getConnection(url);
            //System.out.println("Thanh cong");
            
        }
        catch (SQLException e) {
            System.out.println("Khong the ket noi den CSDL \n" );
        }
        return con;
    }
    
    public static void saveTaiKhoanToList(ArrayList<TaiKhoan> dsTaiKhoan){
        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM TaiKhoan");
                 ResultSet resultSet = statement.executeQuery()) {

                // Duyệt qua kết quả từ câu truy vấn
                while (resultSet.next()) {
                    // Đọc dữ liệu từ ResultSet
                    String tenTK = resultSet.getString("TenTK").trim();
                    String matKhau = resultSet.getString("MatKhau").trim();
                    String loaiTK = resultSet.getString("LoaiTK").trim();
                    boolean trangThai = resultSet.getBoolean("TrangThai");
                    //System.out.println(trangThai);
                    
                    TaiKhoan tk = new TaiKhoan();
                    tk.setMatKhau(matKhau);
                    tk.setTenTK(tenTK);
                    tk.setLoaiTK(loaiTK);
                    tk.setTrangThai(trangThai);
                    //System.out.println(tk.isTrangThai());
                    
                    // Tạo đối tượng TaiKhoan và thêm vào ArrayList
                    dsTaiKhoan.add(tk);
                }
            }
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            //e.printStackTrace();
        }
    }
    
    public static void saveListTaiKhoanToDB(ArrayList<TaiKhoan> dsTaiKhoan){
        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            try (Connection connection = getConnection()) {
                // Xóa hết dữ liệu từ bảng TaiKhoan trước khi chèn
                String deleteQuery = "DELETE FROM TaiKhoan";

                // Tạo đối tượng PreparedStatement và thực hiện lệnh xóa
                PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
                pstmt.executeUpdate();

                // Chuẩn bị câu lệnh SQL cho việc chèn dữ liệu
                String insertQuery = "INSERT INTO TaiKhoan (TenTK, MatKhau, LoaiTK, TrangThai) VALUES (?, ?, ?, ?)";
                pstmt = connection.prepareStatement(insertQuery);

                // Duyệt qua danh sách và chèn dữ liệu vào cơ sở dữ liệu
                for (TaiKhoan taiKhoan : dsTaiKhoan) {
                    pstmt.setString(1, taiKhoan.getTenTK().trim());
                    pstmt.setString(2, taiKhoan.getMatKhau().trim());
                    pstmt.setString(3, taiKhoan.getLoaiTK().trim());
                    pstmt.setBoolean(4, taiKhoan.isTrangThai());
                    // Thực hiện lệnh chèn
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
            //ex.printStackTrace();
        }
    }
    
    public static void updateMatKhau(String tenDN, String newMatKhau) {
    try {
        // Thực hiện kết nối đến cơ sở dữ liệu
        try (Connection connection = getConnection()) {
            // Chuẩn bị câu lệnh SQL cho việc cập nhật mật khẩu
            String updateQuery = "UPDATE TaiKhoan SET MatKhau = ? WHERE TenTK = ?";

            // Tạo đối tượng PreparedStatement và thực hiện lệnh cập nhật
            PreparedStatement pstmt = connection.prepareStatement(updateQuery);
            pstmt.setString(1, newMatKhau.trim());
            pstmt.setString(2, tenDN.trim());
            
            // Thực hiện lệnh cập nhật
            pstmt.executeUpdate();
        }
    } catch (SQLException ex) {
        // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
        //ex.printStackTrace();
    }
}
    
    
    public static void saveKhoaToList(ArrayList<Khoa> khoa) {
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
                String tenKhoa = resultSet.getString("TenKhoa");
                String ngayThanhLap = resultSet.getDate("NgayThanhLap").toString(); // Chuyển ngày thành lập về dạng String

                khoa.add(new Khoa(maKhoa, tenKhoa, ngayThanhLap));
            }
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            //e.printStackTrace();
        }
    }
    
    public static void saveListKhoaToDB(ArrayList<Khoa> dsKhoa) {
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
                    pstmt.setString(2, khoa.getTenKhoa());
                    pstmt.setString(3, khoa.getNgayThanhLap());

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

        Object[] row = {khoa.getMaKhoa(), khoa.getTenKhoa(), khoa.getNgayThanhLap(), khoa.getMaKhoa() ,ThuatToan.anMatKhau(ThuatToan.getMatKhau(dsTaiKhoan, khoa.getMaKhoa()))};
        model.addRow(row);
        //System.out.println(Controller.changePass(Controller.getMatKhau(dsTaiKhoan, khoa.getMaKhoa())));
    }
    
    public static void addListKhoaToTable(ArrayList<Khoa> dsKhoa, JTable tableKhoa, ArrayList<TaiKhoan> dsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tableKhoa.getModel();
        ThuatToan.sapXepTheoMaKhoa(dsKhoa);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);

        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (Khoa khoa: dsKhoa) {
            Object[] row = {khoa.getMaKhoa(), khoa.getTenKhoa(), khoa.getNgayThanhLap(), khoa.getMaKhoa() ,ThuatToan.getTrangThai(dsTaiKhoan, khoa.getMaKhoa())};
            model.addRow(row);
        }
    }
    public static void saveCoVanToList(ArrayList<CoVan> coVan) {
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
                String tenCV = resultSet.getString("TenCoVan");
                String khoa = resultSet.getString("Khoa").trim();
                String gioiTinh = resultSet.getBoolean("GioiTinh") ? "true" : "false";
                String ngaySinh = resultSet.getDate("NgaySinh").toString().trim(); // Chuyển ngày thành lập về dạng String
                String sdt = resultSet.getString("Sdt").trim();
                String email = resultSet.getString("Email");
                String queQuan = resultSet.getString("QueQuan");
                String diaChi = resultSet.getString("DiaChi");
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
    
    
    public static void saveListCoVanToDB(ArrayList<CoVan> dsCoVan) {
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
                    pstmt.setString(2, coVan.getTenCV());
                    pstmt.setString(3, coVan.getKhoa().trim());
                    pstmt.setBoolean(4, Boolean.parseBoolean(coVan.getGioiTinh()));
                    pstmt.setString(5, coVan.getNgaySinh().trim());
                    pstmt.setString(6, coVan.getSdt());
                    pstmt.setString(7, coVan.getEmail());
                    pstmt.setString(8, coVan.getQueQuan());
                    pstmt.setString(9, coVan.getDiaChi());

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
    
    
    
    

    public static void addListCoVanToTable(ArrayList<CoVan> dsCoVan, JTable tableCoVan, ArrayList<Khoa> dsKhoa, ArrayList<TaiKhoan> dsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tableCoVan.getModel();
        ThuatToan.sapXepTheoCoVan(dsCoVan);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        

        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (int i = 0; i < dsCoVan.size(); i++) {
            CoVan cv = dsCoVan.get(i);

            Object[] row = {Integer.toString(i+1), cv.getMaCV(), cv.getTenCV(), cv.getEmail().toLowerCase(), 
                ThuatToan.doiMaKhoaThanhTenKhoa(cv.getKhoa(), dsKhoa), ThuatToan.getTrangThai(dsTaiKhoan, cv.getMaCV())};
            model.addRow(row);
        }
    }
    
    public static void addListCoVanToTable_1Khoa(ArrayList<CoVan> dsCoVan, JTable tableCoVan, String maKhoa, String tenKhoa, ArrayList<TaiKhoan> dsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tableCoVan.getModel();
        ThuatToan.sapXepTheoCoVan(dsCoVan);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        
        int k = 0;
        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (int i = 0; i < dsCoVan.size(); i++) {
            if(dsCoVan.get(i).getKhoa().equals(maKhoa)){
                CoVan cv = dsCoVan.get(i);
                k++;
                Object[] row = {Integer.toString(k), cv.getMaCV(), cv.getTenCV(), cv.getEmail().toLowerCase(), tenKhoa, ThuatToan.getTrangThai(dsTaiKhoan, cv.getMaCV())};
                model.addRow(row);
            }            
        }
    }
    
    public static void addListCoVanToTable_MaKhoa(ArrayList<CoVan> dsCoVan, JTable tableCoVan, ArrayList<Khoa> dsKhoa, String maKhoa, ArrayList<TaiKhoan> dsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tableCoVan.getModel();
        ThuatToan.sapXepTheoCoVan(dsCoVan);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        
        int k = 0;
        // Duyệt qua danh sách các khoa và thêm vào bảng
        for (int i = 0; i < dsCoVan.size(); i++) {
            if(dsCoVan.get(i).getKhoa().equals(maKhoa)){
                CoVan cv = dsCoVan.get(i);
                k++;
                Object[] row = {Integer.toString(k), cv.getMaCV(), cv.getTenCV(), cv.getEmail(), 
                    ThuatToan.doiMaKhoaThanhTenKhoa(cv.getKhoa(), dsKhoa), ThuatToan.getTrangThai(dsTaiKhoan, cv.getMaCV())};
                model.addRow(row);
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
        ps.setString(1, user.trim());
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
    
    public static void saveHocKyToList(ArrayList <HocKy> dsHocKy){
        try {
            try ( // Tạo kết nối tới cơ sở dữ liệu và thực hiện truy vấn
                Connection con = Database.getConnection()) {
                String query = "SELECT * FROM HK_NK";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();
                // Duyệt qua kết quả trả về và thêm vào dsHocKy
                while (rs.next()) {
                    String maHK_NK = rs.getString("MaHK_NK").trim();
                    String hocKy = rs.getString("HocKy");
                    String nienKhoa = rs.getString("NienKhoa");
                    boolean xet = rs.getBoolean("Xet"); // Sử dụng boolean để lưu giá trị Xet
                    // Tạo đối tượng HocKy và thêm vào dsHocKy
                    HocKy hk = new HocKy(maHK_NK, hocKy, nienKhoa, xet );
                    dsHocKy.add(hk);
                }
                // Đóng kết nối
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
            //ex.printStackTrace();
        }
    }
    
    public static void saveListHocKyToDB(ArrayList<HocKy> dsHocKy) {
        try {
            try (Connection con = Database.getConnection()) {
                // Xóa hết dữ liệu trong bảng
                String deleteQuery = "DELETE FROM HK_NK";
                PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
                deleteStmt.executeUpdate();

                // Thêm từng đối tượng từ danh sách vào cơ sở dữ liệu
                String insertQuery = "INSERT INTO HK_NK (MaHK_NK, HocKy, NienKhoa, Xet) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = con.prepareStatement(insertQuery);
                for (HocKy hk : dsHocKy) {
                    insertStmt.setString(1, hk.getMaHK_NK());
                    insertStmt.setString(2, hk.getHocKy());
                    insertStmt.setString(3, hk.getNienKhoa());
                    insertStmt.setBoolean(4, hk.getXet());
                    insertStmt.executeUpdate();
                }
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
        int k=0;
        for (int i=dsHocKy.size()-1;i>=0; i--) {
            HocKy hk = dsHocKy.get(i);
            if (hk != null) { // Kiểm tra hk có null không
                
                String HK ;
                if(hk.getHocKy().equals("1")) HK = "I";
                else HK = "II";
                String xet;
                if(hk.getXet() == true){
                    xet = "Đang diễn ra";
                } else xet = "x";
                Object[] row = {Integer.toString(k + 1), HK ,hk.getNienKhoa(), xet};
                k++;
                model.addRow(row);
                
            }
        }
    }
 
    public static void saveKhoaHocToList(ArrayList <KhoaHoc> dsKhoaHoc){
        try {
            try ( // Tạo kết nối tới cơ sở dữ liệu và thực hiện truy vấn
                Connection con = Database.getConnection()) {
                String query = "SELECT * FROM KhoaHoc";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();
                // Duyệt qua kết quả trả về và thêm vào dsHocKy
                while (rs.next()) {
                    String maKhoaHoc = rs.getString("MaKhoaHoc").trim();
                    String namBD = rs.getString("NamBD");
                    String namKT = rs.getString("MamKT");
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
    
    public static void saveListKhoaHocToDB(ArrayList <KhoaHoc> dsKhoaHoc){
        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            try (Connection con = Database.getConnection()) {
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
                    pstmt.setString(2, kh.getNamBD());
                    pstmt.setString(3, kh.getMamKT());
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
        int k=0;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        for (int i= dsKhoaHoc.size()-1; i>=0; i--) {
            KhoaHoc kh = dsKhoaHoc.get(i);
            if (kh != null) { // Kiểm tra hk có null không

                Object[] row = {Integer.toString(k + 1),kh.getNamBD()+"-"+kh.getMamKT()+"", Float.toString(kh.getTGHoc())};
                k++;
                model.addRow(row);
            }
        }
    }
    
    
    public static void saveLopToList(ArrayList <Lop> dsLop){
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
    
    public static void saveListLopToDB(ArrayList <Lop> dsLop){
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
    
    public static void addListLopToTable_HKXet(ArrayList<Lop> dsLop, JTable tableLop, ArrayList<Khoa> dsKhoa, ArrayList<CoVan> dsCoVan, ArrayList<HocKy> dsHocKy, ArrayList<KhoaHoc>dsKhoaHoc) {
        DefaultTableModel model = (DefaultTableModel) tableLop.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i=0;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        
        for (Lop kh :dsLop) {
            if (kh != null) { // Kiểm tra hk có null không
                String khoaHoc = kh.getMaKhoaHoc();
                String parts[] = khoaHoc.split("-");
                String hkDau = parts[0]+"-"+(Integer.parseInt(parts[0])+1)+"-1";
                float soNamHoc = ThuatToan.getSoNamHoc(dsKhoaHoc, kh.getMaKhoaHoc());
                String hkCuoi = ThuatToan.doiKhoaHocSangHKCuoi(khoaHoc, soNamHoc);
                String hkHienTai = ThuatToan.getHKXet(dsHocKy);
                if(ThuatToan.soSanhHocKy(hkHienTai, hkDau) >=0 && ThuatToan.soSanhHocKy(hkHienTai, hkCuoi) <=0){
                    String khoa = ThuatToan.doiMaKhoaThanhTenKhoa(kh.getMaKhoa(), dsKhoa);
                
                    String coVan = ThuatToan.doiMaCVThanhTen(kh.getMaCoVan(), dsCoVan) + " (" + kh.getMaCoVan() + ") ";
                    if(kh.getMaCoVan().equals(" ") || kh.getMaCoVan().equals("") ) coVan = " ";
                    Object[] row = {Integer.toString(i + 1), kh.getLop(), khoa, coVan, kh.getMaKhoaHoc()};
                    i++;
                    model.addRow(row);
                }
                
            }
        }
    }
    
    public static void addListLopToTable_HKXet_Khoa(ArrayList<Lop> dsLop, JTable tableLop, ArrayList<Khoa> dsKhoa, ArrayList<CoVan> dsCoVan, ArrayList<HocKy> dsHocKy, String tenKhoa, ArrayList<KhoaHoc>dsKhoaHoc) {
        DefaultTableModel model = (DefaultTableModel) tableLop.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i=0;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        
        for (Lop kh :dsLop) {
            if (kh != null) { // Kiểm tra hk có null không
                String khoaHoc = kh.getMaKhoaHoc();
                String parts[] = khoaHoc.split("-");
                String hkDau = parts[0]+"-"+(Integer.parseInt(parts[0])+1)+"-1";
                float soNamHoc = ThuatToan.getSoNamHoc(dsKhoaHoc, kh.getMaKhoaHoc());
                String hkCuoi = ThuatToan.doiKhoaHocSangHKCuoi(khoaHoc, soNamHoc);
                String hkHienTai = ThuatToan.getHKXet(dsHocKy);
                if(ThuatToan.soSanhHocKy(hkHienTai, hkDau) >=0 && ThuatToan.soSanhHocKy(hkHienTai, hkCuoi) <=0 && kh.getMaKhoa().equals(ThuatToan.doiTenKhoaThanhMaKhoa(tenKhoa, dsKhoa))){
                    String khoa = ThuatToan.doiMaKhoaThanhTenKhoa(kh.getMaKhoa(), dsKhoa);
                
                    String coVan = ThuatToan.doiMaCVThanhTen(kh.getMaCoVan(), dsCoVan) + " (" + kh.getMaCoVan() + ") ";
                    if(kh.getMaCoVan().equals(" ") || kh.getMaCoVan().equals("") ) coVan = " ";
                    Object[] row = {Integer.toString(i + 1), kh.getLop(), khoa, coVan, kh.getMaKhoaHoc()};
                    i++;
                    model.addRow(row);
                }
                
            }
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
                String khoa = ThuatToan.doiMaKhoaThanhTenKhoa(kh.getMaKhoa(), dsKhoa);
                
                String coVan = ThuatToan.doiMaCVThanhTen(kh.getMaCoVan(), dsCoVan) + " (" + kh.getMaCoVan() + ") ";
                if(kh.getMaCoVan().equals(" ") || kh.getMaCoVan().equals("") ) coVan = " ";
                Object[] row = {Integer.toString(i + 1), kh.getLop(), khoa, coVan, kh.getMaKhoaHoc()};
                i++;
                model.addRow(row);
            }
        }
    }
    
    
    public static void addListLopToTable_1Khoa(ArrayList<Lop> dsLop, JTable tableLop, String maKhoa, String tenKhoa, ArrayList<CoVan> dsCoVan) {
        DefaultTableModel model = (DefaultTableModel) tableLop.getModel();
        ThuatToan.sapXepTheoLop(dsLop);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i=0;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        
        for (Lop kh :dsLop) {
            if (kh != null) { // Kiểm tra hk có null không
                if(kh.getMaKhoa().equals(maKhoa)){
                    String coVan = ThuatToan.doiMaCVThanhTen(kh.getMaCoVan(), dsCoVan) + " (" + kh.getMaCoVan() + ") ";
                    if(kh.getMaCoVan().equals(" ") || kh.getMaCoVan().equals("") ) coVan = " ";
                    Object[] row = {Integer.toString(i + 1), kh.getLop(), tenKhoa, coVan, kh.getMaKhoaHoc()};
                    i++;
                    model.addRow(row);
                }
            }
        }
    }
    
    
    
    public static void addListLopToTable_Khoa(ArrayList<Lop> dsLop, JTable tableLop, ArrayList<Khoa> dsKhoa, ArrayList<CoVan> dsCoVan, String ten) {
        DefaultTableModel model = (DefaultTableModel) tableLop.getModel();
        ThuatToan.sapXepTheoLop(dsLop);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i=0;
        // Duyệt qua danh sách các học kỳ và thêm vào bảng
        for (Lop kh :dsLop) {
            if (kh != null) { // Kiểm tra hk có null không
                if(ten.equals(kh.getMaKhoa())){
                    String khoa = ThuatToan.doiMaKhoaThanhTenKhoa(kh.getMaKhoa(), dsKhoa);
                    String coVan = ThuatToan.doiMaCVThanhTen(kh.getMaCoVan(), dsCoVan) + " (" + kh.getMaCoVan() + ") ";
                    Object[] row = {Integer.toString(i + 1), kh.getLop(), khoa, coVan, kh.getMaKhoaHoc()};
                    i++;
                    model.addRow(row);
                }
                
            }
        }
    }
    
    public static void saveTieuChiToList(ArrayList<TieuChi> dsTieuChi){
        
        try (Connection conn = getConnection()) {
            // Lấy dữ liệu từ bảng TieuChiDanhGia
            String query = "SELECT MaTieuChi, NoiDung, DiemQD FROM TieuChiDanhGia";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            // Thêm dữ liệu vào danh sách dsTieuChi và dsNoiDung
            while (rs.next()) {
                int i = 0;
                String maTieuChi = rs.getString("MaTieuChi").trim();
                String noiDung = rs.getString("NoiDung");
                int diemQD = rs.getInt("DiemQD");
                if (rs.wasNull()) {
                    diemQD = -50; // Nếu là NULL, gán điểm mặc định là -50
                }
                
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
                    if (rsNoiDung.wasNull()) {
                        diemGiaiThich = -50; // Nếu là NULL, gán điểm mặc định là -50
                    }
                    dsNoiDung.add(new NoiDungTieuChi(giaiThich, diemGiaiThich));
                }
                dsTieuChi.add(new TieuChi(maTieuChi, noiDung, diemQD, dsNoiDung));
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
    

    
    public static void saveTieuChiToDB(ArrayList<TieuChi> dsTieuChi) {
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
                insertTieuChiPstmt.setString(1, tieuChi.getMaTieuChi().trim());
                insertTieuChiPstmt.setString(2, tieuChi.getNoiDung());
                insertTieuChiPstmt.setInt(3, tieuChi.getDiem());
                insertTieuChiPstmt.executeUpdate();
                if(!tieuChi.getDsNoiDung().isEmpty()){
                    // Thêm dữ liệu vào bảng GiaiThichTieuChi
                    for (NoiDungTieuChi noiDung : tieuChi.getDsNoiDung()) {
                        String insertGiaiThichQuery = "INSERT INTO GiaiThichTieuChi (MaTieuChi, NoiDung, DiemQD) VALUES (?, ?, ?)";
                        PreparedStatement insertGiaiThichPstmt = conn.prepareStatement(insertGiaiThichQuery);
                        insertGiaiThichPstmt.setString(1, tieuChi.getMaTieuChi().trim());
                        insertGiaiThichPstmt.setString(2, noiDung.getNoiDung());
                        insertGiaiThichPstmt.setInt(3, noiDung.getDiem());
                        insertGiaiThichPstmt.executeUpdate();
                    }
                }
                
            }
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
            String s ;
            if (tieuChi != null) { // Kiểm tra tiêu chí có null không
                if(tieuChi.getDiem() == -50){
                    s = "";
                }
                else{
                    s = Integer.toString(tieuChi.getDiem());
                }
                Object[] row = {Integer.toString(i + 1), tieuChi.getNoiDung(), s};
                i++;
                model.addRow(row);
            }
        }
    }
    
    public static void addListTieuChiToTable_Cham(ArrayList<TieuChi> dsTieuChi, JTable tableTieuChi) {
        DefaultTableModel model = (DefaultTableModel) tableTieuChi.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i = 0;
        // Duyệt qua danh sách các tiêu chí và thêm vào bảng
        for (TieuChi tieuChi : dsTieuChi) {
            String s ;
            if (tieuChi != null) { // Kiểm tra tiêu chí có null không
                if(tieuChi.getDiem() == -50){
                    s = "";
                }
                else{
                    s = Integer.toString(tieuChi.getDiem());
                }
                Object[] row = {Integer.toString(i + 1), tieuChi.getNoiDung(), s, ""};
                i++;
                model.addRow(row);
            }
        }
    }
    
    public static void addListGiaiThichToTable(ArrayList<NoiDungTieuChi> dsNoiDung, JTable tableND) {
        DefaultTableModel model = (DefaultTableModel) tableND.getModel();

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        // Duyệt qua danh sách các tiêu chí và thêm vào bảng
        for (NoiDungTieuChi nd : dsNoiDung) {
            if (nd != null) { // Kiểm tra tiêu chí có null không
                String s;
                if(nd.getDiem() == -50){
                    s = "";
                }
                else{
                    s = Integer.toString(nd.getDiem());
                }
                Object[] row = { nd.getNoiDung(), s};
                
                model.addRow(row);
            }
        }
    }
    
    public static void saveSinhVienToList(ArrayList<SinhVien> dsSinhVien){
        try (Connection connection = getConnection()) {
            // Chuẩn bị truy vấn SQL
            String sql = "SELECT * FROM SinhVien";
            // Tạo một đối tượng PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Thực hiện truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Duyệt qua các dòng kết quả và thêm sinh viên vào danh sách
            while (resultSet.next()) {
                // Lấy thông tin từ cột trong kết quả
                String maSV = resultSet.getString("MSSV").trim();
                String hoTen = resultSet.getString("HoTen");
                String lop = resultSet.getString("Lop").trim();
                String chucVu = resultSet.getString("ChucVu").trim();
                String sdt = resultSet.getString("Sdt").trim();
                String email = resultSet.getString("Email");
                String ngaySinh = resultSet.getString("NgaySinh");
                String queQuan = resultSet.getString("QueQuan");
                String diaChi = resultSet.getString("DiaChi");
                boolean gioiTinh = resultSet.getBoolean("GioiTinh");
                // Tạo đối tượng SinhVien từ thông tin lấy được và thêm vào danh sách
                SinhVien sinhVien = new SinhVien(maSV, hoTen, lop, chucVu, sdt, email, ngaySinh, queQuan, diaChi, gioiTinh);
                dsSinhVien.add(sinhVien);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            // Xử lý ngoại lệ nếu có lỗi trong quá trình kết nối hoặc truy vấn cơ sở dữ liệu
        }
    } 
    
    
    public static void saveListSinhVienToDB(ArrayList<SinhVien> dsSinhVien){
        try (Connection connection = getConnection()) {
        // Xóa hết dữ liệu trong bảng SinhVien trước khi thêm dữ liệu mới
        String sqlDelete = "DELETE FROM SinhVien";
        PreparedStatement statementDelete = connection.prepareStatement(sqlDelete);
        statementDelete.executeUpdate();

        // Chuẩn bị truy vấn SQL để chèn dữ liệu vào bảng SinhVien
        String sqlInsert = "INSERT INTO SinhVien (MSSV, HoTen, Lop, ChucVu, Sdt, Email, NgaySinh, QueQuan, DiaChi, GioiTinh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // Tạo một đối tượng PreparedStatement
        PreparedStatement statementInsert = connection.prepareStatement(sqlInsert);

        // Duyệt qua từng sinh viên trong danh sách để chèn dữ liệu vào bảng
        for (SinhVien sinhVien : dsSinhVien) {
            // Thiết lập các tham số cho truy vấn
            statementInsert.setString(1, sinhVien.getMaSV().trim());
            statementInsert.setString(2, sinhVien.getHoTen());
            statementInsert.setString(3, sinhVien.getLop().trim());
            statementInsert.setString(4, sinhVien.getChucVu().trim());
            statementInsert.setString(5, sinhVien.getSdt());
            statementInsert.setString(6, sinhVien.getEmail());
            statementInsert.setString(7, sinhVien.getNgaySinh());
            statementInsert.setString(8, sinhVien.getQueQuan());
            statementInsert.setString(9, sinhVien.getDiaChi());
            statementInsert.setBoolean(10, sinhVien.isGioiTinh());

            // Thực hiện truy vấn chèn dữ liệu
            statementInsert.executeUpdate();
        }
        } catch (SQLException e) {
                // Xử lý ngoại lệ nếu có lỗi trong quá trình kết nối hoặc thực hiện truy vấn
                System.out.println("Error: " + e.getMessage());

        }
    }
    
    public static void saveChucVuToList(ArrayList<ChucVu> dsChucVu){
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM ChucVu";
            // Tạo một đối tượng PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Thực hiện truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Duyệt qua các dòng kết quả và thêm chức vụ vào danh sách
            while (resultSet.next()) {
                // Lấy thông tin từ cột trong kết quả
                String maChucVu = resultSet.getString("maChucVu").trim();
                String tenChucVu = resultSet.getString("tenChucVu");

                // Tạo đối tượng ChucVu từ thông tin lấy được và thêm vào danh sách
                ChucVu chucVu = new ChucVu(maChucVu, tenChucVu);
                dsChucVu.add(chucVu);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            // Xử lý ngoại lệ nếu có lỗi trong quá trình kết nối hoặc truy vấn cơ sở dữ liệu
        }
    }
    
    public static void saveListChucVuToDB(ArrayList<ChucVu> dsChucVu){
        try (Connection connection = getConnection()) {
            // Chuẩn bị truy vấn SQL để chèn dữ liệu vào bảng ChucVu
            String sql = "INSERT INTO ChucVu (maChucVu, tenChucVu) VALUES (?, ?)";
            // Tạo một đối tượng PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Duyệt qua từng chức vụ trong danh sách để chèn dữ liệu vào bảng
            for (ChucVu chucVu : dsChucVu) {
                // Thiết lập các tham số cho truy vấn
                statement.setString(1, chucVu.getMaChucVu().trim());
                statement.setString(2, chucVu.getTenChucVu());

                // Thực hiện truy vấn chèn dữ liệu
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu có lỗi trong quá trình kết nối hoặc thực hiện truy vấn
            //e.printStackTrace();
        }
    }

    public static void addListSinhVienToTable(ArrayList<SinhVien> dsSinhVien, JTable tableSinhVien, ArrayList<ChucVu> dsChucVu, ArrayList<TaiKhoan> dsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tableSinhVien.getModel();
        ThuatToan.sapXepTheoMSSV(dsSinhVien);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i = 0;
        // Duyệt qua danh sách sinh viên và thêm vào bảng
        for (SinhVien sinhVien : dsSinhVien) {
            if (sinhVien != null) { // Kiểm tra sinh viên có null không
                Object[] row = {Integer.toString(i + 1), sinhVien.getMaSV(), sinhVien.getHoTen(), 
                sinhVien.getLop(), ThuatToan.getTenChucVu(dsChucVu, sinhVien.getChucVu()), 
                ThuatToan.getTrangThai(dsTaiKhoan, sinhVien.getMaSV())};
                i++;
                model.addRow(row);
            }
        }
    }
    
     public static void addListSinhVienToTable_1Lop(ArrayList<SinhVien> dsSinhVien, JTable tableSinhVien, ArrayList<ChucVu> dsChucVu, ArrayList<TaiKhoan> dsTaiKhoan, String tenLop) {
        DefaultTableModel model = (DefaultTableModel) tableSinhVien.getModel();
        ThuatToan.sapXepTheoMSSV(dsSinhVien);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i = 0;
        // Duyệt qua danh sách sinh viên và thêm vào bảng
        for (SinhVien sinhVien : dsSinhVien) {
            if (sinhVien != null) { // Kiểm tra sinh viên có null không
                if(sinhVien.getLop().equals(tenLop)){
                    Object[] row = {Integer.toString(i + 1), sinhVien.getMaSV(), sinhVien.getHoTen(), 
                    sinhVien.getLop(), ThuatToan.getTenChucVu(dsChucVu, sinhVien.getChucVu()), 
                    ThuatToan.getTrangThai(dsTaiKhoan, sinhVien.getMaSV())};
                    i++;
                    model.addRow(row);
                }
                
            }
        }
    }
    
    public static void addListSinhVienToTable_Khoa(ArrayList<SinhVien> dsSinhVien, ArrayList<Khoa> dsKhoa, ArrayList<Lop> dsLop, JTable tableSinhVien, ArrayList<ChucVu> dsChucVu, ArrayList<TaiKhoan> dsTaiKhoan, String tenKhoa) {
        DefaultTableModel model = (DefaultTableModel) tableSinhVien.getModel();
        ThuatToan.sapXepTheoMSSV(dsSinhVien);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i = 0;
        // Duyệt qua danh sách sinh viên và thêm vào bảng
        for (SinhVien sinhVien : dsSinhVien) {
            if (sinhVien != null) { // Kiểm tra sinh viên có null không
                if(ThuatToan.getKhoaFromSinhVien(dsLop, sinhVien.getLop()).equals(ThuatToan.doiTenKhoaThanhMaKhoa(tenKhoa, dsKhoa))){
                    Object[] row = {Integer.toString(i + 1), sinhVien.getMaSV(), sinhVien.getHoTen(), sinhVien.getLop(), 
                    ThuatToan.getTenChucVu(dsChucVu, sinhVien.getChucVu()), 
                    ThuatToan.getTrangThai(dsTaiKhoan, sinhVien.getMaSV())};
                    i++;
                    model.addRow(row);
                }
                
            }
        }
    }
    
    public static void addListSinhVienToTable_1Khoa(ArrayList<SinhVien> dsSinhVien, String maKhoa, ArrayList<Lop> dsLop, JTable tableSinhVien, ArrayList<ChucVu> dsChucVu, ArrayList<TaiKhoan> dsTaiKhoan, String tenKhoa) {
        DefaultTableModel model = (DefaultTableModel) tableSinhVien.getModel();
        ThuatToan.sapXepTheoMSSV(dsSinhVien);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i = 0;
        // Duyệt qua danh sách sinh viên và thêm vào bảng
        for (SinhVien sinhVien : dsSinhVien) {
            if (sinhVien != null) { // Kiểm tra sinh viên có null không
                if(ThuatToan.getKhoaFromSinhVien(dsLop, sinhVien.getLop()).equals(maKhoa)){
                    Object[] row = {Integer.toString(i + 1), sinhVien.getMaSV(), sinhVien.getHoTen(), sinhVien.getLop(), 
                    ThuatToan.getTenChucVu(dsChucVu, sinhVien.getChucVu()), 
                    ThuatToan.getTrangThai(dsTaiKhoan, sinhVien.getMaSV())};
                    i++;
                    model.addRow(row);
                }
                
            }
        }
    }
    
    public static void addOneSinhVienToTable( JTable tableSinhVien, SinhVien sinhVien, ArrayList<ChucVu> dsChucVu, ArrayList<TaiKhoan> dsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tableSinhVien.getModel();
        int thuTu = tableSinhVien.getRowCount();
        String thu = Integer.toString(thuTu+1);
        Object[] row = {thu, sinhVien.getMaSV(), sinhVien.getHoTen(), sinhVien.getLop(), 
        ThuatToan.getTenChucVu(dsChucVu, sinhVien.getChucVu()), 
        ThuatToan.getTrangThai(dsTaiKhoan, sinhVien.getMaSV())};
        model.addRow(row);

    }
    
    public static void addListSinhVienToTable_Lop(ArrayList<SinhVien> dsSinhVien,  JTable tableSinhVien, ArrayList<ChucVu> dsChucVu, ArrayList<TaiKhoan> dsTaiKhoan, String lop) {
        DefaultTableModel model = (DefaultTableModel) tableSinhVien.getModel();
        ThuatToan.sapXepTheoMSSV(dsSinhVien);
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        int i = 0;
        // Duyệt qua danh sách sinh viên và thêm vào bảng
        for (SinhVien sinhVien : dsSinhVien) {
            if (sinhVien != null) { // Kiểm tra sinh viên có null không
                if(sinhVien.getLop().equals(lop)){
                    Object[] row = {Integer.toString(i + 1), sinhVien.getMaSV(), sinhVien.getHoTen(), 
                    sinhVien.getLop(), ThuatToan.getTenChucVu(dsChucVu, sinhVien.getChucVu()), 
                    ThuatToan.getTrangThai(dsTaiKhoan, sinhVien.getMaSV())};
                    i++;
                    model.addRow(row);
                }
                
            }
        }
    }
    
    
    
    
    public static void saveThongBaoToList(ArrayList<ThongBao> dsThongBao){
        try (Connection connection = getConnection()) {
            String query = "SELECT maHK_NK, ngayBD, ngayKT_SV, ngayKT_CS, ngayKT_CV, ngayKT_Khoa FROM TBChamDiem";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maHocKy = resultSet.getString("maHK_NK").trim();
                Date ngayBD = resultSet.getDate("ngayBD");
                Date ngayKTSV = resultSet.getDate("ngayKT_SV");
                Date ngayKTCS = resultSet.getDate("ngayKT_CS");
                Date ngayKTCV = resultSet.getDate("ngayKT_CV");
                Date ngayKTKhoa = resultSet.getDate("ngayKT_Khoa");

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                ThongBao thongBao = new ThongBao(
                    maHocKy,
                    dateFormat.format(ngayBD),
                    dateFormat.format(ngayKTSV),
                    dateFormat.format(ngayKTCS),
                    dateFormat.format(ngayKTCV),
                    dateFormat.format(ngayKTKhoa)
                );
                dsThongBao.add(thongBao);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
    
    public static void saveListThongBaoToDB(ArrayList<ThongBao> dsThongBao){
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false); // Bắt đầu giao dịch
            
            String deleteQuery = "DELETE FROM TBChamDiem";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.executeUpdate();

            String query = "INSERT INTO TBChamDiem (maHK_NK, ngayBD, ngayKT_SV, ngayKT_CS, ngayKT_CV, ngayKT_Khoa) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            for (ThongBao thongBao : dsThongBao) {
                statement.setString(1, thongBao.getMaHocKy());
                statement.setString(2, thongBao.getNgayBD());
                statement.setString(3, thongBao.getNgayKTSV());
                statement.setString(4, thongBao.getNgayKTCS());
                statement.setString(5, thongBao.getNgayKTCV());
                statement.setString(6, thongBao.getNgayKTKhoa());
                statement.addBatch(); // Thêm lệnh vào batch
            }

            // Thực thi tất cả các lệnh trong batch
            int[] result = statement.executeBatch();

            // Kiểm tra kết quả và kết thúc giao dịch
            for (int i : result) {
                if (i == PreparedStatement.EXECUTE_FAILED) {
                    connection.rollback(); // Lùi lại giao dịch nếu có lỗi
                    return;
                }
            }

            connection.commit(); // Hoàn tất giao dịch nếu không có lỗi
            connection.close();
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
    
    public static String chuyenMaHocKy(String maHocKy) {
        String[] parts = maHocKy.split("-");

        int namBatDau = Integer.parseInt(parts[0]);
        int namKetThuc = Integer.parseInt(parts[1]);
        int soHocKy = Integer.parseInt(parts[2]);

        String hocKy;

        if (soHocKy == 1) {
            hocKy = "I";
        } else {
            hocKy = "II";
        }

        return hocKy + " " + namBatDau + "-" + namKetThuc;
    }
    
    public static void addListThongBaoToTable(ArrayList<ThongBao> dsThongBao, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Xóa tất cả các dòng hiện có trong bảng
        model.setRowCount(0);

        // Đảo ngược danh sách để thêm từ cuối danh sách
        int k = 0;
        // Duyệt qua danh sách ThongBao từ cuối đến đầu và thêm vào bảng
        for (int i = dsThongBao.size() - 1; i >= 0; i--) {
            ThongBao thongBao = dsThongBao.get(i);
            Object[] row = {Integer.toString(k+1), chuyenMaHocKy(thongBao.getMaHocKy()),
                ThuatToan.doiNgay(thongBao.getNgayBD()), ThuatToan.doiNgay(thongBao.getNgayKTSV()), 
                ThuatToan.doiNgay(thongBao.getNgayKTCS()), ThuatToan.doiNgay(thongBao.getNgayKTCV()), 
                ThuatToan.doiNgay(thongBao.getNgayKTKhoa())};
            k++;
            model.addRow(row);
        }
    }
    
    public static void saveDRLToList(ArrayList<DRL>dsDRL){
        try {
            // Bước 1: Đăng ký JDBC driver

            // Bước 2: Mở kết nối
            Connection conn = getConnection();

            // Bước 3: Thực hiện truy vấn
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT MSSV, MaHK_NK, DiemSV, DiemCS, DiemCV, TrangThai FROM DRLSV";
            ResultSet rs = stmt.executeQuery(sql);

            // Bước 4: Xử lý kết quả
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet
                String MSSV = rs.getString("MSSV").trim();
                String maHK = rs.getString("MaHK_NK").trim();
                int diem1 = rs.getInt("DiemSV");
                int diem2 = rs.getInt("DiemCS");
                int diem3 = rs.getInt("DiemCV");
                boolean trangThai = rs.getBoolean("TrangThai");

                // Tạo đối tượng DRL và thêm vào danh sách
                DRL drl = new DRL(MSSV, maHK, diem1, diem2, diem3, trangThai);
                dsDRL.add(drl);
            }
        } catch (SQLException se) {
            // Xử lý các lỗi của JDBC
            //se.printStackTrace();
        } catch (Exception e) {
            // Xử lý các lỗi khác
            //e.printStackTrace();
        } 

    }
    
    public static void saveListDRLToDB(ArrayList<DRL> dsDRL) {
        try {
            // Bước 2: Xóa hết dữ liệu từ bảng
            try ( // Bước 1: Mở kết nối
                    Connection conn = getConnection()) {
                // Bước 2: Xóa hết dữ liệu từ bảng
                String deleteQuery = "DELETE FROM DRLSV";
                PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
                deleteStmt.executeUpdate();
                // Bước 3: Thêm mới dữ liệu từ danh sách
                String insertQuery = "INSERT INTO DRLSV (MSSV, MaHK_NK, DiemSV, DiemCS, DiemCV, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                for (DRL drl : dsDRL) {
                    insertStmt.setString(1, drl.getMSSV().trim());
                    insertStmt.setString(2, drl.getMaHK().trim());
                    insertStmt.setInt(3, drl.getDiem1());
                    insertStmt.setInt(4, drl.getDiem2());
                    insertStmt.setInt(5, drl.getDiem3());
                    insertStmt.setBoolean(6, drl.isTrangThai());
                    insertStmt.addBatch();
                }   insertStmt.executeBatch();
                // Bước 4: Đóng kết nối
            }
        } catch (SQLException se) {
            // Xử lý các lỗi của JDBC
            //se.printStackTrace();
        } catch (Exception e) {
            // Xử lý các lỗi khác
           // e.printStackTrace();
        }
        
    }
    
    public static void updateDRLSV_SV(String mssv, String maHK, int diemSV, int diemCS, int diemCV) {
        try {
            // Bước 1: Mở kết nối
            try (Connection conn = getConnection()) {
                // Bước 2: Tạo truy vấn cập nhật
                String updateQuery = "UPDATE DRLSV SET DiemSV = ?, DiemCS = ?, DiemCV = ? WHERE MSSV = ? AND MaHK_NK = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);

                // Thiết lập các tham số trong truy vấn
                updateStmt.setInt(1, diemSV);
                updateStmt.setInt(2, diemCS);
                updateStmt.setInt(3, diemCV);
                updateStmt.setString(4, mssv);
                updateStmt.setString(5, maHK);

                // Bước 3: Thực thi truy vấn cập nhật
                updateStmt.executeUpdate();

                // Bước 4: Đóng kết nối (kết nối tự đóng sau khi sử dụng try-with-resources)
            }
        } catch (SQLException se) {
            // Xử lý lỗi của JDBC
            //se.printStackTrace();
        } catch (Exception e) {
            // Xử lý lỗi khác
            //e.printStackTrace();
        }
    }
    
    public static void updateDRLSV_CS(String mssv, String maHK, int diemCS, int diemCV) {
        try {
            // Bước 1: Mở kết nối
            try (Connection conn = getConnection()) {
                // Bước 2: Tạo truy vấn cập nhật
                String updateQuery = "UPDATE DRLSV SET DiemCS = ?, DiemCV = ? WHERE MSSV = ? AND MaHK_NK = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);

                // Thiết lập các tham số trong truy vấn
                updateStmt.setInt(1, diemCS);
                updateStmt.setInt(2, diemCV);
                updateStmt.setString(3, mssv);
                updateStmt.setString(4, maHK);

                // Bước 3: Thực thi truy vấn cập nhật
                updateStmt.executeUpdate();

                // Bước 4: Đóng kết nối (kết nối tự đóng sau khi sử dụng try-with-resources)
            }
        } catch (SQLException se) {
            // Xử lý lỗi của JDBC
            //se.printStackTrace();
        } catch (Exception e) {
            // Xử lý lỗi khác
            //e.printStackTrace();
        }
    }
    
    public static void updateDRLSV_CV(String mssv, String maHK, int diemCV) {
        try {
            // Bước 1: Mở kết nối
            try (Connection conn = getConnection()) {
                // Bước 2: Tạo truy vấn cập nhật
                String updateQuery = "UPDATE DRLSV SET  DiemCV = ? WHERE MSSV = ? AND MaHK_NK = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);

                // Thiết lập các tham số trong truy vấn
                updateStmt.setInt(1, diemCV);
                updateStmt.setString(2, mssv);
                updateStmt.setString(3, maHK);

                // Bước 3: Thực thi truy vấn cập nhật
                updateStmt.executeUpdate();

                // Bước 4: Đóng kết nối (kết nối tự đóng sau khi sử dụng try-with-resources)
            }
        } catch (SQLException se) {
            // Xử lý lỗi của JDBC
            //se.printStackTrace();
        } catch (Exception e) {
            // Xử lý lỗi khác
            //e.printStackTrace();
        }
    }
    
    public static void saveOneDRLToDB(DRL drl) {
    try {
        // Bước 1: Mở kết nối
        try (Connection conn = getConnection()) {
            // Bước 2: Thêm mới dữ liệu từ một đối tượng DRL
            String insertQuery = "INSERT INTO DRLSV (MSSV, MaHK_NK, DiemSV, DiemCS, DiemCV, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            
            // Thiết lập các giá trị cho câu lệnh SQL từ đối tượng DRL đưa vào
            insertStmt.setString(1, drl.getMSSV().trim());
            insertStmt.setString(2, drl.getMaHK().trim());
            insertStmt.setInt(3, drl.getDiem1());
            insertStmt.setInt(4, drl.getDiem2());
            insertStmt.setInt(5, drl.getDiem3());
            insertStmt.setBoolean(6, drl.isTrangThai());
            
            // Thực hiện truy vấn
            insertStmt.executeUpdate();
            
            // Bước 3: Đóng kết nối
        }
    } catch (SQLException se) {
        // Xử lý các lỗi của JDBC
        //se.printStackTrace();
    } catch (Exception e) {
        // Xử lý các lỗi khác
        //e.printStackTrace();
    }
}

    
    public static void deleteTable(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Xóa tất cả các dòng hiện có trong bảng
        model.setRowCount(0);
    }
    
    
    
    public static void addListDRLToTable(ArrayList<DRL> dsDRL, ArrayList<SinhVien> dsSV, JTable table, String lop, String hk) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ThuatToan.sapXepTheoDRL(dsDRL);
        // Xóa tất cả các dòng hiện có trong bảng
        model.setRowCount(0);

        // Đảo ngược danh sách để thêm từ cuối danh sách
        int k = 0;
        // Duyệt qua danh sách ThongBao từ cuối đến đầu và thêm vào bảng
        for (DRL drl : dsDRL) {
            if(ThuatToan.getLopFromDRL(drl.getMSSV(), dsSV).equals(lop) && hk.equals(drl.getMaHK())){
                //System.out.println(ThuatToan.getLopFromDRL(drl.getMSSV(), dsSV) + " " + lop + " " + hk + " "+drl.getMaHK());
                String duyet;
                if(drl.isTrangThai()){
                    duyet = "Đã duyệt";
                }else duyet = "Chưa duyệt";
                Object[] row = {Integer.toString(k+1), drl.getMSSV(), ThuatToan.getTenFromMSV(drl.getMSSV(), dsSV),
                Integer.toString(drl.getDiem1()), Integer.toString(drl.getDiem2()), Integer.toString(drl.getDiem3()), duyet};
                k++;
                model.addRow(row);
            }
            
        }
    }
    
    public static void addListDRLToTable_SV_HK(ArrayList<DRL> dsDRL, SinhVien sv, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ThuatToan.sapXepTheoDRL(dsDRL);
        // Xóa tất cả các dòng hiện có trong bảng
        model.setRowCount(0);

        // Đảo ngược danh sách để thêm từ cuối danh sách
        int k = 0;
        // Duyệt qua danh sách ThongBao từ cuối đến đầu và thêm vào bảng
        for (DRL drl : dsDRL) {
            if(drl.getMSSV().equals(sv.getMaSV()) ){
                //System.out.println(ThuatToan.getLopFromDRL(drl.getMSSV(), dsSV) + " " + lop + " " + hk + " "+drl.getMaHK());
                String duyet;
                if(drl.isTrangThai()){
                    duyet = "Đã duyệt";
                }else duyet = "Chưa duyệt";
                Object[] row = {Database.chuyenMaHocKy(drl.getMaHK()), drl.getMSSV(), sv.getHoTen(),
                Integer.toString(drl.getDiem1()), Integer.toString(drl.getDiem2()), Integer.toString(drl.getDiem3()), duyet};
                k++;
                model.addRow(row);
            }
            
        }
    }
    
    public static void updateTrangThai(String mssv, String maHK_NK) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Mở kết nối
            conn = getConnection();

            // Câu lệnh SQL UPDATE
            String sql = "UPDATE DRLSV SET TrangThai = ? WHERE MSSV = ? AND MaHK_NK = ?";
            stmt = conn.prepareStatement(sql);

            // Thiết lập giá trị của các tham số trong câu lệnh SQL
            stmt.setBoolean(1, true);
            stmt.setString(2, mssv);
            stmt.setString(3, maHK_NK);

            // Thực thi câu lệnh SQL
            stmt.executeUpdate();
        } catch (SQLException se) {
            // Xử lý lỗi của JDBC
            //se.printStackTrace();
        } catch (Exception e) {
            // Xử lý các lỗi khác
            //e.printStackTrace();
        }
    }
    
    public static void updateDiem(String mssv, String maHK_NK) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Mở kết nối
            conn = getConnection();

            // Câu lệnh SQL UPDATE
            String sql = "UPDATE DRLSV SET DiemSV = 0, DiemCS = 0, DiemCV = 0 WHERE MSSV = ? AND MaHK_NK = ?";
            stmt = conn.prepareStatement(sql);

            // Thiết lập giá trị của các tham số trong câu lệnh SQL
            stmt.setString(1, mssv);
            stmt.setString(2, maHK_NK);

            // Thực thi câu lệnh SQL
            stmt.executeUpdate();
        } catch (SQLException se) {
            // Xử lý lỗi của JDBC
            //se.printStackTrace();
        } catch (Exception e) {
            // Xử lý các lỗi khác
            //e.printStackTrace();
        }
    }
    
    public static void deleteOneRow(JTable table, int row) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Xóa dòng cần xóa
        model.removeRow(row);
    }
    
}
