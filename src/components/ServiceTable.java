
package components;

import controller.DichVuController;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ServiceTable extends javax.swing.JPanel {

    
    public ServiceTable() {
        initComponents();
    }
    
     public DefaultTableModel  getTableModel() {
        String[] columnNames = {"Mã dịch vụ","Tên dịch vụ","Đơn giá","Đơn vị tính"};
        DichVuController dichVuController = new DichVuController();
        Object[][] tableData = dichVuController.getDichVuFromModel();
        DefaultTableModel tableModel = new DefaultTableModel(tableData,columnNames);      
        return tableModel;
  
    }
    
    public void setTableModel(DefaultTableModel model){
        ServiceTable.setModel(model);
    }
    
    public JTable getServiceTable(){
        return ServiceTable;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ServiceTable = new javax.swing.JTable();

        ServiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(ServiceTable);

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
    private javax.swing.JTable ServiceTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
