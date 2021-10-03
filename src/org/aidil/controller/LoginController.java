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
import org.aidil.dao.UserDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.User;
import org.aidil.view.FormLogin;
import org.aidil.view.FormMenu;
import org.aidil.view.FormUser;

/**
 *
 * @author Aidil
 */
public class LoginController {
    FormLogin view;

    
    UserDAO dao;
    Connection con;
    Koneksi k;
    MenuController menuController;
    FormUser formUser;
    FormMenu formMenu;
    User user;
    
    public LoginController(FormLogin view){
        this.view = view;
        user=new User();
        dao=new UserDAO();
        k = new Koneksi();
        try {
            con = k.getKoneksi();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void nonAktif(){
        formMenu.getMenuGuide().setVisible(false);
        formMenu.getMenuJenisPenginapan().setVisible(false);
        formMenu.getMenuJenisTransportasi().setVisible(false);
       
 }
    public void Aktif(){
        
        formMenu.getMenuGuide().setVisible(true);
        formMenu.getMenuJenisPenginapan().setVisible(true);
        formMenu.getMenuJenisTransportasi().setVisible(true);
        formMenu.getMenuPembayaran().setVisible(true);
       
        
        
    }
    
    
    
    public void checkLogin(){
                        
            String username = view.getTxtUsername().getText();
            String password = view.getTxtPassword().getText();
            User user;
        try {
             user = dao.getUserLogin(con, username, password);
            if(user != null){
               
               // view.getFormMenu().getMenuController().Aktif(user)
                JOptionPane.showMessageDialog(view, "SUKSES!!");
                Aktif();
                
            }
            else{
                JOptionPane.showMessageDialog(view, "MAAF ANDA SALAH");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void bersihForm() {
        view.getTxtUsername().setText("");
        view.getTxtPassword().setText("");
    }
}
