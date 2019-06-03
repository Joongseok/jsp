package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/userForm")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserFormController.class);
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userFormController doGet()");
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		logger.debug("usreFromController doPost()");
		
		String userId = request.getParameter("userId");
		String name	 = request.getParameter("name");    
		String alias = request.getParameter("alias");   
		String pass	 = request.getParameter("pass");    
		String addr1 = request.getParameter("addr1");   
		String addr2 = request.getParameter("addr2");   
		String zipcd = request.getParameter("zipcd");   
		String birth = request.getParameter("birth");     
		String filename	 = request.getParameter("filename");
		
		logger.debug("userId : {}", userId);
		logger.debug("name : {}", name);
		logger.debug("alias : {}", alias);
		logger.debug("pass	 : {}",pass);
		logger.debug("addr1 : {}", addr1);
		logger.debug("addr2 : {}", addr2);
		logger.debug("zipcd : {}", zipcd);
		logger.debug("birth : {}", birth);
		logger.debug("filename	 : {}",filename);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userForm = null;
		try {
			if (birth.equals("")) {
				userForm = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, null /*"", ""*/);
				
			}else{
				userForm = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse(birth) /*"", ""*/);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		UserVO checkId = userService.getUser(userId);
		if (checkId == null) {
			// profile 파일 업로드 처리
			Part profile = request.getPart("profile");
			if (profile.getSize() > 0 && profile != null) {
				String contentDisposition = profile.getHeader("content-disposition");
				String fileName = PartUtil.getFileName(contentDisposition);
				String ext = PartUtil.getExt(fileName);
				String sp = File.separator;
				
				Map<String, Object> resultMap = PartUtil.setMkdir();
				String uploadPath =  (String) resultMap.get("uploadPath");
				File uploadFolder = (File) resultMap.get("uploadFolder");
				
				if(uploadFolder.exists()){
					// 파일 디스크에 쓰기
					String filePath = uploadPath + sp + UUID.randomUUID().toString() + ext;
					userForm.setPath(filePath);
					userForm.setFilename(fileName);
					profile.write(filePath);
					profile.delete();
				}
			}
			
			userService.insertUser(userForm);
			response.sendRedirect(request.getContextPath() + "/userPagingList");
		}else{
			logger.debug("중복된아이디");
			request.setAttribute("msg", "중복된 아이디입니다");
			request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		}
	}

}
