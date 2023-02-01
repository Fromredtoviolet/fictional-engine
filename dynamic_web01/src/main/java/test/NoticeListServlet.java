package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoticeListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/notice/noticeList.jsp";
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			req.setAttribute("msg", "실패");
			req.getRequestDispatcher(page).forward(req, resp);
		}
		
	}
}
