/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_module;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author SHREYASI
 */
public class Complaint_reg extends javax.swing.JFrame {
    Connection con; //object for connection 
    PreparedStatement pst6,pst7,pst8,pst9; //object for sql query
    DefaultTableModel dtm;
    ResultSet rs;

    /**
     * Creates new form Complaint_reg
     */
    public Complaint_reg() {
        try
        {
            initComponents();
            setVisible(true);
            Class.forName("org.apache.derby.jdbc.ClientDriver"); 
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/EBS_DB","EBS04","EBS04");
            JOptionPane.showMessageDialog(null,"DataBase Connected");
        }   
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(cons_details.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(cons_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comp_details_t = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        comp_f = new javax.swing.JTextArea();
        issue_solved_b = new javax.swing.JButton();
        not_solved_b = new javax.swing.JButton();
        back_b3 = new javax.swing.JButton();
        show_rec_b1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comp_no_f = new javax.swing.JTextField();
        name_f = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Complaint Register");

        comp_details_t.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        comp_details_t.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "complaint_no", "Date", "Cust_id", "Name", "Address", "Complaint", "Status"
            }
        ));
        comp_details_t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comp_details_tMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(comp_details_t);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Complaint");

        comp_f.setColumns(20);
        comp_f.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comp_f.setRows(5);
        jScrollPane2.setViewportView(comp_f);

        issue_solved_b.setBackground(new java.awt.Color(255, 153, 0));
        issue_solved_b.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        issue_solved_b.setForeground(new java.awt.Color(0, 51, 51));
        issue_solved_b.setText("Issue solved");
        issue_solved_b.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        issue_solved_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issue_solved_bActionPerformed(evt);
            }
        });

        not_solved_b.setBackground(new java.awt.Color(255, 153, 0));
        not_solved_b.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        not_solved_b.setForeground(new java.awt.Color(0, 51, 51));
        not_solved_b.setText("Not solved");
        not_solved_b.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        not_solved_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                not_solved_bActionPerformed(evt);
            }
        });

        back_b3.setBackground(new java.awt.Color(255, 153, 0));
        back_b3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        back_b3.setForeground(new java.awt.Color(0, 51, 51));
        back_b3.setText("Back");
        back_b3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back_b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_b3ActionPerformed(evt);
            }
        });

        show_rec_b1.setBackground(new java.awt.Color(255, 153, 0));
        show_rec_b1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        show_rec_b1.setForeground(new java.awt.Color(0, 51, 51));
        show_rec_b1.setText("Show Record");
        show_rec_b1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        show_rec_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_rec_b1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Complaint No.");

        comp_no_f.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        name_f.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(show_rec_b1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(issue_solved_b, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(not_solved_b, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(back_b3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comp_no_f, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_f, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comp_no_f, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_f, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(show_rec_b1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(issue_solved_b, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(not_solved_b, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back_b3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void issue_solved_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issue_solved_bActionPerformed
        // TODO add your handling code here:
        int i = comp_details_t.getSelectedRow();
        try
        {
            int r;
            dtm = (DefaultTableModel)comp_details_t.getModel();
            r = Integer.parseInt(dtm.getValueAt(i,0).toString());
            pst8=con.prepareStatement("update CUST_COMPLAINT_REG set status='Issue Solved' where complaint_no=?");
            pst8.setString(1,comp_no_f.getText());
            int r1=pst8.executeUpdate();
            if(r1>=1)
            {
                JOptionPane.showMessageDialog(this, "Record Updated Successfully");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        } 
    }//GEN-LAST:event_issue_solved_bActionPerformed

    private void back_b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_b3ActionPerformed
        // TODO add your handling code here:
        Admin_dashboard adb3 = new Admin_dashboard();
        adb3.setVisible(true);   
    }//GEN-LAST:event_back_b3ActionPerformed

    private void show_rec_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_rec_b1ActionPerformed
        // TODO add your handling code here:
        try 
        {
            pst6=con.prepareStatement("select * from CUST_COMPLAINT_REG",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = pst6.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cols = rsmd.getColumnCount();
            String colname[] = new String[cols];
            for(int i = 1; i <= cols; i++)
            {
                colname[i-1] = rsmd.getColumnName(i); 
            }
            int rows = 0;
            while(rs.next())
            {
                rows++;
            }
            String data[][]=new String[rows][cols];
            rs.beforeFirst();
            rows=0;
            while(rs.next())
            {
                for(int i=1;i<=cols;i++)
                {
                    data[rows][i-1]=rs.getString(i);
                }
                rows++;
                DefaultTableModel dtm = new DefaultTableModel(data,colname);
                comp_details_t.setModel(dtm);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_show_rec_b1ActionPerformed

    private void comp_details_tMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comp_details_tMouseClicked
        // TODO add your handling code here:
        int i = comp_details_t.getSelectedRow(); 
        try
        {
            dtm=(DefaultTableModel)comp_details_t.getModel();
            pst7=con.prepareStatement("select * from CUST_COMPLAINT_REG where complaint_no=?");
            pst7.setString(1,comp_no_f.getText());
            comp_no_f.setText(dtm.getValueAt(i,0).toString());
            name_f.setText(dtm.getValueAt(i,1).toString().trim());
            comp_f.setText(dtm.getValueAt(i,5).toString().trim());
            //pincode_f1.setText(dtm.getValueAt(i,3).toString());
            //mobile_no_f1.setText(dtm.getValueAt(i,4).toString());
            //email_f1.setText(dtm.getValueAt(i,5).toString());
            //meter_no_f1.setText(dtm.getValueAt(i,6).toString());
            //metertype_f1.setText(dtm.getValueAt(i,7).toString());
            //s_dep_f1.setText(dtm.getValueAt(i,8).toString());
            //dep_date_f1.setText(dtm.getValueAt(i,9).toString());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_comp_details_tMouseClicked

    private void not_solved_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_not_solved_bActionPerformed
        // TODO add your handling code here:
        int i = comp_details_t.getSelectedRow();
        try
        {
            int r;
            dtm = (DefaultTableModel)comp_details_t.getModel();
            r = Integer.parseInt(dtm.getValueAt(i,0).toString());
            pst9=con.prepareStatement("update CUST_COMPLAINT_REG set status='Pending' where complaint_no=?");
            pst9.setString(1,comp_no_f.getText());
            int r2 = pst9.executeUpdate();
            if(r2 >= 1)
            {
                JOptionPane.showMessageDialog(this, "Record Updated Successfully");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_not_solved_bActionPerformed

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
            java.util.logging.Logger.getLogger(Complaint_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Complaint_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Complaint_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Complaint_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Complaint_reg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_b3;
    private javax.swing.JTable comp_details_t;
    private javax.swing.JTextArea comp_f;
    private javax.swing.JTextField comp_no_f;
    private javax.swing.JButton issue_solved_b;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name_f;
    private javax.swing.JButton not_solved_b;
    private javax.swing.JButton show_rec_b1;
    // End of variables declaration//GEN-END:variables
}
