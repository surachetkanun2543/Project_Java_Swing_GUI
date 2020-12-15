package dao;

import java.util.ArrayList;
import java.util.HashMap;

//import javax.swing.JOptionPane;

import database.connect;

public class customerDAO {

	connect db;

	public customerDAO() {

		db = new connect();

	}

	public int add(int ID , String NAME, String SURNAME, String USERNAME, String PASSWORD, int ADDRESS, int POSTCODE,
			int BANK_ACCT, double BALANCE , int VERIFIED) {
		String sql = "INSERT INTO customer VALUES ('" + ID + "','" + NAME + "','" + SURNAME + "','" + USERNAME + "','"
				+ PASSWORD + "','" + ADDRESS + "','" + POSTCODE + "','" + BANK_ACCT + "','" + BALANCE + "','" + VERIFIED + "')";
		System.out.println("customerDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}

	public int update(int ID , String NAME, String SURNAME, String USERNAME, String PASSWORD, int ADDRESS, int POSTCODE,
			int BANK_ACCT, double BALANCE , int VERIFIED) {
		String sql = "UPDATE customer SET ID = '" + ID + "'" + ", NAME='" + NAME + "', SURNAME='" + SURNAME
				+ "', USERNAME='" + USERNAME + "', PASSWORD='" + PASSWORD + "', ADDRESS='" + ADDRESS + "', POSTCODE='"
				+ POSTCODE + "', BANK_ACCT='" + BANK_ACCT + "', BALANCE='" + BALANCE + "',  VERIFIED='" + VERIFIED + "' WHERE Id =" + ID + " ";
		System.out.println("customerDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}

	public int delete(int ID) {
		String sql = "DELETE FROM customer WHERE ID = " + ID + "";
		System.out.println("customerDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public ArrayList<HashMap<String, String>> findAll() {
		String sql = "SELECT * FROM `customer` ORDER BY `customer`.`ID` ASC";                                                               
		System.out.println("customerDAO :  ");
		System.err.println(sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}

	public ArrayList<HashMap<String, String>> findAll1() {
		String sql = "SELECT * FROM `customer` ORDER BY `customer`.`ID` ASC";
		ArrayList<HashMap<String, String>> data = db.query(sql);
		System.out.println("customerDAO :  ");
		System.err.println(sql);
		return data;
	}



}
