package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/userModify")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
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
		logger.debug("usreModifyController doPost()");
		
		String userId = ((UserVO) request.getSession().getAttribute("userVo")).getUserId();
		String name	 = request.getParameter("name");    
		String alias = request.getParameter("alias");   
		String addr1 = request.getParameter("addr1");   
		String addr2 = request.getParameter("addr2");   
		String zipcd = request.getParameter("zipcd");   
		String birth = request.getParameter("birth");     
		String filename	 = request.getParameter("modifyFile");
		
		// 사용자가 보낸 평문 비밀번호 데이터
		String pass	 = request.getParameter("pass");    
		pass = KISA_SHA256.encrypt(pass);
		
		UserVO usertmp = userService.getUser(userId);
		
		String tmpPath = usertmp.getPath() == null ? "" : usertmp.getPath();
		String tmpFileName = usertmp.getFilename() == null ? "" : usertmp.getFilename();
		
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
		UserVO modifyUser = null;
		if (birth.equals("")) {
			modifyUser = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, null, tmpPath, tmpFileName);
		}else{
			try {
				modifyUser = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse(birth), tmpPath, tmpFileName);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Part profile = request.getPart("modifyFile");
		if (profile.getSize() > 0 && profile != null) {
			String contentDisposition = profile.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(fileName);
			String sp = File.separator;
			
			Map<String, Object> resultMap = PartUtil.setMkdir();
			File uploadFolder = (File) resultMap.get("uploadFolder");
			String uploadPath =  (String) resultMap.get("uploadPath");
			
			if(uploadFolder.exists()){
				// 파일 디스크에 쓰기
				String filePath = uploadPath + sp + UUID.randomUUID().toString() + ext;
				modifyUser.setPath(filePath);
				modifyUser.setFilename(fileName);
				profile.write(filePath);
				profile.delete();
			}
		}
		int modifyResult = userService.updateDateUser(modifyUser);
		if (modifyResult == 1) {
			logger.debug("수정성공");
			response.sendRedirect(request.getContextPath() + "/userPagingList");
		}else{
			logger.debug("수정실패");
			request.setAttribute("msg", "회원정보 수정 실패");
			request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
		}
		
	}

}
