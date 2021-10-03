/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.aidil.dao.PenginapanDAO;
import org.aidil.dao.TransportasiDAO;
import org.aidil.dao.WisataDAO;
import org.aidil.dao.WisatawanDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.Guide;
import org.aidil.model.Pemesanan;
import org.aidil.model.Penginapan;
import org.aidil.model.Transportasi;
import org.aidil.model.Wisata;
import org.aidil.model.Wisatawan;
import org.aidil.view.DialogPemesanan;
import org.aidil.view.DialogPemesanan2;
import org.aidil.view.FormPemesanan;
import org.aidil.view.LaporanPemesanan;

/**
 *
 * @author Aidil
 */
public class PemesananController {
    FormPemesanan view;
    Pemesanan pemesanan;
    Guide guide;
    GuideDAO guideDao;
    PemesananDAO dao;
    Koneksi k;
    Connection c;
    Wisatawan wisatawan;
    WisatawanDAO wisatawanDAO;
    Wisata wisata;
    WisataDAO wisataDao;
    Transportasi transportasi;
    TransportasiDAO transportasiDAO;
    Penginapan penginapan;
    PenginapanDAO penginapanDAO;
    DialogPemesanan dialogPemesanan;
    LaporanPemesanan laporanPemesanan;
    DialogPemesanan2 dialogPemesanan2;

    public PemesananController(DialogPemesanan dialogPemesanan) {
        this.dialogPemesanan = dialogPemesanan;
        pemesanan = new Pemesanan();
    }

    public PemesananController(LaporanPemesanan laporanPemesanan) {
        this.laporanPemesanan = laporanPemesanan;
        k=new Koneksi();
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(laporanPemesanan, wisata);
        }
    }

    public PemesananController(DialogPemesanan2 dialogPemesanan2) {
        this.dialogPemesanan2 = dialogPemesanan2;
        pemesanan = new Pemesanan();
    }
    
    
    

    public PemesananController(FormPemesanan view) {
        this.view = view;
        pemesanan=new Pemesanan();
        guide=new Guide();
        dao=new PemesananDAO();
        guideDao=new GuideDAO();
        k=new Koneksi();
        wisatawan=new Wisatawan();
        wisatawanDAO=new WisatawanDAO();
        wisata=new Wisata();
        wisataDao=new WisataDAO();
        transportasi = new Transportasi();
        transportasiDAO = new TransportasiDAO();
        penginapan = new Penginapan();
        penginapanDAO = new PenginapanDAO();
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e);
           
        }
    }

    public void insert() {
        pemesanan = new Pemesanan();
        pemesanan.setId_pemesanan(view.getTxtidp().getText());
        pemesanan.setId_guide(view.getTxtidg().getText());
        pemesanan.setId_wisatawan(view.getTxtidwn().getText());
        pemesanan.setPilih_paket((String) view.getCbpkt().getSelectedItem());
        pemesanan.setId_paket_travel(view.getTxtidpk().getText());
        pemesanan.setId_wisata(view.getTxtidw().getText());
        pemesanan.setId_transportasi(view.getTxtidt().getText());
        pemesanan.setId_penginapan(view.getTxtidpp().getText());
        pemesanan.setLama_wisata(view.getTxtlw().getText());
        pemesanan.setJumlah_rombongan(view.getTxtjr().getText());
        pemesanan.setTanggal_perjalanan(view.getDctp().getText());
        pemesanan.setTotal_bayar(view.getTvTotalBayar().getText());

        PemesananDAO dao = new PemesananDAO();
        Koneksi k = new Koneksi();
        try {
            Connection c = k.getKoneksi();
            dao.insert(c, pemesanan);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void update() {
        pemesanan = new Pemesanan();
        pemesanan.setId_pemesanan(view.getTxtidp().getText());
        pemesanan.setId_guide(view.getTxtidg().getText());
        pemesanan.setId_wisatawan(view.getTxtidwn().getText());
        pemesanan.setPilih_paket((String) view.getCbpkt().getSelectedItem());
        pemesanan.setId_paket_travel(view.getTxtidpk().getText());
        pemesanan.setId_wisata(view.getTxtidw().getText());
        pemesanan.setId_transportasi(view.getTxtidt().getText());
        pemesanan.setId_penginapan(view.getTxtidpp().getText());
        pemesanan.setLama_wisata(view.getTxtlw().getText());
        pemesanan.setJumlah_rombongan(view.getTxtjr().getText());
        pemesanan.setTanggal_perjalanan(view.getDctp().getText());
        pemesanan.setTotal_bayar(view.getTvTotalBayar().getText());
        PemesananDAO dao = new PemesananDAO();
        Koneksi conn = new Koneksi();
        try{
            Connection c = conn.getKoneksi();
            dao.update(c, pemesanan);
            JOptionPane.showMessageDialog(view, "Data Berhasil diUpdate");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public void delete() {
        try {
            String deleteID = view.getTxtidp().getText();
            PemesananDAO dao = new PemesananDAO();
            Koneksi conn = new Koneksi();
            Connection c = conn.getKoneksi();
            dao.delete(c,deleteID);
            JOptionPane.showMessageDialog(view, "Data Berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(PemesananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cariData() {
        String idCari = view.getTxtidp().getText();
        if (idCari.length() > 0) {
            try {
                PemesananDAO dao = new PemesananDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                pemesanan = dao.getPemesanan(c, idCari);
                guide=guideDao.getGuide(c, idCari);
                if (pemesanan != null) {
                    view.getTxtidg().setText(pemesanan.getId_guide());
                    view.getTxtidwn().setText(pemesanan.getId_wisatawan());
                    view.getCbpkt().setSelectedItem(pemesanan.getPilih_paket());
                    view.getTxtidpk().setText(pemesanan.getId_paket_travel());
                    view.getTxtidw().setText(pemesanan.getId_wisata());
                    view.getTxtidt().setText(pemesanan.getId_transportasi());
                    view.getTxtidpp().setText(pemesanan.getId_penginapan());
                    view.getTxtlw().setText(pemesanan.getLama_wisata());
                    view.getTxtjr().setText(pemesanan.getJumlah_rombongan());
                    view.getDctp().setText(pemesanan.getTanggal_perjalanan());
                    view.getTvTotalBayar().setText(pemesanan.getTotal_bayar());
                } else {
                    JOptionPane.showMessageDialog(view, "Data tidak di temukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PemesananController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }
    public void CariData1(){
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
    }
    
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
        view.getTxtidp().setText("");
        view.getTxtidg().setText("");
        view.getTxtidwn().setText("");
        view.getCbpkt().setSelectedItem("");
        view.getTxtidpk().setText("");
        view.getTxtidw().setText("");
        view.getTxtidt().setText("");
        view.getTxtidpp().setText("");
        view.getTxtlw().setText("");
        view.getTxtjr().setText("");
        view.getDctp().setText("");
        view.getTvTotalBayar().setText("");
    }
    
    public void tampilTable()
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
    }
    
    public void Transaksi(){
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
    }
    
    public void viewDataDialog(){
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
    }
    
    public void viewDataDialog1(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogPemesanan2.getTabelDialogPemesanan2().getModel();
            tableModel.setRowCount(0);
            PemesananDAO dao = new PemesananDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogPemesanan2.getTxtFilter().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_pemesanan,tanggal_perjalanan,lama_wisata "
                    + "from pemesanan where "
                    + "id_pemesanan like '" + cari + "%' ";
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
            Logger.getLogger(PemesananController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(PemesananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void IsiTgl(){
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
        
    }
    public void LaporanTransfer(){
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
    }
     
   
}


