/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author lucas
 */
public class AlertUtil {

    public static void ExceptionDialog(String windowName, String titulo_problema, String breve_descricao, String exception, Exception ex) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(windowName);
        alert.setHeaderText(titulo_problema);
        alert.setContentText(breve_descricao);

// Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("Detalhes do problema:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

// Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    public static void alertAtencao(String tituloJanela, String tituloErro, String descricaoErro) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(tituloJanela);
        alert.setHeaderText(tituloErro);
        alert.setContentText(descricaoErro);

        alert.showAndWait();
    }

}
