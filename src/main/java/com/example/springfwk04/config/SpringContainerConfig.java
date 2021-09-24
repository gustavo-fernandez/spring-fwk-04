package com.example.springfwk04.config;

import com.example.springfwk04.cache.infraestracture.InfinispamCacheService;
import com.example.springfwk04.cache.infraestracture.RedisCacheService;
import com.example.springfwk04.cache.spi.CacheService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContainerConfig {

  @Bean
  public CacheService cacheService(@Value("${cache.implementation}") String cacheImplementation) {
    if (cacheImplementation.equals("infinispam")) {
      return new InfinispamCacheService();
    }
    if (cacheImplementation.equals("redis")) {
      return new RedisCacheService();
    }
    throw new IllegalStateException("No cache implementation was found");
  }

}
