package br.com.rhmanager.controller;

import br.com.rhmanager.bean.AGBancaria;
import br.com.rhmanager.bean.funcionarios.Cargo;
import br.com.rhmanager.daoImpl.AGBancariaDAOImpl;
import br.com.rhmanager.util.StylesUtil;
import br.com.rhmanager.util.ValidarUtil;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author lucas
 */
public class AGBancariaController {

    Runnable carregarComboBox;
    Thread threadAGBancaria;

    public void preencherComboBox(ComboBox comboBox, ObservableList<String> oLAGBancaria) {
        carregarComboBox = new Runnable() {
            @Override
            public void run() {
                AGBancariaDAOImpl aGBancariaDAOImpl = new AGBancariaDAOImpl();
                List<AGBancaria> agencias = new ArrayList<>();
                agencias.addAll(aGBancariaDAOImpl.listarAgencia());

                for (AGBancaria aGBancaria : agencias) {
                    oLAGBancaria.add(aGBancaria.getNomeAGBancaria());

                }

                comboBox.setItems(oLAGBancaria);
            }
        };

        threadAGBancaria = new Thread(carregarComboBox);
        threadAGBancaria.start();
    }

    public AGBancaria getAgenciaBancariaByName(String nome) {
        AGBancariaDAOImpl agbdaoi = new AGBancariaDAOImpl();

        return agbdaoi.getAGBByName(nome);
    }

}
