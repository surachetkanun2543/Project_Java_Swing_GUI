package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.connect;

public class purchaseDetDAO {

	connect db;
	
	String confirm = "confirm";
	String no_confirm = "no confirm";

	public purchaseDetDAO() {

		db = new connect();

	}
	
	public int Insert(int PURCHASE_ID ) {
		String sql = "UPDATE PURCHASE SET STATUS = '" +confirm+ "' WHERE PURCHASE_ID =" + PURCHASE_ID + " ";
		System.out.println("purchaseDetDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public int Insert2(int PURCHASE_ID){
		String sql = "INSERT INTO stock SELECT GOOD_ID  , QUANTITY FROM purchase_det WHERE ID = " + PURCHASE_ID + " ";
		System.out.println("purchaseDetDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}
	
	public int delete(int PURCHASE_ID) {
		String sql = "UPDATE PURCHASE SET STATUS = '" +no_confirm+ "' WHERE PURCHASE_ID =" + PURCHASE_ID + " ";
		System.out.println("CANCEL ID :  " + PURCHASE_ID);
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public ArrayList<HashMap<String, String>> findAll() {
		String sql = "SELECT `purchase`.`PURCHASE_ID` AS PURCHASE_ID, supplier_id AS SUPPLIER_ID , purchase_det.good_Id AS GOOD_ID , good.GOOD_NAME, purchase_date AS PURCHASE_DATE , RECEIVE_DATE  , status AS STATUS, purchase_det.quantity AS QUANTITY ,  good.UNITPRICE*purchase_det.QUANTITY AS TOTAL_AMOUNT \r\n"
				+ "				FROM purchase , purchase_det , good \r\n"
				+ "				WHERE `purchase`.`PURCHASE_ID` = purchase_det.purchase_Id \r\n"
				+ "				AND good.ID=purchase_det.GOOD_ID  ORDER BY purchase_Id ASC";
		System.out.println("purchaseDetDAO :  ");
		System.err.println(sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}

	public ArrayList<HashMap<String, String>> findAll1() {
		String sql = "SELECT `purchase`.`PURCHASE_ID` AS PURCHASE_ID, supplier_id AS SUPPLIER_ID , purchase_det.good_Id AS GOOD_ID , good.GOOD_NAME, purchase_date AS PURCHASE_DATE , RECEIVE_DATE  , status AS STATUS, purchase_det.quantity AS QUANTITY ,  good.UNITPRICE*purchase_det.QUANTITY AS TOTAL_AMOUNT \r\n"
				+ "				FROM purchase , purchase_det , good \r\n"
				+ "				WHERE `purchase`.`PURCHASE_ID` = purchase_det.purchase_Id \r\n"
				+ "				AND good.ID=purchase_det.GOOD_ID  ORDER BY purchase_Id ASC";
		System.out.println("purchaseDetDAO :  ");
		System.err.println(sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}

}
