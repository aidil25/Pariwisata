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
import org.aidil.model.Pemesanan;

/**
 *
 * @author Aidil
 */
public class PemesananDAO {
    public void insert(Connection con, Pemesanan pemesanan) throws SQLException{
      String sql ="insert into pemesanan values(?,?,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, pemesanan.getId_pemesanan());
      ps.setString(2, pemesanan.getId_guide());
      ps.setString(3, pemesanan.getId_wisatawan());
      ps.setString(4, pemesanan.getPilih_paket());
      ps.setString(5, pemesanan.getId_paket_travel());
      ps.setString(6, pemesanan.getId_wisata());
      ps.setString(7, pemesanan.getId_transportasi());
      ps.setString(8, pemesanan.getId_penginapan());
      ps.setString(9, pemesanan.getLama_wisata());
      ps.setString(10, pemesanan.getJumlah_rombongan());
      ps.setString(11, pemesanan.getTanggal_perjalanan());
      ps.setString(12, pemesanan.getTotal_bayar());
      ps.executeUpdate();
              
    }
    
     public List<Pemesanan> getAllPemesanan(Connection con) throws SQLException{
        String sql ="select * from pemesanan";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Pemesanan> listPemesanan = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Pemesanan pemesanan = null;
        while (rs.next()){
            pemesanan = new Pemesanan();
            pemesanan.setId_pemesanan(rs.getString(1));
            pemesanan.setId_guide(rs.getString(2));
            pemesanan.setId_wisatawan(rs.getString(3));
            pemesanan.setPilih_paket(rs.getString(4));
            pemesanan.setId_paket_travel(rs.getString(5));
            pemesanan.setId_wisata(rs.getString(6));
            pemesanan.setId_transportasi(rs.getString(7));
            pemesanan.setId_penginapan(rs.getString(8));
            pemesanan.setLama_wisata(rs.getString(9));
            pemesanan.setJumlah_rombongan(rs.getString(10));
            pemesanan.setTanggal_perjalanan(rs.getString(11));
            pemesanan.setTotal_bayar(rs.getString(12));
            listPemesanan.add(pemesanan);
         
        }
        return listPemesanan;
    }
    
     public void update(Connection con, Pemesanan pemesanan) throws SQLException{
      String sql ="update pemesanan set id_guide=?, id_wisatawan=?, pilih_paket=?, id_paket_travel=?, id_wisata=?, id_transportasi=?, id_penginapan=?, lama_wisata=?, jumlah_rombongan=?, tanggal_perjalanan=?, total_bayar=? where id_pemesanan=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, pemesanan.getId_guide());
      ps.setString(2, pemesanan.getId_wisatawan());
      ps.setString(3, pemesanan.getPilih_paket());
      ps.setString(4, pemesanan.getId_paket_travel());
      ps.setString(5, pemesanan.getId_wisata());
      ps.setString(6, pemesanan.getId_transportasi());
      ps.setString(7, pemesanan.getId_penginapan());
      ps.setString(8, pemesanan.getLama_wisata());
      ps.setString(9, pemesanan.getJumlah_rombongan());
      ps.setString(10, pemesanan.getTanggal_perjalanan());
      ps.setString(11, pemesanan.getTotal_bayar());
      ps.setString(12, pemesanan.getId_pemesanan());
      ps.executeUpdate();
              
    }
     
     public void delete(Connection con,String id) throws SQLException{
        String sql="delete from pemesanan where id_pemesanan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }
    
     
     public Pemesanan getPemesanan(Connection con , String id) throws SQLException{
         String sql="select * from pemesanan where id_pemesanan=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs =ps.executeQuery();
         Pemesanan pemesanan= null;
         if(rs.next()){
            pemesanan=new Pemesanan();
            pemesanan.setId_pemesanan(rs.getString(1));
            pemesanan.setId_guide(rs.getString(2));
            pemesanan.setId_wisatawan(rs.getString(3));
            pemesanan.setPilih_paket(rs.getString(4));
            pemesanan.setId_paket_travel(rs.getString(5));
            pemesanan.setId_wisata(rs.getString(6));
            pemesanan.setId_transportasi(rs.getString(7));
            pemesanan.setId_penginapan(rs.getString(8));
            pemesanan.setLama_wisata(rs.getString(9));
            pemesanan.setJumlah_rombongan(rs.getString(10));
            pemesanan.setTanggal_perjalanan(rs.getString(11));
            pemesanan.setTotal_bayar(rs.getString(12));
         }
         return pemesanan;
     
}
     
     public ResultSet getResultSet(Connection con, String query) throws SQLException{
         Statement stat = con.createStatement();
         ResultSet rs = stat.executeQuery(query);
         return rs;
     }
}
