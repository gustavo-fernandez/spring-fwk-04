package com.example.springfwk04.config;

import com.example.springfwk04.cache.infraestracture.InfinispamCacheService;
import com.example.springfwk04.cache.infraestracture.RedisCacheService;
import com.example.springfwk04.cache.spi.CacheService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContainerConfig {

  @Bean
  @ConditionalOnProperty(name = "cache.implementation",
    havingValue = "redis")
  public CacheService redisCacheService() {
    return new RedisCacheService();
  }

  @Bean
  @ConditionalOnProperty(name = "cache.implementation",
    havingValue = "infinispam")
  public CacheService infinispamCacheService() {
    return new InfinispamCacheService();
  }

}
