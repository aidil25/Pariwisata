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
import org.aidil.dao.JenisPenginapanDAO;
import org.aidil.dao.JenisWisataDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.JenisPenginapan;
import org.aidil.model.JenisWisata;
import org.aidil.view.FormJenisPenginapan;
import org.aidil.view.FormJenisWisata;

/**
 *
 * @author Aidil
 */
public class JenisPenginapanController {
    FormJenisPenginapan view;
    JenisPenginapan jenisPenginapan;
    JenisPenginapanDAO dao;
    Koneksi k;
    Connection c;

    public JenisPenginapanController(FormJenisPenginapan view) {
        this.view = view;
        jenisPenginapan=new JenisPenginapan();
        k=new Koneksi();
        dao=new JenisPenginapanDAO();
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e);
        }
    }

    public void insert() {
        jenisPenginapan = new JenisPenginapan();
        jenisPenginapan.setId_jenis_penginapan(view.getTxtidjp().getText());
        jenisPenginapan.setJenis_penginapan(view.getTxtjp().getText());

        JenisPenginapanDAO dao = new JenisPenginapanDAO();
        Koneksi k = new Koneksi();
        try {
            Connection c = k.getKoneksi();
            dao.insert(c, jenisPenginapan);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void update() {
        jenisPenginapan = new JenisPenginapan();
        jenisPenginapan.setId_jenis_penginapan(view.getTxtidjp().getText());
        jenisPenginapan.setJenis_penginapan(view.getTxtjp().getText());
        JenisPenginapanDAO dao = new JenisPenginapanDAO();
        Koneksi conn = new Koneksi();
        try{
            Connection c = conn.getKoneksi();
            dao.update(c, jenisPenginapan);
            JOptionPane.showMessageDialog(view, "Data Berhasil diUpdate");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public void delete(){
        try {
            String id = view.getTxtidjp().getText();
            JenisPenginapanDAO dao = new JenisPenginapanDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.delete(c, id);
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(JenisPenginapanController.class.getName()).log(Level.SEVERE,null,ex);
        } 
    }
    public void cariData() {
        String idCari = view.getTxtidjp().getText();
        if (idCari.length() > 0) {
            try {
                JenisPenginapanDAO dao = new JenisPenginapanDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                jenisPenginapan = dao.getJenisPenginapan(c, idCari);
                if (jenisPenginapan != null) {
                    view.getTxtjp().setText(jenisPenginapan.getJenis_penginapan());
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
        view.getTxtidjp().setText("");
        view.getTxtjp().setText("");
    }
    
    public void tampilTable()
    {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) view.getTbjp().getModel();
            tblModel.setRowCount(0);
            JenisPenginapanDAO dao = new JenisPenginapanDAO();
            Koneksi koneksi = new Koneksi();
            Connection connect = koneksi.getKoneksi();
            List<JenisPenginapan> listJenisPenginapan = dao.getAllJenisPenginapan(connect);
            for(JenisPenginapan jp : listJenisPenginapan)
            {
                Object data[]=
                {
                    jp.getId_jenis_penginapan(),
                    jp.getJenis_penginapan()
                };
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JenisPenginapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void pilihTabel(){
        
            String idPenginapan = view.getTbjp().getValueAt(view.getTbjp().getSelectedRow(),0).toString();
            String Penginapan = view.getTbjp().getValueAt(view.getTbjp().getSelectedRow(),1).toString();
         
        try {
            jenisPenginapan = dao.getJenisPenginapan(c, idPenginapan);
            view.getTxtidjp().setText(jenisPenginapan.getId_jenis_penginapan());
            view.getTxtjp().setText(jenisPenginapan.getJenis_penginapan());
           
 
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
