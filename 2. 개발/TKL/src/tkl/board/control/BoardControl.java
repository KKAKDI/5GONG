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
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import tkl.bReply.model.ReplyDTO;
import tkl.bReply.model.ReplyService;
import tkl.board.model.BoardDTO;
import tkl.board.model.BoardService;
import tkl.paging.model.PagingDTO;

@WebServlet("/board.do")
public class BoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		String cp = request.getParameter("currentPage");
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
			}
		} else {
			boardList(request, response);
		}
	}

	private void boardList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ReplyService rService = ReplyService.getInstance();

		/// 여기서부터는 검색기능
		String sk = request.getParameter("sk");
		String sv = request.getParameter("sv");
		System.out.println("sk : " + sk);
		System.out.println("sv : " + sv);
		///평범한 첫 리스트 
		BoardDTO dto = new BoardDTO();
		ArrayList<BoardDTO> list = service.boardList(sk, sv);
		request.setAttribute("list", list);
		
		///페이징 능력 !!!
		//PagingDTO pDto = new PagingDTO();
		//serivce.paging();
		
	

		RequestDispatcher rd = request.getRequestDispatcher("board/board_list.jsp");
		rd.forward(request, response);

	}

	private void boardInform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("board/board_input.jsp");
	}
	
	private void boardIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/image");
		System.out.println("saveDir : " + saveDir);
		int maxPostSize = 10 * 1028 * 1028;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxPostSize, encoding, policy);
		String bImgCopy = mr.getFilesystemName("bImg");
		System.out.println("bImgCopy : " + bImgCopy);
		String bImg = mr.getOriginalFileName("bImg");
		System.out.println("bImg: " + bImg);
		String mNick = mr.getParameter("mNick");
		System.out.println("mNick : " + mNick);
		String eMail = mr.getParameter("eMail");
		String bSubject = mr.getParameter("bSubject");
		System.out.println("bSubejct : " + bSubject);
		String bContent = mr.getParameter("bContent");
		String homepage = mr.getParameter("homepage");
		String pwd = mr.getParameter("pwd");
		BoardDTO dto = new BoardDTO(-1, eMail, mNick, bSubject, bContent, bImg, bImgCopy, -1, -1, null, -1);
		BoardService service = BoardService.getInstance();
		service.insertS(dto);
		System.out.println("파일 업로드 성공");
		response.sendRedirect("board.do");
	}

	private void boardContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		// 쿠키 시작

		// 쿠키변수를 만들어서 값을 저장. 쿠키변수에 값이 있으면 조회수 증가 실행 하지 않음
		boolean isGet = false;
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie c : cookies) {//
				// num쿠키가 있는 경우
				if (c.getName().equals("coocie" + bNo)) {
					isGet = true;
				}
			}
			// num쿠키가 없는 경우
			if (!isGet) {
				service.boardViewS(bNo);// 조회수증가
				Cookie c1 = new Cookie("coocie" + bNo, "coocie" + bNo);
				c1.setMaxAge(1 * 24 * 60 * 60);// 하루저장
				response.addCookie(c1);
			}
		}

		BoardDTO dto = service.boardContentS(bNo);
		request.setAttribute("dto", dto);

		ReplyService rService = ReplyService.getInstance();
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
		String saveDir = sc.getRealPath("image");
		System.out.println("saveDir : " + saveDir);
		String bImgCopy = request.getParameter("bImgCopy");
		System.out.println("bImgCopy : " + bImgCopy);
		File f = new File(saveDir, bImgCopy);
		if (f.exists()) {
			f.delete();
			System.out.println("파일 삭제 성공");
		}
		service.boardDeleteS(bNo);

		response.sendRedirect("board.do");
	}

	private void boardDownload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("boardDownload();");
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("image");

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
		ReplyService rs = ReplyService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String brContent = request.getParameter("brContent");
		rs.replyInS(bNo, brContent);
		response.sendRedirect("board.do?m=board_content&bNo=" + bNo);
	}

	private void replyDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReplyService rs = ReplyService.getInstance();
		int brNo = Integer.parseInt(request.getParameter("brNo"));
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		rs.replyDeleteS(brNo);
		response.sendRedirect("board.do?m=board_content&bNo=" + bNo);
	}

	private void boardLike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		service.boardLikeS(bNo);
		response.sendRedirect("board.do?m=board_content&bNo=" + bNo);
	}
}