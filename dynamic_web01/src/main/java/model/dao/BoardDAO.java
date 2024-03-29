package model.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;
import model.dto.BoardDTO;
import model.dto.BoardImageDTO;

public class BoardDAO {

	private SqlSession session = OracleConnection.getSqlSession();
	
	public List<BoardDTO> selectPage(Map<String, Object> map) {
		List<BoardDTO> data = session.selectList("boardMapper.selectPage", map);
		return data;							// ↑ namespace를 뜻함
	}
	
	public int totalRowCount() {
		int count = session.selectOne("boardMapper.totalRowCount");
		return count;
	}
	
	public BoardDTO selectData(BoardDTO dto) {
		BoardDTO data = session.selectOne("boardMapper.selectData", dto);
		return data;
	}

	public int updateViewCnt(BoardDTO dto) {
		int count = session.update("boardMapper.updateViewCnt", dto);
		return count;
	}
	
	public int updateRecomCnt(BoardDTO dto) {
		int count = session.update("boardMapper.updateRecomCnt", dto);
		return count;
	}
	
	public int updateDepreCnt(BoardDTO dto) {
		int count = session.update("boardMapper.updateDepreCnt", dto);
		return count;
	}
	
	public int updateDecreRecomCnt(BoardDTO dto) {
		int count = session.update("boardMapper.updateDecreRecomCnt", dto);
		return count;
	}
	
	public int updateDecreDepreCnt(BoardDTO dto) {
		int count = session.update("boardMapper.updateDecreDepreCnt", dto);
		return count;
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

	public int selectNextSeq() {
		int seq = session.selectOne("boardMapper.selectNextSeq");
		return seq;
	}

	public int insert(BoardDTO dto) {
		int count = session.insert("boardMapper.insert", dto);
		return count;
	}

	public int update(BoardDTO dto) {
		int count = session.update("boardMapper.update", dto);
		return count;
	}

	public int delete(BoardDTO dto) {
		int count = session.delete("boardMapper.delete", dto);
		return count;
	}

	public int delete(List<Integer> arrId) {
		int count = session.delete("boardMapper.checkedDelete", arrId);
		return count;
	}

	public int insertImage(BoardImageDTO dto) {
		int count = session.insert("boardMapper.insertImage", dto);
		return count;
	}
	
	public List<BoardImageDTO> selectImages(BoardDTO dto) {
		List<BoardImageDTO> data = session.selectList("boardMapper.selectImages", dto);
		return data;
	}

	public int deleteImages(BoardDTO dto) {
		int count = session.delete("boardMapper.deleteImages", dto);
		return count;
	}

	

}
