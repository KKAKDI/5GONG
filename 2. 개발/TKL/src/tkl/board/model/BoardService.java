package tkl.board.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

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
	public BoardDTO boardContentS(int bNo) throws ServletException, IOException {
		return dao.boardContent(bNo);
		
	}
	public void boardDeleteS(int bNo) {
		dao.boardDelete(bNo);
	}
	public void boardUpdateS(int bNo, String bSubject, String bContent, String bImg, String bImgCopy) {
		dao.boardUpdate(bNo, bSubject, bContent, bImg, bImgCopy);	
	}
}
