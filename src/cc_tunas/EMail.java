/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EMail.java
 *
 * Created on Feb 15, 2010, 5:57:31 PM
 */

package cc_tunas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
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
import java.net.*;

/**
 *
 * @author jsm
 */
public class EMail extends javax.swing.JFrame {

    String in[]=new String[12];
    String ou[]=new String[8];
    String s;
    String optm;
    String opdt;
    public static boolean mailtic = false;
    public static int id;
    int l=150;
    int p=0;
    String  nmfile, fullnmfile;

    Timer receiv;

    private String usrlvl;
    public static int status;
    public static int asdep;
    private String solution;
    /** Creates new form EMail */
    public EMail() {
        initComponents();
        setSize(747,424);
        usrlvl();
        showCaltype();showCust();
        receiv=new Timer(10, testing);
    }

    public static login Log;
    public EMail(login log){
        this();
        this.Log=log;
    }
    public static ContactCenterTunas CCanj;
    public EMail(ContactCenterTunas ccanj){
        this();
        this.CCanj=ccanj;
    }
    public static ticket Tic;
    public EMail(ticket tic){
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

        jPanel4 = new javax.swing.JPanel();
        paneloutbox = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnmsend = new javax.swing.JButton();
        btnccancc = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtcmsg = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txtccc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcsu = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtcto = new javax.swing.JTextField();
        txtnotic = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnsrchcus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbcaltype = new javax.swing.JComboBox();
        txtAttachment = new javax.swing.JTextField();
        btnsrchcus1 = new javax.swing.JButton();
        btnAttachment = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cbcust = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("COMPOSE EMAIL");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        paneloutbox.setFont(paneloutbox.getFont().deriveFont(paneloutbox.getFont().getStyle() | java.awt.Font.BOLD, 11));
        paneloutbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneloutboxMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });
        jPanel1.setLayout(null);

        btnmsend.setFont(new java.awt.Font("Calibri", 0, 11));
        btnmsend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/email sent.jpg"))); // NOI18N
        btnmsend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmsendMouseClicked(evt);
            }
        });
        jPanel1.add(btnmsend);
        btnmsend.setBounds(540, 320, 73, 50);

        btnccancc.setFont(new java.awt.Font("Calibri", 0, 11));
        btnccancc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/no.jpg"))); // NOI18N
        btnccancc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnccanccMouseClicked(evt);
            }
        });
        btnccancc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnccanccActionPerformed(evt);
            }
        });
        jPanel1.add(btnccancc);
        btnccancc.setBounds(630, 320, 73, 47);

        txtcmsg.setColumns(20);
        txtcmsg.setFont(txtcmsg.getFont().deriveFont((float)11));
        txtcmsg.setRows(5);
        jScrollPane6.setViewportView(txtcmsg);

        jPanel1.add(jScrollPane6);
        jScrollPane6.setBounds(110, 120, 600, 200);

        jLabel13.setFont(jLabel13.getFont().deriveFont((float)11));
        jLabel13.setText("Messages :");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(10, 120, 100, 20);

        txtccc.setFont(txtccc.getFont().deriveFont((float)11));
        jPanel1.add(txtccc);
        txtccc.setBounds(110, 50, 600, 25);

        jLabel10.setFont(jLabel10.getFont().deriveFont((float)11));
        jLabel10.setText("Cc :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 50, 100, 20);

        jLabel14.setFont(jLabel14.getFont().deriveFont((float)11));
        jLabel14.setText("Subject :");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(10, 30, 100, 20);

        txtcsu.setFont(txtcsu.getFont().deriveFont((float)11));
        jPanel1.add(txtcsu);
        txtcsu.setBounds(110, 30, 600, 25);

        jLabel15.setFont(jLabel15.getFont().deriveFont((float)11));
        jLabel15.setText("To :");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 10, 100, 20);

        txtcto.setFont(txtcto.getFont().deriveFont((float)11));
        txtcto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtctoCaretUpdate(evt);
            }
        });
        txtcto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtctoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcto);
        txtcto.setBounds(110, 10, 390, 25);

        txtnotic.setFont(txtnotic.getFont().deriveFont((float)11));
        jPanel1.add(txtnotic);
        txtnotic.setBounds(590, 10, 100, 24);

        jLabel5.setFont(jLabel5.getFont().deriveFont((float)11));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ticket No.");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(500, 10, 90, 20);

        btnsrchcus.setFont(new java.awt.Font("Calibri", 0, 11));
        btnsrchcus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1245117595_001_37.png"))); // NOI18N
        btnsrchcus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsrchcusMouseClicked(evt);
            }
        });
        jPanel1.add(btnsrchcus);
        btnsrchcus.setBounds(690, 10, 20, 20);

        jLabel6.setFont(jLabel6.getFont().deriveFont((float)11));
        jLabel6.setText("Attachment");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 90, 100, 20);

        cbcaltype.setFont(cbcaltype.getFont().deriveFont((float)11));
        cbcaltype.setMaximumRowCount(9);
        cbcaltype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Non-customer", "Customer-Driver", "Customer-User", "Customer-PIC", "Customer-Other", "Internal-ANJ", "Internal-CC", "Internal-CSO", "Internal-Driver", "Internal-Other" }));
        jPanel1.add(cbcaltype);
        cbcaltype.setBounds(110, 70, 200, 24);

        txtAttachment.setEditable(false);
        txtAttachment.setFont(txtAttachment.getFont().deriveFont((float)11));
        txtAttachment.setFocusable(false);
        txtAttachment.setRequestFocusEnabled(false);
        jPanel1.add(txtAttachment);
        txtAttachment.setBounds(110, 90, 470, 24);

        btnsrchcus1.setFont(new java.awt.Font("Calibri", 0, 11));
        btnsrchcus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.jpg"))); // NOI18N
        btnsrchcus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsrchcus1MouseClicked(evt);
            }
        });
        btnsrchcus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsrchcus1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnsrchcus1);
        btnsrchcus1.setBounds(580, 90, 26, 25);

        btnAttachment.setFont(btnAttachment.getFont().deriveFont(btnAttachment.getFont().getStyle() | java.awt.Font.BOLD, 11));
        btnAttachment.setText("Add Attch.");
        btnAttachment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachmentActionPerformed(evt);
            }
        });
        jPanel1.add(btnAttachment);
        btnAttachment.setBounds(610, 90, 100, 24);

        jLabel7.setFont(jLabel7.getFont().deriveFont((float)11));
        jLabel7.setText("Direction Type");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 70, 100, 20);

        jLabel36.setFont(jLabel36.getFont().deriveFont((float)11));
        jLabel36.setText("Cust. Company");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(410, 70, 100, 20);

        cbcust.setFont(cbcust.getFont().deriveFont((float)11));
        cbcust.setMaximumRowCount(9);
        cbcust.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Non-customer", "Customer-Driver", "Customer-User", "Customer-PIC", "Customer-Other", "Internal-ANJ", "Internal-CC", "Internal-CSO", "Internal-Driver", "Internal-Other" }));
        jPanel1.add(cbcust);
        cbcust.setBounds(510, 70, 200, 24);

        paneloutbox.addTab("Compose", jPanel1);

        jPanel4.add(paneloutbox);
        paneloutbox.setBounds(0, 0, 740, 410);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 750, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paneloutboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneloutboxMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_paneloutboxMouseClicked

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
       //lbldirection.setText("OutBound");
    }//GEN-LAST:event_jPanel1FocusGained

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
//        lbldirection.setText("OutBound");
    }//GEN-LAST:event_jPanel1MouseEntered

    private void btnccanccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnccanccMouseClicked
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_btnccanccMouseClicked

    private void btnccanccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnccanccActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnccanccActionPerformed

    private void btnmsendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmsendMouseClicked
        // TODO add your handling code here:
        opdt();
        optm();
        stt();
        sql="insert into log_mail (mail_date,mail_time,mail_from,mail_to,mail_cc,mail_subject,mail_text,direction,username,ticket_id,direction_type,cust_name) values (current_date,current_time,'careline.tunas@jsm.co.id','"+txtcto.getText()+"','"+txtccc.getText()+"','"+txtcsu.getText()+"','"+txtcmsg.getText()+"',1,'"+CCanj.lbluser.getText()+"','"+Tic.id+"','"+cbcaltype.getSelectedItem()+"','"+cbcust.getSelectedItem()+"')";
//        sql1="insert into log_mail (mail_from,mail_to,mail_subject,mail_text,ticket_id,direction,username) values ('contact@anjrent.com','"+txtcsomail.getText()+"','<Ticket>#"+txtcusnam.getText()+"#"+cbnoplat.getSelectedItem()+"#"+txtusr.getText()+"#"+cbcategory.getSelectedItem()+"#"+txtnotic.getText()+"','"+txtdetails.getText()+"\n\n"+txtsolution.getText()+" \n\n UPDATED','"+id+"',1,'"+CCanj.lbluser.getText()+"')";
        CCanj.jconn.SQLExecute(sql,CCanj.conn);
        sqlid="select distinct last_insert_id() from log_mail";
        rs=CCanj.jconn.SQLExecuteRS(sqlid, CCanj.conn);
        try {
            while (rs.next()) {
                id = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        CCanj.s = "MAIL|OUTBOUND\r\n";
        CCanj.kirimBroad();
        JOptionPane.showMessageDialog(null, "EMAIL SENT", "MAILING",JOptionPane.WARNING_MESSAGE);

        if(!txtAttachment.getText().equals("")){
            receiv.start();
            CCanj.s = "UPLOAD|EMAIL|"+id+"|"+fullnmfile+"|"+Log.ftpserver+"|"+Log.ftpuser+"\r\n";
            CCanj.kirimUplo();
        }

        if(mailtic==true){
            if (status==0 && asdep==0){
                sql="update tickets set _status=1, process_date='"+opdt+"', process_time='"+optm+"', process_username='"+CCanj.lbluser.getText()+"' where ticket_id='"+Tic.id+"' and ticket_no='"+txtnotic.getText()+"'";
                CCanj.jconn.SQLExecute(sql,CCanj.conn);
                status=1;
            }
            sql1="insert into log_tickets (log_date,log_time,username,user_level,ticket_id,_status,info,ticket_no) values ('"+opdt+"','"+optm+"','"+CCanj.lbluser.getText()+"','"+usrlvl+"','"+Tic.id+"','"+status+"','Outgoing Mail \nTo : "+txtcto.getText()+" \n\n "+txtcmsg.getText()+"','"+txtnotic.getText()+"')";
            CCanj.jconn.SQLExecute(sql1, CCanj.conn);
            System.out.print(sql1);
            try{
                sql2="select note from tickets where ticket_id='"+Tic.id+"'";
                rs = CCanj.jconn.SQLExecuteRS(sql2, CCanj.conn);
                while(rs.next()){
                    solution=rs.getString(1);
                }
            }catch(Exception exc){
                System.err.println(exc.getMessage());
            }
            sql3="update tickets set note='"+solution+"\n\n"+CCanj.lbluser.getText()+"@"+opdt.substring(8, 10) + "/" + opdt.substring(5, 7) + "/" + opdt.substring(0, 4)+"\n"+optm.replaceAll(":",".")+"\nOutgoing Mail \nTo : "+txtcto.getText()+" \n\n "+txtcmsg.getText()+"\n===' where ticket_id='"+Tic.id+"'";
            CCanj.jconn.SQLExecute(sql3,CCanj.conn);
        }
        mailtic=false;
    }//GEN-LAST:event_btnmsendMouseClicked

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
    }//GEN-LAST:event_formWindowClosed

    private void txtctoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtctoCaretUpdate
        // TODO add your handling code here:
        int panjang,t;
        String sms,isi;
        if(txtcto.getText().length()>=150){
            txtcto.setEditable(false);
            sms=txtcto.getText();
            isi=sms.substring(0,150);
            l=150-p;
        }else{
            txtcto.setEditable(true);
            p=txtcto.getText().length();
            l=150-p;
        }
    }//GEN-LAST:event_txtctoCaretUpdate

    private void btnsrchcus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsrchcus1MouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_btnsrchcus1MouseClicked

    private void btnsrchcus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsrchcus1ActionPerformed
        // TODO add your handling code here:
        txtAttachment.setText("");
        nmfile="";
        fullnmfile="";
}//GEN-LAST:event_btnsrchcus1ActionPerformed

    private void btnAttachmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachmentActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser("");
        if (chooser.showOpenDialog(this) == JFileChooser.OPEN_DIALOG) {
            try {
                txtAttachment.setText((chooser.getSelectedFile().getName().toString()));
                nmfile=(chooser.getSelectedFile().getName().toString());
//                nmfile=nmfile+(chooser.getSelectedFile().getName().toString());
                System.out.print("\nnamafile: " + nmfile + "\n");
                fullnmfile=(chooser.getSelectedFile().getAbsolutePath());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}//GEN-LAST:event_btnAttachmentActionPerformed
    
    int row=0;
    public void Tampil(){
//        try {
//            row = tblmou.getSelectedRow();
//            txtoto.setText(tblmou.getValueAt(row, 0).toString());
//            txtosu.setText(tblmou.getValueAt(row, 1).toString());
//            txtocc.setText(tblmou.getValueAt(row, 3).toString());
//            sql = "Select mail_text, ticket_id from log_mail where mail_to='" + txtoto.getText() + "' and mail_subject='" + txtosu.getText() + "' and mail_cc='" + txtocc.getText() + "'";
//            ResultSet rs = jconn.SQLExecuteRS(sql, conn);
//            txtomsg.setText(rs.getString(1).toString());
//            txtidti.setText(rs.getString(2).toString());
//        } catch (SQLException ex) {
//            Logger.getLogger(EMail.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    } 
     public void Tampil1(){
//        try {
//            row = tblmin.getSelectedRow();
//            txtfrom.setText(tblmou.getValueAt(row, 0).toString());
//            txtisu.setText(tblmou.getValueAt(row, 1).toString());
//            sql = "Select mail_text from log_mail where mail_from='" + txtfrom.getText() + "' and mail_subject='" + txtosu.getText() + "' and mail_cc='" + txtocc.getText() + "'";
//            ResultSet rs = jconn.SQLExecuteRS(sql, conn);
//            txtimsg.setText(rs.getString(1).toString());
//        } catch (SQLException ex) {
//            Logger.getLogger(EMail.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
//    private javax.swing.table.DefaultTableModel getDefaultTabelin(){
//        return new javax.swing.table.DefaultTableModel(
//                new Object [][]{},
//                new String [] {"From","Subject","Date","Read","Status"}){
//                boolean[] canEdit=new boolean[]{
//                    false,false,false,false,false
//                };
//                public boolean isCellEditable(int rowIndex, int columnIndex){
//                        return canEdit[columnIndex];
//                }
//        };
//    }
//      private javax.swing.table.DefaultTableModel getDefaultTabelout(){
//        return new javax.swing.table.DefaultTableModel(
//                new Object [][]{},
//                new String [] {"To","Subject","Date","Cc","Status",}){
//                boolean[] canEdit=new boolean[]{
//                    false,false,false,false,false
//                };
//                public boolean isCellEditable(int rowIndex, int columnIndex){
//                        return canEdit[columnIndex];
//                }
//        };
//    }
//

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EMail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAttachment;
    private javax.swing.JButton btnccancc;
    private javax.swing.JButton btnmsend;
    private javax.swing.JButton btnsrchcus;
    private javax.swing.JButton btnsrchcus1;
    public static javax.swing.JComboBox cbcaltype;
    public static javax.swing.JComboBox cbcust;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane paneloutbox;
    private javax.swing.JTextField txtAttachment;
    public static javax.swing.JTextField txtccc;
    public static javax.swing.JTextArea txtcmsg;
    public static javax.swing.JTextField txtcsu;
    public static javax.swing.JTextField txtcto;
    public static javax.swing.JTextField txtnotic;
    // End of variables declaration//GEN-END:variables

    private String sql, sql1, sql2, sql3, sqlid;
    private ResultSet rs,rs1;
//    private JavaConnector jconn=new JavaConnector();
//    private Connection conn;



    private void bersih()    {
        txtcto.setText("");
        txtcsu.setText("");
        txtccc.setText("");
        txtcmsg.setText("");
            //txtNim.requestFocus();
    }
    
    Action testing = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            String load,filenm1;
            try {
                if (CCanj.inupload.ready()) {
                    load = CCanj.inupload.readLine();
                    System.out.print("\nframe: " + load + "\n");
                    if(load.equals(fullnmfile+"|UPLOADED")) {
                        sql = "insert into mail_attachment (mail_id,direction,filename) values ('"+id+"',1,'c:\\\\attachments\\\\"+nmfile+"')";
                        CCanj.jconn.SQLExecute(sql, CCanj.conn);
                        receiv.stop();
                    }else{
                        JOptionPane.showMessageDialog(null, "Attachment failed", "MAILING",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }catch (IOException ex) {
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
    private void showCaltype(){
        try{
            cbcaltype.removeAllItems();
            sql="select data from _callertype";
            rs=CCanj.jconn.SQLExecuteRS(sql,CCanj.conn);
            while(rs.next()){
                cbcaltype.addItem(rs.getString(1));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    private void showCust(){
        try{
            cbcust.removeAllItems();
            cbcust.addItem("Others");

            sql="select distinct(cust_name) from customer_order order by cust_name";
            rs=CCanj.jconn.SQLExecuteRS(sql,CCanj.conn);
            while(rs.next()){
                cbcust.addItem(rs.getString(1));
            }
            cbcust.setSelectedIndex(-1);
        }catch(Exception e){
            System.out.println(e);

        }
    }
}
