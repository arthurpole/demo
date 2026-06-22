package br.feevale.helloworld;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void abrirTelaCliente() throws IOException {
        App.setRoot("cliente");
    }

    @FXML
    private void abrirTelaEstabelecimento() throws IOException {
        App.setRoot("estabelecimento");
    }
}
