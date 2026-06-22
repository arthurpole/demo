package br.feevale.helloworld.model;

public class Bebida extends ItemAtendimento {

    public Bebida(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public String getCategoria() {
        return "Bebida";
    }
}
