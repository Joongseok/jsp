package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

public class LprodServiceImpl implements ILprodService {

	ILprodDao lprodDao = new LprodDaoImpl();
	
	@Override
	public List<LprodVO> lprodList() {
		
		return lprodDao.lprodList();
	}

	@Override
	public Map<String, Object> lprodPagingList(PageVO pageVo) {
		
		List<LprodVO> lprodList = lprodDao.lprodPagingList(pageVo);
		int lprodsCnt = lprodDao.lprodCnt();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("lprodList", lprodList);
		resultMap.put("lprodsCnt", lprodsCnt);
		
		int paginationSize = (int) Math.ceil((double) lprodsCnt/pageVo.getPageSize()); //최대갯수 / pageVo.
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public int lprodCnt() {
		
		return lprodDao.lprodCnt();
	}

	@Override
	public LprodVO getLprod(String lprod_id) {
		return lprodDao.getLprod(lprod_id);
	}

}
