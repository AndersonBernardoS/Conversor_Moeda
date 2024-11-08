package Modelo;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class ExchangeRateResponse {
    @SerializedName("result")
    private String result;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    public boolean isSuccess() {
        return "success".equals(result);
    }

    public double getConversionRate(String currencyCode) {
        return conversionRates.getOrDefault(currencyCode, 0.0);
    }
}