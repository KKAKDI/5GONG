package tkl.product.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

import java.util.*;

import javax.servlet.http.Cookie;

import tkl.product.model.ProductService;
import tkl.product.model.ProductDTO;
import tkl.preply.model.PreplyService;
import tkl.preply.model.PreplyDTO;

@WebServlet("/product.do")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("reg_form")) {
				reg_form(request, response);
			}else if(m.equals("reg")) {
				reg(request, response);
			}else if(m.equals("content_img")) {
				content_img(request, response);
			}else if(m.equals("content")) {
				content(request, response);
			}else if(m.equals("delete")) {
				delete(request, response);
			}else if(m.equals("update_form")) {
				update_form(request, response);
			}else if(m.equals("update")) {
				update(request, response);
			}else if(m.equals("reply_reg")) {
				reply_reg(request, response);
			}else if(m.equals("reply_delete")) {
				reply_delete(request, response);
			}else if(m.equals("list_sel")) {
				list_sel(request, response);
			}else if(m.equals("list_buy")) {
				list_buy(request, response);
			}else if(m.equals("buy_complete")) {
				buy_complete(request, response);
			}else {
				list(request, response);
			}
		}else {
			list(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPageStr = request.getParameter("currentPage");
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
		int curPage1 = 0;
		if (request.getParameter("curPage1") != null) {
			curPage1 = Integer.parseInt(request.getParameter("curPage1"));
		}
		ProductService service = ProductService.getInstance();
		int tableRowNum = service.PagingRowNumS();
		int totalRecodeSize = tableRowNum;
		int pageSizePerBlock = 3;
		int curPage = (Integer)request.getAttribute("currentPage");
		if(request.getAttribute("curBlock") != null){
			curBlock = Integer.parseInt(request.getAttribute("curBlock").toString());
		}
		curPage1 = curBlock*pageSizePerBlock;
		if(request.getParameter("curPage1") != null) {
			curPage1 = Integer.parseInt(request.getParameter("curPage1"));
		}
		int recodeSizePerPage = 10;
		int beginNum = curPage1 * recodeSizePerPage;
		int pageSize = (int)Math.ceil((double)totalRecodeSize/recodeSizePerPage);
		int startPage = curBlock*pageSizePerBlock;
		int endPage = startPage + pageSizePerBlock;
		request.setAttribute("pageSizePerBlock", pageSizePerBlock);
		request.setAttribute("curPage", curPage);
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("totalRecodeSize", totalRecodeSize);
		request.setAttribute("curPage1", curPage1);
		request.setAttribute("recodeSizePerPage", recodeSizePerPage);
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("tableRowNum", tableRowNum);
		ArrayList<ProductDTO> list = service.selectS();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("product/product_list.jsp");
		rd.forward(request, response);
	}
	
	private void reg_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("product/product_reg.jsp");
	}
	
	private void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/file/store");
		System.out.println("saveDir : " + saveDir);
		int maxPostSize = 1*1028*1028;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxPostSize, encoding, policy); 
		String pd_img_copy = mr.getFilesystemName("pd_img_copy");
		String pd_img = mr.getOriginalFileName("pd_img_copy");
		String pd_email = mr.getParameter("pd_email");
		//pd_email = "ddd@naver.com";
		String pd_nick = mr.getParameter("pd_nick");
		//pd_nick = "닉네임1";
		String pd_status = mr.getParameter("pd_status");
		pd_status = "판매중";
		String pd_name = mr.getParameter("pd_name");
		String pd_class = mr.getParameter("pd_class");
		String pd_priceStr = mr.getParameter("pd_price");
		pd_priceStr = pd_priceStr.trim();
		int pd_price = Integer.parseInt(pd_priceStr);
		String pd_subject = mr.getParameter("pd_subject");
		String pd_content = mr.getParameter("pd_content");
		
		ProductService service = ProductService.getInstance();
		ProductDTO dto = new ProductDTO();
		dto.setPd_email(pd_email);
		dto.setPd_nick(pd_nick);
		dto.setPd_status(pd_status);
		dto.setPd_name(pd_name);
		dto.setPd_class(pd_class);
		dto.setPd_price(pd_price);
		dto.setPd_subject(pd_subject);
		dto.setPd_content(pd_content);
		dto.setPd_img(pd_img);
		dto.setPd_img_copy(pd_img_copy);
		service.reg(dto);
		
		response.sendRedirect("product.do");
	}
	
	private void content_img(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pd_img_copy = request.getParameter("pd_img_copy");
		String saveFolder = "file/store";
		ServletContext context = getServletContext();
		String realFolder = context.getRealPath(saveFolder);
		String filePath = realFolder + "\\" + pd_img_copy;
		try{
			byte b[] = new byte[4096];
			response.reset();
			response.setContentType("application/octet-stream");
			String Encoding = new String(pd_img_copy.getBytes("UTF-8"), "8859_1");
			response.setHeader("Content-Disposition", "attachment; filename = " + Encoding);
			FileInputStream in = new FileInputStream(filePath);
			ServletOutputStream out2 = response.getOutputStream();
			int numRead;
			while((numRead = in.read(b, 0, b.length)) != -1){
				out2.write(b, 0, numRead);
			}
			out2.flush();
			out2.close();
			in.close();
		} catch(Exception e){}
	}
	
	private void content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		ProductService service1 = ProductService.getInstance();
		int pd_no = getPd_no(request);
		boolean isGet=false;
		if(cookies!=null){   
			for(Cookie c: cookies){  
				//num쿠키가 있는 경우
				if(c.getName().equals("coocie"+pd_no)){
					isGet=true; 
				}
			}
			// num쿠키가 없는 경우
			if(!isGet) {
				service1.viewS(pd_no);//조회수증가
				Cookie c1 = new Cookie("coocie"+pd_no, "coocie"+pd_no); 
				c1.setMaxAge(1*24*60*60);//하루저장
				response.addCookie(c1);    
			}
		}
		ProductDTO dto = service1.contentS(pd_no);
		request.setAttribute("con", dto);
		PreplyService service2 = PreplyService.getInstance();
		ArrayList<PreplyDTO> reply_list = service2.selectS(pd_no);
		request.setAttribute("reply_list", reply_list);
		RequestDispatcher rd = request.getRequestDispatcher("product/product_content.jsp");
		rd.forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/file/store");
		int pd_no = getPd_no(request);
		String pd_img_copy = request.getParameter("pd_img_copy");
		File f = new File(saveDir, pd_img_copy);
		ProductService service = ProductService.getInstance();
		service.deleteS(pd_no);
		if(f.exists()) {
			f.delete();
		}
		response.sendRedirect("product.do");
	}
	
	private void update_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pd_no = getPd_no(request);
		ProductService service = ProductService.getInstance();
		ProductDTO dto = service.contentS(pd_no);
		request.setAttribute("update_form", dto);
		RequestDispatcher rd = request.getRequestDispatcher("product/product_update_form.jsp");
		rd.forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pd_no = getPd_no(request);
		String pd_name = request.getParameter("pd_name");
		String pd_class = request.getParameter("pd_class");
		String pd_priceStr = request.getParameter("pd_price");
		pd_priceStr = pd_priceStr.trim();
		int pd_price = Integer.parseInt(pd_priceStr);
		String pd_img_copy = request.getParameter("pd_img_copy");
		
		ProductDTO dto = new ProductDTO();
		dto.setPd_no(pd_no);
		dto.setPd_name(pd_name);
		dto.setPd_class(pd_class);
		dto.setPd_price(pd_price);
		dto.setPd_img_copy(pd_img_copy);
		ProductService service = ProductService.getInstance();
		service.updateS(dto);
		response.sendRedirect("product.do");
	}
	
	private void reply_reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pd_no = getPd_no(request);
		String pd_email = request.getParameter("pd_email");
		String pd_nick = request.getParameter("pd_nick");
		System.out.println("pd_nick : " + pd_nick);
		String pr_comment = request.getParameter("pr_comment");
		PreplyService service = PreplyService.getInstance();
		PreplyDTO dto = new PreplyDTO();
		dto.setPd_no(pd_no);
		dto.setPd_email(pd_email);
		dto.setPd_nick(pd_nick);
		dto.setPr_comment(pr_comment);
		service.regS(dto);
		response.sendRedirect("product.do?m=content&pd_no="+pd_no);
	}
	
	private void reply_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pd_no = getPd_no(request);
		String pr_noStr = request.getParameter("pr_no");
		pr_noStr = pr_noStr.trim();
		int pr_no = Integer.parseInt(pr_noStr);
		PreplyService service = PreplyService.getInstance();
		service.deleteS(pr_no);
		response.sendRedirect("product.do?m=content&pd_no="+pd_no);
	}
	
	private void list_sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPageStr = request.getParameter("currentPage");
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
		int curPage1 = 0;
		if (request.getParameter("curPage1") != null) {
			curPage1 = Integer.parseInt(request.getParameter("curPage1"));
		}
		ProductService service = ProductService.getInstance();
		int tableRowNum = service.PagingRowNumS();
		int totalRecodeSize = tableRowNum;
		int pageSizePerBlock = 3;
		int curPage = (Integer)request.getAttribute("currentPage");
		if(request.getAttribute("curBlock") != null){
			curBlock = Integer.parseInt(request.getAttribute("curBlock").toString());
		}
		curPage1 = curBlock*pageSizePerBlock;
		if(request.getParameter("curPage1") != null) {
			curPage1 = Integer.parseInt(request.getParameter("curPage1"));
		}
		int recodeSizePerPage = 10;
		int beginNum = curPage1 * recodeSizePerPage;
		int pageSize = (int)Math.ceil((double)totalRecodeSize/recodeSizePerPage);
		int startPage = curBlock*pageSizePerBlock;
		int endPage = startPage + pageSizePerBlock;
		request.setAttribute("pageSizePerBlock", pageSizePerBlock);
		request.setAttribute("curPage", curPage);
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("totalRecodeSize", totalRecodeSize);
		request.setAttribute("curPage1", curPage1);
		request.setAttribute("recodeSizePerPage", recodeSizePerPage);
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("tableRowNum", tableRowNum);
		String pd_class = request.getParameter("pd_class");
		pd_class = "팝니다";
		ArrayList<ProductDTO> list_sel = service.select2(pd_class);
		request.setAttribute("pd_class", pd_class);
		request.setAttribute("list_sel", list_sel);
		RequestDispatcher rd = request.getRequestDispatcher("product/product_list_sel.jsp");
		rd.forward(request, response);
	}
	
	private void list_buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPageStr = request.getParameter("currentPage");
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
		int curPage1 = 0;
		if (request.getParameter("curPage1") != null) {
			curPage1 = Integer.parseInt(request.getParameter("curPage1"));
		}
		ProductService service = ProductService.getInstance();
		int tableRowNum = service.PagingRowNumS();
		int totalRecodeSize = tableRowNum;
		int pageSizePerBlock = 3;
		int curPage = (Integer)request.getAttribute("currentPage");
		if(request.getAttribute("curBlock") != null){
			curBlock = Integer.parseInt(request.getAttribute("curBlock").toString());
		}
		curPage1 = curBlock*pageSizePerBlock;
		if(request.getParameter("curPage1") != null) {
			curPage1 = Integer.parseInt(request.getParameter("curPage1"));
		}
		int recodeSizePerPage = 10;
		int beginNum = curPage1 * recodeSizePerPage;
		int pageSize = (int)Math.ceil((double)totalRecodeSize/recodeSizePerPage);
		int startPage = curBlock*pageSizePerBlock;
		int endPage = startPage + pageSizePerBlock;
		request.setAttribute("pageSizePerBlock", pageSizePerBlock);
		request.setAttribute("curPage", curPage);
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("totalRecodeSize", totalRecodeSize);
		request.setAttribute("curPage1", curPage1);
		request.setAttribute("recodeSizePerPage", recodeSizePerPage);
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("tableRowNum", tableRowNum);
		String pd_class = request.getParameter("pd_class");
		pd_class = "삽니다";
		ArrayList<ProductDTO> list_buy = service.select2(pd_class);
		request.setAttribute("pd_class", pd_class);
		request.setAttribute("list_buy", list_buy);
		RequestDispatcher rd = request.getRequestDispatcher("product/product_list_buy.jsp");
		rd.forward(request, response);
	}
	
	private void buy_complete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pd_no = getPd_no(request);
		String pd_status = request.getParameter("pd_status");
		pd_status = "판매완료";
		ProductDTO dto = new ProductDTO();
		dto.setPd_no(pd_no);
		dto.setPd_status(pd_status);
		ProductService service = ProductService.getInstance();
		service.buyCompleteS(dto);
		response.sendRedirect("product.do");
	}
	
	private int getPd_no(HttpServletRequest request) {
		int pd_no = -1;
		String pd_noStr = request.getParameter("pd_no");
		if(pd_noStr != null) {
			pd_noStr = pd_noStr.trim();
			if(pd_noStr.length() != 0) {
				try {
					pd_no = Integer.parseInt(pd_noStr);
					return pd_no;
				}catch(NumberFormatException ne) {
					return -1;
				}
			}else {
				return -1;
			}
		}else {
			return -1;
		}
	}
}
