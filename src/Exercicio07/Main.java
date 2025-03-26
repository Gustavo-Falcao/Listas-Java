package Exercicio07;

import java.util.ArrayList;
import java.util.Scanner;

// registrar informações dos produtos disponiveis
// controlar as quantidades em estoque
// funcionarios devem ser capazes de:
    // adicionar novos produtos ao estoque
    // atualizar as informações de um produto existente
    // remover produtos do estoque quando necessário
// o sistema deve ser capaz de gerar relatorios sobre o estoque atual incluindo:
    // produtos disponiveis
    // quantidade em estoque
    // valor total em estoque

public class Main {

    private static final Scanner ler = new Scanner(System.in);
    private static final ArrayList<Produto> produtos = new ArrayList<>();

    public static void pegarProduto() {
        System.out.print("Digite o nome: ");
        String nome = ler.nextLine();
        System.out.print("Digite o código: ");
        String codigo = ler.nextLine();
        if(buscarCodigo(codigo) != -1) {
            do {
                System.out.println("Erro -> Esse código já existe!!");
                System.out.print("Informe um novo código: ");
                codigo = ler.nextLine();
            }while(buscarCodigo(codigo) != -1);
        }
        System.out.print("Digite a quantidade em estoque: ");
        int quant = Integer.parseInt(ler.nextLine());
        System.out.print("Digite o preço: ");
        double preco = Double.parseDouble(ler.nextLine());

        produtos.add(new Produto(nome, codigo, quant, preco));

        System.out.println("Produto cadastrado com sucesso!!");
    }

    public static int buscarCodigo(String codigoBusca) {
        int posicao = 0;
        boolean encontrado = false;

        for(int i = 0; i < produtos.size(); i++) {
            if(codigoBusca.equals(produtos.get(i).getCodigo())) {
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

    public static int pegarAtualizacao() {
        System.out.print("Digite a quantidade: ");
        return Integer.parseInt(ler.nextLine());
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n\n-----------------------------------------");
            System.out.println("|   <<-- Gerenciamento de estoque -->>  |");
            System.out.println("-----------------------------------------");
            System.out.println("|      #- [1] Cadastrar produto         |");
            System.out.println("|      #- [2] Atualizar produto         |");
            System.out.println("|      #- [3] Relatórios                |");
            System.out.println("|      #- [0] Sair                      |");
            System.out.println("-----------------------------------------");
            System.out.print("#- Escolha uma opção: ");
            opcao = Integer.parseInt(ler.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n---------------------------------");
                    System.out.println("|  <<-- Cadastrar produto -->>  |");
                    System.out.println("---------------------------------");
                    pegarProduto();
                    break;
                case 2:
                    System.out.print("#- Informe o codigo do produto: ");
                    int posicao = buscarCodigo(ler.nextLine());

                    if(posicao != -1) {
                        int opAtualizar;
                        do {
                            System.out.println("---------------------------------");
                            System.out.println("|  <<-- Atualizar produto -->>  |");
                            System.out.println("---------------------------------");
                            System.out.println("|     #- [1] Adicionar          |");
                            System.out.println("|     #- [2] Remover            |");
                            System.out.println("|     #- [0] Sair               |");
                            System.out.println("---------------------------------");
                            System.out.print("#- Escolha uma opção: ");
                            opAtualizar = Integer.parseInt(ler.nextLine());

                            switch (opAtualizar) {
                                case 1:
                                    System.out.println("-------------------------");
                                    System.out.println("|  <<-- Adicionar -->>  |");
                                    System.out.println("-------------------------");
                                    produtos.get(posicao).adicionarEstoque(pegarAtualizacao());
                                    break;
                                case 2:
                                    System.out.println("-----------------------");
                                    System.out.println("|  <<-- Remover -->>  |");
                                    System.out.println("-----------------------");
                                    produtos.get(posicao).removerEstoque(pegarAtualizacao());
                                    break;
                                case 0:
                                    System.out.println("Saindo...");
                                    break;
                                default: System.out.println("Erro -> Escolha uma opção válida!!"); break;
                            }
                        }while(opAtualizar != 0);

                    } else {
                        System.out.println("Erro -> Código não encontrado!!");
                    }
                    break;
                case 3:
                    int opRelatorio;
                    System.out.println("--------------------------");
                    System.out.println("|  <<-- Relatórios -->>  |");
                    System.out.println("--------------------------");
                    System.out.println("|   #- [1] Geral         |");
                    System.out.println("|   #- [2] Produto       |");
                    System.out.println("|   #- [0] Sair          |");
                    System.out.println("--------------------------");
                    System.out.print("#- Escolha uma opção: ");
                    opRelatorio = Integer.parseInt(ler.nextLine());

                    if(opRelatorio == 1) {
                        int quantidadeProdutos = 0;
                        double precoTotal = 0.0;
                        System.out.println("-------------------------------------");
                        System.out.println("|     <<-- Relatório geral -->>     |");
                        System.out.println("-------------------------------------");
                        System.out.println("|   -->> Produtos disponíveis       |");
                        System.out.println("-------------------------------------");
                        for(Produto produto : produtos) {
                            System.out.println("| #>> " + produto.getNome());
                            quantidadeProdutos += produto.getQuantEstoque();
                            precoTotal += produto.getPreco();
                        }
                        System.out.println("-------------------------------------");
                        System.out.println("|   -->> Quantidade em estoque      |");
                        System.out.println("#>> " + quantidadeProdutos);
                        System.out.println("-------------------------------------");
                        System.out.println("|   -->> Valor total em estoque     |");
                        System.out.println("#>> " + precoTotal);
                        System.out.println("-------------------------------------");
                    }

                case 0:
                    System.out.println("Saindo...");
                    break;
                default: System.out.println("Erro -> Escolha uma opção válida"); break;

            }
        }while(opcao != 0);

        ler.close();
    }
}
