package Exercicio07;

public class Produto {

    private String nome;
    private String codigo;
    private int quantEstoque;
    private double preco;

    Produto(String nome, String codigo, int quantEstoque, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantEstoque = quantEstoque;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public double getPreco() {
        return  preco;
    }

    public double getPrecoTotal() {
        return preco * quantEstoque;
    }

    public void adicionarEstoque(int quant) {
        quantEstoque += quant;
        System.out.println("Produto adicionado com sucesso!!");
    }

    public void removerEstoque(int quant) {
        if(quant > 0 && quant <= quantEstoque) {
            quantEstoque -= quant;
            System.out.println("Produto removido com sucesso!!");
        } else {
            System.out.println("Erro -> Quantidade inválida para remover!!");
        }
    }

    public void exibirInfoProduto() {
        System.out.println("|  #>> Nome: " + nome);
        System.out.println("|  #>> Código: " + codigo);
        System.out.println("|  #>> Quantidade em estoque: " + quantEstoque);
        System.out.printf("|  #>> Valor total em estoque: R$ %.2f", (preco*quantEstoque));
    }

}
