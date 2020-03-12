package easy.factory.shape.presto.util;

import easy.factory.shape.presto.util.PrestoMethod.DefaultMethod;

public class PrestoExample {

	public static void main(String[] args) {

		//package
		PrestoPackage pp = new PrestoPackage();
		pp.setPath("easy.factory.shape.presto.util");
		
		//import
		PrestoImport pi = new PrestoImport();
		pi.setPath("lombok.Builder");
		pi.setPath("lombok.ToString");
		
		//method
		PrestoMethod pm = new PrestoMethod();
		
		//1
		pm.addMethod(
			DefaultMethod.builder()
				.isStatic(true)
				.access("public")
				.returnType("void")
				.methodName("sample")
				.variables(new String[]{"Date date", "int num"}));
		
		//2
		pm.addMethod(
			DefaultMethod.builder()
				.isStatic(true)
				.access("public")
				.returnType("void")
				.methodName("sample2")
				.variables(null));
		
		//class + manage
		PrestoClass pc = new PrestoClass.PrestoClassBuilder()
				.CLASS_ACCESS("public")
				.CLASS_NAME("test")
				.pPackage(pp)
				.pImport(pi)
				.pMethod(pm)
				.build();
		
		System.out.println(pc.toString());
	}
	
}
