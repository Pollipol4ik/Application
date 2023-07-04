module com.example.fubric_kr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.fasterxml.jackson.databind;

    opens com.example.fubric_kr to javafx.fxml;
    exports com.example.fubric_kr;
}