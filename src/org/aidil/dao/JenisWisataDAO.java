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
import org.aidil.model.JenisWisata;

/**
 *
 * @author Aidil
 */
public class JenisWisataDAO {
     public void insert(Connection con, JenisWisata jenisWisata) throws SQLException{
      String sql ="insert into jenis_wisata values(?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, jenisWisata.getId_jenis_wisata());
      ps.setString(2, jenisWisata.getJenis_wisata());
      ps.executeUpdate();
              
    }
    
     public List<JenisWisata> getAllJenisWisata(Connection con) throws SQLException{
        String sql ="select * from jenis_wisata";
        PreparedStatement ps = con.prepareStatement(sql);
        List<JenisWisata> listJenisWisata = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        JenisWisata jenisWisata = null;
        while (rs.next()){
            jenisWisata = new JenisWisata();
            jenisWisata.setId_jenis_wisata(rs.getString(1));
            jenisWisata.setJenis_wisata(rs.getString(2));
            listJenisWisata.add(jenisWisata);
         
        }
        return listJenisWisata;
    }
    
     public void update(Connection con, JenisWisata jenisWisata) throws SQLException{
      String sql ="update jenis_wisata set jenis_wisata=? where id_jenis_wisata=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, jenisWisata.getJenis_wisata());
      ps.setString(2, jenisWisata.getId_jenis_wisata());
      ps.executeUpdate();
              
    }
     
     public void delete(Connection con,String id) throws SQLException{
        String sql="delete from jenis_wisata where id_jenis_wisata=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }
    
     
     public JenisWisata getJenisWisata(Connection con , String id) throws SQLException{
         String sql="select * from jenis_wisata where id_jenis_wisata=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs =ps.executeQuery();
         JenisWisata jenisWisata= null;
         if(rs.next()){
             jenisWisata=new JenisWisata();
             jenisWisata.setId_jenis_wisata(rs.getString(1));
             jenisWisata.setJenis_wisata(rs.getString(2));
         }
         return jenisWisata;
     
}
     
     public ResultSet getResultSet(Connection con, String query) throws SQLException{
         Statement stat = con.createStatement();
         ResultSet rs = stat.executeQuery(query);
         return rs;
     }
}
