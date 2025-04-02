package Exercicio08;

public class Pedido {
    private String saborPizza;
    private String endereco;
    private String idPedido;
    private Pizza pizza;


    Pedido(String saborPizza, String endereco, String idPedido, Pizza pizza, String tamanho, double valor) {
        this.saborPizza = saborPizza;
        this.endereco = endereco;
        this.idPedido = idPedido;
        this.pizza = pizza;
        this.pizza.setTamanho(tamanho);
        this.pizza.setValor(valor);
    }

    public void mostrarPedidos() {
        System.out.println("Id pedido: " + idPedido);
        System.out.println("Enderço: " + endereco);
        System.out.println("Sabor pizza: " + saborPizza);
        System.out.println("Ingredientes: " + pizza.getIngredientes());
        System.out.println("Tamanho pizza: " + pizza.getTamanho());
        System.out.println("Preço: " + pizza.getValor());
    }

    public String getIdPedido() {
        return idPedido;
    }

    public Pizza getPizza() {
        return pizza;
    }

}
