package br.com.rhmanager.util;

import br.com.rhmanager.bean.funcionarios.Cargo;
import java.util.List;

/**
 *
 * @author lucas
 */
public class StringUtil {

    public static String listToStringAndStrings(List<Cargo> lista) {
        String result = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i < lista.size() - 1) {
                result += " " + lista.get(i).getTitulo() + ",";
            } else {
                result += " " + lista.get(i).getTitulo() + ".";
            }
        }
        return result;

    }
}
