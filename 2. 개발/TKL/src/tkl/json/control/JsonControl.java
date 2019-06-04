package tkl.json.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tklJson")
public class JsonControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String j = request.getParameter("j");
		if(j!=null) {
			
		}else {
			jsonList(request,response);
		}
	}
}
