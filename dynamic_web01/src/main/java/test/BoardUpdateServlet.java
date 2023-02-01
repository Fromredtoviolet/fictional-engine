package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class BoardUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bn = req.getParameter("boardnum");
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(bn));
		
		BoardService service = new BoardService();
		Board data = service.getData(board);
		
		if(data == null) {
			req.setAttribute("error", "게시글 수정 실패");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/boardDetail");
		}
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
		boolean result = service.updateBoard(board);
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/boardDetail");
		} else {
			req.setAttribute("error", "게시글 수정 실패");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
		}
	}
}
