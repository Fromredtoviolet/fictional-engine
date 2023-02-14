package main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.dto.BoardDTO;
import database.connect.OracleConnection;

public class MainDAO {

	private SqlSession session = OracleConnection.getSqlSession();
	
	/**
	 * 최신글을 조회하기 위한 맵퍼와 연결된 메서드
	 * @return
	 */
	public List<BoardDTO> selectLatestBoard() {
		List<BoardDTO> data = session.selectList("board.selectLatest");
		return null;
	}

	/**
	 * 조회수가 가장 많은 글을 조회하기 위한 맵퍼와 연결된 메서드
	 * @return
	 */
	public List<BoardDTO> selectBestBoard() {
		List<BoardDTO> data = session.selectList("board.selectBest");
		return null;
	}
}
