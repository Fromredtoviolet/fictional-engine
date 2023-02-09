package controller.ajax;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/ajax/imageUpload")
@MultipartConfig
public class ImageUploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		
		Part image = req.getPart("imageUpload");
		String location = req.getParameter("location");
		
		int maxFileSize = Integer.parseInt(sc.getInitParameter("maxFileSize"));
		String permitFileType = sc.getInitParameter("permitFileType");
		String[] permitFileExt = sc.getInitParameter("permitFileExt").split(",");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String path = "/static/img/" + location + "/" + df.format(new Date());
		String realPath = sc.getRealPath(path);
		File f = new File(realPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		if(image.getSize() <= maxFileSize) {
			if(image.getContentType().startsWith(permitFileType)) {
				if(image.getContentType().endsWith(permitFileExt[0]) ||
						image.getContentType().endsWith(permitFileExt[1])) {
					String uuid = UUID.randomUUID().toString();
					image.write(String.join("/", realPath, uuid)); // 서버에 저장하는 단계(그래서 절대경로 realPath 사용)
								// realPath와 uuid 사이에 "/"가 들어간다는 메서드
					resp.getWriter().print("{\"imageUrl\": \"" + req.getContextPath() + String.join("/", path, uuid) + "\"}");
					// imageUrl이라는 '키'에 다음과 같은 '값'을 배정한다.
					// req.getContextPath로 /web01 + String.join("/", path, uuid)으로 나머지 경로와 날짜, uuid를 순서대로 붙인 것이 값.
					// 이 '키'와 '값'은 ajax에서 success로 '키'를 요청했을때 '값'으로 응답하는 콜백에 쓰인다.
					// 즉, callback(data.imageUrl)이라고 키를 요청하면 req.getContextPath() + String.join("/", path, uuid) 라는 값으로 응답하여 이미지 주소를 전달한다.
					resp.getWriter().flush();
				}
			}
		}
		
	}
}
