/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Panel;

import DataBase.ConnectSQLDatabase;
import GUI.Dialog.AddTypeCustomer_Dialog;
import GUI.Information;
import GUI.MainGUI;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author PhamTheQuyen
 */
public class CustomerGroup extends javax.swing.JPanel {

    /**
     * Creates new form CustomerGroup
     */
    public MainGUI main_gui;
    public JTabbedPane center;
    public  DefaultTableModel model;
    public ArrayList<String> IdRowTable;
    
    public CustomerGroup() {
        initComponents();
        loadTable();
    }
    public void loadTable(){
        try{
        IdRowTable = new DataBase.LoadingContentTables().LoadContentTable_CustomGroup(jTable1);
        model = (DefaultTableModel) jTable1.getModel();
        resize(jTable1);
        }
        catch(Exception ex)
        {}
    }
     public void resize(JTable table)
   {
        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        int minwidth=80;
        for (int column = 0; column < table.getColumnCount(); column++)
        {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++)
            {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width+10);

                //  We've exceeded the maximum width, no need to check other rows

                if (preferredWidth >= maxWidth)
                {
                    preferredWidth = maxWidth;
                    break;
                }
            }
            preferredWidth=Math.max(preferredWidth, minwidth);
            tableColumn.setPreferredWidth( preferredWidth );
            
        }
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        FixButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(930, 352));

        jLabel3.setText("jLabel3");

        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/icon_add.png"))); // NOI18N
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/icon_delete.png"))); // NOI18N
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        FixButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/icon_repair.png"))); // NOI18N
        FixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FixButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addContainerGap(521, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FixButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeleteButton)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AddButton)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        if (Information.add_TypeCustomer) {
            try{
        AddTypeCustomer_Dialog add = new AddTypeCustomer_Dialog(main_gui,true);
        add.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-add.size().width/2,
                Toolkit.getDefaultToolkit().getScreenSize().height/2-add.size().height/2);
        add.setVisible(true);
        Vector vector = new Vector();
        if(add.getButton()){
            vector.add(add.getNameTypeCustomer());
            vector.add(0);
            vector.add(add.getDescriptionTypeCustomer());
            vector.add(false);
            model.addRow(vector);
        }
        //update to db
        String[] columnsName = {"Name","Description"};
        String[] valuesList = {vector.get(0).toString(),vector.get(2).toString()};
        ConnectSQLDatabase conn = new ConnectSQLDatabase();
        conn.insertToDataBase("dbo.tbTypeCustomer",columnsName,valuesList);
        conn.close();
        model=(DefaultTableModel) jTable1.getModel();
        resize(jTable1);
        
        }
        catch(Exception ex)
        {}
        loadTable();
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        int indexCheckColumn = model.getColumnCount() - 1;
        int count = 1, row = 0;
        ArrayList<Integer> selectRowIndexs = new ArrayList<>();
            if (model.getValueAt(0, 0).toString().equals("")) {
                return;
            }
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                if ((Boolean) model.getValueAt(i, indexCheckColumn) == true) {
                    count--;
                    selectRowIndexs.add(i);
                }
            }
            if (count == 1) {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng để xóa", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int click = JOptionPane.showConfirmDialog(center, "Bạn có muốn xóa các đối tượng đã chọn không?", null, JOptionPane.YES_NO_OPTION);
            if (click == JOptionPane.NO_OPTION) {
                return;
            }else if(click == JOptionPane.YES_OPTION){
                ConnectSQLDatabase conn = new ConnectSQLDatabase();
                String[] values = new String[selectRowIndexs.size()];
                for(int i=0;i<selectRowIndexs.size();i++){
                    values[i] = IdRowTable.get(selectRowIndexs.get(i));
                }
                conn.deleteDataBase("dbo.tbTypeCustomer","Id",values);
                conn.close();
            }
            loadTable();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void FixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FixButtonActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int indexCheckColumn = model.getColumnCount() - 1;
        int count = 1, row = 0;
            if (model.getValueAt(0, 0).toString().equals("")) {
                return;
            }
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                if ((Boolean) model.getValueAt(i, indexCheckColumn) == true) {
                    count--;
                    row = i;
                }
            }
            if (count != 0) {
                if (count == 1) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn hoc sinh cần thôi học", null, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Hệ thống chỉ cho phép thôi học một đối tượng tại một thời điểm", null, JOptionPane.INFORMATION_MESSAGE);
                    for (int i = model.getRowCount() - 1; i >= 0; i--) {
                        model.setValueAt(false, i, indexCheckColumn);
                    }
                }
                return;
            }
            //show dialog add
            AddTypeCustomer_Dialog add = new AddTypeCustomer_Dialog(main_gui,true);
            add.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-add.size().width/2,
                Toolkit.getDefaultToolkit().getScreenSize().height/2-add.size().height/2);
            
            //set info group need fix
            add.setNameTypeCustomer(model.getValueAt(row, 1).toString());
            add.setDescriptionTypeCustomer(model.getValueAt(row, 3).toString());
            add.setVisible(true);
            if(add.getButton()){
                
            }
    }//GEN-LAST:event_FixButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton FixButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
