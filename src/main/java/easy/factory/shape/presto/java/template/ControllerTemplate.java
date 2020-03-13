package easy.factory.shape.presto.java.template;

import org.springframework.util.StringUtils;

import easy.factory.shape.presto.java.PrestoClass;
import easy.factory.shape.presto.java.PrestoImport;
import easy.factory.shape.presto.java.PrestoMethod;
import easy.factory.shape.presto.java.PrestoMethod.DefaultMethod;
import easy.factory.shape.presto.java.PrestoPackage;
import easy.factory.shape.presto.java.PrestoVariable;
import easy.factory.shape.presto.java.PrestoVariable.defaultVariable;

public class ControllerTemplate {

	public static void main(String[] args) {

		String pType = "front"; //front or admin
		String pCategory = "purchase";
		
		//package
		PrestoPackage pp = new PrestoPackage();
		pp.setPath("sign.weboffice."+ pType +"." + pCategory +".controller;");
		
		String iType = "front"; //front or admin
		String iCategory = "purchase";
		String iTitle = "MotionCaptureReq";
		String iServiceName = StringUtils.capitalize(iType)+iTitle+"Service";
		String iDomainName = iTitle + "Domain";
		String iWrapperName = iTitle + "Wrapper";
		
		//import
		PrestoImport pi = new PrestoImport();
		pi.setPath("java.rmi.RemoteException");
		pi.setPath("java.util.List");
		pi.setPath("java.util.Map");
		pi.setPath("javax.servlet.http.HttpServletRequest");
		pi.setPath("org.springframework.beans.factory.annotation.Autowired");
		pi.setPath("org.springframework.stereotype.Controller");
		pi.setPath("org.springframework.web.bind.annotation.RequestBody");
		pi.setPath("org.springframework.web.bind.annotation.RequestMapping");
		pi.setPath("org.springframework.web.bind.annotation.ResponseBody");
		pi.setPath("org.springframework.web.servlet.ModelAndView");
		pi.setPath("sign.weboffice.core.base.BaseController");
		pi.setPath("sign.weboffice.core.constants.AjaxResult");
		pi.setPath("sign.weboffice.core.constants.ReqMap");
		pi.setPath("sign.weboffice.core.exception.BizRuntimeException");
		pi.setPath("sign.weboffice.core.mvc.ReturnPageTemplate");
		pi.setPath("sign.weboffice.domain.common.ResponseParking");
		pi.setPath("sign.weboffice.domain.engine.EngineDomain");
		pi.setPath("sign.weboffice.domain." + iCategory + "." + iDomainName);
		pi.setPath("sign.weboffice.domain." + iCategory + "." + iWrapperName);
		pi.setPath("sign.weboffice." + iType + "." + iCategory + ".service."+ iServiceName);

		//method
		PrestoMethod pm = new PrestoMethod();
		
		//1
		pm.addMethod(
			DefaultMethod.builder()
				.methodAnnotation(new String[]{"@RequestMapping(\"MotionCapture_I01\")"})
				.isStatic(false)
				.access("public")
				.returnType("ModelAndView")
				.methodName("MotionCapture_I01")
				.variables(new String[]{"Map<String, Object> paramMap", "HttpServletRequest request", "ModelAndView mav"}));
		
		//2
		pm.addMethod(
			DefaultMethod.builder()
				.methodAnnotation(new String[]{"@RequestMapping(\"MotionCapture_A01\")"})
				.isStatic(false)
				.access("public")
				.returnType("ResponseParking")
				.methodName("MotionCapture_A01")
				.variables(new String[]{"Map<String, Object> paramMap", "HttpServletRequest request", "@RequestBody MotionCaptureReqWrapper wrapper"}));
		
		String cType = "front";
		String cTitle = StringUtils.capitalize(cType) + "MotionCapture";

		PrestoVariable pv = new PrestoVariable();
		
		pv.addVariable(defaultVariable.builder()
				.annotation("@Autowired")
				.object("FrontMotionCaptureReqService")
				.objectName("frontMotionCaptureReqService"));
		
		pv.addVariable(defaultVariable.builder()
				.annotation("@Autowired")
				.object("ReturnPageTemplate")
				.objectName("pageTemplate"));		
		
		//class + manage
		PrestoClass pc = PrestoClass.builder()
			.CLASS_ANNOTATION(new String[] {"@RequestMapping(ReqMap.FRONT_PURCHASE_PATH)", "@Controller"})
			.CLASS_ACCESS("public")
			.CLASS_NAME(cTitle + "Controller")
			.CLASS_EXTEND("BaseController")
			.CLASS_VARIABLES(pv.toStrArray())
//			.CLASS_IMPLEMENTS("")
			.pPackage(pp)
			.pImport(pi)
			.pMethod(pm)
			.build();
		
		System.out.println(pc.toString());
	}
	
}
