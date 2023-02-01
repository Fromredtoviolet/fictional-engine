package test;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;
import model.dto.BoardDTO;

public class BoardDAO {

	private SqlSession session = OracleConnection.getSqlSession();
	
	public int insertBoard(Board board) {
		int count = session.insert("bMapper.insert", board);
		return count;
	}
	
	public int getBoardNum() {
		int boardNum = session.selectOne("bMapper.getBoardNum");
		return boardNum;
	}
	
	public void commit() {
		session.commit();
	}
	
	public void rollback() {
		session.rollback();
	}
	
	public void close() {
		session.close();
	}

	public Board selectData(Board board) {
		Board data = session.selectOne("bMapper.selectData", board);
		return data;
	}

	public int updateBoard(Board board) {
		int count = session.update("bMapper.update", board);
		return count;
	}

	
}
