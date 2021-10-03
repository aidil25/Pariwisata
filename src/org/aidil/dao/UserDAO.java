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
import java.util.ArrayList;
import java.util.List;
import org.aidil.model.User;

/**
 *
 * @author Aidil
 */
public class UserDAO {
     public void insert(Connection con, User user) throws SQLException {
        String sql = "insert into user values (?,md5(?),?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setInt(3, user.getJenis());
        ps.executeUpdate();
    }
    
    public void update(Connection con,User user) throws SQLException{
        String sql = "update user set password=?,jenis=? where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(2, user.getPassword());
        ps.setInt(3, user.getJenis());
        ps.setString(1, user.getUsername());
        ps.executeUpdate();
        
    }
     public void delete(Connection con, String id) throws SQLException{
        String sql = "delete from user where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    public List<User> getAllUser(Connection c) throws SQLException{
        String sql = "select username from user";
        PreparedStatement ps = c.prepareStatement(sql);
        User user = null;
        List<User> listUser = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
        user = new User();
        user.setUsername(rs.getString(1));
        listUser.add(user);
        }
        return listUser;
    }   
    public User getUser(Connection con,String username,String password) throws SQLException{
        String sql = "select * from user where username=? and password=md5(?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
          ResultSet rs = ps.executeQuery();
          User user = null;
          if (rs.next()) {
              user = new User();
              user.setUsername(rs.getString(1));
              user.setPassword(rs.getString(2));
              user.setJenis(rs.getInt(3));
          }
          return user; 
    }
    
    public User getUserLogin(Connection con,String username,String password) throws SQLException{
        String sql = "select * from user where username=? and password=md5(?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2,password);
          ResultSet rs = ps.executeQuery();
          User user = null;
          if (rs.next()) {
              user = new User();
              user.setUsername(rs.getString(1));
              user.setPassword(rs.getString(2));
              user.setJenis(rs.getInt(3));
          }
          return user; 
    }
}
