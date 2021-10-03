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
import org.aidil.dao.JenisWisataDAO;
import org.aidil.dao.WisataDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.JenisWisata;
import org.aidil.model.Wisata;
import org.aidil.view.DialogWisata;
import org.aidil.view.DialogWisataPaketTravel;
import org.aidil.view.FormWisata;

/**
 *
 * @author Aidil
 */
public class WisataController {
    FormWisata view;
    Wisata wisata;
    DialogWisata dialogWisata;
    DialogWisataPaketTravel dialogWisataPaketTravel;

    public WisataController(FormWisata view) {
        this.view = view;
        wisata = new Wisata();
    }

    public WisataController(DialogWisata dialogWisata) {
        this.dialogWisata = dialogWisata;
        wisata = new Wisata();
    }

    public WisataController(DialogWisataPaketTravel dialogWisataPaketTravel) {
        this.dialogWisataPaketTravel = dialogWisataPaketTravel;
        wisata = new Wisata();
    }
    
    
    
    public void insert(){
        try {
            wisata = new Wisata();
            wisata.setId_nama_wisata(view.getTxtidwa().getText());
            wisata.setTempat_wisata(view.getTxtntwa().getText());
            String t_idjeniswisata[] = view.getCbidjw().getSelectedItem().toString().split("-");
            wisata.setId_jenis_wisata(t_idjeniswisata[0]);
            wisata.setTarif_wisata(view.getTxttw().getText());
            WisataDAO dao = new WisataDAO();
            Koneksi k = new Koneksi();
             Connection c = k.getKoneksi();
            dao.insert(c, wisata);
            JOptionPane.showMessageDialog(view, "Data Berhasil Ditambah");
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void delete(){
        try {
            String id = view.getTxtidwa().getText();
            WisataDAO dao = new WisataDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.delete(c, id);
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void update(){
        try {
            wisata = new Wisata();
            wisata.setId_nama_wisata(view.getTxtidwa().getText());
            wisata.setTempat_wisata(view.getTxtntwa().getText());
            String t_idjeniswisata[] = view.getCbidjw().getSelectedItem().toString().split("-");
            wisata.setId_jenis_wisata(t_idjeniswisata[0]);
            wisata.setTarif_wisata(view.getTxttw().getText());
            WisataDAO dao = new WisataDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.update(c, wisata);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void cariData(){
        String id = view.getTxtidwa().getText();
        if(id.length()>0){
            try {
                WisataDAO dao = new WisataDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                wisata = dao.getWisata(c, id);
                if(wisata != null){
                    view.getTxtntwa().setText(wisata.getTempat_wisata());
                    JenisWisataDAO jdao = new JenisWisataDAO();
                    JenisWisata jenisWisata = jdao.getJenisWisata(c, wisata.getId_jenis_wisata());
                    System.out.println(""+wisata.getId_jenis_wisata());
                    view.getCbidjw().setSelectedItem(jenisWisata.getId_jenis_wisata()+"-"+jenisWisata.getJenis_wisata());
                    view.getTxttw().setText(wisata.getTarif_wisata());
                }else{
                    JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            JOptionPane.showMessageDialog(view, "Input Id Cari");
        }
    }
    
    public void bersihForm(){
        view.getTxtidwa().setText("");
        view.getTxtntwa().setText("");
        view.getTxttw().setText("");
    }
    
    public void isiWisata(){
        try {
            JenisWisataDAO dao = new JenisWisataDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<JenisWisata> listJenisWisata = dao.getAllJenisWisata(c);
            view.getCbidjw().removeAllItems();
            for(JenisWisata jenisWisata : listJenisWisata){
                view.getCbidjw().addItem(jenisWisata.getId_jenis_wisata()+"-"+jenisWisata.getJenis_wisata());
            }
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void tampilTable(){
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getTbw().getModel();
            tableModel.setRowCount(0);
            WisataDAO dao = new WisataDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<Wisata> listWisata = dao.getAllWisata(c);
            for(Wisata w : listWisata){
                Object data[] = {
                    w.getId_nama_wisata(),
                    w.getTempat_wisata(),
                    w.getId_jenis_wisata(),
                    w.getTarif_wisata()
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void viewDataDialog(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogWisata.getTbdw().getModel();
            tableModel.setRowCount(0);
            WisataDAO dao = new WisataDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogWisata.getTxtfdw().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_wisata,nama_wisata,tarif_wisata "
                    + "from wisata where "
                    + "id_wisata like '" + cari + "%' "
                    + "or nama_wisata like '" + cari + "%'";
            ResultSet rs =dao.getResultSet(c, sql);
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewDataDialog1(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogWisataPaketTravel.getTbdwpt().getModel();
            tableModel.setRowCount(0);
            WisataDAO dao = new WisataDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogWisataPaketTravel.getTxtknmdwpt().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_wisata,nama_wisata,tarif_wisata "
                    + "from wisata where "
                    + "id_wisata like '" + cari + "%' "
                    + "or nama_wisata like '" + cari + "%'";
            ResultSet rs =dao.getResultSet(c, sql);
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
