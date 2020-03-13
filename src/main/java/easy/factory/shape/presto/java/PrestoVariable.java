package easy.factory.shape.presto.java;

import java.util.ArrayList;
import java.util.List;

import easy.factory.shape.presto.java.PrestoVariable.defaultVariable.defaultVariableBuilder;
import lombok.Builder;

public class PrestoVariable {

	List<defaultVariable> list = new ArrayList<>();
	
	public void addVariable(defaultVariableBuilder builder){
		list.add(builder.build());
	}
	
	public String[] toStrArray(){
		
		String[] temp = new String[list.size()];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = list.get(i).toString();
		}
		
		return temp;
		
	}
	
	@Builder
	static public class defaultVariable {

		String annotation;
		String object;
		String objectName;
		
		@Builder.Default private String FORMAT = "%s\r\n\t%s %s\r\n"; 
		
		@Override
		public String toString() {
			
			return String.format(FORMAT, annotation, object, objectName);
		}
		
	}
}
