/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.views;

import com.controllers.MahasiswaController;
import com.models.MahasiswaModel;
import com.utils.DatabaseConnection;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author axioo
 */
public class MahasiswaView {
    private MahasiswaController mhsController;
    
    public MahasiswaView(MahasiswaController mhsController){
        this.mhsController = mhsController;
    }
    
    Scanner input = new Scanner(System.in);
    
    public  void menu(){
        int pilihan;
        do {            
            System.out.println("\n============== Menu ==============:");
            System.out.println("1. Tampilkan Semua Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Cek Koneksi Database");
            System.out.println("6. Keluar");
            System.out.print("PILIH OPSI: ");
            pilihan = input.nextInt();
            input.nextLine();
            
            switch (pilihan){
                case 1:
                    showAllView();
                    break;
                case 2:
                    addView();
                    break;
                case 3:
                    updateView();
                    break;
                case 4:
                    deleteView();
                    break;
                case 5:
                    checkDBConnection();
                    break;
                case 6:
                    System.out.println("Keluar Aplikasi.");
                    return;
                default:
                    System.out.println("Input tidak valid!");
            }
        } while (pilihan != 6);
    }
    
    public void showAllView(){
        List<MahasiswaModel> mhsList = mhsController.getAllMahasiswa();
        if (mhsList.isEmpty()){
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("\n-------- Data Mahasiswa --------");
            for (MahasiswaModel m : mhsList){
                System.out.println("ID       : " + m.getId());
                System.out.println("NPM      : " + m.getNpm());
                System.out.println("Nama     : " + m.getNama());
                System.out.println("Semester : " + m.getSemester());
                System.out.println("IPK      : " + m.getIpk());
                System.out.println("-------------------------------");
            }
        }
    }
    
    public void addView(){
        System.out.println("\n-------- Input Mahasiswa --------");
        System.out.print("NPM      : ");
        String npm = input.nextLine();
        System.out.print("Nama     : ");
        String nama = input.nextLine();
        System.out.print("Semester : ");
        int semester = input.nextInt();
        input.nextLine();
        System.out.print("IPK      : ");
        float ipk = input.nextFloat();
        input.nextLine();
        
        mhsController.addMahasiswa(npm, nama, semester, ipk);
    }
    
    public void updateView(){
        System.out.println("\n-------- Edit Mahasiswa --------");
        System.out.print("Masukkan id mahasiswa yang akan diubah: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("NPM      : ");
        String npm = input.nextLine();
        System.out.print("Nama     : ");
        String nama = input.nextLine();
        System.out.print("Semester : ");
        int semester = input.nextInt();
        input.nextLine();
        System.out.print("IPK      : ");
        float ipk = input.nextFloat();
        input.nextLine();
        
        mhsController.updateMahasiswa(id, npm, nama, semester, ipk);    
    }
    
    public void deleteView(){
        System.out.println("\n-------- Hapus Mahasiswa --------");
        System.out.print("Masukkan id mahasiswa yang akan dihapus: ");
        int id = input.nextInt();
        
        mhsController.deleteById(id);
    }
    
    public void checkDBConnection(){
        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.checkConnection();
    }
}

