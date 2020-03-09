package easy.factory.shape.presto.word.constant;

public class Word {
	
	public static final class Identifier{
		public static final String PUBLIC = "public";
		public static final String CLASS = "class";
		public static final String PACKAGE = "package";
	}
	
	public static final class Annotation {
		public static final String CONTROLLER = "@Controller";
		public static final String REQUEST_MAPPING = "@RequestMapping";
		public static final String AUTOWIRED = "@Autowired";
	}
	
	public static final class Import{
		public static final String HTTP_SERVLET_REQUEST = "import javax.servlet.http.HttpServletRequest";
		public static final String REQ_MAP = "import sign.weboffice.core.constants.ReqMap";
	}
	
}
