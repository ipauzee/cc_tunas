/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Add_note.java
 *
 * Created on Mar 17, 2010, 7:55:54 PM
 */

package cc_tunas;

import java.sql.ResultSet;
import javax.sun.database.JavaConnector;
import java.sql.Connection;
import java.awt.Event.*;
import java.sql.SQLException;
/**
 *
 * @author jsm
 */
public class Add_note extends javax.swing.JFrame {

        public static int status=0;
    private int asdep;
    private String solution;

    /** Creates new form Add_note */
    public Add_note() {
        initComponents();
    }

    private History Hic;
    public Add_note(History hic){
        this();
        this.Hic=hic;
    }
    public static ContactCenterTunas CCanj;
    public Add_note(ContactCenterTunas ccanj){
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtinfo = new javax.swing.JTextArea();
        btnsave = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADD NOTE");
        setResizable(false);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        txtinfo.setColumns(20);
        txtinfo.setLineWrap(true);
        txtinfo.setRows(5);
        jScrollPane2.setViewportView(txtinfo);

        btnsave.setText("Add note");
        btnsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsaveMouseClicked(evt);
            }
        });

        btnexit.setText("Exit");
        btnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnexit)
                    .addComponent(btnsave))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsaveMouseClicked
        // TODO add your handling code here:
        stt();
        if (txtinfo.getText().equals("")){
        }else{
            if (status==0 && asdep==0){
                System.out.print("\n status = "+status);
                System.out.print("\n asdep = "+asdep);
                sql1="update tickets set _status=1, process_date='"+Hic.opdt+"', process_time='"+Hic.optm+"', process_username='"+CCanj.lbluser.getText()+"' where ticket_id='"+Hic.no+"' and ticket_no='"+Hic.ticid+"'";
                CCanj.jconn.SQLExecute(sql1,CCanj.conn);
                System.out.print(sql1);
                status=1;
            }
//            System.out.print("\ndebug dalam add note \n");
//            System.out.print("\ndebug isi log date ="+Hic.opdt+" \n");
//            System.out.print("\ndebug isi log time ="+Hic.optm+" \n");
//            System.out.print("\ndebug isi user ="+CCanj.lbluser.getText()+" \n");
//            System.out.print("\ndebug isi level ="+Hic.usrlvl+" \n");
//            System.out.print("\ndebug isi tic id ="+Hic.no+" \n");
            sql="insert into log_tickets (log_date,log_time,username,user_level,ticket_id,ticket_no,info,_status) values ('"+Hic.opdt+"','"+Hic.optm+"','"+CCanj.lbluser.getText()+"','"+Hic.usrlvl+"','"+Hic.no+"','"+Hic.ticid+"','"+txtinfo.getText()+"','"+status+"')";
            CCanj.jconn.SQLExecute(sql,CCanj.conn);
            try{
                sql2="select note from tickets where ticket_id='"+Hic.ticid+"'";
                rs = CCanj.jconn.SQLExecuteRS(sql2, CCanj.conn);
                while(rs.next()){
                    solution=rs.getString(1);
                }
            }catch(Exception exc){
                System.err.println(exc.getMessage());
            }
            sql3="update tickets set note='note by : "+CCanj.lbluser.getText()+"@"+Hic.opdt.substring(8, 10) + "/" + Hic.opdt.substring(5, 7) + "/" + Hic.opdt.substring(0, 4)+"\n"+Hic.optm.replaceAll(":",".")+"\n\n"+txtinfo.getText()+"\n\n"+solution+" where ticket_id='"+Hic.no+"'";
            CCanj.jconn.SQLExecute(sql3,CCanj.conn);
            sql1="update notify set _read=0 where ticket_id="+Hic.ticid+" ";
            CCanj.jconn.SQLExecute(sql1,CCanj.conn);
//            System.out.print("\ndebug dalam add note abis execute \n");
//            System.out.print(sql);
            Hic.klik2();
            dispose();
        }
}//GEN-LAST:event_btnsaveMouseClicked

    private void btnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseClicked
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_btnexitMouseClicked

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
                new Add_note().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsave;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtinfo;
    // End of variables declaration//GEN-END:variables

    public static String sql;
    public static String sql1;
    public static String sql2;
    public static String sql3;
    public static ResultSet rs;
//    public static JavaConnector jconn=new JavaConnector();
//    public static Connection conn;

    private void stt(){
                try{
                    sql="select _status, assign_dept from tickets where ticket_id='"+Hic.no+"' and ticket_no='"+Hic.ticid+"'";
                    rs=CCanj.jconn.SQLExecuteRS(sql, CCanj.conn);
                    System.out.print(sql);
                    while(rs.next()){
                        status=Integer.parseInt(rs.getString(1));
                        asdep=Integer.parseInt(rs.getString(2));

                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
}
