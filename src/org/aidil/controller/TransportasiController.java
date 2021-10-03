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
import org.aidil.dao.JenisTransportasiDAO;
import org.aidil.dao.TransportasiDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.JenisTransportasi;
import org.aidil.model.Transportasi;
import org.aidil.view.DialogTransportasi;
import org.aidil.view.DialogTransportasiPaketTravel;
import org.aidil.view.FormTransportasi;

/**
 *
 * @author Aidil
 */
public class TransportasiController {
    
    FormTransportasi view;
    Transportasi transportasi;
    DialogTransportasi dialogTransportasi;
    DialogTransportasiPaketTravel dialogTransportasiPaketTravel;

    public TransportasiController(FormTransportasi view) {
        this.view = view;
        transportasi = new Transportasi();
    }

    public TransportasiController(DialogTransportasi dialogTransportasi) {
        this.dialogTransportasi = dialogTransportasi;
        transportasi = new Transportasi();
    }

    public TransportasiController(DialogTransportasiPaketTravel dialogTransportasiPaketTravel) {
        this.dialogTransportasiPaketTravel = dialogTransportasiPaketTravel;
        transportasi=new Transportasi();
    }
    
    
    
    

    
    
    
    
    public void insert(){
        try {
            transportasi = new Transportasi();
            transportasi.setId_transportasi(view.getTxtidt().getText());
            transportasi.setNama_kendaraan(view.getTxtnk().getText());
            String t_idjenistransportasi[] = view.getCbidjt().getSelectedItem().toString().split("-");
            transportasi.setId_jenis_transportasi(t_idjenistransportasi[0]);
            transportasi.setStatus(view.getTxtst().getText());
            transportasi.setTarif_transportasi(view.getTxttt().getText());
            TransportasiDAO dao = new TransportasiDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.insert(c,transportasi);
            JOptionPane.showMessageDialog(view, "Data Berhasil Ditambah");
        } catch (SQLException ex) {
            Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void delete(){
        try {
            String id = view.getTxtidt().getText();
            TransportasiDAO dao = new TransportasiDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.delete(c, id);
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void update(){
        try {
            transportasi = new Transportasi();
            transportasi.setId_transportasi(view.getTxtidt().getText());
            transportasi.setNama_kendaraan(view.getTxtnk().getText());
            String t_idjenistransportasi[] = view.getCbidjt().getSelectedItem().toString().split("-");
            transportasi.setId_jenis_transportasi(t_idjenistransportasi[0]);
            transportasi.setStatus(view.getTxtst().getText());
            transportasi.setTarif_transportasi(view.getTxttt().getText());
            TransportasiDAO dao = new TransportasiDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.update(c, transportasi);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void cariData(){
        String id = view.getTxtidt().getText();
        if(id.length()>0){
            try {
                TransportasiDAO dao = new TransportasiDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                transportasi = dao.getTransportasi(c, id);
                if(transportasi != null){
                    view.getTxtnk().setText(transportasi.getNama_kendaraan());
                    JenisTransportasiDAO jdao = new JenisTransportasiDAO();
                    JenisTransportasi jenistransportasi = jdao.getJenisTransportasi(c, transportasi.getId_jenis_transportasi());
                    System.out.println(""+transportasi.getId_jenis_transportasi());
                    view.getCbidjt().setSelectedItem(jenistransportasi.getId_jenis_transportasi()+"-"+jenistransportasi.getJenis_transportasi());
                    view.getTxtst().setText(transportasi.getStatus());
                    view.getTxttt().setText(transportasi.getTarif_transportasi());
                }else{
                    JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            JOptionPane.showMessageDialog(view, "Input Id Cari");
        }
    }
    
    public void bersihForm(){
        view.getTxtidt().setText("");
        view.getTxtnk().setText("");
        view.getTxtst().setText("");
        view.getTxttt().setText("");
    }
    
    public void isiTransportasi(){
        try {
            JenisTransportasiDAO dao = new JenisTransportasiDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<JenisTransportasi> listJenisTransportasi = dao.getAllJenisTransportasi(c);
            view.getCbidjt().removeAllItems();
            for(JenisTransportasi jenisTransportasi : listJenisTransportasi){
                view.getCbidjt().addItem(jenisTransportasi.getId_jenis_transportasi()+"-"+jenisTransportasi.getJenis_transportasi());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void tampilTable(){
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getTbt().getModel();
            tableModel.setRowCount(0);
            TransportasiDAO dao = new TransportasiDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<Transportasi> listTransportasi = dao.getAllTransportasi(c);
            for(Transportasi t : listTransportasi){
                Object data[] = {
                    t.getId_transportasi(),
                    t.getNama_kendaraan(),
                    t.getId_jenis_transportasi(),
                    t.getStatus(),
                    t.getTarif_transportasi()
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void viewDataDialog(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogTransportasi.getTbdt().getModel();
            tableModel.setRowCount(0);
            TransportasiDAO dao = new TransportasiDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogTransportasi.getTxtfdt().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_transportasi,nama_kendaraan,tarif_transportasi "
                    + "from transportasi where "
                    + "id_transportasi like '" + cari + "%' "
                    + "or nama_kendaraan like '" + cari + "%'";
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
            Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void viewDataDialog1(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogTransportasiPaketTravel.getTbdtpt().getModel();
            tableModel.setRowCount(0);
            TransportasiDAO dao = new TransportasiDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogTransportasiPaketTravel.getTxtfdtpt().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_transportasi,nama_kendaraan,tarif_transportasi "
                    + "from transportasi where "
                    + "id_transportasi like '" + cari + "%' "
                    + "or nama_kendaraan like '" + cari + "%'";
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
            Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
