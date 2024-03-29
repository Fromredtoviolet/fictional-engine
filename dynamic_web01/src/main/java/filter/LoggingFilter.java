package filter;

import java.io.IOException;
import java.text.SimpleDateFormat;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebFilter("/*") <- 모든 url주소에 적용
public class LoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req; // ServletRequest가 더 상위객체라서 캐스팅해줘야함
		HttpServletResponse response = (HttpServletResponse)resp; // 상동
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a KK:mm:ss.SSS");
		String path = request.getRequestURI();
		String method = request.getMethod();
		String query = request.getQueryString();
		// 쿼리스트링은 주소에서 물음표 이후에 나오는 것(?id=3 같은것)
		
		System.out.printf("[%s] - %s: %s", df.format(new java.util.Date()), method, path);
		if(query != null) {
			System.out.print("?" + query);
		}
		System.out.println();
		
		chain.doFilter(req, resp); // req와 resp까지 넣는것 잊지말기!
		
		int code = response.getStatus();
		String redirect = response.getHeader("Location");
		
		System.out.printf("[%s] - %s: ", df.format(new java.util.Date()), code);
		
		switch(code / 100) {
			case 2:
				System.out.print("정상");
				break;
			case 3:
				System.out.printf("리다이렉트(%s)", redirect);
				break;
			case 4:
				System.out.print("요청 오류");
				break;
			case 5:
				System.out.print("서버 오류");
				break;
		}
		System.out.println();
	}
}
