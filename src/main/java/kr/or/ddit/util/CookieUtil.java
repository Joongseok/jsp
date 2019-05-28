package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {

	public static String cookieString; // 분석할 쿠키 문자열
	
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	/**
	* Method : setCookieString
	* 작성자 : PC25
	* 변경이력 :
	* @param cookieString
	* Method 설명 : 분석할 쿠키 문자열을 받는다
	*/
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString;
	}

	/**
	* Method : getCookie
	* 작성자 : PC25
	* 변경이력 :
	* @param cookie
	* @return
	* Method 설명 : 쿠기 문자열에서 특정 쿠키 값을 가져온다. 
	*/
	public static String getCookie(String cookie) {
		 
		//String cookieString = "userId=brown; rememberme=true; test=testValue";
		
		String cookieValue = "";
		logger.debug("cookie : {}", cookie);
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		for(String str : cookieArray){
			logger.debug("str : {}", str);
			if(str.startsWith(cookie+"=")){
				String[] cookieStr = str.split("=");
				cookieValue = cookieStr[1]; 
				break;
			}
		}
		logger.debug("cookieValue : {} \n", cookieValue);
		return cookieValue;
	}
	
//	/**
//	 * Method : getCookie
//	 * 작성자 : PC25
//	 * 변경이력 :
//	 * @param cookie
//	 * @return
//	 * Method 설명 : 쿠기 문자열에서 특정 쿠키 값을 가져온다.
//	 */
//	public static String getCookie2(String cookie) {
//		
//		//String cookieString = "userId=brown; rememberme=true; test=testValue";
//		
//		String[] cookies = cookieString.split(";");
//		String cookieValue = "";
//		
//		logger.debug("Util-전체 CookiesSize : {}", cookies.length);
//		logger.debug("인자로 받은 CookieName : {}", cookie);
//		for(int i = 0; i < cookies.length; i++){
//			
//			// cookie의 name이 인덱스에 있으면 0 이상
//			if (cookies[i].indexOf(cookie) >= 0 ) {
//				
//				// 있으면 = + 1 인 value의 값이나온다
//				int cookieName = cookies[i].indexOf("=") +1 ;
//				logger.debug("Util-cookies["+ i +"]번째 CookieValueIndex : {}", cookieName);
//				
//				// 해당 인덱스의 = 다음 부터 출력
//				cookies[i] = cookies[i].substring(cookieName);
//				cookieValue = cookies[i];
//			}
//		}
//		logger.debug("Util-CookieValue : {}\n", cookieValue);
//		
//		return cookieValue;
//	}

}
