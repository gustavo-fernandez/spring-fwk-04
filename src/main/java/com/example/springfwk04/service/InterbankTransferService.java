package com.example.springfwk04.service;

import com.example.springfwk04.delegate.ExternalBankService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class InterbankTransferService {

  private List<ExternalBankService> externalBankService;

  public void transfer(String destinationBank, double amount) {

    // externalBankService.forEach(impl -> log.info(impl.getClass().toString())); // Ahora son los proxies!

    ExternalBankService externalBankService = getExternalBankService(destinationBank);
    externalBankService.transfer(amount);
  }

  private ExternalBankService getExternalBankService(String destinationBank) {
    return externalBankService.stream()
      .filter(externalBankService -> externalBankService.supports(destinationBank))
      .findFirst()
      .orElseThrow(() -> new IllegalStateException("Destination bank '" + destinationBank + "' not supported"));
  }

}
