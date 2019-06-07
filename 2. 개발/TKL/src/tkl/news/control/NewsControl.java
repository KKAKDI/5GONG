package tkl.news.control;

import java.io.IOException;  
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tkl.news.model.NewsDTO;
import tkl.news.model.NewsService;

@WebServlet("/news.do")
public class NewsControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m= m.trim();
			if(m.equals("in_form")) {	
				in_form(request, response);
			}else if(m.equals("in")) {
				in(request, response);
			}else if(m.equals("con")){
				con(request,response);
			}else if(m.equals("del")) {
				del(request, response);
			}else if(m.equals("updateview")) {
				updateview(request,response);
			}else if(m.equals("update")) {
				update(request,response);
			}else {
				list(request, response);
			}
		}else {
			list(request, response);
		}	
	}
	public void list (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		NewsService service = NewsService.getInstance();
		ArrayList<NewsDTO> list = service.selectS();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("news/news_list.jsp");
		rd.forward(request,response);

	}
	public void in_form(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.sendRedirect("news/news_reg.jsp");

	}
	public void in(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//String n_email = request.getParameter("n_email");
		String n_nick = request.getParameter("n_nick");
		String n_subject = request.getParameter("n_subject");
		String n_content = request.getParameter("n_content");
		String n_division = request.getParameter("n_division");	
		NewsDTO dto = new NewsDTO();
		//dto.setN_email(n_email);
		dto.setN_nick(n_nick);
		dto.setN_subject(n_subject);
		dto.setN_content(n_content);
		dto.setN_division(n_division);
		NewsService service = NewsService.getInstance();
		service.inserts(dto);
		response.sendRedirect("news.do");

	}
	public void con(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		NewsService service = NewsService.getInstance();
		String n_noStr = request.getParameter("n_no");
		int n_no = Integer.parseInt(n_noStr);
		// 쿠키 시작

		//쿠키변수를 만들어서 값을 저장. 쿠키변수에 값이 있으면 조회수 증가 실행 하지 않음
		boolean isGet=false;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){   
			for(Cookie c: cookies){//    
				//num쿠키가 있는 경우
				if(c.getName().equals("coocie"+n_no)){
					isGet=true; 
				}
			}
			// num쿠키가 없는 경우
			if(!isGet) {
				service.viewU(n_no);//조회수증가
				Cookie c1 = new Cookie("coocie"+n_no, "coocie"+n_no); 
				c1.setMaxAge(1*24*60*60);//하루저장
				response.addCookie(c1);    
			}
		}
		NewsDTO con = service.contentS(n_no);
		request.setAttribute("con", con);
		RequestDispatcher rd = request.getRequestDispatcher("news/news_content.jsp");
		rd.forward(request, response);

	}
	public void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		int n_no = getN_no(request);
		System.out.println(n_no);
		if(n_no != -1) {
			NewsService service = NewsService.getInstance();
			service.deleteD(n_no);
		}else {}
		response.sendRedirect("news.do");	
	}

	public void updateview(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String n_noStr = request.getParameter("n_no");
		n_noStr = n_noStr.trim();
		int n_no = Integer.parseInt(n_noStr);	
		String n_nick = request.getParameter("n_nick");
		String  n_subject = request.getParameter("n_subject");
		String n_content = request.getParameter("n_content");
		String n_division =request.getParameter("n_division");
		NewsService service = NewsService.getInstance();
		NewsDTO dto  = new NewsDTO();
		dto.setN_no(n_no);
		dto.setN_nick(n_nick);
		dto.setN_subject(n_subject);
		dto.setN_content(n_content);
		dto.setN_division(n_division);
		NewsDTO updateview = service.updateviewU(dto);
		request.setAttribute("updateview", updateview);
		RequestDispatcher rd= request.getRequestDispatcher("news/news_update.jsp");
		rd.forward(request, response);

	}
	public void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String n_subject = request.getParameter("n_subject");
		String n_content = request.getParameter("n_content");
		String n_noStr = request.getParameter("n_no");
		n_noStr = n_noStr.trim();
		int n_no = Integer.parseInt(n_noStr);
		NewsDTO dto = new NewsDTO();
		dto.setN_subject(n_subject);
		dto.setN_content(n_content);
		dto.setN_no(n_no);
		NewsService service = NewsService.getInstance();
		service.updateU(dto);
		response.sendRedirect("news.do");
	}
	private int getN_no(HttpServletRequest request) {
		int n_no = -1;
		String n_noStr = request.getParameter("n_no");
		if(n_noStr != null) {
			n_noStr = n_noStr.trim();
			if(n_noStr.length() != 0) {
				try {
					n_no = Integer.parseInt(n_noStr);
					return n_no;
				}catch(NumberFormatException ne) {
					System.out.println("숫자의 형태가 아닌 n_no가 넘어온 경우");
					return -1;
				}
			}else {
				System.out.println("n_no의 길이가 0인 경우");
				return -1;
			}
		}else {
			System.out.println("n_no가 넘어오지 않은 경우");
			return -1;
		}
	}
}


