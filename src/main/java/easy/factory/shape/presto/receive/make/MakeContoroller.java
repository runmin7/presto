package easy.factory.shape.presto.receive.make;

import org.springframework.util.StringUtils;

import easy.factory.shape.presto.word.constant.Word;
import easy.factory.shape.presto.word.constant.Word2;
import easy.factory.shape.presto.word.constant.Word3;

public class MakeContoroller{

	private String packageName;
	private String className;
	private String reqPath;
	private String serviceName;
	private String contents;
	
	//import
	final String httpServletRequest = "import javax.servlet.http.HttpServletRequest";
	final String reqMap = "import sign.weboffice.core.constants.ReqMap";
	
	public String getFile(String menuName, String menuTab) {
		setMeta(menuName, menuTab, "admin");
		makeContents();
		
		return this.contents;
	}
	
	private void setMeta(String menuName, String menuTab, String gubun) {
		
		this.packageName = "package sign.weboffice." + gubun.toLowerCase() + menuTab + ".controller";
		this.className = StringUtils.capitalize(gubun) + menuName + "+Controller";
		this.reqPath = "/"+ gubun.toLowerCase() +"/"+ menuTab +"/";
		this.serviceName = StringUtils.capitalize(gubun) + menuName + "Service";
	}
	
	private void makeContents() {

		StringBuffer sb = new StringBuffer();
		
		//클래스
		sb.append(this.packageName).append("\r\n").append("\r\n")
		
		//import
		.append(httpServletRequest).append("\r\n")
		.append(reqMap).append("\r\n").append("\r\n")
		
		//class
		.append(Word.Annotation.requestMapping).append("(").append(this.reqPath).append(")").append("\r\n")
		.append(Word.Annotation.controller).append("\r\n")
		.append("public class ").append(this.className).append(" {").append("\r\n")
		
		//DI
		.append(Word.Annotation.autowired).append("\r\n")
		.append(this.serviceName).append(" ").append(StringUtils.uncapitalize(this.serviceName)).append(";").append("\r\n")
		
		//end
		.append("}").append("\r\n");
	
		contents = sb.toString();
	}
	
	static void test() {
		String ss = Word3.autowired;		//일반적인 변수

		String ss2 = Word2.Annotation2.requestMapping;	//static 접근
		
		
	}

}