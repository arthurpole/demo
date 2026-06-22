package br.feevale.helloworld.model;

import java.util.List;

public class PedidoRestaurante extends Atendimento {

    public PedidoRestaurante(int numero, List<ItemAtendimento> itens) {
        super(numero, itens);
    }

    @Override
    public String getTipo() {
        return "Pedido restaurante";
    }
}
