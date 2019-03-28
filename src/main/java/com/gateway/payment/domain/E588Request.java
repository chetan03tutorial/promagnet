package com.gateway.payment.domain;

public class E588Request {
    private String accountNumber;
    private int tariff;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getTariff() {
        return tariff;
    }

    public void setTariff(int tariff) {
        this.tariff = tariff;
    }
}
