/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PhamTheQuyen
 */
public class LoadingContentTables {
    public ArrayList<String> LoadContentTable_CustomGroup(JTable table) {
        ArrayList<String> listID = new ArrayList<>();
        DefaultTableModel model;
        int id, dem = 0;
        try {
            Object[] nameColumn = {"STT", "Nhóm Khách Hàng", "Số Lượng", "Mô tả","Đánh dấu"};
            ArrayList<Object[]> data = new ArrayList<Object[]>();
            // rs2 = statement.executeQuery("select * ,count(Students_id) from classes,classes_has_students where classes.id= Classes_Id group by Classes_Id");
            ConnectSQLDatabase conn = new ConnectSQLDatabase();
            String query = "SELECT Id,Name,Description FROM [homecaring].[dbo].[tbTypeCustomer];";
            ResultSet rs1 = conn.getData(query);
            while (rs1.next()) {
                Object str[] = new Object[5];
                str[0] = rs1.getString("Id");
                str[1] = rs1.getString("Name");
                str[2] = 1;
                str[3] = rs1.getString("Description");
                str[4] = false;
                data.add(str);
            }
            if (data.size() == 0) {
                System.out.println("hello w");
                Object[] str = new Object[5];
                str[0] = "";
                str[1] = "                      ";
                str[2] = "";
                str[3] = "";
                str[4] = false;
               
                data.add(str);
            }else{
                //sort data follow abc...
                Collections.sort(data, new SortRowTableCustomerGroup());
                for (int i = 0; i < data.size(); i++) {
                    Object[] st;
                    st = (Object[]) data.get(i);
                    listID.add(st[0].toString());
                    st[0] = i + 1;
                }
            }
            //add info to table
                Object[][] rowColumn = new Object[data.size()][];
                for (int i = 0; i < data.size(); i++) {
                    rowColumn[i] = data.get(i);
                    model = new DefaultTableModel(rowColumn, nameColumn) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false, false, true
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }

                        Class[] types = new Class[]{
                            java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
                        };

                        public Class getColumnClass(int columnIndex) {
                            return types[columnIndex];
                        }
                    };

                    table.setModel(model);

                }
        } catch (SQLException ex) {
            Logger.getLogger(LoadingContentTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listID;
    }
}
