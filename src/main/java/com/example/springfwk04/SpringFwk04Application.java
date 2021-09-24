package com.example.springfwk04;

import com.example.springfwk04.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringFwk04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(SpringFwk04Application.class, args);
		MyService service = appContext.getBean(MyService.class);
		Integer someInteger = service.getSomeInteger();
		log.info("Integer obtenido: {}", someInteger);
	}

}
