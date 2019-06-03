package tkl.product.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import tkl.product.model.ProductService;
import tkl.product.model.ProductDTO;

@WebServlet("/product.do")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("")) {
				
			}else if(m.equals("")) {
				
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

}
