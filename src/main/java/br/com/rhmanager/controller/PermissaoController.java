package br.com.rhmanager.controller;

import br.com.rhmanager.bean.Permissao;
import br.com.rhmanager.daoImpl.PermissaoDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author lucas
 */
public class PermissaoController {

    Runnable carregarComboBox;
    Thread threadPermissao;

    public void preencherComboBoxDB(ObservableList<String> oLPermissaos, ComboBox<String> comboBox) {

        //Configurar para carregar apenas as permissões que tem as mesmas coisas que as minhas.
        /*
         Substituir todos os caracteres de permissão do usuário se a string ficar vazia permitir que seja exibida.
         
         */
        carregarComboBox = new Runnable() {
            @Override
            public void run() {
                PermissaoDAOImpl permissaoDAOImpl = new PermissaoDAOImpl();
                List<Permissao> permissoes = new ArrayList<>();
                permissoes.addAll(permissaoDAOImpl.getPermissoes());

                for (Permissao permissao : permissoes) {
                    oLPermissaos.add(permissao.getTitulo());

                }

                comboBox.setItems(oLPermissaos);
            }
        };

        threadPermissao = new Thread(carregarComboBox);
        threadPermissao.start();
    }

    public Permissao getPermissaoByName(String permissao) {
        PermissaoDAOImpl permissaoDAOImpl = new PermissaoDAOImpl();

        return permissaoDAOImpl.getPermissaoByName(permissao);
    }

}
