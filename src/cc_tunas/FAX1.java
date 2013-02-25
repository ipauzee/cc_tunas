/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FAX1.java
 *
 * Created on Apr 18, 2010, 11:54:51 AM
 */

package cc_tunas;

import java.awt.*;
import java.awt.event.*;
import java.awt.Event.*;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.sql.Connection;
import javax.sun.database.JavaConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jsm
 */
public class FAX1 extends javax.swing.JFrame {
    String s;
    String nmfile;
    String fullnmfile;
    public static int id;
    public static int status;
    public static int asdep;
    public static String usrlvl;
    public static boolean faxtic = false;
   
   Timer receiv;
    /** Creates new form FAX1 */
    public FAX1() {
        initComponents();
        receiv=new Timer(10, testing);
        receiv.start();
        usrlvl();
    }

    private ContactCenterTunas CCanj;
    public FAX1(ContactCenterTunas ccanj){
        this();
        this.CCanj=ccanj;
    }
    private ticket Tic;
    public FAX1(ticket tic){
        this();
        this.Tic=tic;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnopen = new javax.swing.JButton();
        btnupload = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtcto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnotic = new javax.swing.JTextField();
        btnsrchcus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FAX");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        btnopen.setFont(new java.awt.Font("Calibri", 0, 12));
        btnopen.setText("OPEN");
        btnopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopenActionPerformed(evt);
            }
        });
        jPanel1.add(btnopen);
        btnopen.setBounds(10, 50, 100, 24);

        btnupload.setFont(new java.awt.Font("Calibri", 0, 12));
        btnupload.setText("Upload");
        btnupload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadActionPerformed(evt);
            }
        });
        jPanel1.add(btnupload);
        btnupload.setBounds(140, 50, 100, 24);

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 12));
        jLabel15.setText("To :");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 10, 60, 20);

        txtcto.setFont(new java.awt.Font("Calibri", 0, 12));
        txtcto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtctoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcto);
        txtcto.setBounds(70, 10, 170, 24);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ticket No.");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 30, 70, 20);

        txtnotic.setFont(new java.awt.Font("Calibri", 0, 12));
        jPanel1.add(txtnotic);
        txtnotic.setBounds(70, 30, 150, 24);

        btnsrchcus.setFont(new java.awt.Font("Calibri", 0, 12));
        btnsrchcus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1245117595_001_37.png"))); // NOI18N
        btnsrchcus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsrchcusMouseClicked(evt);
            }
        });
        jPanel1.add(btnsrchcus);
        btnsrchcus.setBounds(220, 30, 20, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopenActionPerformed
        // TODO add your handling code here:
        CCanj.s = "DOWNLOAD|fax|WorkingSheetOrder.doc|192.168.0.48|anj_fax\r\n";
        CCanj.kirimUplo();
    }//GEN-LAST:event_btnopenActionPerformed

    private void btnuploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser("");
        if (chooser.showOpenDialog(this) == JFileChooser.OPEN_DIALOG) {
            try {
                nmfile=(chooser.getSelectedFile().getName().toString());
                System.out.print("\nnamafile: " + nmfile + "\n");
                fullnmfile=(chooser.getSelectedFile().getAbsolutePath());
                CCanj.s = "UPLOAD|FAX|"+fullnmfile+"|192.168.0.48|anj_fax\r\n";
                CCanj.kirimUplo();
              } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnuploadActionPerformed

    private void txtctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtctoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtctoActionPerformed

    private void btnsrchcusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsrchcusMouseClicked
        // TODO add your handling code here:
        Search_ticket st = new Search_ticket();
        st.setVisible(true);
}//GEN-LAST:event_btnsrchcusMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
//        try {
//            conn.close();
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
    }//GEN-LAST:event_formWindowClosed

    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAX1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnopen;
    private javax.swing.JButton btnsrchcus;
    private javax.swing.JButton btnupload;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtcto;
    public static javax.swing.JTextField txtnotic;
    // End of variables declaration//GEN-END:variables

    public static String sql;
    public static String sql1;
    public static ResultSet rs;
//    public static JavaConnector jconn=new JavaConnector();
//    public static Connection conn;
    public static String opdt;
    public static String optm;

    
     Action testing = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String load;
                try {
                    if (CCanj.inupload.ready()) {
                        load = CCanj.inupload.readLine();
                        System.out.print("\nframe: " + load + "\n");
                        if(load.equals(fullnmfile+"|UPLOADED")) {
                            sql = "insert into log_fax (recipient,username,doc_name,sent_time,_direction,ticket_id) values ('"+txtcto.getText()+"','"+CCanj.lbluser.getText() +"','"+nmfile+"',CURRENT_TIMESTAMP,1,'"+id+"')";
                            CCanj.jconn.SQLExecute(sql, CCanj.conn);
//                            connectbroad();
                            CCanj.s = "FAX|OUTBOUND\r\n";
                            CCanj.kirimUplo();

                            if (faxtic == true) {
                                opdt();
                                optm();
                                stt();
                                if (status == 0 && asdep == 0) {
                                    sql = "update tickets set _status=1, process_date='" + opdt + "', process_time='" + optm + "', process_username='" + CCanj.lbluser.getText() + "' where ticket_id='" + Tic.id + "' and ticket_no='" + txtnotic.getText() + "'";
                                    CCanj.jconn.SQLExecute(sql, CCanj.conn);
                                    status = 1;
                                }
                                sql1 = "insert into log_tickets (log_date,log_time,username,user_level,ticket_id,_status,info,ticket_no) values ('" + opdt + "','" + optm + "','" + CCanj.lbluser.getText() + "','" + usrlvl + "','" + Tic.id + "','" + status + "','Outgoing Fax \nTo : " + txtcto.getText() + " \n\n File name  :" + nmfile + "','" + txtnotic.getText() + "')";
                                CCanj.jconn.SQLExecute(sql1, CCanj.conn);
                                System.out.print(sql1);
                            }
                            faxtic = false;
                            JOptionPane.showMessageDialog(null,"FAX SENT","FAX",JOptionPane.WARNING_MESSAGE);
                            dispose();
                            receiv.stop();
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ContactCenterTunas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       };


    private void opdt(){
          try{
              sql="select CURRENT_DATE";
              rs = CCanj.jconn.SQLExecuteRS(sql, CCanj.conn);
              while(rs.next()){
                  opdt=rs.getString(1);
              }
          }catch(Exception exc){
              System.err.println(exc.getMessage());
          }
    }

        private void optm(){
            try{
              sql="select CURRENT_TIME";
              rs = CCanj.jconn.SQLExecuteRS(sql, CCanj.conn);
              while(rs.next()){
                  optm=rs.getString(1);
              }
          }catch(Exception exc){
              System.err.println(exc.getMessage());
          }
        }
        private void usrlvl(){
                try{
                    sql="select _level from user_account where username='"+CCanj.lbluser.getText()+"'";
                    rs=CCanj.jconn.SQLExecuteRS(sql, CCanj.conn);
                    while(rs.next()){
                        usrlvl=rs.getString(1);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
        private void stt(){
                try{
                    sql="select _status, assign_dept from tickets where ticket_id='"+Tic.id+"' and ticket_no='"+txtnotic.getText()+"'";
                    rs=CCanj.jconn.SQLExecuteRS(sql, CCanj.conn);
                    while(rs.next()){
                        status=Integer.parseInt(rs.getString(1));
                        asdep=Integer.parseInt(rs.getString(2));
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
}
