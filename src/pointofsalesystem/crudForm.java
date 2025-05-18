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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class crudForm extends javax.swing.JFrame {

    private javax.swing.JTextField txtID;
    private String imagePath;
    
    /**
     * Creates new form crudForm
     */
    public crudForm() {
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
            Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadProductNo(){
          try {
        txtId.removeAllItems();
        pst = con.prepareStatement("SELECT id FROM products");
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
            pst = con.prepareStatement("SELECT * FROM products");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getInt("small"));
                    v2.add(rs.getInt("medium"));
                    v2.add(rs.getInt("large"));
                }
                df.addRow(v2);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pSmall = new javax.swing.JTextField();
        pMed = new javax.swing.JTextField();
        pLg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JComboBox<>();
        jComboBoxMenu = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product id", "Name", "Category", "Price Small", "Price Medium", "Price Large"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Name:");

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 204, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Category:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product Price:");

        pSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pSmallActionPerformed(evt);
            }
        });

        pMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pMedActionPerformed(evt);
            }
        });

        pLg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pLgActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Small");

        jLabel7.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Medium");

        jLabel8.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Large");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Image");

        btnBrowse.setText("Browse Image");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        lblImage.setBackground(new java.awt.Color(0, 0, 0));
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Product Id#:");

        txtId.setEditable(true);
        txtId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "#" }));
        txtId.setToolTipText("");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jComboBoxMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Milktea", "Tea", "Frape", "Meal" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtName)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel6)
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel7)
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel8))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(pSmall, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(pMed, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(pLg, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxMenu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(91, 91, 91))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBrowse)
                        .addGap(77, 77, 77))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pSmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowse)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(102, 102, 102));
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Export as CSV");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel10.setText("Product Inventory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
                                      
      if (txtName.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Name Required!");
    } else if (jComboBoxMenu.getSelectedItem() == null || jComboBoxMenu.getSelectedItem().toString().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Category Required!");
    } else if (pSmall.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Price for Small Required!");
    } else if (pMed.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Price for Medium Required!");
    } else if (pLg.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Price for Large Required!");
    }else if (imagePath == null || imagePath.isEmpty()) {  // Check if image is selected
        JOptionPane.showMessageDialog(this, "Product Image Required!");
    } else {
        try {
            String name = txtName.getText();
            String category = jComboBoxMenu.getSelectedItem().toString();
            int small = Integer.parseInt(pSmall.getText());
            int medium = Integer.parseInt(pMed.getText());
            int large = Integer.parseInt(pLg.getText());
            
            // Set the destination folder and file name
            String destinationFolder = "media/";
            String destinationPath = destinationFolder + new File(imagePath).getName();
            
            // Create the destination folder if it doesn't exist
            File destDir = new File(destinationFolder);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            
            try {
                // Copy the image to the destination folder
                Files.copy(new File(imagePath).toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Save the relative path to the database
            pst = con.prepareStatement("INSERT INTO products (name, category, small, medium, large, image) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setInt(3, small);
            pst.setInt(4, medium);
            pst.setInt(5, large);
            pst.setString(6, destinationPath);  // Store relative path
            
            int k = pst.executeUpdate();
            
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Product added successfully!");
                txtName.setText("");
              jComboBoxMenu.setSelectedIndex(0); // Selects the first item
                pSmall.setText("");
                pMed.setText("");
                pLg.setText("");
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
             try {
    // Get the product name from the search text field
    String productName = txtSearch.getText().trim();
    
    // Prepare the query to fetch product details by name
    pst = con.prepareStatement("SELECT * FROM products WHERE name LIKE ?");
    pst.setString(1, "%" + productName + "%");
    rs = pst.executeQuery();
    
    // If a matching product is found, populate the text fields
    if (rs.next()) {
        txtId.setSelectedItem(rs.getString("id"));
        txtName.setText(rs.getString("name"));
        jComboBoxMenu.setSelectedItem(rs.getString("category"));
        pSmall.setText(rs.getString("small"));
        pMed.setText(rs.getString("medium"));
        pLg.setText(rs.getString("large"));
        
        // Load and display the image with path validation
        String basePath = new File("").getAbsolutePath() + "/";
        String imagePath = basePath + rs.getString("image");
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
        JOptionPane.showMessageDialog(this, "No product found with this name.");
        clearFields();  // Clear the text fields if no product is found
    }
} catch (SQLException ex) {
    Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
}

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
                                      
   if (txtName.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Name Required!");
    } else if (jComboBoxMenu.getSelectedItem() == null || jComboBoxMenu.getSelectedItem().toString().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Category Required!");
    } else if (pSmall.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Price for Small Required!");
    } else if (pMed.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Price for Medium Required!");
    } else if (pLg.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Product Price for Large Required!");
    } else {
        try {
            String name = txtName.getText();
            String category = jComboBoxMenu.getSelectedItem().toString();
            int small = Integer.parseInt(pSmall.getText());
            int medium = Integer.parseInt(pMed.getText());
            int large = Integer.parseInt(pLg.getText());
            int id = Integer.parseInt(txtId.getSelectedItem().toString());
            
            String destinationPath = null;

            // Check if a new image is selected
            if (imagePath != null && !imagePath.isEmpty()) {
                // Set the destination folder and file name
               String destinationFolder = "media/";
destinationPath = destinationFolder + new File(imagePath).getName();

// Store the relative path for consistent retrieval
destinationPath = destinationPath.replace("\\", "/");


                
                // Create the destination folder if it doesn't exist
                File destDir = new File(destinationFolder);
                if (!destDir.exists()) {
                    destDir.mkdirs();
                }
                
                try {
                    // Copy the image to the destination folder
                    Files.copy(new File(imagePath).toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // Update product with or without new image
            if (destinationPath != null) {
                pst = con.prepareStatement("UPDATE products SET name = ?, category = ?, small = ?, medium = ?, large = ?, image = ? WHERE id = ?");
                pst.setString(1, name);
                pst.setString(2, category);
                pst.setInt(3, small);
                pst.setInt(4, medium);
                pst.setInt(5, large);
                pst.setString(6, destinationPath); // Update the image path
                pst.setInt(7, id);
            } else {
                pst = con.prepareStatement("UPDATE products SET name = ?, category = ?, small = ?, medium = ?, large = ? WHERE id = ?");
                pst.setString(1, name);
                pst.setString(2, category);
                pst.setInt(3, small);
                pst.setInt(4, medium);
                pst.setInt(5, large);
                pst.setInt(6, id);
            }

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Updated Successfully");
                txtName.setText("");
                jComboBoxMenu.setSelectedIndex(0);
                pSmall.setText("");
                pMed.setText("");
                pLg.setText("");
                txtId.setSelectedIndex(0);
                lblImage.setIcon(null);
                imagePath = null;
                txtName.requestFocus();

                Fetch();
                LoadProductNo();
            }
        } catch (SQLException ex) {
            Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format. Please check the input values.");
    }//GEN-LAST:event_btnUpdateActionPerformed
  }
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
        String id = txtId.getSelectedItem().toString();
        
        pst = con.prepareStatement("DELETE FROM products WHERE id = ?");
        pst.setString(1, id);
        
        int k = pst.executeUpdate();
        
        if (k > 0) {
            JOptionPane.showMessageDialog(this, "Deleted Successfully");
            txtName.setText("");
            jComboBoxMenu.setSelectedIndex(0);
            pSmall.setText("");
            pMed.setText("");
            pLg.setText("");
            txtName.requestFocus();
            Fetch();
            LoadProductNo();
        } else {
            JOptionPane.showMessageDialog(this, "No matching product found!");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        Logger.getLogger(crudForm.class.getName()).log(Level.SEVERE, null, ex);
    }

        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
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
            // Get table model
            javax.swing.table.TableModel model = jTable1.getModel();
            
            // Write column names
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.print(model.getColumnName(i) + "\t");
            }
            writer.println(); // New line after columns

            // Write table rows
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.print(model.getValueAt(i, j) + "\t");
                }
                writer.println(); // New line after each row
            }

            javax.swing.JOptionPane.showMessageDialog(this, "Report exported successfully to " + fileToSave.getAbsolutePath());
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error exporting report: " + e.getMessage());
        }
    }
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void pSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pSmallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pSmallActionPerformed

    private void pMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pMedActionPerformed

    private void pLgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pLgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pLgActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new AdminDashboard().setVisible(true); // Open new frame
            dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    ImageIcon icon = new ImageIcon(filePath);
    Image image = icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
    lblImage.setIcon(new ImageIcon(image));
    
    // Store the file path for saving to the database
    imagePath = filePath;

}

    }//GEN-LAST:event_btnBrowseActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
      txtId.setEnabled(false);
    }//GEN-LAST:event_txtIdActionPerformed

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
            java.util.logging.Logger.getLogger(crudForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField pLg;
    private javax.swing.JTextField pMed;
    private javax.swing.JTextField pSmall;
    private javax.swing.JComboBox<String> txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
