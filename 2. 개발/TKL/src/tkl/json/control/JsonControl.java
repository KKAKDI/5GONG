package tkl.json.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tkl.json.model.JsonDAO;
import tkl.json.model.JsonService;

@WebServlet("/json.do")
public class JsonControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		JsonService service = JsonService.getInstance();
		String jsonlist = service.jsonList();
		request.setAttribute("jsonlist", jsonlist);
		RequestDispatcher rd = request.getRequestDispatcher("json.jsp"); 
		rd.forward(request, response);
	}	
}
