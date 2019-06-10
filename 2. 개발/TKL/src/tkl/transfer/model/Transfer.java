package tkl.transfer.model;

public interface Transfer {
	boolean isMember(String email); 
	boolean checkBalance(String sender, long amount); 
	boolean minus(String sender, long amount); 
	boolean plus(String receiver, long amount); 
	boolean log(TransferDTO dto); 
	TransferDTO showResult(String sender, String receiver); 
	
	boolean transfer(TransferDTO dto);
}
