package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.connect;

public class purchaseDAO {

	connect db;

	public purchaseDAO() {

		db = new connect();

	}

	public int Insert(int PURCHASE_ID, int supplier_id, String purchase_date, String status, String receive_date,
			double TOTAL_AMOUNT) {
		String sql = "INSERT INTO PURCHASE VALUES ('" + PURCHASE_ID + "','" + supplier_id + "'," + "'" + purchase_date
				+ "'," + "'" + status + "'," + "'" + receive_date + "', " + "'" + TOTAL_AMOUNT + "')";
		System.out.println("purchaseDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public int Insert2(int ID, int purchase_Id, int goods_Id, int quantity) {
		String sql = "INSERT INTO PURCHASE_DET VALUES ('" + ID + "','" + purchase_Id + "','" + goods_Id + "'," + "'"
				+ quantity + "')";
		System.out.println("purchaseDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public int update(int PURCHASE_ID, int supplier_id, String purchase_date, String status, String receive_date,
			double TOTAL_AMOUNT) {
		String sql = "UPDATE purchase SET supplier_id = '" + supplier_id + "'" + ", purchase_date='" + purchase_date
				+ "', status='" + status + "', receive_date='" + receive_date + "', TOTAL_AMOUNT='" + TOTAL_AMOUNT
				+ "' WHERE PURCHASE_ID =" + PURCHASE_ID + " ";
		System.out.println("purchaseDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}

	public int update1(int ID, int purchase_Id, int GOOD_ID, int quantity) {
		String sql = "UPDATE purchase_det SET purchase_Id = '" + purchase_Id + "'" + ", GOOD_ID='" + GOOD_ID
				+ "', quantity='" + quantity + "' WHERE purchase_Id =" + purchase_Id + " ";
		System.out.println("purchaseDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "ID" });
	}

	public int delete(int PURCHASE_ID) {
		String sql = "DELETE FROM purchase WHERE PURCHASE_ID = " + PURCHASE_ID + "";
		System.out.println("purchaseDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public int delete1(int ID) {
		String sql = "DELETE FROM purchase_det WHERE ID = " + ID + "";
		System.out.println("purchaseDAO :  ");
		System.err.println(sql);
		return db.update(sql, new String[] { "Id" });
	}

	public ArrayList<HashMap<String, String>> findAll() {
		String sql = "SELECT `purchase`.`PURCHASE_ID` AS PURCHASE_ID, supplier_id AS SUPPLIER_ID , purchase_date AS PURCHASE_DATE , status AS STATUS, purchase_det.good_Id AS GOOD_ID ,purchase_det.quantity AS QUANTITY , good.GOOD_NAME, good.UNITPRICE*purchase_det.QUANTITY AS TOTAL_AMOUNT \r\n"
				+ "FROM purchase , purchase_det , good \r\n"
				+ "WHERE `purchase`.`PURCHASE_ID` = purchase_det.purchase_Id \r\n"
				+ "AND good.ID=purchase_det.GOOD_ID ORDER BY purchase_Id ASC";
		System.out.println("purchaseDAO :  ");
		System.err.println(sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}

	public ArrayList<HashMap<String, String>> findAll1() {
		String sql = "SELECT `purchase`.`PURCHASE_ID` AS PURCHASE_ID, supplier_id AS SUPPLIER_ID , purchase_date AS PURCHASE_DATE , status AS STATUS, purchase_det.good_Id AS GOOD_ID ,purchase_det.quantity AS QUANTITY , good.GOOD_NAME, good.UNTPRICE*purchase_det.QUANTITY AS TOTAL_AMOUNT \r\n"
				+ "FROM purchase , purchase_det , good \r\n"
				+ "WHERE `purchase`.`PURCHASE_ID` = purchase_det.purchase_Id \r\n"
				+ "AND good.ID=purchase_det.GOOD_ID ORDER BY purchase_Id ASC";
		System.out.println("purchaseDAO :  ");
		System.err.println(sql);
		ArrayList<HashMap<String, String>> data = db.query(sql);
		return data;
	}
		
		public ArrayList<HashMap<String, String>> findAll2() {
			String sql = "SELECT * FROM good";
			System.out.println("purchaseDAO :  ");
			System.err.println(sql);
			ArrayList<HashMap<String, String>> data = db.query(sql);
			return data;
	}
}
