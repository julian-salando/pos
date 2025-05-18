/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class stockInventory extends javax.swing.JFrame {
Connection con;
java.sql.PreparedStatement pst;
int selectedId = -1;
    public stockInventory() {
        initComponents();
        connect();
        loadStockTable();
    }
public void connect() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/pos_system", "root", "");
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(stockInventory.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Database connection failed: " + ex.getMessage());
    }
}
private void loadStockTable() {
    try {
        pst = con.prepareStatement("SELECT * FROM stocks");
        rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("product_name"),
                rs.getInt("stock"),
                rs.getTimestamp("created_at"),
                rs.getString("is_low")
            };
            model.addRow(row);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading stock table: " + ex.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtpname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Quantity", "Date & Time", "Stock Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Name");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity/Stock");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 153));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(153, 0, 0));
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("REMOVE");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "low", "high" }));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbStatus)
                            .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private ResultSet rs;

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
   String productName = txtpname.getText();
    String stockText = txtStock.getText();
    String status = cmbStatus.getSelectedItem().toString().toLowerCase(); // "low" or "high"

    if (productName.isEmpty() || stockText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Name, Stock, and Status are required.");
        return;
    }

    try {
        int stock = Integer.parseInt(stockText);
        pst = con.prepareStatement("INSERT INTO stocks (product_name, stock, is_low) VALUES (?, ?, ?)");
        pst.setString(1, productName);
        pst.setInt(2, stock);
        pst.setString(3, status);

        int result = pst.executeUpdate();
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Stock added successfully!");
            txtpname.setText("");
            txtStock.setText("");
            cmbStatus.setSelectedIndex(0);
            loadStockTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add stock.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid stock value. Please enter a number.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    String productName = txtpname.getText();
    String stockText = txtStock.getText();
    String status = cmbStatus.getSelectedItem().toString().toLowerCase();

    if (productName.isEmpty() || stockText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    try {
        int stock = Integer.parseInt(stockText);

        // Ensure selectedId is correctly used
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row from the table or search for a product first.");
            return;
        }

        pst = con.prepareStatement("UPDATE stocks SET product_name = ?, stock = ?, is_low = ? WHERE id = ?");
        pst.setString(1, productName);
        pst.setInt(2, stock);
        pst.setString(3, status);
        pst.setInt(4, selectedId);

        int result = pst.executeUpdate();
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Stock updated.");
            txtpname.setText("");
            txtStock.setText("");
            cmbStatus.setSelectedIndex(0);
            txtSearch.setText("");
            selectedId = -1;
            loadStockTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Stock must be a number.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
      int selectedRow = jTable1.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        String id = jTable1.getValueAt(selectedRow, 0).toString();

        try {
            pst = con.prepareStatement("DELETE FROM stocks WHERE id = ?");
            pst.setInt(1, Integer.parseInt(id));

            int result = pst.executeUpdate();
            if (result == 1) {
                JOptionPane.showMessageDialog(this, "Stock removed successfully.");
                txtpname.setText("");
                txtStock.setText("");
                loadStockTable(); // Refresh table
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete stock.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
   String searchText = txtSearch.getText().trim();

    if (searchText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter product name to search.");
        return;
    }

    try {
        pst = con.prepareStatement("SELECT id, product_name, stock, is_low FROM stocks WHERE product_name = ?");
        pst.setString(1, searchText);
        rs = pst.executeQuery();

        if (rs.next()) {
            selectedId = rs.getInt("id");  // Ensure selectedId is set correctly
            txtpname.setText(rs.getString("product_name"));
            txtStock.setText(String.valueOf(rs.getInt("stock")));

            String isLow = rs.getString("is_low");
            if (isLow != null) {
                cmbStatus.setSelectedItem(isLow.substring(0, 1).toUpperCase() + isLow.substring(1));
            } else {
                cmbStatus.setSelectedIndex(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Product not found.");
            txtpname.setText("");
            txtStock.setText("");
            cmbStatus.setSelectedIndex(0);
            selectedId = -1;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Search error: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     new AdminDashboard().setVisible(true);
     dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(stockInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stockInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stockInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stockInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stockInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtpname;
    // End of variables declaration//GEN-END:variables
}
