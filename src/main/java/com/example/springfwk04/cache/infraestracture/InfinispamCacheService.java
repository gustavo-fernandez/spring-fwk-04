package com.example.springfwk04.cache.infraestracture;

import com.example.springfwk04.cache.spi.CacheService;

public class InfinispamCacheService implements CacheService {
  @Override
  public boolean hasInteger() {
    return true;
  }

  @Override
  public Integer getInteger() {
    return 200;
  }
}
