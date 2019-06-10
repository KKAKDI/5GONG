package tkl.payment.model;

public class PaymentService {
	private PaymentDAO dao;
	private static PaymentService instance = new PaymentService();
	private PaymentService() {
		dao = new PaymentDAO();
	}
	public static PaymentService getInstance() {
		return instance;
	}
	public PaymentDTO selectS(int pm_no){
		return dao.select(pm_no);
	}
}
