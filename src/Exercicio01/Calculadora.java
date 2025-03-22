package Exercicio01;

public class Calculadora {

    public static double soma(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    public static double divisao(double num1, double num2) {
        if(num1 <= 0 || num2 <= 0) {
            do {
                System.out.println("\nErro na divisão por 0!!");
                System.out.println("<<-- Informe novos numeros -->>");
                num1 = MainCalculadora.catchPrimeiroNum();
                num2 = MainCalculadora.catchSegundoNun();
            }while (num1 <= 0 || num2 <= 0);
        }
        return num1 / num2;
    }
}
