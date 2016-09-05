package br.com.rhmanager.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author lucas
 */
public class ValidarUtil {

    public static String OK = "-fx-effect: dropshadow(three-pass-box, rgba(0, 255, 0,0.8), 5,0,0, 0);";
    public static String ERRO = "-fx-effect: dropshadow(three-pass-box, rgba(255, 0, 0,0.8), 5,0,0, 0);";
    public static String ALERT = "-fx-effect: dropshadow(three-pass-box, rgba(255, 165, 0,0.8), 5,0,0, 0);";

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
        if (comboBox.getSelectionModel().getSelectedItem() != null) {
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

    public static boolean validarTableView(TableView tableView) {
        if (tableView.getItems().size() > 0) {
            tableView.setStyle(OK);
            return true;
        } else {
            tableView.setStyle(ERRO);
            return false;
        }
    }

    public static boolean validarEmail(TextField textField) {
        String text = textField.getText();
        boolean result = text.matches(RegexUtil.EMAIL);

        if (result) {
            textField.setStyle(OK);
            return true;
        } else {
            textField.setStyle(ERRO);
            return false;
        }
    }

    public static boolean validarContaBancaria(TextField tfConta, TextField tfAgencia, ComboBox cbAgenciaBancaria) {
        if (tfConta.getText().length() > 0 || tfAgencia.getText().length() > 0 || cbAgenciaBancaria.getSelectionModel().getSelectedItem() != null) {
            boolean agencia = true,
                    conta = true,
                    agenciabancaria = true;

            if (tfAgencia.getText().length() == 0) {
                tfAgencia.setStyle(ERRO);
                agencia = false;
            } else {
                tfAgencia.setStyle(OK);
                conta = true;
            }

            if (tfConta.getText().length() == 0) {
                tfConta.setStyle(ERRO);
                conta = false;

            } else {
                tfConta.setStyle(OK);
                conta = false;
            }

            if (cbAgenciaBancaria.getSelectionModel().getSelectedItem() == null) {
                cbAgenciaBancaria.setStyle(ERRO);
                agenciabancaria = false;
            } else {
                cbAgenciaBancaria.setStyle(OK);
                agenciabancaria = true;
            }

            return agencia && conta && agenciabancaria;

        } else {
            tfConta.setStyle(ALERT);
            tfAgencia.setStyle(ALERT);
            cbAgenciaBancaria.setStyle(ALERT);
            return true;
        }
    }

    public static boolean acessoEmailSenha(TextField tfEmail, PasswordField tfSenha, ToggleButton tbAtivarAcesso) {
        if (tbAtivarAcesso.isSelected() || tfSenha.getText().length() > 0 || tfEmail.getText().length() > 0) {
            boolean email, senha;
            if (!tbAtivarAcesso.isSelected()) {
                tbAtivarAcesso.setStyle(ALERT);

            } else {
                tbAtivarAcesso.setStyle(OK);
            }

            if (tfEmail.getText().length() == 0 || !validarEmail(tfEmail)) {
                tfEmail.setStyle(ERRO);
                email = false;
            } else {
                tfEmail.setStyle(OK);
                email = true;
            }

            if (tfSenha.getText().length() == 0) {
                tfSenha.setStyle(ERRO);
                senha = false;
            } else {
                tfSenha.setStyle(OK);
                senha = true;
            }

            return email && senha;
        } else {
            tfEmail.setStyle(ALERT);
            tfSenha.setStyle(ALERT);
            tbAtivarAcesso.setStyle(ALERT);
            return true;
        }
    }

}
