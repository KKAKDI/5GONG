package tkl.json;

import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class createJson {	

	 
	JSONObject jsobj;
	JSONArray memArray; 
	JSONObject memInfo;
	public createJson(){
		 jsobj = new JSONObject();		
		 memArray = new JSONArray();		
	}
	public String list() {		
		 memInfo = new JSONObject();			
		memInfo.put("email","TKL@take.look");
		memInfo.put("nick", "admin");
		memArray.add(memInfo);
		
		memInfo = new JSONObject();
		memInfo.put("email","guest@take.look");
		memInfo.put("nick","guest");
		memArray.add(memInfo);
		
		jsobj.put("member", memArray);
		
		String jsonInfo = jsobj.toJSONString();		
		
		
		return jsonInfo;
	}
}
