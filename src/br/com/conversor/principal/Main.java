package br.com.conversor.principal;

import br.com.conversor.objetos.ConversorMoedas;
import br.com.conversor.records.MoedaAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;
        Scanner leitura = new Scanner(System.in);
        double valor;
        double valorConvertido;

        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

        while (opcao != 7) {
            System.out.println("""
                    
                    ------------------------------------------------------------
                    Bem vindo(a) ao conversor de moedas!
                    Escolha uma das opções abaixo para realizar a conversão:
                    
                    1) Dólar -> Peso Argentino
                    2) Peso Argentino -> Dólar
                    
                    3) Dólar -> Peso Colombiano
                    4) Peso Colombiano -> Dólar
                    
                    5) Dólar -> Real Brasileiro
                    6) Real Brasileiro -> Dólar
                    
                    7) SAIR
                    ------------------------------------------------------------
                    """);
            opcao = leitura.nextInt();
            System.out.println("Agora digite o valor a ser convertido: ");
            valor = leitura.nextDouble();

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(ConversorMoedas.getEndereco()))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                //System.out.println(json);

                MoedaAPI moeda = gson.fromJson(json, MoedaAPI.class);
                //System.out.println(moeda);

                ConversorMoedas myTitle = new ConversorMoedas(moeda);
                //System.out.println(myTitle);

                if (opcao == 1) {
                    valorConvertido = valor * moeda.ARS();
                    System.out.println("O valor em Dólar de US$"+valor+" convertido para Peso Argentino é de $"+valorConvertido);
                }
                if (opcao == 2) {
                    valorConvertido = valor / moeda.ARS();
                    System.out.println("O valor do Peso Argentino de $"+valor+" convertido para Dólar é de US$"+valorConvertido);
                }

                if (opcao == 3) {
                    valorConvertido = valor * moeda.COP();
                    System.out.println("O valor em Dólar de US$"+valor+" convertido para Peso Colombiano é de $"+valorConvertido);
                }
                if (opcao == 2) {
                    valorConvertido = valor / moeda.COP();
                    System.out.println("O valor do Peso Colombiano de $"+valor+" convertido para Dólar é de US$"+valorConvertido);
                }

                if (opcao == 3) {
                    valorConvertido = valor * moeda.BRL();
                    System.out.println("O valor em Dólar de US$"+valor+" convertido para Real Brasileiro é de R$"+valorConvertido);
                }
                if (opcao == 4) {
                    valorConvertido = valor / moeda.BRL();
                    System.out.println("O valor do Real Brasileiro de R$"+valor+" convertido para Dólar é de US$"+valorConvertido);
                }

            } catch (NumberFormatException e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ocorreu um erro no link: " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("O programa finalizou!");
            }

        }
        System.out.println("O programa finalizou corretamente!");

    }
}