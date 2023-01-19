package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.UserDTO;
import model.service.UserService;

public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
								// 세션 없는 경우 새로 생성 후 반환 
		
		if((boolean)session.getAttribute("login")) { // 로그인이 null이 아니면 (존재하면)
			resp.sendRedirect(req.getContextPath()); // 괄호 안의 경로(/web01)에 보낸다. 
			return; // 즉, 이미 로그인 된 상태면 로그인페이지 출입을 막고 메인페이지로 보낸다!
		}
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("remember")) {
				req.setAttribute("remember", c.getValue());
			}
		}
		
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		
		/* 세션
		session.setAttribute("세션명1", 객체);
		session.setAttribute("세션명2", 객체);
		session.setAttribute("세션명3", 객체);
		session.getAttribute("세션명1");
		session.removeAttribute("세션명1");
		session.invalidate(); // 세션 삭제
		*/
		/*
		Cookie cookie = new Cookie("name", "value"); // "쿠키명", "쿠키값"
		cookie.setMaxAge(60 * 60 * 24); // 쿠키가 브라우저에 저장되는 유효시간(초단위)
		resp.addCookie(cookie);
		*/
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		UserDTO dto = new UserDTO();
		dto.setUserId(userId);
		dto.setPassword(password);
		
		UserService service = new UserService();
		UserDTO userData = service.login(dto);
		
		Cookie cookie = new Cookie("remember", userId);
		
		if(userData != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", userData); // 사용자정보를 세션에 저장
			
			if(remember != null) {
				cookie.setMaxAge(60 * 60 * 24 * 5); // 쿠키 유효기간 설정
			} else {
				cookie.setMaxAge(0);
			}
			resp.addCookie(cookie);
			resp.sendRedirect(req.getContextPath()); // 로그인했으니 메인페이지로 사용자 보내기
		} else {
			req.setAttribute("error", "로그인 실패 다시 시도하세요.");
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		}
	}
	
}
