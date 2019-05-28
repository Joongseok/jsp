package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImplTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImplTest.class);
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
	
	/**
	* Method : userPagingListTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	*/
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVO pageVo = new PageVO(1, 10);
		
		/***When***/
		Map<String, Object> resultMap = service.userPagingList(pageVo);
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		/***Then***/
		//pagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		//usersCnt assert
		assertEquals(11, (int)paginationSize);
	}
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {}" , paginationSize);
		/***Then***/
		assertEquals(11, (int)paginationSize);

	}

}
