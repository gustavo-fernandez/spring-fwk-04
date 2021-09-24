package com.example.springfwk04.service;

import com.example.springfwk04.cache.spi.CacheService;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MyService {

  private CacheService cacheService;

  public Integer getSomeInteger() {
    if (cacheService.hasInteger()) {
      return cacheService.getInteger();
    }
    return new Random().nextInt();
  }

}
