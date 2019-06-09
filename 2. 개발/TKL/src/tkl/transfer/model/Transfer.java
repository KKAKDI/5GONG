package tkl.transfer.model;

public interface Transfer {
	boolean isMember(String email); 
	boolean checkBalance(String sender, long amount); 
	boolean minus(String sender, long amount); 
	boolean plus(String receiver, long amount); 
	boolean update(String sender, String receiver);
	boolean log(String sender, String receiver, long amount); 
	void showResult(String sender, String receiver); 
	void closeAll();
	
	boolean transfer(String sender, String receiver, long amount);
}
