package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.UserVO;

public class SessionAtrributeListener implements HttpSessionAttributeListener {
	private Map<String, UserVO> sessionUserMap = new HashMap<String, UserVO>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		event.getSession().getServletContext().setAttribute("sessionUserMap", sessionUserMap);

		// 속성명
		if("USER_INFO".equals(event.getName()))
			sessionUserMap.put(event.getSession().getId(), (UserVO) event.getValue());
			
			
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if("USER_INFO".equals(event.getName()))
			sessionUserMap.remove(event.getSession().getId(), (UserVO) event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
