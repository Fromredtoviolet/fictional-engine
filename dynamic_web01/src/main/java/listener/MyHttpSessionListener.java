package listener;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import model.dto.Role;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener{
	// 세션이라는 객체가 만들어지는지 삭제되는지를 듣고만 있는 청취자라서 리스너라고함...? 뭐지

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 세션에 기본적으로 만들어두는게 필요하다면 여기에 작성해서 끌어다쓰는게 편리!
		HttpSessionListener.super.sessionCreated(se);
		HttpSession session = se.getSession();
		session.setAttribute("login", false);
		session.setAttribute("role", new Role("GUEST"));
		session.setAttribute("boardViewHistory", new ArrayList<Integer>());
		session.setAttribute("boardRecomCntHistory", new ArrayList<Integer>());
		session.setAttribute("boardDepreCntHistory", new ArrayList<Integer>());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSessionListener.super.sessionDestroyed(se);
	}
}
