package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtilTest {

	
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtilTest.class);
	/**
	* Method : getCookieTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : getCookie 테스트
	*/
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "userId=brown; rememberme=true; test=testValue";
		CookieUtil.setCookieString(cookieString);
		/***When***/
		String cookieValue = CookieUtil.getCookie("userId");
		String cookieValue1 = CookieUtil.getCookie("userI");
		String cookieValue2 = CookieUtil.getCookie("rememberme");
		String cookieValue3 = CookieUtil.getCookie("test");
		String cookieValue4 = CookieUtil.getCookie("test432423");
		
		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("", cookieValue1);
		assertEquals("true", cookieValue2);
		assertEquals("testValue", cookieValue3);
		assertEquals("", cookieValue4);

	}
//	/**
//	 * Method : getCookieTest2
//	 * 작성자 : PC25
//	 * 변경이력 :
//	 * Method 설명 : getCookie 테스트
//	 */
//	@Test
//	public void getCookieTest2() {
//		/***Given***/
//		String cookieString = "userId=brown; rememberme=true; test=testValue";
//		CookieUtil.setCookieString(cookieString);
//		/***When***/
//		String cookieValue = CookieUtil.getCookie("userId");
//		String cookieValue2 = CookieUtil.getCookie("rememberme");
//		String cookieValue3 = CookieUtil.getCookie("test");
//		String cookieValue4 = CookieUtil.getCookie("test432423");
//		
//		/***Then***/
//		logger.debug("Test - cookieValue : {}", cookieValue);
//		assertEquals("brown", cookieValue);
//		logger.debug("Test - cookieValue2 : {}", cookieValue2);
//		assertEquals("true", cookieValue2);
//		logger.debug("Test - cookieValue3 : {}", cookieValue3);
//		assertEquals("testValue", cookieValue3);
//		assertEquals("", cookieValue4);
//		
//	}

}
