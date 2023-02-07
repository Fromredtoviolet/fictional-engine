package controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		String json = "{";
		if(data == null) {
			json += "\"msg\": \"OK\"";
		} else {
			json += "\"msg\": \"Fail\"";
		}
		json += "}";

		PrintWriter out = resp.getWriter();
		out.println(json);
		out.flush(); // 버퍼에 남아있는 데이터도 다 전송해라
	}
}
