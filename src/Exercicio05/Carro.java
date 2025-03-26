package Exercicio05;

public class Carro {

    private final String marca;
    private final String modelo;
    private final int ano;
    private final String placa;
    private double velocidadeAtual;

    Carro(String marca, String modelo, int ano, String placa, double velocidadeAtual) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = velocidadeAtual;
    }

    public String getPlaca() {
        return placa;
    }

    public void exibirInfo() {
        System.out.println("|  #>> Marca: " + marca);
        System.out.println("|  #>> Modelo: " + modelo);
        System.out.println("|  #>> Ano: " + ano);
        System.out.println("|  #>> Placa: " + placa);
        System.out.printf("|  #>> Velocidade atual: %.2f km/h \n", velocidadeAtual);
        System.out.println("------------------------------------");
    }

    public void acelerar(double acelerar) {
        if(acelerar > 0) {
            velocidadeAtual += acelerar;
            System.out.println("Carro acelerou " + acelerar + " km/h");
        } else {
            System.out.println("Erro -> Valor inválido para acelerar!!");
        }
    }

    public void frear(double frear) {
        if(frear > 0 && frear <= velocidadeAtual) {
            velocidadeAtual -= frear;
            System.out.println("Carro diminui a velocidade em " + frear + " km/h");
        } else {
            System.out.println("Erro -> Valor inválido para frear");
        }
    }
}
