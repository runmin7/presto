package easy.factory.shape.presto.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

public class PrestoMethod {
	
	ArrayList<DefaultMethod> arrayMethod = new ArrayList<>();
	
	public void addMethod(boolean isStatic, String access, String returnType, String methodName, String[] variables){

		DefaultMethod defaultMethod = new DefaultMethod();
		defaultMethod.setStatic(isStatic);
		defaultMethod.setAccess(access);
		defaultMethod.setReturnType(returnType);
		defaultMethod.setMethodName(methodName);
		defaultMethod.setVariables(variables);

		arrayMethod.add(defaultMethod);
	}	
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		for (DefaultMethod defaultMethod : arrayMethod) {
			sb.append(defaultMethod).append("\r\n\r\n");
		}
		
		return sb.toString();
	}
	
	class DefaultMethod {
		@Getter @Setter boolean isStatic;
		@Getter @Setter String access;
		@Getter @Setter String returnType;
		@Getter @Setter String methodName;
		@Getter @Setter String[] variables;
		
		@Override
		public String toString() {
			
			String format = "\t$static%s %s %s($variables){\r\n\r\n$returnType\t}"; 

			//파라미터가 있으면 키워드를 살리고, 없으면 지우는게 핵심
			if(isStatic) format = format.replace("$static", "static ");
			if(variables != null) format = format.replace("$variables", "%s");
			
			//remove
			format = format.replace("$static", "");
			format = format.replace("$variables", "");
			
			//variables
			StringBuffer variable = new StringBuffer();
			for (String var : variables) {
				
				if(variable.length() > 0) variable.append(", ");
				variable.append(var);
			}
			
			//return value
			if(returnType.equalsIgnoreCase("void")) {
				format = format.replace("$returnType", "");
			}else if(returnType.equalsIgnoreCase("string")) {
				format = format.replace("$returnType", "\t\treturn \"\";\r\n");
			}else if(returnType.equalsIgnoreCase("int")) {
				format = format.replace("$returnType", "\t\treturn 0;\r\n");
			}else {
				format = format.replace("$returnType", "\t\treturn new "+ StringUtils.capitalize(returnType) +"();\r\n");
			}
			
			return String.format(format, access, returnType, methodName, variable.toString());
		}
	}
	
}
