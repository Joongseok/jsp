package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IuserService {

	/**
	 * Method : userList 
	 * 작성자 : PC25 
	 * 변경이력 :
	 * @return 
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVO> userList() {
		
		IUserDao dao = new UserDaoImpl();
		
		List<UserVO> userList = dao.userList();
		
		return userList;
	}

	/**
	* Method : getUser
	* 작성자 : PC25
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 조회 리스트
	*/
	@Override
	public UserVO getUser(String userId) {
		IUserDao dao = new UserDaoImpl();
		UserVO userVo = dao.getUser(userId);
		return userVo;
	}

	/**
	* Method : userPagingList
	* 작성자 : PC25
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Override
	public Map<String, Object> userPagingList(PageVO pageVo) {
		IUserDao dao = new UserDaoImpl();
		List<UserVO> userList = dao.userPagingList(pageVo); //10
		int usersCnt = dao.usersCnt(); //105
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("userList", userList); // 10
		resultMap.put("usersCnt", usersCnt); // 105
		
		int paginationSize = (int) Math.ceil((double)usersCnt/pageVo.getPageSize()); // 105/10
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public int usersCnt() {
		IUserDao dao = new UserDaoImpl();
		return dao.usersCnt();
	}

	@Override
	public int insertUser(UserVO userVo) {
		IUserDao dao = new UserDaoImpl();
		int result = dao.insertUser(userVo);
		return result;
	}

	@Override
	public int deleteUser(String userId) {
		IUserDao dao = new UserDaoImpl();
		int result = dao.deleteUser(userId);
		return result;
	}

	@Override
	public int updateDateUser(UserVO modifyUser) {
		IUserDao dao = new UserDaoImpl();
		int result = dao.updateDateUser(modifyUser);
		return result;
	}

	/**
	* Method : encryptPassAllUser
	* 작성자 : PC25
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	* 			  : *********************** 재적용 금지 ***************************************
	*/
	@Override
	public int encryptPassAllUser() {
		// 사용금지 이미 암호화 적용됌
		if( 1 == 1){
			return 0;
		}
		//0. sql 실행에 필요한 sqlSession 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IUserDao dao = new UserDaoImpl();
		//1. 모든 사용자 정보를 조회 (단, 기존 암호화 적용 사용자 제외, brown, userTest)
		List<UserVO> userListForPassEncrypt = dao.userListForPassEncrypt(sqlSession); 
		
		//2. 조회된 사용자의 비밀번호를 암호화 적용 후 사용자 업데이트 
		int updateCntSum = 0;
		for(UserVO userVo : userListForPassEncrypt){
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = dao.updateUserEncryptPass(sqlSession, userVo);
			
			updateCntSum += updateCnt;
			// 비정상
			if (updateCnt != 1) {
				sqlSession.rollback();
				break;
			}
		}
		//3. sqlSession 객체를 commit, close
		sqlSession.commit();
		sqlSession.close();
		
		return updateCntSum;
	}

	// ***********사용금지*****************
//	private static final Logger logger = LoggerFactory
//			.getLogger(UserService.class);
//	public static void main(String[] args) {
//		IuserService service = new UserService();
//		int updateCnt = service.encryptPassAllUser();
//		logger.debug("updateCnt : {}", updateCnt);
//	}
	
}
