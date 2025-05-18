/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.print.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.print.PrintService;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductMenuCashier extends javax.swing.JFrame {
    
    private javax.swing.JTextField txtID;
    private String imagePath;
    private HashMap<String, Integer> priceCountMap = new HashMap<>();
    private HashMap<String, Integer> productCountMap = new HashMap<>();
    private int totalPrice = 0;
    private Stack<String> actionStack = new Stack<>();
    private int currentCashierId;

    
    
    public ProductMenuCashier() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
        textArea.setEnabled(false);
        
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
                    v2.add(rs.getInt("quantity"));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ProductName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ProductCategory = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        small = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        medium = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        large = new javax.swing.JTextField();
        smallBtn = new javax.swing.JButton();
        mediumBtn = new javax.swing.JButton();
        largeBtn = new javax.swing.JButton();
        txtId = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCash = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtChange = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();
        txtPrint = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtPrint1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product id#", "Product Name", "Category", "Small", "Medium", "Large"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Name:");

        ProductName.setEditable(false);
        ProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Category:");

        ProductCategory.setEditable(false);
        ProductCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductCategoryActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Product ID:");

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price SMALL");

        small.setEditable(false);
        small.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price MEDIUM");

        medium.setEditable(false);
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price LARGE");

        large.setEditable(false);
        large.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeActionPerformed(evt);
            }
        });

        smallBtn.setBackground(new java.awt.Color(0, 153, 0));
        smallBtn.setForeground(new java.awt.Color(255, 255, 255));
        smallBtn.setText("Buy SMALL");
        smallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallBtnActionPerformed(evt);
            }
        });

        mediumBtn.setBackground(new java.awt.Color(0, 0, 102));
        mediumBtn.setForeground(new java.awt.Color(255, 255, 255));
        mediumBtn.setText("Buy MEDIUM");
        mediumBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumBtnActionPerformed(evt);
            }
        });

        largeBtn.setBackground(new java.awt.Color(153, 0, 0));
        largeBtn.setForeground(new java.awt.Color(255, 255, 255));
        largeBtn.setText("Buy LARGE");
        largeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeBtnActionPerformed(evt);
            }
        });

        txtId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(large, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medium, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(small, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(smallBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mediumBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(largeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(mediumBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(small, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(smallBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medium, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(large, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(largeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Order Summary");

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setText("\n\n\n\n\n\n\n\n\n\n\n");
        jScrollPane2.setViewportView(textArea);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel8.setText("Total :");

        txtTotal.setEditable(false);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel9.setText("Cash Given:");

        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel10.setText("Change :");

        txtChange.setEditable(false);

        btnPay.setBackground(new java.awt.Color(0, 153, 0));
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("PAY");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        txtPrint.setBackground(new java.awt.Color(51, 51, 51));
        txtPrint.setForeground(new java.awt.Color(255, 255, 255));
        txtPrint.setText("Print Reciept");
        txtPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrintActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Undo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Pay Gcash");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtPrint1.setBackground(new java.awt.Color(51, 51, 51));
        txtPrint1.setForeground(new java.awt.Color(255, 255, 255));
        txtPrint1.setText("Transaction History");
        txtPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrint1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCash))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jLabel11.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jLabel11.setText("Order Menu");

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("© 2025 Cafe 25th. All rights reserved.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 152, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSearch)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 38, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        txtId.setEnabled(false);        
    }//GEN-LAST:event_txtIdActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
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
        ProductName.setText(rs.getString("name"));
        ProductCategory.setText(rs.getString("category"));
        small.setText(rs.getString("small"));
        medium.setText(rs.getString("medium"));
        large.setText(rs.getString("large"));
        
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

    
    }//GEN-LAST:event_searchBtnActionPerformed

    private void smallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallBtnActionPerformed
    // Get product name and size from text fields
    String productName = ProductName.getText();
    String size = "Small"; // Assuming this button is for Small size
    String priceText = small.getText(); // Get price from the small text field

    // Combine name and size for the key
    String productKey = productName + " " + size;

    // Check if the product name and price are not empty
    if (!productName.isEmpty() && !priceText.isEmpty()) {
        try {
            // Convert the price to an integer
            int price = Integer.parseInt(priceText);

            // Update the count in the map
            productCountMap.put(productKey, productCountMap.getOrDefault(productKey, 0) + 1);

            // Add the action to the stack for undo functionality
            actionStack.push(productKey + ":" + price);

            // Add the price to the total
            totalPrice += price;

            // Clear the text area first
            textArea.setText("");

            // Display all products with their counts
            for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
                String key = entry.getKey();
                int count = entry.getValue();
                textArea.append(key + "   " + count + "x\n");
            }

            // Update the total price in txtTotal
            txtTotal.setText(String.valueOf(totalPrice));

        } catch (NumberFormatException e) {
            // If the input is not a valid number, show an error message
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        }
    } else {
        // If product name or price is empty, show a message dialog
        JOptionPane.showMessageDialog(this, "Please enter a product name and price.");
    }
    }//GEN-LAST:event_smallBtnActionPerformed

    private void mediumBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumBtnActionPerformed
    // Get product name and size from text fields
    String productName = ProductName.getText();
    String size = "Medium"; // Assuming this button is for Small size
    String priceText = medium.getText(); // Get price from the small text field

    // Combine name and size for the key
    String productKey = productName + " " + size;

    // Check if the product name and price are not empty
    if (!productName.isEmpty() && !priceText.isEmpty()) {
        try {
            // Convert the price to an integer
            int price = Integer.parseInt(priceText);

            // Update the count in the map
            productCountMap.put(productKey, productCountMap.getOrDefault(productKey, 0) + 1);

            // Add the action to the stack for undo functionality
            actionStack.push(productKey + ":" + price);

            // Add the price to the total
            totalPrice += price;

            // Clear the text area first
            textArea.setText("");

            // Display all products with their counts
            for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
                String key = entry.getKey();
                int count = entry.getValue();
                textArea.append(key + "   " + count + "x\n");
            }

            // Update the total price in txtTotal
            txtTotal.setText(String.valueOf(totalPrice));

        } catch (NumberFormatException e) {
            // If the input is not a valid number, show an error message
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        }
    } else {
        // If product name or price is empty, show a message dialog
        JOptionPane.showMessageDialog(this, "Please enter a product name and price.");
    }   
    }//GEN-LAST:event_mediumBtnActionPerformed

    private void largeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largeBtnActionPerformed
     // Get product name and size from text fields
    String productName = ProductName.getText();
    String size = "Large"; // Assuming this button is for Small size
    String priceText = large.getText(); // Get price from the small text field

    // Combine name and size for the key
    String productKey = productName + " " + size;

    // Check if the product name and price are not empty
    if (!productName.isEmpty() && !priceText.isEmpty()) {
        try {
            // Convert the price to an integer
            int price = Integer.parseInt(priceText);

            // Update the count in the map
            productCountMap.put(productKey, productCountMap.getOrDefault(productKey, 0) + 1);

            // Add the action to the stack for undo functionality
            actionStack.push(productKey + ":" + price);

            // Add the price to the total
            totalPrice += price;

            // Clear the text area first
            textArea.setText("");

            // Display all products with their counts
            for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
                String key = entry.getKey();
                int count = entry.getValue();
                textArea.append(key + "   " + count + "x\n");
            }

            // Update the total price in txtTotal
            txtTotal.setText(String.valueOf(totalPrice));

        } catch (NumberFormatException e) {
            // If the input is not a valid number, show an error message
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        }
    } else {
        // If product name or price is empty, show a message dialog
        JOptionPane.showMessageDialog(this, "Please enter a product name and price.");
    }  
    }//GEN-LAST:event_largeBtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         if (!actionStack.isEmpty()) {
        // Get the last action
        String lastAction = actionStack.pop();

        // Split to get productKey and price
        String[] parts = lastAction.split(":");
        String productKey = parts[0];
        int price = Integer.parseInt(parts[1]);

        // Decrease the count in productCountMap
        int currentCount = productCountMap.getOrDefault(productKey, 0);
        if (currentCount > 1) {
            productCountMap.put(productKey, currentCount - 1);
        } else {
            productCountMap.remove(productKey);
        }

        // Subtract the price from the total
        totalPrice -= price;
        if (totalPrice < 0) totalPrice = 0; // Just a safety check

        // Clear the text area first
        textArea.setText("");
        txtChange.setText("");
        // Display all products with their updated counts
        for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            textArea.append(key + "   " + count + "x\n");
        }

        // Update the total price in txtTotal
        txtTotal.setText(String.valueOf(totalPrice));
    } else {
        JOptionPane.showMessageDialog(this, "No actions to undo.");
    }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void ProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameActionPerformed
      
    }//GEN-LAST:event_ProductNameActionPerformed

    private void ProductCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductCategoryActionPerformed
        
    }//GEN-LAST:event_ProductCategoryActionPerformed

    private void smallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallActionPerformed
        
    }//GEN-LAST:event_smallActionPerformed

    private void mediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumActionPerformed
       
    }//GEN-LAST:event_mediumActionPerformed

    private void largeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largeActionPerformed
        
    }//GEN-LAST:event_largeActionPerformed

    private void txtCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashActionPerformed
      
      
      
    }//GEN-LAST:event_txtCashActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        try {
        // Get total cost and cash given
        int totalCost = Integer.parseInt(txtTotal.getText().trim());
        int cashGiven = Integer.parseInt(txtCash.getText().trim());

        // Calculate change
        int change = cashGiven - totalCost;

        // Check if cash given is enough
        if (change >= 0) {
            // Display change
            txtChange.setText(String.valueOf(change));
        } else {
            // If cash is not enough, show an error message
            JOptionPane.showMessageDialog(this, "Insufficient cash! Customer needs to pay more.");
            txtChange.setText("0"); // Reset change display
        }

    } catch (NumberFormatException e) {
        // Handle invalid input (e.g., letters)
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for Cash.");
    }
    }//GEN-LAST:event_btnPayActionPerformed

    private void txtPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrintActionPerformed
    String url = "jdbc:mysql://localhost:3306/pos_system"; 
    String user = "root"; 
    String password = ""; 

    String items = textArea.getText().trim();
    String totalAmountStr = txtTotal.getText().trim();
    String cashGivenStr = txtCash.getText().trim();
    String changeGivenStr = txtChange.getText().trim();

    if (items.isEmpty() || totalAmountStr.isEmpty() || cashGivenStr.isEmpty() || changeGivenStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please complete the transaction first.");
        return;
    }

    int totalAmount, cashGiven, changeGiven;
    try {
        totalAmount = Integer.parseInt(totalAmountStr);
        cashGiven = Integer.parseInt(cashGivenStr);
        changeGiven = Integer.parseInt(changeGivenStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid input! Please enter numeric values for Total Amount, Cash Given, and Change.");
        return;
    }

    // Save transaction to database
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        String query = "INSERT INTO transactions (items, total_amount, cash_given, change_given) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, items);
            stmt.setInt(2, totalAmount);
            stmt.setInt(3, cashGiven);
            stmt.setInt(4, changeGiven);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Transaction saved successfully! Printing receipt...");
                printReceipt(items, totalAmount, cashGiven, changeGiven);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        e.printStackTrace();
    }
}
private void printReceipt(String items, int totalAmount, int cashGiven, int changeGiven) {
    PrinterJob job = PrinterJob.getPrinterJob();

    PageFormat pf = job.defaultPage();
    Paper paper = new Paper();
    double paperWidth = 185; 
    double paperHeight = 1500; 
    double margin = 5; 
    paper.setSize(paperWidth, paperHeight);
    paper.setImageableArea(margin, margin, paperWidth - (2 * margin), paperHeight - (1 * margin));
    pf.setPaper(paper);

    job.setPrintable((Graphics g, PageFormat pageFormat, int pageIndex) -> {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 8));
        FontMetrics fm = g2d.getFontMetrics();

        int paperCenter = (int) (pageFormat.getImageableWidth() / 2);

        // Print Header
        String header = "Cafe 25th Coffee & Tea";
        int headerWidth = fm.stringWidth(header);
        g2d.drawString(header, paperCenter - (headerWidth / 2), 20);

        g2d.drawString("------------------------------", 10, 35);

        // Print Items
        int y = 50;
        g2d.drawString("Items:", 10, y);
        y += 15;
        for (String line : items.split("\\n")) {
            g2d.drawString(line, 10, y);
            y += 15;
        }
        g2d.drawString("------------------------------", 10, y);
        y += 15;

        // Print Totals
        g2d.drawString(String.format("Total:      ₱%-10d", totalAmount), 10, y);
        y += 15;
        g2d.drawString(String.format("Cash Given: ₱%-10d", cashGiven), 10, y);
        y += 15;
        g2d.drawString(String.format("Change:     ₱%-10d", changeGiven), 10, y);
        y += 15;

        g2d.drawString("------------------------------", 10, y);
        y += 15;

        // Print Coffee Shop Address
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 7)); // Smaller font for address
        fm = g2d.getFontMetrics(); // Update font metrics

        String address1 = "#64 Camarin Road, 1420 North";
        String address2 = "Caloocan City";
        int address1Width = fm.stringWidth(address1);
        int address2Width = fm.stringWidth(address2);

        g2d.drawString(address1, paperCenter - (address1Width / 2), y);
        y += 15;
        g2d.drawString(address2, paperCenter - (address2Width / 2), y);

        return Printable.PAGE_EXISTS;
    }, pf);

    try {
        job.print();
    } catch (PrinterException e) {
        System.err.println("Error printing receipt: " + e.getMessage());
    }
    }//GEN-LAST:event_txtPrintActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       new gcashQr().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int choice = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to log out?", 
            "Logout Confirmation", 
            JOptionPane.YES_NO_OPTION);
    
    if (choice == JOptionPane.YES_OPTION) {
        // Close the current window
        this.dispose();
        
        // Redirect to Login Screen
        LoginForm login = new LoginForm();
        login.setVisible(true);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrint1ActionPerformed
      new SalesReportCashier().setVisible(true);
      dispose();
    }//GEN-LAST:event_txtPrint1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductMenuCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductMenuCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductMenuCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductMenuCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductMenuCashier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ProductCategory;
    private javax.swing.JTextField ProductName;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField large;
    private javax.swing.JButton largeBtn;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField medium;
    private javax.swing.JButton mediumBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField small;
    private javax.swing.JButton smallBtn;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtChange;
    private javax.swing.JComboBox<String> txtId;
    private javax.swing.JButton txtPrint;
    private javax.swing.JButton txtPrint1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JTextField small() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class productCountMap {

        private static int getOrDefault(String productKey, int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static Iterable<Map.Entry<String, Integer>> entrySet() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void put(String productKey, int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public productCountMap() {
        }
    }
}
