package Exercicio05;

import java.util.Scanner;
import java.util.ArrayList;

public class MainCarro {

    private static final Scanner ler = new Scanner(System.in);

    public static Carro pegarCarro() {
        System.out.print("Digite a marca: ");
        String marca = ler.nextLine();
        System.out.print("Digite o modelo: ");
        String modelo = ler.nextLine();
        System.out.print("Digite o ano: ");
        int ano = Integer.parseInt(ler.nextLine());
        System.out.print("Digite a placa: ");
        String placa = ler.nextLine();
        System.out.print("Digite a velocidade atual: ");
        double velocidade = Double.parseDouble(ler.nextLine());

        return new Carro(marca, modelo, ano, placa, velocidade);
    }

    public static int buscarPlaca(String placa, ArrayList<Carro> carros) {
        boolean encontrado = false;
        int posicao = 0;
        for(int i = 0; i < carros.size(); i++) {
            if(placa.equals(carros.get(i).getPlaca())) {
                encontrado = true;
                posicao = i;
                break;
            }
        }
        if(encontrado) {
            return posicao;
        } else {
            return -1;
        }
    }

    public static double pegarMovimentoCarro(String tipo) {
        System.out.print("Informe o valor para " + tipo + ": ");
        return Double.parseDouble(ler.nextLine());
    }

    public static void main(String[] args) {
        ArrayList<Carro> carros = new ArrayList<>();
        int opcao;
        do {
            System.out.println("\n\n-------------------------------------------");
            System.out.println("|    <<-- Gerenciamento de carros -->>    |");
            System.out.println("-------------------------------------------");
            System.out.println("|     #- [1] Cadastrar carro              |");
            System.out.println("|     #- [2] Acessar carro                |");
            System.out.println("|     #- [3] Mostrar carros cadastrados   |");
            System.out.println("|     #- [0] Sair                         |");
            System.out.println("-------------------------------------------");
            System.out.print("#- Escolha uma opção: ");
            opcao = Integer.parseInt(ler.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n\n-------------------------------");
                    System.out.println("|  <<-- Cadastrar carro -->>  |");
                    System.out.println("-------------------------------");
                    carros.add(pegarCarro());
                    System.out.println("Carro cadastrado com sucesso!!");
                    break;
                case 2:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|  <<-- Acessar carro -->>  |");
                    System.out.println("-----------------------------");
                    System.out.print("#- Digite a placa do carro: ");
                    int posicao = buscarPlaca(ler.nextLine(), carros);
                    if(posicao != -1) {
                        int op;
                        do {
                            System.out.println("\n\n------------------------------------");
                            System.out.println("|         <<-- Carro  -->>         |");
                            System.out.println("------------------------------------");
                            carros.get(posicao).exibirInfo();
                            System.out.println("|  #- [1] Acelerar");
                            System.out.println("|  #- [2] Frear");
                            System.out.println("|  #- [0] Sair");
                            System.out.println("------------------------------------");
                            System.out.print("#- Escolha uma opção: ");
                            op = Integer.parseInt(ler.nextLine());
                            if(op == 1) {
                                carros.get(posicao).acelerar(pegarMovimentoCarro("acelerar"));
                            }
                            else if(op == 2) {
                                carros.get(posicao).frear(pegarMovimentoCarro("frear"));
                            }
                            else if(op == 0) {
                                System.out.println("Saindo...");
                                break;
                            }
                            else {
                                System.out.println("Erro -> Escolha uma opção válida!!");
                            }
                        }while(true);
                    }
                    else {
                        System.out.println("Carro não encontrado!!");
                    }
                    break;
                case 3:
                    System.out.println("\n\n----------------------------------");
                    System.out.println("|  <<-- Carros cadastrados -->>  |");
                    System.out.println("----------------------------------");
                    for(Carro carro : carros) {
                        carro.exibirInfo();
                    }
                    break;
                case 0:
                    System.out.println("Saindo..."); break;
            }
        }while(opcao != 0);

        ler.close();

    }
}
