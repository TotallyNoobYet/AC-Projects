package org.academiadecodigo.thisfunctionals;

import java.util.Objects;

public class Money {

    private final int amount;
    private final String currency;

    public Money(int amount, String currency) {

        if(amount < 1){
            throw new IllegalArgumentException("Amount should be positive");
        }

        if(currency == null || currency.isEmpty()){
            throw new IllegalArgumentException("Currency should be valid");
        }

        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && Objects.equals(currency, money.currency);
    }
}


