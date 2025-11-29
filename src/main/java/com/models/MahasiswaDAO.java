/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import com.utils.DatabaseConnection;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author axioo
 */
public class MahasiswaDAO {
    private Connection connection;
       
    // Constructor : langsung ambil koneksi dari DatabaseCOnnection
    public MahasiswaDAO(){
        connection = DatabaseConnection.getConnection();
    }
    
    // Add Mahasiswa
    public void addMahasiswa(MahasiswaModel mhs){
        String sql = "INSERT INTO tbl_mhs (npm, nama, semester, ipk) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mhs.getNpm());
            pstmt.setString(2, mhs.getNama());
            pstmt.setInt(3 , mhs.getSemester());
            pstmt.setFloat(4, mhs.getIpk());
            pstmt.executeUpdate();
            System.out.println("Berhasil menambahkan data.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Get All
    public List<MahasiswaModel> getAllMahasiswa(){
        // Deklarasi objek list
        List<MahasiswaModel> mhsList = new ArrayList<>();
        
        // String SQL
        String sql = "SELECT * FROM tbl_mhs";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                mhsList.add(new MahasiswaModel(
                        rs.getInt("id"),
                        rs.getString("npm"),
                        rs.getString("nama"),
                        rs.getInt("semester"),
                        rs.getFloat("ipk")
                ));
            }
        } 
        catch (Exception e) {
            System.err.println("Gagal menemukan data");
            e.printStackTrace();
        }
        
        return mhsList;
    }
    
    // Update
    public void updateMahasiswa(MahasiswaModel mhs){
        String sql = "UPDATE tbl_mhs SET npm = ?, nama = ?, semester = ?, ipk = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mhs.getNpm());
            pstmt.setString(2, mhs.getNama());
            pstmt.setInt(3 , mhs.getSemester());
            pstmt.setFloat(4, mhs.getIpk());
            pstmt.setFloat(5, mhs.getId());
            pstmt.executeUpdate();
            System.out.println("Berhasil memperbaharui data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Delete
    public void deleteById(int id){
        String sql = "DELETE FROM tbl_mhs WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Berhasil menghapus data mahasiswa dengan id " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteByNpm(String npm){
        String sql = "DELETE FROM tbl_mhs WHERE npm = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, npm);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
