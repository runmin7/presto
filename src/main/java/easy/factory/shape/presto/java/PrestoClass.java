package easy.factory.shape.presto.java;

import lombok.Builder;

@Builder
public class PrestoClass {

	@Builder.Default private String CLASS_EXTEND = "";
	@Builder.Default private String CLASS_IMPLEMENTS = "";
	@Builder.Default private String CLASS_ACCESS = "public";
	@Builder.Default private String CLASS_NAME = "sample";
	@Builder.Default private String FORMAT = "$package$import$annotation%s class %s $extend$implements {\r\n\r\n$classVariables$method}";

	private String[] CLASS_ANNOTATION;
	private String[] CLASS_VARIABLES;
	
	private PrestoPackage pPackage;
	private PrestoImport pImport;
	private PrestoMethod pMethod;
	
	//annotation
	private void processAnnotation(String find) {
		if(CLASS_ANNOTATION != null) replace(find, "%s");
		else replace(find, "%s");
	}
	
	//class variables
	private void processClassVariables(String find) {
		if(CLASS_VARIABLES != null) replace(find, "%s");
		else replace(find, "%s");
	}
	
	//extend
	private void processExtend(String find) {
		if(CLASS_EXTEND != null) replace(find, "extends %s");
		else replace(find, "%s");
	}
	
	//implements
	private void processImplements(String find) {
		if(CLASS_IMPLEMENTS != null) replace(find, "implements %s");
		else replace(find, "%s");
	}
	
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
	
	private StringBuffer getVariablesText(String[] str) {
		
		StringBuffer tempVar = new StringBuffer();
		if(str != null) {
			for (String var : str) {
				tempVar.append(var)
					.append("\r\n");
			}
		}
		
		return tempVar;
	}
	
	//variable
	private StringBuffer getAnnotaionText(String[] str) {
		
		StringBuffer tempVar = new StringBuffer();
		if(str != null) {
			for (String var : str) {
				tempVar.append("\t")
					.append(var)
					.append("\r\n");
			}
		}
		
		return tempVar;
	}
	
	@Override
	public String toString() {
		
		//format
		processAnnotation("$annotation");
		processImplements("$implements");
		processPackage("$package");
		processExtend("$extend");
		processImport("$import");
		processClassVariables("$classVariables");
		processMethod("$method");
		
		//annotation
		StringBuffer tempVar = getVariablesText(this.CLASS_ANNOTATION);
		StringBuffer tempClassVar = getAnnotaionText(this.CLASS_VARIABLES);

		return String.format(FORMAT, pPackage, pImport, tempVar, CLASS_ACCESS, CLASS_NAME, CLASS_EXTEND, CLASS_IMPLEMENTS, tempClassVar, pMethod);
	}
}
