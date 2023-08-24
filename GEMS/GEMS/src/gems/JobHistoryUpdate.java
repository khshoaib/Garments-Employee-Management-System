/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gems;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Hp
 */
public class JobHistoryUpdate extends javax.swing.JFrame {
DefaultTableModel model;
    /**
     * Creates new form UpdateJobHistory
     */
    public JobHistoryUpdate() {
        initComponents();
        setRecordsToTable();
    }
public void setRecordsToTable() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GEMS;selectMethod=cursor;" + "encrypt=true;trustServerCertificate=true;", "sa", "123456");
            String query1 = "SELECT * FROM Job_History";
            PreparedStatement pst = con.prepareStatement(query1);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String Employee_Id = rs.getString("Previous_Company");
                String First_Name = rs.getString("Joining_Date");
                String Last_Name = rs.getString("Ending_Date");
                String Date_of_Birth = rs.getString("Designation");
                String NID = rs.getString("Employee_Id");
                String Address = rs.getString("Job_History_Id");
//                String Phone_Number = rs.getString("Phone_Number");
//                String Gender = rs.getString("Gender");
//                String Mobile_Banking_Account = rs.getString("Mobile_Banking_Account");
//                String Banking_Account = rs.getString("Banking_Account");
                Object[] obj = {Employee_Id, First_Name, Last_Name, Date_of_Birth, NID, Address};

                model = (DefaultTableModel) jTable1.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
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

        jPanel1 = new javax.swing.JPanel();
        btnReturn = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PrevJob = new javax.swing.JTextField();
        EmpID = new javax.swing.JTextField();
        JOBhISID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Designation = new javax.swing.JTextField();
        EndingDate = new javax.swing.JTextField();
        JoiningDate = new javax.swing.JTextField();
        BtnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Search_bar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        jPanel1.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 25, 100, 37));

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 25, 100, 37));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Joining Date:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 110, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Designation:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 110, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Employee ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 110, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Job history ID:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 110, 50));
        jPanel1.add(PrevJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 180, 50));
        jPanel1.add(EmpID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 180, 50));
        jPanel1.add(JOBhISID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 180, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Ending Date:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 110, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Previous Job:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 110, 50));
        jPanel1.add(Designation, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 180, 50));
        jPanel1.add(EndingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 180, 50));
        jPanel1.add(JoiningDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 180, 50));

        BtnUpdate.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BtnUpdate.setText("Update");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(BtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 810, 110, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Previous Job", "Joining Date", "Ending Date", "Designation", "Employee ID", "Job history ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 1410, 930));

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
        jPanel1.add(Search_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 50, 260, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Search:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 40, 80, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
        JobHistory jjb=new JobHistory();
        jjb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        MainForm m=new MainForm();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GEMS;selectMethod=cursor;" + "encrypt=true;trustServerCertificate=true;", "sa", "123456");
            int row =jTable1.getSelectedRow();
            String value=(jTable1.getModel().getValueAt(row,5).toString());
            String query="UPDATE Job_History SET Previous_Company=?,Joining_Date=?,Ending_Date=?,Designation=?,Employee_Id=?,Job_History_Id=? where Job_History_Id="+value;
            /*
            create table Job_History(
Previous_Company varchar(50) not null,
Joining_Date date not null,
Ending_Date date not null,
Designation varchar(50) not null,
Employee_Id int not null foreign key references Employee(Employee_Id),
Job_History_Id int identity(1,1) primary key,
);
            */
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, PrevJob.getText());
            pst.setString(2,JoiningDate.getText());
            pst.setString(3, EndingDate.getText());
            pst.setString(4,Designation.getText());
            pst.setString(5, EmpID.getText());
            pst.setString(6,JOBhISID.getText());
//            String gender="";
//            if(Male.isSelected()){
//                gender="Male";
//            }
//            if(Female.isSelected()){
//                gender="Female";
//            }
//            pst.setString(7, gender);
//            pst.setString(8,MBC.getText());
//            pst.setString(9,bc.getText());
            pst.executeUpdate();
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            setRecordsToTable();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();
        TableModel model1=jTable1.getModel();
        PrevJob.setText(model1.getValueAt(i, 0).toString());
        JoiningDate.setText(model1.getValueAt(i, 1).toString());
        EndingDate.setText(model1.getValueAt(i,2).toString());
        
        Designation.setText(model1.getValueAt(i, 3).toString());
        EmpID.setText(model1.getValueAt(i, 4).toString());
        JOBhISID .setText(model1.getValueAt(i, 5).toString());
//        String sex=model.getValueAt(i, 7).toString();
//        if(sex.equals("Male")){
//            Male.setSelected(true);
//        }
//        else{
//            Female.setSelected(true);
//        }
//        MBC.setText(model1.getValueAt(i, 8).toString());
//        bc.setText(model1.getValueAt(i, 9).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void Search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_barActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_Search_barActionPerformed

    private void Search_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_barKeyReleased
        // TODO add your handling code here:
        String searchString=Search_bar.getText();
        search(searchString);
    }//GEN-LAST:event_Search_barKeyReleased

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
            java.util.logging.Logger.getLogger(JobHistoryUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobHistoryUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobHistoryUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobHistoryUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobHistoryUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JTextField Designation;
    private javax.swing.JTextField EmpID;
    private javax.swing.JTextField EndingDate;
    private javax.swing.JTextField JOBhISID;
    private javax.swing.JTextField JoiningDate;
    private javax.swing.JTextField PrevJob;
    private javax.swing.JTextField Search_bar;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}