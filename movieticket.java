/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author omark
 */
public class movieticket extends javax.swing.JFrame {

    /**
     * Creates new form movieticket
     */
    public movieticket() {
        initComponents();
    }

    
     DefaultTableModel model = new DefaultTableModel();
    
     Connection con;
     PreparedStatement ps1;
     PreparedStatement ps2;
     /**
      * This method is called from within the constructor to initialize the form.
      * WARNING: Do NOT modify this code. The content of this method is always
      * regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated
     // Code">//GEN-BEGIN:initComponents
     private void initComponents() {

         jPanel1 = new javax.swing.JPanel();
         jLabel1 = new javax.swing.JLabel();
         jPanel2 = new javax.swing.JPanel();
         chk1 = new javax.swing.JCheckBox();
         chk2 = new javax.swing.JCheckBox();
         chk3 = new javax.swing.JCheckBox();
         chk4 = new javax.swing.JCheckBox();
         txtodc = new javax.swing.JSpinner();
         txtbalcony = new javax.swing.JSpinner();
         txtbox = new javax.swing.JSpinner();
         txtsbalcony = new javax.swing.JSpinner();
         jButton1 = new javax.swing.JButton();
         jButton2 = new javax.swing.JButton();
         jScrollPane1 = new javax.swing.JScrollPane();
         jTable1 = new javax.swing.JTable();
         jLabel2 = new javax.swing.JLabel();
         jLabel3 = new javax.swing.JLabel();
         jLabel4 = new javax.swing.JLabel();
         txtsub = new javax.swing.JTextField();
         txtbal = new javax.swing.JTextField();
         txtpay = new javax.swing.JTextField();

         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         jPanel1.setBackground(new java.awt.Color(51, 51, 255));

         jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
         jLabel1.setForeground(new java.awt.Color(255, 255, 255));
         jLabel1.setText("Movie Ticket Booking");

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                         jPanel1Layout.createSequentialGroup()
                                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addComponent(jLabel1).addGap(194, 194, 194)));
         jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(jPanel1Layout.createSequentialGroup().addGap(49, 49, 49).addComponent(jLabel1)
                         .addContainerGap(52, Short.MAX_VALUE)));

         jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(0));

         chk1.setText("ODC");

         chk2.setText("Balcony");

         chk3.setText("Box");

         chk4.setText("Super Balcony");

         javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
         jPanel2.setLayout(jPanel2Layout);
         jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addComponent(chk1).addComponent(chk2).addComponent(chk3).addComponent(chk4))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                 .addComponent(txtbalcony, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                 .addComponent(txtodc).addComponent(txtbox).addComponent(txtsbalcony))
                         .addContainerGap(36, Short.MAX_VALUE)));
         jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(jPanel2Layout.createSequentialGroup().addGap(19, 19, 19)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(chk1).addComponent(txtodc, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(33, 33, 33)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(chk2).addComponent(txtbalcony, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(36, 36, 36)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(chk3).addComponent(txtbox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(35, 35, 35)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(chk4).addComponent(txtsbalcony, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addContainerGap(22, Short.MAX_VALUE)));

         jButton1.setText("ADD");
         jButton1.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton1ActionPerformed(evt);
             }
         });

         jButton2.setText("Print Invoice ");
         jButton2.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton2ActionPerformed(evt);
             }
         });

         jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

         }, new String[] { "SeatType", "Price", "Qty", "Total" }));
         jScrollPane1.setViewportView(jTable1);

         jLabel2.setText("Subtotal");

         jLabel3.setText("Balance");

         jLabel4.setText("Pay");

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                         Short.MAX_VALUE)
                 .addGroup(layout.createSequentialGroup().addGroup(layout
                         .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup().addGap(24, 24, 24)
                                 .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup().addGap(46, 46, 46).addComponent(jButton1)
                                 .addGap(52, 52, 52)
                                 .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
                                         javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(91, 91, 91)
                                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(
                                                 layout.createSequentialGroup().addComponent(jLabel3).addGap(18, 18, 18)
                                                         .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                         .addGroup(
                                                 layout.createSequentialGroup().addComponent(jLabel2).addGap(18, 18, 18)
                                                         .addComponent(txtsub, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                         .addGap(31, 31, 31).addComponent(jLabel4).addGap(18, 18, 18)
                                                         .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                         .addContainerGap(19, Short.MAX_VALUE)));
         layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                 javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259,
                                         javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(jLabel2).addComponent(jLabel4)
                                 .addComponent(txtsub, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(
                                         txtpay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                         javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                         .addGroup(layout.createSequentialGroup().addGroup(layout
                                                 .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                         javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                         javax.swing.GroupLayout.PREFERRED_SIZE))
                                                 .addGap(41, 41, 41))
                                         .addGroup(layout.createSequentialGroup().addGroup(
                                                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                         .addComponent(jLabel3).addComponent(txtbal,
                                                                 javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                 javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                 javax.swing.GroupLayout.PREFERRED_SIZE))
                                                 .addGap(44, 44, 44)))));

         pack();
         setLocationRelativeTo(null);
     }// </editor-fold>//GEN-END:initComponents

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
         int sub = Integer.parseInt(txtsub.getText());
         int pay = Integer.parseInt(txtpay.getText());
         int bal = pay - sub;
         txtbal.setText(String.valueOf(bal));

         sales();
     }// GEN-LAST:event_jButton2ActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
         int sum = 0;
         int price;
         int tot;
         int qty;

         if (chk1.isSelected()) {
             String odc = chk1.getText();
             price = 300;
             qty = Integer.parseInt(txtodc.getValue().toString());
             tot = price * qty;
             model = (DefaultTableModel) jTable1.getModel();
             model.addRow(new Object[] {

                     odc, price, qty, tot });
         }

         if (chk2.isSelected()) {
             String Balcony = chk2.getText();
             price = 350;
             qty = Integer.parseInt(txtbalcony.getValue().toString());
             tot = price * qty;
             model = (DefaultTableModel) jTable1.getModel();
             model.addRow(new Object[] {

                     Balcony, price, qty, tot });
         }

         if (chk3.isSelected()) {
             String Box = chk3.getText();
             price = 400;
             qty = Integer.parseInt(txtbox.getValue().toString());
             tot = price * qty;
             model = (DefaultTableModel) jTable1.getModel();
             model.addRow(new Object[] {

                     Box, price, qty, tot });
         }

         if (chk4.isSelected()) {
             String Superbal = chk4.getText();
             price = 500;
             qty = Integer.parseInt(txtsbalcony.getValue().toString());
             tot = price * qty;
             model = (DefaultTableModel) jTable1.getModel();
             model.addRow(new Object[] {

                     Superbal, price, qty, tot });
         }

         for (int i = 0; i < jTable1.getRowCount(); i++) {

             sum = sum + Integer.parseInt(jTable1.getValueAt(i, 3).toString());

         }

         txtsub.setText(String.valueOf(sum));
     }// GEN-LAST:event_jButton1ActionPerformed

     public void sales() {
         String subtotal = txtsub.getText();
         String pay = txtpay.getText();
         String tot = txtbal.getText();

         int lastid = 0;
         try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/movieticket", "root", "");
             String query = "insert into sales(subtotal,pay,balance)values(?,?,?)";
             ps1 = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

             ps1.setString(1, subtotal);
             ps1.setString(2, pay);
             ps1.setString(3, tot);
             ps1.executeUpdate();

             ResultSet rs = ps1.getGeneratedKeys();

             if (rs.next()) {
                 lastid = rs.getInt(1);

             }

             int rows = jTable1.getRowCount();
             String query1 = "insert into sales_product(sales_id,tickettype,qty,price,total)values(?,?,?,?,?)";

             ps2 = con.prepareStatement(query1);

             String tickettype = "";
             int price;
             int qty;
             int total = 0;

             for (int i = 0; i < jTable1.getRowCount(); i++) {

                 tickettype = (String) jTable1.getValueAt(i, 0);
                 price = (int) jTable1.getValueAt(i, 1);
                 qty = (int) jTable1.getValueAt(i, 2);
                 total = (int) jTable1.getValueAt(i, 3);

                 ps2.setInt(1, lastid);
                 ps2.setString(2, tickettype);
                 ps2.setInt(3, qty);
                 ps2.setInt(4, price);
                 ps2.setInt(5, total);
                 ps2.executeUpdate();
             }

             JOptionPane.showMessageDialog(this, "Sales Completeeee");

         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(movieticket.class.getName()).log(Level.SEVERE, null, ex);
         }

     }

     /**
      * @param args the command line arguments
      */
     public static void main(String args[]) {
         /* Set the Nimbus look and feel */
         // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
         // (optional) ">
         /*
          * If Nimbus (introduced in Java SE 6) is not available, stay with the default
          * look and feel. For details see
          * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
          */

        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(movieticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(movieticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(movieticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(movieticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new movieticket().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chk1;
    private javax.swing.JCheckBox chk2;
    private javax.swing.JCheckBox chk3;
    private javax.swing.JCheckBox chk4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtbal;
    private javax.swing.JSpinner txtbalcony;
    private javax.swing.JSpinner txtbox;
    private javax.swing.JSpinner txtodc;
    private javax.swing.JTextField txtpay;
    private javax.swing.JSpinner txtsbalcony;
    private javax.swing.JTextField txtsub;
    // End of variables declaration//GEN-END:variables
}
