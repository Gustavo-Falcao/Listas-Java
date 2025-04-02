package Exercicio08;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

        Pizza calabresa = new Pizza("Calabresa", 0.0, "Queijo muçarela, linguiça calabresa fatiada, rodelas de cebola, orégano.", "");
        Pizza margherita = new Pizza("Margherita", 0.0, "Queijo muçarela, rodelas de tomate, folhas de manjericão, azeite de oliva.", "");
        Pizza portuguesa = new Pizza("Portugues", 0.0, "Queijo muçarela, presunto, ovos cozidos, cebola, azeitonas, orégano.", "");
        Pizza bacon = new Pizza("Bacon", 0.0, "Queijo muçarela, bacon em cubos fritos, orégano.", "");
        Pizza quatro_queijos = new Pizza("Quatro Queijos", 0.0, "Queijo muçarela, queijo provolone, queijo gorgonzola, queijo parmesão ralado, orégano.", "");
        Pizza pepperoni = new Pizza("Pepperoni", 0.0, "Queijo muçarela, pepperoni fatiado.", "");

        int opcao;

        do {
            System.out.println("\n\n--------------------------------------");
            System.out.println("| << -- Gerenciamento Pizzaria -->>  |");
            System.out.println("--------------------------------------");
            System.out.println("|    #- [1] Cadastrar pedido         |");
            System.out.println("|    #- [2] Cancelar pedido          |");
            System.out.println("|    #- [3] Gerar relatório          |");
            System.out.println("|    #- [4] Exibir pedidos           |");
            System.out.println("|    #- [0] Sair                     |");
            System.out.println("--------------------------------------");
            System.out.print("#- Escolha uma opção: ");
            opcao = Integer.parseInt(ler.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n\n--------------------------------");
                    System.out.println("|  <<-- Cadastrar pedido -->>  |");
                    System.out.println("--------------------------------");
                    System.out.println("|                              |");
                    System.out.println("|        <<< Pizzas >>>        |");
                    System.out.println("|       #- [1] Calabresa       |");
                    System.out.println("|       #- [2] Margherita      |");
                    System.out.println("|       #- [3] Portuguesa      |");
                    System.out.println("|       #- [4] Bacon           |");
                    System.out.println("|       #- [5] Quatro Queijos  |");
                    System.out.println("|       #- [6] Pepperoni       |");
                    System.out.println("|                              |");
                    System.out.println("--------------------------------");
                    System.out.print("#>> Esolha uma pizza: ");
                    int opPizza = Integer.parseInt(ler.nextLine());
                    Pizza pizza = new Pizza("", 0.0, "", "");
                    switch (opPizza) {
                        case 1: pizza = calabresa; break;
                        case 2: pizza = margherita; break;
                        case 3: pizza = portuguesa; break;
                        case 4: pizza = bacon; break;
                        case 5: pizza = quatro_queijos; break;
                        case 6: pizza = pepperoni; break;
                        default: System.out.println("Esolha um sabor válido!!"); break;
                    }
                    System.out.print("Informe o tamanho da pizza: ");
                    String tamanho = ler.nextLine();
                    System.out.print("Informe o preço da pizza: ");
                    double preco = Double.parseDouble(ler.nextLine());
                    System.out.print("Inoforme o id do pedido: ");
                    String idPedido = ler.nextLine();
                    System.out.print("Informe o endereço para entrega: ");
                    String endereco = ler.nextLine();

                    pedidos.add(new Pedido(pizza.getNome(), endereco, idPedido, pizza, tamanho, preco));
                break;
                case 2:
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido cadastrado ainda!!");
                    }
                    else {
                        System.out.println("\n\n-------------------------------");
                        System.out.println("|  <<-- Cancelar pedido -->>  |");
                        System.out.println("-------------------------------");
                        System.out.print("Informe o id do pedido: ");
                        String idBusca = ler.nextLine();
                        boolean removido = false;
                        for(int i = 0; i < pedidos.size(); i++) {
                            if(idBusca.equals(pedidos.get(i).getIdPedido())) {
                                pedidos.remove(i);
                                removido = true;
                                break;
                            }
                        }
                        if(removido) {
                            System.out.println("Pedido cancelado com sucesso!!");
                        }else {
                            System.out.println("Id não encontrado!!");
                        }
                    }
                break;
                case 3:
                    System.out.println("\n\n-------------------------");
                    System.out.println("|  <<-- Relatório -->>  |");
                    System.out.println("-------------------------");
                    int numTotalPedidos = 0;
                    double mediaPrecos = 0.0;
                    for(Pedido pedido : pedidos) {
                        numTotalPedidos ++;
                        mediaPrecos += pedido.getPizza().getValor();
                    }
                    mediaPrecos /= numTotalPedidos;
                    System.out.println(" #>>Numero de pedidos realizados: " + numTotalPedidos);
                    System.out.printf(" #>> Media de preços total de pedidos: %.2f \n", mediaPrecos);
                break;
                case 4:
                    System.out.println("\n\n-----------------------");
                    System.out.println("|  <<-- Pedidos -->>  |");
                    System.out.println("-----------------------");
                    int i = 1;
                    for(Pedido pedido : pedidos) {
                        System.out.println();
                        System.out.println("Pedido " + i++);
                        pedido.mostrarPedidos();
                        System.out.println();
                    }
                break;
                case 0:
                    System.out.println("Saindo...");
                break;

                default: System.out.println("Escolha uma opção válida!!"); break;
            }
        }while (opcao != 0);
    }
}
