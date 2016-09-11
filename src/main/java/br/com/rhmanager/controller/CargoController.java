package br.com.rhmanager.controller;

import br.com.rhmanager.TableView.CargoTableView;
import br.com.rhmanager.bean.funcionarios.Cargo;

import br.com.rhmanager.daoImpl.CargoDAOImpl;
import br.com.rhmanager.util.AlertUtil;
import br.com.rhmanager.vo.CargoVOTable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author lucas
 */
public class CargoController {

    Thread threadCargos;
    Runnable carregarComboBox;

    Runnable carregarTable;

    public void preencherTable(CargoTableView cargoTableView, List<Cargo> cargos) {
        carregarTable = new Runnable() {
            @Override
            public void run() {
                cargoTableView.addAllDados(cargos);
                cargoTableView.start();
            }
        };

        threadCargos = new Thread(carregarTable);
        threadCargos.start();
    }

    public void preencherComboBoxDB(ObservableList<String> oLCargos, ComboBox<String> comboBox) {

        carregarComboBox = new Runnable() {
            @Override
            public void run() {
                CargoDAOImpl cargoDAOImpl = new CargoDAOImpl();
                List<Cargo> cargos = new ArrayList<>();
                cargos.addAll(cargoDAOImpl.listarCargos());

                for (Cargo cargo : cargos) {
                    oLCargos.add(cargo.getTitulo());

                }

                System.out.println("FUNCIONANDO" + oLCargos.get(0));

                comboBox.setItems(oLCargos);
            }
        };

        threadCargos = new Thread(carregarComboBox);
        threadCargos.start();
    }

    public void inserirCargo(List<Cargo> cargos, ComboBox cbCargo) {
        if (!cbCargo.getSelectionModel().isEmpty()) {
            String tituloCargo = cbCargo.getSelectionModel().getSelectedItem().toString();

            boolean verify = true;
            for (Cargo cargo : cargos) {
                if (cargo.getTitulo().equals(tituloCargo)) {
                    verify = false;
                    break;
                } else {
                    verify = true;
                }
            }

            if (verify) {
                CargoDAOImpl cargoDAOImpl = new CargoDAOImpl();
                Cargo cargo = cargoDAOImpl.getCargoByName(tituloCargo);

                cargos.add(cargo);

                Notifications.create().title("Sucesso").text("Cargo de " + cargo.getTitulo() + " adicionado com sucesso!").hideAfter(Duration.seconds(20)).showInformation();
                cbCargo.getSelectionModel().clearSelection();
            } else {
                AlertUtil.erro("Erro", "Este cargo já foi adicionado a este Funcionário!", "");
            }
        } else {
            AlertUtil.alertAtencao("Atenção", "Selecione o cargo que deseja inserir.", "Caso não esteja presente no componente de seleção adicione um cargo novo Pressionando o Botão Novo Cargo. ");
        }

    }

    public void removerCargo(TableView<CargoVOTable> tvCargo, List<Cargo> cargos) {
        if (tvCargo.getSelectionModel().getSelectedItem() != null) {
            CargoVOTable cargoVOTable = tvCargo.getSelectionModel().getSelectedItem();

            for (Cargo cargo : cargos) {
                if (cargo.getIdCargos().toString().equals(cargoVOTable.getId())) {
                    cargos.remove(cargo);

                    Notifications.create().title("Sucesso").text("Cargo removido com sucesso!").hideAfter(Duration.seconds(20)).showInformation();

                    break;
                }
            }

        }
    }

    public Cargo getCargoByName(String nome) {
        CargoDAOImpl cargoDAOImpl = new CargoDAOImpl();

        return cargoDAOImpl.getCargoByName(nome);
    }

}
