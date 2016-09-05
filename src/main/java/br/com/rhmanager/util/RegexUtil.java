package br.com.rhmanager.util;

/**
 *
 * @author lucas
 */
public class RegexUtil {

    public static String APENAS_LETRAS = "^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü ]*$";
    public static String EMAIL = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //MASK
    public static String MASK_TEL = "(##) ####-#####";
}
