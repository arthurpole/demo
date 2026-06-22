package br.feevale.helloworld;

import br.feevale.helloworld.model.Atendimento;
import br.feevale.helloworld.model.ItemAtendimento;
import br.feevale.helloworld.model.StatusAtendimento;
import br.feevale.helloworld.service.AtendimentoService;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class EstabelecimentoController {

    @FXML
    private ListView<Atendimento> atendimentosListView;

    @FXML
    private ComboBox<StatusAtendimento> statusComboBox;

    @FXML
    private Label detalhesLabel;

    @FXML
    private Label mensagemLabel;

    @FXML
    private void initialize() {
        statusComboBox.setItems(FXCollections.observableArrayList(StatusAtendimento.values()));
        carregarAtendimentos();

        atendimentosListView.getSelectionModel().selectedItemProperty().addListener((observable, antigo, selecionado) -> {
            mostrarDetalhes(selecionado);

            if (selecionado != null) {
                statusComboBox.setValue(selecionado.getStatus());
            }
        });
    }

    @FXML
    private void atualizarStatus() {
        Atendimento atendimento = atendimentosListView.getSelectionModel().getSelectedItem();
        StatusAtendimento status = statusComboBox.getValue();

        if (atendimento == null || status == null) {
            mensagemLabel.setText("Selecione um atendimento e um status.");
            return;
        }

        AtendimentoService.getInstance().atualizarStatus(atendimento, status);
        atendimentosListView.refresh();
        mostrarDetalhes(atendimento);
        mensagemLabel.setText("Status atualizado para: " + status);
    }

    @FXML
    private void carregarAtendimentos() {
        atendimentosListView.setItems(FXCollections.observableArrayList(
                AtendimentoService.getInstance().listarAtendimentos()
        ));
        mensagemLabel.setText("Atendimentos carregados: " + atendimentosListView.getItems().size());
    }

    @FXML
    private void abrirMenu() throws IOException {
        App.setRoot("menu");
    }

    private void mostrarDetalhes(Atendimento atendimento) {
        if (atendimento == null) {
            detalhesLabel.setText("Selecione um atendimento para visualizar os itens.");
            return;
        }

        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Atendimento #").append(atendimento.getNumero()).append("\n");
        detalhes.append("Status: ").append(atendimento.getStatus()).append("\n\n");
        detalhes.append("Itens:\n");

        for (ItemAtendimento item : atendimento.getItens()) {
            detalhes.append("- ").append(item).append("\n");
        }

        detalhes.append("\nTotal: R$ ").append(String.format("%.2f", atendimento.calcularTotal()));
        detalhesLabel.setText(detalhes.toString());
    }
}
