package br.com.rhmanager.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author lucas
 */
public class ValidarUtil {

    public static String OK = "-fx-effect: dropshadow(three-pass-box, rgba(0, 255, 0,0.8), 10,0,0, 0);";
    public static String ERRO = "-fx-effect: dropshadow(three-pass-box, rgba(255, 0, 0,0.8), 10,0,0, 0);";

    public static boolean validarTextField(TextField textField, int min) {
        String valor = textField.getText().replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", "");

        if (valor.length() >= min) {
            textField.setStyle(OK);

            return true;
        } else {
            textField.setStyle(ERRO);

            return false;
        }
    }

    public static boolean validarComboBox(ComboBox comboBox) {
        if (comboBox.getSelectionModel().getSelectedIndex() > 0) {
            comboBox.setStyle(OK);
            return true;
        } else {
            comboBox.setStyle(ERRO);
            return false;
        }

    }

    public static boolean validarDataNascimento(TextField textField) {
        if (textField.getText().length() < 10) {
            return false;
        } else {

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false); // aqui o pulo do gato
            Date date = new Date();
            try {
                date = df.parse(textField.getText());
                String[] data = textField.getText().split("/");
                int ano = Integer.parseInt(data[2]);
                
                int result = DateUtil.getAnoAtual() - ano;

                if (result >= 16) {
                    textField.setStyle(OK);
                    return true;
                } else {
                    textField.setStyle(ERRO);
                    return false;
                }

            } catch (ParseException ex) {
                textField.setStyle(ERRO);
                return false;
            }

        }
    }

}
