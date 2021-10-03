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
import org.aidil.model.Pembayaran;

/**
 *
 * @author Aidil
 */
public class PembayaranDAO {
    public void insert(Connection con, Pembayaran pembayaran) throws SQLException{
        String sql = "insert into Pembayaran values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pembayaran.getId_pembayaran());
        ps.setString(2, pembayaran.getId_pemesanan());
        ps.setString(3, pembayaran.getTotal_bayar());
        ps.setString(4, pembayaran.getJumlah_bayar());
        ps.setString(5, pembayaran.getSisa());
        ps.setString(6, pembayaran.getTanggal_transaksi());
        
        ps.executeUpdate();
    }
    
    public void update(Connection con, Pembayaran pembayaran) throws SQLException{
        String sql = "update pembayaran "
                + "set id_pemesanan=?, total_bayar=?, tanggal_transaksi=?, jumlah_bayar=?, sisa=? "
                + "where id_pembayaran=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, pembayaran.getId_pemesanan());
        ps.setString(2, pembayaran.getTotal_bayar());
        ps.setString(4, pembayaran.getJumlah_bayar());
        ps.setString(5, pembayaran.getSisa());
        ps.setString(3, pembayaran.getTanggal_transaksi());
        ps.setString(6, pembayaran.getId_pembayaran());
        ps.executeUpdate();
    }
    
    public void delete(Connection con, String id) throws SQLException{
        String sql = "delete from pembayaran where id_pembayaran=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    
    public Pembayaran getPembayaran(Connection con, String id) throws SQLException{
        String sql = "select * from pembayaran where id_pembayaran=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Pembayaran pembayaran = null;
        if(rs.next()){
            pembayaran = new Pembayaran();
            pembayaran.setId_pembayaran(rs.getString(1));
            pembayaran.setId_pemesanan(rs.getString(2));
            pembayaran.setTotal_bayar(rs.getString(3));
            pembayaran.setJumlah_bayar(rs.getString(4));
            pembayaran.setSisa(rs.getString(5));
            pembayaran.setTanggal_transaksi(rs.getString(6));
        }
        return pembayaran;
    }
    public List<Pembayaran> getAllPembayaran(Connection con) throws SQLException{
        String sql = "select * from pembayaran";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Pembayaran> listPembayaran = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Pembayaran pembayaran = null;
        while(rs.next()){
            pembayaran = new Pembayaran();
            pembayaran.setId_pembayaran(rs.getString(1));
            pembayaran.setId_pemesanan(rs.getString(2));
            pembayaran.setTotal_bayar(rs.getString(3));
            pembayaran.setJumlah_bayar(rs.getString(4));
            pembayaran.setSisa(rs.getString(5));
            pembayaran.setTanggal_transaksi(rs.getString(6));
            listPembayaran.add(pembayaran);
        }
        return listPembayaran;
    }

    public ResultSet getResultSet(Connection c, String query) throws SQLException {
        Statement stat = c.createStatement();
        ResultSet rs = stat.executeQuery(query);
        return rs;
    }
}
