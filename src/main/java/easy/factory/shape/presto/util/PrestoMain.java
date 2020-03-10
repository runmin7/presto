package easy.factory.shape.presto.util;

public class PrestoMain {

	public static void main(String[] args) {

		PrestoPackage pp = new PrestoPackage();
		pp.setPath("easy.factory.shape.presto.util");
		
		PrestoImport pi = new PrestoImport();
		pi.setPath("lombok.Builder");
		pi.setPath("lombok.ToString");
		
		PrestoMethod pm = new PrestoMethod();
		
		String ss[] = {"String str", "int num"};
		
		pm.addMethod(false, "public", "void", "sample1", ss);
		pm.addMethod(true, "public", "String", "sample2", ss);
		pm.addMethod(true, "public", "int", "sample3", ss);
		pm.addMethod(true, "public", "object", "sample4", ss);
		
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
