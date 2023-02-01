package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardInsert")
public class BoardWriteServelet extends HttpServlet { // 보드 컨트롤러
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/common/board.jsp").forward(req, resp);
	}							
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardWriter = req.getParameter("boardWriter");
		String boardTitle = req.getParameter("boardTitle");
		String boardContent = req.getParameter("boardContent");
		String boardDate = req.getParameter("boardDate");
		
		Board board = new Board();
		board.setBoardWriter(boardWriter);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardDate(boardDate);
		
		BoardService service = new BoardService();
		boolean result = service.insertBoard(board);
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/boardList");
		} else {
			req.setAttribute("error", "게시글 수정 실패");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
		}
	}
}
