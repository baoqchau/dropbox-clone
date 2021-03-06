package com.amazonaws.samples;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.awt.List;
import java.awt.datatransfer.DataFlavor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.transfer.MultipleFileDownload;
import com.amazonaws.services.s3.transfer.TransferManager;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends javax.swing.JFrame {
	
	 // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_above;
    private S3Services s3Services;
    private ExecutorService executor;
    private JTable table_below;
    private JPasswordField passwordField;
    private JLabel lblStatus;
    private S3Services download;
    /**
     * @wbp.nonvisual location=993,411
     */
    private final Scrollbar scrollbar = new Scrollbar();
    // End of variables declaration//GEN-END:variables
    
    public MainMenu() {
    	setResizable(false);
    	this.s3Services = new S3Services("us-west-2", "dropbox-clone-cs4650");
    	
 //   	System.out.println(s3Services.GetObject().);
    	
      this.executor = Executors.newFixedThreadPool(30);
        setTitle("Dropbox Clone");
        initComponents();
        this.setTransferHandler(new FileListTransferHandler(table_above)); //LOCAL
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
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_above = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //BUTTON
        
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

        jButton3.setText("Exit");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        //LOCAL
        
        table_above.setModel(new javax.swing.table.DefaultTableModel(
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
        
        
        
        jScrollPane2.setViewportView(table_above);

//        jButton4.setText("Upload");
//        jButton4.setActionCommand("");
//        jButton4.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton4ActionPerformed(evt);
//            }
//        });

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        String initialText = "Program Started!\n Please enter password!";
        JTextArea textArea = new JTextArea("Program Started!\nPlease enter password!");
        
        passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//JPasswordField in = (JPasswordField)e.getSource();
        		//char[] password = passwordField.getPassword();
        		char[] password = passwordField.getPassword();
        		char[] pass = {'b','a'};
        		String ss = new String(password);
        		boolean ret = Arrays.equals(password, pass);
        		if (ret) {
        			textArea.append("\nCorrect! Access granted");
        		} else {
        			textArea.append("\nWrong Password");
        		}
        	}
        });
        
        
        JLabel lblPassword = new JLabel("PASSWORD:");
        lblPassword.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 13));
        
        lblStatus = new JLabel("STATUS:");
        lblStatus.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 13));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        				.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        				.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        				.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        				.addComponent(passwordField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        				.addComponent(lblPassword)
        				.addComponent(textArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        				.addComponent(lblStatus))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(24)
        							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addComponent(lblPassword))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblStatus)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
        			.addGap(20))
        );
        
        table_below = new JTable();
        
        table_below.setModel(new javax.swing.table.DefaultTableModel(
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
        
        scrollPane.setViewportView(table_below);
        getContentPane().setLayout(layout);
        pack();
        
        //DOWNLOAD FROM S3 TO LOCAL
        
	  	TransferManager transferManager = new TransferManager();
	  	File dir = new File("MyLocalFolder"); //MKDIR IN eclipse-workspace
	  	MultipleFileDownload download = transferManager.downloadDirectory("dropbox-clone-cs4650", "", dir);

	  	File S3 = new File("***MY LOCAL FOLER DIR***"); //LOCAL DIR /Users/JIN/eclipse-workspace/TeamProject 
	  	File[] S3Files = S3.listFiles();

	  	for (File f1 : S3Files) {
	  		if(f1.isDirectory()) {System.out.println("FOLDER"+f1.getName());}
	  		if(f1.isFile()) {DownloadNewFileToTable(f1);}
	  		else {textArea.append("\n"+f1.toString());}
	  	}
	  	
	  	FileFilter fileFilter = new FileFilter() {
	  		public boolean accept(File file) {
	  			return file.isDirectory();
	  		}
	  	};
	  	S3Files=S3.listFiles(fileFilter);
	  	System.out.println(S3Files.length+" Files");
    }// </editor-fold>//GEN-END:initComponents

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
            		 addNewFileToTable(listOfFiles[i]);
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
            int i = table_above.getSelectedRow();
            DefaultTableModel model = ((DefaultTableModel)table_above.getModel());
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
      addNewFileToTable(file);
     // this.revalidate();
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
    
    public void addNewFileToTable(File importFile) {
    	DefaultTableModel tableModel = (DefaultTableModel)table_above.getModel();
        String Name = importFile.getName();
        String type = Name.substring(importFile.getName().lastIndexOf('.'));
        String path = importFile.getPath();
        tableModel.addRow(new Object[] {Name ,type, path});
    }
    
    public void DownloadNewFileToTable(File importFile) {
    	DefaultTableModel tableModel = (DefaultTableModel)table_below.getModel();
        String Name = importFile.getName();
        String type = Name.substring(importFile.getName().lastIndexOf('.'));
        String path = importFile.getPath();
        tableModel.addRow(new Object[] {Name ,type, path});
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
class FileListTransferHandler extends TransferHandler {
    private JTable table;

    public FileListTransferHandler(JTable list) {
      this.table = list;
    }

    public int getSourceActions(JComponent c) {
      return COPY_OR_MOVE;
    }

    public boolean canImport(TransferSupport ts) {
      return ts.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
    }
    public boolean importData(TransferSupport ts) {
        try {
            String dir = ts.getTransferable().getTransferData(DataFlavor.javaFileListFlavor).toString();
            dir = dir.substring(1, dir.length()- 1);
            System.out.println(dir);

            DecimalFormat df = new DecimalFormat("#.#");
            df.setRoundingMode(RoundingMode.CEILING);
            //parsing directory names and converting them into file array
            List<File> fileList = new ArrayList<>();

            int lastComma = 0;
            for(int i = 2; i < dir.length(); i++) {
                //System.out.println(dir.substring(i-2,i));
                if(dir.substring(i-2,i).equals(", ")) {
                    File file = new File(dir.substring(lastComma,i-2));
                    fileList.add(file);
                    lastComma = i; 
                }
            }
            File file = new File(dir.substring(lastComma, dir.length()));
            fileList.add(file);

            System.out.println(fileList.toString());
            if(fileList.size() < 1) {
               return false;
            }
            DefaultTableModel tableModel = (DefaultTableModel)table_above.getModel();

            for(int i = 0; i < fileList.size(); i++) {
                File curFile = fileList.get(i);
                double num = curFile.length();
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


                String Name = curFile.getName();
                String type = Name.substring(fileList.get(i).getName().lastIndexOf('.'));
                String path = curFile.getPath();
                tableModel.addRow(new Object[] {Name ,sizeInKB ,type, path});
            }
            return true;
        } catch (UnsupportedFlavorException e) {
            return false;
        } catch (IOException e) {
            return false;
    }
   }
}
}