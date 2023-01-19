package listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletRequestListener.super.requestInitialized(sre);
		System.out.println("Request 객체가 생성되었습니다.");
		HttpServletRequest req = (HttpServletRequest)sre.getServletRequest();
	}								// 상위객체라서 캐스팅해줘야함
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletRequestListener.super.requestDestroyed(sre);
		System.out.println("Request 객체가 소멸되었습니다.");
	}
}
