package Exercicio04;

public class Jogador {

    private final String nome;
    private final String idPerfil;
    private int pontuacao;
    private int nivel;

    Jogador(String nome, String idPerfil, int pontuacao, int nivel) {
        this.nome = nome;
        this.idPerfil = idPerfil;
        this.pontuacao = pontuacao;
        this.nivel = nivel;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNivel(int novoNivel) {
        this.nivel = novoNivel;
    }

    public void setPontuacao(int novoPontuacao) {
        this.pontuacao = novoPontuacao;
    }

    public void exibirInfo() {
        System.out.println("| #>> Nome: " + nome);
        System.out.println("| #>> Id: " + idPerfil);
        System.out.println("| #>> Pontuação: " + pontuacao);
        System.out.println("| #>> Nivel: " + nivel);

    }

    public void exibirJogadores() {
        System.out.println("| #>> Nome: " + nome);
        System.out.println("| #>> Pontuação: " + pontuacao);
        System.out.println("| #>> Nivel: " + nivel);

    }
}
