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
		download = new JButton("Download");
		delete = new JButton("Delete");
		exit = new JButton("Exit");
		
		
		panel.add(table);
		panel.add(download);
		panel.add(delete);
		panel.add(exit);
		
		
		
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
	public static void main(String args[]) 
	{
		new gui();
	}
	
}