package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
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

public class customerController extends JPanel {

	JTextField txtId;
	JTextField txtName;
	JTextField txtSurname;
	JTextField txtUsername;
	JTextField txtPassword;
	JTextField txtAddress;
	JTextField txtPostcode;
	JTextField txtBank_acct;
	JTextField txtBalance;
	JTextField txtVERIFIED;

	public customerController() {
		setPreferredSize(new Dimension(1200, 800));
		setOpaque(true);
		setBackground(new java.awt.Color(255,255,255));
		setLayout(null);

		// customerDAO cusDAO = new customerDAO();

		// JTable
		// --------------------------------------------------------------------------------
		// เก็บ columns ไว้ในรูปแบบ Array  ไว้ใสนตัวแปล columns  แล้วเอามาใส่ใน model table
		
		Object[] columns = { "ID", "NAME", "SURNAME", "USERNAME", "PASSWORD", "ADDRESS", "POTCODE", "BANK_ACCT",
				"BALANCE", "VERIFIED" };
		
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

			ArrayList<HashMap<String, String>> customerlist = new customerDAO().findAll();
			for (int i = 0; i < customerlist.size(); i++) {

				model.addRow(new Object[0]);
				model.setValueAt(customerlist.get(i).get("ID"), i, 0);
				model.setValueAt(customerlist.get(i).get("NAME"), i, 1);
				model.setValueAt(customerlist.get(i).get("SURNAME"), i, 2);
				model.setValueAt(customerlist.get(i).get("USERNAME"), i, 3);
				model.setValueAt(customerlist.get(i).get("PASSWORD"), i, 4);
				model.setValueAt(customerlist.get(i).get("ADDRESS"), i, 5);
				model.setValueAt(customerlist.get(i).get("POTCODE"), i, 6);
				model.setValueAt(customerlist.get(i).get("BANK_ACCT"), i, 7);
				model.setValueAt(customerlist.get(i).get("BALANCE"), i, 8);
				model.setValueAt(customerlist.get(i).get("VERIFIED"), i, 9);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		// JTextField
		// --------------------------------------------------------------------------------
		

		
		Border border1 = new LineBorder(Color.red, 1, true);
		
		txtId = new JTextField();
		txtId.setBounds(190, 355, 145, 25);
		txtId.setBorder(border1);
		add(txtId);

		txtName = new JTextField();
		txtName.setBounds(190, 395, 145, 25);
		txtName.setBorder(null);
		add(txtName);

		txtSurname = new JTextField();
		txtSurname.setBounds(190, 435, 145, 25);
		txtSurname.setBorder(null);
		add(txtSurname);

		txtUsername = new JTextField();
		txtUsername.setBounds(190, 472, 145, 25);
		txtUsername.setBorder(null);
		add(txtUsername);

		txtPassword = new JTextField();
		txtPassword.setBounds(190, 505, 145, 25);
		txtPassword.setBorder(null);
		add(txtPassword);

		txtAddress = new JTextField();
		txtAddress.setBounds(190, 540, 145, 25);
		txtAddress.setBorder(null);
		add(txtAddress);

		txtPostcode = new JTextField();
		txtPostcode.setBounds(190, 578, 145, 25);
		txtPostcode.setBorder(null);
		add(txtPostcode);

		txtBank_acct = new JTextField();
		txtBank_acct.setBounds(190, 615, 145, 25);
		txtBank_acct.setBorder(null);
		add(txtBank_acct);

		txtBalance = new JTextField();
		txtBalance.setBounds(190, 652, 145, 25);
		txtBalance.setBorder(null);
		add(txtBalance);
		
		txtVERIFIED = new JTextField();
		txtVERIFIED.setBounds(190, 692, 145, 25);
		txtVERIFIED.setBorder(null);
		add(txtVERIFIED);

		// JLabel
		// --------------------------------------------------------------------------------
		
		JLabel labelheader = new JLabel("CUSTOMER");
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

		JLabel labelSurname = new JLabel("SURNAME");
		labelSurname.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelSurname.setBounds(50, 430, 120, 35);
		labelSurname.setForeground(new java.awt.Color(255, 255, 255));
		add(labelSurname);

		JLabel labelUsername = new JLabel("USERNMAE");
		labelUsername.setFont(new java.awt.Font("Segoe UI", 120, 20));
		labelUsername.setBounds(50, 465, 120, 35);
		labelUsername.setForeground(new java.awt.Color(255, 255, 255));
		add(labelUsername);

		JLabel labelPassword = new JLabel("PASSWORD");
		labelPassword.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelPassword.setBounds(50, 500, 120, 35);
		labelPassword.setForeground(new java.awt.Color(255, 255, 255));
		add(labelPassword);

		JLabel labelAddress = new JLabel("ADDRESS");
		labelAddress.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelAddress.setBounds(50, 535, 120, 35);
		labelAddress.setForeground(new java.awt.Color(255, 255, 255));
		add(labelAddress);

		JLabel labelPostcode = new JLabel("POSTCODE");
		labelPostcode.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelPostcode.setBounds(50, 572, 120, 35);
		labelPostcode.setForeground(new java.awt.Color(255, 255, 255));
		add(labelPostcode);

		JLabel labelBank_acct = new JLabel("BANK_ACCT");
		labelBank_acct.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelBank_acct.setBounds(50, 605, 130, 45);
		labelBank_acct.setForeground(new java.awt.Color(255, 255, 255));
		add(labelBank_acct);

		JLabel labelBalance = new JLabel("BALANCE");
		labelBalance.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelBalance.setBounds(50, 645, 120, 35);
		labelBalance.setForeground(new java.awt.Color(255, 255, 255));
		add(labelBalance);
		
		JLabel labelVERIFIED = new JLabel("VERIFIED");
		labelVERIFIED.setFont(new java.awt.Font("Segoe UI", 50, 20));
		labelVERIFIED.setBounds(50, 686, 120, 35);
		labelVERIFIED.setForeground(new java.awt.Color(255, 255, 255));
		add(labelVERIFIED);

		// JButton
		// --------------------------------------------------------------------------------

		
		JButton btnAdd = new JButton("INSERT");
		btnAdd.setBounds(360, 355, 120, 30);
		btnAdd.setForeground(new java.awt.Color(255, 255, 255));
		btnAdd.setBackground(new java.awt.Color(92, 184, 92));
		btnAdd.setBorder(null);
		add(btnAdd);

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

		// add
		// --------------------------------------------------------------------------------

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				customerDAO customerDAO = new customerDAO();
				try {
					model.setRowCount(0);

					customerDAO.add(
							Integer.parseInt(txtId.getText()), 
							txtName.getText(), txtSurname.getText(),
							txtUsername.getText(), txtPassword.getText(),
							Integer.parseInt(txtAddress.getText()),
							Integer.parseInt(txtPostcode.getText()),
							Integer.parseInt(txtBank_acct.getText()),
							Double.parseDouble(txtBalance.getText()),
							Integer.parseInt(txtVERIFIED.getText()));
					
					ArrayList<HashMap<String, String>> customerlist = new customerDAO().findAll1();
					for (int i = 0; i < customerlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(customerlist.get(i).get("ID"), i, 0);
						model.setValueAt(customerlist.get(i).get("NAME"), i, 1);
						model.setValueAt(customerlist.get(i).get("SURNAME"), i, 2);
						model.setValueAt(customerlist.get(i).get("USERNAME"), i, 3);
						model.setValueAt(customerlist.get(i).get("PASSWORD"), i, 4);
						model.setValueAt(customerlist.get(i).get("ADDRESS"), i, 5);
						model.setValueAt(customerlist.get(i).get("POTCODE"), i, 6);
						model.setValueAt(customerlist.get(i).get("BANK_ACCT"), i, 7);
						model.setValueAt(customerlist.get(i).get("BALANCE"), i, 8);
						model.setValueAt(customerlist.get(i).get("VERIFIED"), i, 9);

					}

					txtId.setText(null);
					txtName.setText(null);
					txtSurname.setText(null);
					txtUsername.setText(null);
					txtPassword.setText(null);
					txtAddress.setText(null);
					txtPostcode.setText(null);
					txtBank_acct.setText(null);
					txtBalance.setText(null);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("INSERT CUSTOMER SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "INSERT CUSTOMER SUCCESS !!");

			}
		});

		// update
		// --------------------------------------------------------------------------------

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					customerDAO customerDAO = new customerDAO();
					model.setRowCount(0);
					customerDAO.update(Integer.parseInt(txtId.getText()),
							txtName.getText(), txtSurname.getText(),
							txtUsername.getText(), txtPassword.getText(),
							Integer.parseInt(txtAddress.getText()),
							Integer.parseInt(txtPostcode.getText()),
							Integer.parseInt(txtBank_acct.getText()),
							Double.parseDouble(txtBalance.getText()),
							Integer.parseInt(txtVERIFIED.getText()));
					
					ArrayList<HashMap<String, String>> customerlist = new customerDAO().findAll1();
					for (int i = 0; i < customerlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(customerlist.get(i).get("ID"), i, 0);
						model.setValueAt(customerlist.get(i).get("NAME"), i, 1);
						model.setValueAt(customerlist.get(i).get("SURNAME"), i, 2);
						model.setValueAt(customerlist.get(i).get("USERNAME"), i, 3);
						model.setValueAt(customerlist.get(i).get("PASSWORD"), i, 4);
						model.setValueAt(customerlist.get(i).get("ADDRESS"), i, 5);
						model.setValueAt(customerlist.get(i).get("POTCODE"), i, 6);
						model.setValueAt(customerlist.get(i).get("BANK_ACCT"), i, 7);
						model.setValueAt(customerlist.get(i).get("BALANCE"), i, 8);
						model.setValueAt(customerlist.get(i).get("VERIFIED"), i, 9);

					}
					
					txtId.setText(null);
					txtName.setText(null);
					txtSurname.setText(null);
					txtUsername.setText(null);
					txtPassword.setText(null);
					txtAddress.setText(null);
					txtPostcode.setText(null);
					txtBank_acct.setText(null);
					txtBalance.setText(null);
					
				} catch (Exception e1) {
				}

				System.out.println("UPDATE CUSTOMER SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "UPDATE CUSTOMER SUCCESS !!");
			}
		});

		// delete
		// --------------------------------------------------------------------------------

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				customerDAO customerDAO = new customerDAO();
				try {
					customerDAO.delete(Integer.parseInt(txtId.getText()));
					model.setRowCount(0);

					ArrayList<HashMap<String, String>> customerlist = new customerDAO().findAll1();
					for (int i = 0; i < customerlist.size(); i++) {

						model.addRow(new Object[0]);
						model.setValueAt(customerlist.get(i).get("ID"), i, 0);
						model.setValueAt(customerlist.get(i).get("NAME"), i, 1);
						model.setValueAt(customerlist.get(i).get("SURNAME"), i, 2);
						model.setValueAt(customerlist.get(i).get("USERNAME"), i, 3);
						model.setValueAt(customerlist.get(i).get("PASSWORD"), i, 4);
						model.setValueAt(customerlist.get(i).get("ADDRESS"), i, 5);
						model.setValueAt(customerlist.get(i).get("POTCODE"), i, 6);
						model.setValueAt(customerlist.get(i).get("BANK_ACCT"), i, 7);
						model.setValueAt(customerlist.get(i).get("BALANCE"), i, 8);
						model.setValueAt(customerlist.get(i).get("VERIFIED"), i, 9);

					}
					
					txtId.setText(null);
					txtName.setText(null);
					txtSurname.setText(null);
					txtUsername.setText(null);
					txtPassword.setText(null);
					txtAddress.setText(null);
					txtPostcode.setText(null);
					txtBank_acct.setText(null);
					txtBalance.setText(null);
					
				} catch (Exception ed) {
					// TODO Auto-generated catch block
					ed.printStackTrace();
				}

				System.out.println("DELETE CUSTOMER SUCCESS !! ");
				JOptionPane.showMessageDialog(null, "DELETE CUSTOMER SUCCESS !!");
			}
		});

	
	}

}
