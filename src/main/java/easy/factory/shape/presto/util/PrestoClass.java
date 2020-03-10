package easy.factory.shape.presto.util;

import lombok.Builder;

@Builder
public class PrestoClass {

	@Builder.Default private String CLASS_ACCESS = "public";
	@Builder.Default private final String CLASS_NAME = "sample";

	private PrestoPackage pPackage;
	private PrestoImport pImport;
	private PrestoMethod pMethod;
	
	@Override
	public String toString() {
		
		String format = "$package$import%s %s %s {\r\n\r\n$method}";

		//오브젝트가 있으면 format에 추가
		if(pPackage != null) format = format.replace("$package", "%s");
		if(pImport != null) format = format.replace("$import", "%s");
		if(pMethod != null) format = format.replace("$method", "%s");

		//변환이 안된 데이터들 모두 삭제
		format = format.replace("$package", "");
		format = format.replace("$import", "");
		format = format.replace("$method", "");
		
		return String.format(format, pPackage, pImport, CLASS_ACCESS, "class", CLASS_NAME, pMethod);
	}
}
