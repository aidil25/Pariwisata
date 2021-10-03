/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.aidil.dao.GuideDAO;
import org.aidil.dao.PemesananDAO;
import org.aidil.dao.PengembalianDAO;
import org.aidil.dao.PenginapanDAO;
import org.aidil.dao.TransportasiDAO;
import org.aidil.dao.WisataDAO;
import org.aidil.dao.WisatawanDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.Guide;
import org.aidil.model.Pemesanan;
import org.aidil.model.Pengembalian;
import org.aidil.model.Penginapan;
import org.aidil.model.Transportasi;
import org.aidil.model.Wisata;
import org.aidil.model.Wisatawan;
import org.aidil.view.DialogPemesanan;
import org.aidil.view.FormPemesanan;
import org.aidil.view.FormPengembalian;
import org.aidil.view.LaporanPemesanan;

/**
 *
 * @author Aidil
 */
public class PengembalianController {
    FormPengembalian view;
    Pengembalian pengembalian;
    Koneksi k;
    Connection c;

    public PengembalianController(FormPengembalian view) {
        this.view = view;
    }

    
   
    public void insert() {
        pengembalian = new Pengembalian();
        pengembalian.setId_pengembalian(view.getTxtIdPengembalian().getText());
        pengembalian.setId_pemesanan(view.getTxtIdPemesanan().getText());
        pengembalian.setTanggal_perjalanan(view.getDcTanggalPerjalanan().getText());
        pengembalian.setTanggal_kembali(view.getDcTanggalKembali().getText());
        pengembalian.setTerlambat(view.getTxtTerlambat().getText());
        pengembalian.setDenda(view.getTxtDenda().getText());

        PengembalianDAO dao = new PengembalianDAO();
        Koneksi k = new Koneksi();
        try {
            Connection c = k.getKoneksi();
            dao.insert(c, pengembalian);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void update() {
         pengembalian = new Pengembalian();
        pengembalian.setId_pengembalian(view.getTxtIdPengembalian().getText());
        pengembalian.setId_pemesanan(view.getTxtIdPemesanan().getText());
        pengembalian.setTanggal_perjalanan(view.getDcTanggalPerjalanan().getText());
        pengembalian.setTanggal_kembali(view.getDcTanggalKembali().getText());
        pengembalian.setTerlambat(view.getTxtTerlambat().getText());
        pengembalian.setDenda(view.getTxtDenda().getText());
        PengembalianDAO dao = new PengembalianDAO();
        Koneksi conn = new Koneksi();
        try{
            Connection c = conn.getKoneksi();
            dao.update(c, pengembalian);
            JOptionPane.showMessageDialog(view, "Data Berhasil diUpdate");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public void delete() {
        try {
            String deleteID = view.getTxtIdPengembalian().getText();
            PengembalianDAO dao = new PengembalianDAO();
            Koneksi conn = new Koneksi();
            Connection c = conn.getKoneksi();
            dao.delete(c,deleteID);
            JOptionPane.showMessageDialog(view, "Data Berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cariData() {
        String idCari = view.getTxtIdPengembalian().getText();
        if (idCari.length() > 0) {
            try {
                PengembalianDAO dao = new PengembalianDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                pengembalian = dao.getPengembalian(c, idCari);
                if (pengembalian != null) {
                    view.getTxtIdPemesanan().setText(pengembalian.getId_pemesanan());
                    view.getDcTanggalPerjalanan().setText(pengembalian.getTanggal_perjalanan());
                    view.getDcTanggalKembali().setText(pengembalian.getTanggal_kembali());
                    view.getTxtTerlambat().setText(pengembalian.getTerlambat());
                    view.getTxtDenda().setText(pengembalian.getDenda());
                } else {
                    JOptionPane.showMessageDialog(view, "Data tidak di temukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }
    /**public void CariData1(){
        String idCaritvguide = view.getTvIdGuide().getText();
        String idCariwisata=view.getTvIdWisata().getText();
        String idcariWisatawan=view.getTvIdwisatawan().getText();
        String idcariTransportasi=view.getTvIdTransportasi().getText();
        String idcariPenginapan = view.getTvIdPenginapan().getText();
        if(idCaritvguide.length()>0){
            try {
                
                PemesananDAO dao = new PemesananDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                guide=guideDao.getGuide(c, idCaritvguide);
                wisata=wisataDao.getWisata(c, idCariwisata);
                wisatawan=wisatawanDAO.getWisatawan(c, idcariWisatawan);
                transportasi=transportasiDAO.getTransportasi(c, idcariTransportasi);
                penginapan=penginapanDAO.getPenginapan(c, idcariPenginapan);
                if(guide != null){
                view.getTvNameGuide().setText(guide.getNama_guide());
                view.getTvtarifGuide().setText(guide.getTarif_guide());
                view.getTvNamaWisatawan().setText(wisatawan.getNama());
                view.getTvNamaWisata().setText(wisata.getId_nama_wisata());
                view.getTvTarifWisata().setText(wisata.getTarif_wisata());
                view.getTvnamakendaraan().setText(transportasi.getNama_kendaraan());
                view.getTvTarifTransportasi().setText(transportasi.getTarif_transportasi());
                view.getTvNamaPenginapan().setText(penginapan.getNama_penginapan());
                view.getTvTarifPenginapan().setText(penginapan.getTarif_penginapan());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, e);
            }
            
        }
    }*/
    
//    public  void isicombo(){
//       
//        if (view.getCbpkt().getSelectedIndex() == 0){
//          view.getTxtidpp().setEnabled(true);
//        }
//        
//        
//       
//    }

    public void bersihForm() {
        view.getTxtIdPengembalian().setText("");
        view.getTxtIdPemesanan().setText("");
        view.getDcTanggalPerjalanan().setText("");
        view.getDcTanggalKembali().setText("");
        view.getTxtTerlambat().setText("");
        view.getTxtDenda().setText("");
    }
    /**public void tampilTable()
    {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) view.getTbps().getModel();
            tblModel.setRowCount(0);
            PemesananDAO dao = new PemesananDAO();
            Koneksi koneksi = new Koneksi();
            Connection connect = koneksi.getKoneksi();
            List<Pemesanan> listPemesanan = dao.getAllPemesanan(connect);
            for(Pemesanan ps : listPemesanan)
            {
                Object data[]=
                {
                    ps.getId_pemesanan(),
                    ps.getId_guide(),
                    ps.getId_wisatawan(),
                    ps.getPilih_paket(),
                    ps.getId_paket_travel(),
                    ps.getId_wisata(),
                    ps.getId_transportasi(),
                    ps.getId_penginapan(),
                    ps.getLama_wisata(),
                    ps.getJumlah_rombongan(),
                    ps.getTanggal_perjalanan(),
                    ps.getTotal_bayar()
                };
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PemesananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
   /** public void Transaksi(){
            double tarifGuide=Double.parseDouble(view.getTvtarifGuide().getText());
            double tarifWisata=Double.parseDouble(view.getTvTarifWisata().getText());
            double tarifTransportasi=Double.parseDouble(view.getTvTarifTransportasi().getText());
            double tarifPenginapan=Double.parseDouble(view.getTvTarifPenginapan().getText());
            double diskon;
            int lama=Integer.parseInt(view.getTvLama().getText());
            int jumlah=Integer.parseInt(view.getTvJumlah().getText());
            double hasil,hasil1,hasil2;
           
        if(view.getCbpkt().getSelectedItem()=="paket"){
             int tarif_guide = 0;
            hasil=(tarif_guide*lama)+((tarifWisata+tarifPenginapan+tarifTransportasi)*(jumlah+lama));
            diskon=hasil*0.4;
            hasil2=hasil-diskon;
            view.getTvTotalBayar().setText(hasil2+"");
            
        }else{
             int tarif_guide = 0;
            hasil=(tarif_guide*lama)+((tarifWisata+tarifPenginapan+tarifTransportasi)*(jumlah+lama));
            diskon=0;
            hasil2=hasil-diskon;
            view.getTvTotalBayar().setText(hasil2+"");
        }
    }*/
    
   /** public void viewDataDialog(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogPemesanan.getTbDialogPemesanan().getModel();
            tableModel.setRowCount(0);
            PemesananDAO dao = new PemesananDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogPemesanan.getTxtFilterPemesanan().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_pemesanan,total_bayar "
                    + "from pemesanan where "
                    + "id_pemesanan like '" + cari + "%' ";
            ResultSet rs =dao.getResultSet(c, sql);
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2)
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PemesananController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(PemesananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
   /** public void IsiTgl(){
        laporanPemesanan.getCbTgl().removeAllItems();
        int i=1;
        for(i=1;i<=31;i++){
            laporanPemesanan.getCbTgl().addItem(i+"");
        }  
    }
    public void IsiBln(){
        laporanPemesanan.getCbBulan().removeAllItems();
        int i=1;
        for(i=1;i<=12;i++){
            laporanPemesanan.getCbBulan().addItem(i+"");
        }
    }
    public void IsiThn(){
        int i=1;
        laporanPemesanan.getCbTahun().removeAllItems();
        for(i=2000;i<=2050;i++){
            laporanPemesanan.getCbTahun().addItem(i+"");
        }
    }
    public void matikan(){
        laporanPemesanan.getCbBulan().setEnabled(false);
        laporanPemesanan.getCbTgl().setEnabled(false);
        laporanPemesanan.getCbTahun().setEnabled(false);
    }
    public void tgl(){
                laporanPemesanan.getCbTgl().setEnabled(true);
                laporanPemesanan.getCbBulan().setEnabled(true);
                laporanPemesanan.getCbTahun().setEnabled(true);
        
    }
    
    public void bln(){
                laporanPemesanan.getCbBulan().setEnabled(true);
                laporanPemesanan.getCbTahun().setEnabled(true);
        
    }
    public void thn(){
          
          laporanPemesanan.getCbTahun().setEnabled(true);
        
    }*/
    /**public void LaporanTransfer(){
        try {
            c=k.getKoneksi();
            HashMap param = new HashMap();
            JasperPrint jasperPrint = null;
            if(laporanPemesanan.getRbTanggal().isSelected()){
                String tgl=laporanPemesanan.getCbTgl().getSelectedItem().toString();
                String bln=laporanPemesanan.getCbBulan().getSelectedItem().toString();
                String thn=laporanPemesanan.getCbTahun().getSelectedItem().toString();
                param.put("tanggal", tgl);
                param.put("bulan", bln);
                param.put("tahun", thn);
                jasperPrint=JasperFillManager.fillReport("report/reportPemesanan.jasper", param,c);
                
            }else if(laporanPemesanan.getRbBulan().isSelected()){
                String bln=laporanPemesanan.getCbBulan().getSelectedItem().toString();
                String thn=laporanPemesanan.getCbTahun().getSelectedItem().toString();
                param.put("bulan", bln);
                param.put("tahun", thn);
                jasperPrint=JasperFillManager.fillReport("report/reportPemesanan.jasper", param,c);
                
                
            }else if(laporanPemesanan.getRbTahun().isSelected()){
                String thn=laporanPemesanan.getCbTahun().getSelectedItem().toString();
                param.put("tahun", thn);
                jasperPrint=JasperFillManager.fillReport("report/reportPemesanan.jasper", param,c);
                
            }
            JasperViewer.viewReport(jasperPrint,false);
            
        } catch (SQLException ex) {
            Logger.getLogger(LaporanPembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(LaporanPembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
