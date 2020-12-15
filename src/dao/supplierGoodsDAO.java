package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.connect;

public class supplierGoodsDAO {
	connect db;

	public supplierGoodsDAO() {

		db = new connect();

	}

	public int Insert(int ID, int supplier_id , int GOOD_ID) {
		String sql = "INSERT INTO supplier_good VALUES (" + ID + ", " + "'" + supplier_id + "', "
				+ "'" + GOOD_ID + "')";
		System.out.println("supplierGoodsDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public int update(int ID, int supplier_id , int GOOD_ID) {
		String sql = "UPDATE supplier_good SET ID = '" + ID + "'" + ",supplier_id='" + supplier_id
				+ "',GOOD_ID='" + GOOD_ID + "' WHERE ID =" + ID + " ";
		System.out.println("supplierGoodsDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public int delete(int ID) {
		String sql = "DELETE FROM supplier_good WHERE ID = " + ID + "";
		System.out.println("supplierGoodsDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public ArrayList<HashMap<String, String>> findAll() {
		String sql = "SELECT supplier_good.ID  , GOOD_NAME , UNITCOST  , UNITPRICE , supplier.SUPPLIER_ID , supplier.SUPPLIER_NAME ,supplier.SUPPLIER_ADDRESS,supplier_good.GOOD_ID\r\n" + 
				"FROM good , supplier , supplier_good\r\n" + 
				"WHERE supplier_good.GOOD_ID=good.ID \r\n" + 
				"AND supplier_good.SUPPLIER_ID=supplier.SUPPLIER_ID";
		System.out.println("supplierGoodsDAO :  ");
		System.err.println(sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}

	public ArrayList<HashMap<String, String>> findAll1() {
		String sql = "SELECT supplier_good.ID  , GOOD_NAME , UNITCOST  , UNITPRICE , supplier.SUPPLIER_ID , supplier.SUPPLIER_NAME ,supplier.SUPPLIER_ADDRESS,supplier_good.GOOD_ID\r\n" + 
				"FROM good , supplier , supplier_good\r\n" + 
				"WHERE supplier_good.GOOD_ID=good.ID \r\n" + 
				"AND supplier_good.SUPPLIER_ID=supplier.SUPPLIER_ID";
		System.err.println("supplierGoodsDAO :  "+  sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}
}
