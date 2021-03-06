package tkl.board.control;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.websocket.Session;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import tkl.bPaging.model.PagingDTO;
import tkl.bPaging.model.PagingService;
import tkl.bReply.model.ReplyDTO;
import tkl.bReply.model.ReplyService;
import tkl.board.model.BoardDTO;
import tkl.board.model.BoardSQL;
import tkl.board.model.BoardService;

@WebServlet("/board.do")
public class BoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");

		if (m != null) {
			m = m.trim();
			if (m.equals("board_list")) {
				boardList(request, response);
			} else if (m.equals("board_input")) {
				boardInform(request, response);
			} else if (m.equals("board_in")) {
				boardIn(request, response);
			} else if (m.equals("board_content")) {
				boardContent(request, response);
			} else if (m.equals("board_delete")) {
				boardDelete(request, response);
			} else if (m.equals("board_update_form")) {
				boardUpdateForm(request, response);
			} else if (m.equals("board_update")) {
				boardUpdate(request, response);
			} else if (m.equals("board_download")) {
				boardDownload(request, response);
			} else if (m.equals("replyIn")) {
				replyIn(request, response);
			} else if (m.equals("reply_delete")) {
				replyDelete(request, response);
			} else if (m.equals("board_like")) {
				boardLike(request, response);
//			} else if (m.equals("board_like_list")) {
//				boardLikeList(request,response);
			}
		}else {
				boardList(request, response);
		}
	}

	private void boardList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ReplyService rService = ReplyService.getInstance();
		PagingService pService = PagingService.getInstance();
		String currentPageStr = request.getParameter("currentPage");
		String b = request.getParameter("b");
		String sk = request.getParameter("sk");
		String sv = request.getParameter("sv");
		request.setAttribute("sk", sk);
		request.setAttribute("sv", sv);

		//페이징 기능 시작
		int i = searchCheck(sk, sv);
		if (currentPageStr == null) {
			int currentPage = 0;
			request.setAttribute("currentPage", currentPage);
		} else {
			int currentPage = Integer.parseInt(currentPageStr);
			request.setAttribute("currentPage", currentPage);
		}
		int curBlock = 0;
		if (request.getParameter("curBlock") != null) {
			curBlock = Integer.parseInt(request.getParameter("curBlock"));
		}
		int curPage = 0;
		if (request.getParameter("curPage") != null) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}

		int pageSizePerBlock = 3;
		if (request.getAttribute("curBlock") != null) {
			curBlock = Integer.parseInt(request.getAttribute("curBlock").toString());
		}
		int totalRecodeSize = pService.PagingRowNumS(i, sv);
		curPage = curBlock * pageSizePerBlock;
		if (request.getParameter("curPage") != null) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		int recodeSizePerPage = 5;//내가 알기론 이거 한페이지 나올수 있는 리스트 
		int beginNum = curPage * recodeSizePerPage;
		int pageSize = (int) Math.ceil((double) totalRecodeSize / recodeSizePerPage);
		//이거는 아래 i 이다
		int startPage = curBlock * pageSizePerBlock;
		int endPage = startPage + pageSizePerBlock;
		
		
		
		///// 자료 집어넣기
		
		request.setAttribute("pageSizePerBlock", pageSizePerBlock);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("recodeSizePerPage", recodeSizePerPage);
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("totalRecodeSize", totalRecodeSize);
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("curPage", curPage);
		request.setAttribute("curBlock", curBlock);

		///그냥 리스트
		BoardDTO dto = new BoardDTO();
		ArrayList<BoardDTO> list = service.boardList(sk, sv);
		request.setAttribute("list", list);
		

		RequestDispatcher rd = request.getRequestDispatcher("board/board_list.jsp");
		rd.forward(request, response);

	}

	private void boardInform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("board/board_input.jsp");
	}

	private void boardIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/img");
		System.out.println("saveDir : " + saveDir);
		int maxPostSize = 10 * 1028 * 1028;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxPostSize, encoding, policy);
		String bImgCopy = mr.getFilesystemName("bImg");
		String bImg = mr.getOriginalFileName("bImg");
		System.out.println("bImg: " + bImg);
		String mNick = (String)session.getAttribute("session_nick");
		System.out.println("mNick : "+mNick);
		String eMail = (String)session.getAttribute("session_email");
		System.out.println("eMail : "+eMail);
		System.out.println("세션 아이디 : "+(String)session.getAttribute("session_nick"));
		String bSubject = mr.getParameter("bSubject");
		String bContent = mr.getParameter("bContent");
		String homepage = mr.getParameter("homepage");
		String pwd = mr.getParameter("pwd");
		BoardDTO dto = new BoardDTO(-1, eMail, mNick, bSubject, bContent, bImg, bImgCopy, -1, -1, null, -1);
		BoardService service = BoardService.getInstance();
		service.insertS(dto);
		response.sendRedirect("board.do?m=board_list");
	}

	private void boardContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		
		
		// 추천 리스트 확인하는거
		ArrayList <String> likeList = new ArrayList<String>();
		ReplyService rService = ReplyService.getInstance();
		likeList = rService.replyLikeListS(bNo);
		request.setAttribute("likeList", likeList);
		

		// 쿠키 시작
		boolean isGet = false;
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {//
			// num��Ű�� �ִ� ���
			System.out.println("��Ű�̸� : " + c.getName());

		}

		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("coocie" + bNo)) {
					isGet = true;
				}
			}
			if (!isGet) {
				service.boardViewS(bNo);
				Cookie c1 = new Cookie("coocie" + bNo, "coocie" + bNo);
				c1.setMaxAge(1 * 24 * 60 * 60);
				response.addCookie(c1);
			}
		}
 
		BoardDTO dto = service.boardContentS(bNo);
		request.setAttribute("dto", dto);  
		
		ArrayList<ReplyDTO> list = rService.replyListS(bNo);

		request.setAttribute("rList", list);
		RequestDispatcher rd = request.getRequestDispatcher("board/board_content.jsp");
		rd.forward(request, response);

	}

	private void boardUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardService service = BoardService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		BoardDTO dto = service.boardContentS(bNo);
		request.setAttribute("dto", dto);
		RequestDispatcher rd = request.getRequestDispatcher("board/board_update.jsp");
		rd.forward(request, response);

	}

	private void boardUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardService service = BoardService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String bSubject = request.getParameter("bSubject");
		System.out.println("bSubject : " + bSubject);
		String bContent = request.getParameter("bContent");
		String bImg = request.getParameter("bImg");
		String bImgCopy = request.getParameter("bImg");
		System.out.println("bImg : " + bImg);
		service.boardUpdateS(bNo, bSubject, bContent, bImg, bImgCopy);
		response.sendRedirect("board.do");

	}

	private void boardDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("img");
		System.out.println("saveDir : " + saveDir);
		String bImgCopy = request.getParameter("bImgCopy");
		System.out.println("bImgCopy : " + bImgCopy);
		File f = new File(saveDir, bImgCopy);
		if (f.exists()) {
			f.delete();
		}
		service.boardDeleteS(bNo);

		response.sendRedirect("board.do");
	}

	private void boardDownload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("boardDownload();");
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("img");

		String fileName = new String(request.getParameter("bImgCopy"));
		File file = new File(saveDir + "/" + fileName);
		response.setContentType("application/octet-stream");
		String Agent = request.getHeader("USER-AGENT");
		if (Agent.indexOf("MSIE") >= 0) {
			int i = Agent.indexOf('M', 2);
			String IEV = Agent.substring(i + 5, i + 8);
			if (IEV.equalsIgnoreCase("5.5")) {
				response.setHeader("Content-Disposition",
						"filename=" + new String(fileName.getBytes("utf-8"), "8859_1"));
			} else {
				response.setHeader("Content-Disposition",
						"attachment;filename=" + new String(fileName.getBytes("utf-8"), "8859_1"));
			}
		} else {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(fileName.getBytes("utf-8"), "8859_1"));
		}

		byte b[] = new byte[1024];
		if (file.isFile()) {
			try {
				BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());

				int read = 0;
				while ((read = fin.read(b)) != -1) {
					outs.write(b, 0, read);
				}
				outs.flush();
				outs.close();
				fin.close();
			} catch (Exception e) {
			}
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/file/store");

		String fname = request.getParameter("fname");
		File f = new File(saveDir, fname);
		if (f.exists()) {
			f.delete();
		}
		response.sendRedirect("file.do");
	}

	private void replyIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mEmail = (String)session.getAttribute("session_email");
		System.out.println("mEmail : "+mEmail);
		String mNick = (String)session.getAttribute("session_nick");
		System.out.println("mNick : "+mNick);
		ReplyService rs = ReplyService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		System.out.println("bNo : "+bNo);
		String brContent = request.getParameter("brContent");
		rs.replyInS(bNo, brContent, mEmail, mNick);
		response.sendRedirect("board.do?m=board_content&bNo=" + bNo);
	}

	private void replyDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReplyService rs = ReplyService.getInstance();
		HttpSession session = request.getSession();
		int brNo = Integer.parseInt(request.getParameter("brNo"));
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		ReplyDTO dto = rs.replyNickS(brNo);
		if(dto.getmNick()==session.getAttribute("session_nick")) {
			System.out.println("세션 아이디와 일치");
			String check = "-1";
			request.setAttribute("check", check);
		}else {
			System.out.println("세션 아이디와 불일치");
			String check = "0";
			request.setAttribute("check", check);
		}
		
		rs.replyDeleteS(brNo);
		response.sendRedirect("board.do?m=board_content&bNo=" + bNo);
	}

	private void boardLike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ReplyService rService = ReplyService.getInstance();
		HttpSession session = request.getSession();
		String nick = (String)session.getAttribute("session_nick");
		String email = (String)session.getAttribute("session_email");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		//리플 추천 아이디 넣는거
		rService.replyLikeInS(bNo, email, nick);
		//보드 추천수 올리는거
		service.boardLikeS(bNo);
		
		response.sendRedirect("board.do?m=board_content&bNo=" + bNo);
	}
	
	private void boardLikeList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList <String> likeList = new ArrayList<String>();
		ReplyService rService = ReplyService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		likeList = rService.replyLikeListS(bNo);
		request.setAttribute("likeList", likeList);
		for(String temp : likeList) {
			System.out.println("likeList 뽑아보자 : "+temp);
		}
		response.sendRedirect("tkl.board/board_content.jsp");
	}
	
	private int searchCheck(String sk, String sv) {
		if ((sk == null || sv == null) || (sk == "")) {
			return 0;
		} else {
			if (sk.equals("M_NICK")) {
				sv = sv.trim();
				return 1;
			} else if (sk.equals("B_SUBJECT")) {
				sv = sv.trim();
				return 2;
			} else if (sk.equals("B_CONTENT")) {
				sv = sv.trim();
				return 3;
			}
		}
		return 0;
	}
}