package br.feevale.helloworld.service;

import br.feevale.helloworld.model.Atendimento;
import br.feevale.helloworld.model.ItemAtendimento;
import br.feevale.helloworld.model.PedidoRestaurante;
import br.feevale.helloworld.model.StatusAtendimento;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoService {

    private static final AtendimentoService INSTANCE = new AtendimentoService();

    private final ArrayList<Atendimento> atendimentosRealizados = new ArrayList<>();
    private int proximoNumero = 1;

    private AtendimentoService() {
    }

    public static AtendimentoService getInstance() {
        return INSTANCE;
    }

    public Atendimento registrarPedido(List<ItemAtendimento> itens) {
        Atendimento atendimento = new PedidoRestaurante(proximoNumero, itens);
        proximoNumero++;
        atendimentosRealizados.add(atendimento);
        return atendimento;
    }

    public ArrayList<Atendimento> listarAtendimentos() {
        return new ArrayList<>(atendimentosRealizados);
    }

    public void atualizarStatus(Atendimento atendimento, StatusAtendimento status) {
        atendimento.atualizarStatus(status);
    }
}
