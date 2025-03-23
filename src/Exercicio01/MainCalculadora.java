package Exercicio01;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class MainCalculadora {
    private static final Scanner ler = new Scanner(System.in);

    public static double pegarPrimeiroNum() {
        System.out.print("Digite o primeiro numero: ");
        return Double.parseDouble(ler.nextLine());
    }

    public static double pegarSegundoNun() {
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
                    mostrarResultado(Calculadora.soma(pegarPrimeiroNum(), pegarSegundoNun()), "soma");
                    break;
                case 2:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|    <<-- SUBTRACAO -->>    |");
                    System.out.println("-----------------------------");
                    mostrarResultado(Calculadora.subtracao(pegarPrimeiroNum(), pegarSegundoNun()), "subtração");
                    break;
                case 3:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|  <<-- Multiplicação -->>  |");
                    System.out.println("-----------------------------");
                    mostrarResultado(Calculadora.multiplicacao(pegarPrimeiroNum(), pegarSegundoNun()), "multiplicação");
                    break;
                case 4:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|     <<-- DIVISÃO -->>     |");
                    System.out.println("-----------------------------");
                    double resultado = Calculadora.divisao(pegarPrimeiroNum(), pegarSegundoNun());

                    if(Double.isNaN(resultado)) {
                        System.out.println("Erro: Divisão por 0");
                    } else {
                        mostrarResultado(resultado, "divisão");
                    }
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
