/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductMenu extends javax.swing.JFrame {
    
    private javax.swing.JTextField txtID;
    private String imagePath;
    private HashMap<String, Integer> priceCountMap = new HashMap<>();
    private HashMap<String, Integer> productCountMap = new HashMap<>();
    private int totalPrice = 0;
    private Stack<String> actionStack = new Stack<>();

    
    
    public ProductMenu() {
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
        jPanel4 = new javax.swing.JPanel();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

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
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn7.setBackground(new java.awt.Color(153, 153, 153));
        btn7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(153, 153, 153));
        btn8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(153, 153, 153));
        btn9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(153, 153, 153));
        btn4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(153, 153, 153));
        btn5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(153, 153, 153));
        btn6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(153, 153, 153));
        btn1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(153, 153, 153));
        btn3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(153, 153, 153));
        btn2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn0.setBackground(new java.awt.Color(153, 153, 153));
        btn0.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(153, 153, 153));
        btnDel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnDel.setText("Del");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(smallBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mediumBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                            .addComponent(largeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(14, 20, Short.MAX_VALUE)
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Order Summary");

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        jLabel8.setText("Total :");

        txtTotal.setEditable(false);

        jLabel9.setText("Cash Given:");

        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });

        jLabel10.setText("Change :");

        txtChange.setEditable(false);

        btnPay.setBackground(new java.awt.Color(0, 102, 0));
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("PAY");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        txtPrint.setBackground(new java.awt.Color(51, 51, 51));
        txtPrint.setForeground(new java.awt.Color(255, 255, 255));
        txtPrint.setText("Save Reciept");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCash)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChange)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Order Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(271, 271, 271)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearch)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      new AdminDashboard().setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
        // Database connection details
    String url = "jdbc:mysql://localhost:3306/pos_system"; 
    String user = "root"; 
    String password = ""; 

    // Get all the information
    String items = textArea.getText().trim();
    String totalAmount = txtTotal.getText().trim();
    String cashGiven = txtCash.getText().trim();
    String changeGiven = txtChange.getText().trim();

    // Check if all fields are filled
    if (items.isEmpty() || totalAmount.isEmpty() || cashGiven.isEmpty() || changeGiven.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please complete the transaction first.");
        return;
    }

    // Display receipt (optional)
    JOptionPane.showMessageDialog(this, 
        "Receipt:\n" + 
        "Items:\n" + items + 
        "\nTotal: " + totalAmount + 
        "\nCash Given: " + cashGiven + 
        "\nChange: " + changeGiven);

    // Save to database
    try {
        Connection conn = DriverManager.getConnection(url, user, password);
        String query = "INSERT INTO transactions (items, total_amount, cash_given, change_given) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);

        // Set parameters
        stmt.setString(1, items);
        stmt.setInt(2, Integer.parseInt(totalAmount));
        stmt.setInt(3, Integer.parseInt(cashGiven));
        stmt.setInt(4, Integer.parseInt(changeGiven));

        // Execute the insert
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Transaction saved and printed successfully!");
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error saving transaction: " + e.getMessage());
    }
    }//GEN-LAST:event_txtPrintActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
       txtCash.setText(txtCash.getText() + "0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
         txtCash.setText(txtCash.getText() + "1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        txtCash.setText(txtCash.getText() + "2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
         txtCash.setText(txtCash.getText() + "3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
         txtCash.setText(txtCash.getText() + "4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
         txtCash.setText(txtCash.getText() + "5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
         txtCash.setText(txtCash.getText() + "6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
         txtCash.setText(txtCash.getText() + "7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
         txtCash.setText(txtCash.getText() + "8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        txtCash.setText(txtCash.getText() + "9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // Get the current text from txtCash
    String currentText = txtCash.getText();
    
    // Check if the text is not empty
    if (currentText.length() > 0) {
        // Remove the last character
        txtCash.setText(currentText.substring(0, currentText.length() - 1));
    }
    }//GEN-LAST:event_btnDelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       new QrCode().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ProductCategory;
    private javax.swing.JTextField ProductName;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel4;
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
