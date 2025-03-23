package Exercicio02;

import java.util.ArrayList;

import java.util.Scanner;

public class MainLivro {
    private static final Scanner ler = new Scanner(System.in);

    public static Livro pegarLivro() {
        System.out.print("##- Digite o titulo: ");
        String titulo = ler.nextLine();
        System.out.print("##- Digite o autor: ");
        String autor = ler.nextLine();
        System.out.print("##- Digite o ano: ");
        int ano = Integer.parseInt(ler.nextLine());

        return new Livro(titulo, autor, ano);
    }

    public static void main(String[] args) {
        int opcao;
        ArrayList<Livro> livros = new ArrayList<>();
        do {
            System.out.println("\n\n-----------------------------------------");
            System.out.println("|          <<-- BIBLIOTECA -->>          |");
            System.out.println("-----------------------------------------");
            System.out.println("|      #- [1] Inserir livro              |");
            System.out.println("|      #- [2] Buscar livro               |");
            System.out.println("|      #- [3] Mostrar livros cadastrados |");
            System.out.println("|      #- [0] Sair                       |");
            System.out.println("------------------------------------------");
            System.out.print("##- Informe uma opção: ");
            opcao = Integer.parseInt(ler.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|  <<-- Inserir livro -->>  |");
                    System.out.println("-----------------------------");
                    livros.add(pegarLivro());
                    System.out.println("Livro cadastrado com sucesso!!");
                    break;
                case 2:
                    System.out.println("\n\n-----------------------------");
                    System.out.println("|   <<-- Buscar livro -->>   |");
                    System.out.println("-----------------------------");
                    System.out.print("##- Informe o titulo: ");
                    String tituloBusca = ler.nextLine();
                    boolean encontrado = false;
                    for(Livro livro : livros) {
                        if(tituloBusca.equals(livro.getTitulo())) {
                            livro.exibirInfo();
                            encontrado = true;
                            break;
                        }
                    }
                    if(!encontrado) {
                        System.out.println("Titulo não encontrado!!");
                    }
                    break;
                case 3:
                    System.out.println("\n\n---------------------------------");
                    System.out.println("|  <<-- Livros cadastrdos -->>  |");
                    System.out.println("---------------------------------");
                    int i = 0;
                    for(Livro livro : livros) {
                        System.out.println("|  ##- Livro " + (i+=1));
                        System.out.println("|  #- Titulo: " + livro.getTitulo());
                        System.out.println("|  #- Autor: " + livro.getAutor());
                        System.out.println("|  #- Ano: " + livro.getAno());
                        System.out.println("---------------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        }while(opcao != 0);
        ler.close();
    }
}
