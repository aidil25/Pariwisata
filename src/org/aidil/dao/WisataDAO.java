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
import org.aidil.model.Wisata;

/**
 *
 * @author Aidil
 */
public class WisataDAO {
    public void insert(Connection con, Wisata wisata) throws SQLException{
        String sql = "insert into wisata values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, wisata.getId_nama_wisata());
        ps.setString(2, wisata.getTempat_wisata());
        ps.setString(3, wisata.getId_jenis_wisata());
        ps.setString(4, wisata.getTarif_wisata());
        ps.executeUpdate();
    }
    
    public void update(Connection con, Wisata wisata) throws SQLException{
        String sql = "update wisata "
                + "set nama_wisata=?, id_jenis_wisata=?, tarif_wisata=?"
                + "where id_wisata=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, wisata.getTempat_wisata());
        ps.setString(2, wisata.getId_jenis_wisata());
        ps.setString(3, wisata.getTarif_wisata());
        ps.setString(4, wisata.getId_nama_wisata());
        ps.executeUpdate();
    }
    
    public void delete(Connection con, String id) throws SQLException{
        String sql = "delete from wisata where id_wisata=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    
    public Wisata getWisata(Connection con, String id) throws SQLException{
        String sql = "select * from wisata where id_wisata=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Wisata wisata = null;
        if(rs.next()){
            wisata = new Wisata();
            wisata.setId_nama_wisata(rs.getString(1));
            wisata.setTempat_wisata(rs.getString(2));
            wisata.setId_jenis_wisata(rs.getString(3));
            wisata.setTarif_wisata(rs.getString(4));
        }
        return wisata;
    }
    public List<Wisata> getAllWisata(Connection con) throws SQLException{
        String sql = "select * from wisata";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Wisata> listWisata = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Wisata wisata = null;
        while(rs.next()){
            wisata = new Wisata();
            wisata.setId_nama_wisata(rs.getString(1));
            wisata.setTempat_wisata(rs.getString(2));
            wisata.setId_jenis_wisata(rs.getString(3));
            wisata.setTarif_wisata(rs.getString(4));
            listWisata.add(wisata);
        }
        return listWisata;
    }

   public ResultSet getResultSet(Connection c, String query) throws SQLException {
        Statement stat = c.createStatement();
        ResultSet rs = stat.executeQuery(query);
        return rs;
    }
}
