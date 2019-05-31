package kr.or.ddit.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private IuserService userService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("UserController doGet()");
		
		// request객체로부터 사용자 아이디 파라미터 획득
		String userId = request.getParameter("userId");
		
		logger.debug("userId : {}", userId);
		
		// 사용자 아이디로 사용자 정보를 조회
		UserVO userVo = userService.getUser(userId);
		logger.debug("userVo : {}", userVo);
		
		// 조회 결과를 request객체에 속성으로 저장
		request.setAttribute("userVo", userVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("userVo", userVo);
		if (userVo.getBirth() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthStr = sdf.format(userVo.getBirth());
			request.setAttribute("birthStr", birthStr);
			
		}
		// 화면을 담당하는 /user/userList.jsp로 forword
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
	}

}
