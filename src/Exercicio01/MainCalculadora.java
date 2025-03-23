package Exercicio01;

import java.util.Scanner;

public class MainCalculadora {
    private static final Scanner ler = new Scanner(System.in);

    public static double catchPrimeiroNum() {
        System.out.print("Digite o primeiro numero: ");
        return Double.parseDouble(ler.nextLine());
    }

    public static double catchSegundoNun() {
        System.out.print("Digite o segundo numero: ");
        return Double.parseDouble(ler.nextLine());
    }

    public static void mostrarResultado(double resultado, String operacao) {
        System.out.println("O resultado da " + operacao + ": " + resultado);
    }

    public static void main(String[] args) {
       int opcao;
        do {
            System.out.println("\n\n-----------------------------");
            System.out.println("|   <<-- CALCULADORA -->>   |");
            System.out.println("-----------------------------");
            System.out.println("|   ## [1] Soma             |");
            System.out.println("|   ## [2] Subtração        |");
            System.out.println("|   ## [3] Multiplicação    |");
            System.out.println("|   ## [4] Divisão          |");
            System.out.println("|   ## [0] Sair             |");
            System.out.println("-----------------------------");
            System.out.print("#- Escolha uma operação: ");
            opcao = Integer.parseInt(ler.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|      <<-- SOMA -->>       |");
                    System.out.println("-----------------------------");
                    mostrarResultado(Calculadora.soma(catchPrimeiroNum(), catchSegundoNun()), "soma");
                    break;
                case 2:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|    <<-- SUBTRACAO -->>    |");
                    System.out.println("-----------------------------");
                    mostrarResultado(Calculadora.subtracao(catchPrimeiroNum(), catchSegundoNun()), "subtração");
                    break;
                case 3:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|  <<-- Multiplicação -->>  |");
                    System.out.println("-----------------------------");
                    mostrarResultado(Calculadora.multiplicacao(catchPrimeiroNum(), catchSegundoNun()), "multiplicação");
                    break;
                case 4:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|     <<-- DIVISÃO -->>     |");
                    System.out.println("-----------------------------");
                    mostrarResultado(Calculadora.divisao(catchPrimeiroNum(), catchSegundoNun()), "divisão");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default: System.out.println("\n<<Escolha uma opção existente!!>>"); break;
            }
        } while(opcao != 0);
        ler.close();
    }
}
