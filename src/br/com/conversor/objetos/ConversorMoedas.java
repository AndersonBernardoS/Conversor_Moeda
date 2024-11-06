package br.com.conversor.objetos;

import br.com.conversor.records.MoedaAPI;

public class ConversorMoedas {
    private static String chave = "5dd68edc8e74db5c24b2b20a";
    private static final String endereco = "https://v6.exchangerate-api.com/v6/"+chave+"/latest/USD";

    private String result;
    private String documentation;
    private String terms_of_use;
    private long time_last_update_unix;
    private String time_last_update_utc;
    private long time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private MoedaAPI conversion_rates;

    public ConversorMoedas(MoedaAPI moeda) {
    }

    public static String getEndereco() {
        return endereco;
    }


    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public long getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public long getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public MoedaAPI getConversion_rates() {
        return conversion_rates;
    }
}
