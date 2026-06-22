package br.feevale.helloworld.model;

public class Lanche extends ItemAtendimento {

    public Lanche(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public String getCategoria() {
        return "Lanche";
    }
}
