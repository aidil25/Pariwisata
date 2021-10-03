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
import org.aidil.controller.TransportasiController;

/**
 *
 * @author Aidil
 */
public class DialogTransportasiPaketTravel extends javax.swing.JDialog {

    /**
     * Creates new form DialogTransportasiPaketTravel
     */
    TransportasiController transportasiController;
    FormPaketTravel formPaketTravel;
    public DialogTransportasiPaketTravel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formPaketTravel = (FormPaketTravel)parent;
        transportasiController = new TransportasiController(this);
        transportasiController.viewDataDialog1();
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
        txtfdtpt = new javax.swing.JTextField();
        btnfdtpt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdtpt = new javax.swing.JTable();
        btnpdtpt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID / Nama Kendaraan'");

        btnfdtpt.setText("FILTER");
        btnfdtpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfdtptActionPerformed(evt);
            }
        });

        tbdtpt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Transportasi", "Nama Kendaraan", "Tarif Transportasi"
            }
        ));
        jScrollPane1.setViewportView(tbdtpt);

        btnpdtpt.setText("PILIH");
        btnpdtpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdtptActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfdtpt, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnfdtpt)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnpdtpt)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtfdtpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfdtpt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnpdtpt)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfdtptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfdtptActionPerformed
        // TODO add your handling code here:
        transportasiController.viewDataDialog1();
    }//GEN-LAST:event_btnfdtptActionPerformed

    private void btnpdtptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdtptActionPerformed
        // TODO add your handling code here:
        formPaketTravel.getTxtidtpt().setText(tbdtpt.getValueAt(tbdtpt.getSelectedRow(),0).toString());
        formPaketTravel.getTxtnnkpt().setText(tbdtpt.getValueAt(tbdtpt.getSelectedRow(),1).toString());
        formPaketTravel.getTxtttpt().setText(tbdtpt.getValueAt(tbdtpt.getSelectedRow(),2).toString());
        dispose();
    }//GEN-LAST:event_btnpdtptActionPerformed

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
            java.util.logging.Logger.getLogger(DialogTransportasiPaketTravel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogTransportasiPaketTravel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogTransportasiPaketTravel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogTransportasiPaketTravel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogTransportasiPaketTravel dialog = new DialogTransportasiPaketTravel(new javax.swing.JFrame(), true);
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

    public TransportasiController getTransportasiController() {
        return transportasiController;
    }

    public void setTransportasiController(TransportasiController transportasiController) {
        this.transportasiController = transportasiController;
    }

    public FormPaketTravel getFormPaketTravel() {
        return formPaketTravel;
    }

    public void setFormPaketTravel(FormPaketTravel formPaketTravel) {
        this.formPaketTravel = formPaketTravel;
    }

    public JButton getBtnfdtpt() {
        return btnfdtpt;
    }

    public void setBtnfdtpt(JButton btnfdtpt) {
        this.btnfdtpt = btnfdtpt;
    }

    public JButton getBtnpdtpt() {
        return btnpdtpt;
    }

    public void setBtnpdtpt(JButton btnpdtpt) {
        this.btnpdtpt = btnpdtpt;
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

    public JTable getTbdtpt() {
        return tbdtpt;
    }

    public void setTbdtpt(JTable tbdtpt) {
        this.tbdtpt = tbdtpt;
    }

    public JTextField getTxtfdtpt() {
        return txtfdtpt;
    }

    public void setTxtfdtpt(JTextField txtfdtpt) {
        this.txtfdtpt = txtfdtpt;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfdtpt;
    private javax.swing.JButton btnpdtpt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbdtpt;
    private javax.swing.JTextField txtfdtpt;
    // End of variables declaration//GEN-END:variables
}