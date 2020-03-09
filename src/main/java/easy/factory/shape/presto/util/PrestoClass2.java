package easy.factory.shape.presto.util;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public class PrestoClass2 {

	@Getter @Builder.Default private String jClass = "Clccccccccass";
	private String jMethod;
	private String jName;
	
    @Builder.Default
    private String name = "wonwoo";
}
