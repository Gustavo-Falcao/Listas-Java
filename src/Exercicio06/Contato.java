package Exercicio06;

public class Contato {

    private final String nome;
    private String telefone;

    Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void exibirInfo() {
        System.out.println("|  #>> Nome: " + nome);
        System.out.println("|  #>> Telefone: " + telefone);
    }
}
