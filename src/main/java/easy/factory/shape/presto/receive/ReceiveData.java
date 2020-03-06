package easy.factory.shape.presto.receive;

import easy.factory.shape.presto.receive.make.MakeContoroller;

public class ReceiveData {

	public void start() {
		
		System.out.println("-------------- 프로그램 시작 --------------");
		
		//입력값으로 메뉴명을 받고
		String menuTab = "purchase";
		String menuName = "motionCapture";
		
		//이 메뉴명으로 컨트롤러 샘플을 만들어서 내려준다.
		MakeContoroller makeContoroller = new MakeContoroller();
		String ss = makeContoroller.getFile(menuName, menuTab);
		
		System.out.println(ss);
		
		System.out.println("-------------- 프로그램 종료 --------------");
	}
	
	
	
	
	
}
