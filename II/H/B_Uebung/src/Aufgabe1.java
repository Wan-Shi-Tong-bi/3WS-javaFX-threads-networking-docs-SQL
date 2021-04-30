
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class Aufgabe1 {
    public static void main(String[] args) throws SQLException{
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/Patient", "Patient", "Patient");     
        ////Abfrage ohne prepared Statement
//        Statement f = c.createStatement();
//        String temp = "Select * from Patient";
//        ResultSet set = f.executeQuery(temp);
//        
//        while(set.next()){
//            System.out.println("" + set.getString(1) + " " + set.getInt(2));
//        }
        
        ////Abfrage mit prepared Statemnet
//        String SQL = "Select * from Patient where age = ?";
//        PreparedStatement pstmt = c.prepareStatement(SQL);
//        pstmt.setInt(1, 31);
//        ResultSet rs = pstmt.executeQuery();
//        
//        while(rs.next()){
//            System.out.println("" + rs.getString(1) + " " + rs.getInt(2));
//        }

        
        ////Einfügen von Weten
//        PreparedStatement pstmt = c.prepareStatement("insert into Patient values(?,?)");
//        pstmt.setString(1, "Mathma");
//        pstmt.setInt(2, 40);
//        int i = pstmt.executeUpdate();
//        System.out.println(i + " records inserted");
        
       ////Verändern einees Datensatzes in der Tabelle 
//        PreparedStatement pstmt = c.prepareStatement("update Patient set name = ? where age = ?");
//        pstmt.setString(1, "Bieber");
//        pstmt.setInt(2, 31);
//        int i = pstmt.executeUpdate();
//        System.out.println(i + " records inserted");

        c.close();


    }
}
