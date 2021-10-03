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
import org.aidil.model.Penginapan;
import org.aidil.model.Transportasi;
import org.aidil.model.Wisata;

/**
 *
 * @author Aidil
 */
public class PenginapanDAO {
    public void insert(Connection con, Penginapan penginapan) throws SQLException{
        String sql = "insert into penginapan values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, penginapan.getId_penginapan());
        ps.setString(2, penginapan.getNama_penginapan());
        ps.setString(3, penginapan.getId_jenis_penginapan());
        ps.setString(4, penginapan.getTarif_penginapan());
        ps.executeUpdate();
    }
    
    public void update(Connection con, Penginapan penginapan) throws SQLException{
        String sql = "update penginapan "
                + "set nama_penginapan=?, id_jenis_penginapan=?, tarif_penginapan=?"
                + "where id_penginapan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(4, penginapan.getId_penginapan());
        ps.setString(1, penginapan.getNama_penginapan());
        ps.setString(2, penginapan.getId_jenis_penginapan());
        ps.setString(3, penginapan.getTarif_penginapan());
        ps.executeUpdate();
    }
    
    public void delete(Connection con, String id) throws SQLException{
        String sql = "delete from penginapan where id_penginapan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    
    public Penginapan getPenginapan(Connection con, String id) throws SQLException{
        String sql = "select * from penginapan where id_penginapan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Penginapan penginapan = null;
        if(rs.next()){
            penginapan = new Penginapan();
            penginapan.setId_penginapan(rs.getString(1));
            penginapan.setNama_penginapan(rs.getString(2));
            penginapan.setId_jenis_penginapan(rs.getString(3));
            penginapan.setTarif_penginapan(rs.getString(4));
        }
        return penginapan;
    }
    public List<Penginapan> getAllPenginapan(Connection con) throws SQLException{
        String sql = "select * from penginapan";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Penginapan> listPenginapan = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Penginapan penginapan = null;
        while(rs.next()){
            penginapan = new Penginapan();
            penginapan.setId_penginapan(rs.getString(1));
            penginapan.setNama_penginapan(rs.getString(2));
            penginapan.setId_jenis_penginapan(rs.getString(3));
            penginapan.setTarif_penginapan(rs.getString(4));
            listPenginapan.add(penginapan);
        }
        return listPenginapan;
    }

    public ResultSet getResultSet(Connection c, String query) throws SQLException {
        Statement stat = c.createStatement();
        ResultSet rs = stat.executeQuery(query);
        return rs;
    }
   
}
