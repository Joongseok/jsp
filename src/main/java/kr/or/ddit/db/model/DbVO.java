package kr.or.ddit.db.model;

public class DbVO {
	
	private String uri;
	private String classname;
	
	@Override
	public String toString() {
		return "DbVO [uri=" + uri + ", classname=" + classname + "]";
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
	
}
