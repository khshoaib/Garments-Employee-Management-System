/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MUSFIQ
 */
public class AttendanceClass extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * Creates new form AttendanceClass
     */
    public AttendanceClass() {
        initComponents();
        setRecordsToTable();
    }

    public void setRecordsToTable() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GEMS;selectMethod=cursor;" + "encrypt=true;trustServerCertificate=true;", "sa", "123456");
            String query1 = "SELECT * FROM Attendance";
            PreparedStatement pst = con.prepareStatement(query1);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String Entry_Date = rs.getString("Entry_Date");
                String Entry_Month = rs.getString("Entry_Month");
                String Entry_Year = rs.getString("Entry_Year");
                String Entry_Time = rs.getString("Entry_Time");
                String Exit_Time = rs.getString("Exit_Time");
                String Employee_Id = rs.getString("Employee_Id");
                String Over_Time = rs.getString("Over_Time");

                Object[] obj = {Entry_Date, Entry_Month, Entry_Year, Entry_Time, Exit_Time, Employee_Id, Over_Time};

                model = (DefaultTableModel) jTable2.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void search(String str) {
        model = (DefaultTableModel) jTable2.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTable2.setRowSorter(trs);
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

        attMainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        entryYear = new javax.swing.JLabel();
        entryYearField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        exitField = new javax.swing.JTextField();
        attEmpId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        UpdateAttBtn = new javax.swing.JButton();
        InsertAttBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        Search_bar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        entryField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        entryMonth = new javax.swing.JLabel();
        entryMonthField = new javax.swing.JTextField();
        entryDateField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        attMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Attendance Panel");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 300, 35));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel2.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 10, 20, 20));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Back_icon2.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 50, 50));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home2.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 2, 50, 50));

        attMainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 100));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        entryYear.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        entryYear.setText("Entry Year");
        jPanel2.add(entryYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 110, 30));

        entryYearField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        entryYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryYearFieldActionPerformed(evt);
            }
        });
        jPanel2.add(entryYearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 270, 30));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel5.setText("Exit Time");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 100, 30));

        exitField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        exitField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFieldActionPerformed(evt);
            }
        });
        jPanel2.add(exitField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 270, 30));

        attEmpId.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N
        jPanel2.add(attEmpId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 270, 30));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel6.setText("Employee id");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 110, 30));

        UpdateAttBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateAttBtn.setText("Update");
        UpdateAttBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateAttBtnActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateAttBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        InsertAttBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        InsertAttBtn.setText("Insert");
        InsertAttBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertAttBtnActionPerformed(evt);
            }
        });
        jPanel2.add(InsertAttBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entry Date", "Entry Month", "Entry Year", "Entry Time", "Exit Time", "Employee Id", "Over Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 870, 550));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Search:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

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
        jPanel2.add(Search_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 230, 30));

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel7.setText("Entry Time");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 100, 30));

        entryField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        entryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryFieldActionPerformed(evt);
            }
        });
        jPanel2.add(entryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 270, 30));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel8.setText("Entry Date");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 100, 30));

        entryMonth.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        entryMonth.setText("Entry Month");
        jPanel2.add(entryMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 110, 30));

        entryMonthField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        entryMonthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryMonthFieldActionPerformed(evt);
            }
        });
        jPanel2.add(entryMonthField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 270, 30));

        entryDateField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        entryDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryDateFieldActionPerformed(evt);
            }
        });
        jPanel2.add(entryDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 270, 30));

        attMainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1400, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(attMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(attMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainForm m = new MainForm();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MainForm m = new MainForm();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void UpdateAttBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateAttBtnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GEMS;selectMethod=cursor;" + "encrypt=true;trustServerCertificate=true;", "sa", "123456");
            int row = jTable2.getSelectedRow();
            //String value = (jTable2.getModel().getValueAt(row, 3).toString());
            //String date = (jTable2.getModel().getValueAt(row, 0).toString());
            String query = "UPDATE Attendance SET Entry_Month=?,Entry_Year=?,Entry_Time=?,Exit_Time=?,Over_Time=?" + " where Employee_Id=? and Entry_Date=?";

            PreparedStatement pst = con.prepareStatement(query);

            String query1 = "SELECT\n"
                    + "  Employee_id,\n"
                    + "  DATEDIFF(second, Entry_Time, Exit_Time) AS difference\n"
                    + "FROM Attendance where Entry_date=? and Employee_id=?";

            PreparedStatement g = con.prepareStatement(query1);
            g.setString(1, entryDateField.getText());
            g.setString(2, attEmpId.getText());

            ResultSet sp = g.executeQuery();

            sp.next();
            String f = sp.getString("difference");
            int i = Integer.parseInt(f);

            i = i - 28800;
            System.out.println(i);
            String ov = String.valueOf(i);
            System.out.println(ov);
            pst.setString(1, entryMonthField.getText());
            pst.setString(2, entryYearField.getText());
            pst.setString(3, entryField.getText());
            pst.setString(4, exitField.getText());
            System.out.println(ov);
            pst.setString(5, ov);
            pst.setString(6, attEmpId.getText());
            pst.setString(7, entryDateField.getText());

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            setRecordsToTable();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_UpdateAttBtnActionPerformed

    private void InsertAttBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertAttBtnActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GEMS;selectMethod=cursor;" + "encrypt=true;trustServerCertificate=true;", "sa", "123456");

            String query = "insert into attendance(Entry_Date,Entry_Month,Entry_Year,Entry_Time,Exit_Time,Employee_Id)values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, entryDateField.getText());
            pst.setString(2, entryMonthField.getText());
            pst.setString(3, entryYearField.getText());
            pst.setString(4, entryField.getText());
            pst.setString(5, exitField.getText());
            pst.setString(6, attEmpId.getText());

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            setRecordsToTable();
            JOptionPane.showMessageDialog(null, "Inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("notconnect");
        }
        //setRecordsToTable();
    }//GEN-LAST:event_InsertAttBtnActionPerformed

    private void Search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_barActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Search_barActionPerformed

    private void Search_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_barKeyReleased
        // TODO add your handling code here:
        String searchString = Search_bar.getText();
        search(searchString);
    }//GEN-LAST:event_Search_barKeyReleased

    private void entryYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryYearFieldActionPerformed

    private void exitFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitFieldActionPerformed

    private void entryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryFieldActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int i = jTable2.getSelectedRow();
        TableModel model1 = jTable2.getModel();
        entryDateField.setText(model1.getValueAt(i, 0).toString());
        entryMonthField.setText(model1.getValueAt(i, 1).toString());
        entryYearField.setText(model1.getValueAt(i, 2).toString());
        entryField.setText(model1.getValueAt(i, 3).toString());
        exitField.setText(model1.getValueAt(i, 4).toString());
        attEmpId.setText(model1.getValueAt(i, 5).toString());
        //attOvtime.setText(model1.getValueAt(i,4).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void entryDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryDateFieldActionPerformed

    private void entryMonthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryMonthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryMonthFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AttendanceClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InsertAttBtn;
    private javax.swing.JTextField Search_bar;
    private javax.swing.JButton UpdateAttBtn;
    private javax.swing.JTextField attEmpId;
    private javax.swing.JPanel attMainPanel;
    private javax.swing.JTextField entryDateField;
    private javax.swing.JTextField entryField;
    private javax.swing.JLabel entryMonth;
    private javax.swing.JTextField entryMonthField;
    private javax.swing.JLabel entryYear;
    private javax.swing.JTextField entryYearField;
    private javax.swing.JTextField exitField;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
