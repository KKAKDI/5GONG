package tkl.member.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tkl.member.model.MamberDTO;
import tkl.member.model.MemberDAO;
import tkl.member.model.MemberService;


@WebServlet("/member.do")
public class MemberControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		if(m!=null) {
			m = m.trim();
			if(m.equals("insert")) {
				insert(request,response);
			}else if(m.equals("signin")) {
				signIn(request,response);
			}else if (m.equals("out")) {
				logout(request, response);
			}
		}else {			
		}
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int actNum = 0;
		int phone = 0;
		String email = request.getParameter("email");
		String phoneStr = request.getParameter("phone");
		phoneStr.trim();
		if(phoneStr!=null) {
			phone = Integer.parseInt(phoneStr);
		}
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd2");
		String nick = request.getParameter("nick");
		String bank = request.getParameter("bank");
		String actNumStr = request.getParameter("actnum");
		actNumStr.trim();
		if(actNumStr!=null) {
			actNum = Integer.parseInt(actNumStr);
		}
		//String actName = request.getParameter("actname"); 예금주
		MamberDTO dto = new MamberDTO();
		dto.setEmail(email);
		dto.setNick(nick);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setBank(bank);
		dto.setActNum(actNum);
		dto.setPhone(phone);
		MemberService service = MemberService.getInstance();
		service.insertS(dto);
		response.sendRedirect("index.do");		
	}
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.do");
	}
	
	protected void signIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");	
		MamberDTO inMem = new MamberDTO();
		inMem.setEmail(email);
		inMem.setPwd(pwd);
		MemberDAO dao = new MemberDAO();
		MamberDTO outMem = dao.getMem(inMem);		
		if(outMem==null) {
			response.sendRedirect("sign_in.jsp?e=1");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("session_email", outMem.getEmail());
			session.setAttribute("session_nick",outMem.getNick());
			response.sendRedirect("index.do");
			}
	}
}
