/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.util;

import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

/**
 *
 * @author lucas
 */
public class NotificationsUtil {

    public static void gerarNotificationSucess(String titulo, String mensagem) {
        Notifications.create().title(titulo).text(mensagem).position(Pos.TOP_LEFT).showInformation();
    }

}
