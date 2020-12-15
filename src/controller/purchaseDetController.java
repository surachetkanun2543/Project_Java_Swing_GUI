package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.purchaseDAO;
import dao.purchaseDetDAO;

public class purchaseDetController extends JPanel {
	
	JTextField txtId , txtstatus ;

	public purchaseDetController() {

		setPreferredSize(new Dimension(1200, 800));
		setOpaque(true);
		setBackground(new java.awt.Color(255, 255, 255));
		setLayout(null);

		Object[] columns = { "PURCHASE_ID", "SUPPLIER_ID", "GOOD_ID", "GOOD_NAME", "PURCHASE_DATE", "RECEIVE_DATE",
				"STATUS", "QUANTITY", "TOTAL_AMOUNT" };

		Border border = new LineBorder(Color.white, 2, true);

		JScrollPane scrollPane = new JScrollPane();
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		table.getTableHeader().setFont(new Font("TimesRoman", Font.BOLD, 15));
		table.getTableHeader().setBackground(new Color(133, 30, 36));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setFont(new Font("TimesRoman", Font.BOLD, 15));
		table.setGridColor(new java.awt.Color(255, 255, 255));
		table.setRowHeight(25);
		table.setModel(model);
		table.setBorder(border);
		table.setBackground(new java.awt.Color(255, 255, 255));

		model.setColumnIdentifiers(columns);
		scrollPane.setBounds(40, 110, 1100, 200);
		scrollPane.setFont(new java.awt.Font("sans-serif", 10, 15));
		scrollPane.setViewportView(table);
		scrollPane.setBackground(new java.awt.Color(255, 255, 255));
		scrollPane.setBorder(border);
		add(scrollPane);

		try {

			ArrayList<HashMap<String, String>> purchaseDetlist = new purchaseDetDAO().findAll();
			for (int i = 0; i < purchaseDetlist.size(); i++) {

				model.addRow(new Object[0]);
				model.setValueAt(purchaseDetlist.get(i).get("PURCHASE_ID"), i, 0);
				model.setValueAt(purchaseDetlist.get(i).get("SUPPLIER_ID"), i, 1);
				model.setValueAt(purchaseDetlist.get(i).get("GOOD_ID"), i, 2);
				model.setValueAt(purchaseDetlist.get(i).get("GOOD_NAME"), i, 3);
				model.setValueAt(purchaseDetlist.get(i).get("PURCHASE_DATE"), i, 4);
				model.setValueAt(purchaseDetlist.get(i).get("RECEIVE_DATE"), i, 5);
				model.setValueAt(purchaseDetlist.get(i).get("STATUS"), i, 6);
				model.setValueAt(purchaseDetlist.get(i).get("QUANTITY"), i, 7);
				model.setValueAt(purchaseDetlist.get(i).get("TOTAL_AMOUNT"), i, 8);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Border border1 = new LineBorder(Color.red, 2, true);
		
		txtId = new JTextField();
		txtId.setBounds(190, 355, 145, 25);
		txtId.setBorder(border1);
		add(txtId);
		
		JLabel labelheader = new JLabel("RECEIVE");
		labelheader.setFont(new Font("Segoe UI", Font.BOLD, 25));
		labelheader.setBounds(50, 20, 150, 50);
		labelheader.setForeground(new java.awt.Color(255, 163, 43));
		add(labelheader);
		
		JLabel labelpurchase_Id = new JLabel("PURCHASE ID");
		labelpurchase_Id.setFont(new java.awt.Font("Segoe UI", 120, 17));
		labelpurchase_Id.setBounds(50, 350, 120, 35);
		labelpurchase_Id.setForeground(new java.awt.Color(255, 0, 0));
		add(labelpurchase_Id);
		
		JButton btnInsert = new JButton("UPDATE STATUS");
		btnInsert.setBounds(360, 355, 120, 30);
		btnInsert.setForeground(new java.awt.Color(255, 255, 255));
		btnInsert.setBackground(new java.awt.Color(92, 184, 92));
		btnInsert.setBorder(null);
		add(btnInsert);
		
		JButton btnDelete = new JButton("CANCEL STATUS");
		btnDelete.setBounds(360, 410, 120, 30);
		btnDelete.setForeground(new java.awt.Color(255, 255, 255));
		btnDelete.setBackground(new java.awt.Color(217, 83, 79));
		btnDelete.setBorder(null);
		add(btnDelete);
		
		JPanel panelup1 = new JPanel();
		panelup1.setBackground(new Color	(34,34,34));
		panelup1.setBounds(0, 0, 491, 1000);
		add(panelup1);
		panelup1.setLayout(null);
		
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				purchaseDetDAO purchaseDetDAO = new purchaseDetDAO();
				try {
					model.setRowCount(0);

					purchaseDetDAO.Insert(
							Integer.parseInt(txtId.getText()));
							

					
					purchaseDetDAO.Insert2(
							Integer.parseInt(txtId.getText()));
							
					
					ArrayList<HashMap<String, String>> purchaseDetlist = new purchaseDetDAO().findAll();
					for (int i = 0; i < purchaseDetlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(purchaseDetlist.get(i).get("PURCHASE_ID"), i, 0);
						model.setValueAt(purchaseDetlist.get(i).get("SUPPLIER_ID"), i, 1);
						model.setValueAt(purchaseDetlist.get(i).get("GOOD_ID"), i, 2);
						model.setValueAt(purchaseDetlist.get(i).get("GOOD_NAME"), i, 3);
						model.setValueAt(purchaseDetlist.get(i).get("PURCHASE_DATE"), i, 4);
						model.setValueAt(purchaseDetlist.get(i).get("RECEIVE_DATE"), i, 5);
						model.setValueAt(purchaseDetlist.get(i).get("STATUS"), i, 6);
						model.setValueAt(purchaseDetlist.get(i).get("QUANTITY"), i, 7);
						model.setValueAt(purchaseDetlist.get(i).get("TOTAL_AMOUNT"), i, 8);

					}
					
					txtId.setText(null);


				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("INSERT RECEIVE SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "INSERT RECEIVE SUCCESS !!");

			}
		});
		
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				purchaseDetDAO purchaseDetDAO = new purchaseDetDAO();
				try {
				model.setRowCount(0);

				purchaseDetDAO.delete(
						Integer.parseInt(txtId.getText()));
						
				
				ArrayList<HashMap<String, String>> purchaseDetlist = new purchaseDetDAO().findAll();
				for (int i = 0; i < purchaseDetlist.size(); i++) {

					model.addRow(new Object[0]);
					model.setValueAt(purchaseDetlist.get(i).get("PURCHASE_ID"), i, 0);
					model.setValueAt(purchaseDetlist.get(i).get("SUPPLIER_ID"), i, 1);
					model.setValueAt(purchaseDetlist.get(i).get("GOOD_ID"), i, 2);
					model.setValueAt(purchaseDetlist.get(i).get("GOOD_NAME"), i, 3);
					model.setValueAt(purchaseDetlist.get(i).get("PURCHASE_DATE"), i, 4);
					model.setValueAt(purchaseDetlist.get(i).get("RECEIVE_DATE"), i, 5);
					model.setValueAt(purchaseDetlist.get(i).get("STATUS"), i, 6);
					model.setValueAt(purchaseDetlist.get(i).get("QUANTITY"), i, 7);
					model.setValueAt(purchaseDetlist.get(i).get("TOTAL_AMOUNT"), i, 8);

				}
				
				txtId.setText(null);
				

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				System.out.println("CANCEL RECEIVE SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "CANCEL RECEIVE SUCCESS !!");
				
			}
		});
		
	}
}
