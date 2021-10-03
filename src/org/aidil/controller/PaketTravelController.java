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
import org.aidil.dao.KulinerDAO;
import org.aidil.dao.PaketTravelDAO;
import org.aidil.dao.WisatawanDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.PaketTravel;
import org.aidil.view.DialogPaketTravel;
import org.aidil.view.DialogWisataPaketTravel;
import org.aidil.view.FormPaketTravel;


/**
 *
 * @author Aidil
 */
public class PaketTravelController {
    FormPaketTravel view;
    PaketTravel paketTravel;
    PaketTravelDAO dao;
    Koneksi k;
    Connection c;
    DialogPaketTravel dialogPaketTravel;
    DialogWisataPaketTravel dialogWisataPaketTravel;

    public PaketTravelController(FormPaketTravel view) {
        this.view = view;
        paketTravel = new PaketTravel();
        dao=new PaketTravelDAO();
        k=new Koneksi();
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e);
        }
    }

    public PaketTravelController(DialogPaketTravel dialogPaketTravel) {
        this.dialogPaketTravel = dialogPaketTravel;
        paketTravel = new PaketTravel();
    }

    public PaketTravelController(DialogWisataPaketTravel dialogWisataPaketTravel) {
        this.dialogWisataPaketTravel = dialogWisataPaketTravel;
        paketTravel = new PaketTravel();
    }
    
    
    public void insert(){
        try {
            paketTravel = new PaketTravel();
            paketTravel.setId_paket_travel(view.getTxtidpt().getText());
            paketTravel.setId_wisata(view.getTxtidwpt().getText());
            paketTravel.setNama_wisata(view.getTxtnmpt().getText());
            paketTravel.setTarif_wisata(view.getTxttarifwisPatra().getText());
            paketTravel.setId_transportasi(view.getTxtidtpt().getText());
            paketTravel.setNama_kendaraan(view.getTxtnnkpt().getText());
            paketTravel.setTarif_transportasi(view.getTxtttpt().getText());
            paketTravel.setId_penginapan(view.getTxtidpppt().getText());
            paketTravel.setNama_penginapan(view.getTxtnpppt().getText());
            paketTravel.setTarif_penginapan(view.getTxttppt().getText());
            paketTravel.setLama_wisata(view.getTxtlwpt().getText());
            paketTravel.setJumlah_rombongan(view.getTxtjrpt().getText());
            PaketTravelDAO dao = new PaketTravelDAO();
            Koneksi k = new Koneksi();
            
             Connection c = k.getKoneksi();
            dao.insert(c, paketTravel);
            JOptionPane.showMessageDialog(view, "Data Berhasil Ditambah");
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void delete(){
        try {
            String id = view.getTxtidpt().getText();
            PaketTravelDAO dao = new PaketTravelDAO();
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
            paketTravel = new PaketTravel();
            paketTravel.setId_paket_travel(view.getTxtidpt().getText());
            paketTravel.setId_wisata(view.getTxtidwpt().getText());
            paketTravel.setNama_wisata(view.getTxtnmpt().getText());
            paketTravel.setTarif_wisata(view.getTxttarifwisPatra().getText());
            paketTravel.setId_transportasi(view.getTxtidtpt().getText());
            paketTravel.setNama_kendaraan(view.getTxtnnkpt().getText());
            paketTravel.setTarif_transportasi(view.getTxtttpt().getText());
            paketTravel.setId_penginapan(view.getTxtidpppt().getText());
            paketTravel.setNama_penginapan(view.getTxtnpppt().getText());
            paketTravel.setTarif_penginapan(view.getTxttppt().getText());
            paketTravel.setLama_wisata(view.getTxtlwpt().getText());
            paketTravel.setJumlah_rombongan(view.getTxtjrpt().getText());
            PaketTravelDAO dao = new PaketTravelDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.update(c, paketTravel);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            Logger.getLogger(PaketTravelController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void cariData(){
        String id = view.getTxtidpt().getText();
        if(id.length()>0){
            try {
                PaketTravelDAO dao = new PaketTravelDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                paketTravel = dao.getPaketTravel(c, id);
                if(paketTravel != null){
                    view.getTxtidwpt().setText(paketTravel.getId_wisata());
                    view.getTxtnmpt().setText(paketTravel.getNama_wisata());
                    view.getTxttarifwisPatra().setText(paketTravel.getTarif_wisata());
                    view.getTxtidtpt().setText(paketTravel.getId_transportasi());
                    view.getTxtnnkpt().setText(paketTravel.getNama_kendaraan());
                    view.getTxtttpt().setText(paketTravel.getTarif_transportasi());
                    view.getTxtidpppt().setText(paketTravel.getId_penginapan());
                    view.getTxtnpppt().setText(paketTravel.getNama_penginapan());
                    view.getTxttppt().setText(paketTravel.getTarif_penginapan());
                    view.getTxtlwpt().setText(paketTravel.getLama_wisata());
                    view.getTxtjrpt().setText(paketTravel.getJumlah_rombongan());
                }else{
                    JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PaketTravelController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            JOptionPane.showMessageDialog(view, "Input Id Cari");
        }
    }
    
    public void bersihForm(){
        view.getTxtidpt().setText("");
        view.getTxtidwpt().setText("");
        view.getTxtnmpt().setText("");
        view.getTxtidtpt().setText("");
        view.getTxtnnkpt().setText("");
        view.getTxtidpppt().setText("");
        view.getTxtnpppt().setText("");
        view.getTxtlwpt().setText("");
        view.getTxtjrpt().setText("");
        view.getTxttarifwisPatra().setText("");
        view.getTxtttpt().setText("");
        view.getTxttppt().setText("");
        
    }
    
    public void pilihTabel(){
        
            String idpaket = view.getTbpt().getValueAt(view.getTbpt().getSelectedRow(),0).toString();
         
        try {
             paketTravel= dao.getPaketTravel(c, idpaket);
                    view.getTxtidpt().setText(paketTravel.getId_paket_travel());
                    view.getTxtidwpt().setText(paketTravel.getId_wisata());
                    view.getTxtnmpt().setText(paketTravel.getNama_wisata());
                    view.getTxttarifwisPatra().setText(paketTravel.getTarif_wisata());
                    view.getTxtidtpt().setText(paketTravel.getId_transportasi());
                    view.getTxtnnkpt().setText(paketTravel.getNama_kendaraan());
                    view.getTxtttpt().setText(paketTravel.getTarif_transportasi());
                    view.getTxtidpppt().setText(paketTravel.getId_penginapan());
                    view.getTxtnpppt().setText(paketTravel.getNama_penginapan());
                    view.getTxttppt().setText(paketTravel.getTarif_penginapan());
                    view.getTxtlwpt().setText(paketTravel.getLama_wisata());
                    view.getTxtjrpt().setText(paketTravel.getJumlah_rombongan());   
           
 
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   /** public void isiWisata(){
        try {
            WisataDAO dao = new WisataDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<Wisata> listWisata = dao.getAllWisata(c);
            view.getCbidwa().removeAllItems();
            for(Wisata wisata : listWisata){
                view.getCbidwa().addItem(wisata.getId_nama_wisata()+"-"+wisata.getTempat_wisata());
            }
        } catch (SQLException ex) {
            Logger.getLogger(WisataController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }*/
    
  /**  public void isiTransportasi(){
        try {
            TransportasiDAO dao = new TransportasiDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<Transportasi> listTransportasi = dao.getAllTransportasi(c);
            view.getCbidt().removeAllItems();
            for(Transportasi transportasi : listTransportasi){
                view.getCbidt().addItem(transportasi.getId_transportasi()+"-"+transportasi.getNama_kendaraan());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }*/
   
  /**  public void isiPenginapan(){
        try {
            PenginapanDAO dao = new PenginapanDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<Penginapan> listPenginapan = dao.getAllPenginapan(c);
            view.getCbidp().removeAllItems();
            for(Penginapan penginapan : listPenginapan){
                view.getCbidp().addItem(penginapan.getId_penginapan()+"-"+penginapan.getNama_penginapan());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }*/
    
    public void tampilTable(){
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getTbpt().getModel();
            tableModel.setRowCount(0);
            PaketTravelDAO dao = new PaketTravelDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<PaketTravel> listPaketTravel = dao.getAllPaketTravel(c);
            for(PaketTravel p : listPaketTravel){
                Object data[] = {
                    p.getId_paket_travel(),
                    p.getId_wisata(),
                    p.getNama_wisata(),
                    p.getTarif_wisata(),
                    p.getId_transportasi(),
                    p.getNama_penginapan(),
                    p.getTarif_transportasi(),
                    p.getId_penginapan(),
                    p.getNama_penginapan(),
                    p.getTarif_penginapan(),
                    p.getLama_wisata(),
                    p.getJumlah_rombongan()
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaketTravelController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
       public void viewDataDialog(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogPaketTravel.getTbdpt().getModel();
            tableModel.setRowCount(0);
            WisatawanDAO dao = new WisatawanDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogPaketTravel.getTxtfdpt().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_paket_travel,id_wisata,nama_wisata,tarif_wisata,id_transportasi,nama_kendaraan,tarif_transportasi,id_penginapan,nama_penginapan,tarif_penginapan,lama_wisata,jumlah_rombongan "
                    + " from paket_travel where "
                    + "id_paket_travel like '" + cari + "%' ";
            ResultSet rs = dao.getResultSet(c, sql);
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12)
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
       
}
    
    
    
  /**  public void viewDataDialog1(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogWisataPaketTravel.getTbdwpt().getModel();
            tableModel.setRowCount(0);
            PaketTravelDAO dao = new PaketTravelDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogWisataPaketTravel.getTxtknmdwpt().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_wisata,nama_wisata "
                    + "from paket_travel where "
                     + "id_wisata like '" + cari + "%' "
                    + "or nama_wisata like '" + cari + "%'";
            ResultSet rs =dao.getResultSet(c, sql);
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaketTravelController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(PaketTravelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    } */


