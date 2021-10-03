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
import org.aidil.model.JenisTransportasi;
import org.aidil.model.JenisWisata;

/**
 *
 * @author Aidil
 */
public class JenisTransportasiDAO {
    public void insert(Connection con, JenisTransportasi jenisTransportasi) throws SQLException{
      String sql ="insert into jenis_transportasi values(?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, jenisTransportasi.getId_jenis_transportasi());
      ps.setString(2, jenisTransportasi.getJenis_transportasi());
      ps.executeUpdate();
              
    }
    
     public List<JenisTransportasi> getAllJenisTransportasi(Connection con) throws SQLException{
        String sql ="select * from jenis_transportasi";
        PreparedStatement ps = con.prepareStatement(sql);
        List<JenisTransportasi> listJenisTransportasi = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        JenisTransportasi jenisTransportasi = null;
        while (rs.next()){
            jenisTransportasi = new JenisTransportasi();
            jenisTransportasi.setId_jenis_transportasi(rs.getString(1));
            jenisTransportasi.setJenis_transportasi(rs.getString(2));
            listJenisTransportasi.add(jenisTransportasi);
         
        }
        return listJenisTransportasi;
    }
    
     public void update(Connection con, JenisTransportasi jenisTransportasi) throws SQLException{
      String sql ="update jenis_transportasi set jenis_transportasi=? where id_jenis_transportasi=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, jenisTransportasi.getJenis_transportasi());
      ps.setString(2, jenisTransportasi.getId_jenis_transportasi());
      ps.executeUpdate();
              
    }
     
     public void delete(Connection con,String id) throws SQLException{
        String sql="delete from jenis_transportasi where id_jenis_transportasi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }
    
     
     public JenisTransportasi getJenisTransportasi(Connection con , String id) throws SQLException{
         String sql="select * from jenis_transportasi where id_jenis_transportasi=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs =ps.executeQuery();
         JenisTransportasi jenisTransportasi= null;
         if(rs.next()){
             jenisTransportasi=new JenisTransportasi();
             jenisTransportasi.setId_jenis_transportasi(rs.getString(1));
             jenisTransportasi.setJenis_transportasi(rs.getString(2));
         }
         return jenisTransportasi;
     
}
     
     public ResultSet getResultSet(Connection con, String query) throws SQLException{
         Statement stat = con.createStatement();
         ResultSet rs = stat.executeQuery(query);
         return rs;
     }
}
