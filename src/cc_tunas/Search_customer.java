/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Search_ticket.java
 *
 * Created on Feb 23, 2010, 4:31:41 PM
 */

package cc_tunas;


import javax.sun.database.JavaConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author jsm
 */
public class Search_customer extends javax.swing.JFrame {
    private static String cus[]=new String[21];
    private static String condition;
    public static int Form=0;
    /** Creates new form Search_ticket */
    public Search_customer() {
        initComponents();
        tblcus.setModel(tabcus);
        tbcus(tblcus,new int []{80,80,80,80,300,500,80,80,100,80,50,100,200,80,200,80,100,80,100,200,0});
        setLocation(0,330);
    }

    public static ContactCenterTunas CCanj;
    public Search_customer(ContactCenterTunas ccanj){
        this();
        this.CCanj=ccanj;
    }
    private ticket Tic;
    public Search_customer(ticket tic){
        this();
        this.Tic=tic;
    }
    private InBoundCall Inc;
    public Search_customer(InBoundCall inc){
        this();
        this.Inc=inc;
    }
    public Sms_income Sin;
    public Search_customer(Sms_income sin){
        this();
        this.Sin=sin;
    }
    public Email_incoming Ein;
    public Search_customer(Email_incoming ein){
        this();
        this.Ein=ein;
    }

    public static javax.swing.table.DefaultTableModel getDefaultTabelcus(){
        return new javax.swing.table.DefaultTableModel(
                new Object [][]{},
                new String [] {"Contract No.","Contract Start","Contract End","Cust. Code","Cust. Name","Address","Phone","PIC","User","User Phone","No. Plat","Type","Driver","Driver Phone","CSO","CSO Phone","CSO Mail","No. Plat GS","GS Type","GS Driver",""}){
                boolean[] canEdit=new boolean[]{
                    false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false
                };
                public boolean isCellEditable(int rowIndex, int columnIndex){
                        return canEdit[columnIndex];
                }
        };
    }
    public static javax.swing.table.DefaultTableModel tabcus=getDefaultTabelcus();
    public static void tabelcus(){
        tabcus.setRowCount(0);
        try{
            int row=0;

            sql="select * from customer_order where _deleted=0 ";
            condition="";
            if(!txtcusnm.getText().equals("")){
                condition=condition+" and cust_name like '%"+txtcusnm.getText()+"%'";
            }
            if(!txtnopl.getText().equals("")){
                condition=condition+" and vehicle_platno like '%"+txtnopl.getText()+"%'";
            }
            if(!txtdri.getText().equals("")){
                condition=condition+" and driver_name like '%"+txtdri.getText()+"%'";
            }
            if(!txtcso.getText().equals("")){
//                    if (condition.equals("")){
//                        condition=condition+" where ";
//                    }else{
//                        condition=condition+" and ";
//                    }
                condition=condition+" and cso_name like '%"+txtcso.getText()+"%'";
            }
            if(!txtplatnogs.getText().equals("")){
                condition=condition+" and gs_vehicle_platno like '%"+txtplatnogs.getText()+"%'";
            }
            if(!txtgsdriver.getText().equals("")){
                condition=condition+" and gs_driver_name like '%"+txtgsdriver.getText()+"%'";
            }
            if(!txtuser.getText().equals("")){
                condition=condition+" and user_name like '%"+txtuser.getText()+"%'";
            }

            sql=sql+condition;
            rs=CCanj.jconn.SQLExecuteRS(sql, CCanj.conn);
//            System.out.println(sql);

            while(rs.next()){
                cus[0]=rs.getString("contract_no");
                cus[1]=rs.getString("contract_startdate");
                cus[2]=rs.getString("contract_enddate");
                cus[3]=rs.getString(4);
                cus[4]=rs.getString(5);
                cus[5]=rs.getString(6);
                cus[6]=rs.getString(7);
                cus[7]=rs.getString(9);
                cus[8]=rs.getString(14);
                cus[9]=rs.getString(15);
                cus[10]=rs.getString(21);
                cus[11]=rs.getString(23);
                cus[12]=rs.getString(33);
                cus[13]=rs.getString(34);
                cus[14]=rs.getString(18);
                cus[15]=rs.getString(19);
                cus[16]=rs.getString(20);
                cus[17]=rs.getString(26);
                cus[18]=rs.getString(28);
                cus[19]=rs.getString(37);
                cus[20]=rs.getString(1);
                tabcus.addRow(cus);
                row+=1;
            }if(row==0){
                //                            JOptionPane.showMessageDialog(null,"Ticket with number ticket "+cbuser.getSelectedItem()+", categoty "+cbcategory.getSelectedItem()+", with customer "+cbcustomer.getSelectedItem()+", with driver "+cbdriver.getSelectedItem()+" dosen't exsist");
            }

        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }
    private void tbcus(javax.swing.JTable tb, int lebar[]){
        tb.setAutoResizeMode(tb.AUTO_RESIZE_OFF);
        int kolom=tb.getColumnCount();
        for (int i=0;i<kolom;i++){
            javax.swing.table.TableColumn tbc=tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(18);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcus = new javax.swing.JTable();
        btnsrch = new javax.swing.JButton();
        txtcso = new javax.swing.JTextField();
        txtcusnm = new javax.swing.JTextField();
        txtnopl = new javax.swing.JTextField();
        txtdri = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtgsdriver = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtplatnogs = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Customer");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 11));
        jPanel1.setLayout(null);

        jScrollPane1.setAutoscrolls(true);

        tblcus.setAutoCreateRowSorter(true);
        tblcus.setFont(tblcus.getFont().deriveFont((float)11));
        tblcus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblcus.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblcus.setDoubleBuffered(true);
        tblcus.setFillsViewportHeight(true);
        tblcus.setMaximumSize(new java.awt.Dimension(2147483647, 72));
        tblcus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcus);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(16, 68, 991, 300);

        btnsrch.setFont(btnsrch.getFont().deriveFont(btnsrch.getFont().getStyle() | java.awt.Font.BOLD, 11));
        btnsrch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1245117595_001_37.png"))); // NOI18N
        btnsrch.setText("Search Customer");
        btnsrch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsrchMouseClicked(evt);
            }
        });
        btnsrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsrchActionPerformed(evt);
            }
        });
        jPanel1.add(btnsrch);
        btnsrch.setBounds(837, 38, 170, 24);

        txtcso.setFont(txtcso.getFont().deriveFont((float)11));
        jPanel1.add(txtcso);
        txtcso.setBounds(346, 37, 104, 24);

        txtcusnm.setFont(txtcusnm.getFont().deriveFont((float)11));
        txtcusnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcusnmActionPerformed(evt);
            }
        });
        jPanel1.add(txtcusnm);
        txtcusnm.setBounds(16, 37, 104, 24);

        txtnopl.setFont(txtnopl.getFont().deriveFont((float)11));
        jPanel1.add(txtnopl);
        txtnopl.setBounds(126, 37, 104, 24);

        txtdri.setFont(txtdri.getFont().deriveFont((float)11));
        jPanel1.add(txtdri);
        txtdri.setBounds(236, 37, 104, 24);

        jLabel5.setFont(jLabel5.getFont().deriveFont((float)11));
        jLabel5.setText("Nama");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 20, 27, 14);

        jLabel6.setFont(jLabel6.getFont().deriveFont((float)11));
        jLabel6.setText("No Plat");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 20, 51, 14);

        jLabel7.setFont(jLabel7.getFont().deriveFont((float)11));
        jLabel7.setText("Driver");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(240, 20, 51, 14);

        jLabel8.setFont(jLabel8.getFont().deriveFont((float)11));
        jLabel8.setText("CSO");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(350, 20, 51, 14);

        jLabel9.setFont(jLabel9.getFont().deriveFont((float)11));
        jLabel9.setText("GS Driver");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(460, 20, 51, 14);

        txtgsdriver.setFont(txtgsdriver.getFont().deriveFont((float)11));
        jPanel1.add(txtgsdriver);
        txtgsdriver.setBounds(456, 37, 104, 24);

        jLabel10.setFont(jLabel10.getFont().deriveFont((float)11));
        jLabel10.setText("No Plat GS");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(570, 20, 74, 14);

        txtplatnogs.setFont(txtplatnogs.getFont().deriveFont((float)11));
        jPanel1.add(txtplatnogs);
        txtplatnogs.setBounds(566, 37, 104, 24);

        jLabel11.setFont(jLabel11.getFont().deriveFont((float)11));
        jLabel11.setText("User");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(680, 20, 74, 14);

        txtuser.setFont(txtuser.getFont().deriveFont((float)11));
        jPanel1.add(txtuser);
        txtuser.setBounds(676, 37, 104, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsrchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsrchMouseClicked
        // TODO add your handling code here:
        tabelcus();
    }//GEN-LAST:event_btnsrchMouseClicked

    private void txtcusnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcusnmActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtcusnmActionPerformed

    @SuppressWarnings("static-access")
    private void tblcusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcusMouseClicked
        // TODO add your handling code here:
        if(tabcus.getRowCount()!=0){
            if(evt.getClickCount()==2){
                switch (Form){
                    case 1:
                        Tic.cbnoplat.removeAllItems();
                        Tic.cbdriver.removeAllItems();

                        Tic.txtcontract.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),0));
                        Tic.txtcuscod.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),3));
                        Tic.txtcusnam.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),4));
                        Tic.txtcustadd.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),5));
                        Tic.txtcusfax.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),6));
                        Tic.txtcuspic.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),7));
                        Tic.txtdrinm.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),12));
                        Tic.txtcso.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),14));
                        Tic.txtcsopho.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),15));
                        Tic.txtcsomail.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),16));
            //            Tic.cbnoplat.addItem((String)tblcus.getValueAt(tblcus.getSelectedRow(),10));
            //            Tic.cbnoplat.addItem((String)tblcus.getValueAt(tblcus.getSelectedRow(),16));
                        Tic.cbdriver.addItem((String)tblcus.getValueAt(tblcus.getSelectedRow(),12));
                        Tic.cbdriver.addItem((String)tblcus.getValueAt(tblcus.getSelectedRow(),18));
                        Tic.contid=Integer.parseInt((String)tblcus.getValueAt(tblcus.getSelectedRow(),20));

//                        Tic.showPlat();
                        Tic.showcus();
                        break;
                    case 2:
                        Inc.IdCust=((String)tblcus.getValueAt(tblcus.getSelectedRow(),0));
                        Inc.txtIdCust.setText((String)tblcus.getValueAt(tblcus.getSelectedRow(),0));
                        Inc.tabeltic();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                }
                dispose();
            }
        }
    }//GEN-LAST:event_tblcusMouseClicked

    private void btnsrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsrchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsrchActionPerformed

   
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_customer().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsrch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcus;
    public static javax.swing.JTextField txtcso;
    public static javax.swing.JTextField txtcusnm;
    public static javax.swing.JTextField txtdri;
    public static javax.swing.JTextField txtgsdriver;
    public static javax.swing.JTextField txtnopl;
    public static javax.swing.JTextField txtplatnogs;
    public static javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables

    private static String sql;
    private static ResultSet rs;
//    private JavaConnector jconn=new JavaConnector();
//    private Connection conn;
}
