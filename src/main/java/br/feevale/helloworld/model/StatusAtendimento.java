package br.feevale.helloworld.model;

public enum StatusAtendimento {
    EM_PREPARO("Em preparo"),
    PRONTO("Pronto"),
    ENTREGUE("Entregue");

    private final String descricao;

    StatusAtendimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
