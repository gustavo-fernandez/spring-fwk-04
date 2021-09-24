package com.example.springfwk04.delegate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BbvaService implements ExternalBankService {
  @Override
  public void transfer(double amount) {
    log.info("Transfiriendo {} a BBVA", amount);
  }

  @Override
  public boolean supports(String destinationBank) {
    return destinationBank.equals("BBVA");
  }
}
