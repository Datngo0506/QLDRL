package com.raven.swing;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableThongBao extends Table {

    public TableThongBao() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 0 ) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                if (i1 == 1 ) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                if (i1 == 2 ) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                if (i1 == 3 ) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                if (i1 == 4 ) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                if (i1 == 5 ) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                if (i1 == 6 ) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
            Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
            com.setBackground(Color.WHITE);
            setBorder(noFocusBorder);
            
            // Đặt căn giữa cho nội dung các ô dữ liệu
            setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // 5 là khoảng cách bạn muốn
            if(i1 == 0 ){
                setHorizontalAlignment(JLabel.CENTER);
            }
            if(i1 == 1 ){
                setHorizontalAlignment(JLabel.CENTER);
            }
            if(i1 == 2 ){
                setHorizontalAlignment(JLabel.CENTER);
            }
            if(i1 == 3 ){
                setHorizontalAlignment(JLabel.CENTER);
            }
            if(i1 == 4 ){
                setHorizontalAlignment(JLabel.CENTER);
            }
            if(i1 == 5 ){
                setHorizontalAlignment(JLabel.CENTER);
            }
            if(i1 == 6 ){
                setHorizontalAlignment(JLabel.CENTER);
            }

            if (selected) {
                com.setForeground(Color.RED);
                com.setFont(com.getFont().deriveFont(Font.BOLD));
            } else {
                com.setForeground(new Color(102, 102, 102));
                com.setFont(com.getFont().deriveFont(Font.PLAIN)); // Đặt chữ văn bản bình thường
            }
            return com;
        }
    });
    }
    
    
    @Override
    public void doLayout() {
        super.doLayout();
        setColumnWidths();
    }

    private void setColumnWidths() {
        TableColumnModel columnModel = getColumnModel();

        // Lấy tổng số cột
        int totalColumns = columnModel.getColumnCount();

        // Tính tổng tỷ lệ
        double totalWeight = 1 / 10 + 1.5/10+ 1.5/10 + 1.5/10 + 1.5/10 + 1.5/10 + 1.5/10;

        // Thiết lập độ rộng của từng cột theo tỷ lệ
        TableColumn column;
        column = columnModel.getColumn(0);
        column.setPreferredWidth((int) (getWidth() * (1 / totalWeight))); // Cột 1
        column = columnModel.getColumn(1);
        column.setPreferredWidth((int) (getWidth() * (1.5 / totalWeight))); // Cột 2
        column = columnModel.getColumn(2);
        column.setPreferredWidth((int) (getWidth() * (1.5 / totalWeight))); // Cột 3
        column = columnModel.getColumn(3);
        column.setPreferredWidth((int) (getWidth() * (1.5 / totalWeight))); // Cột 4
        column = columnModel.getColumn(4);
        column.setPreferredWidth((int) (getWidth() * (1.5 / totalWeight))); // Cột 5
        column = columnModel.getColumn(5);
        column.setPreferredWidth((int) (getWidth() * (1.5 / totalWeight))); // Cột 6
        column = columnModel.getColumn(6);
        column.setPreferredWidth((int) (getWidth() * (1.5 / totalWeight))); // Cột 6
        
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
