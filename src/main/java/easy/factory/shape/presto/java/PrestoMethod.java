package easy.factory.shape.presto.java;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import easy.factory.shape.presto.java.PrestoMethod.DefaultMethod.DefaultMethodBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class PrestoMethod {
	
	ArrayList<DefaultMethod> arrayMethod = new ArrayList<>();
	
	public void addMethod(DefaultMethodBuilder build) {
		arrayMethod.add(build.build());
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		for (DefaultMethod defaultMethod : arrayMethod) {
			sb.append(defaultMethod).append("\r\n\r\n");
		}
		
		return sb.toString();
	}
	
	@Builder
	static public class DefaultMethod {
		
		@Setter boolean isStatic;
		@Setter String access;
		@Setter String returnType;
		@Setter String methodName;
		@Setter String[] variables;
		@Setter String[] methodAnnotation;

		@Builder.Default private String FORMAT = "$methodAnnotation\t$static%s %s %s($variables){\r\n\r\n$returnType\t}"; 
		
		//static
		private void processStatic(String find) {
			if(isStatic) replace(find, "static ");
			else replace(find, "");
		}
		
		//variables
		private void processVariables(String find) {
			if(variables != null) replace(find, "%s");
			else replace(find, "%s");
		}
		
		//method annotation
		private void processMethodAnnotation(String find) {
			if(methodAnnotation != null) replace(find, "%s");
			else replace(find, "%s");
		}
		
		
		//return 
		private void processReturn(String find) {
			
			if(returnType.equalsIgnoreCase("void")) replace(find, "");
			else if(returnType.equalsIgnoreCase("string")) replace(find, "\t\treturn \"\";\r\n");
			else if(returnType.equalsIgnoreCase("int")) replace(find, "\t\treturn 0;\r\n");
			else replace(find, "\t\treturn new "+ StringUtils.capitalize(returnType) +"();\r\n");
		}
		
		//find and change
		private void replace(String find, String change) {
			this.FORMAT = this.FORMAT.replace(find, change);
		}
		
		//variable
		private StringBuffer getVariablesText(String[] str) {
			
			StringBuffer tempVar = new StringBuffer();
			if(str != null) {
				for (String var : str) {
					if(tempVar.length() > 0) tempVar.append(", ");
					tempVar.append(var);
				}
			}
			
			return tempVar;
		}
		
		//annotation
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
			processMethodAnnotation("$methodAnnotation");
			processStatic("$static");
			processVariables("$variables");
			processReturn("$returnType");

			//variables
			StringBuffer tempVar = getVariablesText(this.variables);
			StringBuffer tempMethodAnnotation = getAnnotaionText(this.methodAnnotation);
			
			return String.format(FORMAT, tempMethodAnnotation, access, returnType, methodName, tempVar.toString());
		}
	}
	
}
