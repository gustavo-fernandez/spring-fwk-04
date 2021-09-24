package com.example.springfwk04.delegate;

public interface ExternalBankService {

  void transfer(double amount);

  boolean supports(String destinationBank);

}
