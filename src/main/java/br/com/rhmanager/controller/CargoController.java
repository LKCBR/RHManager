/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.controller;

import br.com.rhmanager.TableView.CargoTableView;
import br.com.rhmanager.bean.funcionarios.Cargo;

import br.com.rhmanager.daoImpl.CargoDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.Duration;
import javax.management.Notification;
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

    public void preencherBomboBoxDB(ObservableList<String> oLCargos, ComboBox<String> comboBox) {

        carregarComboBox = new Runnable() {
            @Override
            public void run() {
                CargoDAOImpl cargoDAOImpl = new CargoDAOImpl();
                List<Cargo> cargos = new ArrayList<>();
                cargos.addAll(cargoDAOImpl.listarCargos());

                for (Cargo cargo : cargos) {
                    oLCargos.add(cargo.getTitulo());

                }

                comboBox.setItems(oLCargos);
            }
        };

        threadCargos = new Thread(carregarComboBox);
        threadCargos.start();
    }

    public void inserirCargo(List<Cargo> cargos, ComboBox cbCargo) {
        if (!cbCargo.getSelectionModel().isEmpty()) {

            String tituloCargo = cbCargo.getSelectionModel().getSelectedItem().toString();

            CargoDAOImpl cargoDAOImpl = new CargoDAOImpl();
            Cargo cargo = cargoDAOImpl.getCargoByName(tituloCargo);

            cargos.add(cargo);

            Notifications.create().title("Sucesso").text("Cargo de " + cargo.getTitulo() + " adicionado com sucesso!").hideAfter(Duration.seconds(20)).showInformation();
        }

    }

}
