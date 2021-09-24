package com.example.springfwk04.delegate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
// BCP, MIBANCO
@Service
public class BcpService implements ExternalBankService {
  @Override
  public void transfer(double amount) {
    log.info("Transfiriendo {} a BCP o MIBANCO", amount);
  }

  @Override
  public boolean supports(String destinationBank) {
    return destinationBank.equals("BCP")
      || destinationBank.equals("MIBANCO");
  }
}