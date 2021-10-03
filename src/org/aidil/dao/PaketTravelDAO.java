/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.aidil.model.PaketTravel;


/**
 *
 * @author Aidil
 */
public class PaketTravelDAO {
     public void insert(Connection con, PaketTravel paketTravel) throws SQLException{
        String sql = "insert into paket_travel values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, paketTravel.getId_paket_travel());
        ps.setString(2, paketTravel.getId_wisata());
        ps.setString(3, paketTravel.getNama_wisata());
        ps.setString(4, paketTravel.getTarif_wisata());
        ps.setString(5, paketTravel.getId_transportasi());
        ps.setString(6, paketTravel.getNama_kendaraan());
        ps.setString(7, paketTravel.getTarif_transportasi());
        ps.setString(8, paketTravel.getId_penginapan());
        ps.setString(9, paketTravel.getNama_penginapan());
        ps.setString(10, paketTravel.getTarif_penginapan());
        ps.setString(11, paketTravel.getLama_wisata());
        ps.setString(12, paketTravel.getJumlah_rombongan());
        ps.executeUpdate();
    }
    
    public void update(Connection con, PaketTravel paketTravel) throws SQLException{
        String sql = "update paket_travel "
                + "set id_wisata=?, nama_wisata=?, tarif_wisata=?, id_transportasi=?, nama_kendaraan=?, tarif_transportasi=?, id_penginapan=?, nama_penginapan=?, tarif_penginapan=?, lama_wisata=?, jumlah_rombongan=?"
                + "where id_paket_travel=?";
        PreparedStatement ps = con.prepareStatement(sql);
         
        ps.setString(1, paketTravel.getId_wisata());
        ps.setString(2, paketTravel.getNama_wisata());
        ps.setString(3, paketTravel.getTarif_wisata());
        ps.setString(4, paketTravel.getId_transportasi());
        ps.setString(5, paketTravel.getNama_kendaraan());
        ps.setString(6, paketTravel.getTarif_transportasi());
        ps.setString(7, paketTravel.getId_penginapan());
        ps.setString(8, paketTravel.getNama_penginapan());
        ps.setString(9, paketTravel.getTarif_penginapan());
        ps.setString(10, paketTravel.getLama_wisata());
        ps.setString(11, paketTravel.getJumlah_rombongan());
        ps.setString(12, paketTravel.getId_paket_travel());
        ps.executeUpdate();
    }
    
    public void delete(Connection con, String id) throws SQLException{
        String sql = "delete from paket_travel where id_paket_travel=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    
    public PaketTravel getPaketTravel(Connection con, String id) throws SQLException{
        String sql = "select * from paket_travel where id_paket_travel=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        PaketTravel paketTravel = null;
        if(rs.next()){
            paketTravel = new PaketTravel();
            paketTravel.setId_paket_travel(rs.getString(1));
            paketTravel.setId_wisata(rs.getString(2));
            paketTravel.setNama_wisata(rs.getString(3));
            paketTravel.setTarif_wisata(rs.getString(4));
            paketTravel.setId_transportasi(rs.getString(5));
            paketTravel.setNama_kendaraan(rs.getString(6));
            paketTravel.setTarif_transportasi(rs.getString(7));
            paketTravel.setId_penginapan(rs.getString(8));
            paketTravel.setNama_penginapan(rs.getString(9));
            paketTravel.setTarif_penginapan(rs.getString(10));
            paketTravel.setLama_wisata(rs.getString(11));
            paketTravel.setJumlah_rombongan(rs.getString(12));
        }
        return paketTravel;
    }
    public List<PaketTravel> getAllPaketTravel(Connection con) throws SQLException{
        String sql = "select * from paket_travel";
        PreparedStatement ps = con.prepareStatement(sql);
        PaketTravel paketTravel= null;
        List<PaketTravel> listPaketTravel = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            paketTravel=new PaketTravel();
            paketTravel.setId_paket_travel(rs.getString(1));
            paketTravel.setId_wisata(rs.getString(2));
            paketTravel.setNama_wisata(rs.getString(3));
            paketTravel.setTarif_wisata(rs.getString(4));
            paketTravel.setId_transportasi(rs.getString(5));
            paketTravel.setNama_kendaraan(rs.getString(6));
            paketTravel.setTarif_transportasi(rs.getString(7));
            paketTravel.setId_penginapan(rs.getString(8));
            paketTravel.setNama_penginapan(rs.getString(9));
            paketTravel.setTarif_penginapan(rs.getString(10));
            paketTravel.setLama_wisata(rs.getString(11));
            paketTravel.setJumlah_rombongan(rs.getString(12));
            listPaketTravel.add(paketTravel);
        }
        return listPaketTravel;
    }

    public ResultSet getResultSet(Connection c, String query) throws SQLException {
        Statement stat = c.createStatement();
        ResultSet rs = stat.executeQuery(query);
        return rs;
    }
}
