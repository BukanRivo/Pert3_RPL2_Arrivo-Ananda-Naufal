/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pert3_nama;

import com.controllers.MahasiswaController;
import com.models.MahasiswaDAO;
import com.views.MahasiswaView;

/**
 *
 * @author axioo
 */
public class Main {
    public static void main(String[] args) {
        MahasiswaDAO mhsDAO = new MahasiswaDAO();
        MahasiswaController mhsController = new MahasiswaController(mhsDAO);
        MahasiswaView mhsView = new MahasiswaView(mhsController);
        mhsView.menu();
    }
}
