package cn.johnnyzen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MasterTeachersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterTeachersApplication.class, args);
	}

	@RequestMapping("/") //设置默认索引页
	public String index(){
		return "index";
	}
}
