package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;

public class LprodDaoImpl implements ILprodDao {

	@Override
	public List<LprodVO> lprodList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.lprodList");
		sqlSession.close();
		return lprodList;
	}

	@Override
	public List<LprodVO> lprodPagingList(PageVO pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodPagingList = sqlSession.selectList("lprod.lprodPagingList", pageVo);
		sqlSession.close();
		return lprodPagingList;
	}

	@Override
	public int lprodCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int lprodCnt = sqlSession.selectOne("lprod.lprodCnt");
		sqlSession.close();
		return lprodCnt;
	}

	@Override
	public LprodVO getLprod(String lprod_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		LprodVO lprodVo = sqlSession.selectOne("lprod.getLprod", lprod_id);
		sqlSession.close();
		return lprodVo;
	}

	/**
	* Method : getProdNameTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : prod_lgu에 해당하는 prodName과 prodId를 조회하는 메서드
	*/
	@Override
	public List<ProdVO> getProdName(String prod_lgu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ProdVO> prodNames = sqlSession.selectList("lprod.getProdName", prod_lgu);
		sqlSession.close();
		return prodNames;
	}



}
