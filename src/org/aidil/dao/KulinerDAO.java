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
import org.aidil.model.Kuliner;

/**
 *
 * @author Aidil
 */
public class KulinerDAO {
    public void insert(Connection con, Kuliner kuliner) throws SQLException{
      String sql ="insert into kuliner values(?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, kuliner.getId_kuliner());
      ps.setString(2, kuliner.getNama());
      ps.executeUpdate();
              
    }
    
     public List<Kuliner> getAllKuliner(Connection con) throws SQLException{
        String sql ="select * from kuliner";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Kuliner> listkuliner = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Kuliner kuliner = null;
        while (rs.next()){
            kuliner = new Kuliner();
            kuliner.setId_kuliner(rs.getString(1));
            kuliner.setNama(rs.getString(2));
            listkuliner.add(kuliner);
         
        }
        return listkuliner;
    }
    
     public void update(Connection con, Kuliner kuliner) throws SQLException{
      String sql ="update kuliner set nama=? where id_kuliner=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, kuliner.getNama());
      ps.setString(2, kuliner.getId_kuliner());
      ps.executeUpdate();
              
    }
     
     public void delete(Connection con,String id) throws SQLException{
        String sql="delete from kuliner where id_kuliner=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }
    
     
     public Kuliner getKuliner(Connection con , String id) throws SQLException{
         String sql="select * from kuliner where id_kuliner=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs =ps.executeQuery();
         Kuliner kuliner= null;
         if(rs.next()){
             kuliner=new Kuliner();
             kuliner.setId_kuliner(rs.getString(1));
             kuliner.setNama(rs.getString(2));
         }
         return kuliner;
     
}
     
     public ResultSet getResultSet(Connection con, String query) throws SQLException{
         Statement stat = con.createStatement();
         ResultSet rs = stat.executeQuery(query);
         return rs;
     }
}
