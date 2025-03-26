package Exercicio06;

import java.util.Scanner;

public class Main {

    private static final Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n\n-----------------------------------------");
            System.out.println("|  <<-- Gerenciamento de contatos -->>  |");
            System.out.println("-----------------------------------------");
            System.out.println("|     #- [1] Adicionar contato          |");
            System.out.println("|     #- [2] Buscar contato por nome    |");
            System.out.println("|     #- [3] Mostrar todos os contatos  |");
            System.out.println("|     #- [0] Sair                       |");
            System.out.println("-----------------------------------------");
            System.out.print("#- Escolha uma opção: ");
            opcao = Integer.parseInt(ler.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n---------------------------------");
                    System.out.println("|  <<-- Adicionar contato -->>  |");
                    System.out.println("---------------------------------");
                    Agenda.adicionarNovoContato();
                    break;
                case 2:
                    System.out.println("\n------------------------------");
                    System.out.println("|  <<-- Buscar contato -->>  |");
                    System.out.println("------------------------------");
                    Agenda.buscarContato();
                    break;
                case 3:
                    System.out.println("\n------------------------------------");
                    System.out.println("|  <<-- Contatos adicionados -->>  |");
                    System.out.println("------------------------------------");
                    Agenda.exibirContatos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default: System.out.println("Erro -> Escolha uma opção válida!!"); break;
            }
        }while(opcao != 0);

        ler.close();
    }
}
