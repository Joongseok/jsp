package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

public interface ILprodDao {
	/**
	* Method : lprodList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 조회
	*/
	List<LprodVO> lprodList();
	
	/**
	* Method : lprodPagingList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : lprod 페이징 조회
	*/
	List<LprodVO> lprodPagingList(PageVO pageVo);
	/**
	* Method : getLprod
	* 작성자 : PC25
	* 변경이력 :
	* @param lprod_id
	* @return
	* Method 설명 : lprod 선택 조회
	*/
	LprodVO getLprod(String lprod_id);
	/**
	* Method : lprodCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 수 조회
	*/
	int lprodCnt();
}
