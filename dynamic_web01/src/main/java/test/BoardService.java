package test;

import model.dao.BookmarkDAO;

public class BoardService {

	public boolean insertBoard(Board board) {
		BoardDAO dao = new BoardDAO();
		
		int id = dao.getBoardNum();
		board.setBoardNum(id);
		
		int count = dao.insertBoard(board);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

	public Board getData(Board board) {
		BoardDAO dao = new BoardDAO();
		Board data = dao.selectData(board);
		dao.close();
		return data;
	}

	public boolean updateBoard(Board board) {
		BoardDAO dao = new BoardDAO();
		int count = dao.updateBoard(board);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

}
