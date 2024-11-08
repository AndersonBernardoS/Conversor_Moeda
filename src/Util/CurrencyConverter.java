package Util;

import Servicos.ExchangeRateService;

public class CurrencyConverter {
    private final ExchangeRateService rateService;

    public CurrencyConverter(ExchangeRateService rateService) {
        this.rateService = rateService;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        double rate = rateService.getExchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}

