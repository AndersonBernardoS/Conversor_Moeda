package br.com.conversor.objetos;

import br.com.conversor.records.ConversionRates;
import br.com.conversor.records.MoedaAPIold;
import com.google.gson.*;

public class ConversorMoedas {
    private static String chave = "5dd68edc8e74db5c24b2b20a";
    private static String endereco = "https://v6.exchangerate-api.com/v6/" + chave + "/latest/USD";

    static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    static JsonObject jsonObject = JsonParser.parseString(String.valueOf(gson)).getAsJsonObject();
    static JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

    static double ars = conversionRates.get("ARS").getAsDouble();
    static double cop = conversionRates.get("COP").getAsDouble();
    static double usd = conversionRates.get("USD").getAsDouble();
    static double brl = conversionRates.get("BRL").getAsDouble();

    public ConversorMoedas(MoedaAPIold moeda) {
    }

    public static String getEndereco() {
        return endereco;
    }

    public static double getArs() {
        return ars;
    }

    public static double getCop() {
        return cop;
    }

    public static double getUsd() {
        return usd;
    }

    public static double getBrl() {
        return brl;
    }
}