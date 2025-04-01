package Exercicio07;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final Scanner ler = new Scanner(System.in);
    private static final HashMap<String, Produto> produtos = new HashMap<String, Produto>();

    public static void cadastrarProduto() {
        System.out.print("Digite o nome: ");
        String nome = ler.nextLine();
        System.out.print("Digite o código: ");
        String codigo = ler.nextLine();
        while(produtos.containsKey(codigo)){
                System.out.println("Código já existe!!");
                System.out.print("Digite outro: ");
                codigo = ler.nextLine();
            }
        System.out.print("Digite a quantidade em estoque: ");
        int quant = Integer.parseInt(ler.nextLine());
        System.out.print("Digite o preço: ");
        double preco = Double.parseDouble(ler.nextLine());

        produtos.put(codigo,new Produto(nome, codigo, quant, preco));

        System.out.println("Produto cadastrado com sucesso!!");
    }

    public static String pegarCodigBusca() {
        System.out.print("#- Informe o codigo do produto: ");
        return ler.nextLine();
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
                    cadastrarProduto();
                    break;
                case 2:
                    String codigoBusca = pegarCodigBusca();

                    if(produtos.containsKey(codigoBusca)) {
                        int opAtualizar;
                        do {
                            System.out.println("\n\n---------------------------------");
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
                                    System.out.println("\n\n-------------------------");
                                    System.out.println("|  <<-- Adicionar -->>  |");
                                    System.out.println("-------------------------");
                                    produtos.get(codigoBusca).adicionarEstoque(pegarAtualizacao());
                                    break;
                                case 2:
                                    System.out.println("\n\n-----------------------");
                                    System.out.println("|  <<-- Remover -->>  |");
                                    System.out.println("-----------------------");
                                    System.out.println("##-> Quantidade atual em estoque: " + produtos.get(codigoBusca).getQuantEstoque());
                                    produtos.get(codigoBusca).removerEstoque(pegarAtualizacao());
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
                    System.out.println("\n\n--------------------------");
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
                        double precoTotal = 0.00;
                        System.out.println("\n\n      <<-- Relatório geral -->>     ");
                        System.out.println("-------------------------------------");
                        System.out.println("|   -->> Produtos disponíveis       |");
                        System.out.println("-------------------------------------");
                        for(String codigo : produtos.keySet()) {
                            if(produtos.get(codigo).getQuantEstoque() > 0) {
                                System.out.println("| #>> " + produtos.get(codigo).getNome());
                                quantidadeProdutos += produtos.get(codigo).getQuantEstoque();
                                precoTotal += produtos.get(codigo).getPrecoTotal();
                            }
                        }
                        System.out.println("-------------------------------------");
                        System.out.println("|   -->> Quantidade em estoque      |");
                        System.out.println("|  #>> " + quantidadeProdutos);
                        System.out.println("-------------------------------------");
                        System.out.println("|   -->> Valor total em estoque     |");
                        System.out.printf("|  #>> R$ %.2f \n", precoTotal);
                        System.out.println("-------------------------------------");
                    }
                    else if(opRelatorio == 2) {
                        String codigoInformado = pegarCodigBusca();
                        if(produtos.containsKey(codigoInformado)) {
                            System.out.println("\n\n---------------------------------");
                            System.out.println("|  <<-- Relatório produto -->>  |");
                            System.out.println("---------------------------------");
                            produtos.get(codigoInformado).exibirInfoProduto();
                            System.out.println("---------------------------------");
                        }
                        else {
                            System.out.println("Código não encontrado!!");
                        }
                    }
                    else if(opRelatorio == 0) {
                        System.out.println("Saindo...");
                    }
                    else {
                        System.out.println("Escolha uma opção válida!!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default: System.out.println("Erro -> Escolha uma opção válida"); break;
            }
        }while(opcao != 0);

        ler.close();
    }
}
