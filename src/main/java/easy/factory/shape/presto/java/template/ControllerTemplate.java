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
		
		String iType = "front";
		String iCategory = "purchase";
		String iTitle = "MotionCapture";
		
		//import
		PrestoImport pi = new PrestoImport();
		pi.setImport("java.rmi.RemoteException");
		pi.setImport("java.util.List");
		pi.setImport("java.util.Map");
		pi.setImport("javax.servlet.http.HttpServletRequest");
		pi.setImport("org.springframework.beans.factory.annotation.Autowired");
		pi.setImport("org.springframework.stereotype.Controller");
		pi.setImport("org.springframework.web.bind.annotation.RequestBody");
		pi.setImport("org.springframework.web.bind.annotation.RequestMapping");
		pi.setImport("org.springframework.web.bind.annotation.ResponseBody");
		pi.setImport("org.springframework.web.servlet.ModelAndView");
		pi.setImport("sign.weboffice.core.base.BaseController");
		pi.setImport("sign.weboffice.core.constants.AjaxResult");
		pi.setImport("sign.weboffice.core.constants.ReqMap");
		pi.setImport("sign.weboffice.core.exception.BizRuntimeException");
		pi.setImport("sign.weboffice.core.mvc.ReturnPageTemplate");
		pi.setImport("sign.weboffice.domain.common.ResponseParking");
		pi.setImport("sign.weboffice.domain.engine.EngineDomain");
		pi.setImport("sign.weboffice.domain." + iCategory + "." + iTitle + "ReqDomain");
		pi.setImport("sign.weboffice.domain." + iCategory + "." + iTitle + "ReqWrapper");
		pi.setImport("sign.weboffice." + iType + "." + iCategory + ".service."+ StringUtils.capitalize(iType) + iTitle + "ReqService");

		//method
		PrestoMethod pm = new PrestoMethod();
		
		//1
		pm.addMethod(
			DefaultMethod.builder()
				.methodAnnotation(new String[]{"@RequestMapping(\""+ iTitle +"_I01\")"})
				.isStatic(false)
				.access("public")
				.returnType("ModelAndView")
				.methodName(iTitle + "_I01")
				.variables(new String[]{"Map<String, Object> paramMap", "HttpServletRequest request", "ModelAndView mav"}));
		
		//2
		pm.addMethod(
			DefaultMethod.builder()
				.methodAnnotation(new String[]{"@RequestMapping(\""+ iTitle +"_A01\")"})
				.isStatic(false)
				.access("public")
				.returnType("ResponseParking")
				.methodName(iTitle + "_A01")
				.variables(new String[]{"Map<String, Object> paramMap", "HttpServletRequest request", "@RequestBody " + iTitle + "ReqWrapper wrapper"}));
		
		String cType = "front";
		String cTitle = "MotionCapture";
		String cCategory = "purchase";

		//pvariable
		PrestoVariable pv = new PrestoVariable();
		
		pv.addVariable(defaultVariable.builder()
				.annotation("@Autowired")
				.object(cType + cTitle + "ReqService")
				.objectName(cType + cTitle + "ReqService"));
		
		pv.addVariable(defaultVariable.builder()
				.annotation("@Autowired")
				.object("ReturnPageTemplate")
				.objectName("pageTemplate"));		
		
		//class + manage
		PrestoClass pc = PrestoClass.builder()
			.CLASS_ANNOTATION(new String[] {"@RequestMapping(ReqMap."+ cType.toUpperCase() +"_"+ cCategory +"_PATH)", "@Controller"})
			.CLASS_ACCESS("public")
			.CLASS_NAME(StringUtils.capitalize(cType) + cTitle + "Controller")
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
