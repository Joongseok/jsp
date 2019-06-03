package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256_test {

	private static final Logger logger = LoggerFactory
			.getLogger(KISA_SHA256_test.class);

	/**
	* Method : sha245Test
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 복호화가 불가능한 hash 알고리즘
	*/
	@Test
	public void sha245Test() {
		/***Given***/
		String plainText = "brown1234";

		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);

		/***Then***/
		logger.debug("encryptText : {}", encryptText);
	}

}
