package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;
import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IdbDao;
import kr.or.ddit.db.model.DbVO;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IdbService;

public class RequestMapping {
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
	private static Map<String, Controller> requestMapping;
	private static IdbService dbService = new DbService();
	
	static{
		List<DbVO> urIClassMappingList = dbService.getUriClassMapping();
		
		requestMapping = new HashMap<String, Controller>();
		
		for(DbVO dbVo : urIClassMappingList){
			String classInfo = dbVo.getClassname();
			try {
				Class clazz =  Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(dbVo.getUri(), (Controller)obj);
			}catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Controller getController(String uri) {
		logger.debug("getController : {}", uri);
		return requestMapping.get(uri);
	}
	
}
