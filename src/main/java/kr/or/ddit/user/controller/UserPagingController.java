package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/userPagingList")
public class UserPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserPagingController.class);
	
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String pageString = req.getParameter("page");
		String pageSizeString = req.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		// 데이터에 대한 토탈 페이지 구하기
		// 1. 전체 데이터
		
		PageVO pageVo = new PageVO(page, pageSize);
		logger.debug("pageVo : {}", pageVo);
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		// 2. 출력할 페이지 사이즈
//		float paginationSize = Math.ceil((float)userData.size() / pageSize);
//		logger.debug("dataSize : {}", paginationSize);

		// 3. 토탈 페이지 수
//		int totalPage = (int) Math.ceil(paginationSize);
//		req.setAttribute("totalPage", totalPage);
		
		req.setAttribute("userList", userList);
		req.setAttribute("paginationSize", paginationSize);
		req.setAttribute("pageVo", pageVo);
		
		req.getRequestDispatcher("/user/userPageList.jsp").forward(req, resp);
	}
       
}
