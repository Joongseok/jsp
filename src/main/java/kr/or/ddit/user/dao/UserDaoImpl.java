package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

import org.apache.ibatis.session.SqlSession;


public class UserDaoImpl implements IUserDao {


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

	@Override
	public int insertUser(UserVO userVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int result = sqlSession.insert("user.insertUser", userVo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int result = sqlSession.delete("user.deleteUser", userId);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int updateDateUser(UserVO modifyUser) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int result = sqlSession.update("user.updateDateUser", modifyUser);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	

	
	
}
