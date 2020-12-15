package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.connect;

public class supplierDAO {

	connect db;

	public supplierDAO() {

		db = new connect();

	}
	
	public int Insert(int SUPPLIER_ID, String NAME, String ADDRESS) {
		String sql = "INSERT INTO supplier VALUES ('" + SUPPLIER_ID + "','" + NAME + "','" + ADDRESS + "')";
		System.out.println("supplierDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}
	
	public int update(int SUPPLIER_ID, String NAME, String ADDRESS) {
		String sql = "UPDATE supplier SET SUPPLIER_ID = '" + SUPPLIER_ID + "'" + ", SUPPLIER_NAME='" + NAME + "', SUPPLIER_ADDRESS='" + ADDRESS
				+ "' WHERE SUPPLIER_ID =" + SUPPLIER_ID + " ";
		System.out.println("supplierDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}
	
	public int delete(int SUPPLIER_ID) {
		String sql = "DELETE FROM supplier WHERE SUPPLIER_ID = " + SUPPLIER_ID + "";
		System.out.println("supplierDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "SUPPLIER_ID" });
	}
	
	public ArrayList<HashMap<String, String>> findAll() {
		String sql = "SELECT * FROM `supplier` ORDER BY SUPPLIER_ID ASC";
		System.out.println("supplierDAO :  ");
		System.err.println(sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}
	public ArrayList<HashMap<String, String>> findAll1() {
		String sql = "SELECT * FROM `supplier` ORDER BY SUPPLIER_ID ASC";
		ArrayList<HashMap<String, String>> data = db.query(sql);
		System.out.println("supplierDAO :  ");
		System.err.println(sql);
		return data;
	}
	
}