package controller.board;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.dto.BoardDTO;
import model.dto.BoardImageDTO;
import model.dto.UserDTO;
import model.service.BoardService;

@WebServlet("/board/add")
//@MultipartConfig(
//		location = "D:/imageTemp",
//  		maxFileSize = 1024 * 1024 * 5,
//  		maxRequestSize = 1024 * 1024 * 5,
//  		fileSizeThreshold = 1024
//)
public class AddController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/board/add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); // 세션에 계정정보가 있으므로 필요
		ServletContext sc = req.getServletContext();
		
		String title = req.getParameter("title");
		String context = req.getParameter("context");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContext(context);
		dto.setWriter(((UserDTO)session.getAttribute("user")).getUserId());
		dto.setBtype("B");
		if(req.getParameter("notice") != null) {
			if(req.getParameter("notice").equals("yes")) {
				dto.setBtype("N");
			}
		}
		/* 이미지 업로드 (토스트UI 없이) 관련 작업한 것
		int maxFileSize = Integer.parseInt(sc.getInitParameter("maxFileSize"));
		String permitFileType = sc.getInitParameter("permitFileType");
		String[] permitFileExt = sc.getInitParameter("permitFileExt").split(",");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String path = "/static/img/board/" + df.format(new Date()) + "/";
		String realPath = sc.getRealPath(path);
		// DB에 파일 경로 저장할 때는 절대경로를 다 적어둘 필요가 없으므로 path가,
		// 실제 저장할 때는 realPath가 필요하다.
		File f = new File(realPath);
		if(!f.exists()) { // File 객체에 쓰면 realPath가 있는지 검증하는 역할. 없으면 만들어라
			f.mkdirs();
		}
		
		Collection<Part> parts = req.getParts(); // 하나의 input에 파일 여러개 올릴땐(multiple) getParts를 써야함.
		List<BoardImageDTO> boardImageList = new ArrayList<BoardImageDTO>();
		for(Part part: parts) {
			if(part.getName().equals("imageUpload")) {
				if(part.getSize() <= maxFileSize) {
					if(part.getContentType().startsWith(permitFileType)) {
						if(part.getContentType().endsWith(permitFileExt[0]) ||
								part.getContentType().endsWith(permitFileExt[1])) {
							String uuid = UUID.randomUUID().toString();
							// UUID를 파일명에 적용하면 중복이 거의 없으므로 파일명 중복 오류를 방지한다.
							part.write(String.join("/", realPath, uuid));
							BoardImageDTO boardImageDTO = new BoardImageDTO();
							boardImageDTO.setPath(path);
							boardImageDTO.setName(part.getSubmittedFileName());
							boardImageDTO.setUuid(uuid);
							boardImageList.add(boardImageDTO);
						}
					}
				}
			}
		}
		*/
		BoardService service = new BoardService();
		boolean result = service.add(dto, null);
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + dto.getId());
		} else {
			req.getRequestDispatcher("/WEB-INF/view/board/add.jsp").forward(req, resp);
		}
		
	}
}
