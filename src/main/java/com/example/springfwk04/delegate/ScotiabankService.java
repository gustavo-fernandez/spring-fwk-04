package com.example.springfwk04.delegate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScotiabankService implements ExternalBankService {

  @Override
  public void transfer(double amount) {
    log.info("Transfer to Scotiabank");
  }

  @Override
  public boolean supports(String destinationBank) {
    return destinationBank.startsWith("SCOTIA");
  }
}
