package tkl.board.model;

import java.util.ArrayList;

public class BoardService {
	private BoardDAO dao;
	private static BoardService instance = new BoardService();
	private BoardService() {
		dao = new BoardDAO();
	}
	public static BoardService getInstance() {
		return instance;
	}
	public ArrayList<BoardDTO> boardList(){
		
		return dao.boardList();
		
	}
	public void insertS(BoardDTO dto) {
		dao.insert(dto);
	}

}
