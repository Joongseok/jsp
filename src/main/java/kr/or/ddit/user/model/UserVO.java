package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class UserVO implements HttpSessionBindingListener{
	private static final Logger logger = LoggerFactory
			.getLogger(UserVO.class);
	
	private String userId;
	private String name;    
	private String alias;
	private String pass;
	private String addr1;
	private String addr2;
	private String zipcd;
	private Date birth;
	private String path;
	private String filename;
	
	public String getBirthStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (this.birth != null) {
			return sdf.format(this.birth);
		}
		return null;	
	}

	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public UserVO(String userId, String name, String alias, String pass,
			String addr1, String addr2, String zipcd, Date birth, String path,
			String filename) {
		super();
		this.userId = userId;
		this.name = name;
		this.alias = alias;
		this.pass = pass;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcd = zipcd;
		this.birth = birth;
		this.path = path;
		this.filename = filename;
	}

	public UserVO(String userId2, String name2, String alias2, String pass2,
			String addr12, String addr22, String zipcd2, Date birth2) {
		super();
		this.userId = userId2;
		this.name = name2;
		this.alias = alias2;
		this.pass = pass2;
		this.addr1 = addr12;
		this.addr2 = addr22;
		this.zipcd = zipcd2;
		this.birth = birth2;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", name=" + name + ", alias="
				+ alias + ", pass=" + pass + ", addr1=" + addr1 + ", addr2="
				+ addr2 + ", zipcd=" + zipcd + ", birth=" + birth + ", path="
				+ path + ", filename=" + filename + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		logger.debug("value Bound");
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		logger.debug("value UnBound");		
	}


	
		
}
