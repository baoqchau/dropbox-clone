package com.amazonaws.samples;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
//import java.awt.List;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ye
 */
public class MainMenu extends javax.swing.JFrame {
	
	 // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private S3Services s3Services;
    private ExecutorService executor;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
    	this.s3Services = new S3Services("us-west-2", "dropbox-clone-cs4650");
    	ArrayList<String> directories;
    	
    	
      this.executor = Executors.newFixedThreadPool(30);
        setTitle("Dropbox Clone");
        initComponents();
        setResizable(false);
        //this.setTransferHandler(new FileListTransferHandler(jTable2));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Select Directory To Watch");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDirectory(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedFile(evt);
            }
        });

        jButton3.setText("Download");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadSelectedDirectory(evt);
            }
        });
        jButton4.setText("Exit");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitProgram(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Path"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Name"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        
        jScrollPane2.setViewportView(jTable2);
        jScrollPane3.setViewportView(jTable3);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup()
                		.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                		.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                	.addGroup(layout.createSequentialGroup()
                	    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addContainerGap())
        );

        setUpDownloadableDirectories();
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setUpDownloadableDirectories() {
      try {
        ArrayList<String> directories = this.s3Services.getDirectoriesInBucket();
    	for (int i=0; i < directories.size(); i++) {
    		addNewFileToTable(directories.get(i), this.jTable3);
    	}
      }catch (IOException e) {
    	e.printStackTrace();
      }
    }
    private void selectDirectory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Path dir = Paths.get(".");
        try{
        	 JFileChooser fileChooser = new JFileChooser();
             fileChooser.setCurrentDirectory(new java.io.File("."));
             fileChooser.setDialogTitle("Choose a directory");
             fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
             int showOpenDialog = fileChooser.showOpenDialog(this);
             if (showOpenDialog != JFileChooser.APPROVE_OPTION) return;
            //implement download 
             File watchDir = fileChooser.getSelectedFile();
        	 System.out.println(watchDir.getName());
        	 StringBuilder objectDir = new StringBuilder(watchDir.getName());
        	 objectDir.append("/");
             dir = Paths.get(watchDir.toString());
             File[] listOfFiles = watchDir.listFiles();
             for (int i=0; i < listOfFiles.length; i++) {
             if (listOfFiles[i].isFile()) {
            		 StringBuilder objectName = new StringBuilder();
            		 objectName.append(objectDir);
            		 objectName.append(listOfFiles[i].getName());
            		 addNewFileToTable(listOfFiles[i], this.jTable2);
            		 s3Services.upload(listOfFiles[i], objectName.toString());
            	}
            }
           executor.execute(new WatchDir(dir, true, this));
        }
        catch(Exception e) {
            
        }
 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteSelectedFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Delete selected row
        try{
            int i = jTable2.getSelectedRow();
            DefaultTableModel model = ((DefaultTableModel)jTable2.getModel());
            File deletedFile = new File(model.getValueAt(i, 2).toString());
            if (deletedFile.delete()) {
            	model.removeRow(i);
            } else {
            	JOptionPane.showMessageDialog(this, "Selected file cannot be deleted", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch(Exception e) {
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void addNewFileToDirectory(File file) {
      System.out.println(file.toString());
      addNewFileToTable(file, this.jTable2);
     // this.revalidate();
    }
    private void exitProgram(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.executor.shutdown();
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    public String sizeInKb(File importFile) {
    	double num = importFile.length();
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        String str;
        
        String sizeInKB = Double.toString(num) +"B";
        if(((num/1024)/1024)/1024  > 1) {
            num = ((num/1024)/1024)/1024;
            str = df.format(num);
            sizeInKB = str + "GB";
        } 
        else if((num/1024)/1024 > 1) {
            num = (num/1024)/1024;
            str = df.format(num);
            sizeInKB = str + "MB";
        }
        else if(num/1024 > 1) {
            num = num/1024;
            str = df.format(num);
            sizeInKB = str + "KB";
        }
        return sizeInKB;
    }
    
    public void downloadSelectedDirectory(java.awt.event.ActionEvent evt) {
    	 try{
             int i = jTable3.getSelectedRow();
             DefaultTableModel model = ((DefaultTableModel)jTable3.getModel());
             String selectedDirectory = model.getValueAt(i, 0).toString();
             JFileChooser fileChooser = new JFileChooser();
             fileChooser.setCurrentDirectory(new java.io.File("."));
             fileChooser.setDialogTitle("Choose a directory");
             fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
             int showOpenDialog = fileChooser.showOpenDialog(this);
             if (showOpenDialog != JFileChooser.APPROVE_OPTION) return;
            //implement download 
             File destinationDir = fileChooser.getSelectedFile();
             s3Services.downloadFileFromDirectory(selectedDirectory, destinationDir.toString());
         } 
         catch(Exception e) {
             
         }
    }
    
    public void addNewFileToTable(File importFile, JTable jTable) {
    	DefaultTableModel tableModel = (DefaultTableModel)jTable.getModel();
        String Name = importFile.getName();
        String type = Name.substring(importFile.getName().lastIndexOf('.'));
        String path = importFile.getPath();
        tableModel.addRow(new Object[] {Name ,type, path});
    }
    
    public void addNewFileToTable(String Name, JTable jTable) {
    	DefaultTableModel tableModel = (DefaultTableModel)jTable.getModel();
        tableModel.addRow(new Object[] {Name});
    }
    
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
}

