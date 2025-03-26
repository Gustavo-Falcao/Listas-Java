package Exercicio06;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private static final ArrayList<Contato> contatos = new ArrayList<>();
    private static final Scanner ler = new Scanner(System.in);

    public static void adicionarNovoContato() {
        System.out.print("Digite o nome: ");
        String nome = ler.nextLine();
        System.out.print("Digite o numero de telefone: ");
        String numero = ler.nextLine();

        contatos.add(new Contato(nome, numero));
        System.out.println("Contato adicionado com sucesso!!");
    }

    public static void buscarContato() {
        int posicao = 0;
        boolean encontrado = false;

        System.out.print("Informe o nome: ");
        String nomeBusca = ler.nextLine();

        for(int i = 0; i < contatos.size(); i++) {
            if(nomeBusca.equals(contatos.get(i).getNome())) {
                posicao = i;
                encontrado = true;
                break;
            }
        }

        if(encontrado) {
            System.out.println("------------------------------");
            contatos.get(posicao).exibirInfo();
            System.out.println("------------------------------");
        } else {
            System.out.println("Contato não encontrado!!");
        }

    }

    public static void exibirContatos() {
        for(Contato contato : contatos) {
            contato.exibirInfo();
            System.out.println("------------------------------------");
        }
    }

}
