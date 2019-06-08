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
	JSONArray memArray,actArray; 
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
		 actArray = new JSONArray();		
		 String jsonInfo = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(JsonSQL.SQL_MEM);
			while(rs.next()) {
				String mNick = rs.getString("M_NICK");
				String mEmail = rs.getString("M_EMAIL");
				String mPhone = rs.getString("M_PHONE");
				String mName = rs.getString("M_NAME");
				String mAct = rs.getString("M_ACCOUNT");
				String mBank = rs.getString("M_BANK");
				String mPwd = rs.getString("M_PASSWORD");
				memInfo = new JSONObject();	
				memInfo.put("email",mEmail);
				memInfo.put("pwd",mPwd);
				memInfo.put("nick",mNick);
				memInfo.put("name",mName);
				memInfo.put("phone",mPhone);
				memInfo.put("bank",mBank);
				memInfo.put("actnum",mAct);
				memArray.add(memInfo);				
				jsobj.put("member", memArray);							
			}			
			rs = stmt.executeQuery(JsonSQL.SQL_REF);
			while(rs.next()) {
				String phone = rs.getString("PHONE");
				String name = rs.getString("NAME");
				String bank = rs.getString("BANK");
				String actNum = rs.getString("ACT_NUMBER");
				String actHold = rs.getString("ACT_HOLDER");
				memInfo = new JSONObject();	
				memInfo.put("phone",phone);
				memInfo.put("name",name);
				memInfo.put("bank",bank);
				memInfo.put("actnum",actNum);
				memInfo.put("actname",actHold);
				actArray.add(memInfo);	
				jsobj.put("actinfo", actArray);
			}
			jsonInfo = jsobj.toJSONString();
			return jsonInfo;
		} catch (SQLException se) {			
			System.out.println(se);
			return null;
		}
	}
}
