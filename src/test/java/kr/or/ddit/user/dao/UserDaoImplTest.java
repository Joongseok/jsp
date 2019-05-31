package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImplTest {

	
	private IUserDao userDao;
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoImplTest.class);
	
	// junit 실행순서
	// @BeforeClass가 적용된 메소드가 1회 실행
	
	// 다음 구간은 @Test가 적용된 모든 메소드에 대해 반복작용
	// @Before가 적용된 메소드 싱행
	// @Test가 적용 메소드 실행
	// @Atfer가 적용된 메소드 실행
	
	// @AfterClass가 적용된 메소드가 1회 실행
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	@Before
	public void setup(){
		logger.debug("setup");
		userDao = new UserDaoImpl();
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	
	/**
	* Method : userListTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	*/
	@Test
	public void userListTest() {
		/***Given***/
		IUserDao userDao = new UserDaoImpl();

		/***When***/
		List<UserVO> userList = userDao.userList();
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList);
	}
	
	/**
	* Method : getUserTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 사용자 조회 테스트
	*/
	@Test
	public void getUserTest(){
		/***Given***/
		IUserDao userDao = new UserDaoImpl();
		String userId = "brown";
		/***When***/
		UserVO userVo = userDao.getUser(userId);
		/***Then***/
		assertEquals("브라운", userVo.getName());
		logger.debug("getUser");
		logger.debug("password : {}", userVo.getPass());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birthStr = sdf.format(userVo.getBirth());
		logger.debug("userBirth : {}", birthStr);
	}
	
	// 사용자 페이징 리스트 조회
	// 고려사항 
	// 몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여줄건지 : 쿼리 실행 파라미터
	// 정렬 순서 ? : 로직 --> 파라미터화 시킬수 있다
	// --> 사용자 아이디 순으로 정렬
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
		List<UserVO> userPagingList = userDao.userPagingList(pageVo);
		
		/***Then***/
		assertNotNull(userPagingList);
		assertEquals(10, userPagingList.size());
		
	}

	
	/**
	* Method : usersCnt
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	*/
	@Test
	public void usersCnt(){
		/***Given***/

		/***When***/
		int usersCnt = userDao.usersCnt();

		/***Then***/
		assertEquals(105, usersCnt);
		logger.debug("usersCnt : {}", usersCnt);

	}
	
	/**
	* Method : insertUserTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	*/
	@Test
	public void insertUserTest() throws ParseException{
		/***Given***/
		String userId   = "1251251test214152525";
		String name     = "test";
		String alias    = "test";
		String pass     = "test";
		String addr1    = "test";
		String addr2    = "test";
		String zipcd    = "test";
		Date birth    = new Date();
		String path     = "test";
		String filename = "test";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserVO userVo = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse("2019-05-31"), path, filename);
		
		/***When***/
		int result = userDao.insertUser(userVo);
		/***Then***/
		assertEquals(1, result);
		
		int delResult = userDao.deleteUser(userId);
		assertEquals(1, delResult);

	}
	
	/**
	* Method : updateDateUserTest
	* 작성자 : PC25
	* 변경이력 :
	* @throws ParseException
	* Method 설명 : 사용자 정보 수정
	*/
	@Test
	public void updateDateUserTest() throws ParseException{
		/***Given***/
		String userId   = "userTest";
		String name     = "test";
		String alias    = "test";
		String pass     = "test";
		String addr1    = "test";
		String addr2    = "test";
		String zipcd    = "test";
		Date birth    = new Date();
		String path     = "test";
		String filename = "test";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVo = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse("2019-05-31"), path, filename);
		
		logger.debug("parse : {}" ,sdf.parse("2019-05-31"));
		String birthStr = sdf.format(birth);
		logger.debug("birthStr : {}", birthStr);
		/***When***/
		int result = userDao.updateDateUser(userVo);
		/***Then***/
		assertEquals(1, result);
		
	}
	
}
