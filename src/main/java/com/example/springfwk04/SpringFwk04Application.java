package com.example.springfwk04;

import java.util.Comparator;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringFwk04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(SpringFwk04Application.class, args);

		BeanDefinition beanDefinition = BeanDefinitionBuilder
			.genericBeanDefinition(NoEsUnBean.class)
			.getBeanDefinition();
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) appContext.getBeanFactory();
		beanFactory.registerBeanDefinition("beanDeEjemplo", beanDefinition);

		Map<String, Object> allBeans = appContext.getBeansOfType(Object.class);
		allBeans
			.entrySet()
			.stream()
			.filter(entry -> entry.getValue().getClass().getPackage().getName().startsWith("com.example.springfwk04"))
			.sorted(Comparator.comparing(Map.Entry::getKey))
			.forEach(entry -> log.info("beanName: {}, beanObject: {}", entry.getKey(), entry.getValue()));

		NoEsUnBean beanDeEjemplo = beanFactory.getBean("beanDeEjemplo", NoEsUnBean.class);
		log.info("Ya es un bean: {}", beanDeEjemplo);
		log.info("Campo inyectado: {}", beanDeEjemplo.myService);
	}

}
