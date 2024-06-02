/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import controller.Database;
import controller.Link;
import com.raven.swing.ScrollBar;
import controller.ThuatToan;
import static controller.ThuatToan.doiKhoaHocSangHKCuoi;
import static controller.ThuatToan.getKhoaHocFromSV;
import static controller.ThuatToan.getSoNamHoc;
import java.awt.Cursor;
import java.awt.Image;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
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
 * 
 * 
 */




public final class FormQuanLy extends javax.swing.JFrame {

/**
     * Creates new form FormSinhVien
     */ private ArrayList <Khoa> dsKhoa = null;
        private ArrayList <CoVan> dsCoVan = null;
        private ArrayList <HocKy> dsHocKy = null;
        private ArrayList <KhoaHoc> dsKhoaHoc = null;
        private ArrayList <Lop> dsLop = null;
        private ArrayList <TaiKhoan> dsTaiKhoan = null;
        private ArrayList <TieuChi> dsTieuChi = null;
        private ArrayList <SinhVien> dsSinhVien = null;
        private ArrayList <ChucVu> dsChucVu = null;
        private ArrayList <ThongBao> dsThongBao = null;
        private ArrayList <DRL> dsDRL = null;
        private JFrame frame;
        //private final static Color textColor = new Color(0, 0, 139);
        private final static Color white = Color.WHITE;
        private final static Color hoveColor = new Color(255,204,102);//màu đậm
        private final static Color hoveColor2 = new Color(255, 228, 181);//màu lợt
        private final Color buttonHoverColor = new Color(30,115,190);
        private final Color buttonColor = new Color(221,51,51);
    // Màu của viền
        
    public FormQuanLy() {
        initComponents();
        suKienMenu();
    }
    
    //covan
    public FormQuanLy(JFrame frame, ArrayList<TaiKhoan> dsTaiKhoan, ArrayList <Khoa>dsKhoa, ArrayList <CoVan>dsCoVan, ArrayList<HocKy>dsHocKy,
            ArrayList<KhoaHoc>dsKhoaHoc, ArrayList<Lop> dsLop, ArrayList<TieuChi> dsTieuChi, ArrayList<ChucVu>dsChucVu, 
            ArrayList<SinhVien>dsSinhVien, ArrayList <ThongBao> dsThongBao, ArrayList<DRL> dsDRL) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        this.dsHocKy = dsHocKy;
        this.dsKhoaHoc = dsKhoaHoc;
        this.dsLop = dsLop;
        this.dsTaiKhoan = dsTaiKhoan;
        this.dsTieuChi = dsTieuChi;
        this.dsSinhVien = dsSinhVien;
        this.dsChucVu = dsChucVu;
        this.dsThongBao = dsThongBao;
        this.dsDRL = dsDRL;
        this.frame = frame;
        //setRootPaneCheckingEnabled(false);
        initComponents();
        suKienMenu();
    }
    
    //Xử lý khi click vào menu nào thì bảng của menu đó có dữ liệu
    public void addTable(String text){
        if(text.contains("KHOA")){
            new Thread(() -> {
                Database.saveKhoaToList(dsKhoa);
                Database.addListKhoaToTable(dsKhoa, jTableKhoa, dsTaiKhoan);
            }).start();
        }
        else if (text.contains("CỐ VẤN")){
            new Thread(() -> {
                Database.saveKhoaToList(dsKhoa);
                Database.saveCoVanToList(dsCoVan);
                Database.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa, dsTaiKhoan);
                ThuatToan.addChoiceKhoa(choiceKhoa_CoVan, dsKhoa);
            }).start();
            
        }
        else if(text.contains("THỜI GIAN BIỂU")){
            new Thread(() -> {
                Database.saveHocKyToList(dsHocKy);
                Database.saveKhoaHocToList(dsKhoaHoc);
                Database.saveThongBaoToList(dsThongBao);
                Database.addListHocKyToTable(dsHocKy, jTableHocKy);
                Database.addListKhoaHocToTable(dsKhoaHoc, jTableKhoaHoc);
                Database.addListThongBaoToTable(dsThongBao, jTableHanNop);
            }).start();
        }
        else if(text.contains("LỚP")){
            new Thread(() -> {
                Database.saveKhoaToList(dsKhoa);
                Database.saveLopToList(dsLop);
                Database.addListLopToTable(dsLop, jTableLop, dsKhoa, dsCoVan);
                ThuatToan.addChoiceKhoa(choiceKhoa_Lop, dsKhoa);
            }).start();
        }
        else if(text.contains("TIÊU CHÍ")){
            new Thread(() -> {
                Database.saveTieuChiToList(dsTieuChi);
                Database.addListTieuChiToTable(dsTieuChi, jTableTieuChi);
            }).start();
        }
        else if(text.contains("SINH VIÊN")){
            new Thread(() -> {
                Database.saveKhoaToList(dsKhoa);
                Database.saveLopToList(dsLop);
                Database.saveSinhVienToList(dsSinhVien);
                choiceLop_SV.removeAll();
                Database.addListSinhVienToTable(dsSinhVien, jTableSV, dsChucVu, dsTaiKhoan);
                ThuatToan.addChoiceKhoa(choiceKhoa_SV, dsKhoa);
            }).start();
        }
        else if(text.contains("DUYỆT ĐIỂM")){
            new Thread(() -> {
                Database.saveLopToList(dsLop);
                Database.saveHocKyToList(dsHocKy);
                Database.saveKhoaToList(dsKhoa);
                Database.saveDRLToList(dsDRL);
                ThuatToan.addChoiceKhoa(choiceKhoa_DRL, dsKhoa);
                choiceKhoa_DRL.remove("Tất cả");
                choiceKhoa_DRL.select(dsKhoa.get(1).getTenKhoa());
                ThuatToan.addChoiceLop(choiceLop_DRL, dsLop, dsKhoa.get(1).getTenKhoa(), dsKhoa);
                choiceLop_DRL.select("D15CQAT01-N");
                String khoaHoc = ThuatToan.getKhoaHocFromSV(dsLop, dsLop.getFirst().getLop());
                ThuatToan.addChoiceHocKy(dsHocKy, khoaHoc, ThuatToan.getSoNamHoc(dsKhoaHoc, khoaHoc), choiceHK_DRL);

                choiceHK_DRL.select(dsHocKy.getFirst().getMaHK_NK());
                Database.addListDRLToTable(dsDRL, dsSinhVien, jTableDRL, dsLop.getFirst().getLop(), dsHocKy.getFirst().getMaHK_NK());
                jPanelNutDuyet.setVisible(false);
                jLabelNutDuyet.setVisible(false);
                jPanelNutChamLai.setVisible(false);
                jLabelNutChamLai.setVisible(false);
            }).start();
        }
        else {
            moTrangChu();
        }
    }    
    
    public void moTrangChu(){
        new Thread(() -> {
            Database.saveKhoaToList(dsKhoa);
            Database.saveLopToList(dsLop);
            Database.saveThongBaoToList(dsThongBao);
            ThuatToan.addChoiceKhoa(choiceKhoa_LopXet, dsKhoa);
            String hkxet = ThuatToan.getHKXet(dsHocKy);
            jLabelHKXet.setText(Database.chuyenMaHocKy(hkxet));
            ThongBao tb = ThuatToan.getThongBao(dsThongBao, hkxet);
            jLabelNgayBD.setText(ThuatToan.doiNgay(tb.getNgayBD()));
            jLabelHanSV.setText(ThuatToan.doiNgay(tb.getNgayKTSV()));
            jLabelHanCS.setText(ThuatToan.doiNgay(tb.getNgayKTCS()));
            jLabelHanCV.setText(ThuatToan.doiNgay(tb.getNgayKTCV()));
            jLabelHanKhoa.setText(ThuatToan.doiNgay(tb.getNgayKTKhoa()));
            choiceKhoa_LopXet.removeAll();
            ThuatToan.addChoiceKhoa(choiceKhoa_LopXet, dsKhoa);

            Database.addListLopToTable_HKXet(dsLop, jTableLopXet, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc);
        }).start();
    }
        
        // Sử dụng màu này trong ứng dụng của bạn
    
    //Khi chọn vào menu nào thì menu đó có màu vàng còn tất cả còn lại reset màu trắng    
    public void viewMenuClick(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        main.setBackground(hoveColor);
        main.revalidate(); // Cập nhật giao diện
        main.repaint();    // Vẽ lại giao diện
        //updatejadsjkfadkj
        p2.setBackground(white);
        p2.revalidate(); // Cập nhật giao diện
        p2.repaint();    // Vẽ lại giao diện
        
        p3.setBackground(white);
        p3.revalidate(); // Cập nhật giao diện
        p3.repaint();    // Vẽ lại giao diện
        
        p4.setBackground(white);
        p4.revalidate(); // Cập nhật giao diện
        p4.repaint();    // Vẽ lại giao diện
        
        p5.setBackground(white);
        p5.revalidate(); // Cập nhật giao diện
        p5.repaint();    // Vẽ lại giao diện
        
        p6.setBackground(white);
        p6.revalidate(); // Cập nhật giao diện
        p6.repaint();    // Vẽ lại giao diện
        
        p7.setBackground(white);
        p7.revalidate(); // Cập nhật giao diện
        p7.repaint();    // Vẽ lại giao diện
        
        p8.setBackground(white);
        p8.revalidate(); // Cập nhật giao diện
        p8.repaint();    // Vẽ lại giao diện
        
    }    
    // rê vào menu nào thì menu đó có màu vàng lợt, trừ menu được chọn
    public void viewMenuHover(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7,  JPanel p8){
        if(main.getBackground().equals(white)){
            main.setBackground(hoveColor2);
            main.revalidate(); // Cập nhật giao diện
            main.repaint();    // Vẽ lại giao diện
        }
        if(!p2.getBackground().equals(hoveColor)){
            p2.setBackground(white);
            p2.revalidate(); // Cập nhật giao diện
            p2.repaint();    // Vẽ lại giao diện
        }
        if(!p3.getBackground().equals(hoveColor)){
            p3.setBackground(white);
            p3.revalidate(); // Cập nhật giao diện
            p3.repaint();    // Vẽ lại giao diện
        }
        if(!p4.getBackground().equals(hoveColor)){
            p4.setBackground(white);
            p4.revalidate(); // Cập nhật giao diện
            p4.repaint();    // Vẽ lại giao diện
        }
        if(!p5.getBackground().equals(hoveColor)){
            p5.setBackground(white);
            p5.revalidate(); // Cập nhật giao diện
            p5.repaint();    // Vẽ lại giao diện
        }
        if(!p6.getBackground().equals(hoveColor)){
            p6.setBackground(white);
            p6.revalidate(); // Cập nhật giao diện
            p6.repaint();    // Vẽ lại giao diện
        }
        if(!p7.getBackground().equals(hoveColor)){
            p7.setBackground(white);
            p7.revalidate(); // Cập nhật giao diện
            p7.repaint();    // Vẽ lại giao diện
        }
        if(!p8.getBackground().equals(hoveColor)){
            p8.setBackground(white);
            p8.revalidate(); // Cập nhật giao diện
            p8.repaint();    // Vẽ lại giao diện
        }
        
    }
    // rê ra khỏi menu thì menu màu trắng
    public void viewExit(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        if(!main.getBackground().equals(hoveColor)){
            main.setBackground(white);
            main.revalidate(); // Cập nhật giao diện
            main.repaint();    // Vẽ lại giao diện
        }
        if(!p2.getBackground().equals(hoveColor)){
            p2.setBackground(white);
            p2.revalidate(); // Cập nhật giao diện
            p2.repaint();    // Vẽ lại giao diện
        }
        if(!p3.getBackground().equals(hoveColor)){
            p3.setBackground(white);
            p3.revalidate(); // Cập nhật giao diện
            p3.repaint();    // Vẽ lại giao diện
        }
        if(!p4.getBackground().equals(hoveColor)){
            p4.setBackground(white);
            p4.revalidate(); // Cập nhật giao diện
            p4.repaint();    // Vẽ lại giao diện
        }
        if(!p5.getBackground().equals(hoveColor)){
            p5.setBackground(white);
            p5.revalidate(); // Cập nhật giao diện
            p5.repaint();    // Vẽ lại giao diện
        }
        if(!p6.getBackground().equals(hoveColor)){
            p6.setBackground(white);
            p6.revalidate(); // Cập nhật giao diện
            p6.repaint();    // Vẽ lại giao diện
        }
        if(!p7.getBackground().equals(hoveColor)){
            p7.setBackground(white);
            p7.revalidate(); // Cập nhật giao diện
            p7.repaint();    // Vẽ lại giao diện
        }
        if(!p8.getBackground().equals(hoveColor)){
            p8.setBackground(white);
            p8.revalidate(); // Cập nhật giao diện
            p8.repaint();    // Vẽ lại giao diện
        }
    }
    //Khi click vào đăng xuất thì thoát    
    public void dangXuat(JPanel jpanelLogOut, JLabel jlabelLogOut, JLabel jlabelLeft9, JFrame main, JFrame next){
        jpanelLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thoát không?");
                    if(chon == JOptionPane.YES_OPTION) {
                // Thực hiện hành động khi người dùng chọn "Yes"
                // Ví dụ: thoát chương trình
                    main.dispose();
                    next.setVisible(true);
            }
                
            }
        });
        jlabelLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thoát không?");
                    if(chon == JOptionPane.YES_OPTION) {
                // Thực hiện hành động khi người dùng chọn "Yes"
                // Ví dụ: thoát chương trình
                    main.dispose();
                    next.setVisible(true);
                
                }
            }
        });
        jlabelLeft9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                    int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thoát không?");
                    if(chon == JOptionPane.YES_OPTION) {
                // Thực hiện hành động khi người dùng chọn "Yes"
                // Ví dụ: thoát chương trình
                    main.dispose();
                    next.setVisible(true);
                }
            }
        });
    }
    //Các sự kiện của menu
    
    public void hoverMenu(){
        //rê vào menu nào thì menu đó màu vàng nhạt
        EnterEvent(jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft, jPanelSinhVien, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelDRL);
       EnterEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       EnterEvent(jPanelKhoa, jLabelKhoa, jLabelKhoaLeft, jPanelDRL, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       EnterEvent(jPanelHocKy, jLabelHocKy, jLabelHocKyLeft, jPanelKhoa, jPanelDRL, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       EnterEvent(jPanelLop, jLabelLop, jLabelLopLeft, jPanelKhoa, jPanelHocKy, jPanelDRL, jPanelCoVan, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       EnterEvent(jPanelCoVan, jLabelCoVan, jLabelCoVanLeft, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelDRL, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       EnterEvent(jPanelTieuChi, jLabelTieuChi, jLabelTieuChiLeft, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelDRL, jPanelSinhVien, jPanelTrangChu);
       EnterEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelDRL, jPanelTrangChu);
    }
    
    public void clickMenu(){
        //Kích vào menu nào thì đó hiện màu vàng đậm
       ClickEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelKhoa, jLabelKhoa, jLabelKhoaLeft, jPanelDRL, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelHocKy, jLabelHocKy, jLabelHocKyLeft, jPanelKhoa, jPanelDRL, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelLop, jLabelLop, jLabelLopLeft, jPanelKhoa, jPanelHocKy, jPanelDRL, jPanelCoVan, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelCoVan, jLabelCoVan, jLabelCoVanLeft, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelDRL, jPanelTieuChi, jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelTieuChi, jLabelTieuChi, jLabelTieuChiLeft, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelDRL, jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelDRL, jPanelTrangChu);
       ClickEvent(jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft,jPanelSinhVien, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelDRL);
    }
    
    public void hoverUnderMenu(){
        //Xử lý khi rê vào trợ giúp và đăng xuất
        buttonMenuHoverEvent(jLabelHelp, jPanelHelp, jLabelLeft8);
        buttonMenuHoverEvent(jLabelLogOut, jPanelLogOut, jLabelLeft9);
    }
    
    public void hoverButton(){
        //rê vào các nút thêm sửa xóa sẽ đổi màu xanh
        
        //nút thêm
        buttonHoverEvent(jLabelNutChamLai, jPanelNutChamLai);
        buttonHoverEvent(jLabelNutDuyet, jPanelNutDuyet);
        buttonHoverEvent(jLabelNutCapNhat, jPanelNutCapNhat);
        buttonHoverEvent(jLabelNutThemKhoaHoc, jPanelNutThemKhoaHoc);
        
        buttonHoverEvent(jLabelNutKhoaKhoa, jPanelNutKhoaKhoa);
        buttonHoverEvent(jLabelNutKhoaCV, jPanelNutKhoaCV);
        buttonHoverEvent(jLabelNutKhoaSV, jPanelNutKhoaSV);
        
        buttonHoverEvent(jLabelNutChiTietTC, jPanelNutChiTietTC);
        buttonHoverEvent(jLabelNutThemTieuChi, jPanelNutThemTieuChi);
        buttonHoverEvent(jLabelThemSV, jPanelThemSV);
        buttonHoverEvent(jLabelNutThemLop, jPanelNutThemLop);
        buttonHoverEvent(jLabelNutThemCoVan, jPanelNutThemCoVan);
        buttonHoverEvent(jLabelNutThemKhoa, jPanelNutThemKhoa);
        buttonHoverEvent(jLabelNutXoaKhoa, jPanelNutXoaKhoa);
        buttonHoverEvent(jLabelNutDoiHanNop, jPanelNutDoiHanNop);
        buttonHoverEvent(jLabelNutLienHe, jPanelNutLienHe);
        //nút xóa
        buttonHoverEvent(jLabelNutXoaTieuChi, jPanelNutXoaTieuChi);
        buttonHoverEvent(jLabelNutThemHK, jPanelNutThemHK);
        buttonHoverEvent(jLabelXoaSV, jPanelXoaSV);
        buttonHoverEvent(jLabelNutXoaLop, jPanelNutXoaLop);
        buttonHoverEvent(jLabelNutXoaCoVan, jPanelNutXoaCoVan);
        //buttonHoverEvent(jLabelNutXoa, jPanelNutXoa);
        
        //nút sửa
        buttonHoverEvent(jLabelNutChiTietTC, jPanelNutChiTietTC);
        buttonHoverEvent(jLabelNutDoiTT, jPanelNutDoiTT);
        buttonHoverEvent(jLabelSuaSV, jPanelSuaSV);
        buttonHoverEvent(jLabelNutSuaLop, jPanelNutSuaLop);
        buttonHoverEvent(jLabelNutSuaCoVan, jPanelNutSuaCoVan);
        buttonHoverEvent(jLabelNutSuaKhoa, jPanelNutSuaKhoa);
    }
    
    public void openFromMenu(){
        ClickMenuEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft, jPanelDuyetDiem, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelSinhVienMain, jPanelTrangChuMain);
        ClickMenuEvent(jPanelKhoa, jLabelKhoa, jLabelKhoaLeft, jPanelKhoaMain, jPanelDuyetDiem, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelSinhVienMain, jPanelTrangChuMain);
        ClickMenuEvent(jPanelHocKy, jLabelHocKy, jLabelHocKyLeft, jPanelHocKyMain, jPanelKhoaMain, jPanelDuyetDiem, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelSinhVienMain, jPanelTrangChuMain);
        ClickMenuEvent(jPanelLop, jLabelLop, jLabelLopLeft, jPanelLopMain, jPanelKhoaMain, jPanelHocKyMain, jPanelDuyetDiem, jPanelCoVanMain, jPanelTieuChiMain, jPanelSinhVienMain, jPanelTrangChuMain);
        ClickMenuEvent(jPanelCoVan, jLabelCoVan, jLabelCoVanLeft, jPanelCoVanMain, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelDuyetDiem, jPanelTieuChiMain, jPanelSinhVienMain, jPanelTrangChuMain);
        ClickMenuEvent(jPanelTieuChi, jLabelTieuChi, jLabelTieuChiLeft, jPanelTieuChiMain, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelDuyetDiem, jPanelSinhVienMain, jPanelTrangChuMain);
        ClickMenuEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft, jPanelSinhVienMain, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelDuyetDiem, jPanelTrangChuMain);       
        ClickMenuEvent( jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft,jPanelTrangChuMain, jPanelSinhVienMain, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelDuyetDiem); 
    }
    
    public void suKienMenu(){
        setLocationRelativeTo(null);
        hoverMenu();
        clickMenu();
        hoverUnderMenu();
        hoverButton();
        openFromMenu();
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo_ptit.png")); // Thay "logo.png" bằng đường dẫn của hình ảnh của bạn
        Image logo = icon.getImage();
        this.setIconImage(logo);        
        //Mặc định khi mở sẽ hiện màn hình tài khoản khi kích vào nút nào thì nút đó hiện ra phần màn hình đó
        jPanelTrangChu.setBackground(hoveColor);
        hienManHinhCanMo(jPanelTrangChu, jPanelKhoaMain, jPanelTieuChiMain, jPanelCoVanMain, jPanelLopMain, jPanelHocKyMain, jPanelSinhVienMain, jPanelDuyetDiem);
        moTrangChu();
        dangXuat(jPanelLogOut, jLabelLogOut, jLabelLeft9, this, frame);
    }
    
    
    
    //Xử lý các sự kiện click
    public void ClickEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        
        main1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5, p6, p7, p8);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5, p6, p7, p8);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5, p6, p7, p8);
            }
        });
        
    }
    
    
    
    //kích vô menu nào hiện màn hình đó
    //jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelHocKyMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, PanelXemDiemMain
    public void ClickMenuEvent(JPanel main, JLabel main2, JLabel main3, JPanel main1, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7, p8);
                addTable(main2.getText());
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7, p8);
                addTable(main2.getText());
            }
        });
        
        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7, p8);
                addTable(main2.getText());
            }
        });
        
    }
    
    public void EnterEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        
            main1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5, p6, p7, p8);
                }
            });

            // Bắt sự kiện khi rê chuột vào jLabelKhoa2
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5, p6, p7, p8);
                }
            });

            // Bắt sự kiện khi rê chuột vào jLabelLeft
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5, p6, p7, p8);
                }
            });
            
            main1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5, p6, p7, p8);
                }
            });
            
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5, p6, p7, p8);
                }
            });
            
            main3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5, p6, p7, p8);
                }
            });
    }
    
    //Xử lý khi rê các nút thêm, xóa sửa, chấm điểm
    public  void buttonHoverEvent(JLabel label, JPanel panel){
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(buttonHoverColor);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(buttonHoverColor);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(buttonColor);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(buttonColor);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
    }
   
    public void buttonMenuHoverEvent(JLabel label, JPanel panel, JLabel icon){
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(hoveColor2);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(hoveColor2);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(hoveColor2);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(white);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(white);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(white);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
    }
    
    public void hienManHinhCanMo(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        main.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        p7.setVisible(false);
        p8.setVisible(false);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelView = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jPanelTrangChu = new javax.swing.JPanel();
        jLabelTrangChu = new javax.swing.JLabel();
        jLabelTrangChuLeft = new javax.swing.JLabel();
        jPanelKhoa = new javax.swing.JPanel();
        jLabelKhoa = new javax.swing.JLabel();
        jLabelKhoaLeft = new javax.swing.JLabel();
        jPanelHocKy = new javax.swing.JPanel();
        jLabelHocKy = new javax.swing.JLabel();
        jLabelHocKyLeft = new javax.swing.JLabel();
        jPanelLop = new javax.swing.JPanel();
        jLabelLop = new javax.swing.JLabel();
        jLabelLopLeft = new javax.swing.JLabel();
        jPanelCoVan = new javax.swing.JPanel();
        jLabelCoVan = new javax.swing.JLabel();
        jLabelCoVanLeft = new javax.swing.JLabel();
        jPanelTieuChi = new javax.swing.JPanel();
        jLabelTieuChi = new javax.swing.JLabel();
        jLabelTieuChiLeft = new javax.swing.JLabel();
        jPanelSinhVien = new javax.swing.JPanel();
        jLabelSinhVien = new javax.swing.JLabel();
        jLabelSinhVienLeft = new javax.swing.JLabel();
        jPanelDRL = new javax.swing.JPanel();
        jLabelDRL = new javax.swing.JLabel();
        jLabelDRLLeft = new javax.swing.JLabel();
        jPanelNullDot = new javax.swing.JPanel();
        jLabelThreedots = new javax.swing.JLabel();
        jPanelNullDot2 = new javax.swing.JPanel();
        jLabelThreeDots = new javax.swing.JLabel();
        jPanelHelp = new javax.swing.JPanel();
        jLabelHelp = new javax.swing.JLabel();
        jLabelLeft8 = new javax.swing.JLabel();
        jPanelLogOut = new javax.swing.JPanel();
        jLabelLogOut = new javax.swing.JLabel();
        jLabelLeft9 = new javax.swing.JLabel();
        jPanelPanel = new javax.swing.JPanel();
        jPanelContact = new javax.swing.JPanel();
        jPanelPtit = new javax.swing.JPanel();
        jLabelpanelPtit = new javax.swing.JLabel();
        jPanelNutLienHe = RoundedPanel.createRoundedPanel();
        jLabelNutLienHe = new javax.swing.JLabel();
        jLabelCloud = new javax.swing.JLabel();
        jLabelFb = new javax.swing.JLabel();
        jLabelThuongHieu = new javax.swing.JLabel();
        jLayeredPaneMain = new javax.swing.JLayeredPane();
        jPanelTrangChuMain = new javax.swing.JPanel();
        jPanelThanhTieuDeTrangChu1 = RoundedPanel.createRoundedPanel();
        jPanelNutTieuDeTrangChu1 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTrangChu1 = new javax.swing.JLabel();
        jPanel1 = RoundedPanel.createRoundedPanel();
        jLabelChonKhoa_Lop4 = new javax.swing.JLabel();
        jLabelHKXet = new javax.swing.JLabel();
        jLabelChonKhoa_Lop3 = new javax.swing.JLabel();
        jLabelNgayBD = new javax.swing.JLabel();
        jLabelChonKhoa_Lop7 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop5 = new javax.swing.JLabel();
        jLabelHanCV = new javax.swing.JLabel();
        jLabelChonKhoa_Lop8 = new javax.swing.JLabel();
        jLabelHanKhoa = new javax.swing.JLabel();
        jLabelChonKhoa_Lop6 = new javax.swing.JLabel();
        jLabelHanSV = new javax.swing.JLabel();
        jLabelHanCS = new javax.swing.JLabel();
        jPanelTableLop_Xet = new com.raven.swing.PanelBorder();
        jLabelTableTitleLop1 = new javax.swing.JLabel();
        jScrollPaneLopXet = new javax.swing.JScrollPane();
        jTableLopXet = new com.raven.swing.TableLop();
        choiceKhoa_LopXet = new java.awt.Choice();
        jLabelChonKhoa_Lop1 = new javax.swing.JLabel();
        jPanelKhoaMain = new javax.swing.JPanel();
        jPanelThanhTieuDeKhoa = new javax.swing.JPanel();
        jPanelNutTieuDeKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa = new javax.swing.JLabel();
        jPanelNutXoaKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutXoaKhoa = new javax.swing.JLabel();
        jPanelNutSuaKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutSuaKhoa = new javax.swing.JLabel();
        jPanelNutKhoaKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutKhoaKhoa = new javax.swing.JLabel();
        jPanelNutThemKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutThemKhoa = new javax.swing.JLabel();
        panelBorderTableKhoa = new com.raven.swing.PanelBorder();
        jLabelTableTitleKhoa = new javax.swing.JLabel();
        jScrollPaneKhoa = new javax.swing.JScrollPane();
        jTableKhoa = new com.raven.swing.TableKhoa();
        jPanelHocKyMain = new javax.swing.JPanel();
        jPanelThanhTieuDeHK = RoundedPanel.createRoundedPanel();
        jPanelNutTieuDeHK = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeHK = new javax.swing.JLabel();
        jPanelNutCapNhat = RoundedPanel.createRoundedPanel();
        jLabelNutCapNhat = new javax.swing.JLabel();
        jPanelBorderHocKy = new com.raven.swing.PanelBorder();
        jLabelTitleHocKy = new javax.swing.JLabel();
        jScrollPaneHocKy = new javax.swing.JScrollPane();
        jTableHocKy = new com.raven.swing.TableHocKy();
        jPanelNutThemHK = RoundedPanel.createRoundedPanel();
        jLabelNutThemHK = new javax.swing.JLabel();
        jPanelNutDoiTT = RoundedPanel.createRoundedPanel();
        jLabelNutDoiTT = new javax.swing.JLabel();
        jPanelBorderKhoaHoc = new com.raven.swing.PanelBorder();
        jLabelTitleKhoaHoc = new javax.swing.JLabel();
        jScrollPaneKhoaHoc = new javax.swing.JScrollPane();
        jTableKhoaHoc = new com.raven.swing.TableKhoaHoc();
        jPanelNutThemKhoaHoc = RoundedPanel.createRoundedPanel();
        jLabelNutThemKhoaHoc = new javax.swing.JLabel();
        jPanelBorderHanNop = new com.raven.swing.PanelBorder();
        jLabelTitleHanNop = new javax.swing.JLabel();
        jScrollPaneHanNop = new javax.swing.JScrollPane();
        jTableHanNop = new com.raven.swing.TableThongBao();
        jPanelNutDoiHanNop = RoundedPanel.createRoundedPanel();
        jLabelNutDoiHanNop = new javax.swing.JLabel();
        jPanelLopMain = new javax.swing.JPanel();
        jPanelThanhTieuDeLop = new javax.swing.JPanel();
        jPanelNutTieuDeLop = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa2 = new javax.swing.JLabel();
        jPanelNutXoaLop = RoundedPanel.createRoundedPanel();
        jLabelNutXoaLop = new javax.swing.JLabel();
        jPanelNutSuaLop = RoundedPanel.createRoundedPanel();
        jLabelNutSuaLop = new javax.swing.JLabel();
        jPanelNutThemLop = RoundedPanel.createRoundedPanel();
        jLabelNutThemLop = new javax.swing.JLabel();
        jPanelTableLop = new com.raven.swing.PanelBorder();
        jLabelTableTitleLop = new javax.swing.JLabel();
        jScrollPaneLop = new javax.swing.JScrollPane();
        jTableLop = new com.raven.swing.TableLop();
        choiceKhoa_Lop = new java.awt.Choice();
        jLabelChonKhoa_Lop = new javax.swing.JLabel();
        jPanelCoVanMain = new javax.swing.JPanel();
        jPanelThanhTieuDeCoVan = new javax.swing.JPanel();
        jPanelNutTieuDeCoVan = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeCoVan = new javax.swing.JLabel();
        jPanelNutXoaCoVan = RoundedPanel.createRoundedPanel();
        jLabelNutXoaCoVan = new javax.swing.JLabel();
        jPanelNutSuaCoVan = RoundedPanel.createRoundedPanel();
        jLabelNutSuaCoVan = new javax.swing.JLabel();
        jPanelNutThemCoVan = RoundedPanel.createRoundedPanel();
        jLabelNutThemCoVan = new javax.swing.JLabel();
        jPanelNutKhoaCV = RoundedPanel.createRoundedPanel();
        jLabelNutKhoaCV = new javax.swing.JLabel();
        jPanelTableCoVan = new com.raven.swing.PanelBorder();
        jLabelTableTitleCoVan = new javax.swing.JLabel();
        jScrollPaneCoVan = new javax.swing.JScrollPane();
        jTableCoVan = new com.raven.swing.TableCoVan();
        choiceKhoa_CoVan = new java.awt.Choice();
        jLabelChon1 = new javax.swing.JLabel();
        jPanelTieuChiMain = new javax.swing.JPanel();
        jPanelThanhTieuDeTieuChi = new javax.swing.JPanel();
        jPanelNutTieuDeTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTieuChi = new javax.swing.JLabel();
        jPanelNutXoaTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutXoaTieuChi = new javax.swing.JLabel();
        jPanelNutThemTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutThemTieuChi = new javax.swing.JLabel();
        jPanelBorderTieuChi = new com.raven.swing.PanelBorder();
        jLabelTitleTieuChi = new javax.swing.JLabel();
        jScrollPaneTieuChi = new javax.swing.JScrollPane();
        jTableTieuChi = new com.raven.swing.TableTieuChi();
        jPanelNutChiTietTC = RoundedPanel.createRoundedPanel();
        jLabelNutChiTietTC = new javax.swing.JLabel();
        jPanelSinhVienMain = new javax.swing.JPanel();
        jPanelTitleSV = new javax.swing.JPanel();
        jPanelNutTitleSV = RoundedPanel.createRoundedPanel();
        jLabelNutSV = new javax.swing.JLabel();
        jPanelXoaSV = RoundedPanel.createRoundedPanel();
        jLabelXoaSV = new javax.swing.JLabel();
        jPanelSuaSV = RoundedPanel.createRoundedPanel();
        jLabelSuaSV = new javax.swing.JLabel();
        jPanelThemSV = RoundedPanel.createRoundedPanel();
        jLabelThemSV = new javax.swing.JLabel();
        jPanelNutKhoaSV = RoundedPanel.createRoundedPanel();
        jLabelNutKhoaSV = new javax.swing.JLabel();
        jPanelBorderSV = new com.raven.swing.PanelBorder();
        jLabelTitleSV = new javax.swing.JLabel();
        jScrollPaneSV = new javax.swing.JScrollPane();
        jTableSV = new com.raven.swing.TableSinhVien();
        jLabelChon_SV = new javax.swing.JLabel();
        jLabelChonLop_SV = new javax.swing.JLabel();
        choiceKhoa_SV = new java.awt.Choice();
        choiceLop_SV = new java.awt.Choice();
        jPanelDuyetDiem = new javax.swing.JPanel();
        jPanelThanhTieuDeTrangChu = new javax.swing.JPanel();
        jPanelNutTieuDeTrangChu = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTrangChu = new javax.swing.JLabel();
        jPanelNutChamLai = RoundedPanel.createRoundedPanel();
        jLabelNutChamLai = new javax.swing.JLabel();
        jPanelNutDuyet = RoundedPanel.createRoundedPanel();
        jLabelNutDuyet = new javax.swing.JLabel();
        jPanelTabeDRL = new com.raven.swing.PanelBorder();
        jScrollPaneDRL = new javax.swing.JScrollPane();
        jTableDRL = new com.raven.swing.TableDRL();
        choiceKhoa_DRL = new java.awt.Choice();
        jLabelChon2 = new javax.swing.JLabel();
        jLabelChon3 = new javax.swing.JLabel();
        jLabelChonLop_SV1 = new javax.swing.JLabel();
        choiceLop_DRL = new java.awt.Choice();
        choiceHK_DRL = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Quản lý điểm rèn luyện học viện cơ sở");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelView.setBackground(new java.awt.Color(189, 56, 27));
        jPanelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setRequestFocusEnabled(false);
        jPanelMenu.setVerifyInputWhenFocusTarget(false);
        jPanelMenu.setLayout(new java.awt.GridLayout(12, 1));

        jPanelTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTrangChu.setForeground(new java.awt.Color(227, 70, 34));
        jLabelTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redhome.png"))); // NOI18N
        jLabelTrangChu.setText("TRANG CHỦ");

        jLabelTrangChuLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelTrangChuLayout = new javax.swing.GroupLayout(jPanelTrangChu);
        jPanelTrangChu.setLayout(jPanelTrangChuLayout);
        jPanelTrangChuLayout.setHorizontalGroup(
            jPanelTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTrangChuLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTrangChuLayout.setVerticalGroup(
            jPanelTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelTrangChuLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelTrangChu);

        jPanelKhoa.setBackground(new java.awt.Color(255, 255, 255));
        jPanelKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelKhoa.setBackground(new java.awt.Color(255, 255, 255));
        jLabelKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelKhoa.setForeground(new java.awt.Color(227, 70, 34));
        jLabelKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/khoa.png"))); // NOI18N
        jLabelKhoa.setText("KHOA");

        jLabelKhoaLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelKhoaLayout = new javax.swing.GroupLayout(jPanelKhoa);
        jPanelKhoa.setLayout(jPanelKhoaLayout);
        jPanelKhoaLayout.setHorizontalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelKhoaLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelKhoaLayout.setVerticalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelKhoaLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelKhoa);

        jPanelHocKy.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHocKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelHocKy.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHocKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHocKy.setForeground(new java.awt.Color(227, 70, 34));
        jLabelHocKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hocky.png"))); // NOI18N
        jLabelHocKy.setText("THỜI GIAN BIỂU");

        jLabelHocKyLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelHocKyLayout = new javax.swing.GroupLayout(jPanelHocKy);
        jPanelHocKy.setLayout(jPanelHocKyLayout);
        jPanelHocKyLayout.setHorizontalGroup(
            jPanelHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHocKyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHocKyLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHocKyLayout.setVerticalGroup(
            jPanelHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHocKy, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelHocKyLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelHocKy);

        jPanelLop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLop.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLop.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lop.png"))); // NOI18N
        jLabelLop.setText("LỚP");

        jLabelLopLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelLopLayout = new javax.swing.GroupLayout(jPanelLop);
        jPanelLop.setLayout(jPanelLopLayout);
        jPanelLopLayout.setHorizontalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLopLayout.setVerticalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLop, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelLopLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelLop);

        jPanelCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCoVan.setForeground(new java.awt.Color(227, 70, 34));
        jLabelCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/covan.png"))); // NOI18N
        jLabelCoVan.setText("CỐ VẤN");
        jLabelCoVan.setToolTipText("");

        jLabelCoVanLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelCoVanLayout = new javax.swing.GroupLayout(jPanelCoVan);
        jPanelCoVan.setLayout(jPanelCoVanLayout);
        jPanelCoVanLayout.setHorizontalGroup(
            jPanelCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoVanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCoVanLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCoVanLayout.setVerticalGroup(
            jPanelCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelCoVanLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelCoVan);

        jPanelTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTieuChi.setForeground(new java.awt.Color(227, 70, 34));
        jLabelTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/danhgia.png"))); // NOI18N
        jLabelTieuChi.setText("TIÊU CHÍ");
        jLabelTieuChi.setToolTipText("");

        jLabelTieuChiLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelTieuChiLayout = new javax.swing.GroupLayout(jPanelTieuChi);
        jPanelTieuChi.setLayout(jPanelTieuChiLayout);
        jPanelTieuChiLayout.setHorizontalGroup(
            jPanelTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTieuChiLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTieuChiLayout.setVerticalGroup(
            jPanelTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelTieuChiLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelTieuChi);

        jPanelSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSinhVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSinhVien.setForeground(new java.awt.Color(227, 70, 34));
        jLabelSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redstudent32.png"))); // NOI18N
        jLabelSinhVien.setText("SINH VIÊN");
        jLabelSinhVien.setToolTipText("");

        jLabelSinhVienLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelSinhVienLayout = new javax.swing.GroupLayout(jPanelSinhVien);
        jPanelSinhVien.setLayout(jPanelSinhVienLayout);
        jPanelSinhVienLayout.setHorizontalGroup(
            jPanelSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSinhVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSinhVienLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSinhVienLayout.setVerticalGroup(
            jPanelSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelSinhVienLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelSinhVien);

        jPanelDRL.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelDRL.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDRL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDRL.setForeground(new java.awt.Color(227, 70, 34));
        jLabelDRL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redtick.png"))); // NOI18N
        jLabelDRL.setText("DUYỆT ĐIỂM");
        jLabelDRL.setToolTipText("");

        jLabelDRLLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelDRLLayout = new javax.swing.GroupLayout(jPanelDRL);
        jPanelDRL.setLayout(jPanelDRLLayout);
        jPanelDRLLayout.setHorizontalGroup(
            jPanelDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDRLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDRLLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDRLLayout.setVerticalGroup(
            jPanelDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDRL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelDRLLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelDRL);

        jPanelNullDot.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelThreedots.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThreedots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/threedot.png"))); // NOI18N

        javax.swing.GroupLayout jPanelNullDotLayout = new javax.swing.GroupLayout(jPanelNullDot);
        jPanelNullDot.setLayout(jPanelNullDotLayout);
        jPanelNullDotLayout.setHorizontalGroup(
            jPanelNullDotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNullDotLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelThreedots, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNullDotLayout.setVerticalGroup(
            jPanelNullDotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNullDotLayout.createSequentialGroup()
                .addComponent(jLabelThreedots, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        jPanelMenu.add(jPanelNullDot);

        jPanelNullDot2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelThreeDots.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThreeDots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/threedot.png"))); // NOI18N

        javax.swing.GroupLayout jPanelNullDot2Layout = new javax.swing.GroupLayout(jPanelNullDot2);
        jPanelNullDot2.setLayout(jPanelNullDot2Layout);
        jPanelNullDot2Layout.setHorizontalGroup(
            jPanelNullDot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThreeDots, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );
        jPanelNullDot2Layout.setVerticalGroup(
            jPanelNullDot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNullDot2Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(jLabelThreeDots, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelMenu.add(jPanelNullDot2);

        jPanelHelp.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelHelp.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHelp.setForeground(new java.awt.Color(227, 70, 34));
        jLabelHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/help.png"))); // NOI18N
        jLabelHelp.setText("Hướng dẫn");

        jLabelLeft8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelHelpLayout = new javax.swing.GroupLayout(jPanelHelp);
        jPanelHelp.setLayout(jPanelHelpLayout);
        jPanelHelpLayout.setHorizontalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft8, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHelpLayout.setVerticalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelLeft8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelHelp);

        jPanelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLogOut.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jLabelLogOut.setText("Thoát");
        jLabelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseClicked(evt);
            }
        });

        jLabelLeft9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelLogOutLayout = new javax.swing.GroupLayout(jPanelLogOut);
        jPanelLogOut.setLayout(jPanelLogOutLayout);
        jPanelLogOutLayout.setHorizontalGroup(
            jPanelLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft9, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLogOutLayout.setVerticalGroup(
            jPanelLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelLeft9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelLogOut);

        jPanelView.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 140, 200, 600));

        jPanelPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContact.setBackground(new java.awt.Color(189, 56, 27));
        jPanelContact.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPtit.setBackground(new java.awt.Color(255, 255, 255));

        jLabelpanelPtit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoptithcm.png"))); // NOI18N
        jLabelpanelPtit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelNutLienHe.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutLienHe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutLienHe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutLienHe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/thongbaolienket.png"))); // NOI18N
        jLabelNutLienHe.setText("Xem thông tin mới nhất");
        jLabelNutLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutLienHe.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutLienHe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutLienHeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutLienHeLayout = new javax.swing.GroupLayout(jPanelNutLienHe);
        jPanelNutLienHe.setLayout(jPanelNutLienHeLayout);
        jPanelNutLienHeLayout.setHorizontalGroup(
            jPanelNutLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutLienHeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutLienHe, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
        );
        jPanelNutLienHeLayout.setVerticalGroup(
            jPanelNutLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutLienHe, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPtitLayout = new javax.swing.GroupLayout(jPanelPtit);
        jPanelPtit.setLayout(jPanelPtitLayout);
        jPanelPtitLayout.setHorizontalGroup(
            jPanelPtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabelpanelPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanelNutLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanelPtitLayout.setVerticalGroup(
            jPanelPtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addComponent(jLabelpanelPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanelNutLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelContact.add(jPanelPtit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1010, -1));

        jLabelCloud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cloud.png"))); // NOI18N
        jLabelCloud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCloud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloudMouseClicked(evt);
            }
        });
        jPanelContact.add(jLabelCloud, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, 30));

        jLabelFb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fb.png"))); // NOI18N
        jLabelFb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFbMouseClicked(evt);
            }
        });
        jPanelContact.add(jLabelFb, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, 30));

        jLabelThuongHieu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelThuongHieu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThuongHieu.setText("VERSION:PTITHCM's Student Training Point 2024 - DesignBy: ĐN");
        jLabelThuongHieu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelContact.add(jLabelThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 400, 30));

        jPanelPanel.add(jPanelContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 130));

        jPanelView.add(jPanelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        jLayeredPaneMain.setRequestFocusEnabled(false);
        jLayeredPaneMain.setVerifyInputWhenFocusTarget(false);
        jLayeredPaneMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTrangChuMain.setPreferredSize(new java.awt.Dimension(804, 612));
        jPanelTrangChuMain.setRequestFocusEnabled(false);
        jPanelTrangChuMain.setVerifyInputWhenFocusTarget(false);
        jPanelTrangChuMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTrangChu1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTrangChu1.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTrangChu1.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTrangChu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTrangChu1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTrangChu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitehome.png"))); // NOI18N
        jLabelNutTieuDeTrangChu1.setText("Trang chủ");
        jLabelNutTieuDeTrangChu1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTrangChu1.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTrangChu1Layout = new javax.swing.GroupLayout(jPanelNutTieuDeTrangChu1);
        jPanelNutTieuDeTrangChu1.setLayout(jPanelNutTieuDeTrangChu1Layout);
        jPanelNutTieuDeTrangChu1Layout.setHorizontalGroup(
            jPanelNutTieuDeTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDeTrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutTieuDeTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );
        jPanelNutTieuDeTrangChu1Layout.setVerticalGroup(
            jPanelNutTieuDeTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTrangChu1Layout = new javax.swing.GroupLayout(jPanelThanhTieuDeTrangChu1);
        jPanelThanhTieuDeTrangChu1.setLayout(jPanelThanhTieuDeTrangChu1Layout);
        jPanelThanhTieuDeTrangChu1Layout.setHorizontalGroup(
            jPanelThanhTieuDeTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTrangChu1Layout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(618, Short.MAX_VALUE))
        );
        jPanelThanhTieuDeTrangChu1Layout.setVerticalGroup(
            jPanelThanhTieuDeTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelTrangChuMain.add(jPanelThanhTieuDeTrangChu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 770, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabelChonKhoa_Lop4.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop4.setText("Học kỳ đang xét:");

        jLabelHKXet.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHKXet.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHKXet.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHKXet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHKXet.setText("2025-2026 I");
        jLabelHKXet.setOpaque(true);

        jLabelChonKhoa_Lop3.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop3.setText(", hạn nộp của sinh viên:");

        jLabelNgayBD.setBackground(new java.awt.Color(221, 51, 51));
        jLabelNgayBD.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelNgayBD.setForeground(new java.awt.Color(221, 51, 51));
        jLabelNgayBD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNgayBD.setText("22-06-2023");

        jLabelChonKhoa_Lop7.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop7.setText("Hạn nộp của cán sự lớp:");

        jLabelChonKhoa_Lop5.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop5.setText("Hạn nộp của CVHT:");

        jLabelHanCV.setBackground(new java.awt.Color(221, 51, 51));
        jLabelHanCV.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHanCV.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHanCV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHanCV.setText("22-06-2023");

        jLabelChonKhoa_Lop8.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop8.setText(", hạn nộp của khoa:");

        jLabelHanKhoa.setBackground(new java.awt.Color(221, 51, 51));
        jLabelHanKhoa.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHanKhoa.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHanKhoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHanKhoa.setText("2025-2026 I");

        jLabelChonKhoa_Lop6.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop6.setText(", ngày bắt đầu xét:");

        jLabelHanSV.setBackground(new java.awt.Color(221, 51, 51));
        jLabelHanSV.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHanSV.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHanSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHanSV.setText("22-06-2023");

        jLabelHanCS.setBackground(new java.awt.Color(221, 51, 51));
        jLabelHanCS.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHanCS.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHanCS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHanCS.setText("2025-2026 I");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelChonKhoa_Lop7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanCS, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelChonKhoa_Lop5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanCV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelChonKhoa_Lop8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelChonKhoa_Lop4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHKXet, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelChonKhoa_Lop6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelChonKhoa_Lop3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanSV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHKXet, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHanSV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHanCV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHanKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHanCS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jPanelTrangChuMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 70));

        jPanelTableLop_Xet.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTableLop_Xet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabelTableTitleLop1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTableTitleLop1.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTableTitleLop1.setText("DS lớp thuộc khoa đang trong thời gian xét");

        jScrollPaneLopXet.setBorder(null);
        jScrollPaneLopXet.setVerticalScrollBar(new ScrollBar());
        jScrollPaneLopXet.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneLopXet.getViewport().setBackground(Color.WHITE);
        JPanel p24 = new JPanel();
        p24.setBackground(Color.WHITE);
        jScrollPaneLop.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p24);

        jTableLopXet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableLopXet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "   Lớp", "  Khoa", "  Cố vấn", "  Khóa học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLopXet.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableLopXet.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableLopXet.setShowGrid(true);
        jTableLopXet.setShowVerticalLines(false);
        jScrollPaneLopXet.setViewportView(jTableLopXet);

        choiceKhoa_LopXet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_LopXet.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_LopXet.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_LopXet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_LopXetItemStateChanged(evt);
            }
        });

        jLabelChonKhoa_Lop1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop1.setText("Chọn khoa:");

        javax.swing.GroupLayout jPanelTableLop_XetLayout = new javax.swing.GroupLayout(jPanelTableLop_Xet);
        jPanelTableLop_Xet.setLayout(jPanelTableLop_XetLayout);
        jPanelTableLop_XetLayout.setHorizontalGroup(
            jPanelTableLop_XetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLop_XetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelTableLop_XetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneLopXet, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTableLop_XetLayout.createSequentialGroup()
                        .addComponent(jLabelTableTitleLop1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelChonKhoa_Lop1)
                        .addGap(2, 2, 2)
                        .addComponent(choiceKhoa_LopXet, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelTableLop_XetLayout.setVerticalGroup(
            jPanelTableLop_XetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLop_XetLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelTableLop_XetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTableTitleLop1)
                    .addComponent(choiceKhoa_LopXet, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneLopXet, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelTrangChuMain.add(jPanelTableLop_Xet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 760, 440));

        jLayeredPaneMain.add(jPanelTrangChuMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jPanelKhoaMain.setPreferredSize(new java.awt.Dimension(621, 436));
        jPanelKhoaMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeKhoa.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeKhoa.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeKhoa.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeKhoa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteschool.png"))); // NOI18N
        jLabelNutTieuDeKhoa.setText("Khoa");
        jLabelNutTieuDeKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeKhoa.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeKhoaLayout = new javax.swing.GroupLayout(jPanelNutTieuDeKhoa);
        jPanelNutTieuDeKhoa.setLayout(jPanelNutTieuDeKhoaLayout);
        jPanelNutTieuDeKhoaLayout.setHorizontalGroup(
            jPanelNutTieuDeKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDeKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutTieuDeKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );
        jPanelNutTieuDeKhoaLayout.setVerticalGroup(
            jPanelNutTieuDeKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaKhoa.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutXoaKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutXoaKhoa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutXoaKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitedelete.png"))); // NOI18N
        jLabelNutXoaKhoa.setText("Xóa");
        jLabelNutXoaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutXoaKhoa.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutXoaKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutXoaKhoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutXoaKhoaLayout = new javax.swing.GroupLayout(jPanelNutXoaKhoa);
        jPanelNutXoaKhoa.setLayout(jPanelNutXoaKhoaLayout);
        jPanelNutXoaKhoaLayout.setHorizontalGroup(
            jPanelNutXoaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutXoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
        );
        jPanelNutXoaKhoaLayout.setVerticalGroup(
            jPanelNutXoaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutXoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutSuaKhoa.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutSuaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutSuaKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutSuaKhoa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutSuaKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitewrite.png"))); // NOI18N
        jLabelNutSuaKhoa.setText("Cập nhật");
        jLabelNutSuaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutSuaKhoa.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutSuaKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutSuaKhoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutSuaKhoaLayout = new javax.swing.GroupLayout(jPanelNutSuaKhoa);
        jPanelNutSuaKhoa.setLayout(jPanelNutSuaKhoaLayout);
        jPanelNutSuaKhoaLayout.setHorizontalGroup(
            jPanelNutSuaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSuaKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutSuaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );
        jPanelNutSuaKhoaLayout.setVerticalGroup(
            jPanelNutSuaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutSuaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutKhoaKhoa.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutKhoaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutKhoaKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutKhoaKhoa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutKhoaKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclose.png"))); // NOI18N
        jLabelNutKhoaKhoa.setText("Mở /Khóa TK");
        jLabelNutKhoaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutKhoaKhoa.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutKhoaKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutKhoaKhoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutKhoaKhoaLayout = new javax.swing.GroupLayout(jPanelNutKhoaKhoa);
        jPanelNutKhoaKhoa.setLayout(jPanelNutKhoaKhoaLayout);
        jPanelNutKhoaKhoaLayout.setHorizontalGroup(
            jPanelNutKhoaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutKhoaKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutKhoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
        );
        jPanelNutKhoaKhoaLayout.setVerticalGroup(
            jPanelNutKhoaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutKhoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelNutThemKhoa.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutThemKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutThemKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutThemKhoa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutThemKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelNutThemKhoa.setText("Thêm");
        jLabelNutThemKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutThemKhoa.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutThemKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutThemKhoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutThemKhoaLayout = new javax.swing.GroupLayout(jPanelNutThemKhoa);
        jPanelNutThemKhoa.setLayout(jPanelNutThemKhoaLayout);
        jPanelNutThemKhoaLayout.setHorizontalGroup(
            jPanelNutThemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutThemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
        );
        jPanelNutThemKhoaLayout.setVerticalGroup(
            jPanelNutThemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutThemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeKhoaLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeKhoa);
        jPanelThanhTieuDeKhoa.setLayout(jPanelThanhTieuDeKhoaLayout);
        jPanelThanhTieuDeKhoaLayout.setHorizontalGroup(
            jPanelThanhTieuDeKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeKhoaLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jPanelNutKhoaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutThemKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutSuaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutXoaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeKhoaLayout.setVerticalGroup(
            jPanelThanhTieuDeKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutXoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutSuaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutThemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutKhoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelKhoaMain.add(jPanelThanhTieuDeKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        panelBorderTableKhoa.setBackground(new java.awt.Color(255, 255, 255));
        panelBorderTableKhoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabelTableTitleKhoa.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTableTitleKhoa.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTableTitleKhoa.setText("Danh sách các khoa");

        jScrollPaneKhoa.setBorder(null);
        jScrollPaneKhoa.setVerticalScrollBar(new ScrollBar());
        jScrollPaneKhoa.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneKhoa.getViewport().setBackground(Color.WHITE);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        jScrollPaneKhoa.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p1);

        jTableKhoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khoa", "Tên khoa", "Ngày thành lập", "Tên đăng nhập", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKhoa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableKhoa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableKhoa.setShowGrid(true);
        jTableKhoa.setShowVerticalLines(false);
        jScrollPaneKhoa.setViewportView(jTableKhoa);

        javax.swing.GroupLayout panelBorderTableKhoaLayout = new javax.swing.GroupLayout(panelBorderTableKhoa);
        panelBorderTableKhoa.setLayout(panelBorderTableKhoaLayout);
        panelBorderTableKhoaLayout.setHorizontalGroup(
            panelBorderTableKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderTableKhoaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorderTableKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTableTitleKhoa))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelBorderTableKhoaLayout.setVerticalGroup(
            panelBorderTableKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderTableKhoaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTableTitleKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelKhoaMain.add(panelBorderTableKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 760, 520));

        jLayeredPaneMain.add(jPanelKhoaMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelHocKyMain.setPreferredSize(new java.awt.Dimension(790, 620));
        jPanelHocKyMain.setRequestFocusEnabled(false);
        jPanelHocKyMain.setVerifyInputWhenFocusTarget(false);
        jPanelHocKyMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeHK.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeHK.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeHK.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeHK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeHK.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeHK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitecalender.png"))); // NOI18N
        jLabelNutTieuDeHK.setText("Học kỳ");
        jLabelNutTieuDeHK.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeHK.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeHKLayout = new javax.swing.GroupLayout(jPanelNutTieuDeHK);
        jPanelNutTieuDeHK.setLayout(jPanelNutTieuDeHKLayout);
        jPanelNutTieuDeHKLayout.setHorizontalGroup(
            jPanelNutTieuDeHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeHKLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeHK, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTieuDeHKLayout.setVerticalGroup(
            jPanelNutTieuDeHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeHK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelNutCapNhat.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitechange.png"))); // NOI18N
        jLabelNutCapNhat.setText("Cập nhật lại");
        jLabelNutCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutCapNhat.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutCapNhatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutCapNhatLayout = new javax.swing.GroupLayout(jPanelNutCapNhat);
        jPanelNutCapNhat.setLayout(jPanelNutCapNhatLayout);
        jPanelNutCapNhatLayout.setHorizontalGroup(
            jPanelNutCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutCapNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );
        jPanelNutCapNhatLayout.setVerticalGroup(
            jPanelNutCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeHKLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeHK);
        jPanelThanhTieuDeHK.setLayout(jPanelThanhTieuDeHKLayout);
        jPanelThanhTieuDeHKLayout.setHorizontalGroup(
            jPanelThanhTieuDeHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeHKLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                .addComponent(jPanelNutCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeHKLayout.setVerticalGroup(
            jPanelThanhTieuDeHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeHK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelThanhTieuDeHKLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelNutCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelHocKyMain.add(jPanelThanhTieuDeHK, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelBorderHocKy.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBorderHocKy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelBorderHocKy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitleHocKy.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTitleHocKy.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTitleHocKy.setText("Học kỳ");
        jPanelBorderHocKy.add(jLabelTitleHocKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPaneHocKy.setBorder(null);
        // Code of sub-components and layout - not shown here

        // Code adding the component to the parent container - not shown here
        jScrollPaneHocKy.setVerticalScrollBar(new ScrollBar());
        jScrollPaneHocKy.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneHocKy.getViewport().setBackground(Color.WHITE);
        JPanel p4 = new JPanel();
        p4.setBackground(Color.WHITE);
        jScrollPaneHocKy.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p4);

        jTableHocKy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableHocKy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số thứ tự", "Học kỳ", "Niên Khóa", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHocKy.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHocKy.setShowGrid(true);
        jScrollPaneHocKy.setViewportView(jTableHocKy);
        // Code of sub-components and layout - not shown here

        // Code adding the component to the parent container - not shown here

        jPanelBorderHocKy.add(jScrollPaneHocKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 49, 395, 190));

        jPanelNutThemHK.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutThemHK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutThemHK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutThemHK.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutThemHK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelNutThemHK.setText("Thêm");
        jLabelNutThemHK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutThemHK.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutThemHK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutThemHKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutThemHKLayout = new javax.swing.GroupLayout(jPanelNutThemHK);
        jPanelNutThemHK.setLayout(jPanelNutThemHKLayout);
        jPanelNutThemHKLayout.setHorizontalGroup(
            jPanelNutThemHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemHKLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNutThemHK, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jPanelNutThemHKLayout.setVerticalGroup(
            jPanelNutThemHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutThemHK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelBorderHocKy.add(jPanelNutThemHK, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 6, 100, 40));

        jPanelNutDoiTT.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutDoiTT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutDoiTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutDoiTT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutDoiTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitechange.png"))); // NOI18N
        jLabelNutDoiTT.setText("Đổi HK xét");
        jLabelNutDoiTT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutDoiTT.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutDoiTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutDoiTTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutDoiTTLayout = new javax.swing.GroupLayout(jPanelNutDoiTT);
        jPanelNutDoiTT.setLayout(jPanelNutDoiTTLayout);
        jPanelNutDoiTTLayout.setHorizontalGroup(
            jPanelNutDoiTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutDoiTTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutDoiTT, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );
        jPanelNutDoiTTLayout.setVerticalGroup(
            jPanelNutDoiTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutDoiTT, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelBorderHocKy.add(jPanelNutDoiTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 6, 130, 40));

        jPanelHocKyMain.add(jPanelBorderHocKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 430, 250));

        jPanelBorderKhoaHoc.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBorderKhoaHoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelBorderKhoaHoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitleKhoaHoc.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTitleKhoaHoc.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTitleKhoaHoc.setText("Khóa học");
        jPanelBorderKhoaHoc.add(jLabelTitleKhoaHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPaneKhoaHoc.setBorder(null);

        jTableKhoaHoc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số thứ tự", "Khóa học", "Số năm học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKhoaHoc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableKhoaHoc.setShowGrid(true);
        jScrollPaneKhoaHoc.setViewportView(jTableKhoaHoc);
        if (jTableKhoaHoc.getColumnModel().getColumnCount() > 0) {
            jTableKhoaHoc.getColumnModel().getColumn(1).setResizable(false);
            jTableKhoaHoc.getColumnModel().getColumn(2).setHeaderValue("Số năm học");
        }

        jPanelBorderKhoaHoc.add(jScrollPaneKhoaHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 49, 285, 190));
        jScrollPaneKhoaHoc.setVerticalScrollBar(new ScrollBar());
        jScrollPaneKhoaHoc.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneKhoaHoc.getViewport().setBackground(Color.WHITE);
        JPanel p3 = new JPanel();
        p3.setBackground(Color.WHITE);
        jScrollPaneKhoaHoc.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p3);

        jPanelNutThemKhoaHoc.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutThemKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutThemKhoaHoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutThemKhoaHoc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutThemKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelNutThemKhoaHoc.setText("Thêm");
        jLabelNutThemKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutThemKhoaHoc.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutThemKhoaHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutThemKhoaHocMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutThemKhoaHocLayout = new javax.swing.GroupLayout(jPanelNutThemKhoaHoc);
        jPanelNutThemKhoaHoc.setLayout(jPanelNutThemKhoaHocLayout);
        jPanelNutThemKhoaHocLayout.setHorizontalGroup(
            jPanelNutThemKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemKhoaHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutThemKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
        );
        jPanelNutThemKhoaHocLayout.setVerticalGroup(
            jPanelNutThemKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutThemKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanelBorderKhoaHoc.add(jPanelNutThemKhoaHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 6, 100, -1));

        jPanelHocKyMain.add(jPanelBorderKhoaHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 320, 250));

        jPanelBorderHanNop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBorderHanNop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelBorderHanNop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitleHanNop.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTitleHanNop.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTitleHanNop.setText("Hạn nộp điểm");
        jPanelBorderHanNop.add(jLabelTitleHanNop, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, -1));

        jScrollPaneHanNop.setBorder(null);

        jTableHanNop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableHanNop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Học kỳ", "Bắt đầu", "Hạn của SV", "Hạn của CS", "Hạn của CVHT", "Hạn của Khoa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHanNop.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHanNop.setShowGrid(true);
        jTableHanNop.setShowVerticalLines(false);
        jScrollPaneHanNop.setViewportView(jTableHanNop);

        jPanelBorderHanNop.add(jScrollPaneHanNop, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 54, 725, 200));
        jScrollPaneHanNop.setVerticalScrollBar(new ScrollBar());
        jScrollPaneHanNop.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneHanNop.getViewport().setBackground(Color.WHITE);
        JPanel p19 = new JPanel();
        p19.setBackground(Color.WHITE);
        jScrollPaneHanNop.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p19);

        jPanelNutDoiHanNop.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutDoiHanNop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutDoiHanNop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutDoiHanNop.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutDoiHanNop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitetime.png"))); // NOI18N
        jLabelNutDoiHanNop.setText("Đổi thời gian");
        jLabelNutDoiHanNop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutDoiHanNop.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutDoiHanNop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutDoiHanNopMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutDoiHanNopLayout = new javax.swing.GroupLayout(jPanelNutDoiHanNop);
        jPanelNutDoiHanNop.setLayout(jPanelNutDoiHanNopLayout);
        jPanelNutDoiHanNopLayout.setHorizontalGroup(
            jPanelNutDoiHanNopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutDoiHanNopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutDoiHanNop, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );
        jPanelNutDoiHanNopLayout.setVerticalGroup(
            jPanelNutDoiHanNopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutDoiHanNop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelBorderHanNop.add(jPanelNutDoiHanNop, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 10, 150, 40));

        jPanelHocKyMain.add(jPanelBorderHanNop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 760, 270));

        jLayeredPaneMain.add(jPanelHocKyMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelLopMain.setPreferredSize(new java.awt.Dimension(684, 505));
        jPanelLopMain.setRequestFocusEnabled(false);
        jPanelLopMain.setVerifyInputWhenFocusTarget(false);
        jPanelLopMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeLop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeLop.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeLop.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeKhoa2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeKhoa2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeKhoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclass.png"))); // NOI18N
        jLabelNutTieuDeKhoa2.setText("Lớp");
        jLabelNutTieuDeKhoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeKhoa2.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeLopLayout = new javax.swing.GroupLayout(jPanelNutTieuDeLop);
        jPanelNutTieuDeLop.setLayout(jPanelNutTieuDeLopLayout);
        jPanelNutTieuDeLopLayout.setHorizontalGroup(
            jPanelNutTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeLopLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTieuDeLopLayout.setVerticalGroup(
            jPanelNutTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaLop.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutXoaLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutXoaLop.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutXoaLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitedelete.png"))); // NOI18N
        jLabelNutXoaLop.setText("Xóa");
        jLabelNutXoaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutXoaLop.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutXoaLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutXoaLopMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutXoaLopLayout = new javax.swing.GroupLayout(jPanelNutXoaLop);
        jPanelNutXoaLop.setLayout(jPanelNutXoaLopLayout);
        jPanelNutXoaLopLayout.setHorizontalGroup(
            jPanelNutXoaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelNutXoaLopLayout.setVerticalGroup(
            jPanelNutXoaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutSuaLop.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutSuaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutSuaLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutSuaLop.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutSuaLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitewrite.png"))); // NOI18N
        jLabelNutSuaLop.setText("Cập nhật");
        jLabelNutSuaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutSuaLop.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutSuaLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutSuaLopMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutSuaLopLayout = new javax.swing.GroupLayout(jPanelNutSuaLop);
        jPanelNutSuaLop.setLayout(jPanelNutSuaLopLayout);
        jPanelNutSuaLopLayout.setHorizontalGroup(
            jPanelNutSuaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSuaLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutSuaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
        );
        jPanelNutSuaLopLayout.setVerticalGroup(
            jPanelNutSuaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutSuaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutThemLop.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutThemLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutThemLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutThemLop.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutThemLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelNutThemLop.setText("Thêm");
        jLabelNutThemLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutThemLop.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutThemLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutThemLopMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutThemLopLayout = new javax.swing.GroupLayout(jPanelNutThemLop);
        jPanelNutThemLop.setLayout(jPanelNutThemLopLayout);
        jPanelNutThemLopLayout.setHorizontalGroup(
            jPanelNutThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
        );
        jPanelNutThemLopLayout.setVerticalGroup(
            jPanelNutThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeLopLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeLop);
        jPanelThanhTieuDeLop.setLayout(jPanelThanhTieuDeLopLayout);
        jPanelThanhTieuDeLopLayout.setHorizontalGroup(
            jPanelThanhTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeLopLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(jPanelNutThemLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutSuaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutXoaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeLopLayout.setVerticalGroup(
            jPanelThanhTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutSuaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelLopMain.add(jPanelThanhTieuDeLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelTableLop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTableLop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabelTableTitleLop.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTableTitleLop.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTableTitleLop.setText("Danh sách các lớp");

        jScrollPaneLop.setBorder(null);
        jScrollPaneLop.setVerticalScrollBar(new ScrollBar());
        jScrollPaneLop.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneLop.getViewport().setBackground(Color.WHITE);
        JPanel p5 = new JPanel();
        p5.setBackground(Color.WHITE);
        jScrollPaneLop.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p5);

        jTableLop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "   Lớp", "  Khoa", "  Cố vấn", "  Khóa học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLop.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableLop.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableLop.setShowGrid(true);
        jTableLop.setShowVerticalLines(false);
        jScrollPaneLop.setViewportView(jTableLop);

        choiceKhoa_Lop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_Lop.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_Lop.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_Lop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_LopItemStateChanged(evt);
            }
        });

        jLabelChonKhoa_Lop.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop.setText("Chọn khoa:");

        javax.swing.GroupLayout jPanelTableLopLayout = new javax.swing.GroupLayout(jPanelTableLop);
        jPanelTableLop.setLayout(jPanelTableLopLayout);
        jPanelTableLopLayout.setHorizontalGroup(
            jPanelTableLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLopLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelTableLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneLop, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTableLopLayout.createSequentialGroup()
                        .addComponent(jLabelTableTitleLop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelChonKhoa_Lop)
                        .addGap(2, 2, 2)
                        .addComponent(choiceKhoa_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelTableLopLayout.setVerticalGroup(
            jPanelTableLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLopLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelTableLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTableTitleLop)
                    .addComponent(choiceKhoa_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneLop, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelLopMain.add(jPanelTableLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelLopMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelCoVanMain.setPreferredSize(new java.awt.Dimension(645, 461));
        jPanelCoVanMain.setRequestFocusEnabled(false);
        jPanelCoVanMain.setVerifyInputWhenFocusTarget(false);
        jPanelCoVanMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeCoVan.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeCoVan.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeCoVan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteteacher.png"))); // NOI18N
        jLabelNutTieuDeCoVan.setText("Cố vấn");
        jLabelNutTieuDeCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeCoVan.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeCoVanLayout = new javax.swing.GroupLayout(jPanelNutTieuDeCoVan);
        jPanelNutTieuDeCoVan.setLayout(jPanelNutTieuDeCoVanLayout);
        jPanelNutTieuDeCoVanLayout.setHorizontalGroup(
            jPanelNutTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeCoVanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTieuDeCoVanLayout.setVerticalGroup(
            jPanelNutTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaCoVan.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutXoaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutXoaCoVan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutXoaCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitedelete.png"))); // NOI18N
        jLabelNutXoaCoVan.setText("Xóa");
        jLabelNutXoaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutXoaCoVan.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutXoaCoVan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutXoaCoVanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutXoaCoVanLayout = new javax.swing.GroupLayout(jPanelNutXoaCoVan);
        jPanelNutXoaCoVan.setLayout(jPanelNutXoaCoVanLayout);
        jPanelNutXoaCoVanLayout.setHorizontalGroup(
            jPanelNutXoaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaCoVanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutXoaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelNutXoaCoVanLayout.setVerticalGroup(
            jPanelNutXoaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutXoaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutSuaCoVan.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutSuaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutSuaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutSuaCoVan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutSuaCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitewrite.png"))); // NOI18N
        jLabelNutSuaCoVan.setText("Cập nhật");
        jLabelNutSuaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutSuaCoVan.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutSuaCoVan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutSuaCoVanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutSuaCoVanLayout = new javax.swing.GroupLayout(jPanelNutSuaCoVan);
        jPanelNutSuaCoVan.setLayout(jPanelNutSuaCoVanLayout);
        jPanelNutSuaCoVanLayout.setHorizontalGroup(
            jPanelNutSuaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSuaCoVanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutSuaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanelNutSuaCoVanLayout.setVerticalGroup(
            jPanelNutSuaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutSuaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutThemCoVan.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutThemCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutThemCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutThemCoVan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutThemCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelNutThemCoVan.setText("Thêm");
        jLabelNutThemCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutThemCoVan.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutThemCoVan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutThemCoVanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutThemCoVanLayout = new javax.swing.GroupLayout(jPanelNutThemCoVan);
        jPanelNutThemCoVan.setLayout(jPanelNutThemCoVanLayout);
        jPanelNutThemCoVanLayout.setHorizontalGroup(
            jPanelNutThemCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemCoVanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutThemCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
        );
        jPanelNutThemCoVanLayout.setVerticalGroup(
            jPanelNutThemCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutThemCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutKhoaCV.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutKhoaCV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutKhoaCV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutKhoaCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutKhoaCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclose.png"))); // NOI18N
        jLabelNutKhoaCV.setText("Mở /Khóa TK");
        jLabelNutKhoaCV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutKhoaCV.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutKhoaCV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutKhoaCVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutKhoaCVLayout = new javax.swing.GroupLayout(jPanelNutKhoaCV);
        jPanelNutKhoaCV.setLayout(jPanelNutKhoaCVLayout);
        jPanelNutKhoaCVLayout.setHorizontalGroup(
            jPanelNutKhoaCVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutKhoaCVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutKhoaCV, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
        );
        jPanelNutKhoaCVLayout.setVerticalGroup(
            jPanelNutKhoaCVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutKhoaCV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeCoVanLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeCoVan);
        jPanelThanhTieuDeCoVan.setLayout(jPanelThanhTieuDeCoVanLayout);
        jPanelThanhTieuDeCoVanLayout.setHorizontalGroup(
            jPanelThanhTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeCoVanLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(jPanelNutKhoaCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutThemCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutSuaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutXoaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeCoVanLayout.setVerticalGroup(
            jPanelThanhTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutXoaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutSuaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutThemCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutKhoaCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelCoVanMain.add(jPanelThanhTieuDeCoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelTableCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTableCoVan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabelTableTitleCoVan.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTableTitleCoVan.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTableTitleCoVan.setText("Danh sách các cố vấn");

        jScrollPaneCoVan.setBorder(null);
        jScrollPaneCoVan.setVerticalScrollBar(new ScrollBar());
        jScrollPaneCoVan.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneCoVan.getViewport().setBackground(Color.WHITE);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.WHITE);
        jScrollPaneCoVan.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p2);

        jTableCoVan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableCoVan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã cố vấn", "  Tên cố vấn", "  Email trường cấp", "  Khoa", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCoVan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableCoVan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCoVan.setShowGrid(true);
        jTableCoVan.setShowVerticalLines(false);
        jScrollPaneCoVan.setViewportView(jTableCoVan);

        choiceKhoa_CoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_CoVan.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_CoVan.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_CoVan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_CoVanItemStateChanged(evt);
            }
        });

        jLabelChon1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChon1.setText("Chọn khoa:");

        javax.swing.GroupLayout jPanelTableCoVanLayout = new javax.swing.GroupLayout(jPanelTableCoVan);
        jPanelTableCoVan.setLayout(jPanelTableCoVanLayout);
        jPanelTableCoVanLayout.setHorizontalGroup(
            jPanelTableCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableCoVanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelTableCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTableCoVanLayout.createSequentialGroup()
                        .addComponent(jLabelTableTitleCoVan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelChon1)
                        .addGap(2, 2, 2)
                        .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelTableCoVanLayout.setVerticalGroup(
            jPanelTableCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableCoVanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelTableCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTableTitleCoVan)
                    .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChon1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanelCoVanMain.add(jPanelTableCoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelCoVanMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelTieuChiMain.setPreferredSize(new java.awt.Dimension(790, 620));
        jPanelTieuChiMain.setRequestFocusEnabled(false);
        jPanelTieuChiMain.setVerifyInputWhenFocusTarget(false);
        jPanelTieuChiMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTieuChi.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTieuChi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitetieuchi.png"))); // NOI18N
        jLabelNutTieuDeTieuChi.setText("Tiêu chí");
        jLabelNutTieuDeTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelNutTieuDeTieuChi);
        jPanelNutTieuDeTieuChi.setLayout(jPanelNutTieuDeTieuChiLayout);
        jPanelNutTieuDeTieuChiLayout.setHorizontalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeTieuChiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTieuDeTieuChiLayout.setVerticalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaTieuChi.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutXoaTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutXoaTieuChi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutXoaTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitedelete.png"))); // NOI18N
        jLabelNutXoaTieuChi.setText("Xóa");
        jLabelNutXoaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutXoaTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutXoaTieuChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutXoaTieuChiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutXoaTieuChiLayout = new javax.swing.GroupLayout(jPanelNutXoaTieuChi);
        jPanelNutXoaTieuChi.setLayout(jPanelNutXoaTieuChiLayout);
        jPanelNutXoaTieuChiLayout.setHorizontalGroup(
            jPanelNutXoaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelNutXoaTieuChiLayout.setVerticalGroup(
            jPanelNutXoaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutThemTieuChi.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutThemTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutThemTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutThemTieuChi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutThemTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelNutThemTieuChi.setText("Thêm");
        jLabelNutThemTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutThemTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutThemTieuChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutThemTieuChiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutThemTieuChiLayout = new javax.swing.GroupLayout(jPanelNutThemTieuChi);
        jPanelNutThemTieuChi.setLayout(jPanelNutThemTieuChiLayout);
        jPanelNutThemTieuChiLayout.setHorizontalGroup(
            jPanelNutThemTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutThemTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
        );
        jPanelNutThemTieuChiLayout.setVerticalGroup(
            jPanelNutThemTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutThemTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeTieuChi);
        jPanelThanhTieuDeTieuChi.setLayout(jPanelThanhTieuDeTieuChiLayout);
        jPanelThanhTieuDeTieuChiLayout.setHorizontalGroup(
            jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTieuChiLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
                .addComponent(jPanelNutThemTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutXoaTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTieuChiLayout.setVerticalGroup(
            jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutThemTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelTieuChiMain.add(jPanelThanhTieuDeTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelBorderTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBorderTieuChi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTitleTieuChi.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTitleTieuChi.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTitleTieuChi.setText("Tiêu chí đánh giá");

        jScrollPaneTieuChi.setBorder(null);

        jTableTieuChi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableTieuChi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số thứ tự", "Nội dung", "Điểm quyết định"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTieuChi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTieuChi.setShowGrid(true);
        jScrollPaneTieuChi.setViewportView(jTableTieuChi);

        jPanelNutChiTietTC.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutChiTietTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutChiTietTC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutChiTietTC.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutChiTietTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteview.png"))); // NOI18N
        jLabelNutChiTietTC.setText("Xem chi tiết");
        jLabelNutChiTietTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutChiTietTC.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutChiTietTC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutChiTietTCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutChiTietTCLayout = new javax.swing.GroupLayout(jPanelNutChiTietTC);
        jPanelNutChiTietTC.setLayout(jPanelNutChiTietTCLayout);
        jPanelNutChiTietTCLayout.setHorizontalGroup(
            jPanelNutChiTietTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutChiTietTCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutChiTietTC, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );
        jPanelNutChiTietTCLayout.setVerticalGroup(
            jPanelNutChiTietTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutChiTietTC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelBorderTieuChiLayout = new javax.swing.GroupLayout(jPanelBorderTieuChi);
        jPanelBorderTieuChi.setLayout(jPanelBorderTieuChiLayout);
        jPanelBorderTieuChiLayout.setHorizontalGroup(
            jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                        .addComponent(jLabelTitleTieuChi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelNutChiTietTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelBorderTieuChiLayout.setVerticalGroup(
            jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitleTieuChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelNutChiTietTC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPaneTieuChi.setVerticalScrollBar(new ScrollBar());
        jScrollPaneTieuChi.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneTieuChi.getViewport().setBackground(Color.WHITE);
        JPanel p6 = new JPanel();
        p6.setBackground(Color.WHITE);
        jScrollPaneTieuChi.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p6);

        jPanelTieuChiMain.add(jPanelBorderTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelTieuChiMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelSinhVienMain.setPreferredSize(new java.awt.Dimension(574, 409));
        jPanelSinhVienMain.setRequestFocusEnabled(false);
        jPanelSinhVienMain.setVerifyInputWhenFocusTarget(false);
        jPanelSinhVienMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitleSV.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTitleSV.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTitleSV.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclass.png"))); // NOI18N
        jLabelNutSV.setText("Danh sách sinh viên");
        jLabelNutSV.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutSV.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTitleSVLayout = new javax.swing.GroupLayout(jPanelNutTitleSV);
        jPanelNutTitleSV.setLayout(jPanelNutTitleSVLayout);
        jPanelNutTitleSVLayout.setHorizontalGroup(
            jPanelNutTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTitleSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutSV, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTitleSVLayout.setVerticalGroup(
            jPanelNutTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelXoaSV.setBackground(new java.awt.Color(221, 51, 51));
        jPanelXoaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelXoaSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelXoaSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelXoaSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitedelete.png"))); // NOI18N
        jLabelXoaSV.setText("Xóa");
        jLabelXoaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelXoaSV.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelXoaSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelXoaSVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelXoaSVLayout = new javax.swing.GroupLayout(jPanelXoaSV);
        jPanelXoaSV.setLayout(jPanelXoaSVLayout);
        jPanelXoaSVLayout.setHorizontalGroup(
            jPanelXoaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelXoaSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelXoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelXoaSVLayout.setVerticalGroup(
            jPanelXoaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelXoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelSuaSV.setBackground(new java.awt.Color(221, 51, 51));
        jPanelSuaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelSuaSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSuaSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSuaSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitewrite.png"))); // NOI18N
        jLabelSuaSV.setText("Sửa");
        jLabelSuaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSuaSV.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelSuaSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSuaSVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelSuaSVLayout = new javax.swing.GroupLayout(jPanelSuaSV);
        jPanelSuaSV.setLayout(jPanelSuaSVLayout);
        jPanelSuaSVLayout.setHorizontalGroup(
            jPanelSuaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuaSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSuaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        jPanelSuaSVLayout.setVerticalGroup(
            jPanelSuaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSuaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelThemSV.setBackground(new java.awt.Color(221, 51, 51));
        jPanelThemSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelThemSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelThemSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThemSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelThemSV.setText("Thêm");
        jLabelThemSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelThemSV.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelThemSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelThemSVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelThemSVLayout = new javax.swing.GroupLayout(jPanelThemSV);
        jPanelThemSV.setLayout(jPanelThemSVLayout);
        jPanelThemSVLayout.setHorizontalGroup(
            jPanelThemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelThemSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelThemSV, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        );
        jPanelThemSVLayout.setVerticalGroup(
            jPanelThemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThemSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutKhoaSV.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutKhoaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutKhoaSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutKhoaSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutKhoaSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclose.png"))); // NOI18N
        jLabelNutKhoaSV.setText("Mở /Khóa TK");
        jLabelNutKhoaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutKhoaSV.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutKhoaSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutKhoaSVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutKhoaSVLayout = new javax.swing.GroupLayout(jPanelNutKhoaSV);
        jPanelNutKhoaSV.setLayout(jPanelNutKhoaSVLayout);
        jPanelNutKhoaSVLayout.setHorizontalGroup(
            jPanelNutKhoaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutKhoaSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutKhoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
        );
        jPanelNutKhoaSVLayout.setVerticalGroup(
            jPanelNutKhoaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutKhoaSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelTitleSVLayout = new javax.swing.GroupLayout(jPanelTitleSV);
        jPanelTitleSV.setLayout(jPanelTitleSVLayout);
        jPanelTitleSVLayout.setHorizontalGroup(
            jPanelTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleSVLayout.createSequentialGroup()
                .addComponent(jPanelNutTitleSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(jPanelThemSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSuaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelXoaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTitleSVLayout.createSequentialGroup()
                    .addGap(333, 333, 333)
                    .addComponent(jPanelNutKhoaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );
        jPanelTitleSVLayout.setVerticalGroup(
            jPanelTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTitleSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelXoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelSuaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelThemSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelNutKhoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSinhVienMain.add(jPanelTitleSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelBorderSV.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBorderSV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabelTitleSV.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTitleSV.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTitleSV.setText("Danh sách sinh viên");

        jScrollPaneSV.setBorder(null);

        jTableSV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "   MSSV", "   Họ và tên", "   Lớp", "   Chức vụ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSV.setShowGrid(true);
        jTableSV.setShowVerticalLines(false);
        jScrollPaneSV.setViewportView(jTableSV);

        jLabelChon_SV.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChon_SV.setText("Chọn khoa:");

        jLabelChonLop_SV.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonLop_SV.setText("Chọn lớp:");

        choiceKhoa_SV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_SV.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_SV.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_SV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_SVItemStateChanged(evt);
            }
        });

        choiceLop_SV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceLop_SV.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceLop_SV.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceLop_SV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceLop_SVItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelBorderSVLayout = new javax.swing.GroupLayout(jPanelBorderSV);
        jPanelBorderSV.setLayout(jPanelBorderSVLayout);
        jPanelBorderSVLayout.setHorizontalGroup(
            jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneSV, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                        .addComponent(jLabelTitleSV)
                        .addGap(122, 122, 122)
                        .addComponent(jLabelChon_SV)
                        .addGap(2, 2, 2)
                        .addComponent(choiceKhoa_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelChonLop_SV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(choiceLop_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelBorderSVLayout.setVerticalGroup(
            jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                .addGroup(jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelChonLop_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelTitleSV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelChon_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(choiceLop_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(choiceKhoa_SV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSV, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPaneSV.setVerticalScrollBar(new ScrollBar());
        jScrollPaneSV.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneSV.getViewport().setBackground(Color.WHITE);
        JPanel p7 = new JPanel();
        p7.setBackground(Color.WHITE);
        jScrollPaneSV.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p7);

        jPanelSinhVienMain.add(jPanelBorderSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelSinhVienMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelDuyetDiem.setPreferredSize(new java.awt.Dimension(804, 612));
        jPanelDuyetDiem.setRequestFocusEnabled(false);
        jPanelDuyetDiem.setVerifyInputWhenFocusTarget(false);
        jPanelDuyetDiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTrangChu.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTrangChu.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteview.png"))); // NOI18N
        jLabelNutTieuDeTrangChu.setText("Duyệt điểm rèn luyện sinh viên");
        jLabelNutTieuDeTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTrangChu.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTrangChuLayout = new javax.swing.GroupLayout(jPanelNutTieuDeTrangChu);
        jPanelNutTieuDeTrangChu.setLayout(jPanelNutTieuDeTrangChuLayout);
        jPanelNutTieuDeTrangChuLayout.setHorizontalGroup(
            jPanelNutTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutTieuDeTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );
        jPanelNutTieuDeTrangChuLayout.setVerticalGroup(
            jPanelNutTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutChamLai.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutChamLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutChamLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutChamLai.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutChamLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclose.png"))); // NOI18N
        jLabelNutChamLai.setText("Chấm lại");
        jLabelNutChamLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutChamLai.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutChamLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutChamLaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutChamLaiLayout = new javax.swing.GroupLayout(jPanelNutChamLai);
        jPanelNutChamLai.setLayout(jPanelNutChamLaiLayout);
        jPanelNutChamLaiLayout.setHorizontalGroup(
            jPanelNutChamLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutChamLaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
        );
        jPanelNutChamLaiLayout.setVerticalGroup(
            jPanelNutChamLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutDuyet.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutDuyet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutDuyet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutDuyet.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutDuyet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitetick.png"))); // NOI18N
        jLabelNutDuyet.setText("Duyệt");
        jLabelNutDuyet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutDuyet.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutDuyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutDuyetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutDuyetLayout = new javax.swing.GroupLayout(jPanelNutDuyet);
        jPanelNutDuyet.setLayout(jPanelNutDuyetLayout);
        jPanelNutDuyetLayout.setHorizontalGroup(
            jPanelNutDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutDuyetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutDuyet, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
        );
        jPanelNutDuyetLayout.setVerticalGroup(
            jPanelNutDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutDuyet, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTrangChuLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeTrangChu);
        jPanelThanhTieuDeTrangChu.setLayout(jPanelThanhTieuDeTrangChuLayout);
        jPanelThanhTieuDeTrangChuLayout.setHorizontalGroup(
            jPanelThanhTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTrangChuLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(jPanelNutDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutChamLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTrangChuLayout.setVerticalGroup(
            jPanelThanhTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutDuyet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelDuyetDiem.add(jPanelThanhTieuDeTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelTabeDRL.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTabeDRL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jScrollPaneDRL.setBorder(null);
        jScrollPaneDRL.setVerticalScrollBar(new ScrollBar());
        jScrollPaneDRL.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneDRL.getViewport().setBackground(Color.WHITE);
        JPanel p22 = new JPanel();
        p22.setBackground(Color.WHITE);
        jScrollPaneDRL.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p22);

        jTableDRL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableDRL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sinh viên", "Họ và tên", "ĐSV", "ĐCS", "ĐCV", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDRL.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableDRL.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableDRL.setShowGrid(true);
        jTableDRL.setShowVerticalLines(false);
        jScrollPaneDRL.setViewportView(jTableDRL);

        choiceKhoa_DRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_DRL.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_DRL.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_DRL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_DRLItemStateChanged(evt);
            }
        });

        jLabelChon2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChon2.setText("Chọn học kỳ:");

        jLabelChon3.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChon3.setText("Chọn khoa:");

        jLabelChonLop_SV1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonLop_SV1.setText("Chọn lớp:");

        choiceLop_DRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceLop_DRL.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceLop_DRL.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceLop_DRL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceLop_DRLItemStateChanged(evt);
            }
        });

        choiceHK_DRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceHK_DRL.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceHK_DRL.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceHK_DRL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceHK_DRLItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelTabeDRLLayout = new javax.swing.GroupLayout(jPanelTabeDRL);
        jPanelTabeDRL.setLayout(jPanelTabeDRLLayout);
        jPanelTabeDRLLayout.setHorizontalGroup(
            jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                        .addComponent(jLabelChon3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceKhoa_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelChonLop_SV1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceLop_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelChon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceHK_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelTabeDRLLayout.setVerticalGroup(
            jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                .addGroup(jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabelChon3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choiceKhoa_DRL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelChonLop_SV1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choiceLop_DRL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelChon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choiceHK_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(14, 14, 14)
                .addComponent(jScrollPaneDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanelDuyetDiem.add(jPanelTabeDRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelDuyetDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelView.add(jLayeredPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 140, 784, 600));

        getContentPane().add(jPanelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    


    

    private void jLabelNutXoaKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaKhoaMouseClicked
        // TODO add your handling code here:
        int selectedRow = jTableKhoa.getSelectedRow();
        
        // Kiểm tra xem có hàng nào được chọn không
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần xóa!");
            return;
        }
        String mk = jTableKhoa.getValueAt(selectedRow, 0).toString();
        for(Lop lop:dsLop){
            if(lop.getMaKhoa().equals(mk)){
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa khoa có lớp theo học!");
                return;
            }
        }
        for(CoVan cv: dsCoVan){
            if(cv.getKhoa().equals(mk)){
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa khoa có cố vấn công tác!");
                return;
            }
        }
        // Xóa hàng được chọn từ bảng
        int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?");
        if(chon == JOptionPane.YES_OPTION){
            new Thread(() -> {

                String maKhoa = dsKhoa.get(selectedRow).getMaKhoa().trim();
                DefaultTableModel model = (DefaultTableModel) jTableKhoa.getModel();
                model.removeRow(selectedRow);
                for(int i=0; i<dsTaiKhoan.size(); i++){
                    TaiKhoan tk = dsTaiKhoan.get(i);
                    if(tk.getTenTK().equals(maKhoa)){
                        dsTaiKhoan.remove(i);
                        break;
                    }
                }
                dsKhoa.remove(selectedRow);
                //dsTaiKhoan.remove(1);
                new Thread(() -> {
                    Database.saveListKhoaToDB(dsKhoa);
                    Database.saveListTaiKhoanToDB(dsTaiKhoan);
                }).start();

            }).start();

        }
        
    }//GEN-LAST:event_jLabelNutXoaKhoaMouseClicked

    private void jLabelNutSuaKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaKhoaMouseClicked
        // TODO add your handling code here:
        int chon = jTableKhoa.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần sửa!");
        }
        else{
            try {
                new FormThem_SuaKhoa(dsKhoa, jTableKhoa, chon, dsTaiKhoan, dsCoVan, dsLop, "Sua").setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(FormQuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelNutSuaKhoaMouseClicked

    private void jLabelNutThemKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemKhoaMouseClicked
         try {
             // TODO add your handling code here:
             new FormThem_SuaKhoa(dsTaiKhoan, dsKhoa, jTableKhoa, "Them").setVisible(true);
         } catch (ParseException ex) {
             Logger.getLogger(FormQuanLy.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jLabelNutThemKhoaMouseClicked

    private void choiceKhoa_CoVanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_CoVanItemStateChanged
        // TODO add your handling code here:
        new Thread(() -> {
            Database.saveCoVanToList(dsCoVan);
            String maKhoa = ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa);
            if(maKhoa.equals("")){
                Database.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa, dsTaiKhoan);
            }
            else{
                Database.addListCoVanToTable_MaKhoa(dsCoVan, jTableCoVan, dsKhoa, maKhoa, dsTaiKhoan);
            }
        }).start();
        
    }//GEN-LAST:event_choiceKhoa_CoVanItemStateChanged

    private void jLabelNutSuaCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaCoVanMouseClicked
        // TODO add your handling code here:
        int chon = jTableCoVan.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần sửa!");
        }
        else{
            try {
                
                new FormThem_SuaCoVan(dsTaiKhoan, dsKhoa, jTableCoVan, chon, dsCoVan, choiceKhoa_CoVan, "Sua", dsLop).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(FormQuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelNutSuaCoVanMouseClicked

    private void jLabelNutXoaCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaCoVanMouseClicked
        int selectedRow = jTableCoVan.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần xóa!");
            return;
        }
        String mcv = jTableCoVan.getValueAt(selectedRow, 1).toString();
        for(Lop lop:dsLop){
            if(lop.getMaCoVan().equals(mcv)){
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa cố vấn đang cố vấn cho 1 lớp!");
                return;
            }
        }
        // Xóa hàng được chọn từ bảng
        int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?");
        if(chon == JOptionPane.YES_OPTION){
            Object cellValue = jTableCoVan.getValueAt(selectedRow, 1); // Lấy dữ liệu từ cột MaCV
            new Thread(() -> {
                Database.saveCoVanToList(dsCoVan);
                String maCoVan = cellValue.toString().trim();
                int hub = 0;
                for(int i=0; i<dsCoVan.size(); i++){
                    if(dsCoVan.get(i).getMaCV().equals(maCoVan)){
                        hub = i;
                        break;
                    }
                }
                //System.out.println(hub);
                dsCoVan.remove(hub);
                Database.saveTaiKhoanToList(dsTaiKhoan);
                for(int i=0; i<dsTaiKhoan.size(); i++){
                    TaiKhoan tk = dsTaiKhoan.get(i);
                    if(tk.getTenTK().equals(maCoVan)){
                        dsTaiKhoan.remove(i);
                        break;
                    }
                }
                if(choiceKhoa_CoVan.getSelectedItem().equals("Tất cả")){
                    Database.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa, dsTaiKhoan);
                }
                else{
                    Database.addListCoVanToTable_MaKhoa(dsCoVan, jTableCoVan, dsKhoa, 
                    ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa), dsTaiKhoan);
                }
                Database.saveListCoVanToDB(dsCoVan);
                Database.saveListTaiKhoanToDB(dsTaiKhoan);

            }).start();

        } else {
            // Nếu không xác nhận xóa, bạn có thể xử lý tùy ý ở đây
        }
        
    }//GEN-LAST:event_jLabelNutXoaCoVanMouseClicked

    private void jLabelNutThemCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemCoVanMouseClicked
         try {
            
             // TODO add your handling code here:
             new FormThem_SuaCoVan(dsTaiKhoan, dsKhoa, jTableCoVan, dsCoVan, choiceKhoa_CoVan, "Them").setVisible(true);
         } catch (ParseException ex) {
             Logger.getLogger(FormQuanLy.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jLabelNutThemCoVanMouseClicked

    private void jLabelNutThemKhoaHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemKhoaHocMouseClicked
        // TODO add your handling code here:
        LocalDate currentDate = LocalDate.now();
        
        // Lấy năm từ ngày hiện tại
        int currentYear = currentDate.getYear();
        String khoa1 = Integer.toString(currentYear)+ "-" +Integer.toString(currentYear+4);
        String khoa2 = Integer.toString(currentYear)+ "-" +Integer.toString(currentYear+5);
        if(dsKhoaHoc.getLast().getMaKhoaHoc().equals(khoa1) || dsKhoaHoc.getLast().getMaKhoaHoc().equals(khoa2)){
            JOptionPane.showMessageDialog(rootPane, "Khóa học mới của năm nay đã được thêm!");
        }
        else{
            int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thêm 2 khóa học của năm nay?");
            if(chon ==  JOptionPane.YES_OPTION){
                KhoaHoc kh = new KhoaHoc();
                kh.setMaKhoaHoc(khoa1);
                kh.setNamBD(Integer.toString(currentYear));
                kh.setMamKT(Integer.toString(currentYear+4));
                kh.setTGHoc((float)4);
                dsKhoaHoc.addFirst(kh);
                KhoaHoc kh2 = new KhoaHoc();
                kh2.setMaKhoaHoc(khoa1);
                kh2.setNamBD(Integer.toString(currentYear));
                kh2.setMamKT(Integer.toString(currentYear+5));
                kh2.setTGHoc((float) 4.5);
                dsKhoaHoc.addFirst(kh2);
                Database.addListKhoaHocToTable(dsKhoaHoc, jTableKhoaHoc);
                Database.saveListKhoaHocToDB(dsKhoaHoc);
        }
        
        }
        
    }//GEN-LAST:event_jLabelNutThemKhoaHocMouseClicked

    private void jLabelNutThemHKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemHKMouseClicked
        // Hiển thị thông báo
        //JOptionPane.showMessageDialog(null, "Thêm học kỳ thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        // Thực thi công việc trong một luồng mới để không chặn giao diện người dùng
        new Thread(() -> {
            LocalDate currentDate = LocalDate.now();

            // Lấy năm từ ngày hiện tại
            int currentYear = currentDate.getYear();
            String hkMoi = ThuatToan.tangHocKy(dsHocKy.getLast().getMaHK_NK());
            String parts[] = hkMoi.split("-");
            String nienKhoa = parts[0] + "-" +parts[1];
            int namMoi = Integer.parseInt(parts[0]);
            if( currentYear < namMoi){
                JOptionPane.showMessageDialog(rootPane, "Không được thêm quá nhiều học kỳ trong 1 năm!");
            }
            else{
                int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thêm học kỳ mới?");
                if(chon ==  JOptionPane.YES_OPTION){
                    HocKy hk1 = new HocKy();
                    hk1.setMaHK_NK(hkMoi);
                    hk1.setNienKhoa(nienKhoa);
                    hk1.setHocKy(parts[2]);
                    hk1.setXet(false);
                    dsHocKy.add(hk1);
                    ThongBao tb1;
                    if(Integer.parseInt(parts[2]) == 1){
                        tb1 = ThuatToan.addNewThongBaoHK1(hkMoi, Integer.toString(currentYear+1));
                    }
                    else{
                        tb1 = ThuatToan.addNewThongBaoHK2(hkMoi, Integer.toString(currentYear+1));
                    }
                    dsThongBao.add(tb1);
                    Database.saveListThongBaoToDB(dsThongBao);
                    Database.addListThongBaoToTable(dsThongBao, jTableHanNop);
                    Database.addListHocKyToTable(dsHocKy, jTableHocKy);
                    Database.saveListHocKyToDB(dsHocKy);
                    ThuatToan.addDRLSV1HocKy(dsTaiKhoan, dsSinhVien, dsLop, dsKhoaHoc, hkMoi, dsDRL);

                }
            }
            // Sau khi công việc hoàn thành, đóng JOptionPane
            SwingUtilities.invokeLater(() -> {
                JOptionPane.getRootFrame().dispose(); // Đóng JOptionPane
            });
        }).start();
    }//GEN-LAST:event_jLabelNutThemHKMouseClicked

    private void jLabelNutDoiTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutDoiTTMouseClicked
        // TODO add your handling code here:
        
       int chonHang = jTableHocKy.getSelectedRow();
       
        if(chonHang == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn học kỳ cần đổi!");
        }
        else{
            if(dsHocKy.get(dsHocKy.size()-chonHang-1).getXet()==true){
                JOptionPane.showMessageDialog(rootPane, "Học kỳ đang được xét điểm!");
            }
            else{
                //System.out.println(dsHocKy.get(chonHang).getNienKhoa()+ " " +dsHocKy.get(chonHang).getXet());
                String nam = dsHocKy.get(dsHocKy.size()-chonHang-1).getNienKhoa();
                //System.out.println(nam);
                String parts[] = nam.split("-");
                LocalDate currentDate = LocalDate.now();      
                // Lấy năm từ ngày hiện tại
                int currentYear = currentDate.getYear();
                if(currentYear > Integer.parseInt(parts[1])){
                    JOptionPane.showMessageDialog(rootPane, "Không thể đổi học kỳ của năm cũ!");
                }else{
                    //
                    if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn đổi?")==JOptionPane.YES_OPTION){
                        int xetCu = 0;
                        for(HocKy hk:dsHocKy){
                            hk.setXet(false);
                        }
                        dsHocKy.get(dsHocKy.size()-1-chonHang).setXet(true);
                        //jTableHocKy.setValueAt("Đang diễn ra", dsHocKy.size()-1-chonHang, 3);
                        Database.saveListHocKyToDB(dsHocKy);
                         Database.addListHocKyToTable(dsHocKy, jTableHocKy);
                    }
                    
                }
            }
            
            
        }
    }//GEN-LAST:event_jLabelNutDoiTTMouseClicked

    private void choiceKhoa_LopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_LopItemStateChanged
        // TODO add your handling code here:
        new Thread(() -> {
            Database.saveKhoaToList(dsKhoa);
            Database.saveCoVanToList(dsCoVan);
            Database.saveLopToList(dsLop);
            
            String maKhoa = ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_Lop.getSelectedItem(), dsKhoa);
            if(maKhoa.equals("")){
                Database.addListLopToTable(dsLop, jTableLop, dsKhoa, dsCoVan);
            }
            else{
                Database.addListLopToTable_Khoa(dsLop, jTableLop, dsKhoa, dsCoVan, maKhoa);
            }
        }).start();
    }//GEN-LAST:event_choiceKhoa_LopItemStateChanged

    private void jLabelNutXoaLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaLopMouseClicked
        // TODO add your handling code here:
        int choose = jTableLop.getSelectedRow();
        if(choose == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần xóa!");
            return;
        }
        Object cellValue = jTableLop.getValueAt(choose , 1);
        for(SinhVien sv: dsSinhVien){
            if(sv.getLop().equals(cellValue.toString())){
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa lớp có sinh viên theo học!");
                return;
            }
        }
        
        if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?") == JOptionPane.YES_OPTION){
            int temp = 0;
            for(int i=0; i<dsLop.size(); i++){
                if(dsLop.get(i).getLop().equals(cellValue.toString())){
                    temp = i; break;
                }
            }
            dsLop.remove(temp);
            if(choiceKhoa_Lop.getSelectedItem().equals("Tất cả")){
                Database.addListLopToTable(dsLop, jTableLop, dsKhoa, dsCoVan);

            }
            else{
                Database.addListLopToTable_Khoa(dsLop, jTableLop, dsKhoa, dsCoVan, choiceKhoa_Lop.getSelectedItem());
            }
            new Thread(() -> {
                Database.saveListLopToDB(dsLop);
            }).start();
        }
        
    }//GEN-LAST:event_jLabelNutXoaLopMouseClicked

    private void jLabelNutThemLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemLopMouseClicked
        // TODO add your handling code here:
        new FormThem_SuaLop(dsKhoa, dsCoVan, dsKhoaHoc, dsLop, jTableLop, choiceKhoa_Lop, "Them").setVisible(true);
    }//GEN-LAST:event_jLabelNutThemLopMouseClicked

    private void jLabelNutSuaLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaLopMouseClicked
        // TODO add your handling code here:
        int choose = jTableLop.getSelectedRow();
        if(choose == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn lớp cần sửa!");
        }
        else{
            new FormThem_SuaLop(dsKhoa, dsCoVan, dsKhoaHoc, dsLop, jTableLop, choiceKhoa_Lop, choose, dsSinhVien, "Sua").setVisible(true);
        }
        
    }//GEN-LAST:event_jLabelNutSuaLopMouseClicked

    private void jLabelThemSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThemSVMouseClicked
         try {
             // TODO add your handling code here:
             new FormThem_SuaSinhVien(dsTaiKhoan, dsKhoa, jTableSV, choiceKhoa_SV, choiceLop_SV, dsLop, dsSinhVien, dsChucVu, "Them").setVisible(true);
         } catch (ParseException ex) {
             Logger.getLogger(FormQuanLy.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jLabelThemSVMouseClicked

    private void choiceKhoa_SVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_SVItemStateChanged
        // TODO add your handling code here:
        new Thread(() -> {
            Database.saveSinhVienToList(dsSinhVien);
            Database.saveLopToList(dsLop);
            Database.saveChucVuToList(dsChucVu);
            if(choiceKhoa_SV.getSelectedItem().equals("Tất cả")){
                Database.addListSinhVienToTable(dsSinhVien, jTableSV, dsChucVu, dsTaiKhoan);
                //choiceLop_SV.removeAll();

            }
            else{

                Database.addListSinhVienToTable_Khoa(dsSinhVien, dsKhoa, dsLop, jTableSV, dsChucVu, dsTaiKhoan, choiceKhoa_SV.getSelectedItem());
            }


            ThuatToan.addChoiceLopTatCa(choiceLop_SV, dsLop, choiceKhoa_SV.getSelectedItem(), dsKhoa);
            choiceLop_SV.select("Tất cả");
        }).start();
        
    }//GEN-LAST:event_choiceKhoa_SVItemStateChanged

    private void choiceLop_SVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceLop_SVItemStateChanged
        // TODO add your handling code here:
        new Thread(() -> {
            Database.saveSinhVienToList(dsSinhVien);
            Database.saveLopToList(dsLop);
            Database.saveChucVuToList(dsChucVu);
            if(!choiceLop_SV.getSelectedItem().equals("Tất cả")){
                Database.addListSinhVienToTable_Lop(dsSinhVien, jTableSV, dsChucVu, dsTaiKhoan, choiceLop_SV.getSelectedItem());
            }
            else{
                if(choiceKhoa_SV.getSelectedItem().equals("Tất cả")){
                Database.addListSinhVienToTable(dsSinhVien, jTableSV, dsChucVu, dsTaiKhoan);
                //choiceLop_SV.removeAll();

                }
                else{

                    Database.addListSinhVienToTable_Khoa(dsSinhVien, dsKhoa, dsLop, jTableSV, dsChucVu, dsTaiKhoan, choiceKhoa_SV.getSelectedItem());
                }
            }
        }).start();
        
    }//GEN-LAST:event_choiceLop_SVItemStateChanged

    private void jLabelSuaSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuaSVMouseClicked
        // TODO add your handling code here:
        int chon = jTableSV.getSelectedRow();
        if(chon==-1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sinh viên cần cập nhật thông tin!");
        }
        else{
            try {
                new FormThem_SuaSinhVien(dsTaiKhoan, dsKhoa, jTableSV, chon, dsSinhVien, choiceKhoa_SV, choiceLop_SV, dsLop, dsChucVu, "Sua").setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(FormQuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jLabelSuaSVMouseClicked

    private void jLabelNutChamLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutChamLaiMouseClicked
        // TODO add your handling code here:
        int chon = jTableDRL.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sinh viên cần chấm lại!");
        }else{
            Object cell = jTableDRL.getValueAt(chon, 6);
            String tt = cell.toString();
            Object cell5 = jTableDRL.getValueAt(chon, 1);
            String tt5 = cell5.toString();
            if(tt.equals("Chưa duyệt")){
                if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn hủy bỏ điểm của sinh viên này?") == JOptionPane.YES_OPTION){
                    jTableDRL.setValueAt("0", chon, 3);
                    jTableDRL.setValueAt("0", chon, 4);
                    jTableDRL.setValueAt("0", chon, 5);
                    new Thread(() -> {
                        Database.saveDRLToList(dsDRL);
                        for(DRL drl: dsDRL){
                            //System.out.println(ThuatToan.getHKXet(dsHocKy));
                            if(drl.getMSSV().equals(tt5) && drl.getMaHK().equals(ThuatToan.getHKXet(dsHocKy))){
                                drl.setTrangThai(false);
                                drl.setDiem1(0);
                                drl.setDiem2(0);
                                drl.setDiem3(0);

                                return;
                            }
                        }
                    }).start();
                    new Thread(() -> {
                        Database.updateDiem(tt5, ThuatToan.getHKXet(dsHocKy));
                    }).start();
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sinh viên này đã duyệt điểm rồi!");
            }
        }
    }//GEN-LAST:event_jLabelNutChamLaiMouseClicked

    private void jLabelNutDuyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutDuyetMouseClicked
        // TODO add your handling code here:
        int chon = jTableDRL.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sinh viên cần duyệt!");
        }else{
            Object cell = jTableDRL.getValueAt(chon, 6);
            String tt = cell.toString();
            Object cell5 = jTableDRL.getValueAt(chon, 1);
            String tt5 = cell5.toString();
            if(tt.equals("Chưa duyệt")){
                //JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn duyệt điểm sinh viên này?");
                Object cell2 = jTableDRL.getValueAt(chon, 5);
                String tt2 = cell2.toString();
                Object cell3 = jTableDRL.getValueAt(chon, 4);
                String tt3 = cell3.toString();
                Object cell4 = jTableDRL.getValueAt(chon, 3);
                String tt4 = cell4.toString();
                if(tt2.equals("0") || tt3.equals("0") || tt4.equals("0")){
                    JOptionPane.showMessageDialog(rootPane, "Sinh viên này chưa hoàn tất đủ 3 cột điểm");
                }
                else{
                    if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn duyệt điểm sinh viên này?") == JOptionPane.YES_OPTION){
                            jTableDRL.setValueAt("Đã duyệt", chon, 6);
                            new Thread(() -> {
                                Database.saveDRLToList(dsDRL);
                                for(DRL drl: dsDRL){
                                    if(drl.getMSSV().equals(tt5) && drl.getMaHK().equals(ThuatToan.getHKXet(dsHocKy))){
                                        drl.setTrangThai(true);

                                        return;
                                    }
                                }
                            }).start();
                        new Thread(() -> {
                            Database.updateTrangThai(tt5, ThuatToan.getHKXet(dsHocKy));
                        }).start();
                        
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sinh viên này đã duyệt điểm rồi!");
            }
        }
    }//GEN-LAST:event_jLabelNutDuyetMouseClicked

    private void jLabelNutChiTietTCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutChiTietTCMouseClicked
        // TODO add your handling code here:
        int chon = jTableTieuChi.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn tiêu chí cần xem chi tiết!");
        }
        else{
            String noiDung = dsTieuChi.get(chon).getNoiDung();
            int diem = dsTieuChi.get(chon).getDiem();
            if(dsTieuChi.get(chon).getDsNoiDung().isEmpty() ){
                
                new FormThem_SuaTieuChi(noiDung, diem, chon, dsTieuChi, jTableTieuChi).setVisible(true);
            }
            else{
                new FormNoiDungTieuChi(dsTieuChi, dsTieuChi.get(chon).getDsNoiDung(), noiDung, chon).setVisible(true);
            }

        }
        evt.consume();
        
        
    }//GEN-LAST:event_jLabelNutChiTietTCMouseClicked

    private void jLabelNutLienHeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLienHeMouseClicked
        // TODO add your handling code here:
        Link.openLink("https://ptithcm.edu.vn/");
    }//GEN-LAST:event_jLabelNutLienHeMouseClicked

    private void jLabelCloudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloudMouseClicked
        // TODO add your handling code here:
        Link.openLink("https://www.facebook.com/CUUSVPTITHCM");
    }//GEN-LAST:event_jLabelCloudMouseClicked

    private void jLabelFbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFbMouseClicked
        // TODO add your handling code here:
        Link.openLink("https://www.facebook.com/ptithochiminh");
    }//GEN-LAST:event_jLabelFbMouseClicked

    private void jLabelNutXoaTieuChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaTieuChiMouseClicked
        // TODO add your handling code here:
        int select = jTableTieuChi.getSelectedRow();
        if(select == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn tiêu chí cần xóa!");
        }
        else{
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?") ==  JOptionPane.YES_OPTION){
                Database.saveTieuChiToList(dsTieuChi);
                dsTieuChi.remove(select);
                ThuatToan.resetMaTC(dsTieuChi);
                Database.addListTieuChiToTable(dsTieuChi, jTableTieuChi);
            }
        }
    }//GEN-LAST:event_jLabelNutXoaTieuChiMouseClicked

    private void jLabelNutThemTieuChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemTieuChiMouseClicked
        // TODO add your handling code here:
        new FormThem_SuaTieuChi(dsTieuChi, jTableTieuChi).setVisible(true);
    }//GEN-LAST:event_jLabelNutThemTieuChiMouseClicked

    private void jLabelNutDoiHanNopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutDoiHanNopMouseClicked
        // TODO add your handling code here:
        int chon = jTableHanNop.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn học kỳ cần đổi!");
        }else{
            try {
                new FormDoiHanNop(dsThongBao, jTableHanNop, chon).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(FormQuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelNutDoiHanNopMouseClicked

    private void choiceKhoa_DRLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_DRLItemStateChanged
        // TODO add your handling code here:
        new Thread(() -> {
            Database.saveLopToList(dsLop);
            ThuatToan.addChoiceLop(choiceLop_DRL, dsLop, choiceKhoa_DRL.getSelectedItem(), dsKhoa);
            Database.deleteTable(jTableDRL);
            choiceHK_DRL.removeAll();
        }).start();
    }//GEN-LAST:event_choiceKhoa_DRLItemStateChanged

    private void choiceLop_DRLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceLop_DRLItemStateChanged
        // TODO add your handling code here:
       new Thread(() -> {
            String khoaHoc = ThuatToan.getKhoaHocFromSV(dsLop, choiceLop_DRL.getSelectedItem());
            String hk = ThuatToan.getHKXet(dsHocKy).trim();
            float nam = ThuatToan.getSoNamHoc(dsKhoaHoc, khoaHoc);
            boolean flag = ThuatToan.kTraHKTrongKhoaHoc(khoaHoc, hk);
            //System.out.println(flag);
            if(flag == false){
                //System.out.println(ThuatToan.doiMaHKSangHK(hk));
                ThuatToan.addChoiceHocKy(dsHocKy, khoaHoc, ThuatToan.getSoNamHoc(dsKhoaHoc, khoaHoc), choiceHK_DRL);
                jPanelNutDuyet.setVisible(false);
                jLabelNutDuyet.setVisible(false);
                jPanelNutChamLai.setVisible(false);
                jLabelNutChamLai.setVisible(false);
                
            }else{
                ThuatToan.addChoiceHocKy(dsHocKy, khoaHoc, nam, choiceHK_DRL);
                choiceHK_DRL.select(ThuatToan.doiMaHKSangHK(hk));
                jPanelNutDuyet.setVisible(true);
                jLabelNutDuyet.setVisible(true);
                jPanelNutChamLai.setVisible(true);
                jLabelNutChamLai.setVisible(true);
            }
            Database.saveHocKyToList(dsHocKy);
            Database.addListDRLToTable(dsDRL, dsSinhVien, jTableDRL, choiceLop_DRL.getSelectedItem(), 
                                        ThuatToan.doiHKSangMaHK(choiceHK_DRL.getSelectedItem()));
        }).start();
    }//GEN-LAST:event_choiceLop_DRLItemStateChanged

    private void choiceHK_DRLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceHK_DRLItemStateChanged
        // TODO add your handling code here:
        new Thread(() -> {
            Database.saveSinhVienToList(dsSinhVien);
            Database.saveDRLToList(dsDRL);
            Database.addListDRLToTable(dsDRL, dsSinhVien, jTableDRL, choiceLop_DRL.getSelectedItem(), 
                                    ThuatToan.doiHKSangMaHK(choiceHK_DRL.getSelectedItem()));
            if(ThuatToan.doiHKSangMaHK(choiceHK_DRL.getSelectedItem().trim()).equals(
                    ThuatToan.getHKXet(dsHocKy))){
                jPanelNutDuyet.setVisible(true);
                jLabelNutDuyet.setVisible(true);
                jPanelNutChamLai.setVisible(true);
                jLabelNutChamLai.setVisible(true);
            }
            else{
                jPanelNutDuyet.setVisible(false);
                jLabelNutDuyet.setVisible(false);
                jPanelNutChamLai.setVisible(false);
                jLabelNutChamLai.setVisible(false);
            }
            
        }).start();
        
    }//GEN-LAST:event_choiceHK_DRLItemStateChanged

    private void jLabelNutCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutCapNhatMouseClicked
        // Hiển thị thông báo chờ
    JOptionPane.showMessageDialog(null, "Cập nhật lại thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

    // Thực thi công việc trong một luồng mới để không chặn giao diện người dùng
    new Thread(() -> {
        // Thêm dữ liệu mới vào dsDRL
        for(SinhVien sv : dsSinhVien) {
            String khoaHoc = getKhoaHocFromSV(dsLop, sv.getLop());
            float soNamHoc = getSoNamHoc(dsKhoaHoc, khoaHoc);
            String hkCuoi = doiKhoaHocSangHKCuoi(khoaHoc, soNamHoc);
            String hkHienTai = ThuatToan.getHKXet(dsHocKy);
            int soSanh = ThuatToan.soSanhHocKy(hkHienTai, hkCuoi);
            if(!ThuatToan.kTraTonTaiMSSV(sv.getMaSV(), dsDRL, ThuatToan.getHKXet(dsHocKy)) && soSanh <= 0) {
                DRL drl = new DRL();
                drl.setMSSV(sv.getMaSV());
                drl.setMaHK(ThuatToan.getHKXet(dsHocKy));
                drl.setDiem1(0);
                drl.setDiem2(0); // Chỉnh sửa thành setDiem2
                drl.setDiem3(0); // Chỉnh sửa thành setDiem3
                drl.setTrangThai(false);
                dsDRL.add(drl);
                Database.saveOneDRLToDB(drl);
            }
        }
        // Sau khi công việc hoàn thành, đóng JOptionPane
        SwingUtilities.invokeLater(() -> {
            JOptionPane.getRootFrame().dispose(); // Đóng JOptionPane
        });
    }).start();

    }//GEN-LAST:event_jLabelNutCapNhatMouseClicked

    private void jLabelXoaSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXoaSVMouseClicked
        // TODO add your handling code here:
        
        int chon = jTableSV.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(jPanelNutCapNhat, "Vui lòng chọn sinh viên cần xóa!");
            return;
        }
        Object cellValue = jTableSV.getValueAt(chon, 1);
        String maSV = cellValue.toString().trim();
        for(DRL drl: dsDRL){
            if(drl.getMSSV().equals(maSV) && drl.isTrangThai() == true){
                JOptionPane.showMessageDialog(jPanelNutCapNhat, "Không thể xóa sinh viên đã từng có kết quả xét điểm!");
                return;
            }
        }
       
        if(JOptionPane.showConfirmDialog(jPanelNutCapNhat, "Bạn có chắc chắn xóa không?") == JOptionPane.YES_OPTION){
            new Thread(() -> {
                for(int i=0; i<dsSinhVien.size(); i++){
                    SinhVien sv = dsSinhVien.get(i);
                    if(sv.getMaSV().equals(maSV)){
                        dsSinhVien.remove(i);
                        break;
                    }
                }
                for(int i=0; i<dsTaiKhoan.size(); i++){
                    TaiKhoan tk = dsTaiKhoan.get(i);
                    if(tk.getTenTK().equals(maSV)){
                        dsTaiKhoan.remove(i);
                        break;
                    }
                }
                for(int i=0; i<dsDRL.size(); i++){
                    DRL drl = dsDRL.get(i);
                    if(drl.getMSSV().equals(maSV)){
                        dsDRL.remove(i);
                    }
                }
                new Thread(() -> {
                    Database.saveListTaiKhoanToDB(dsTaiKhoan);
                    Database.saveListSinhVienToDB(dsSinhVien);
                }).start();

            }).start();
            Database.deleteOneRow(jTableSV, chon);
            for(int i=0; i<jTableSV.getRowCount(); i++){
                jTableSV.setValueAt(i, i, 0);
            }
        }
    }//GEN-LAST:event_jLabelXoaSVMouseClicked

    private void jLabelLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogOutMouseClicked

    }//GEN-LAST:event_jLabelLogOutMouseClicked

    private void jLabelNutKhoaKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutKhoaKhoaMouseClicked
        // TODO add your handling code here:
        int chon = jTableKhoa.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn khoa cần khóa/mở tài khoản!");
        }
        else{
            if(JOptionPane.showConfirmDialog(jPanelNutCapNhat, "Bạn có chắc chắn khóa/mở tài khoản này?") == JOptionPane.YES_OPTION){
                new Thread(() -> {
                    Object cellValue = jTableKhoa.getValueAt(chon, 0);
                    for(TaiKhoan tk: dsTaiKhoan){
                        if(tk.getTenTK().equals(cellValue.toString())){
                            tk.setTrangThai(!tk.isTrangThai());
                            break;
                        }
                    }
                    Database.saveListTaiKhoanToDB(dsTaiKhoan);
                }).start();
                new Thread(() -> {
                    Database.addListKhoaToTable(dsKhoa, jTableKhoa, dsTaiKhoan);
                }).start();
            }
        }
    }//GEN-LAST:event_jLabelNutKhoaKhoaMouseClicked

    private void jLabelNutKhoaCVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutKhoaCVMouseClicked
        // TODO add your handling code here:
        int chon = jTableCoVan.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn khoa cần khóa/mở tài khoản!");
        }
        else{
            if(JOptionPane.showConfirmDialog(jPanelNutCapNhat, "Bạn có chắc chắn khóa/mở tài khoản này?") == JOptionPane.YES_OPTION){
                new Thread(() -> {
                    Object cellValue = jTableCoVan.getValueAt(chon, 1);
                    for(TaiKhoan tk: dsTaiKhoan){
                        if(tk.getTenTK().equals(cellValue.toString())){
                            tk.setTrangThai(!tk.isTrangThai());
                            break;
                        }
                    }
                    Database.saveListTaiKhoanToDB(dsTaiKhoan);
                }).start();
                new Thread(() -> {
                    if(choiceKhoa_CoVan.getSelectedItem().equals("Tất cả")){
                        Database.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa, dsTaiKhoan);
                    }
                    else{
                        Database.addListCoVanToTable_MaKhoa(dsCoVan,  jTableCoVan, dsKhoa, ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa), dsTaiKhoan);
                    }
                }).start();
            }
        }
    }//GEN-LAST:event_jLabelNutKhoaCVMouseClicked

    private void jLabelNutKhoaSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutKhoaSVMouseClicked
        // TODO add your handling code here:
        int chon = jTableSV.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn khoa cần khóa/mở tài khoản!");
        }
        else{
            if(JOptionPane.showConfirmDialog(jPanelNutCapNhat, "Bạn có chắc chắn khóa/mở tài khoản này?") == JOptionPane.YES_OPTION){
                new Thread(() -> {
                    Object cellValue = jTableSV.getValueAt(chon, 1);
                    for(TaiKhoan tk: dsTaiKhoan){
                        if(tk.getTenTK().equals(cellValue.toString())){
                            tk.setTrangThai(!tk.isTrangThai());
                            break;
                        }
                    }
                    Database.saveListTaiKhoanToDB(dsTaiKhoan);
                }).start();
                new Thread(() -> {
                    Object cellValue = jTableSV.getValueAt(chon, 5);
                    String set;
                    if(cellValue.toString().equals("Hoạt động")){
                        set = "Đã khóa";
                    }else set = "Hoạt động";
                    jTableSV.setValueAt(set, chon, 5);
                }).start();
            }
        }
    }//GEN-LAST:event_jLabelNutKhoaSVMouseClicked

    private void choiceKhoa_LopXetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_LopXetItemStateChanged
        // TODO add your handling code here:
        new Thread(() -> {
            Database.saveKhoaToList(dsKhoa);
            Database.saveLopToList(dsLop);
            Database.saveCoVanToList(dsCoVan);
            if(choiceKhoa_LopXet.getSelectedItem().equals("Tất cả")){
                Database.addListLopToTable_HKXet(dsLop, jTableLopXet, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc);
            }
            else{
                Database.addListLopToTable_HKXet_Khoa(dsLop, jTableLopXet, dsKhoa, dsCoVan, dsHocKy, choiceKhoa_LopXet.getSelectedItem(), dsKhoaHoc);
            }
        }).start();
    }//GEN-LAST:event_choiceKhoa_LopXetItemStateChanged

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         //</editor-fold>
         //</editor-fold>
         //</editor-fold>
         //</editor-fold>
         
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormQuanLy().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceHK_DRL;
    private java.awt.Choice choiceKhoa_CoVan;
    private java.awt.Choice choiceKhoa_DRL;
    private java.awt.Choice choiceKhoa_Lop;
    private java.awt.Choice choiceKhoa_LopXet;
    private java.awt.Choice choiceKhoa_SV;
    private java.awt.Choice choiceLop_DRL;
    private java.awt.Choice choiceLop_SV;
    private javax.swing.JLabel jLabelChon1;
    private javax.swing.JLabel jLabelChon2;
    private javax.swing.JLabel jLabelChon3;
    private javax.swing.JLabel jLabelChonKhoa_Lop;
    private javax.swing.JLabel jLabelChonKhoa_Lop1;
    private javax.swing.JLabel jLabelChonKhoa_Lop3;
    private javax.swing.JLabel jLabelChonKhoa_Lop4;
    private javax.swing.JLabel jLabelChonKhoa_Lop5;
    private javax.swing.JLabel jLabelChonKhoa_Lop6;
    private javax.swing.JLabel jLabelChonKhoa_Lop7;
    private javax.swing.JLabel jLabelChonKhoa_Lop8;
    private javax.swing.JLabel jLabelChonLop_SV;
    private javax.swing.JLabel jLabelChonLop_SV1;
    private javax.swing.JLabel jLabelChon_SV;
    private javax.swing.JLabel jLabelCloud;
    private javax.swing.JLabel jLabelCoVan;
    private javax.swing.JLabel jLabelCoVanLeft;
    private javax.swing.JLabel jLabelDRL;
    private javax.swing.JLabel jLabelDRLLeft;
    private javax.swing.JLabel jLabelFb;
    private javax.swing.JLabel jLabelHKXet;
    private javax.swing.JLabel jLabelHanCS;
    private javax.swing.JLabel jLabelHanCV;
    private javax.swing.JLabel jLabelHanKhoa;
    private javax.swing.JLabel jLabelHanSV;
    private javax.swing.JLabel jLabelHelp;
    private javax.swing.JLabel jLabelHocKy;
    private javax.swing.JLabel jLabelHocKyLeft;
    private javax.swing.JLabel jLabelKhoa;
    private javax.swing.JLabel jLabelKhoaLeft;
    private javax.swing.JLabel jLabelLeft8;
    private javax.swing.JLabel jLabelLeft9;
    private javax.swing.JLabel jLabelLogOut;
    private javax.swing.JLabel jLabelLop;
    private javax.swing.JLabel jLabelLopLeft;
    private javax.swing.JLabel jLabelNgayBD;
    private javax.swing.JLabel jLabelNutCapNhat;
    private javax.swing.JLabel jLabelNutChamLai;
    private javax.swing.JLabel jLabelNutChiTietTC;
    private javax.swing.JLabel jLabelNutDoiHanNop;
    private javax.swing.JLabel jLabelNutDoiTT;
    private javax.swing.JLabel jLabelNutDuyet;
    private javax.swing.JLabel jLabelNutKhoaCV;
    private javax.swing.JLabel jLabelNutKhoaKhoa;
    private javax.swing.JLabel jLabelNutKhoaSV;
    private javax.swing.JLabel jLabelNutLienHe;
    private javax.swing.JLabel jLabelNutSV;
    private javax.swing.JLabel jLabelNutSuaCoVan;
    private javax.swing.JLabel jLabelNutSuaKhoa;
    private javax.swing.JLabel jLabelNutSuaLop;
    private javax.swing.JLabel jLabelNutThemCoVan;
    private javax.swing.JLabel jLabelNutThemHK;
    private javax.swing.JLabel jLabelNutThemKhoa;
    private javax.swing.JLabel jLabelNutThemKhoaHoc;
    private javax.swing.JLabel jLabelNutThemLop;
    private javax.swing.JLabel jLabelNutThemTieuChi;
    private javax.swing.JLabel jLabelNutTieuDeCoVan;
    private javax.swing.JLabel jLabelNutTieuDeHK;
    private javax.swing.JLabel jLabelNutTieuDeKhoa;
    private javax.swing.JLabel jLabelNutTieuDeKhoa2;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi;
    private javax.swing.JLabel jLabelNutTieuDeTrangChu;
    private javax.swing.JLabel jLabelNutTieuDeTrangChu1;
    private javax.swing.JLabel jLabelNutXoaCoVan;
    private javax.swing.JLabel jLabelNutXoaKhoa;
    private javax.swing.JLabel jLabelNutXoaLop;
    private javax.swing.JLabel jLabelNutXoaTieuChi;
    private javax.swing.JLabel jLabelSinhVien;
    private javax.swing.JLabel jLabelSinhVienLeft;
    private javax.swing.JLabel jLabelSuaSV;
    private javax.swing.JLabel jLabelTableTitleCoVan;
    private javax.swing.JLabel jLabelTableTitleKhoa;
    private javax.swing.JLabel jLabelTableTitleLop;
    private javax.swing.JLabel jLabelTableTitleLop1;
    private javax.swing.JLabel jLabelThemSV;
    private javax.swing.JLabel jLabelThreeDots;
    private javax.swing.JLabel jLabelThreedots;
    private javax.swing.JLabel jLabelThuongHieu;
    private javax.swing.JLabel jLabelTieuChi;
    private javax.swing.JLabel jLabelTieuChiLeft;
    private javax.swing.JLabel jLabelTitleHanNop;
    private javax.swing.JLabel jLabelTitleHocKy;
    private javax.swing.JLabel jLabelTitleKhoaHoc;
    private javax.swing.JLabel jLabelTitleSV;
    private javax.swing.JLabel jLabelTitleTieuChi;
    private javax.swing.JLabel jLabelTrangChu;
    private javax.swing.JLabel jLabelTrangChuLeft;
    private javax.swing.JLabel jLabelXoaSV;
    private javax.swing.JLabel jLabelpanelPtit;
    private javax.swing.JLayeredPane jLayeredPaneMain;
    private javax.swing.JPanel jPanel1;
    private com.raven.swing.PanelBorder jPanelBorderHanNop;
    private com.raven.swing.PanelBorder jPanelBorderHocKy;
    private com.raven.swing.PanelBorder jPanelBorderKhoaHoc;
    private com.raven.swing.PanelBorder jPanelBorderSV;
    private com.raven.swing.PanelBorder jPanelBorderTieuChi;
    private javax.swing.JPanel jPanelCoVan;
    private javax.swing.JPanel jPanelCoVanMain;
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPanel jPanelDRL;
    private javax.swing.JPanel jPanelDuyetDiem;
    private javax.swing.JPanel jPanelHelp;
    private javax.swing.JPanel jPanelHocKy;
    private javax.swing.JPanel jPanelHocKyMain;
    private javax.swing.JPanel jPanelKhoa;
    private javax.swing.JPanel jPanelKhoaMain;
    private javax.swing.JPanel jPanelLogOut;
    private javax.swing.JPanel jPanelLop;
    private javax.swing.JPanel jPanelLopMain;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNullDot;
    private javax.swing.JPanel jPanelNullDot2;
    private javax.swing.JPanel jPanelNutCapNhat;
    private javax.swing.JPanel jPanelNutChamLai;
    private javax.swing.JPanel jPanelNutChiTietTC;
    private javax.swing.JPanel jPanelNutDoiHanNop;
    private javax.swing.JPanel jPanelNutDoiTT;
    private javax.swing.JPanel jPanelNutDuyet;
    private javax.swing.JPanel jPanelNutKhoaCV;
    private javax.swing.JPanel jPanelNutKhoaKhoa;
    private javax.swing.JPanel jPanelNutKhoaSV;
    private javax.swing.JPanel jPanelNutLienHe;
    private javax.swing.JPanel jPanelNutSuaCoVan;
    private javax.swing.JPanel jPanelNutSuaKhoa;
    private javax.swing.JPanel jPanelNutSuaLop;
    private javax.swing.JPanel jPanelNutThemCoVan;
    private javax.swing.JPanel jPanelNutThemHK;
    private javax.swing.JPanel jPanelNutThemKhoa;
    private javax.swing.JPanel jPanelNutThemKhoaHoc;
    private javax.swing.JPanel jPanelNutThemLop;
    private javax.swing.JPanel jPanelNutThemTieuChi;
    private javax.swing.JPanel jPanelNutTieuDeCoVan;
    private javax.swing.JPanel jPanelNutTieuDeHK;
    private javax.swing.JPanel jPanelNutTieuDeKhoa;
    private javax.swing.JPanel jPanelNutTieuDeLop;
    private javax.swing.JPanel jPanelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanelNutTieuDeTrangChu;
    private javax.swing.JPanel jPanelNutTieuDeTrangChu1;
    private javax.swing.JPanel jPanelNutTitleSV;
    private javax.swing.JPanel jPanelNutXoaCoVan;
    private javax.swing.JPanel jPanelNutXoaKhoa;
    private javax.swing.JPanel jPanelNutXoaLop;
    private javax.swing.JPanel jPanelNutXoaTieuChi;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPtit;
    private javax.swing.JPanel jPanelSinhVien;
    private javax.swing.JPanel jPanelSinhVienMain;
    private javax.swing.JPanel jPanelSuaSV;
    private com.raven.swing.PanelBorder jPanelTabeDRL;
    private com.raven.swing.PanelBorder jPanelTableCoVan;
    private com.raven.swing.PanelBorder jPanelTableLop;
    private com.raven.swing.PanelBorder jPanelTableLop_Xet;
    private javax.swing.JPanel jPanelThanhTieuDeCoVan;
    private javax.swing.JPanel jPanelThanhTieuDeHK;
    private javax.swing.JPanel jPanelThanhTieuDeKhoa;
    private javax.swing.JPanel jPanelThanhTieuDeLop;
    private javax.swing.JPanel jPanelThanhTieuDeTieuChi;
    private javax.swing.JPanel jPanelThanhTieuDeTrangChu;
    private javax.swing.JPanel jPanelThanhTieuDeTrangChu1;
    private javax.swing.JPanel jPanelThemSV;
    private javax.swing.JPanel jPanelTieuChi;
    private javax.swing.JPanel jPanelTieuChiMain;
    private javax.swing.JPanel jPanelTitleSV;
    private javax.swing.JPanel jPanelTrangChu;
    private javax.swing.JPanel jPanelTrangChuMain;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JPanel jPanelXoaSV;
    private javax.swing.JScrollPane jScrollPaneCoVan;
    private javax.swing.JScrollPane jScrollPaneDRL;
    private javax.swing.JScrollPane jScrollPaneHanNop;
    private javax.swing.JScrollPane jScrollPaneHocKy;
    private javax.swing.JScrollPane jScrollPaneKhoa;
    private javax.swing.JScrollPane jScrollPaneKhoaHoc;
    private javax.swing.JScrollPane jScrollPaneLop;
    private javax.swing.JScrollPane jScrollPaneLopXet;
    private javax.swing.JScrollPane jScrollPaneSV;
    private javax.swing.JScrollPane jScrollPaneTieuChi;
    private com.raven.swing.TableCo5Cot jTableCoVan;
    private com.raven.swing.TableCo5Cot jTableDRL;
    private com.raven.swing.Table jTableHanNop;
    private com.raven.swing.Table jTableHocKy;
    private com.raven.swing.TableCo5Cot jTableKhoa;
    private com.raven.swing.Table jTableKhoaHoc;
    private com.raven.swing.TableCo5Cot jTableLop;
    private com.raven.swing.TableCo5Cot jTableLopXet;
    private com.raven.swing.Table jTableSV;
    private com.raven.swing.Table jTableTieuChi;
    private com.raven.swing.PanelBorder panelBorderTableKhoa;
    // End of variables declaration//GEN-END:variables


}
