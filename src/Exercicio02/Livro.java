package Exercicio02;

public class Livro {

    private final String titulo;
    private final String autor;
    private final int ano;

    Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    void exibirInfo() {
        System.out.println("\nTitulo: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano: " + getAno());
    }

}
