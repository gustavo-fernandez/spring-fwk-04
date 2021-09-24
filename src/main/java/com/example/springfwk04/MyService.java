package com.example.springfwk04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
// @Scope(BeanDefinition.SCOPE_SINGLETON) // default
@Slf4j
public class MyService {

  public MyService() {
    log.info("MyService created!");
  }

}
