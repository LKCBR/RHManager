/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.controller;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.daoImpl.FuncionarioDaoImpl;
import br.com.rhmanager.util.AlertUtil;
import br.com.rhmanager.util.Icons;
import br.com.rhmanager.view.controller.FormFuncionariosVController;
import br.com.rhmanager.view.controller.FuncionariosVController;
import br.com.rhmanager.vo.FuncionarioVOTable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class FuncionarioController {

    public List<Funcionario> listarFuncionarios() {
        FuncionarioDaoImpl funcionarioDaoImpl = new FuncionarioDaoImpl();

        return funcionarioDaoImpl.getAllFuncionarios();
    }

    public void editarFuncionario(TableView<FuncionarioVOTable> tvFuncionarios, Stage stage) {
        if (tvFuncionarios.getSelectionModel().getSelectedItem() != null) {

            FXMLLoader loader = new FXMLLoader(FormFuncionariosVController.class.getResource("/fxml/FormFuncionarios.fxml"));

            FuncionarioDaoImpl funcionarioDaoImpl = new FuncionarioDaoImpl();

            Funcionario funcionario = funcionarioDaoImpl.getFuncionarioByCpf(tvFuncionarios.getSelectionModel().getSelectedItem().getCpf());

            Parent root;
            try {
                root = (Parent) loader.load();
                FormFuncionariosVController controller = loader.getController();
                controller.setFuncionario(funcionario);

                Scene scene = new Scene(root, 850, 600);

                stage.setTitle("aasdadsd");
                stage.setScene(scene);

                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            AlertUtil.alertAtencao("Atenção", "Nenhum Funcionário Selecionado!", "Selecione o Funcionário que deseja editar na tabela.");
        }
    }

}
