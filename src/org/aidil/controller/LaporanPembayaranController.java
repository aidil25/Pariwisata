/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.aidil.koneksi.Koneksi;
import org.aidil.view.LaporanPembayaran;
import org.aidil.view.LaporanPemesananFinal;

/**
 *
 * @author Aidil
 */
public class LaporanPembayaranController {
    LaporanPembayaran laporanPembayaran;
    LaporanPemesananFinal pemesanan;
    Koneksi k;
    Connection c;

    public LaporanPembayaranController(LaporanPembayaran laporanPembayaran) {
        this.laporanPembayaran = laporanPembayaran;
        k=new Koneksi();
        
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(laporanPembayaran, e);
        }
    }

    public LaporanPembayaranController( LaporanPemesananFinal pemesanan) {
        this.pemesanan = pemesanan;
         k=new Koneksi();
        
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(laporanPembayaran, e);
        }
    }
    
    
    
    
    public void LaporanTransfer(){
        try {
            c=k.getKoneksi();
            HashMap param = new HashMap();
            JasperPrint jasperPrint = null;
            String norek=laporanPembayaran.getTvId().getText();
            param.put("id",norek);
            jasperPrint= JasperFillManager.fillReport("report/reportPembayaran.jasper",param,c);
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException ex) {
            Logger.getLogger(LaporanPembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(LaporanPembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LaporanTransfer2(){
        try {
            
            c=k.getKoneksi();
            HashMap param = new HashMap();
            JasperPrint jasperPrint = null;
            if(pemesanan.getRbjangkawaktu().isEnabled()){
                String awal=pemesanan.getAwal().getText();
                String akhir=pemesanan.getAkhir().getText();
                param.put("awal", new SimpleDateFormat("MM-dd-yyyy").parse(awal));
                param.put("akhir",new SimpleDateFormat("MM-dd-yyyy").parse(akhir));
                jasperPrint= JasperFillManager.fillReport("report/reportPemesanan.jasper",param,c);
                   JasperViewer.viewReport(jasperPrint,false);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LaporanPembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(LaporanPembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LaporanPembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void matikan(){
        pemesanan.getAkhir().setEnabled(false);
        pemesanan.getAwal().setEnabled(false);
    }
    
    public void Rbwaktu(){
        pemesanan.getAkhir().setEnabled(true);
        pemesanan.getAwal().setEnabled(true);
    }
}