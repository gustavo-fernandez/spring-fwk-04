package com.example.springfwk04;

import com.example.springfwk04.service.InterbankTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringFwk04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(SpringFwk04Application.class, args);
		InterbankTransferService service = appContext.getBean(InterbankTransferService.class);
		service.transfer("BCP", 10.0);
		service.transfer("BBVA", 20.0);
		service.transfer("MIBANCO", 30.0);
		service.transfer("SCOTIABANK", 40.0);
	}

}
