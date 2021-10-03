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
import org.aidil.view.FormUser;

/**
 *
 * @author Aidil
 */
public class UserController {
    FormUser view;
    User user;
    Koneksi k;
    UserDAO dao;
    Connection con;
    public UserController(FormUser view) {
       this.view=view;
       k = new Koneksi();
       dao = new UserDAO();
        try {
            con = k.getKoneksi();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert() {
            user = new User();
            user.setUsername(view.getTxtUsername().getText());
            user.setPassword(view.getTxtPassword().getText());
            String temp[]=view.getCmbJenis().getSelectedItem().toString().split("-");
            user.setJenis(Integer.parseInt(temp[0]));
        try {
            dao.insert(con, user);
            JOptionPane.showMessageDialog(view, "Entry Data Ok");
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void bersihForm() {
        view.getTxtUsername().setText("");
        view.getTxtPassword().setText("");
        
    }
    public void isiJenis(){
        view.getCmbJenis().removeAllItems();
        view.getCmbJenis().addItem("1-Admin");
        view.getCmbJenis().addItem("2-Operator");
    }
   public void update() {
       user = new User();
       user.setUsername(view.getTxtUsername().getText());
       user.setPassword(view.getTxtPassword().getText());
        try {
            dao.update(con, user);
            JOptionPane.showMessageDialog(view, "Data berhasil diedit");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
   public void delete() {
        try {
            String idDelete = view.getTxtUsername().getText();
            dao.delete(con, idDelete);
            JOptionPane.showMessageDialog(view, "Data berhasil dihapus !");
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } 
   }
}
