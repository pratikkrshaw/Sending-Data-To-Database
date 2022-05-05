/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sendingdata;
import java.util.*;
import java.sql.*;
/**
 *
 * @author SHAW
 */
public class SENDINGDATA {
    static final String select="select * from sending"; 
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Data you want to insert:");
        int n=sc.nextInt();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","root");
        PreparedStatement stmt=con.prepareStatement("insert into sending values(?,?,?,?)");
        for(int i=0;i<n;i++){
            System.out.println("Enter Id:");
            int id=sc.nextInt();
            System.out.println("Enter Name:");
            String name=sc.next();
            System.out.println("Enter Roll Number:");
            int roll=sc.nextInt();
            System.out.println("Enter Gender:");
            String gender=sc.next();
            //String insert="insert into sending (id,name,roll,gender) values";
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setInt(3,roll);
            stmt.setString(4,gender);
            stmt.executeUpdate();
        }
        ResultSet rs=stmt.executeQuery(select);
        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
        }
        con.close();
    }
}
