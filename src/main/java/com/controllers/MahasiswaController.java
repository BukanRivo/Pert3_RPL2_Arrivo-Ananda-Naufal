/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.MahasiswaDAO;
import com.models.MahasiswaModel;
import java.util.List;

/**
 *
 * @author axioo
 */
public class MahasiswaController {
    private MahasiswaDAO mahasiswaDAO;
    
    public MahasiswaController(MahasiswaDAO mahasiswaDAO){
        this.mahasiswaDAO = mahasiswaDAO;
    }
    
    // Add
    public void addMahasiswa(String npm, String nama, int semester, float ipk){
        MahasiswaModel newMahasiswa = new MahasiswaModel(0, npm, nama, semester, ipk);
        mahasiswaDAO.addMahasiswa(newMahasiswa);
    }
    
    // Get All
    public List<MahasiswaModel> getAllMahasiswa(){
        return mahasiswaDAO.getAllMahasiswa();
    }
    
    // Update
    public void updateMahasiswa(int id, String npm, String nama, int semester, float ipk){
        MahasiswaModel newMahasiswa = new MahasiswaModel(id, npm, nama, semester, ipk);
        mahasiswaDAO.updateMahasiswa(newMahasiswa);
    }
    
    // Delete
    public void deleteById(int id){
        mahasiswaDAO.deleteById(id);
    }
    
}
