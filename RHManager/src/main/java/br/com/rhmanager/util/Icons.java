/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.util;

import javafx.scene.image.ImageView;

/**
 *
 * @author lucas
 */
public class Icons {

    public static String ICON_EXCLUIR = "/images/icons/cancel.png";
    public static String ICON_CAPELO = "/images/icons/capelo.png";
    public static String ICON_REGISTER = "/images/icons/register.png";
    public static String ICON_DELETE = "/images/icons/delete.png";
    public static String ICON_INFO = "/images/icons/info.png";
    public static String ICON_ADD = "/images/icons/add.png";
    public static String ICON_EDIT = "/images/icons/Edit.png";
    public static String ICON_MENU = "/images/icons/menu.png";
    public static String ICON_PRINCIPAL = "/images/icons/principal.png";

    public static ImageView getIcon(String caminho, double tamanho) {
        ImageView icon = new ImageView(caminho);
        icon.setFitHeight(tamanho);
        icon.setFitWidth(tamanho);
        return icon;
    }

}
