package kr.or.ddit.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.model.DbVO;

import org.junit.Before;
import org.junit.Test;

public class DbDaoTest {

	private IdbDao dbDao;
	@Before
	public void setUp() throws Exception {
		dbDao = new DbDao();
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
		DbVO dbVo = dbDao.getClassName(uri);
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
		List<DbVO> dbList = dbDao.getUriClassMapping();
		/***Then***/
		assertEquals(2, dbList.size());

	}

}
