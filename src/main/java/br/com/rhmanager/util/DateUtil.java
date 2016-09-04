/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.util;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author lucas
 */
public class DateUtil {

    public static int getAnoAtual() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

}
