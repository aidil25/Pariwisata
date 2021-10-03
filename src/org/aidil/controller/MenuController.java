/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.View;
import org.aidil.dao.UserDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.User;
import org.aidil.view.FormLogin;
import org.aidil.view.FormMenu;

/**
 *
 * @author Aidil
 */
public class MenuController {
    FormMenu view;
    User user;
    UserDAO dao;
    Connection c;
    Koneksi k;
    public MenuController(FormMenu view){
        this.view = view;
        user = new User();
        dao = new UserDAO();
        k = new Koneksi();
        
        try {
            c = k.getKoneksi();
                    } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void nonAktif(){
        view.getMenuGuide().setVisible(false);
        view.getMenuJenisPenginapan().setVisible(false);
        view.getMenuJenisTransportasi().setVisible(false);
        view.getMenuJenisWisata().setVisible(false);
        view.getMenuPaketTravel().setVisible(false);
        view.getMenuPembayaran().setVisible(false);
        view.getMenuPemesanan().setVisible(false);
        view.getMenuPenginapan().setVisible(false);
        view.getMenuTransportasi().setVisible(false);
        view.getMenuUser().setVisible(false);
        view.getMenuWisata().setVisible(false);
        view.getMenuWisatawan().setVisible(false);
        view.getMenuLaporanPembayaran().setVisible(false);
        view.getMenuLaporanPemesanan().setVisible(false);
     }
     public void aktif(){
        view.getMenuGuide().setVisible(true);
        view.getMenuJenisPenginapan().setVisible(true);
        view.getMenuJenisTransportasi().setVisible(true);
        view.getMenuJenisWisata().setVisible(true);
        view.getMenuPaketTravel().setVisible(true);
        view.getMenuPembayaran().setVisible(true);
        view.getMenuPemesanan().setVisible(true);
        view.getMenuPenginapan().setVisible(true);
        view.getMenuTransportasi().setVisible(true);
        view.getMenuUser().setVisible(true);
        view.getMenuWisata().setVisible(true);
        view.getMenuWisatawan().setVisible(true);
        view.getMenuLaporanPembayaran().setVisible(true);
        view.getMenuLaporanPemesanan().setVisible(true);
        }
       public void cekLogin() {
        String username = view.getTxtUsername().getText();
        String password = view.getTxtPassword().getText();
        user = null;
        try {
            user = dao.getUserLogin(c, username, password);
            if (user != null) {
                JOptionPane.showMessageDialog(view, "Login Berhasil");
                aktif();
                setelahLogin();
            } else {
                JOptionPane.showMessageDialog(view, "Login Gagal");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void setelahLogin(){
        view.getTxtUsername().setEnabled(false);
        view.getTxtPassword().setEnabled(false);
        view.getBtnLogin().setEnabled(false);
        view.getBtnLogout().setEnabled(true);
        view.getBtnCancel().setEnabled(false);
    }
       public void logout(){
        view.getTxtUsername().setEnabled(true);
        view.getTxtPassword().setEnabled(true);
        view.getBtnLogin().setEnabled(true);
        view.getBtnCancel().setEnabled(true);
        view.getBtnLogout().setEnabled(false);
        JOptionPane.showMessageDialog(view, "Logout Berhasil");
    }
       public void bersih(){
        view.getTxtUsername().setText("");
        view.getTxtPassword().setText("");
    }
}
