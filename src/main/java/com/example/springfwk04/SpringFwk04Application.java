package com.example.springfwk04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringFwk04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(SpringFwk04Application.class, args);

		MyService bean = appContext.getBean(MyService.class);
		log.info("bean: {}", bean);
		MyService bean1 = appContext.getBean(MyService.class);
		log.info("bean1: {}", bean1);
		MyService bean2 = appContext.getBean(MyService.class);
		log.info("bean2: {}", bean2);
	}

}
