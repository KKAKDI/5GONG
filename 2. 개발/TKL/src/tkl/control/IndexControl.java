package tkl.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index.do")
public class IndexControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		System.out.println(m);
		if(m!=null) {
			m=m.trim();
			if(m.equals("kakao")) {
				kakao(request,response);
			}
		}else {
			response.sendRedirect("index.jsp");
		}		
	}
	public void kakao(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nick = request.getParameter("nick");
		System.out.println(nick);
		HttpSession session = request.getSession();
		session.setAttribute("session_nick", nick);
		response.sendRedirect("index.jsp");
	}
}
