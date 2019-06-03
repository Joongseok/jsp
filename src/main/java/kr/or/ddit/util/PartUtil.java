package kr.or.ddit.util;

public class PartUtil {
	
	/**
	* Method : getFileName
	* 작성자 : PC25
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한다.
	*/
	public static String getFileName(String contentDisposition) {
		String[] contestDispositions = contentDisposition.split("; ");
		String fileName = "";
		for(String content : contestDispositions){
			if(content.startsWith("filename")){
				String[] fileNames = content.split("=");
				fileName = fileNames[1].substring(1, fileNames[1].length()-1);
			}
		}
		return fileName;
	}

	/**
	* Method : getExt
	* 작성자 : PC25
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로부터 파일 확장자를 반환한다.
	*/
	public static String getExt(String fileName) {
		if (fileName.contains(".")) {
			int start = fileName.lastIndexOf('.') + 1;
			return fileName.substring(start);
		}
		return "";
	}

}
