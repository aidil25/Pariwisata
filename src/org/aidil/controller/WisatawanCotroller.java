/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.aidil.dao.GuideDAO;
import org.aidil.dao.WisatawanDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.Wisatawan;
import org.aidil.view.DialogWisatawan;
import org.aidil.view.FormWisatawan;

/**
 *
 * @author Aidil
 */
public class WisatawanCotroller {
    FormWisatawan view;
    Wisatawan wisatawan;
    DialogWisatawan dialogWisatawan;

    public WisatawanCotroller(FormWisatawan view) {
        this.view = view;
        wisatawan = new Wisatawan();
    }

    public WisatawanCotroller(DialogWisatawan dialogWisatawan) {
        this.dialogWisatawan = dialogWisatawan;
        wisatawan = new Wisatawan();
    }
    
    

    public void insert() {
        wisatawan = new Wisatawan();
        wisatawan.setId_wisatawan(view.getTxtidw().getText());
        wisatawan.setNama(view.getTxtnw().getText());
        wisatawan.setAlamat(view.getTxtaw().getText());
        wisatawan.setTelepon(view.getTxttw().getText());

        WisatawanDAO dao = new WisatawanDAO();
        Koneksi k = new Koneksi();
        try {
            Connection c = k.getKoneksi();
            dao.insert(c, wisatawan);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void update() {
        wisatawan = new Wisatawan();
        wisatawan.setId_wisatawan(view.getTxtidw().getText());
        wisatawan.setNama(view.getTxtnw().getText());
        wisatawan.setAlamat(view.getTxtaw().getText());
        wisatawan.setTelepon(view.getTxttw().getText());
        WisatawanDAO dao = new WisatawanDAO();
        Koneksi conn = new Koneksi();
        try{
            Connection c = conn.getKoneksi();
            dao.update(c, wisatawan);
            JOptionPane.showMessageDialog(view, "Data Berhasil diUpdate");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public void delete() {
        try {
            String deleteID = view.getTxtidw().getText();
            WisatawanDAO dao = new WisatawanDAO();
            Koneksi conn = new Koneksi();
            Connection c = conn.getKoneksi();
            dao.delete(c,deleteID);
            JOptionPane.showMessageDialog(view, "Data Berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(WisatawanCotroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cariData() {
        String idCari = view.getTxtidw().getText();
        if (idCari.length() > 0) {
            try {
                WisatawanDAO dao = new WisatawanDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                wisatawan = dao.getWisatawan(c, idCari);
                if (wisatawan != null) {
                    view.getTxtnw().setText(wisatawan.getNama());
                    view.getTxtaw().setText(wisatawan.getAlamat());
                    view.getTxttw().setText(wisatawan.getTelepon());
                } else {
                    JOptionPane.showMessageDialog(view, "Data tidak di temukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(WisatawanCotroller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    public void bersihForm() {
        view.getTxtidw().setText("");
        view.getTxtnw().setText("");
        view.getTxtaw().setText("");
        view.getTxttw().setText("");
    }
    
    public void tampilTable()
    {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) view.getTbw().getModel();
            tblModel.setRowCount(0);
            WisatawanDAO dao = new WisatawanDAO();
            Koneksi koneksi = new Koneksi();
            Connection connect = koneksi.getKoneksi();
            List<Wisatawan> listWisatawan = dao.getAllWisatawan(connect);
            for(Wisatawan w : listWisatawan)
            {
                Object data[]=
                {
                    w.getId_wisatawan(),
                    w.getNama(),
                    w.getAlamat(),
                    w.getTelepon()
                };
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WisatawanCotroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viewDataDialog(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogWisatawan.getTbdwn().getModel();
            tableModel.setRowCount(0);
            WisatawanDAO dao = new WisatawanDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogWisatawan.getTxtfwn().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_wisatawan,nama_wisatawan,telepon "
                    + "from wisatawan where "
                    + "id_wisatawan like '" + cari + "%' "
                    + "or nama_wisatawan like '" + cari + "%'";
            ResultSet rs = dao.getResultSet(c, sql);
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
}
