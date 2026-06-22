package br.feevale.helloworld.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Atendimento implements AtualizavelStatus {

    private final int numero;
    private final ArrayList<ItemAtendimento> itens;
    private StatusAtendimento status;

    protected Atendimento(int numero, List<ItemAtendimento> itens) {
        this.numero = numero;
        this.itens = new ArrayList<>(itens);
        this.status = StatusAtendimento.EM_PREPARO;
    }

    public int getNumero() {
        return numero;
    }

    public List<ItemAtendimento> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public StatusAtendimento getStatus() {
        return status;
    }

    @Override
    public void atualizarStatus(StatusAtendimento status) {
        this.status = status;
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemAtendimento item : itens) {
            total += item.getPreco();
        }

        return total;
    }

    public abstract String getTipo();

    public String getResumo() {
        return "#" + numero + " - " + getTipo() + " | " + status + " | R$ " + String.format("%.2f", calcularTotal());
    }

    @Override
    public String toString() {
        return getResumo();
    }
}
