/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_wisata_aidill;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.aidil.koneksi.Koneksi;

/**
 *
 * @author Aidil
 */
public class Si_wisata_aidill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Koneksi kon = new Koneksi();
        try {
            kon.getKoneksi();
        } catch (SQLException ex) {
            Logger.getLogger(Si_wisata_aidill.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(null, "Koneksi OK");
    }
    
}
