package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.customerDAO;
import dao.purchaseDAO;

public class purchaseController extends JPanel {

	JTextField txtpurchase_Id;
	JTextField txtsupplier_id;
	JTextField txtpurchase_date;
	JTextField txtstatus;
	JTextField txtgoods_Id;
	JTextField txtquantity;
	JTextField txtpurchase_det_Id;
	JTextField txtreceive_date;
	JTextField txttotal_amount;

	public purchaseController() {

		setPreferredSize(new Dimension(1200, 800));
		setOpaque(true);
		setBackground(new java.awt.Color(255,255,255));
		setLayout(null);

		Object[] columns = { "PURCHASE_ID", "SUPPLIER_ID", "PURCHASE_DATE", "STATUS", "GOOD_ID", "QUANTITY","GOOD_NAME" ,"TOTAL_AMOUNT" };

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
		scrollPane.setBounds(40, 110, 1100, 200);
		scrollPane.setFont(new java.awt.Font("sans-serif", 10, 15));
		scrollPane.setViewportView(table);
		scrollPane.setBackground(new java.awt.Color(255, 255, 255));
		scrollPane.setBorder(border);
		add(scrollPane);

		try {

			ArrayList<HashMap<String, String>> purchaselist = new purchaseDAO().findAll();
			for (int i = 0; i < purchaselist.size(); i++) {

				model.addRow(new Object[0]);
				model.setValueAt(purchaselist.get(i).get("PURCHASE_ID"), i, 0);
				model.setValueAt(purchaselist.get(i).get("SUPPLIER_ID"), i, 1);
				model.setValueAt(purchaselist.get(i).get("PURCHASE_DATE"), i, 2);
				model.setValueAt(purchaselist.get(i).get("STATUS"), i, 3);
				model.setValueAt(purchaselist.get(i).get("GOOD_ID"), i, 4);
				model.setValueAt(purchaselist.get(i).get("QUANTITY"), i, 5);
				model.setValueAt(purchaselist.get(i).get("GOOD_NAME"), i, 6);
				model.setValueAt(purchaselist.get(i).get("TOTAL_AMOUNT"), i, 7);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Border border1 = new LineBorder(Color.red, 2, true);
		
		txtpurchase_Id = new JTextField();
		txtpurchase_Id.setBounds(190, 355, 145, 25);
		txtpurchase_Id.setBorder(border1);
		add(txtpurchase_Id);

		txtsupplier_id = new JTextField();
		txtsupplier_id.setBounds(190, 395, 145, 25);
		txtsupplier_id.setBorder(null);
		add(txtsupplier_id);

		txtpurchase_date = new JTextField();
		txtpurchase_date.setBounds(190, 435, 145, 25);
		txtpurchase_date.setBorder(null);
		add(txtpurchase_date);

		txtstatus = new JTextField();
		txtstatus.setBounds(190, 472, 145, 25);
		txtstatus.setBorder(null);
		add(txtstatus);

		txtreceive_date = new JTextField();
		txtreceive_date.setBounds(190, 505, 145, 25);
		txtreceive_date.setBorder(null);
		add(txtreceive_date);

		txttotal_amount = new JTextField();
		txttotal_amount.setBounds(190, 540, 145, 25);
		txttotal_amount.setBorder(null);
		add(txttotal_amount);

		txtgoods_Id = new JTextField();
		txtgoods_Id.setBounds(190, 578, 145, 25);
		txtgoods_Id.setBorder(null);
		add(txtgoods_Id);

		txtquantity = new JTextField();
		txtquantity.setBounds(190, 615, 145, 25);
		txtquantity.setBorder(null);
		add(txtquantity);
		

		

		JLabel labelheader = new JLabel("PURCHASE");
		labelheader.setFont(new Font("Segoe UI", Font.BOLD, 25));
		labelheader.setBounds(50, 20, 150, 50);
		labelheader.setForeground(new java.awt.Color(255, 163, 43));
		add(labelheader);
		
		JLabel labelpurchase_Id = new JLabel("PURCHASE ID");
		labelpurchase_Id.setFont(new java.awt.Font("Segoe UI", 120, 15));
		labelpurchase_Id.setBounds(50, 350, 120, 35);
		labelpurchase_Id.setForeground(new java.awt.Color(255, 0, 0));
		add(labelpurchase_Id);

		JLabel labelsupplier_id = new JLabel("SUPPLIER ID");
		labelsupplier_id.setFont(new java.awt.Font("Segoe UI", 120, 15));
		labelsupplier_id.setBounds(50, 390, 120, 35);
		labelsupplier_id.setForeground(new java.awt.Color(255, 255, 255));
		add(labelsupplier_id);

		JLabel labelpurchase_date = new JLabel("PURCHASE DATE");
		labelpurchase_date.setFont(new java.awt.Font("Segoe UI", 120, 15));
		labelpurchase_date.setBounds(50, 430, 120, 35);
		labelpurchase_date.setForeground(new java.awt.Color(255, 255, 255));
		add(labelpurchase_date);

		JLabel labelstatus = new JLabel("STATUS");
		labelstatus.setFont(new java.awt.Font("Segoe UI", 120, 15));
		labelstatus.setBounds(50, 465, 120, 35);
		labelstatus.setForeground(new java.awt.Color(255, 255, 255));
		add(labelstatus);

		JLabel labelreceive_date = new JLabel("RECEIVE DATE");
		labelreceive_date.setFont(new java.awt.Font("Segoe UI", 120, 15));
		labelreceive_date.setBounds(50, 500, 120, 35);
		labelreceive_date.setForeground(new java.awt.Color(255, 255, 255));
		add(labelreceive_date);

		JLabel labeltotal_amount = new JLabel("TOTAL AMOUNT");
		labeltotal_amount.setFont(new java.awt.Font("Segoe UI", 120, 15));
		labeltotal_amount.setBounds(50, 535, 120, 35);
		labeltotal_amount.setForeground(new java.awt.Color(255, 255, 255));
		add(labeltotal_amount);

		JLabel labelgoods_Id = new JLabel("GOODS ID");
		labelgoods_Id.setFont(new java.awt.Font("Segoe UI", 120, 15));
		labelgoods_Id.setBounds(50, 572, 120, 35);
		labelgoods_Id.setForeground(new java.awt.Color(255, 255, 255));
		add(labelgoods_Id);

		JLabel labelquantity = new JLabel("QUANTITY");
		labelquantity.setFont(new java.awt.Font("Segoe UI", 120, 15));
		labelquantity.setBounds(50, 605, 130, 45);
		labelquantity.setForeground(new java.awt.Color(255, 255, 255));
		add(labelquantity);
		
		
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
				purchaseDAO purchaseDAO = new purchaseDAO();
				try {
					model.setRowCount(0);

					purchaseDAO.Insert(
							Integer.parseInt(txtpurchase_Id.getText()),
							Integer.parseInt(txtsupplier_id.getText()),
							txtpurchase_date.getText(),
							txtstatus.getText(),
							txtreceive_date.getText(),
							Double.parseDouble(txttotal_amount.getText()));
					
					purchaseDAO.Insert2(
							Integer.parseInt(txtpurchase_Id.getText()),
							Integer.parseInt(txtpurchase_Id.getText()),
							Integer.parseInt(txtgoods_Id.getText()),
							Integer.parseInt(txtquantity.getText()));
							
					
					ArrayList<HashMap<String, String>> purchaselist = new purchaseDAO().findAll();
					for (int i = 0; i < purchaselist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(purchaselist.get(i).get("PURCHASE_ID"), i, 0);
						model.setValueAt(purchaselist.get(i).get("SUPPLIER_ID"), i, 1);
						model.setValueAt(purchaselist.get(i).get("PURCHASE_DATE"), i, 2);
						model.setValueAt(purchaselist.get(i).get("STATUS"), i, 3);
						model.setValueAt(purchaselist.get(i).get("GOOD_ID"), i, 4);
						model.setValueAt(purchaselist.get(i).get("QUANTITY"), i, 5);
						model.setValueAt(purchaselist.get(i).get("GOOD_NAME"), i, 6);
						model.setValueAt(purchaselist.get(i).get("TOTAL_AMOUNT"), i, 7);

					}
					
					txtpurchase_Id.setText(null);
					txtsupplier_id.setText(null);
					txtpurchase_date.setText(null);
					txtstatus.setText(null);
					txtreceive_date.setText(null);
					txttotal_amount.setText(null);
					txtgoods_Id.setText(null);
					txtquantity.setText(null);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("INSERT PURCHASE SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "INSERT PURCHASE SUCCESS !!");

			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			purchaseDAO purchaseDAO = new purchaseDAO();
			try {
				model.setRowCount(0);

				purchaseDAO.update(
						Integer.parseInt(txtpurchase_Id.getText()),
						Integer.parseInt(txtsupplier_id.getText()),
						txtpurchase_date.getText(),
						txtstatus.getText(),
						txtreceive_date.getText(),
						Double.parseDouble(txttotal_amount.getText()));
				
				purchaseDAO.update1(
						Integer.parseInt(txtpurchase_Id.getText()),
						Integer.parseInt(txtpurchase_Id.getText()),
						Integer.parseInt(txtgoods_Id.getText()),
						Integer.parseInt(txtquantity.getText()));
					
				ArrayList<HashMap<String, String>> purchaselist = new purchaseDAO().findAll();
				for (int i = 0; i < purchaselist.size(); i++) {

					model.addRow(new Object[0]);
					model.setValueAt(purchaselist.get(i).get("PURCHASE_ID"), i, 0);
					model.setValueAt(purchaselist.get(i).get("SUPPLIER_ID"), i, 1);
					model.setValueAt(purchaselist.get(i).get("PURCHASE_DATE"), i, 2);
					model.setValueAt(purchaselist.get(i).get("STATUS"), i, 3);
					model.setValueAt(purchaselist.get(i).get("GOOD_ID"), i, 4);
					model.setValueAt(purchaselist.get(i).get("QUANTITY"), i, 5);
					model.setValueAt(purchaselist.get(i).get("GOOD_NAME"), i, 6);
					model.setValueAt(purchaselist.get(i).get("TOTAL_AMOUNT"), i, 7);

				}
				
				txtpurchase_Id.setText(null);
				txtsupplier_id.setText(null);
				txtpurchase_date.setText(null);
				txtstatus.setText(null);
				txtreceive_date.setText(null);
				txttotal_amount.setText(null);
				txtgoods_Id.setText(null);
				txtquantity.setText(null);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				System.out.println("UPDATE PURCHASE SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "UPDATE PURCHASE SUCCESS !!");
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				purchaseDAO purchaseDAO = new purchaseDAO();
				try {
					model.setRowCount(0);

					purchaseDAO.delete(
							Integer.parseInt(txtpurchase_Id.getText()));
					
					purchaseDAO.delete1(
							Integer.parseInt(txtpurchase_Id.getText()));

					ArrayList<HashMap<String, String>> purchaselist = new purchaseDAO().findAll();
					for (int i = 0; i < purchaselist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(purchaselist.get(i).get("PURCHASE_ID"), i, 0);
						model.setValueAt(purchaselist.get(i).get("SUPPLIER_ID"), i, 1);
						model.setValueAt(purchaselist.get(i).get("PURCHASE_DATE"), i, 2);
						model.setValueAt(purchaselist.get(i).get("STATUS"), i, 3);
						model.setValueAt(purchaselist.get(i).get("GOOD_ID"), i, 4);
						model.setValueAt(purchaselist.get(i).get("QUANTITY"), i, 5);
						model.setValueAt(purchaselist.get(i).get("GOOD_NAME"), i, 6);
						model.setValueAt(purchaselist.get(i).get("TOTAL_AMOUNT"), i, 7);

					}
					
					txtpurchase_Id.setText(null);
					txtsupplier_id.setText(null);
					txtpurchase_date.setText(null);
					txtstatus.setText(null);
					txtreceive_date.setText(null);
					txttotal_amount.setText(null);
					txtgoods_Id.setText(null);
					txtquantity.setText(null);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					System.out.println("DELETE PURCHASE SUCCESS !! ");
					JOptionPane.showMessageDialog(null, "DELETE PURCHASE SUCCESS !!");
					
				}
			});
		
	}
}
