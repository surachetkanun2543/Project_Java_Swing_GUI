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
import dao.supplierGoodsDAO;

public class supplierGoodsController extends JPanel {

	JTextField txtId;
	JTextField txtsupplier_id;
	JTextField txtgoods_id;

	public supplierGoodsController() {
		setPreferredSize(new Dimension(1200, 800));
		setOpaque(true);
		setBackground(new java.awt.Color(255, 255, 255));
		setLayout(null);

		Object[] columnstable = { "ID", "GOOD_NAME", "UNITCOST", "UNITPRICE", "SUPPLIER_ID", "SUPPLIER_NAME",
				"SUPPLIER_ADDRESS", "GOOD_ID" };

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

		model.setColumnIdentifiers(columnstable);
		scrollPane.setBounds(50, 80, 1100, 200);
		scrollPane.setFont(new java.awt.Font("sans-serif", 10, 15));
		scrollPane.setViewportView(table);
		scrollPane.setBackground(new java.awt.Color(255, 255, 255));
		scrollPane.setBorder(border);
		add(scrollPane);

		try {

			ArrayList<HashMap<String, String>> supplierGoodlist = new supplierGoodsDAO().findAll();
			for (int i = 0; i < supplierGoodlist.size(); i++) {

				model.addRow(new Object[0]);
				model.setValueAt(supplierGoodlist.get(i).get("ID"), i, 0);
				model.setValueAt(supplierGoodlist.get(i).get("GOOD_NAME"), i, 1);
				model.setValueAt(supplierGoodlist.get(i).get("UNITCOST"), i, 2);
				model.setValueAt(supplierGoodlist.get(i).get("UNITPRICE"), i, 3);
				model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_ID"), i, 4);
				model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_NAME"), i, 5);
				model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_ADDRESS"), i, 6);
				model.setValueAt(supplierGoodlist.get(i).get("GOOD_ID"), i, 7);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border1 = new LineBorder(Color.red, 2, true);

		txtId = new JTextField();
		txtId.setBounds(190, 355, 145, 25);
		txtId.setBorder(border1);
		add(txtId);

		txtsupplier_id = new JTextField();
		txtsupplier_id.setBounds(190, 395, 145, 25);
		txtsupplier_id.setBorder(null);
		add(txtsupplier_id);

		txtgoods_id = new JTextField();
		txtgoods_id.setBounds(190, 435, 145, 25);
		txtgoods_id.setBorder(null);
		add(txtgoods_id);

		JLabel labelheader = new JLabel("SUPPLIER GOODS");
		labelheader.setFont(new Font("Segoe UI", Font.BOLD, 25));
		labelheader.setBounds(50, 20, 250, 50);
		labelheader.setForeground(new java.awt.Color(255, 163, 43));
		add(labelheader);

		JLabel labelId = new JLabel("ID");
		labelId.setFont(new java.awt.Font("Segoe UI", 120, 20));
		labelId.setBounds(50, 350, 120, 35);
		labelId.setForeground(new java.awt.Color(255, 0, 0));
		add(labelId);

		JLabel labelsupplier_id = new JLabel("SUPPLIER ID");
		labelsupplier_id.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelsupplier_id.setBounds(50, 390, 120, 35);
		labelsupplier_id.setForeground(new java.awt.Color(255, 255, 255));
		add(labelsupplier_id);

		JLabel labelgoods_id = new JLabel("GOODS ID");
		labelgoods_id.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelgoods_id.setBounds(50, 430, 120, 35);
		labelgoods_id.setForeground(new java.awt.Color(255, 255, 255));
		add(labelgoods_id);

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
				supplierGoodsDAO supplierGoodsDAO = new supplierGoodsDAO();
				try {
					model.setRowCount(0);

					supplierGoodsDAO.Insert(Integer.parseInt(txtId.getText()),
							Integer.parseInt(txtsupplier_id.getText()), Integer.parseInt(txtgoods_id.getText()));

					ArrayList<HashMap<String, String>> supplierGoodlist = new supplierGoodsDAO().findAll();
					for (int i = 0; i < supplierGoodlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(supplierGoodlist.get(i).get("ID"), i, 0);
						model.setValueAt(supplierGoodlist.get(i).get("GOOD_NAME"), i, 1);
						model.setValueAt(supplierGoodlist.get(i).get("UNITCOST"), i, 2);
						model.setValueAt(supplierGoodlist.get(i).get("UNITPRICE"), i, 3);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_ID"), i, 4);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_NAME"), i, 5);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_ADDRESS"), i, 6);
						model.setValueAt(supplierGoodlist.get(i).get("GOOD_ID"), i, 7);

					}

					txtId.setText(null);
					txtsupplier_id.setText(null);
					txtgoods_id.setText(null);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println("INSERT SUPPLIER_GOODS SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "INSERT SUPPLIER_GOODS SUCCESS !!");

			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				supplierGoodsDAO supplierGoodsDAO = new supplierGoodsDAO();
				try {
					model.setRowCount(0);

					supplierGoodsDAO.update(Integer.parseInt(txtId.getText()),
							Integer.parseInt(txtsupplier_id.getText()), Integer.parseInt(txtgoods_id.getText()));
					ArrayList<HashMap<String, String>> supplierGoodlist = new supplierGoodsDAO().findAll();
					for (int i = 0; i < supplierGoodlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(supplierGoodlist.get(i).get("ID"), i, 0);
						model.setValueAt(supplierGoodlist.get(i).get("GOOD_NAME"), i, 1);
						model.setValueAt(supplierGoodlist.get(i).get("UNITCOST"), i, 2);
						model.setValueAt(supplierGoodlist.get(i).get("UNITPRICE"), i, 3);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_ID"), i, 4);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_NAME"), i, 5);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_ADDRESS"), i, 6);
						model.setValueAt(supplierGoodlist.get(i).get("GOOD_ID"), i, 7);
					}

					txtId.setText(null);
					txtsupplier_id.setText(null);
					txtgoods_id.setText(null);

				} catch (Exception e1) {
				}

				System.out.println("UPDATE SUPPLIER GOODS SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "UPDATE SUPPLIER GOODS SUCCESS !!");
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				supplierGoodsDAO supplierGoodsDAO = new supplierGoodsDAO();
				try {
					model.setRowCount(0);

					supplierGoodsDAO.delete(Integer.parseInt(txtId.getText()));
					ArrayList<HashMap<String, String>> supplierGoodlist = new supplierGoodsDAO().findAll();
					for (int i = 0; i < supplierGoodlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(supplierGoodlist.get(i).get("ID"), i, 0);
						model.setValueAt(supplierGoodlist.get(i).get("GOOD_NAME"), i, 1);
						model.setValueAt(supplierGoodlist.get(i).get("UNITCOST"), i, 2);
						model.setValueAt(supplierGoodlist.get(i).get("UNITPRICE"), i, 3);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_ID"), i, 4);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_NAME"), i, 5);
						model.setValueAt(supplierGoodlist.get(i).get("SUPPLIER_ADDRESS"), i, 6);
						model.setValueAt(supplierGoodlist.get(i).get("GOOD_ID"), i, 7);

					}

					txtId.setText(null);
					txtsupplier_id.setText(null);
					txtgoods_id.setText(null);

				} catch (Exception ed) {
					// TODO Auto-generated catch block
					ed.printStackTrace();
				}

				System.out.println("DELETE SUPPLIER GOODS SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "DELETE SUPPLIER GOODS SUCCESS !!");
			}
		});

	}

}
