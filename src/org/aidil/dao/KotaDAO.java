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
import org.aidil.model.Kota;
import org.aidil.model.Kuliner;

/**
 *
 * @author Aidil
 */
public class KotaDAO {
    public void insert(Connection con, Kota kota) throws SQLException{
      String sql ="insert into kota values(?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, kota.getId_kota());
      ps.setString(2, kota.getNama_kota());
      ps.executeUpdate();
              
    }
    
     public List<Kota> getAllKota(Connection con) throws SQLException{
        String sql ="select * from kota";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Kota> listkota = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Kota kota = null;
        while (rs.next()){
            kota = new Kota();
            kota.setId_kota(rs.getString(1));
            kota.setNama_kota(rs.getString(2));
            listkota.add(kota);
         
        }
        return listkota;
    }
    
     public void update(Connection con, Kota kota) throws SQLException{
      String sql ="update kota set nama_kota=? where id_kota=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, kota.getNama_kota());
      ps.setString(2, kota.getId_kota());
      ps.executeUpdate();
              
    }
     
     public void delete(Connection con,String id) throws SQLException{
        String sql="delete from kota where id_kota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }
    
     
     public Kota getKota(Connection con , String id) throws SQLException{
         String sql="select * from kota where id_kota=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs =ps.executeQuery();
         Kota kota= null;
         if(rs.next()){
             kota=new Kota();
             kota.setId_kota(rs.getString(1));
             kota.setNama_kota(rs.getString(2));
         }
         return kota;
     
}
     
     public ResultSet getResultSet(Connection con, String query) throws SQLException{
         Statement stat = con.createStatement();
         ResultSet rs = stat.executeQuery(query);
         return rs;
     }
}
