package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/userModify")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IuserService userService;
	public static void main(String[] args) {
		
	}
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userModifyController doGet()");
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		logger.debug("usreModifyController doPost()");
		
		String userId = ((UserVO) request.getSession().getAttribute("userVo")).getUserId();
		String name	 = request.getParameter("name");    
		String alias = request.getParameter("alias");   
		String pass	 = request.getParameter("pass");    
		String addr1 = request.getParameter("addr1");   
		String addr2 = request.getParameter("addr2");   
		String zipcd = request.getParameter("zipcd");   
		String birth = request.getParameter("birth");     
		String filename	 = request.getParameter("filename");
		
		UserVO userVo= userService.getUser(userId);
		
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
		logger.debug("sdf : {}", birth = new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		UserVO modifyUser = null;
		
		try {
			modifyUser = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse(birth), "", "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (userVo.getBirth() != null) {
			String birthStr = sdf.format(userVo.getBirth());
			request.setAttribute("birthStr", birthStr);
			
		}
		
		int modifyResult = userService.updateDateUser(modifyUser);
		if (modifyResult == 1) {
			response.sendRedirect(request.getContextPath() + "/userPagingList");
		}else{
			logger.debug("수정실패");
			request.setAttribute("msg", "회원정보 수정 실패");
			request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
		}
		
	}

}
