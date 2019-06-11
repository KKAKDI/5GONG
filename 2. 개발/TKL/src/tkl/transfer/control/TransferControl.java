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
		String pm_seller = request.getParameter("pm_seller");
		System.out.println("pm_seller1 : " + pm_seller);
		String pm_s_bank = request.getParameter("pm_s_bank");
		System.out.println("pm_s_bank1 : " + pm_s_bank);
		String pm_s_accountStr = request.getParameter("pm_s_account");
		pm_s_accountStr = pm_s_accountStr.trim();
		long pm_s_account = Long.parseLong(pm_s_accountStr);
		System.out.println("pm_s_account1 : " + pm_s_account);
		String pm_buyer = request.getParameter("pm_buyer");
		System.out.println("pm_buyer1 : " + pm_buyer);
		String pm_b_bank = request.getParameter("pm_b_bank");
		System.out.println("pm_b_bank1 : " + pm_b_bank);
		String pm_b_accountStr = request.getParameter("pm_b_account");
		pm_b_accountStr = pm_b_accountStr.trim();
		long pm_b_account = Long.parseLong(pm_b_accountStr);
		System.out.println("account1 : " + pm_b_account);
		String pm_s_amountStr = request.getParameter("pm_s_amount");
		pm_s_amountStr = pm_s_amountStr.trim();
		long pm_s_amount = Long.parseLong(pm_s_amountStr);
		System.out.println("pm_s_amount1 : " + pm_s_amount);
		String pm_b_amountStr = request.getParameter("pm_b_amount");
		pm_s_amountStr = pm_s_amountStr.trim();
		long pm_b_amount = Long.parseLong(pm_b_amountStr);
		System.out.println("pm_b_amount1 : " + pm_b_amount);
		String pm_addr = request.getParameter("pm_addr");
		System.out.println("pm_addr1 : " + pm_addr);
		String pdNoStr = request.getParameter("pd_no");
		pdNoStr = pdNoStr.trim();
		int pd_no = Integer.parseInt(pdNoStr);
		System.out.println("pd_no1 : " + pd_no);
		String pmNoStr = request.getParameter("pm_no");
		pmNoStr = pmNoStr.trim();
		int pm_no = Integer.parseInt(pmNoStr);
		System.out.println("pm_no1 : " + pm_no);
		dto.setPd_no(pd_no);
		dto.setPm_seller(pm_seller);
		dto.setPm_s_bank(pm_s_bank);
		dto.setPm_s_account(pm_s_account);
		dto.setPm_buyer(pm_buyer);
		dto.setPm_b_bank(pm_b_bank);
		dto.setPm_b_account(pm_b_account);
		dto.setPm_s_amount(pm_s_amount);
		dto.setPm_b_amount(pm_b_amount);
		dto.setPm_addr(pm_addr);
		
		service.createPayment(dto);
		System.out.println("여기인가???");
		response.sendRedirect("pDeal.do?m=pDeal_list&pd_no="+pd_no+"&pm_no="+pm_no);
		//상품에서 거래로 request	목록
	}
}
