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


public class gui extends JFrame {
	
	JButton download, delete, exit;
	JPanel panel, buttons;
	JTable table;
	
	public gui() {
		setTitle("MyCloud");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		setSize(800, 475);
		setResizable(false);
		
		panel = new JPanel();
		buttons = new JPanel();
		BoxLayout layout = new BoxLayout(buttons, BoxLayout.Y_AXIS);
		buttons.setLayout(layout);
		
		String[] columnNames= {"File Name", "Size", "Type"};
		String[][] data = {{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"},
							{"example", "0", "example"}};
		table = new JTable(data, columnNames);
		JScrollPane scroll = new JScrollPane(table);
		
		download = new JButton("Download");
		delete = new JButton("Delete");
		exit = new JButton("Exit");
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH ;
		c.gridwidth = 3;
		c.gridheight = 5;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(scroll, c);
		
		
		c.gridwidth = 4;
		c.gridheight = 1;
		buttons.add(download);
		buttons.add(delete);
		buttons.add(exit);
		
		
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 4;
		c.gridy = 0;
		
		panel.add(buttons, c);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check if username and passwords are correct;
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(panel);	
		setVisible(true);
		//pack();
	}
   
	public static void main(String args[]) 
	{
		new gui();
	}
}