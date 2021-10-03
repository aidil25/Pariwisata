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
import org.aidil.model.JenisPenginapan;
import org.aidil.model.JenisWisata;

/**
 *
 * @author Aidil
 */
public class JenisPenginapanDAO {
     public void insert(Connection con, JenisPenginapan jenisPenginapan) throws SQLException{
      String sql ="insert into jenis_penginapan values(?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, jenisPenginapan.getId_jenis_penginapan());
      ps.setString(2, jenisPenginapan.getJenis_penginapan());
      ps.executeUpdate();
              
    }
    
     public List<JenisPenginapan> getAllJenisPenginapan(Connection con) throws SQLException{
        String sql ="select * from jenis_penginapan";
        PreparedStatement ps = con.prepareStatement(sql);
        List<JenisPenginapan> listJenisPenginapan = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        JenisPenginapan jenisPenginapan = null;
        while (rs.next()){
            jenisPenginapan = new JenisPenginapan();
            jenisPenginapan.setId_jenis_penginapan(rs.getString(1));
            jenisPenginapan.setJenis_penginapan(rs.getString(2));
            listJenisPenginapan.add(jenisPenginapan);
         
        }
        return listJenisPenginapan;
    }
    
     public void update(Connection con, JenisPenginapan jenisPenginapan) throws SQLException{
      String sql ="update jenis_penginapan set jenis_penginapan=? where id_jenis_penginapan=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, jenisPenginapan.getJenis_penginapan());
      ps.setString(2, jenisPenginapan.getId_jenis_penginapan());
      ps.executeUpdate();
              
    }
     
     public void delete(Connection con,String id) throws SQLException{
        String sql="delete from jenis_penginapan where id_jenis_penginapan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }
    
     
     public JenisPenginapan getJenisPenginapan(Connection con , String id) throws SQLException{
         String sql="select * from jenis_penginapan where id_jenis_penginapan=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs =ps.executeQuery();
         JenisPenginapan jenisPenginapan= null;
         if(rs.next()){
             jenisPenginapan=new JenisPenginapan();
             jenisPenginapan.setId_jenis_penginapan(rs.getString(1));
             jenisPenginapan.setJenis_penginapan(rs.getString(2));
         }
         return jenisPenginapan;
     
}
     
     public ResultSet getResultSet(Connection con, String query) throws SQLException{
         Statement stat = con.createStatement();
         ResultSet rs = stat.executeQuery(query);
         return rs;
     }
}
