package database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class connect {
		public static Connection getConnect(){
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/project2?user=root&password=");
				if(con==null) {
					System.out.println("ERROR Database CONNECT!");
				} else if (con != null){
					System.out.println("CONNECT DATABASE :::::::: project2 ::::::: SUCCESSFULLY!");
				}
				return con;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		



		public ArrayList<HashMap<String,String>> query(String sql){
			ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
			try {
				Connection con = getConnect();
				Statement st = con.createStatement();
				ResultSet result = st.executeQuery(sql);
				ResultSetMetaData meta = result.getMetaData();
					while(result.next()){
						HashMap<String,String> inList = new HashMap<String,String>();
						for(int i=0;i<meta.getColumnCount();i++) {
							inList.put(meta.getColumnName(i+1),result.getString(i+1));
						}
						list.add(inList);
					}
				con.close();
				st.close();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public int update(String sql,String[] param) {
			int status = -1;
			try {
				Connection con = getConnect();
				Statement st = con.createStatement();
				status = st.executeUpdate(sql,param);
				con.close();
				st.close();
				return status;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}

}
