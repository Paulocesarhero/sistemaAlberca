package uv.daduv.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExceptionHandler {
    public static void handleException(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Se ha producido una excepción");
        alert.setContentText(e.getMessage());

        // Personalizar la apariencia del diálogo de error
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #f2dede;"); // Cambia el color de fondo
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.initStyle(StageStyle.UNDECORATED); // Quita los bordes de la ventana
        stage.initModality(Modality.APPLICATION_MODAL);

        // Agregar detalles de la excepción en el contenido del diálogo
        Label label = new Label("Detalles de la excepción:");
        Label exceptionLabel = new Label(e.toString());
        GridPane gridPane = new GridPane();
        gridPane.add(label, 0, 0);
        gridPane.add(exceptionLabel, 1, 0);
        dialogPane.setExpandableContent(gridPane);

        alert.showAndWait();
    }
}
