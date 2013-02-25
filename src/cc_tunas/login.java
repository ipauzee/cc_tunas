/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * login.java
 *
 * Created on Feb 15, 2010, 9:26:47 AM
 */

package cc_tunas;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.sql.*;
import javax.sun.database.JavaConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.net.*;
import java.util.GregorianCalendar;
import javax.swing.UIManager.LookAndFeelInfo;
//import javax.swing.UIManager.*;

/**
 *
 * @author jsm
 */
public class login extends javax.swing.JFrame {
    public static String[] data = new String[6];
    int acti;
    public static int shift=0;
    public static int deptid;
    public String ld;
    public final static int Loc=0,Dev=1,Pro=2;
    public static int version=Pro;

    public static String deptnm="",ftpuser,ftpserver,ftpuserRec,ftpserverRec;
    /** Creates new form login */
    public login() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        initComponents();
        
        version=Pro;setKoneksi();
        if(version==Loc){
//            setTitle("CONTACT CENTER KONICA MINOLTA");
//            lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/konica_minolta_logo_clear.gif")));
        }
        //this.setSize(1024,768);
        this.setExtendedState(JFrame.MAXIMIZED_HORIZ);
        txtnm.requestFocus();
        showShift();
    }

    public static void setKoneksi(){
        switch (version) {
            case Loc:
                conn=(Connection) jconn.ConnectToMySQL("localhost","cc_tunas","root","");
                break;

            case Dev:
                conn=(Connection) jconn.ConnectToMySQL("192.168.0.88","cc_tunas","root","j@r1ng");
                ftpuser="anj_mail";
                ftpserver="192.168.0.48";
                ftpuserRec="anj";
                ftpserverRec="192.168.0.6";
                break;
            case Pro:
                conn=(Connection) jconn.ConnectToMySQL("192.168.0.70","cc_tunas?useUnicode=true&characterEncoding=utf8","cc_tunas","");
                ftpuser="tunas_mail";
                ftpserver="192.168.0.68";
                ftpuserRec="tunas";
                ftpserverRec="192.168.0.62";
                break;
        }
    }

    private ContactCenterTunas CCanj;
    public login(ContactCenterTunas ccanj){
        this();
        this.CCanj=ccanj;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdp = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblnm = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbshift = new javax.swing.JComboBox();
        txtpass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        btnlogin = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lbllogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Contact Center Tunas Rental");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jdp.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setForeground(new java.awt.Color(255, 204, 102));
        jPanel1.setLayout(null);

        lblnm.setFont(new java.awt.Font("Calibri", 0, 12));
        lblnm.setText("Username"); // NOI18N
        jPanel1.add(lblnm);
        lblnm.setBounds(40, 20, 70, 20);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12));
        jLabel2.setText("Password"); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 50, 70, 20);

        txtnm.setFont(txtnm.getFont().deriveFont((float)11));
        txtnm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnmKeyPressed(evt);
            }
        });
        jPanel1.add(txtnm);
        txtnm.setBounds(110, 20, 160, 24);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12));
        jLabel3.setText("Shift"); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 80, 25, 20);

        cbshift.setFont(cbshift.getFont().deriveFont((float)11));
        cbshift.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbshift.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbshiftKeyPressed(evt);
            }
        });
        jPanel1.add(cbshift);
        cbshift.setBounds(110, 80, 160, 24);

        txtpass.setFont(txtpass.getFont().deriveFont((float)11));
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });
        jPanel1.add(txtpass);
        txtpass.setBounds(110, 50, 160, 24);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(340, 220, 310, 130);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        btnlogin.setFont(btnlogin.getFont().deriveFont(btnlogin.getFont().getStyle() | java.awt.Font.BOLD, 11));
        btnlogin.setText("Login"); // NOI18N
        btnlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnloginMouseClicked(evt);
            }
        });
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        btnlogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnloginKeyPressed(evt);
            }
        });
        jPanel2.add(btnlogin);
        btnlogin.setBounds(20, 10, 80, 25);

        btnexit.setFont(btnexit.getFont().deriveFont(btnexit.getFont().getStyle() | java.awt.Font.BOLD, 11));
        btnexit.setText("Exit"); // NOI18N
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jPanel2.add(btnexit);
        btnexit.setBounds(130, 10, 80, 25);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(380, 370, 230, 50);

        lbllogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TUNAS Rental_High Res Logo1.png"))); // NOI18N
        jPanel3.add(lbllogo);
        lbllogo.setBounds(10, 0, 1010, 220);

        jPanel3.setBounds(0, 0, 1024, 720);
        jdp.add(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdp, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdp, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void txtnmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnmKeyPressed
        // TODO add your handling code here:
        int ke=evt.getKeyCode();
        if(ke==10){
            if(txtnm.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Username cannot be empty","WARNING !!!",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                txtpass.requestFocus();
            }
        }
    }//GEN-LAST:event_txtnmKeyPressed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
        int ke=evt.getKeyCode();
        if(ke==10){
            if(txtpass.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Password cannot be empty","WARNING !!!",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                cbshift.requestFocus();
//                inputValid();
            }
        }
    }//GEN-LAST:event_txtpassKeyPressed

    private void cbshiftKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbshiftKeyPressed
        // TODO add your handling code here:
        int ke=evt.getKeyCode();
        if(ke==10){
            if(cbshift.getSelectedItem().equals("--"))
            {
                JOptionPane.showMessageDialog(null, "Shift Cannot be empty","WARNING !!!",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                btnloginKeyPressed(evt);
            }
        }
    }//GEN-LAST:event_cbshiftKeyPressed

    private void btnloginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnloginKeyPressed
        // TODO add your handling code here:
        inputValid();
        if (cbshift.getSelectedItem().equals("PAGI")){
            shift=1;
        }else if (cbshift.getSelectedItem().equals("SIANG")){
            shift=2;
        }else if (cbshift.getSelectedItem().equals("MALAM")){
            shift=3;
        }
    }//GEN-LAST:event_btnloginKeyPressed

    private void btnloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnloginMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnloginMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        try {
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        inputValid();
        if (cbshift.getSelectedItem().equals("PAGI")){
            shift=1;
        }else if (cbshift.getSelectedItem().equals("SIANG")){
            shift=2;
        }else if (cbshift.getSelectedItem().equals("MALAM")){
            shift=3;
        }
    }//GEN-LAST:event_btnloginActionPerformed

      public boolean inputValid(){
          boolean result = false;
        try {
            sql = "select username from user_account where username = '" + txtnm.getText() + "'";
            rs = jconn.SQLExecuteRS(sql, conn);
//            System.out.println(sql);
            while(rs.next()){
                data[0]=rs.getString(1);
                //data[1]=rs.getString(2);
            }
//            System.out.println(data[0]);
            int row=0;
            sql1="select password, _activity, host_addr, dept_id from user_account where password = md5('"+txtpass.getText()+"') and username= '" + txtnm.getText() + "'";
            rs = jconn.SQLExecuteRS(sql1, conn);
//            System.out.println(sql1);
            while(rs.next()){
                data[1]=rs.getString(1);
                acti=Integer.parseInt(rs.getString(2));
                data[5]=rs.getString(3);
                deptid=Integer.parseInt(rs.getString(4));
                row++;
            }
//            System.out.println(data[1]);
            sql2="select substring(user(),position('@' in user())+1)";
            host = jconn.SQLExecuteRS(sql2, conn);
//            System.out.println(sql2);
            while(host.next()){
                data[2]=host.getString(1);
            }
//            System.out.println(data[2]);
            sql3="select CURRENT_TIMESTAMP";
            rs = jconn.SQLExecuteRS(sql3, conn);
//            System.out.println(sql3);
            while(rs.next()){
                data[3]=rs.getString(1);
            }
//            System.out.println(data[3]);
            if ((txtnm.getText().equals("")) || (txtpass.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Fill data first");
                result = false;
            } else if (txtnm.getText().equals(data[0])) {
//                System.out.println(data[0]);
                result = false;
                    if (row>0) {
                        if (cbshift.getSelectedItem().equals("--")){
                            JOptionPane.showMessageDialog(null, "Shift can't be empty !!");
                        }else{
                            if(acti==1){
                                if(data[2].equals(data[5])){
                                    sql="update user_account set _status=1,_activity=1,host_addr='"+data[2]+"',login_time='"+data[3]+"',last_login='"+data[3]+"'where password = md5('"+txtpass.getText()+"')and username= '" + txtnm.getText() + "' limit 1";
                                    jconn.SQLExecute(sql, conn);
        //                            System.out.println(data[1]);
        //                            System.out.println(sql);

                                    ContactCenterTunas ccanj = new ContactCenterTunas();
                                    jdp.add(ccanj);
                                    ccanj.show();
                                    bersih();

                                     CCanj.lbluser.setText((String)txtnm.getText());
                                     CCanj.lblpas.setText((String)txtpass.getText());

                                    result = true;
//                                    conn.close();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Account already logged in on" + data[5]);
                                }
                            }else{                             
                            sql="update user_account set _status=1,_activity=1,host_addr='"+data[2]+"',login_time='"+data[3]+"',last_login='"+data[3]+"'where password = md5('"+txtpass.getText()+"')and username= '" + txtnm.getText() + "' limit 1";
                            jconn.SQLExecute(sql, conn);
//                            System.out.println(data[1]);
//                            System.out.println(sql);

                            ContactCenterTunas ccanj = new ContactCenterTunas();
                            jdp.add(ccanj);
                            ccanj.show();
                            bersih();

                             CCanj.lbluser.setText((String)txtnm.getText());
                             CCanj.lblpas.setText((String)txtpass.getText());

                            result = true;
//                            conn.close();
                            }
                        }
                    } else {
                    JOptionPane.showMessageDialog(null, "Password denided!!");
                    txtpass.requestFocus();txtpass.selectAll();
                    }
            }
             else {
                JOptionPane.showMessageDialog(null, "Username Invalid !!");
                result = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }                            
             
              //CCanj.lblshift.setText((String)cbshift.getSelectedItem());
            return result;
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    public static javax.swing.JButton btnlogin;
    public static javax.swing.JComboBox cbshift;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JDesktopPane jdp;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblnm;
    public static javax.swing.JTextField txtnm;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables

    private String sql;
    private String sql1;
    private String sql2;
    private String sql3;
    private String sql4;
    private ResultSet rs;
    private ResultSet host;
    public static JavaConnector jconn=new JavaConnector();
    public static Connection conn;

    private void showShift()
    {
         cbshift.removeAllItems();
         cbshift.addItem("PAGI");
         cbshift.addItem("SIANG");
         cbshift.addItem("MALAM");

         currentdate();
         h=Integer.parseInt(ld.substring(0,2));
         if(h>=6){
             if(h>=14){
                 if(h>=22){
                     cbshift.setSelectedIndex(2);
                 }else{
                     cbshift.setSelectedIndex(1);
                 }
             }else{
                 cbshift.setSelectedIndex(0);
             }
         }else{
             cbshift.setSelectedIndex(2);
         }
         
         


    }
    int h;
      private void currentdate() {

        try {
            sql4 = "select CURRENT_TIME";
            rs = jconn.SQLExecuteRS(sql4, conn);
            while (rs.next()) {
                ld = rs.getString(1);
            }
//            System.out.println(ld);
        } catch (SQLException ex) {
            Logger.getLogger(ContactCenterTunas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void bersih()
    {
        txtnm.setEnabled(false);
        txtpass.setEnabled(false);
        cbshift.setEnabled(false);
        btnlogin.setEnabled(false);
    }    
}