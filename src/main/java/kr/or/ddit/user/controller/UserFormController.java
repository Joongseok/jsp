package kr.or.ddit.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/userForm")
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
//		String filename = "";
		
		logger.debug("userId : {}", userId);
		logger.debug("name : {}", name);
		logger.debug("alias : {}", alias);
		logger.debug("pass	 : {}",pass);
		logger.debug("addr1 : {}", addr1);
		logger.debug("addr2 : {}", addr2);
		logger.debug("zipcd : {}", zipcd);
		logger.debug("birth : {}", birth);
		logger.debug("filename	 : {}",filename);
		
//		if (path != null) {
//			int pathSlice = path.lastIndexOf("\\");
//			filename = path.substring(pathSlice + 1 );
//		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVO userForm = null;
		try {
			userForm = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse(birth), "a", filename);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		UserVO checkId = userService.getUser(userId);
		if (checkId == null) {
			userService.insertUser(userForm);
			response.sendRedirect(request.getContextPath() + "/userPagingList");
		}else{
			logger.debug("중복된아이디");
			request.setAttribute("msg", "중복된 아이디입니다");
			request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
			
		}
		
		
	}

}
