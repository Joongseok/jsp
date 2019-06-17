package kr.or.ddit.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.model.DbVO;
import kr.or.ddit.mybatis.MybatisUtil;

public class DbDao implements IdbDao {

	/**
	* Method : getClassName
	* 작성자 : PC25
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : 요청받은 uri에 해당하는 클래스의 이름을 얻어오는 메서드
	*/
	@Override
	public DbVO getClassName(String uri) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		DbVO dbVo = sqlSession.selectOne("db.getClassName", uri);
		sqlSession.close();
		return dbVo;
	}
	/**
	* Method : getUriClassMapping
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : db에 있는 uriclassMapping정보를 얻어오는 메서드
	*/
	@Override
	public List<DbVO> getUriClassMapping() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<DbVO> dbList = sqlSession.selectList("db.getUriClassMapping");
		sqlSession.close();
		return dbList;
	}

}
