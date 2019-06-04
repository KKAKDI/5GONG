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
			}else if(m.equals("updateList")) {
				
			}else if(m.equals("update")) {
	            
			}else if(m.equals("replyList")) {
				
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
		ArrayList<ReportDTO> list = service.selectS();
		request.setAttribute("list",  list);
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
	    String rFileCopy = mr.getFilesystemName("rFileCopy");
	    System.out.println("rFileCopy : " + rFileCopy);
	    String rFile = mr.getOriginalFileName("rFile"); 
	    System.out.println("rFile : " + rFile);
	       
		String rSubject = mr.getParameter("rSubject");
		System.out.println("rSubject : " + rSubject);
		String rContent = mr.getParameter("rContent");
		System.out.println("rContent : " + rContent);
		String rNick = mr.getParameter("rNick");
		System.out.println("rNick : " + rNick);

		ReportDTO dto = new ReportDTO(-1, rSubject, rContent, rFile, rFileCopy, null, rNick, null, null); // -1 은 통상 의미없는 숫자를 넣을떄
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

}
