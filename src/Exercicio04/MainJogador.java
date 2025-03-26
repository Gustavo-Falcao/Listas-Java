package Exercicio04;

import java.util.Scanner;
import java.util.ArrayList;

public class MainJogador {

    private static final Scanner ler = new Scanner(System.in);

    public static Jogador pegarPerfil() {
        System.out.print("Digite o nome do jogador: ");
        String nome = ler.nextLine();
        System.out.print("Informe o id do perfil (será usado para acessar o perfil): ");
        String idPerfil = ler.nextLine();
        System.out.print("Digite a pontuação: ");
        int pontuacao = Integer.parseInt(ler.nextLine());
        System.out.print("Digite o nivel: ");
        int nivel = Integer.parseInt(ler.nextLine());

        return new Jogador(nome, idPerfil, pontuacao, nivel);
    }

    public static int encontraPerfil(String perfil, ArrayList<Jogador> jogadores) {
        int posicao = 0;
        boolean encontrado = false;
        for(int i = 0; i < jogadores.size(); i++) {
            if(perfil.equals(jogadores.get(i).getIdPerfil())) {
                posicao = i;
                encontrado = true;
                break;
            }
        }
        if(encontrado) {
            return posicao;
        } else {
            return -1;
        }
    }

    public static int pegarAtualizacao(String tipo, String frase) {
        System.out.println("\n-----------------------------------");
        System.out.println("  <<-- Atualizar " + tipo + " -->>");
        System.out.println("-----------------------------------");
        System.out.print("#- Digite " + frase + tipo + ": ");
        return Integer.parseInt(ler.nextLine());
    }

    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n\n-----------------------------------------");
            System.out.println("|  <<-- Gerenciamento de jogadores -->> |");
            System.out.println("-----------------------------------------");
            System.out.println("|     #- [1] Criar perfil               |");
            System.out.println("|     #- [2] Entrar em um perfil        |");
            System.out.println("|     #- [3] Exibir perfis criados      |");
            System.out.println("|     #- [0] Sair                       |");
            System.out.println("-----------------------------------------");
            System.out.print("#- Escolha uma opção: ");
            opcao = Integer.parseInt(ler.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n----------------------------");
                    System.out.println("|  <<-- Criar perfil -->>  |");
                    System.out.println("----------------------------");
                    jogadores.add(pegarPerfil());
                    System.out.println("Perfil criado com sucesso!!");
                    break;
                case 2:
                    System.out.println("\n--------------------------------");
                    System.out.println("|  <<-- Entrar no perfil -->>  |");
                    System.out.println("--------------------------------");
                    System.out.print("Informe o id do perfil: ");
                    int posicao = encontraPerfil(ler.nextLine(), jogadores);

                    if(posicao != -1) {
                        do {
                            System.out.println("\n\n-----------------------------------");
                            System.out.println("        <<-- " + jogadores.get(posicao).getNome() + " -->>");
                            System.out.println("-----------------------------------");
                            System.out.println("|   #- [1] Atualizar pontuação    |");
                            System.out.println("|   #- [2] Atualizar nivel        |");
                            System.out.println("|   #- [3] Exibir informações     |");
                            System.out.println("|   #- [0] Sair                   |");
                            System.out.println("-----------------------------------");
                            System.out.print("##- Escolha uma opção: ");
                            int op = Integer.parseInt(ler.nextLine());

                            if(op == 1) {
                                jogadores.get(posicao).setPontuacao(pegarAtualizacao("pontuação", "sua nova "));
                                System.out.println("Pontuação atualizada com sucesso!!");
                            }
                            else if(op == 2) {
                                jogadores.get(posicao).setNivel(pegarAtualizacao("nivel", "seu novo "));
                                System.out.println("Nivel atualizado com sucesso!!");
                            }
                            else if(op == 3) {
                                System.out.println("\n--------------------------------");
                                System.out.println("|  <<-- Dados do jogador -->>  |");
                                System.out.println("--------------------------------");
                                jogadores.get(posicao).exibirInfo();
                                System.out.println("--------------------------------");
                            }
                            else if(op == 0) {
                                System.out.println("Voltando ao menu principal...");
                                break;
                            }
                            else {
                                System.out.println("ERRO ->> Informe uma opção válida!!");
                            }
                        }while(true);
                    }
                    else {
                        System.out.println("Perfil não encontrado!!");
                    }
                    break;
                case 3:
                    System.out.println("\n-------------------------");
                    System.out.println("|  <<-- Jogadores -->>  |");
                    System.out.println("-------------------------");
                    for(Jogador jogador: jogadores) {
                        jogador.exibirJogadores();
                        System.out.println("-------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default: System.out.println("ERRO ->> Escolha uma opção válida"); break;

            }
        }while(opcao != 0);


        ler.close();
    }
}
