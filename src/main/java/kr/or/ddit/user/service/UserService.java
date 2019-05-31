package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IuserService {

	/**
	 * Method : userList 
	 * 작성자 : PC25 
	 * 변경이력 :
	 * @return 
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVO> userList() {
		
		IUserDao dao = new UserDaoImpl();
		
		List<UserVO> userList = dao.userList();
		
		return userList;
	}

	/**
	* Method : getUser
	* 작성자 : PC25
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 조회 리스트
	*/
	@Override
	public UserVO getUser(String userId) {
		IUserDao dao = new UserDaoImpl();
		UserVO userVo = dao.getUser(userId);
		return userVo;
	}

	/**
	* Method : userPagingList
	* 작성자 : PC25
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Override
	public Map<String, Object> userPagingList(PageVO pageVo) {
		IUserDao dao = new UserDaoImpl();
		List<UserVO> userList = dao.userPagingList(pageVo); //10
		int usersCnt = dao.usersCnt(); //105
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("userList", userList); // 10
		resultMap.put("usersCnt", usersCnt); // 105
		
		int paginationSize = (int) Math.ceil((double)usersCnt/pageVo.getPageSize()); // 105/10
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public int usersCnt() {
		IUserDao dao = new UserDaoImpl();
		return dao.usersCnt();
	}

	@Override
	public int insertUser(UserVO userVo) {
		IUserDao dao = new UserDaoImpl();
		int result = dao.insertUser(userVo);
		return result;
	}

	@Override
	public int deleteUser(String userId) {
		IUserDao dao = new UserDaoImpl();
		int result = dao.deleteUser(userId);
		return result;
	}

	@Override
	public int updateDateUser(UserVO modifyUser) {
		IUserDao dao = new UserDaoImpl();
		int result = dao.updateDateUser(modifyUser);
		return result;
	}

}
