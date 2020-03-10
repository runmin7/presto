package easy.factory.shape.presto.util;

import lombok.Setter;

public class PrestoPackage {

	@Setter private String path;
	
	@Override
	public String toString() {
		return String.format("package %s\r\n\r\n", this.path);
	}
	
}
