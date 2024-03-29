package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.BookmarkDAO;
import model.dao.VisitDAO;
import model.dto.BookmarkDTO;
import model.dto.VisitDTO;
import paging.Paging;

public class BookmarkService {

	public Paging getPage(BookmarkDTO dto, int pageNumber, int cnt) { // dto가 있어야 사용자별 정보 조회 가능
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (pageNumber - 1) * cnt + 1);
		map.put("end", pageNumber * cnt);
		map.put("userId", dto.getUserId());
		
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data = dao.selectPage(map);
		int count = dao.totalRowCount(dto);
		int lastPageNumber = (count / cnt) + (count % cnt == 0 ? 0 : 1);
		
		Paging paging = new Paging(data, pageNumber, lastPageNumber, cnt, 5);
																	   // ↑ 페이지 수 조정
		dao.close();
		return paging;
	}
	
	/*
	public List<BookmarkDTO> getAll(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data = dao.selectAll(dto);
		dao.close();
		return data;
	}*/
	
	public boolean add(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		
		int id = dao.getId();
		dto.setId(id);
		
		int count = dao.insert(dto);
		if(count == 1) {
			dao.commit();
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();
		return false;
	}

	public BookmarkDTO getId(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		BookmarkDTO data = dao.selectId(dto);
		dao.close();
		return data;
	}

	public boolean update(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		int count = dao.update(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

	public boolean delete(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		int count = dao.delete(dto);
		if(count == 1) {
			dao.commit(); dao.close();
			return true;
		}
		dao.rollback(); dao.close();
		return false;
	}

}
