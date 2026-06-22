package br.feevale.helloworld.model;

public interface AtualizavelStatus {

    StatusAtendimento getStatus();

    void atualizarStatus(StatusAtendimento status);
}
