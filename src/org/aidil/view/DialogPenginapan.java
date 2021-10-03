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
import org.aidil.controller.PenginapanController;

/**
 *
 * @author Aidil
 */
public class DialogPenginapan extends javax.swing.JDialog {

    /**
     * Creates new form DialogPenginapan
     */
    PenginapanController penginapanController;
    FormPemesanan formPemesanan;
    public DialogPenginapan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formPemesanan = (FormPemesanan)parent;
        penginapanController = new PenginapanController(this);
        penginapanController.viewDataDialog();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtfdpp = new javax.swing.JTextField();
        btnfdpp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdpp = new javax.swing.JTable();
        btnpdpp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID / Nama Penginapan");

        btnfdpp.setText("FILTER");
        btnfdpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfdppActionPerformed(evt);
            }
        });

        tbdpp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Penginapan", "Nama Penginapan", "Tarif Penginapan"
            }
        ));
        jScrollPane1.setViewportView(tbdpp);

        btnpdpp.setText("PILIH");
        btnpdpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtfdpp, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnfdpp)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnpdpp)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtfdpp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfdpp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnpdpp)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfdppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfdppActionPerformed
        // TODO add your handling code here:
        penginapanController.viewDataDialog();
    }//GEN-LAST:event_btnfdppActionPerformed

    private void btnpdppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdppActionPerformed
        // TODO add your handling code here:
        formPemesanan.getTxtidpp().setText(tbdpp.getValueAt(tbdpp.getSelectedRow(),0).toString());
        formPemesanan.getTxtnpps().setText(tbdpp.getValueAt(tbdpp.getSelectedRow(),1).toString());
        formPemesanan.getTxttpps().setText(tbdpp.getValueAt(tbdpp.getSelectedRow(),2).toString());
        dispose();
    }//GEN-LAST:event_btnpdppActionPerformed

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
            java.util.logging.Logger.getLogger(DialogPenginapan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogPenginapan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogPenginapan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogPenginapan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogPenginapan dialog = new DialogPenginapan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JButton getBtnfdpp() {
        return btnfdpp;
    }

    public void setBtnfdpp(JButton btnfdpp) {
        this.btnfdpp = btnfdpp;
    }

    public JButton getBtnpdpp() {
        return btnpdpp;
    }

    public void setBtnpdpp(JButton btnpdpp) {
        this.btnpdpp = btnpdpp;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTbdpp() {
        return tbdpp;
    }

    public void setTbdpp(JTable tbdpp) {
        this.tbdpp = tbdpp;
    }

    public JTextField getTxtfdpp() {
        return txtfdpp;
    }

    public void setTxtfdpp(JTextField txtfdpp) {
        this.txtfdpp = txtfdpp;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfdpp;
    private javax.swing.JButton btnpdpp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbdpp;
    private javax.swing.JTextField txtfdpp;
    // End of variables declaration//GEN-END:variables
}