/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author axioo
 */
public class DatabaseConnection {
    // attribute dababase
    private static final String url = "jdbc:mysql://localhost:3306/rpl2_pert3_npm";
    private static final String user = "root";
    private static final String password = "";
    
    // Attribute Connection
    private static Connection connection;
    
    public static Connection getConnection(){
        if (connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    } 
    
    public static boolean checkConnection(){
        try {
            if(connection != null && !connection.isClosed());
            System.out.println("Koneksi database berhasil.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void closeConnection(){
        try {
            if (connection != null){
                connection.isClosed();
                connection = null;
                System.out.println("Koneksi database ditutup.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
