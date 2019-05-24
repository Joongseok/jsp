package kr.or.ddit.user.service;

import java.util.List;

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
	
	

}
