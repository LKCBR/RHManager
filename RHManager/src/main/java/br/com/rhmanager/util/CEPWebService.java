package br.com.rhmanager.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import org.controlsfx.dialog.ExceptionDialog;
import org.json.JSONObject;

/**
 *
 * @author lucas
 */
public class CEPWebService {

    public static void getEnderecoByCEP(String CEP, ComboBox cbEstado, TextField tfRua, TextField tfBairro, TextField tfCidade) {

        String cep = CEP.replaceAll("\\.", "").replaceAll("-", "");

        String URL = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            String line;

            while ((line = br.readLine()) != null) {
                jsonSb.append(line);
            }

            JSONObject json = new JSONObject(jsonSb.toString());

            tfBairro.setText((String) json.get("bairro"));
            tfRua.setText((String) json.get("logradouro"));
            tfCidade.setText((String) json.get("localidade"));
            cbEstado.setValue(json.get("uf"));

        } catch (Exception e) {
            AlertUtil.ExceptionDialog("ERRO", "Não foi possível buscar o endereço pelo CEP!", "", "", e);
        }

    }

}
