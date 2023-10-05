package uv.daduv.alberca;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import uv.daduv.domain.Deportista;
import uv.daduv.utils.ExcelWriter;
import uv.daduv.utils.ExceptionHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import static uv.daduv.utils.ExcelWriter.guardarDeportistaEnExcel;

public class HelloController implements Initializable {
    public TextField tfCódigo;
    public TextField tfNombre;

    public TextField tfTelefono ;
    public TextField tfEdad;
    public TextField tfNoDeCredencial;
    public TextField tfCorreo;
    public ChoiceBox<String> cbTipo;
    public ChoiceBox<String> cbModalidad;

    public ChoiceBox<String> cbHorario;
    public ChoiceBox<String> cbSexo;

    private Deportista deportista = new Deportista("dsads", "", "", "", 0, "", "", "", "", "");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listeners();
        fillComboBox();
        validateInputs();
    }

    public void clicGuardar(ActionEvent actionEvent) {
        try {
            guardarDeportistaEnExcel(deportista, "bdDeportistas.xlsx");
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void fillComboBox(){
        cbTipo.getItems().addAll("Estudiante UV","Derechohabiente","Trabajador UV", "Condonado",
                "Público en general", "Egresado UV", "Jubilado");
        cbTipo.setValue("Estudiante UV");
        cbModalidad.getItems().addAll("Libre", "Clase A 16 años", "Clase B 16 años", "Clase A 8 años",
                "Clase B 8 años", "Clase trabajores", "Equipo natación", "Equipo triatlon");
        cbModalidad.setValue("Libre");
        cbHorario.getItems().addAll("6:00 6:50", "7:00 7:50", "8:00 8:50", "12:00 12:50", "13:00 13:50",
                "14:00 14:50", "15:00 15:50", "16:00 16:50 17:00 17:50", "18:00 18:50", "19:00 19:50");
        cbHorario.setValue("6:00 6:50");
        cbSexo.getItems().addAll("Masculino", "Femenino");
        cbSexo.setValue("Masculino");
    }

    public void validateInputs(){
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String input = change.getText();
            if (Pattern.matches("\\d*", input)) {
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        tfEdad.setTextFormatter(textFormatter);
    }

    public void listeners(){
        tfCódigo.textProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setId(newValue);
        });

        tfNombre.textProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setNombre(newValue);
        });

        tfTelefono.textProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setTelefono(newValue);
        });

        tfEdad.textProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setEdad(Integer.parseInt(newValue));
        });

        tfNoDeCredencial.textProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setNoCredencial(newValue);
        });

        tfCorreo.textProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setCorreo(newValue);
        });

        cbTipo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setTipo(newValue);
        });

        cbModalidad.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setModalidad(newValue);
        });

        cbHorario.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setHorario(newValue);
        });

        cbSexo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deportista.setSexo(newValue);
        });
    }
}