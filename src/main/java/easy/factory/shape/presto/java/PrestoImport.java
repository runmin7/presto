package easy.factory.shape.presto.java;

import java.util.ArrayList;
import java.util.List;

public class PrestoImport {

	List<String> path = new ArrayList<String>();
	
	public void setPath(String path) {
		this.path.add(String.format("import %s;", path));
	}
	
	public List<String> getPath() {
		return path;
	}
	
	@Override
	public String toString() {
		
		StringBuffer text = new StringBuffer();
		
		for (String str : path) {
			text.append(str).append("\r\n");
		}
		
		text.append("\r\n");
		
		return text.toString();
	}
}
