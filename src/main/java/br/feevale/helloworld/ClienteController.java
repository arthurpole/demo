package br.feevale.helloworld;

import br.feevale.helloworld.model.Atendimento;
import br.feevale.helloworld.model.Bebida;
import br.feevale.helloworld.model.ItemAtendimento;
import br.feevale.helloworld.model.Lanche;
import br.feevale.helloworld.service.AtendimentoService;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ClienteController {

    @FXML
    private ComboBox<ItemAtendimento> opcoesComboBox;

    @FXML
    private ListView<ItemAtendimento> itensListView;

    @FXML
    private Label resumoLabel;

    @FXML
    private Label mensagemLabel;

    @FXML
    private void initialize() {
        opcoesComboBox.setItems(FXCollections.observableArrayList(
                new Lanche("Xis salada", 24.90),
                new Lanche("Cachorro quente", 16.50),
                new Lanche("Pastel", 12.00),
                new Bebida("Refrigerante", 6.00),
                new Bebida("Suco natural", 8.50)
        ));
        opcoesComboBox.getSelectionModel().selectFirst();
        atualizarResumo();
    }

    @FXML
    private void adicionarItem() {
        ItemAtendimento item = opcoesComboBox.getValue();

        if (item != null) {
            itensListView.getItems().add(item);
            mensagemLabel.setText("Item adicionado ao pedido.");
            atualizarResumo();
        }
    }

    @FXML
    private void removerItem() {
        ItemAtendimento item = itensListView.getSelectionModel().getSelectedItem();

        if (item == null) {
            mensagemLabel.setText("Selecione um item para remover.");
            return;
        }

        itensListView.getItems().remove(item);
        mensagemLabel.setText("Item removido do pedido.");
        atualizarResumo();
    }

    @FXML
    private void cancelarPedido() {
        itensListView.getItems().clear();
        mensagemLabel.setText("Pedido cancelado.");
        atualizarResumo();
    }

    @FXML
    private void concluirPedido() {
        if (itensListView.getItems().isEmpty()) {
            mensagemLabel.setText("Adicione pelo menos um item antes de concluir.");
            return;
        }

        Atendimento atendimento = AtendimentoService.getInstance().registrarPedido(itensListView.getItems());
        itensListView.getItems().clear();
        mensagemLabel.setText("Pedido confirmado. Atendimento gerado: #" + atendimento.getNumero());
        atualizarResumo();
    }

    @FXML
    private void abrirMenu() throws IOException {
        App.setRoot("menu");
    }

    private void atualizarResumo() {
        double total = 0;

        for (ItemAtendimento item : itensListView.getItems()) {
            total += item.getPreco();
        }

        resumoLabel.setText("Itens: " + itensListView.getItems().size() + " | Total: R$ " + String.format("%.2f", total));
    }
}
