package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.connect;

public class goodsDAO {

	connect db;

	public goodsDAO() {

		db = new connect();

	}

	public int add(int ID, String GOOD_NAME, double UNITCOST, double UNTPRICE) {
		String sql = "INSERT INTO good VALUES (" + ID + ", " + "'" + GOOD_NAME + "', " + "'" + UNITCOST + "', " + "'"
				+ UNTPRICE + "')";
		System.out.println("goodsDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}

	public int update(int ID, String GOOD_NAME, double UNITCOST, double UNTPRICE) {
		String sql = "UPDATE good SET GOOD_NAME = '" + GOOD_NAME + "' " + ", UNITCOST = '" + UNITCOST + "'" + ", UNITPRICE = '" + UNTPRICE + "'" + " WHERE ID = " + ID + " ";
		System.out.println("goodsDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}

	public int delete(int ID) {
		String sql = "DELETE FROM good WHERE ID = " + ID + "";
		System.out.println("goodsDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}

	public ArrayList<HashMap<String, String>> findAll() {
		String sql = "SELECT * FROM `good` ORDER BY `good`.`ID` ASC";
		System.out.println("goodsDAO :  ");
		System.err.println(sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}

	public ArrayList<HashMap<String, String>> findAll1() {
		String sql = "SELECT * FROM `good` ORDER BY `good`.`ID` ASC";
		ArrayList<HashMap<String, String>> data = db.query(sql);
		System.err.println("goodsDAO :  "+  sql);
		return data;
	}

}
