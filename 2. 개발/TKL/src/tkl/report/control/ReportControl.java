package tkl.report.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import tkl.report.model.ReportDTO;
import tkl.report.model.ReportService;

@WebServlet("/rBoard.do")
public class ReportControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("in_form")) {
				in_form(request, response);
			}else if(m.equals("in")) {
				in(request, response);
			}else if(m.equals("del")) {	
				del(request, response);
			}else if(m.equals("content")) {
				content(request, response);
			}else if(m.equals("fileDownLoad")) {
				fileDownLoad(request, response);
			}else if(m.equals("rIn_form")) {
				rIn_form(request, response);
			}else if(m.equals("rIn")) {
				rIn(request, response);
			}else if(m.equals("reply")) {
				
			}else {
				list(request, response);
			}
		}else {
			list(request, response);
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportService service = ReportService.getInstance();
		String pageStr = request.getParameter("pg");
		String searchKey = request.getParameter("searchKey");
		HttpSession session = request.getSession();
		String sessionNick  = (String)session.getAttribute("session_nick");
		String sessionGrant = (String)session.getAttribute("session_grant"); 
		System.out.println("searchKey : " + searchKey);
		int rowCnt = 5;
		int page = 1;
		
		if(pageStr!=null) {//page 가 초기값이 아닌 경우 저장
			page = Integer.parseInt(pageStr);
		}
		
		int begin =(page*rowCnt)-(rowCnt-1);// 2x5-4
		int end =(page*rowCnt);//2x5 
		
		ArrayList<ReportDTO> list = null;
		int total = 0;
			
		if(searchKey == null) {
			list = service.selectS(sessionNick, sessionGrant, searchKey, begin, end);
			total = service.getTotalS(sessionNick, 0, 1);
			System.out.println("sessionNick : " + sessionNick + ",searchKey : " + searchKey + ", 0, 1," + " begin : " + begin + ", end : " + end + ", total : " + total);
		}else if(searchKey.equals("listR")) {
			list = service.selectS(sessionNick, sessionGrant, searchKey, begin, end);
			total = service.getTotalS(sessionNick, 0, 0);
			System.out.println("sessionNick : " + sessionNick + ",searchKey : " + searchKey + ", 0, 0," + " begin : " + begin + ", end : " + end + ", total : " + total);
		}else if(searchKey.equals("listC")) {
			list = service.selectS(sessionNick, sessionGrant, searchKey, begin, end);
			total = service.getTotalS(sessionNick, 1, 1);
			System.out.println("sessionNick : " + sessionNick + ",searchKey : " + searchKey + ", 1, 1," + " begin : " + begin + ", end : " + end + ", total : " + total);
		}else {
			list = service.selectS(sessionNick, sessionGrant, searchKey, begin, end);
			total = service.getTotalS(sessionNick, 0, 1);
			System.out.println("sessionNick : " + sessionNick + ",searchKey : " + searchKey + ", 0, 1," + " begin : " + begin + ", end : " + end + ", total : " + total);
		}
		int allPage = (int)Math.ceil(total/(double)rowCnt);
		int block = 5;
		
		int fromPage= ((page-1)/block*block)+1;
		int toPage = ((page-1)/block*block)+block;
		if(toPage>allPage) {
			toPage=allPage;
		}
		
		request.setAttribute("list",  list);
		request.setAttribute("page", page);
		request.setAttribute("fromPage", fromPage);
		request.setAttribute("toPage", toPage);
		request.setAttribute("allPage", allPage);		
		request.setAttribute("block", block);
		
		RequestDispatcher rd = request.getRequestDispatcher("report/list.jsp");
		rd.forward(request, response);
	}
	protected void in_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("report/input.jsp");
	}
	protected void in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
	    String saveDir = sc.getRealPath("/file/report");
	    int maxPostSize = 1*1028*1028;
	    String encoding = "utf-8";
	    FileRenamePolicy policy = new DefaultFileRenamePolicy();
	    System.out.println("saveDir:" + saveDir);
		MultipartRequest mr = new MultipartRequest(
				request, saveDir, maxPostSize, encoding, policy); 
		//String fwriter = mr.getParameter("writer");
	    String rFileCopy = mr.getFilesystemName("rFile");
	    System.out.println("rFileCopy : " + rFileCopy);
	    String rFile = mr.getOriginalFileName("rFile"); 
	    System.out.println("rFile : " + rFile);
	       
		String rSubject = mr.getParameter("rSubject");
		System.out.println("rSubject : " + rSubject);
		String rContent = mr.getParameter("rContent");
		System.out.println("rContent : " + rContent);
		String rNick = mr.getParameter("rNick");
		System.out.println("rNick : " + rNick);
		String rClass = mr.getParameter("rClass");
		System.out.println("rClass : " + rClass);
		String rReply = "신고가 처리 중 이며, 빠른시일 내에 답변 예정입니다.";
		ReportDTO dto = new ReportDTO(-1, rSubject, rContent, rFile, rFileCopy, null, rNick, null, null, rReply, rClass); // -1 은 통상 의미없는 숫자를 넣을떄
		ReportService service = ReportService.getInstance();
		service.insertS(dto);
		//list(request, response); // 새로 고침 시 계속 생성됨 아래 것으로 사용
		response.sendRedirect("rBoard.do");
	}
	protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/file/report");
		String rFile = request.getParameter("rFile");
		File file = new File(saveDir, rFile);
		if(file.exists()) {
			file.delete();
		}
		int rNO = getrNO(request);
		if(rNO != -1) {
			ReportService service = ReportService.getInstance();
			service.deleteS(rNO);
		}else {
		}
		response.sendRedirect("rBoard.do");
	}
	protected void content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportService service = ReportService.getInstance();
		int rNO = getrNO(request);
		ReportDTO dtoContent = service.contentS(rNO);
		request.setAttribute("dtoContent",  dtoContent);
		RequestDispatcher rd = request.getRequestDispatcher("report/content.jsp");
		rd.forward(request, response);
	}
	
	protected void fileDownLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/file/report");
       
		String fileName = new String(request.getParameter("rFile"));
		File file = new File(saveDir +"/"+fileName);
		response.setContentType("application/octet-stream"); 
		String Agent=request.getHeader("USER-AGENT");
		if( Agent.indexOf("MSIE") >= 0 ){
			int i = Agent.indexOf( 'M', 2 );
			String IEV = Agent.substring( i + 5, i + 8 );
			if( IEV.equalsIgnoreCase("5.5") ){
				response.setHeader("Content-Disposition", "filename=" + new String( fileName.getBytes("utf-8"), "8859_1") );
			}else{
				response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"8859_1"));
			}
		}else{
			response.setHeader("Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("utf-8"), "8859_1") );
		}

		byte b[] = new byte[1024];
		if( file.isFile()){ 
			try{ 
				BufferedInputStream fin = new BufferedInputStream( new FileInputStream( file ) );  
				BufferedOutputStream outs = new BufferedOutputStream( response.getOutputStream() );  

				int read = 0;
				while( ( read = fin.read( b ) ) != -1 ){  
					outs.write(b,0,read);
				}
				outs.flush();
				outs.close();  
				fin.close(); 
			}catch( Exception e ){}
		}
	}
	
	private int getrNO(HttpServletRequest request) {
		String rNOStr = request.getParameter("rNO");
		if(rNOStr != null) {
			rNOStr = rNOStr.trim();
			if(rNOStr.length() != 0) {
				try {
					int rNO = Integer.parseInt(rNOStr);
					return rNO;
				}catch(NumberFormatException ne) {
					System.out.println("숫자의 형태가 아닌 rNo가 넘어온 경우");
					return -1;
				}
			}else {
				System.out.println("rNo의 길이가 0인 경우");
				return -1;
			}
		}else {
			System.out.println("rNo가 넘어오지 않은 경우");
			return -1;
		}
	}
	protected void rIn_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportService service = ReportService.getInstance();
		int rNO = getrNO(request);
		ReportDTO dtoContent = service.contentS(rNO);
		request.setAttribute("dtoContent",  dtoContent);
		RequestDispatcher rd = request.getRequestDispatcher("report/rInput.jsp");
		rd.forward(request, response);
	}
	protected void rIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rReply = request.getParameter("rReply");
		int rNO = getrNO(request);
		ReportDTO dto = new ReportDTO(rNO, null, null, null, null, null, null, null, null, rReply, null); // -1 은 통상 의미없는 숫자를 넣을떄
		ReportService service = ReportService.getInstance();
		service.updateS(dto);
		//list(request, response); // 새로 고침 시 계속 생성됨 아래 것으로 사용
		response.sendRedirect("rBoard.do");
	}

}
