package controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import database.connect;
import controller.customerController;
import controller.goodsController;
import controller.supplierController;
import controller.supplierGoodsController;
import controller.purchaseController;

public class homeController extends JFrame {

	public static void main(String[] args) {

		connect db = new connect();

		String customerPanel = "customerPanel";
		String goodsPanel = "goodsPenel";
		String supplierPanel = "supplierPanel";
		String suppliergoodsPanel = "suppliergoodsPanel";
		String purchasePanel = "purchasePanel";
		String purchaseDetPanel = "purchaseDetPanel";

		customerController customer = new customerController();
		goodsController goods = new goodsController();
		supplierController supplier = new supplierController();
		supplierGoodsController suppliergoods = new supplierGoodsController();
		purchaseController purchase = new purchaseController();
		purchaseDetController purchaseDet = new purchaseDetController();

		JFrame frame = new JFrame();
		CardLayout cardLayout = new CardLayout();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 150, 1300, 800);
		frame.setTitle("RUAY RUAY RUAY .Surachet");
		
		frame.getContentPane().setLayout(cardLayout);
		frame.getContentPane().add(customer);
		frame.getContentPane().add(goods);
		frame.getContentPane().add(supplier);
		frame.getContentPane().add(suppliergoods);
		frame.getContentPane().add(purchase);
		frame.getContentPane().add(purchaseDet);

		cardLayout.addLayoutComponent(customer, customerPanel);
		cardLayout.addLayoutComponent(goods, goodsPanel);
		cardLayout.addLayoutComponent(supplier, supplierPanel);
		cardLayout.addLayoutComponent(suppliergoods, suppliergoodsPanel);
		cardLayout.addLayoutComponent(purchase, purchasePanel);
		cardLayout.addLayoutComponent(purchaseDet, purchaseDetPanel);

		JMenuItem jMenuItem1 = new JMenuItem("Customers");
		jMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Switch to Customer");
				cardLayout.show(frame.getContentPane(), customerPanel);
			}
		});

		JMenuItem jMenuItem2 = new JMenuItem("Goods");
		jMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Switch to Goods");
				cardLayout.show(frame.getContentPane(), goodsPanel);
			}
		});

		JMenuItem jMenuItem3 = new JMenuItem("Supplier");
		jMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Switch to Supplier");
				cardLayout.show(frame.getContentPane(), supplierPanel);
			}
		});

		JMenuItem jMenuItem4 = new JMenuItem("SupplierGoods");
		jMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Switch to SupplierGoods");
				cardLayout.show(frame.getContentPane(), suppliergoodsPanel);
			}
		});

		JMenuItem jMenuItem5 = new JMenuItem("purchase");
		jMenuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Switch to purchase");
				cardLayout.show(frame.getContentPane(), purchasePanel);
			}
		});

		JMenuItem jMenuItem6 = new JMenuItem("Receive");
		jMenuItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Switch to Receive");
				cardLayout.show(frame.getContentPane(), purchaseDetPanel);
			}
		});

		JMenu jMenu = new JMenu("MENU");
		JMenu jMenu1 = new JMenu("About");
		
		
		JMenuBar jMenuBar = new JMenuBar();

		jMenuBar.add(jMenu);
		jMenuBar.add(jMenu1);
		frame.setJMenuBar(jMenuBar);

		jMenuBar.setBorder(null);
		jMenu.setForeground(new java.awt.Color(34,34,34));
		jMenu1.setForeground(new java.awt.Color(34,34,34));
		jMenuBar.setBackground(new java.awt.Color(255, 163, 43));

		JPanel panelup1 = new JPanel();
		panelup1.setBackground(new Color(255, 163, 43));
		jMenuBar.add(panelup1);
		panelup1.setLayout(null);
		jMenuBar.setBorder(null);

		jMenu.add(jMenuItem1);
		jMenu.add(jMenuItem2);
		jMenu.add(jMenuItem3);
		jMenu.add(jMenuItem4);
		jMenu.add(jMenuItem5);
		jMenu.add(jMenuItem6);

		frame.pack();
		frame.setVisible(true);

	}

}
