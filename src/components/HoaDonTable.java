
package components;

import controller.DichVuController;
import controller.HoaDonController;
import controller.KhachHangController;
import controller.NhanVienController;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class HoaDonTable extends javax.swing.JPanel {

    /**
     * Creates new form ServiceTable
     */
    public HoaDonTable() {
        initComponents();
    }

    public DefaultTableModel getTableModel() {
        String[] columnNames = {"Mã Hóa Đơn:", "Ngày Lập:", "Thành Tiền:"};
        HoaDonController hoaDonController = new HoaDonController();
        Object[][] tableData = hoaDonController.getHoaDonFromModel();
        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);
        return tableModel;
    }

    public void setTableModel(DefaultTableModel model) {
        HoaDonTable.setModel(model);
    }

    public JTable getClientTable() {
        return HoaDonTable;
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        HoaDonTable = new javax.swing.JTable();

        HoaDonTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(HoaDonTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HoaDonTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
