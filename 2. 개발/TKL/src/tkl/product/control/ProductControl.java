package tkl.product.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tkl.product.model.ProductDTO;
import tkl.product.model.ProductService;

@WebServlet("/product.do")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("list")) {
				list(request,response);
			}else if(m.equals("con")) {
				con(request,response);
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

public void con(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int pd_no= -1;
		ProductService service = ProductService.getInstance();
		String pd_noStr = request.getParameter("pd_no");
		pd_no = Integer.parseInt(pd_noStr);
		ProductDTO con = service.contentS(pd_no);
		request.setAttribute("con", con);
		RequestDispatcher rd = request.getRequestDispatcher("product/product_content.jsp");
		rd.forward(request, response);

	}
	
}
