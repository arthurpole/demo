package br.feevale.helloworld.model;

public abstract class ItemAtendimento {

    private final String nome;
    private final double preco;

    protected ItemAtendimento(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public abstract String getCategoria();

    public String getDescricao() {
        return getCategoria() + " - " + nome;
    }

    @Override
    public String toString() {
        return getDescricao() + " | R$ " + String.format("%.2f", preco);
    }
}
