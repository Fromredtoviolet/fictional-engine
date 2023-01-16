package model.service;

import java.util.List;

import model.dao.BookmarkDAO;
import model.dao.VisitDAO;
import model.dto.BookmarkDTO;
import model.dto.VisitDTO;

public class BookmarkService {

	public List<BookmarkDTO> getAll() {
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data = dao.selectAll();
		dao.close();
		return data;
	}
	
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
