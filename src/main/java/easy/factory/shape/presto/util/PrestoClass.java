package easy.factory.shape.presto.util;

public class PrestoClass {

	private final String jMethod;
	private final String jClass;
	private final String jName;
	
	public static class Builder {
		
		private String jMethod;
		private String jClass;
		private String jName;
		
		public Builder jMethod(String value) {
			jMethod = value;
			return this;
		}
		
		public Builder jClass(String value) {
			jClass = value;
			return this;
		}
		
		public Builder jName(String value) {
			jName = value;
			return this;
		}
		
		public PrestoClass build() {
			return new PrestoClass(this);
		}
	}
	
	public PrestoClass(Builder builder) {
		this.jMethod = builder.jMethod;
		this.jClass = builder.jClass;
		this.jName = builder.jName;
	}

}
