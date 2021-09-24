package com.example.springfwk04.service;

import com.example.springfwk04.cache.spi.CacheService;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("myService")
@Slf4j
public class MyService {

  private CacheService cacheService;

  public MyService(CacheService cacheService) {
    this.cacheService = cacheService;
  }

  public Integer getSomeInteger() {
    if (cacheService.hasInteger()) {
      return cacheService.getInteger();
    }
    return new Random().nextInt();
  }

}
