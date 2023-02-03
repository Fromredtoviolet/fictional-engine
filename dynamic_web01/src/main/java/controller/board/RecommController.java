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

@WebServlet("/board/recommend")
public class RecommController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Integer> recomHistory = (List<Integer>)session.getAttribute("boardRecomCntHistory");
		List<Integer> depreHistory = (List<Integer>)session.getAttribute("boardDepreCntHistory");
		// 이 리스트 세션은 MyHttpSessionListener 클래스에 만들어둔걸 끌어다 씀
		
		Integer id = Integer.parseInt(req.getParameter("id")); 
		
		BoardDTO dto = new BoardDTO();
		dto.setId(id.intValue());
		
		BoardService service = new BoardService();
		if(!recomHistory.contains(id) && !depreHistory.contains(id)) {
		// 부정이 들어가기 때문에 추천/비추천을 클릭한 이력이 없는 id만 카운트 된다.
			service.incRecomCnt(dto);
			recomHistory.add(id);
		} else if(recomHistory.contains(id)) {
		// 이미 클릭 이력이 있는 id 중 추천을 클릭했던 id가 true가 된다!
			service.decreRecomCnt(dto);
			recomHistory.remove(id);
			// 추천을 클릭한 적이 있는 id의 경우, 이번에 또 추천을 누른다면 카운트는 -1이 되고,
			// 히스토리에서는 id가 삭제된다. 그러므로 다음번에 다시 추천/비추천을 누를 수 있는 상태가 된다.
		}
		session.setAttribute("boardRecomCntHistory", recomHistory);
		
		resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + id);
	}
	
}
