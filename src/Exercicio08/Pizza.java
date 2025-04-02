package Exercicio08;

public class Pizza {
    String nome;
    double valor;
    String ingredientes;
    String tamanho;

    Pizza(String nome, double valor, String ingredientes, String tamanho) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
        this.tamanho = tamanho;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
