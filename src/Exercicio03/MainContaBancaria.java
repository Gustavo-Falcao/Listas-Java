package Exercicio03;

import java.util.Scanner;
import java.util.ArrayList;

public class MainContaBancaria {

    private static final Scanner ler = new Scanner(System.in);

    public static ContaBancaria pegarConta() {
        System.out.print("Informe o número da conta: ");
        String numero = ler.nextLine();
        System.out.print("Informe o nome do Titular: ");
        String nome = ler.nextLine();
        System.out.print("Informe o seu saldo inicial: ");
        double saldo = Double.parseDouble(ler.nextLine());

        return new ContaBancaria(numero, nome, saldo);
    }

    public static void main(String[] args) {
        ArrayList<ContaBancaria> contasUsuarios = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n\n------------------------------");
            System.out.println("|  <<-- Conta Bancaria -->>  |");
            System.out.println("------------------------------");
            System.out.println("|   #- [1] Cadastrar conta   | ");
            System.out.println("|   #- [2] Acessar conta     |");
            System.out.println("|   #- [0] Sair              |");
            System.out.println("------------------------------");
            System.out.print("#- Escolha uma opçao: ");
            opcao = Integer.parseInt(ler.nextLine());

            if (opcao == 1) {
                System.out.println("\n---------------------------------");
                System.out.println("|  <<-- Cadastro da conta -->>  |");
                System.out.println("---------------------------------");
                contasUsuarios.add(pegarConta());
                System.out.println("Conta cadastrada com sucesso!!");
            }
            else if(opcao == 2) {
                System.out.println("\n-----------------------------");
                System.out.println("|  <<-- Acessar conta -->>  |");
                System.out.println("-----------------------------");
                System.out.print("#- Informe o número da conta: ");
                String numeroConsulta = ler.nextLine();
                int posicao = 0;
                boolean encontrado = false;
                for(int i = 0; i < contasUsuarios.size(); i++) {
                    if(numeroConsulta.equals(contasUsuarios.get(i).getNumeroConta())) {
                        posicao = i;
                        encontrado = true;
                        break;
                    }
                }
                if(encontrado) {
                    int op;
                    do {
                        System.out.println("\n\n-----------------------------------");
                        System.out.println("|         <<-- Conta -->>         |");
                        System.out.println("-----------------------------------");
                        System.out.println("|  #- Nome do titular: " + contasUsuarios.get(posicao).getNomeTitular());
                        System.out.println("|  #- Número da conta: " + contasUsuarios.get(posicao).getNumeroConta());
                        System.out.println("-----------------------------------");
                        System.out.println("|  #- [1] Depositar");
                        System.out.println("|  #- [2] Sacar");
                        System.out.println("|  #- [3] Mostrar saldo");
                        System.out.println("|  #- [0] Sair");
                        System.out.println("-----------------------------------");
                        System.out.print("#- Escolha uma opção: ");
                        op = Integer.parseInt(ler.nextLine());

                        switch (op) {
                            case 1:
                                System.out.println("\n-------------------------");
                                System.out.println("|  <<-- Depositar -->>  |");
                                System.out.println("-------------------------");
                                System.out.print("#- Digite um valor: ");
                                double valor = Double.parseDouble(ler.nextLine());
                                contasUsuarios.get(posicao).depositar(valor);
                                System.out.println("Deposito realizado com sucesso!!");
                                break;
                            case 2:
                                System.out.println("\n---------------------");
                                System.out.println("|  <<-- Sacar -->>  |");
                                System.out.println("---------------------");
                                System.out.print("#- Digite um valor: ");
                                double val = Double.parseDouble(ler.nextLine());
                                if(val > contasUsuarios.get(posicao).getSaldo()) {
                                    System.out.println("Erro: Valor informado é maior que o saldo atual!!");
                                    break;
                                } else {
                                    contasUsuarios.get(posicao).sacar(val);
                                    System.out.println("Saque realizado com sucesso!!");
                                }
                                break;
                            case 3:
                                System.out.println("\n---------------------");
                                System.out.println("|  <<-- Saldo -->>  |");
                                System.out.println("---------------------");
                                System.out.printf("##-- %.2f\n", contasUsuarios.get(posicao).getSaldo());
                                break;
                            case 0:
                                System.out.println("Saindo...");
                                break;
                            default: System.out.println("Erro: Escolha uma opção existente!!"); break;

                        }
                    }while(op != 0);
                } else {
                    System.out.println("Conta não encontrada!!");
                }
            }
            else if(opcao == 0) {
                System.out.println("Saindo...");
                break;
            }
            else {
               System.out.println("ERRO --> Informe uma opção existente!!");
            }
        }while(true);
        ler.close();
    }
}



