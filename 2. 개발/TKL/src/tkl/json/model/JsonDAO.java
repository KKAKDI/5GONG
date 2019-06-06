package tkl.json.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JsonDAO {	
	JSONObject jsobj;
	JSONArray memArray; 
	JSONObject memInfo;
	private DataSource ds;
	
	JsonDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			System.out.println("JsonDAO : " + ne);
		}
	}
	String list() {	
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		 jsobj = new JSONObject();		
		 memArray = new JSONArray();			
		 String jsonInfo = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(JsonSQL.SQL_MEM);
			while(rs.next()) {
				String mNick = rs.getString("M_NICK");
				String mEmail = rs.getString("M_EMAIL");
				memInfo = new JSONObject();	
				memInfo.put("email",mEmail);
				memInfo.put("nick",mNick);
				memArray.add(memInfo);				
				jsobj.put("member", memArray);							
			}
			jsonInfo = jsobj.toJSONString();
			return jsonInfo;
		} catch (SQLException se) {			
			System.out.println(se);
			return null;
		}
	}
}
