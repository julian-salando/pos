/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAMSUNG
 */
public class SalesReport extends javax.swing.JFrame {

    /**
     * Creates new form SalesReport
     */
    public SalesReport() {
        initComponents();
        displayTransactions();
    }
private void displayTransactions() {
    // Database connection details
    String url = "jdbc:mysql://localhost:3306/pos_system";
    String user = "root";
    String password = "";

    // Query to fetch data
    String query = "SELECT * FROM transactions";

    try {
        // Establish connection
        Connection con = DriverManager.getConnection(url, user, password);

        // Prepare and execute query
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        // Get the model of the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows

        // Loop through the result set and add rows to the table
        while (rs.next()) {
            // Get data from each column (adjust as per your table structure)
            String transactionID = rs.getString("transaction_id");
            String items = rs.getString("items");
            String totalAmount = rs.getString("total_amount");
            String cashGiven = rs.getString("cash_given");
            String changeGiven = rs.getString("change_given");
            String transactionDate = rs.getString("transaction_date");

            // Add row to the table model
            model.addRow(new Object[]{transactionID, items, totalAmount, cashGiven, changeGiven, transactionDate});
        }

        // Close the connection
        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    private void generateReport() {
   String url = "jdbc:mysql://localhost:3306/pos_system";
    String user = "root";
    String password = "";

    String reportType = reportTypeComboBox.getSelectedItem().toString();
    String query = "";

    // Choose query based on report type
    if (reportType.equals("Daily")) {
        query = "SELECT transaction_id, items, total_amount, cash_given, change_given, transaction_date FROM transactions WHERE DATE(transaction_date) = CURDATE()";
    } else if (reportType.equals("Weekly")) {
        query = "SELECT transaction_id, items, total_amount, cash_given, change_given, transaction_date FROM transactions WHERE YEARWEEK(transaction_date) = YEARWEEK(NOW())";
    } else if (reportType.equals("Monthly")) {
        query = "SELECT transaction_id, items, total_amount, cash_given, change_given, transaction_date FROM transactions WHERE DATE_FORMAT(transaction_date, '%Y-%m') = DATE_FORMAT(NOW(), '%Y-%m')";
    }

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        StringBuilder report = new StringBuilder();
        report.append("Sales Report (" + reportType + ")\n");
        report.append("-------------------------------------------------------------\n");
        report.append(String.format("%-15s %-30s %-10s %-10s %-10s %-20s\n", 
                "Transaction ID", "Items", "Total", "Cash Given", "Change", "Date"));
        report.append("-------------------------------------------------------------\n");

        // Fetch data and build report
        while (rs.next()) {
            String transactionId = rs.getString("transaction_id");
            String items = rs.getString("items");
            double totalAmount = rs.getDouble("total_amount");
            double cashGiven = rs.getDouble("cash_given");
            double changeGiven = rs.getDouble("change_given");
            String transactionDate = rs.getString("transaction_date");

            report.append(String.format("%-15s %-30s %-10.2f %-10.2f %-10.2f %-20s\n", 
                    transactionId, items, totalAmount, cashGiven, changeGiven, transactionDate));
        }

        // Display report in JTextArea
        reportArea.setText(report.toString());

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error generating report: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        reportTypeComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        exportReport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportArea = new javax.swing.JTextArea();
        generateReport = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel1.setText("Filter");

        reportTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Transaction_id", "Items", "Total_amount", "Cash_given", "Change_given", "Transaction_date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        exportReport.setText("Export");
        exportReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportReportActionPerformed(evt);
            }
        });

        reportArea.setColumns(20);
        reportArea.setRows(5);
        jScrollPane2.setViewportView(reportArea);

        generateReport.setText("Generate Report");
        generateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("Transaction History");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setText("Generate Reports");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exportReport, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reportTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(generateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reportTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(exportReport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void generateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportActionPerformed
       generateReport();
    }//GEN-LAST:event_generateReportActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       new AdminDashboard().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void exportReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportReportActionPerformed
       JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save Report As");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        if (!fileToSave.getAbsolutePath().toLowerCase().endsWith(".txt")) {
            fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
        }

        try (PrintWriter writer = new PrintWriter(fileToSave)) {
            writer.print(reportArea.getText());
            javax.swing.JOptionPane.showMessageDialog(this, "Report exported successfully to " + fileToSave.getAbsolutePath());
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error exporting report: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_exportReportActionPerformed

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
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportReport;
    private javax.swing.JButton generateReport;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea reportArea;
    private javax.swing.JComboBox<String> reportTypeComboBox;
    // End of variables declaration//GEN-END:variables

    private static class rs {

        public rs() {
        }
    }
}
