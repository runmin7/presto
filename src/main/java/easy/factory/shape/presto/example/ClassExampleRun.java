package easy.factory.shape.presto.example;

import easy.factory.shape.presto.java.PrestoClass;

import easy.factory.shape.presto.java.PrestoImport;
import easy.factory.shape.presto.java.PrestoMethod;
import easy.factory.shape.presto.java.PrestoPackage;
import easy.factory.shape.presto.java.PrestoClass.PrestoClassBuilder;
import easy.factory.shape.presto.java.PrestoMethod.DefaultMethod;

public class ClassExampleRun {

	//컨트롤러 템플릿 하나
	//서비스 템플릿 하나
	//DAO 템플릿 하나
	//이런식으로 클래스의 견본을 무수히 만들고... 
	//최종적으로 거기에 파라미터 이름만 넣어주면 그 이름으로 클래스가 찍어져 나오도록 하자!
	public static void main(String[] args) {

		//package
		PrestoPackage pp = new PrestoPackage();
		pp.setPath("easy.factory.shape.presto.util");
		
		//import
		PrestoImport pi = new PrestoImport();
		pi.setImport("lombok.Builder");
		pi.setImport("lombok.ToString");
		
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
		PrestoClass pc = PrestoClass.builder()
			.CLASS_ACCESS("public")
			.CLASS_NAME("test")
			.pPackage(pp)
			.pImport(pi)
			.pMethod(pm)
			.build();
		
		
		System.out.println(pc.toString());
	}
	
}
