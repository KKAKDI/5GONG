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

import tkl.product.model.ProductService;
import tkl.product.model.ProductDTO;

@WebServlet("/product.do")
public class ProductControl extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("reg_form")) {
				reg_form(request, response);
			}else if(m.equals("reg")) {
				reg(request, response);
			}else if(m.equals("con_file")) {
				contentFile(request, response);
			}else if(m.equals("content")) {
				content(request, response);
			}else if(m.equals("update_form")) {
				update_form(request, response);
			}else if(m.equals("update")) {
				update(request, response);
			}else if(m.equals("delete")) {
				delete(request, response);
			}else {
				list(request, response);
			}
		}else {
			list(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = ProductService.getInstance();
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
		//pd_no, pd_email, pd_nick, pd_status, pd_name, pd_class, pd_price, pd_subject, pd_content, pd_view, pd_img, pd_img_copy, pd_regdate
		String pd_img_copy = mr.getFilesystemName("pd_img_copy");
		String pd_img = mr.getOriginalFileName("pd_img_copy");
		System.out.println("pd_img : " + pd_img);
		System.out.println("pd_img_copy : " + pd_img_copy);
		String pd_nick = mr.getParameter("pd_nick");
		String pd_status = mr.getParameter("pd_status");
		String pd_name = mr.getParameter("pd_name");
		String pd_class = mr.getParameter("pd_class");
		String pd_priceStr = mr.getParameter("pd_price");
		pd_priceStr = pd_priceStr.trim();
		int pd_price = Integer.parseInt(pd_priceStr);
		String pd_subject = mr.getParameter("pd_subject");
		String pd_content = mr.getParameter("pd_content");
		
		ProductService service = ProductService.getInstance();
		ProductDTO dto = new ProductDTO();
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
	
	private void content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pd_noStr = request.getParameter("pd_no");
		pd_noStr = pd_noStr.trim();
		int pd_no = Integer.parseInt(pd_noStr);
		ProductService service = ProductService.getInstance();
		ProductDTO con = service.contentS(pd_no);
		request.setAttribute("con", con);
		RequestDispatcher rd = request.getRequestDispatcher("product/product_content.jsp");
		rd.forward(request, response);
	}
	
	private void contentFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pd_img_copy = request.getParameter("pd_img_copy");
		System.out.println("fname : "+pd_img_copy);
		String saveFolder = "file/store";
		ServletContext context = getServletContext();
		String realFolder = context.getRealPath(saveFolder);
		String filePath = realFolder + "\\" + pd_img_copy;
		try{
			File file = new File(filePath);
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
	
	private void update_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
