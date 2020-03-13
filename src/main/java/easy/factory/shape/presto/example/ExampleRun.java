package easy.factory.shape.presto.example;

import easy.factory.shape.presto.java.template.ControllerTemplate;

public class ExampleRun {

	public void start() {
		
		System.out.println("-------------- 프로그램 시작 --------------");
		
//		ClassExampleRun.main(null);
		ControllerTemplate.main(null);
		
		System.out.println("-------------- 프로그램 종료 --------------");
	}
	
	public static void main(String[] args) {
		new ExampleRun().start();
	}
	
	
	
	
	
}
