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

import dao.customerDAO;
import dao.goodsDAO;
import dao.supplierDAO;

public class supplierController extends JPanel {

	public supplierController() {
		setPreferredSize(new Dimension(1200, 800));
		setOpaque(true);
		setBackground(new java.awt.Color(255,255,255));
		setLayout(null);

		JTextField txtId;
		JTextField txtName;
		JTextField txtAddress;

		// customerDAO cusDAO = new customerDAO();

		// JTable
		// --------------------------------------------------------------------------------

		Object[] columns = { "SUPPLIER_ID", "SUPPLIER_NAME", "SUPPLIER_ADDRESS"};
		
		Border border = new LineBorder(Color.white, 2, true);

		JScrollPane scrollPane = new JScrollPane();
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		table.getTableHeader().setFont(new Font("TimesRoman", Font.BOLD, 15));
		table.getTableHeader().setBackground(new Color(133,30,36));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setFont(new Font("TimesRoman", Font.BOLD, 15));
		table.setGridColor(new java.awt.Color(255, 255, 255));
		table.setRowHeight(25);
		table.setModel(model);
		table.setBorder(border);
		table.setBackground(new java.awt.Color(255, 255, 255));
		
		model.setColumnIdentifiers(columns);
		scrollPane.setBounds(50, 80, 1100, 200);
		scrollPane.setFont(new java.awt.Font("sans-serif", 10, 15));
		scrollPane.setViewportView(table);
		scrollPane.setBackground(new java.awt.Color(255, 255, 255));
		scrollPane.setBorder(border);
		add(scrollPane);
		try {

			ArrayList<HashMap<String, String>> supplierlist = new supplierDAO().findAll();
			for (int i = 0; i < supplierlist.size(); i++) {

				model.addRow(new Object[0]);
				model.setValueAt(supplierlist.get(i).get("SUPPLIER_ID"), i, 0);
				model.setValueAt(supplierlist.get(i).get("SUPPLIER_NAME"), i, 1);
				model.setValueAt(supplierlist.get(i).get("SUPPLIER_ADDRESS"), i, 2);


			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Border border1 = new LineBorder(Color.red, 2, true);

		txtId = new JTextField();
		txtId.setBounds(190, 355, 145, 25);
		txtId.setBorder(border1);
		add(txtId);

		txtName = new JTextField();
		txtName.setBounds(190, 395, 145, 25);
		txtName.setBorder(null);
		add(txtName);

		txtAddress = new JTextField();
		txtAddress.setBounds(190, 435, 145, 25);
		txtAddress.setBorder(null);
		add(txtAddress);
		
		
		JLabel labelheader = new JLabel("SUPPLIER");
		labelheader.setFont(new Font("Segoe UI", Font.BOLD, 25));
		labelheader.setBounds(50, 20, 150, 50);
		labelheader.setForeground(new java.awt.Color(255, 163, 43));
		add(labelheader);
		
		JLabel labelId = new JLabel("ID");
		labelId.setFont(new java.awt.Font("Segoe UI", 120, 20));
		labelId.setBounds(50, 350, 120, 35);
		labelId.setForeground(new java.awt.Color(255, 0, 0));
		add(labelId);

		JLabel labelName = new JLabel("NAME");
		labelName.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelName.setBounds(50, 390, 120, 35);
		labelName.setForeground(new java.awt.Color(255, 255, 255));
		add(labelName);

		JLabel labelAddress = new JLabel("ADDRESS");
		labelAddress.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelAddress.setBounds(50, 430, 120, 35);
		labelAddress.setForeground(new java.awt.Color(255, 255, 255));
		add(labelAddress);

		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBounds(360, 355, 120, 30);
		btnInsert.setForeground(new java.awt.Color(255, 255, 255));
		btnInsert.setBackground(new java.awt.Color(92, 184, 92));
		btnInsert.setBorder(null);
		add(btnInsert);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(360, 410, 120, 30);
		btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
		btnUpdate.setBackground(new java.awt.Color(240, 173, 78));
		btnUpdate.setBorder(null);
		add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(360, 465, 120, 30);
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
				supplierDAO supplierDAO = new supplierDAO();
				try {
					//model.setRowCount(0);
					supplierDAO.Insert(Integer.parseInt(txtId.getText()), txtName.getText(), txtAddress.getText());
					
					ArrayList<HashMap<String, String>> supplierlist = new supplierDAO().findAll1();
					for (int i = 0; i < supplierlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_ID"), i, 0);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_NAME"), i, 1);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_ADDRESS"), i, 2);

					}

					
					txtId.setText(null);
					txtName.setText(null);
					txtAddress.setText(null);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("INSERT SUUPLIER SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "INSERT SUUPLIER SUCCESS !!");

			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					supplierDAO supplierDAO = new supplierDAO();
					//model.setRowCount(0);
					supplierDAO.update(Integer.parseInt(txtId.getText()), txtName.getText(), txtAddress.getText());
					ArrayList<HashMap<String, String>> supplierlist = new supplierDAO().findAll1();
					for (int i = 0; i < supplierlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_ID"), i, 0);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_NAME"), i, 1);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_ADDRESS"), i, 2);

					}
					
					txtId.setText(null);
					txtName.setText(null);
					txtAddress.setText(null);
					
				} catch (Exception e1) {
				}

				System.out.println("UPDATE SUPPLIER SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "UPDATE SUPPLIER SUCCESS !!");
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				supplierDAO supplierDAO = new supplierDAO();
				try {
					supplierDAO.delete(Integer.parseInt(txtId.getText()));
					//model.setRowCount(0);

					ArrayList<HashMap<String, String>> supplierlist = new supplierDAO().findAll1();
					for (int i = 0; i < supplierlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_ID"), i, 0);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_NAME"), i, 1);
						model.setValueAt(supplierlist.get(i).get("SUPPLIER_ADDRESS"), i, 2);

					}
					
					txtId.setText(null);
					txtName.setText(null);
					txtAddress.setText(null);
					
				} catch (Exception ed) {
					// TODO Auto-generated catch block
					ed.printStackTrace();
				}

				System.out.println("DELETE SUPPLIER SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "DELETE SUPPLIER SUCCESS !!");
			}
		});
		
	}

}
