package controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.UserDTO;
import model.service.UserService;

@WebServlet("/ajax/userIdCheck")
public class UserIdCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		
		UserDTO dto = new UserDTO();
		dto.setUserId(userId);
		
		UserService service = new UserService();
		UserDTO data = service.getData(dto);
		
		JsonFactory jf = new JsonFactory();
		StringWriter sw = new StringWriter();
		JsonGenerator jg = jf.createGenerator(sw);
		
		jg.writeStartObject();
		if(data == null) {
			jg.writeStringField("msg", "OK");
		} else {				//키	//값
			jg.writeStringField("msg", "Fail");
		}
		jg.writeEndObject();
		jg.close();
		
		PrintWriter out = resp.getWriter();
		out.print(sw.toString());
		out.flush(); // 버퍼에 남아있는 데이터도 다 전송해라
	}
}
