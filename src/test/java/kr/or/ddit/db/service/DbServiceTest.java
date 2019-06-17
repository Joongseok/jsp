package kr.or.ddit.db.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.model.DbVO;

import org.junit.Before;
import org.junit.Test;

public class DbServiceTest {

	private IdbService dbService;
	@Before
	public void setUp() throws Exception {
		dbService = new DbService();
	}

	/**
	* Method : getClassNameTest
	* 작성자 : PC25
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : 요청받은 uri에 해당하는 클래스의 이름을 얻어오는 메서드 테스트
	*/
	@Test
	public void getClassNameTest() {
		/***Given***/
		String uri = "/main.do";

		/***When***/
		DbVO dbVo = dbService.getClassName(uri);
		/***Then***/
		assertNotNull(dbVo);

	}
	/**
	* Method : getUriClassMappingTest
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : db에 있는 uriclassMapping정보를 얻어오는 메서드
	*/
	@Test
	public void getUriMappingTest(){
		/***Given***/

		/***When***/
		List<DbVO> dbList = dbService.getUriClassMapping();
		/***Then***/
		assertEquals(2, dbList.size());

	}
	

}
