/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.aidil.dao.JenisWisataDAO;
import org.aidil.dao.KulinerDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.JenisWisata;
import org.aidil.model.Kuliner;
import org.aidil.view.FormJenisWisata;
import org.aidil.view.FormKuliner;

/**
 *
 * @author Aidil
 */
public class KulinerController {
     FormKuliner view;
    Kuliner kuliner;
    KulinerDAO dao;
    Connection c;
    Koneksi k;

    public KulinerController(FormKuliner view) {
        this.view = view;
        kuliner=new Kuliner();
        k=new Koneksi();
        dao=new KulinerDAO();
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e);
        }
        
    }

    public void insert() {
        kuliner = new Kuliner();
        kuliner.setId_kuliner(view.getTxtidk().getText());
        kuliner.setNama(view.getTxtnk().getText());

        KulinerDAO dao = new KulinerDAO();
        Koneksi k = new Koneksi();
        try {
            Connection c = k.getKoneksi();
            dao.insert(c, kuliner);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void update() {
        kuliner = new Kuliner();
        kuliner.setId_kuliner(view.getTxtidk().getText());
        kuliner.setNama(view.getTxtnk().getText());
        KulinerDAO dao = new KulinerDAO();
        Koneksi conn = new Koneksi();
        try{
            Connection c = conn.getKoneksi();
            dao.update(c, kuliner);
            JOptionPane.showMessageDialog(view, "Data Berhasil diUpdate");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public void delete() {
        try {
            String deleteID = view.getTxtidk().getText();
            KulinerDAO dao = new KulinerDAO();
            Koneksi conn = new Koneksi();
            Connection c = conn.getKoneksi();
            dao.delete(c,deleteID);
            JOptionPane.showMessageDialog(view, "Data Berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(KulinerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cariData() {
        String idCari = view.getTxtidk().getText();
        if (idCari.length() > 0) {
            try {
                KulinerDAO dao = new KulinerDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                kuliner = dao.getKuliner(c, idCari);
                if (kuliner != null) {
                    view.getTxtnk().setText(kuliner.getNama());
                } else {
                    JOptionPane.showMessageDialog(view, "Data tidak di temukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(KulinerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    public void bersihForm() {
        view.getTxtidk().setText("");
        view.getTxtnk().setText("");
    }
    
    public void tampilTable()
    {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) view.getTbk().getModel();
            tblModel.setRowCount(0);
            KulinerDAO dao = new KulinerDAO();
            Koneksi koneksi = new Koneksi();
            Connection connect = koneksi.getKoneksi();
            List<Kuliner> listKuliner = dao.getAllKuliner(connect);
            for(Kuliner k : listKuliner)
            {
                Object data[]=
                {
                    k.getId_kuliner(),
                    k.getNama()
                };
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JenisWisataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pilihTabel(){
        
            String idkuliner = view.getTbk().getValueAt(view.getTbk().getSelectedRow(),0).toString();
            String jkuliner = view.getTbk().getValueAt(view.getTbk().getSelectedRow(),1).toString();
         
        try {
             kuliner= dao.getKuliner(c, idkuliner);
            view.getTxtidk().setText(kuliner.getId_kuliner());
            view.getTxtnk().setText(kuliner.getNama());
           
 
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
