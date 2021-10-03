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
import org.aidil.model.Transportasi;

/**
 *
 * @author Aidil
 */
public class TransportasiDAO {
    
    public void insert(Connection con, Transportasi transportasi) throws SQLException{
        String sql = "insert into transportasi values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, transportasi.getId_transportasi());
        ps.setString(2, transportasi.getNama_kendaraan());
        ps.setString(3, transportasi.getId_jenis_transportasi());
        ps.setString(4, transportasi.getStatus());
        ps.setString(5, transportasi.getTarif_transportasi());
        ps.executeUpdate();
    }
    
    public void update(Connection con, Transportasi transportasi) throws SQLException{
        String sql = "update transportasi "
                + "set nama_kendaraan=?, id_jenis_transportasi=?, status=?, tarif_transportasi=?"
                + "where id_transportasi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, transportasi.getNama_kendaraan());
        ps.setString(2, transportasi.getId_jenis_transportasi());
        ps.setString(3, transportasi.getStatus());
        ps.setString(4, transportasi.getTarif_transportasi());
        ps.setString(5, transportasi.getId_transportasi());
        ps.executeUpdate();
    }
    
    public void delete(Connection con, String id) throws SQLException{
        String sql = "delete from transportasi where id_transportasi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    
    public Transportasi getTransportasi(Connection con, String id) throws SQLException{
        String sql = "select * from transportasi where id_transportasi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Transportasi transportasi = null;
        if(rs.next()){
            transportasi = new Transportasi();
            transportasi.setId_transportasi(rs.getString(1));
            transportasi.setNama_kendaraan(rs.getString(2));
            transportasi.setId_jenis_transportasi(rs.getString(3));
            transportasi.setStatus(rs.getString(4));
            transportasi.setTarif_transportasi(rs.getString(5));
        }
        return transportasi;
    }
    public List<Transportasi> getAllTransportasi(Connection con) throws SQLException{
        String sql = "select * from transportasi";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Transportasi> listTransportasi = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Transportasi transportasi = null;
        while(rs.next()){
            transportasi = new Transportasi();
            transportasi.setId_transportasi(rs.getString(1));
            transportasi.setNama_kendaraan(rs.getString(2));
            transportasi.setId_jenis_transportasi(rs.getString(3));
            transportasi.setStatus(rs.getString(4));
            transportasi.setTarif_transportasi(rs.getString(5));
            listTransportasi.add(transportasi);
        }
        return listTransportasi;
    }

    public ResultSet getResultSet(Connection c, String query) throws SQLException {
        Statement stat = c.createStatement();
        ResultSet rs = stat.executeQuery(query);
        return rs;
    }
}
