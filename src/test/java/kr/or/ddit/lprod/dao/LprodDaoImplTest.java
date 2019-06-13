package kr.or.ddit.lprod.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.lprod.model.ProdVO;

import org.junit.Before;
import org.junit.Test;

public class LprodDaoImplTest {

	private ILprodDao dao;
	
	@Before
	public void setup(){
		dao = new LprodDaoImpl();
	}
	
	/**
	* Method : getProdNameTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : prod_lgu에 해당하는 prodName과 prodId를 조회하는 메서드
	*/
	@Test
	public void getProdNameTest() {
		/***Given***/
		String prod_lgu = "P201";

		/***When***/
		List<ProdVO> prodList = dao.getProdName(prod_lgu);
		/***Then***/
		assertEquals(21, prodList.size());
		
		
	}

}
