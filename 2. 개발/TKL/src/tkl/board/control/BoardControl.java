package tkl.board.control;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import tkl.board.model.BoardDTO;
import tkl.board.model.BoardService;

@WebServlet("/board.do")
public class BoardControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		String cp = request.getParameter("currentPage");
		if(m != null) {
			m = m.trim();
			if (m.equals("board_list")) {
				boardList(request, response);
			}else if(m.equals("board_input")) {
				boardInform(request, response);
				
			}else if(m.equals("board_in")) {
				boardIn(request, response);
			}else if(m.equals("board_content")) {
				boardContent(request, response);
			}
		}else {
			boardList(request, response);
		}
	}
	private void boardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		BoardDTO dto = new BoardDTO();
		ArrayList<BoardDTO> list = service.boardList();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("tklBoard/board_list.jsp");
		rd.forward(request, response);
	}
	private void boardInform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("tklBoard/board_input.jsp");
		rd.forward(request, response);
	}
	private void boardIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/image");
		System.out.println("saveDir : "+saveDir);
		int maxPostSize = 10*1028*1028;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxPostSize, encoding, policy);
		String bImgCopy = mr.getFilesystemName("bImg");
		System.out.println("filename : "+bImgCopy);
		String bImg = mr.getOriginalFileName("bImg");
		String mNick = mr.getParameter("mNick");
		System.out.println("mNick : "+mNick);
		String eMail = mr.getParameter("eMail");
		String bSubejct = mr.getParameter("bSubejct");
		String bContent = mr.getParameter("bContent");
		String homepage = mr.getParameter("homepage");
		String pwd = mr.getParameter("pwd");
		BoardDTO dto = new BoardDTO(-1, eMail,mNick,bSubejct,bContent,bImg,bImgCopy,-1,-1,null);
		BoardService service = BoardService.getInstance();
		service.insertS(dto);
		System.out.println("파일 업로드 성공");
		response.sendRedirect("board.do");
	}
	private void boardContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}