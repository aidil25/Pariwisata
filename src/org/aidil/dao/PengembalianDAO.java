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
import org.aidil.model.Pemesanan;
import org.aidil.model.Pengembalian;

/**
 *
 * @author Aidil
 */
public class PengembalianDAO {
     public void insert(Connection con, Pengembalian pengembalian) throws SQLException{
      String sql ="insert into pengembalian values(?,?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, pengembalian.getId_pengembalian());
      ps.setString(2, pengembalian.getId_pemesanan());
      ps.setString(3, pengembalian.getTanggal_perjalanan());
      ps.setString(4, pengembalian.getTanggal_kembali());
      ps.setString(5, pengembalian.getTerlambat());
      ps.setString(6, pengembalian.getDenda());
      ps.executeUpdate();
              
    }
    
     public List<Pengembalian> getAllPengembalian(Connection con) throws SQLException{
        String sql ="select * from pengembalian";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Pengembalian> listPengembalian = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Pengembalian pengembalian = null;
        while (rs.next()){
            pengembalian = new Pengembalian();
            pengembalian.setId_pengembalian(rs.getString(1));
            pengembalian.setId_pemesanan(rs.getString(2));
            pengembalian.setTanggal_perjalanan(rs.getString(3));
            pengembalian.setTanggal_kembali(rs.getString(4));
            pengembalian.setTerlambat(rs.getString(5));
            pengembalian.setDenda(rs.getString(6));
            listPengembalian.add(pengembalian);
         
        }
        return listPengembalian;
    }
    
     public void update(Connection con, Pengembalian pengembalian) throws SQLException{
      String sql ="update pengembalian set id_pemesanan=?, tanggal_perjalanan=?, tanggal_kembali=?, terlambat=?, denda=?  where id_pengembalian=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, pengembalian.getId_pemesanan());
      ps.setString(2, pengembalian.getTanggal_perjalanan());
      ps.setString(3, pengembalian.getTanggal_kembali());
      ps.setString(4, pengembalian.getTerlambat());
      ps.setString(5, pengembalian.getDenda());
      ps.setString(6, pengembalian.getId_pengembalian());
      ps.executeUpdate();
              
    }
     
     public void delete(Connection con,String id) throws SQLException{
        String sql="delete from pengembalian where id_pengembalian=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }
    
     
     public Pengembalian getPengembalian(Connection con , String id) throws SQLException{
         String sql="select * from pengembalian where id_pengembalian=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs =ps.executeQuery();
         Pengembalian pengembalian= null;
         if(rs.next()){
            pengembalian=new Pengembalian();
            pengembalian.setId_pengembalian(rs.getString(1));
            pengembalian.setId_pemesanan(rs.getString(2));
            pengembalian.setTanggal_perjalanan(rs.getString(3));
            pengembalian.setTanggal_kembali(rs.getString(4));
            pengembalian.setTerlambat(rs.getString(5));
            pengembalian.setDenda(rs.getString(6));
         }
         return pengembalian;
     
}
     
     public ResultSet getResultSet(Connection con, String query) throws SQLException{
         Statement stat = con.createStatement();
         ResultSet rs = stat.executeQuery(query);
         return rs;
     }
}
