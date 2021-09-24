package com.example.springfwk04;

import java.util.Comparator;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringFwk04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(SpringFwk04Application.class, args);

		appContext.getBeanFactory().registerSingleton("beanDeEjemplo", new NoEsUnBean());
		appContext.getAutowireCapableBeanFactory().autowireBean(appContext.getBean("beanDeEjemplo"));

		Map<String, Object> allBeans = appContext.getBeansOfType(Object.class);
		allBeans
			.entrySet()
			.stream()
			.filter(entry -> entry.getValue().getClass().getPackage().getName().startsWith("com.example.springfwk04"))
			.sorted(Comparator.comparing(Map.Entry::getKey))
			.forEach(entry -> log.info("beanName: {}, beanObject: {}", entry.getKey(), entry.getValue()));

		NoEsUnBean beanDeEjemplo = (NoEsUnBean) appContext.getBean("beanDeEjemplo");
		log.info("Ya es un bean: {}", beanDeEjemplo);
		log.info("Campo inyectado: {}", beanDeEjemplo.myService);
	}

}
