/**
*GUI for DropBox like application
*CS4650
*11/18/2018
**/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;

public class login extends JFrame {
	
	JLabel idPrompt, passwordPrompt;
	JTextField idTextField;
	JPasswordField passwordTextField;
	JButton loginButton, cancel;
	JPanel panel;
	
	public login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setResizable(true);
		
		panel = new JPanel();
		buildPanel();
		add(panel);	
		setVisible(true);
	}
	public void buildPanel()
	{
		idPrompt = new JLabel("ID:");
		passwordPrompt = new JLabel("Password:");
		
		idTextField = new JTextField(20);
		passwordTextField = new JPasswordField(16);
	
		loginButton = new JButton("Log In");
		cancel = new JButton("Cancel");
		
		panel.add(idPrompt);
		panel.add(idTextField);
		panel.add(passwordPrompt);
		panel.add(passwordTextField);
		panel.add(loginButton);
		panel.add(cancel);
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check if username and passwords are correct;
			}
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		FlowLayout layout = new FlowLayout();
		//GridLayout layout = new GridLayout(3,2);
		Container pane = getContentPane();
		panel.setLayout(layout);
		
	
	}
<<<<<<< HEAD

=======
	
>>>>>>> fa16ffc81802ee31698d85084c4ab64109aeb762
	public static void main(String args[]) 
	{
		new login();
	}
}