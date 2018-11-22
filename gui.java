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
<<<<<<< HEAD
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
		
=======
	JPanel panel;
	JTable table;
	
	public void gui() {
		setTitle("MyCloud");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 250);
		setResizable(true);
		
		panel = new JPanel();
		buildPanel();
		add(panel);	
		setVisible(true);
	}
	public void buildPanel()
	{
		MyTableModel model = new MyTableModel();
		table = new JTable(model);
>>>>>>> fa16ffc81802ee31698d85084c4ab64109aeb762
		download = new JButton("Download");
		delete = new JButton("Delete");
		exit = new JButton("Exit");
		
<<<<<<< HEAD
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

=======
		
		panel.add(table);
		panel.add(download);
		panel.add(delete);
		panel.add(exit);
		
		
		
>>>>>>> fa16ffc81802ee31698d85084c4ab64109aeb762
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
<<<<<<< HEAD
		add(panel);	
		setVisible(true);
		//pack();
	}
   
=======
		
		
		
		FlowLayout layout = new FlowLayout();
		Container pane = getContentPane();
		panel.setLayout(layout);
	}
	
	class MyTableModel extends AbstractTableModel {
		ArrayList<String> header = new ArrayList<>(Arrays.asList("File Name", "Size", "Type"));
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		
		public int getColumnCount() {
			return header.size();
		}
		public int getRowCount() {
			return data.size();
		}

		public String getColumnName(int col) {
			return header.get(col);
		}
		public Object getValueAt(int row, int col) {
			return (data.get(row)).get(col);
		}
		public Class getColumnClass(int c) {
			switch(c){
				case 0:
					return String.class;
				case 1:
					return int.class;
				case 2: 
					return String.class;
				default:
					return String.class;
			}
		}
		public boolean isCellEditable(int row, int column) {
			switch(column) {
				case 0:
					return false;
				case 1: 
					return false;
				default:
					return true;
			}
		}
		public void setValueAt(Object value, int row, int col) {
            (data.get(row)).set(col,value);
            fireTableCellUpdated(row, col);
        }
		public void addRow(String name, int size, String type) {
			ArrayList<Object> nList = new ArrayList<Object>(Arrays.asList(name, size, type));
			for(int i = 0; i < header.size() - 5; i++) {
				nList.add(null);
			}
			data.add(nList);
			fireTableStructureChanged();
			fireTableDataChanged();
		}
		public void removeRow(int row) {
			data.remove(row);
			fireTableDataChanged();
		}
		public void removeCol(String id) {
			int index = header.indexOf(id);
			header.remove(index);
			for(int i = 0; i < data.size(); i++) {
				data.get(i).remove(index);
			}
			fireTableDataChanged();
			fireTableStructureChanged();
		}
    }
>>>>>>> fa16ffc81802ee31698d85084c4ab64109aeb762
	public static void main(String args[]) 
	{
		new gui();
	}
<<<<<<< HEAD
=======
	
>>>>>>> fa16ffc81802ee31698d85084c4ab64109aeb762
}