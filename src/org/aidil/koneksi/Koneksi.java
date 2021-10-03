/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aidil
 */
public class Koneksi {

    private String url="jdbc:mysql://localhost/pariwisata";
    private String username="root";
    private String password="";
    
    public Connection getKoneksi() throws SQLException 
    {
        return DriverManager.getConnection(url, username, password);
    }
    
}
