module br.feevale.helloworld {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.feevale.helloworld to javafx.fxml;
    exports br.feevale.helloworld;
    exports br.feevale.helloworld.model;
}
