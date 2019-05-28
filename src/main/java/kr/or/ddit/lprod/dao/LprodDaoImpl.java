package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;

public class LprodDaoImpl implements ILprodDao {

	@Override
	public List<LprodVO> lprodList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.lprodList");
		return lprodList;
	}

	@Override
	public List<LprodVO> lprodPagingList(PageVO pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodPagingList = sqlSession.selectList("lprod.lprodPagingList", pageVo);
		return lprodPagingList;
	}

	@Override
	public int lprodCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int lprodCnt = sqlSession.selectOne("lprod.lprodCnt");
		return lprodCnt;
	}



}
