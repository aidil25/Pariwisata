/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.aidil.controller.JenisWisataController;

/**
 *
 * @author Aidil
 */
public class FormJenisWisata extends javax.swing.JFrame {

    /**
     * Creates new form FormJenisWisata
     */
    JenisWisataController jenisWisataController;
    public FormJenisWisata() {
        initComponents();
        jenisWisataController = new JenisWisataController(this);
        jenisWisataController.bersihForm();
        jenisWisataController.tampilTable();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidjw = new javax.swing.JTextField();
        txtjw = new javax.swing.JTextField();
        btncjw = new javax.swing.JButton();
        btnijw = new javax.swing.JButton();
        btnejw = new javax.swing.JButton();
        btndjw = new javax.swing.JButton();
        btnccjw = new javax.swing.JButton();
        btnexjw = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbjw = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Jenis Wisata");

        jLabel2.setText("Jenis Wisata");

        txtidjw.setText("jTextField1");

        txtjw.setText("jTextField2");

        btncjw.setText("CARI");
        btncjw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncjwActionPerformed(evt);
            }
        });

        btnijw.setText("INSERT");
        btnijw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnijwActionPerformed(evt);
            }
        });

        btnejw.setText("EDIT");
        btnejw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnejwActionPerformed(evt);
            }
        });

        btndjw.setText("DELETE");
        btndjw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndjwActionPerformed(evt);
            }
        });

        btnccjw.setText("CANCEL");
        btnccjw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnccjwActionPerformed(evt);
            }
        });

        btnexjw.setText("EXIT");
        btnexjw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexjwActionPerformed(evt);
            }
        });

        tbjw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Jenis Wisata", "Jenis Wisata"
            }
        ));
        tbjw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbjwMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbjw);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnijw)
                            .addGap(18, 18, 18)
                            .addComponent(btnejw)
                            .addGap(18, 18, 18)
                            .addComponent(btndjw)
                            .addGap(18, 18, 18)
                            .addComponent(btnccjw)
                            .addGap(18, 18, 18)
                            .addComponent(btnexjw))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtjw, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addComponent(txtidjw))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btncjw))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidjw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncjw))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtjw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnijw)
                    .addComponent(btnejw)
                    .addComponent(btndjw)
                    .addComponent(btnccjw)
                    .addComponent(btnexjw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncjwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncjwActionPerformed
        // TODO add your handling code here:
        jenisWisataController.cariData();
    }//GEN-LAST:event_btncjwActionPerformed

    private void btnijwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnijwActionPerformed
        // TODO add your handling code here:
        jenisWisataController.insert();
        jenisWisataController.bersihForm();
        jenisWisataController.tampilTable();
    }//GEN-LAST:event_btnijwActionPerformed

    private void btnejwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnejwActionPerformed
        // TODO add your handling code here:
        jenisWisataController.update();
        jenisWisataController.bersihForm();
        jenisWisataController.tampilTable();
    }//GEN-LAST:event_btnejwActionPerformed

    private void btndjwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndjwActionPerformed
        // TODO add your handling code here:
        jenisWisataController.delete();
        jenisWisataController.bersihForm();
        jenisWisataController.tampilTable();
    }//GEN-LAST:event_btndjwActionPerformed

    private void btnccjwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnccjwActionPerformed
        // TODO add your handling code here:
        jenisWisataController.bersihForm();
    }//GEN-LAST:event_btnccjwActionPerformed

    private void btnexjwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexjwActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexjwActionPerformed

    private void tbjwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbjwMouseClicked
        // TODO add your handling code here:
        jenisWisataController.pilihTabel();
    }//GEN-LAST:event_tbjwMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormJenisWisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJenisWisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJenisWisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJenisWisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJenisWisata().setVisible(true);
            }
        });
    }

    public JButton getBtnccjw() {
        return btnccjw;
    }

    public void setBtnccjw(JButton btnccjw) {
        this.btnccjw = btnccjw;
    }

    public JButton getBtncjw() {
        return btncjw;
    }

    public void setBtncjw(JButton btncjw) {
        this.btncjw = btncjw;
    }

    public JButton getBtndjw() {
        return btndjw;
    }

    public void setBtndjw(JButton btndjw) {
        this.btndjw = btndjw;
    }

    public JButton getBtnejw() {
        return btnejw;
    }

    public void setBtnejw(JButton btnejw) {
        this.btnejw = btnejw;
    }

    public JButton getBtnexjw() {
        return btnexjw;
    }

    public void setBtnexjw(JButton btnexjw) {
        this.btnexjw = btnexjw;
    }

    public JButton getBtnijw() {
        return btnijw;
    }

    public void setBtnijw(JButton btnijw) {
        this.btnijw = btnijw;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JTextField getTxtidjw() {
        return txtidjw;
    }

    public void setTxtidjw(JTextField txtidjw) {
        this.txtidjw = txtidjw;
    }

    public JTextField getTxtjw() {
        return txtjw;
    }

    public void setTxtjw(JTextField txtjw) {
        this.txtjw = txtjw;
    }

    public JenisWisataController getJenisWisataController() {
        return jenisWisataController;
    }

    public void setJenisWisataController(JenisWisataController jenisWisataController) {
        this.jenisWisataController = jenisWisataController;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getTbjw() {
        return tbjw;
    }

    public void setTbjw(JTable tbjw) {
        this.tbjw = tbjw;
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnccjw;
    private javax.swing.JButton btncjw;
    private javax.swing.JButton btndjw;
    private javax.swing.JButton btnejw;
    private javax.swing.JButton btnexjw;
    private javax.swing.JButton btnijw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbjw;
    private javax.swing.JTextField txtidjw;
    private javax.swing.JTextField txtjw;
    // End of variables declaration//GEN-END:variables
}