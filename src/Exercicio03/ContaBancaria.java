package Exercicio03;

public class ContaBancaria {

    private final String numeroConta;
    private final String nomeTitular;
    private double saldo;

    ContaBancaria(String numeroConta, String nomeTitular, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double deposito) {
        saldo += deposito;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

}



