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
import org.aidil.model.Guide;
import org.aidil.model.Wisata;

/**
 *
 * @author Aidil
 */
public class GuideDAO {
    public void insert(Connection con, Guide guide) throws SQLException{
        String sql = "insert into guide values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, guide.getId_guide());
        ps.setString(2, guide.getNama_guide());
        ps.setString(3, guide.getAlamat());
        ps.setString(4, guide.getTelepon());
        ps.setString(5, guide.getTarif_guide());
        ps.executeUpdate();
    }
    
    public void update(Connection con, Guide guide) throws SQLException{
        String sql = "update guide "
                + "set nama_guide=?, alamat=?, telepon=?, tarif_guide=? "
                + "where id_guide=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, guide.getNama_guide());
        ps.setString(2, guide.getAlamat());
        ps.setString(3, guide.getTelepon());
        ps.setString(4, guide.getTarif_guide());
        ps.setString(5, guide.getId_guide());
        ps.executeUpdate();
    }
    
    public void delete(Connection con, String id) throws SQLException{
        String sql = "delete from guide where id_guide=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    
    public Guide getGuide(Connection con, String id) throws SQLException{
        String sql = "select * from guide where id_guide=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Guide guide = null;
        if(rs.next()){
            guide = new Guide();
            guide.setId_guide(rs.getString(1));
            guide.setNama_guide(rs.getString(2));
            guide.setAlamat(rs.getString(3));
            guide.setTelepon(rs.getString(4));
            guide.setTarif_guide(rs.getString(5));
        }
        return guide;
    }
    public List<Guide> getAllGuide(Connection con) throws SQLException{
        String sql = "select * from guide";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Guide> listGuide = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Guide guide = null;
        while(rs.next()){
            guide = new Guide();
            guide.setId_guide(rs.getString(1));
            guide.setNama_guide(rs.getString(2));
            guide.setAlamat(rs.getString(3));
            guide.setTelepon(rs.getString(4));
            guide.setTarif_guide(rs.getString(5));
            listGuide.add(guide);
        }
        return listGuide;
    }

    public ResultSet getResultSet(Connection c, String query) throws SQLException {
        Statement stat = c.createStatement();
        ResultSet rs = stat.executeQuery(query);
        return rs;
    }
}
