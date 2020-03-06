package easy.factory.shape.presto.util;

public class StringBufferUtil {

	StringBuffer sb = null;

	public StringBufferUtil() {
		this.sb = new StringBuffer();
	}

	public StringBufferUtil appendLF(String str) {
		sb.append(str).append("\r\n");
		return this;
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}
	
}
