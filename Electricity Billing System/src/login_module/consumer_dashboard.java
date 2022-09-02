/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_module;

/**
 *
 * @author SHREYASI
 */
public class consumer_dashboard extends javax.swing.JFrame {

    /**
     * Creates new form consumer_dashboard
     */
    public consumer_dashboard() {
        initComponents();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        ons_service = new javax.swing.JMenu();
        cal_bill_mi = new javax.swing.JMenuItem();
        pay_bill_mi = new javax.swing.JMenuItem();
        comp_reg_mi = new javax.swing.JMenuItem();
        logout_mi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login_module/cons_dashboard_image.jpg"))); // NOI18N

        ons_service.setText("Consumer Services");

        cal_bill_mi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK));
        cal_bill_mi.setText("Calculate Bill");
        cal_bill_mi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal_bill_miActionPerformed(evt);
            }
        });
        ons_service.add(cal_bill_mi);

        pay_bill_mi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        pay_bill_mi.setText("Pay Bill");
        pay_bill_mi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_bill_miActionPerformed(evt);
            }
        });
        ons_service.add(pay_bill_mi);

        comp_reg_mi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        comp_reg_mi.setText("Complaint Registration");
        comp_reg_mi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_reg_miActionPerformed(evt);
            }
        });
        ons_service.add(comp_reg_mi);

        logout_mi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        logout_mi.setText("Logout");
        logout_mi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_miActionPerformed(evt);
            }
        });
        ons_service.add(logout_mi);

        jMenuBar1.add(ons_service);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_miActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_miActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_logout_miActionPerformed

    private void cal_bill_miActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal_bill_miActionPerformed
        // TODO add your handling code here:
        Calculate_bill cb = new Calculate_bill();
        cb.setVisible(true);
    }//GEN-LAST:event_cal_bill_miActionPerformed

    private void pay_bill_miActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_bill_miActionPerformed
        // TODO add your handling code here:
        Pay_bill pb = new Pay_bill();
        pb.setVisible(true);
    }//GEN-LAST:event_pay_bill_miActionPerformed

    private void comp_reg_miActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_reg_miActionPerformed
        // TODO add your handling code here:
        Complaint_registration comp = new Complaint_registration();
        comp.setVisible(true);
    }//GEN-LAST:event_comp_reg_miActionPerformed

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
            java.util.logging.Logger.getLogger(consumer_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consumer_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consumer_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consumer_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consumer_dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cal_bill_mi;
    private javax.swing.JMenuItem comp_reg_mi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem logout_mi;
    private javax.swing.JMenu ons_service;
    private javax.swing.JMenuItem pay_bill_mi;
    // End of variables declaration//GEN-END:variables
}
