import Servicos.ExchangeRateService;
import Util.CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeRateService rateService = new ExchangeRateService();
        CurrencyConverter converter = new CurrencyConverter(rateService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
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
                    
                    Digite sua opção abaixo:
                    ------------------------------------------------------------
                    """);
            int opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Você saiu e o programa finalizou corretamente!");
                running = false;
                continue;
            }

            System.out.println("Agora digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            double valorConvertido = 0.0;

            String targetCurrency = switch (opcao) {
                case 1 -> "EUR";
                case 2 -> "BRL";
                case 3 -> "JPY";
                case 4 -> "GBP";
                case 5 -> "CAD";
                case 6 -> "AUD";
                default -> throw new IllegalStateException("Opção inválida.");
            };

            try {
                switch (opcao) {
                    case 1 -> {
                        valorConvertido = converter.convert("USD", "ARS", valor);
                        System.out.printf("O valor em Dólar de US$%.2f convertido para Peso Argentino é de $%.2f%n", valor, valorConvertido);
                    }
                    case 2 -> {
                        valorConvertido = converter.convert("ARS", "USD", valor);
                        System.out.printf("O valor do Peso Argentino de $%.2f convertido para Dólar é de US$%.2f%n", valor, valorConvertido);
                    }
                    case 3 -> {
                        valorConvertido = converter.convert("USD", "COP", valor);
                        System.out.printf("O valor em Dólar de US$%.2f convertido para Peso Colombiano é de $%.2f%n", valor, valorConvertido);
                    }
                    case 4 -> {
                        valorConvertido = converter.convert("COP", "USD", valor);
                        System.out.printf("O valor do Peso Colombiano de $%.2f convertido para Dólar é de US$%.2f%n", valor, valorConvertido);
                    }
                    case 5 -> {
                        valorConvertido = converter.convert("USD", "BRL", valor);
                        System.out.printf("O valor em Dólar de US$%.2f convertido para Real Brasileiro é de R$%.2f%n", valor, valorConvertido);
                    }
                    case 6 -> {
                        valorConvertido = converter.convert("BRL", "USD", valor);
                        System.out.printf("O valor do Real Brasileiro de R$%.2f convertido para Dólar é de US$%.2f%n", valor, valorConvertido);
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage());
            }
        }

        scanner.close();
    }
}