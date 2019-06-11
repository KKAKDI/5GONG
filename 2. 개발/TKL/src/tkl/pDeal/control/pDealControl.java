package tkl.pDeal.control;

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
import tkl.pDeal.model.pDealDTO;
import tkl.pDeal.model.pDealService;

@WebServlet("/pDeal.do")
public class pDealControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");

		if (m != null) {
			m = m.trim();
			if (m.equals("pDeal_list")) {
				pDeal_list(request, response);

			}else {
				pDeal_list(request, response);
			}
		}
	}
	private void pDeal_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pDealService service = pDealService.getInstance();
		HttpSession session = request.getSession();
		int pd_no = Integer.parseInt(request.getParameter("pd_no"));
		System.out.println("pd_no : " + pd_no);
		String m_email = (String)session.getAttribute("session_email");
		System.out.println("email : "+m_email);
		int pm_no = Integer.parseInt(request.getParameter("pm_no"));
		System.out.println("pm_no : " + pm_no);
		
		///그냥 리스트
		pDealDTO dto = service.pDeal_listS(m_email, pd_no, pm_no);
		request.setAttribute("dto", dto);

		RequestDispatcher rd = request.getRequestDispatcher("board/board_list2.jsp");
		rd.forward(request, response);

	}
}
