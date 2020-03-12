package easy.factory.shape.presto.util;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import easy.factory.shape.presto.util.PrestoMethod.DefaultMethod.DefaultMethodBuilder;
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
	static class DefaultMethod {
		
		@Setter boolean isStatic;
		@Setter String access;
		@Setter String returnType;
		@Setter String methodName;
		@Setter String[] variables;

		@Builder.Default private String FORMAT = "\t$static%s %s %s($variables){\r\n\r\n$returnType\t}"; 
		
		//static
		private void processStatic(String find) {
			if(isStatic) replace(find, "static ");
			else replace(find, "");
		}
		
		//variables
		private void processVariables(String find) {
			if(variables != null) replace(find, "%s");
			else replace(find, "");
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
		
		private StringBuffer getVariablesText() {
			
			StringBuffer tempVar = new StringBuffer();
			if(this.variables != null) {
				for (String var : variables) {
					if(tempVar.length() > 0) tempVar.append(", ");
					tempVar.append(var);
				}
			}
			
			return tempVar;
		}
		
		@Override
		public String toString() {
			
			//format
			processStatic("$static");
			processVariables("$variables");
			processReturn("$returnType");

			//variables
			StringBuffer tempVar = getVariablesText();
			
			return String.format(FORMAT, access, returnType, methodName, tempVar.toString());
		}
	}
	
}
