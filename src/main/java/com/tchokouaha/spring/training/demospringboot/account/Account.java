package com.tchokouaha.spring.training.demospringboot.account;

import org.springframework.stereotype.Component;

@Component
public class Account {

    private Long accountNumber;

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                '}';
    }
}
