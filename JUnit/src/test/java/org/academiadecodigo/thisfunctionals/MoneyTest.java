package org.academiadecodigo.thisfunctionals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    @Test
    @Parameters({"10, EUR",
            "25, USD",
            "67, KWZ",
            "130, YEN",
            "200, GBP"})
    //Os methods vão todos ser void
    public void constructorShouldSetAmountAndCurrency(int amount, String currency) {

        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());

    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"0", "-10", "-347", "-10826"})
    public void constructorShouldThrowIAEForInvalidAmount(int invalidAmount){
        new Money(invalidAmount, "EUR");
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"null", ""})
    public void constructorShouldThrowIAEForInvalidCurrency(@Nullable String invalidCurrency){
        new Money(10, invalidCurrency);
    }

}
