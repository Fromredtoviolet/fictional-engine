package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.dto.UserDTO;
import model.service.UserService;

public class ImageUploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		
		Part imageFile = req.getPart("imageFile");
		int maxFileSize = Integer.parseInt(req.getServletContext().getInitParameter("maxFileSize").toString());
		String permitFileType = req.getServletContext().getInitParameter("permitFileType").toString();
		String[] permitFileExt = req.getServletContext().getInitParameter("permitFileExt").toString().split(",");
		
		String viewPath = "";
		if(imageFile.getSize() <= maxFileSize) {
			if(imageFile.getContentType().startsWith(permitFileType)) {
				if(imageFile.getContentType().endsWith(permitFileExt[0]) ||
						imageFile.getContentType().endsWith(permitFileExt[1])) {
					System.out.println("파일명: " + imageFile.getSubmittedFileName());
					System.out.println("파일크기: " + imageFile.getSize());
					System.out.println("파일종류: " + imageFile.getContentType());
					
					String path = req.getServletContext().getRealPath("/static/img/profile");
					
					imageFile.write(path + "/" + imageFile.getSubmittedFileName());
					// imageFile.delete();
					
					user.setpImg("/static/img/profile/" + imageFile.getSubmittedFileName());
					UserService service = new UserService();
					service.uploadImage(user);
					
					resp.sendRedirect(req.getContextPath() + "/logout");
					return; // 오류 없을때 마지막줄 실행 안하고 돌아가란 의미의 리턴
				} else {
					req.setAttribute("errorType", "fileExtError");
					viewPath  = "/WEB-INF/view/error/imageUploadError.jsp";
				}
			} else {
				req.setAttribute("errorType", "fileTypeError");
				viewPath = "/WEB-INF/view/error/imageUploadError.jsp";
			}
		} else {
			req.setAttribute("errorType", "fileSizeError");
			viewPath = "/WEB-INF/view/error/imageUploadError.jsp";
		}
		req.getRequestDispatcher(viewPath).forward(req, resp);
	}
}
