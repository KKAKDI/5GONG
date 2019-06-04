package tkl.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class createJson {

	public createJson(){
		JSONObject jsobj = new JSONObject();
		
		JSONArray memArray = new JSONArray();
		JSONObject memInfo = new JSONObject();
		
		memInfo.put("email","TKL@take.look");
		memInfo.put("nick", "admin");
		memArray.add(memInfo);
		
		memInfo = new JSONObject();
		memInfo.put("email","guest@take.look");
		memInfo.put("nick","guest");
		memArray.add(memInfo);
		
		jsobj.put("member", memArray);
		
		String jsonInfo = jsobj.toJSONString();
		
		System.out.print(jsonInfo);
	}
	
	public static void main(String args[]) {
		createJson cj = new createJson();
	}
}
