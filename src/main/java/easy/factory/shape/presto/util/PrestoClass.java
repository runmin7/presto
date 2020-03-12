package easy.factory.shape.presto.util;

import lombok.Builder;

@Builder
public class PrestoClass {

	@Builder.Default private String CLASS_ACCESS = "public";
	@Builder.Default private final String CLASS_NAME = "sample";
	@Builder.Default private String FORMAT = "$package$import%s %s %s {\r\n\r\n$method}";
	
	private PrestoPackage pPackage;
	private PrestoImport pImport;
	private PrestoMethod pMethod;
	
	//package
	private void processPackage(String find) {
		if(pPackage != null) replace(find, "%s");
		else replace(find, "");
	}
	
	//import
	private void processImport(String find) {
		if(pImport != null) replace(find, "%s");
		else replace(find, "");
	}
	
	//method
	private void processMethod(String find) {
		if(pMethod != null) replace(find, "%s");
		else replace(find, "");
	}
	
	//find and change
	private void replace(String find, String change) {
		this.FORMAT = this.FORMAT.replace(find, change);
	}
	
	@Override
	public String toString() {
		
		//format
		processPackage("$package");
		processImport("$import");
		processMethod("$method");
		
		return String.format(FORMAT, pPackage, pImport, CLASS_ACCESS, "class", CLASS_NAME, pMethod);
	}
}
