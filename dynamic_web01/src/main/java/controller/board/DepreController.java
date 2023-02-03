package controller.board;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardDTO;
import model.service.BoardService;

@WebServlet("/board/deprecate")
public class DepreController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Integer> recomHistory = (List<Integer>)session.getAttribute("boardRecomCntHistory");
		List<Integer> depreHistory = (List<Integer>)session.getAttribute("boardDepreCntHistory");
		
		Integer id = Integer.parseInt(req.getParameter("id")); 
		
		BoardDTO dto = new BoardDTO();
		dto.setId(id.intValue());

		BoardService service = new BoardService();
		if(!recomHistory.contains(id) && !depreHistory.contains(id)) {
			service.incDepreCnt(dto);
			depreHistory.add(id);
		} else if(depreHistory.contains(id)) {
		// 이미 클릭 이력이 있는 id 중 비추천을 클릭했던 id가 true가 된다!
			service.decreDepreCnt(dto);
			depreHistory.remove(id);
		}
		session.setAttribute("boardDepreCntHistory", depreHistory);
		
		resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + id);
		
	}
	
}
