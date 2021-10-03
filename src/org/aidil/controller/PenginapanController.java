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
import org.aidil.dao.JenisPenginapanDAO;
import org.aidil.dao.JenisWisataDAO;
import org.aidil.dao.PenginapanDAO;
import org.aidil.dao.WisataDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.JenisPenginapan;
import org.aidil.model.JenisWisata;
import org.aidil.model.Penginapan;
import org.aidil.model.Wisata;
import org.aidil.view.DialogPenginapan;
import org.aidil.view.DialogPenginapanPaketTravel;
import org.aidil.view.FormPenginapan;
import org.aidil.view.FormWisata;

/**
 *
 * @author Aidil
 */
public class PenginapanController {
    FormPenginapan view;
    Penginapan penginapan;
    DialogPenginapan dialogPenginapan;
    DialogPenginapanPaketTravel dialogPenginapanPaketTravel;

    public PenginapanController(FormPenginapan view) {
        this.view = view;
        penginapan = new Penginapan();
    }

    public PenginapanController(DialogPenginapan dialogPenginapan) {
        this.dialogPenginapan = dialogPenginapan;
        penginapan = new Penginapan();
    }

    public PenginapanController(DialogPenginapanPaketTravel dialogPenginapanPaketTravel) {
        this.dialogPenginapanPaketTravel = dialogPenginapanPaketTravel;
        penginapan = new Penginapan();
    }
    
    
    
    public void insert(){
        try {
            penginapan = new Penginapan();
            penginapan.setId_penginapan(view.getTxtidp().getText());
            penginapan.setNama_penginapan(view.getTxtnp().getText());
            String t_idjenispenginapan[] = view.getCbidjp().getSelectedItem().toString().split("-");
            penginapan.setId_jenis_penginapan(t_idjenispenginapan[0]);
            penginapan.setTarif_penginapan(view.getTxttp().getText());
            PenginapanDAO dao = new PenginapanDAO();
            Koneksi k = new Koneksi();
             Connection c = k.getKoneksi();
            dao.insert(c, penginapan);
            JOptionPane.showMessageDialog(view, "Data Berhasil Ditambah");
        } catch (SQLException ex) {
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void delete(){
        try {
            String id = view.getTxtidp().getText();
            PenginapanDAO dao = new PenginapanDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.delete(c, id);
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void update(){
        try {
            penginapan = new Penginapan();
            penginapan.setId_penginapan(view.getTxtidp().getText());
            penginapan.setNama_penginapan(view.getTxtnp().getText());
            String t_idjenispenginapan[] = view.getCbidjp().getSelectedItem().toString().split("-");
            penginapan.setId_jenis_penginapan(t_idjenispenginapan[0]);
            penginapan.setTarif_penginapan(view.getTxttp().getText());
            PenginapanDAO dao = new PenginapanDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.update(c, penginapan);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void cariData(){
        String id = view.getTxtidp().getText();
        if(id.length()>0){
            try {
                PenginapanDAO dao = new PenginapanDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                penginapan = dao.getPenginapan(c, id);
                if(penginapan != null){
                    view.getTxtnp().setText(penginapan.getNama_penginapan());
                    JenisPenginapanDAO jdao = new JenisPenginapanDAO();
                    JenisPenginapan jenisPenginapan = jdao.getJenisPenginapan(c, penginapan.getId_jenis_penginapan());
                    System.out.println(""+penginapan.getId_jenis_penginapan());
                    view.getCbidjp().setSelectedItem(jenisPenginapan.getId_jenis_penginapan()+"-"+jenisPenginapan.getJenis_penginapan());
                    view.getTxttp().setText(penginapan.getTarif_penginapan());
                }else{
                    JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            JOptionPane.showMessageDialog(view, "Input Id Cari");
        }
    }
    
    public void bersihForm(){
        view.getTxtidp().setText("");
        view.getTxtnp().setText("");
        view.getTxttp().setText("");
    }
    
    public void isiPenginapan(){
        try {
            JenisPenginapanDAO dao = new JenisPenginapanDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<JenisPenginapan> listJenisPenginapan = dao.getAllJenisPenginapan(c);
            view.getCbidjp().removeAllItems();
            for(JenisPenginapan jenisPenginapan : listJenisPenginapan){
                view.getCbidjp().addItem(jenisPenginapan.getId_jenis_penginapan()+"-"+jenisPenginapan.getJenis_penginapan());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void tampilTable(){
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getTbjp().getModel();
            tableModel.setRowCount(0);
            PenginapanDAO dao = new PenginapanDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            List<Penginapan> listPenginapan = dao.getAllPenginapan(c);
            for(Penginapan p : listPenginapan){
                Object data[] = {
                    p.getId_penginapan(),
                    p.getNama_penginapan(),
                    p.getId_jenis_penginapan(),
                    p.getTarif_penginapan()
                };
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void viewDataDialog(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogPenginapan.getTbdpp().getModel();
            tableModel.setRowCount(0);
            PenginapanDAO dao = new PenginapanDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogPenginapan.getTxtfdpp().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_penginapan,nama_penginapan,tarif_penginapan "
                    + "from penginapan where "
                    + "id_penginapan like '" + cari + "%' "
                    + "or nama_penginapan like '" + cari + "%'";
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
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void viewDataDialog1(){
        try {
            DefaultTableModel tableModel=(DefaultTableModel) dialogPenginapanPaketTravel.getTbdppt().getModel();
            tableModel.setRowCount(0);
            PenginapanDAO dao = new PenginapanDAO();
            Koneksi conn = new Koneksi();
            String cari = dialogPenginapanPaketTravel.getTxtfdppt().getText();
            Connection c = conn.getKoneksi();
            String sql = "select id_penginapan,nama_penginapan,tarif_penginapan "
                    + "from penginapan where "
                    + "id_penginapan like '" + cari + "%' "
                    + "or nama_penginapan like '" + cari + "%'";
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
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        }  {
            Object ex = null;
            Logger.getLogger(PenginapanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
