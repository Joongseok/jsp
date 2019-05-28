package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

public class UserDaoImpl implements IUserDao {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoImpl.class);
	
	public static void main(String[] args) {
		/***Given***/
		IUserDao userDao = new UserDaoImpl();

		/***When***/
		List<UserVO> userList = userDao.userList();
		
		/***Then***/
		logger.debug("userList : {}", userList);

		
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVO user = userDao.getUser(userId);

		/***Then***/
		logger.debug("user : {}", user);
		
	}

	/**
	* Method : userList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userList"); // 네임스페이스.아이디
		sqlSession.close();
		return userList;
		
	}

	/**
	* Method : getUser
	* 작성자 : PC25
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 특정 사용자 조회
	*/
	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVO user = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		return user;
	}

	@Override
	public List<UserVO> userPagingList(PageVO pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userPagingList = sqlSession.selectList("user.userPagingList", pageVo);
		sqlSession.close();
		return userPagingList;
	}

	/**
	* Method : usersCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	*/
	@Override
	public int usersCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int usersCnt = sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		return usersCnt;
	}
	

	
	
}
