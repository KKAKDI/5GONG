package tkl.transfer.model;



public class TransferService {
	private TransferDAO dao;
	private static TransferService instance = new TransferService();
	private TransferService() {
		dao = new TransferDAO();
	}
	public static TransferService getInstance() {
		return instance;
	}
	
	public boolean transactionS(String email, long amount) {
		return dao.checkBalance(email,amount);
	}
	
	public void createPayment(TransferDTO dto) {
		dao.createPayment(dto);
	}
}
