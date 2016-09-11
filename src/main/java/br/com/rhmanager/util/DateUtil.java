/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class DateUtil {

    public static int getAnoAtual() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    public static Calendar convertStringCalendar(String data) {

        try {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

            Calendar c = Calendar.getInstance();
            c.setTime(formatoData.parse(data));
            return c;
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static String convertCalendarInString(Calendar calendar) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        String retorno = "";

        retorno = formatoData.format(calendar.getTime());

        return retorno;

    }

    public static Calendar getDataHoraAtual() {

        Calendar cal = new GregorianCalendar();

        return cal;
    }

    public static Calendar getData(String data_br) {
        java.util.Date data;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        data_br = data_br.replaceAll("/", "-");

        String[] vetor = data_br.split("-");

        int ano = Integer.parseInt(vetor[2]);
        int mes = Integer.parseInt(vetor[1]);
        int dia = Integer.parseInt(vetor[0]);

        Calendar cal = new GregorianCalendar(ano, (mes - 1), dia);

        return cal;
    }

    public static String getDataBR(Calendar calendar) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String data = df.format(calendar.getTime());

        return data;
    }

    public static String getHoraBR(Date date) {
        DateFormat df = new SimpleDateFormat("HH:mm");

        String data = df.format(date);

        return data;
    }

    public static String transformDate(String string) {

        String[] data = string.split("/");

        return data[2] + "-" + data[1] + "-" + data[0];
    }

    public static String convertCalendarInStringDateEUA(Calendar calendar) {
        Date data = calendar.getTime();

        Format formato = new SimpleDateFormat("yyyy-MM-dd");

        return formato.format(data);
    }

    public static Date convertStringHourInDate(String hora) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Date d = null;
        try {
            d = sdf.parse(hora);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public static Calendar minorDateList(Calendar atual, Calendar recente) {
        if (atual.before(recente)) {
            return recente;
        } else {
            return atual;
        }
    }

}
