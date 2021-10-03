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
import org.aidil.dao.JenisTransportasiDAO;
import org.aidil.dao.JenisWisataDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.JenisTransportasi;
import org.aidil.model.JenisWisata;
import org.aidil.view.FormJenisTransportasi;
import org.aidil.view.FormJenisWisata;

/**
 *
 * @author Aidil
 */
public class JenisTransportasiController {
    FormJenisTransportasi view;
    JenisTransportasi jenisTransportasi;
    Koneksi k;
    Connection c;
    JenisTransportasiDAO dao;

    public JenisTransportasiController (FormJenisTransportasi view) {
        this.view = view;
        jenisTransportasi=new JenisTransportasi();
        k=new Koneksi();
        dao=new JenisTransportasiDAO();
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e);
        }
    }

    public void insert() {
        jenisTransportasi = new JenisTransportasi();
        jenisTransportasi.setId_jenis_transportasi(view.getTxtidjt().getText());
        jenisTransportasi.setJenis_transportasi(view.getTxtjt().getText());

        JenisTransportasiDAO dao = new JenisTransportasiDAO();
        Koneksi k = new Koneksi();
        try {
            Connection c = k.getKoneksi();
            dao.insert(c, jenisTransportasi);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void update() {
        jenisTransportasi = new JenisTransportasi();
        jenisTransportasi.setId_jenis_transportasi(view.getTxtidjt().getText());
        jenisTransportasi.setJenis_transportasi(view.getTxtjt().getText());
        JenisTransportasiDAO dao = new JenisTransportasiDAO();
        Koneksi conn = new Koneksi();
        try{
            Connection c = conn.getKoneksi();
            dao.update(c, jenisTransportasi);
            JOptionPane.showMessageDialog(view, "Data Berhasil diUpdate");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public void delete() {
        try {
            String deleteID = view.getTxtidjt().getText();
            JenisTransportasiDAO dao = new JenisTransportasiDAO();
            Koneksi conn = new Koneksi();
            Connection c = conn.getKoneksi();
            dao.delete(c,deleteID);
            JOptionPane.showMessageDialog(view, "Data Berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(JenisTransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cariData() {
        String idCari = view.getTxtidjt().getText();
        if (idCari.length() > 0) {
            try {
                JenisTransportasiDAO dao = new JenisTransportasiDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                jenisTransportasi = dao.getJenisTransportasi(c, idCari);
                if (jenisTransportasi != null) {
                    view.getTxtjt().setText(jenisTransportasi.getJenis_transportasi());
                } else {
                    JOptionPane.showMessageDialog(view, "Data tidak di temukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(JenisTransportasiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    public void bersihForm() {
        view.getTxtidjt().setText("");
        view.getTxtjt().setText("");
    }
    
    public void tampilTable()
    {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) view.getTbjt().getModel();
            tblModel.setRowCount(0);
            JenisTransportasiDAO dao = new JenisTransportasiDAO();
            Koneksi koneksi = new Koneksi();
            Connection connect = koneksi.getKoneksi();
            List<JenisTransportasi> listJenisTransportasi = dao.getAllJenisTransportasi(connect);
            for(JenisTransportasi jt : listJenisTransportasi)
            {
                Object data[]=
                {
                    jt.getId_jenis_transportasi(),
                    jt.getJenis_transportasi()
                };
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JenisTransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pilihTabel(){
        
            String idtransportasi = view.getTbjt().getValueAt(view.getTbjt().getSelectedRow(),0).toString();
            String transportasi = view.getTbjt().getValueAt(view.getTbjt().getSelectedRow(),1).toString();
         
        try {
             jenisTransportasi= dao.getJenisTransportasi(c, idtransportasi);
            view.getTxtidjt().setText(jenisTransportasi.getId_jenis_transportasi());
            view.getTxtjt().setText(jenisTransportasi.getJenis_transportasi());
           
 
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
