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
import org.aidil.koneksi.Koneksi;
import org.aidil.model.JenisWisata;
import org.aidil.view.FormJenisWisata;

/**
 *
 * @author Aidil
 */
public class JenisWisataController {
    FormJenisWisata view;
    JenisWisata jenisWisata;
    Koneksi k;
    Connection c;
    JenisWisataDAO dao;

    public JenisWisataController(FormJenisWisata view) {
        this.view = view;
        dao=new JenisWisataDAO();
        k=new Koneksi();
        jenisWisata=new JenisWisata();
        try {
            c=k.getKoneksi();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e);
        }
    }

    public void insert() {
        jenisWisata = new JenisWisata();
        jenisWisata.setId_jenis_wisata(view.getTxtidjw().getText());
        jenisWisata.setJenis_wisata(view.getTxtjw().getText());

        JenisWisataDAO dao = new JenisWisataDAO();
        Koneksi k = new Koneksi();
        try {
            Connection c = k.getKoneksi();
            dao.insert(c, jenisWisata);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void update() {
        jenisWisata = new JenisWisata();
        jenisWisata.setId_jenis_wisata(view.getTxtidjw().getText());
        jenisWisata.setJenis_wisata(view.getTxtjw().getText());
        JenisWisataDAO dao = new JenisWisataDAO();
        Koneksi conn = new Koneksi();
        try{
            Connection c = conn.getKoneksi();
            dao.update(c, jenisWisata);
            JOptionPane.showMessageDialog(view, "Data Berhasil diUpdate");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public void delete() {
        try {
            String deleteID = view.getTxtidjw().getText();
            JenisWisataDAO dao = new JenisWisataDAO();
            Koneksi conn = new Koneksi();
            Connection c = conn.getKoneksi();
            dao.delete(c,deleteID);
            JOptionPane.showMessageDialog(view, "Data Berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(JenisWisataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cariData() {
        String idCari = view.getTxtidjw().getText();
        if (idCari.length() > 0) {
            try {
                JenisWisataDAO dao = new JenisWisataDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                jenisWisata = dao.getJenisWisata(c, idCari);
                if (jenisWisata != null) {
                    view.getTxtjw().setText(jenisWisata.getJenis_wisata());
                } else {
                    JOptionPane.showMessageDialog(view, "Data tidak di temukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(JenisWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    public void bersihForm() {
        view.getTxtidjw().setText("");
        view.getTxtjw().setText("");
    }
    
    public void tampilTable()
    {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) view.getTbjw().getModel();
            tblModel.setRowCount(0);
            JenisWisataDAO dao = new JenisWisataDAO();
            Koneksi koneksi = new Koneksi();
            Connection connect = koneksi.getKoneksi();
            List<JenisWisata> listJenisWisata = dao.getAllJenisWisata(connect);
            for(JenisWisata jw : listJenisWisata)
            {
                Object data[]=
                {
                    jw.getId_jenis_wisata(),
                    jw.getJenis_wisata()
                };
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JenisWisataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pilihTabel(){
        
            String idwisata = view.getTbjw().getValueAt(view.getTbjw().getSelectedRow(),0).toString();
            String wisata = view.getTbjw().getValueAt(view.getTbjw().getSelectedRow(),1).toString();
         
        try {
             jenisWisata= dao.getJenisWisata(c, idwisata);
            view.getTxtidjw().setText(jenisWisata.getId_jenis_wisata());
            view.getTxtjw().setText(jenisWisata.getJenis_wisata());
           
 
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
