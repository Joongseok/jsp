package kr.or.ddit.db.dao;

import java.util.List;

import kr.or.ddit.db.model.DbVO;

public interface IdbDao {
	
	/**
	* Method : getClassName
	* 작성자 : PC25
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : 요청받은 uri에 해당하는 클래스의 이름을 얻어오는 메서드
	*/
	DbVO getClassName(String uri);

	/**
	* Method : getUriClassMapping
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : db에 있는 uriclassMapping정보를 얻어오는 메서드
	*/
	List<DbVO> getUriClassMapping();
}
