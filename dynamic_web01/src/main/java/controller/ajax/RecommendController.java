package controller.ajax;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardDTO;
import model.service.BoardService;

@WebServlet("/ajax/recommend")
public class RecommendController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Integer> recomHistory = (List<Integer>)session.getAttribute("boardRecomCntHistory");
		List<Integer> depreHistory = (List<Integer>)session.getAttribute("boardDepreCntHistory");
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("type");
		
		BoardDTO dto = new BoardDTO();
		dto.setId(id.intValue());
		
		BoardService service = new BoardService();
		JsonFactory jf = new JsonFactory();
		StringWriter sw = new StringWriter();
		JsonGenerator jg = jf.createGenerator(sw);
		
		jg.writeStartObject();
		if(type.equals("recom")) {
			if(!recomHistory.contains(id) && !depreHistory.contains(id)) {
				service.incRecomCnt(dto);
				recomHistory.add(id);
			} else if(recomHistory.contains(id)) {
				service.decreRecomCnt(dto);
				recomHistory.remove(id);
			}
			session.setAttribute("boardRecomCntHistory", recomHistory);
			BoardDTO data = service.getData(dto);
			jg.writeStringField("type", "success");
			jg.writeNumberField("count", data.getRecomCnt());
		} else if(type.equals("depre")) {
			if(!recomHistory.contains(id) && !depreHistory.contains(id)) {
				service.incDepreCnt(dto);
				depreHistory.add(id);
			} else if(depreHistory.contains(id)) {
				service.decreDepreCnt(dto);
				depreHistory.remove(id);
			}
			session.setAttribute("boardDepreCntHistory", depreHistory);
			BoardDTO data = service.getData(dto);
			jg.writeStringField("type", "success");
			jg.writeNumberField("count", data.getDepreCnt());
		} else {
			jg.writeStringField("type", "error");
			jg.writeStringField("msg", "잘못된 타입 입니다.");
		}
		jg.writeEndObject();
		jg.close();
		
		resp.getWriter().print(sw.toString());
		resp.getWriter().flush();
		
		
		
	}
}
