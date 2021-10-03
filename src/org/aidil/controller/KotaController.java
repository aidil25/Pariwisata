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
import org.aidil.dao.KotaDAO;
import org.aidil.dao.KulinerDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.Kota;
import org.aidil.model.Kuliner;
import org.aidil.view.FormKota;
import org.aidil.view.FormKuliner;

/**
 *
 * @author Aidil
 */
public class KotaController {
    FormKota view;
    Kota kota;
    Koneksi k;
    Connection c;
    KotaDAO dao;

    public KotaController(FormKota view) {
        this.view = view;
        dao=new KotaDAO();
        kota=new Kota();
        k=new Koneksi();
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e);
        }
    }

    public void insert() {
        kota = new Kota();
        kota.setId_kota(view.getTxtidkt().getText());
        kota.setNama_kota(view.getTxtnkt().getText());

        KotaDAO dao = new KotaDAO();
        Koneksi k = new Koneksi();
        try {
            Connection c = k.getKoneksi();
            dao.insert(c, kota);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void update() {
        kota = new Kota();
        kota.setId_kota(view.getTxtidkt().getText());
        kota.setNama_kota(view.getTxtnkt().getText());
        KotaDAO dao = new KotaDAO();
        Koneksi conn = new Koneksi();
        try{
            Connection c = conn.getKoneksi();
            dao.update(c, kota);
            JOptionPane.showMessageDialog(view, "Data Berhasil diUpdate");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public void delete() {
        try {
            String deleteID = view.getTxtidkt().getText();
            KotaDAO dao = new KotaDAO();
            Koneksi conn = new Koneksi();
            Connection c = conn.getKoneksi();
            dao.delete(c,deleteID);
            JOptionPane.showMessageDialog(view, "Data Berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(KotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cariData() {
        String idCari = view.getTxtidkt().getText();
        if (idCari.length() > 0) {
            try {
                KotaDAO dao = new KotaDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                kota = dao.getKota(c, idCari);
                if (kota != null) {
                    view.getTxtnkt().setText(kota.getNama_kota());
                } else {
                    JOptionPane.showMessageDialog(view, "Data tidak di temukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(KotaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    public void bersihForm() {
        view.getTxtidkt().setText("");
        view.getTxtnkt().setText("");
    }
    
    public void tampilTable()
    {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) view.getTbkt().getModel();
            tblModel.setRowCount(0);
            KotaDAO dao = new KotaDAO();
            Koneksi koneksi = new Koneksi();
            Connection connect = koneksi.getKoneksi();
            List<Kota> listKota = dao.getAllKota(connect);
            for(Kota k : listKota)
            {
                Object data[]=
                {
                    k.getId_kota(),
                    k.getNama_kota()
                };
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pilihTabel(){
        
            String idKota = view.getTbkt().getValueAt(view.getTbkt().getSelectedRow(),0).toString();
            String namakota = view.getTbkt().getValueAt(view.getTbkt().getSelectedRow(),1).toString();
         
        try {
             kota= dao.getKota(c, idKota);
            view.getTxtidkt().setText(kota.getId_kota());
            view.getTxtnkt().setText(kota.getNama_kota());
           
 
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
