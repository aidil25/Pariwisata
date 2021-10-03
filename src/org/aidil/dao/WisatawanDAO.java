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
import org.aidil.model.Wisata;
import org.aidil.model.Wisatawan;

/**
 *
 * @author Aidil
 */
public class WisatawanDAO {
    public void insert(Connection con, Wisatawan wisatawan) throws SQLException{
      String sql ="insert into wisatawan values(?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, wisatawan.getId_wisatawan());
      ps.setString(2, wisatawan.getNama());
      ps.setString(3, wisatawan.getAlamat());
      ps.setString(4, wisatawan.getTelepon());
      ps.executeUpdate();
              
    }
    
     public List<Wisatawan> getAllWisatawan(Connection con) throws SQLException{
        String sql ="select * from wisatawan";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Wisatawan> listWisatawan = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Wisatawan wisatawan = null;
        while (rs.next()){
            wisatawan = new Wisatawan();
            wisatawan.setId_wisatawan(rs.getString(1));
            wisatawan.setNama(rs.getString(2));
            wisatawan.setAlamat(rs.getString(3));
            wisatawan.setTelepon(rs.getString(4));
            listWisatawan.add(wisatawan);
         
        }
        return listWisatawan;
    }
    
     public void update(Connection con, Wisatawan wisatawan) throws SQLException{
      String sql ="update wisatawan set nama_wisatawan=?, alamat=?, telepon=? where id_wisatawan=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, wisatawan.getNama());
      ps.setString(2, wisatawan.getAlamat());
      ps.setString(3, wisatawan.getTelepon());
      ps.setString(4, wisatawan.getId_wisatawan());
      ps.executeUpdate();
              
    }
     
     public void delete(Connection con,String id) throws SQLException{
        String sql="delete from wisatawan where id_wisatawan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }
    
     
     public Wisatawan getWisatawan(Connection con , String id) throws SQLException{
         String sql="select * from wisatawan where id_wisatawan=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs =ps.executeQuery();
         Wisatawan wisatawan= null;
         if(rs.next()){
             wisatawan=new Wisatawan();
             wisatawan.setId_wisatawan(rs.getString(1));
             wisatawan.setNama(rs.getString(2));
             wisatawan.setAlamat(rs.getString(3));
             wisatawan.setTelepon(rs.getString(4));
         }
         return wisatawan;
     
}
     
      public ResultSet getResultSet(Connection c, String query) throws SQLException {
        Statement stat = c.createStatement();
        ResultSet rs = stat.executeQuery(query);
        return rs;
    }

    public Wisata getWisata(Connection c, String id_wisata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
