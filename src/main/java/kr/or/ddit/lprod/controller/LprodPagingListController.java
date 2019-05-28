package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.paging.model.PageVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(LprodPagingListController.class);
	
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodServiceImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 5 : Integer.parseInt(pageSizeString);
		
		PageVO pageVo = new PageVO(page, pageSize);
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		
		List<LprodVO> lprodList = (List<LprodVO>) resultMap.get("lprodList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/lprod/lprodPageList.jsp").forward(request, response);
		
	}

}
