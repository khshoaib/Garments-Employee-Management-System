/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gems;
//import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.*;
import gems.ConnectionProvider;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Shoaib
 */
public class EmployeeList extends javax.swing.JFrame {
        DefaultTableModel model;
    /**
     * Creates new form EmployeeList
     */
    public EmployeeList() {
        initComponents();
        setRecordsToTable();
        //show_user();
    }
    public void setRecordsToTable(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GEMS;selectMethod=cursor;" + "encrypt=true;trustServerCertificate=true;", "sa", "123456");
            String query1="SELECT * FROM Employee";
            PreparedStatement pst=con.prepareStatement(query1);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                String Employee_Id =rs.getString("Employee_Id");
                String First_Name=rs.getString("First_Name");
                String Last_Name=rs.getString("Last_Name");
                String Date_of_Birth=rs.getString("Date_of_Birth");
                String NID=rs.getString("NID");
                String Address=rs.getString("Address");
                String Phone_Number=rs.getString("Phone_Number");
                String Gender=rs.getString("Gender");
                String Mobile_Banking_Account=rs.getString("Mobile_Banking_Account");
                String Banking_Account=rs.getString("Banking_Account");
                Object[] obj={Employee_Id,First_Name,Last_Name,Date_of_Birth,NID,Address,Phone_Number,Gender,Mobile_Banking_Account,Banking_Account};
                
                model =(DefaultTableModel)jTable1.getModel();
                model.addRow(obj);
                
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
   /* public ArrayList<User>userList(){
        ArrayList<User>userList =new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GEMS;selectMethod=cursor;" + "encrypt=true;trustServerCertificate=true;", "sa", "123456");
            String query1="SELECT * FROM Employee";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query1);
            User user;
            while(rs.next()){
                user=new User(rs.getInt("Employee_Id") ,rs.getString("First_Name"), rs.getString("Last_Name"),rs.getString("Date_of_Birth"),rs.getInt("NID"),rs.getString("Address"),rs.getInt("phone_Number"),rs.getString("Gender"),rs.getInt("Mobile_Banking_Account"),rs.getInt("Banking_Account"),rs.getInt("Admin_Id"));
                userList.add(user);
            }
            
            
        }catch(Exception e){
            
        }
        return userList;
    }
    
    public void show_user(){
        ArrayList<User>list=userList();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row=new Object[11];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getEmployee_Id();
            row[1]=list.get(i).getFirst_Name();
            row[2]=list.get(i).getLast_Name();
            row[3]=list.get(i).getDate_of_Birth();
            row[4]=list.get(i).getNID();
            row[5]=list.get(i).getAddress();
            row[6]=list.get(i).getPhone_Number();
            row[7]=list.get(i).getGender();
            row[8]=list.get(i).getMobile_Banking_Account();
            row[9]=list.get(i).getBanking_Account();
            row[10]=list.get(i).getAdmin_Id();
            model.addRow(row);
        }
    }*/
    
    public void search(String str){
        model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> trs =new TableRowSorter<>(model);
        jTable1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Search_bar = new javax.swing.JTextField();
        back1 = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee_Id", "First_Name", "Last_Name", "DOB", "NID", "Address", "Mobile_NUmber", "Gender", "Mobile_banking_Acc", "Bank_Acc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 990));

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        back.setText("Home");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 80, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Employee List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(897, 35, 131, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Search :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 56, -1, 30));

        Search_bar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_barActionPerformed(evt);
            }
        });
        Search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Search_barKeyReleased(evt);
            }
        });
        jPanel1.add(Search_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 52, 250, 40));

        back1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        back1.setText("Return");
        back1.setMaximumSize(new java.awt.Dimension(69, 25));
        back1.setMinimumSize(new java.awt.Dimension(69, 25));
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });
        jPanel1.add(back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 30));

        print.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        print.setText("Print");
        print.setMaximumSize(new java.awt.Dimension(69, 25));
        print.setMinimumSize(new java.awt.Dimension(69, 25));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2070, 110));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 970));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try{
            jTable1.print(JTable.PrintMode.NORMAL);
        }catch(Exception e){
            System.out.println("nothing");
        }

    }//GEN-LAST:event_printActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        MainForm m=new MainForm();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void Search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_barActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Search_barActionPerformed

    private void Search_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_barKeyReleased
        // TODO add your handling code here:
        String searchString=Search_bar.getText();
        search(searchString);
    }//GEN-LAST:event_Search_barKeyReleased

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        // TODO add your handling code here:
        EmployeeADD m=new EmployeeADD();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back1ActionPerformed
     private void formComponentShown(java.awt.event.ComponentEvent evt) {                                    
        // TODO add your handling code here:DAtabase showing process///
//        try{
//            Connection con = ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select * from Admin");
//            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
    }       
//        try{
//            Connection con = ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select * from Employee");
//            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//            System.out.println("nothing1");
//        }
//    }                  
    
    
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
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search_bar;
    private javax.swing.JButton back;
    private javax.swing.JButton back1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}