package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.dto.VisitDTO;
import model.service.BookmarkService;
import model.service.VisitService;

@WebServlet("/bookmark")
public class BookmarkController extends HttpServlet {
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		UserDTO userData = (UserDTO)session.getAttribute("user");
		
		BookmarkService service = new BookmarkService();
		BookmarkDTO dto = new BookmarkDTO();
		dto.setUserId(userData.getUserId());
		
		List<BookmarkDTO> data = service.getAll(dto);
		
		req.setAttribute("data", data);
		req.getRequestDispatcher("/WEB-INF/view/bookmark.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		UserDTO userData = (UserDTO)session.getAttribute("user");
		
		String url = req.getParameter("url");
		String name = req.getParameter("name");
		
		BookmarkDTO dto = new BookmarkDTO();
		dto.setUserId(userData.getUserId());
		dto.setUrl(url);
		dto.setName(name);
		
		BookmarkService service = new BookmarkService();
		boolean result = service.add(dto);
		
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/bookmark");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error");
		}
	}
	
}
