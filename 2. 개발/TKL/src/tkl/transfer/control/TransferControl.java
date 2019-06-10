package tkl.transfer.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tkl.transfer.model.TransferDTO;
import tkl.transfer.model.TransferService;


@WebServlet("/transfer.do")
public class TransferControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		if(m!=null) {
			m = m.trim();
			if(m.equals("fin")) {
				transfer(request,response);
			}else if(m.equals("payment")) {
				payment(request,response);
			}
		}else {
			System.out.println("잘못된 접근입니다.");
		}
	}
	public void transfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TransferService service = TransferService.getInstance();
		boolean test = service.transactionS("eee@google.com",10000);
		
		System.out.println(test+"");
	}
	public void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TransferService service = TransferService.getInstance();
		TransferDTO dto = new TransferDTO();
		service.createPayment(dto);
		response.sendRedirect("product.do");
		//상품에서 거래로 request	목록
	}
}
