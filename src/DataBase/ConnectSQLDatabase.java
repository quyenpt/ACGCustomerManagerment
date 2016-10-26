/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author PhamTheQuyen
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectSQLDatabase {
    String host = "jdbc:sqlserver://localhost:1433";
    String user = "quyenpt";
    String password = "123456";
    Connection conn = null;
    Statement statement = null;
    public ConnectSQLDatabase(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(host,user,password);
            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getData(String query){
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void insertToDataBase(String table,String[] columns,String[] values){
        //columns la danh sach ten cac cot muon them du lieu
        //values la danh sach cac du lieu tuong ung voi cac cot
        String colsStr = "["+columns[0]+"]";
        for(int i=1;i<columns.length;i++){
            colsStr+= ","+"["+columns[i]+"]";
        }
        
        String valsStr = "N'"+values[0]+"'";
        for(int i=1;i<values.length;i++){
            valsStr+= ","+"N'"+values[i]+"'";
        }
        String query = "INSERT INTO "+table+"\n" +
        "("+colsStr+")\n" +
        "VALUES ("+valsStr+");";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean deleteDataBase(String table, String columnCondition, String[] values){
        String Condition = columnCondition + " = " +values[0];
        for(int i=1;i<values.length;i++){
            Condition+= " or "+columnCondition + " = " +values[i];
        }
        String query = "DELETE FROM " +table+" WHERE "+Condition;
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
