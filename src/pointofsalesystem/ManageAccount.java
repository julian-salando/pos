/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

import java.awt.Image;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author SAMSUNG
 */
public class ManageAccount extends javax.swing.JFrame {

    private Object imagePath;
    private javax.swing.JTextField txtID;
    private int id;
    

    /**
     * Creates new form ManageAccount
     */
    public ManageAccount() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
     public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pos_system","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void LoadProductNo(){
          try {
        txtId.removeAllItems();
        pst = con.prepareStatement("SELECT id FROM users");
        rs = pst.executeQuery();
        
        while (rs.next()) {
            txtId.addItem(rs.getString("id"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
  public void Fetch(){
    try {
        int q;
        pst = con.prepareStatement("SELECT * FROM users");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();

        q = rss.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();
            v2.add(rs.getString("id"));
            v2.add(rs.getString("full_name"));
            v2.add(rs.getString("username"));
            v2.add(rs.getString("phone_number"));
            v2.add("******"); // Mask the password
            v2.add(rs.getString("role"));

            df.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
    }      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtId = new javax.swing.JComboBox<>();
        txtRole = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        ShowPass = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "User Id#", "Name", "Username", "Contact #", "Password", "Role"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        btnUpdate.setBackground(new java.awt.Color(0, 0, 153));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update User");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 0, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete User");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add User");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID#" }));

        jLabel5.setText("Role");

        jLabel6.setText("Contact #");

        btnBrowse.setBackground(new java.awt.Color(102, 102, 102));
        btnBrowse.setText("Choose profile");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jLabel1.setText("Full Name");

        txtPassword.setText("jPassword");

        ShowPass.setText("Show Password");
        ShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ShowPass)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(193, 193, 193))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 103, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(151, 151, 151))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowse)))
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowPass)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel7.setText("Add Accounts");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(68, 68, 68)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSearch)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          try {
    // Get the product name from the search text field
    String username = txtSearch.getText().trim();
    
    // Prepare the query to fetch product details by name
    pst = con.prepareStatement("SELECT * FROM users WHERE username LIKE ?");
    pst.setString(1, "%" + username + "%");
    rs = pst.executeQuery();
    
    // If a matching product is found, populate the text fields
    if (rs.next()) {
        txtId.setSelectedItem(rs.getString("id"));
        txtName.setText(rs.getString("full_name"));
        txtRole.setText(rs.getString("role"));
        txtUsername.setText(rs.getString("username"));
        txtContact.setText(rs.getString("phone_number"));
        txtPassword.setText(rs.getString("password"));
        // Load and display the image with path validation
        String basePath = new File("").getAbsolutePath() + "/";
        String imagePath = basePath + rs.getString("profile_picture");
        File imageFile = new File(imagePath);

        if (imageFile.exists()) {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(image));
        } else {
            lblImage.setIcon(null);
            JOptionPane.showMessageDialog(this, "Image not found: " + imagePath);
        }
    } else {
        JOptionPane.showMessageDialog(this, "No user found with this name.");
        clearFields();  // Clear the text fields if no product is found
    }
} catch (SQLException ex) {
    Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
}

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
                                     
     if (txtName.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "User Full name Required!");
    } else if (txtUsername.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username Required!");
    } else if (txtPassword.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password Required!");
    } else if (txtContact.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Contact number Required!");
    } else if (txtRole.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please Select User Role Required!");
    }else if (imagePath == null || imagePath.toString().isEmpty()) {  // Check if image is selected
        JOptionPane.showMessageDialog(this, "Users Profile Picture Required!");
    } else {
        try {
            String full_name = txtName.getText();
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            String phone_number = txtContact.getText();
            String role = txtRole.getText();
            // Set the destination folder and file name
            String destinationFolder = "media/";
            String destinationPath = destinationFolder + new File((String) imagePath).getName();
            
            // Create the destination folder if it doesn't exist
            File destDir = new File(destinationFolder);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            
            try {
                // Copy the image to the destination folder
                Files.copy(new File((String) imagePath).toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Save the relative path to the database
            pst = con.prepareStatement("INSERT INTO users (full_name, username, password, phone_number, role, profile_picture) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, full_name);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, phone_number);
            pst.setString(5, role);
            pst.setString(6, destinationPath);  // Store relative path
            
            int k = pst.executeUpdate();
            
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "User added successfully!");
                txtName.setText("");
                txtUsername.setText("");
                txtPassword.setText("");
                txtContact.setText("");
                txtRole.setText("");
                lblImage.setIcon(null);
                imagePath = null; // Reset imagePath after successful upload
                Fetch();
                LoadProductNo();
            } else {
                JOptionPane.showMessageDialog(this, "Error! Try Again.");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format. Please check the input values.");
        }
     } 
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Choose an Image");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String filePath = selectedFile.getAbsolutePath();
        
        // Set the imagePath for validation and saving
        imagePath = filePath;   // <-- This line is the fix
        
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(image));
    }     
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
                                             
  if (txtName.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "User Full name Required!");
    } else if (txtUsername.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username Required!");
    } else if (txtPassword.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password Required!");
    } else if (txtContact.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Contact number Required!");
    } else if (txtRole.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please Select User Role Required!");
    }else  {
        try {
            String full_name = txtName.getText();
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            String phone_number = txtContact.getText();
            String role = txtRole.getText();
            int id = Integer.parseInt(txtId.getSelectedItem().toString());
                  // Check if a new image is selected
            String destinationPath = null;

if (imagePath != null && !imagePath.toString().isEmpty()) {
                // Set the destination folder and file name
               String destinationFolder = "media/";
destinationPath = destinationFolder + new File((String) imagePath).getName();

// Store the relative path for consistent retrieval
destinationPath = destinationPath.replace("\\", "/");


                
                // Create the destination folder if it doesn't exist
                File destDir = new File(destinationFolder);
                if (!destDir.exists()) {
                    destDir.mkdirs();
                }
                
                try {
                    // Copy the image to the destination folder
                    Files.copy(new File((String) imagePath).toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // Update product with or without new image
            if (destinationPath != null) {
                pst = con.prepareStatement("UPDATE users SET full_name = ?, username = ?, password = ?, phone_number = ?, role = ?, profile_picture = ? WHERE id = ?");
                pst.setString(1, full_name);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, phone_number);
                pst.setString(5, role);
                pst.setString(6, destinationPath); // Update the image path
                pst.setInt(7, id);
            } else {
                pst = con.prepareStatement("UPDATE users SET full_name = ?, username = ?, password = ?, phone_number = ?, role = ? WHERE id = ?");
                 pst.setString(1, full_name);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, phone_number);
                pst.setString(5, role);
                pst.setInt(6, id);
            }

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Updated Successfully");
                txtName.setText("");
                txtUsername.setText("");
                txtPassword.setText("");
                txtContact.setText("");
                txtRole.setText("");
                lblImage.setIcon(null);
                txtId.setSelectedIndex(0);
                imagePath = null; // Reset imagePath after successful upload
                txtName.requestFocus();
                Fetch();
                LoadProductNo();
            }
        } catch (SQLException ex) {
            Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format. Please check the input values.");                                      
        }
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       new AdminDashboard().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
            try {
        // Get selected ID from dropdown (JComboBox)
        String id = txtId.getSelectedItem().toString();

        // Ensure connection exists
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection error!");
            return;
        }

        // Prepare SQL query using ID instead of full_name
        pst = con.prepareStatement("DELETE FROM users WHERE id = ?");
        pst.setString(1, id);

        int k = pst.executeUpdate();

        if (k > 0) {  
            JOptionPane.showMessageDialog(this, "User deleted successfully!");

            // Clear input fields after deletion
            txtName.setText("");
            txtUsername.setText("");
            txtContact.setText("");
            txtPassword.setText("");
            txtRole.setText("");
            txtName.requestFocus();

            // Refresh table
            Fetch();
            LoadProductNo();
        } else {
            JOptionPane.showMessageDialog(this, "No matching user found!");
        }

    } catch (SQLException ex) {
        Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void ShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPassActionPerformed
       if (ShowPass.isSelected()) {
        txtPassword.setEchoChar((char) 0); // Show password
    } else {
        txtPassword.setEchoChar('*'); // Hide password
    }
    }//GEN-LAST:event_ShowPassActionPerformed

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
            java.util.logging.Logger.getLogger(ManageAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ShowPass;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField txtContact;
    private javax.swing.JComboBox<String> txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
