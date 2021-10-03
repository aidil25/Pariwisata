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
import org.aidil.dao.PembayaranDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.Guide;
import org.aidil.model.Pembayaran;
import org.aidil.view.DialogGuide;
import org.aidil.view.FormGuide;
import org.aidil.view.FormPembayaran;

/**
 *
 * @author Aidil
 */
public class PembayaranController {
    FormPembayaran view;
    Pembayaran pembayaran;
    //DialogGuide dialogGuide;
    
  
    public PembayaranController(FormPembayaran view) {
        this.view = view;
        pembayaran = new Pembayaran();
    }

   /** public GuideController(DialogGuide dialogGuide) {
        this.dialogGuide = dialogGuide;
        guide = new Guide();
    }*/
    
    
    
    public void insert(){
        try {
            pembayaran = new Pembayaran();
            pembayaran.setId_pembayaran(view.getTxtIdPembayaran().getText());
            pembayaran.setId_pemesanan(view.getTxtIfPemesanan().getText());
            pembayaran.setTotal_bayar(view.getTxtTvTotalBayar().getText());
            pembayaran.setJumlah_bayar(view.getTxtJumlahBayar().getText());
            pembayaran.setSisa(view.getTxtSisa().getText());
            pembayaran.setTanggal_transaksi(view.getDctTanggalTransaksi().getText());
            PembayaranDAO dao = new PembayaranDAO();
            Koneksi k = new Koneksi();
             Connection c = k.getKoneksi();
            dao.insert(c, pembayaran);
            JOptionPane.showMessageDialog(view, "Data Berhasil Ditambah");
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void delete(){
        try {
            String id = view.getTxtIdPembayaran().getText();
            PembayaranDAO dao = new PembayaranDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.delete(c, id);
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void update(){
        try {
            pembayaran = new Pembayaran();
            pembayaran.setId_pembayaran(view.getTxtIdPembayaran().getText());
            pembayaran.setId_pemesanan(view.getTxtIfPemesanan().getText());
            pembayaran.setTotal_bayar(view.getTxtTvTotalBayar().getText());
            pembayaran.setJumlah_bayar(view.getTxtJumlahBayar().getText());
            pembayaran.setSisa(view.getTxtSisa().getText());
            pembayaran.setTanggal_transaksi(view.getDctTanggalTransaksi().getText());
            PembayaranDAO dao = new PembayaranDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.update(c, pembayaran);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void cariData(){
        String id = view.getTxtIdPembayaran().getText();
        if(id.length()>0){
            try {
                PembayaranDAO dao = new PembayaranDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                pembayaran = dao.getPembayaran(c, id);
                if(pembayaran != null){
                    view.getTxtIfPemesanan().setText(pembayaran.getId_pemesanan());
                    view.getTxtTvTotalBayar().setText(pembayaran.getTotal_bayar());
                    view.getTxtJumlahBayar().setText(pembayaran.getJumlah_bayar());
                    view.getTxtSisa().setText(pembayaran.getSisa());
                    view.getDctTanggalTransaksi().setText(pembayaran.getTanggal_transaksi());
                }else{
                    JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            JOptionPane.showMessageDialog(view, "Input Id Cari");
        }
    }
    
    public void bersihForm(){
        view.getTxtIdPembayaran().setText("");
        view.getTxtIfPemesanan().setText("");
        view.getTxtTvTotalBayar().setText("");
        view.getTxtJumlahBayar().setText("");
        view.getTxtSisa().setText("");
        view.getDctTanggalTransaksi().setText("");
    }
    
    public void Sisa(){
        double totalBayar=Double.parseDouble(view.getTxtTvTotalBayar().getText());
        double jumlahbayar=Double.parseDouble(view.getTxtJumlahBayar().getText());
        double hasil;
        hasil=jumlahbayar-totalBayar;
        view.getTxtSisa().setText(String.valueOf(hasil));
    }
    
    /** public void tampilTable(){
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getTbg().getModel();
            tableModel.setRowCount(0);
            GuideDAO dao = new GuideDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<Guide> listGuide = dao.getAllGuide(c);
            for(Guide g : listGuide){
                Object data[] = {
                    g.getId_guide(),
                    g.getNama_guide(),
                    g.getAlamat(),
                    g.getTelepon(),
                    g.getTarif_guide()
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }*/
    
    /** public void viewDataDialog(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogGuide.getTbkng().getModel();
            tableModel.setRowCount(0);
            GuideDAO dao = new GuideDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogGuide.getTxtkng().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_guide,nama_guide,tarif_guide "
                    + "from guide where "
                    + "id_guide like '" + cari + "%' "
                    + "or nama_guide like '" + cari + "%'";
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
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
