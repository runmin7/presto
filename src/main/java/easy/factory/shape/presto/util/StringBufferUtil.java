package easy.factory.shape.presto.util;

import org.springframework.util.StringUtils;

import easy.factory.shape.presto.word.constant.Word.Annotation;
import easy.factory.shape.presto.word.constant.Word.Identifier;
import easy.factory.shape.presto.word.constant.Word.Import;

//내부에 버퍼를 갖고 있으면서,
//요청에 따라 문자열을 식별이 가능한형태로 제공하는 메서드를 갖고있어서 텍스트 작성을 돕는다. 
//한마디로 이 자체가 나름의 규칙을 갖는 별도의 학습이 필요한 메서드가 되겟네
public class StringBufferUtil {

	StringBuffer sb = new StringBuffer();
	
	//라인의 끝에 개행문자를 더한다.
	public void appendLf() {
		sb.append("\r\n");
	}
	
	public void appendCls() {
		
		sb
		.append(Identifier.PACKAGE).append(" easy.factory.shape.presto.util;").append("\r\n")
//		.append(Annotation.REQUEST_MAPPING).append("(").append(reqPath).append(")").append("\r\n")
//		.append(Annotation.CONTROLLER).append("\r\n")
		.append(Identifier.PUBLIC).append(" ").append(Identifier.CLASS).append("adminMotionCaptureContoller").append(" {").append("\r\n").append("\r\n")
		.append("}").append("\r\n");
		
	}
	
	
	@Override
	public String toString() {
		return sb.toString();
	}
	
	
	private void makeContents() {

		String packageName = "";
		String className = "";
		String reqPath = "";
		String serviceName = "";
		String contents = "";
		
		StringBuffer sb = new StringBuffer();
		
		//패키지
		sb.append(packageName).append("\r\n").append("\r\n")
		
		//import
		.append(Import.HTTP_SERVLET_REQUEST).append("\r\n")
		.append(Import.REQ_MAP).append("\r\n").append("\r\n")
		
		//class
		.append(Annotation.REQUEST_MAPPING).append("(").append(reqPath).append(")").append("\r\n")
		.append(Annotation.CONTROLLER).append("\r\n")
		.append(Identifier.PUBLIC).append(" ").append(Identifier.CLASS).append(className).append(" {").append("\r\n")
		
		//DI
		.append(Annotation.AUTOWIRED).append("\r\n")
		.append(serviceName).append(" ").append(StringUtils.uncapitalize(serviceName)).append(";").append("\r\n")
		
		//end
		.append("}").append("\r\n");
	
		contents = sb.toString();
	}
	
}
