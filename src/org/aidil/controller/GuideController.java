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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.aidil.dao.GuideDAO;
import org.aidil.dao.JenisWisataDAO;
import org.aidil.dao.WisataDAO;
import org.aidil.koneksi.Koneksi;
import org.aidil.model.Guide;
import org.aidil.model.JenisWisata;
import org.aidil.model.Wisata;
import org.aidil.view.DialogGuide;
import org.aidil.view.FormGuide;
import org.aidil.view.FormWisata;

/**
 *
 * @author Aidil
 */
public class GuideController {
    FormGuide view;
    Guide guide;
    GuideDAO dao;
    DialogGuide dialogGuide;
    Koneksi k;
    Connection c;
    
    
  
    public GuideController(FormGuide view) {
        this.view = view;
        guide = new Guide();
        dao=new GuideDAO();
        k=new Koneksi();
        try {
            c=k.getKoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e);
        }
        
    }

    public GuideController(DialogGuide dialogGuide) {
        this.dialogGuide = dialogGuide;
        guide = new Guide();
    }
    
    
    
    public void insert(){
        try {
            guide = new Guide();
            guide.setId_guide(view.getTxtidg().getText());
            guide.setNama_guide(view.getTxtng().getText());
            guide.setAlamat(view.getTxtag().getText());
            guide.setTelepon(view.getTxttpg().getText());
            guide.setTarif_guide(view.getTxttfg().getText());
            GuideDAO dao = new GuideDAO();
            Koneksi k = new Koneksi();
             Connection c = k.getKoneksi();
            dao.insert(c, guide);
            JOptionPane.showMessageDialog(view, "Data Berhasil Ditambah");
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void delete(){
        try {
            String id = view.getTxtidg().getText();
            GuideDAO dao = new GuideDAO();
            Koneksi k = new Koneksi();
            Connection c = k.getKoneksi();
            dao.delete(c, id);
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void update(){
        try {
            
            guide.setId_guide(view.getTxtidg().getText());
            guide.setNama_guide(view.getTxtng().getText());
            guide.setAlamat(view.getTxtag().getText());
            guide.setTelepon(view.getTxttpg().getText());
            guide.setTarif_guide(view.getTxttfg().getText());

            c = k.getKoneksi();
            dao.update(c, guide);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void cariData(){
        String id = view.getTxtidg().getText();
        if(id.length()>0){
            try {
                GuideDAO dao = new GuideDAO();
                Koneksi k = new Koneksi();
                Connection c = k.getKoneksi();
                guide = dao.getGuide(c, id);
                if(guide != null){
                    view.getTxtng().setText(guide.getNama_guide());
                    view.getTxtag().setText(guide.getAlamat());
                    view.getTxttpg().setText(guide.getTelepon());
                    view.getTxttfg().setText(guide.getTarif_guide());
                }else{
                    JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            JOptionPane.showMessageDialog(view, "Input Id Cari");
        }
    }
    
    public void bersihForm(){
        view.getTxtidg().setText("");
        view.getTxtng().setText("");
        view.getTxtag().setText("");
        view.getTxttpg().setText("");
        view.getTxttfg().setText("");
    }
    
    
    public void tampilTable(){
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
    }
    
     public void viewDataDialog(){
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
    }
     
     public void pilihTabel(){
        
            String idguide = view.getTbg().getValueAt(view.getTbg().getSelectedRow(),0).toString();
            String namaguide = view.getTbg().getValueAt(view.getTbg().getSelectedRow(),1).toString();
            String alamat = view.getTbg().getValueAt(view.getTbg().getSelectedRow(),2).toString();
            String telepon = view.getTbg().getValueAt(view.getTbg().getSelectedRow(),3).toString();
            String tarif=view.getTbg().getValueAt(view.getTbg().getSelectedRow(),4).toString();
        try {
            guide = dao.getGuide(c, idguide);
            view.getTxtidg().setText(guide.getId_guide());
            view.getTxtng().setText(guide.getNama_guide());
            view.getTxtag().setText(guide.getAlamat());
            view.getTxttpg().setText(guide.getTelepon());
            view.getTxttfg().setText(guide.getTarif_guide());
 
        } catch (SQLException ex) {
            Logger.getLogger(GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
