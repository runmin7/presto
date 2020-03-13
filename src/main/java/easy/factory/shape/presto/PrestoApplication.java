package easy.factory.shape.presto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import easy.factory.shape.presto.example.ExampleRun;

@SpringBootApplication
@RestController
public class PrestoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrestoApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "gubun", defaultValue = "1") String gubun) {
		
		if(gubun.equals("1")) {
			name+= "<a href='http://127.0.0.1:8080/hello'>refresh</>";
			ExampleRun data = new ExampleRun();
			data.start();
		}
		
		return String.format("Hello %s!", name);
	}

}
