package tkl.member.model;

public class MemberService {
	private MemberDAO dao;
	private static MemberService instance = new MemberService();
	private MemberService() {
		dao = new MemberDAO();
	}
	public static MemberService getInstance() {
		return instance;
	}
	public void insertS(MemberDTO dto) {
		dao.insert(dto);
	}
}
