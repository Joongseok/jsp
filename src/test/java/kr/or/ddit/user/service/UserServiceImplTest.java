package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

	private IuserService service;
	
	@Before
	public void setup(){
		service = new UserService();
	}
	
	/**
	* Method : userListTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Test
	public void userListTest() {
		/***Given***/

		/***When***/
		List<UserVO> userList = service.userList();

		/***Then***/
		assertEquals(105, userList.size());
	}
	
	@Test
	public void getUser(){
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVO userVo = service.getUser(userId);
		/***Then***/
		assertEquals("브라운", userVo.getName());
	}

}
