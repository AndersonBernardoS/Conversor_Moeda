package Servicos;

import com.google.gson.JsonObject;
import Modelo.ExchangeRateResponse;

public class ExchangeRateService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/5dd68edc8e74db5c24b2b20a/latest/";

    private final ApiClient apiClient;

    public ExchangeRateService() {
        this.apiClient = new ApiClient();
    }

    public double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        ExchangeRateResponse response = apiClient.getRates(baseCurrency);
        return response.getConversionRate(targetCurrency);
    }
}