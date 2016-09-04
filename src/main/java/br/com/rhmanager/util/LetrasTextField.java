/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.util;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author lucas
 */
public class LetrasTextField extends TextField {

    private int maxlength;

    public LetrasTextField() {
        this.maxlength = 10;
    }
    
    

    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    @Override
    public void replaceText(int start, int end, String text) {
        // Delete or backspace user input.
        if (text.equals("")) {
            super.replaceText(start, end, text.toUpperCase());
        } else if (getText().length() < maxlength && text.matches(RegexUtil.APENAS_LETRAS)) {
            super.replaceText(start, end, text.toUpperCase());
        }
    }

    @Override
    public void replaceSelection(String text) {
        // Delete or backspace user input.
        if (text.equals("")) {
            super.replaceSelection(text);
        } else if (getText().length() < maxlength) {
            // Add characters, but don't exceed maxlength.
            if (text.length() > maxlength - getText().length()) {
                text = text.substring(0, maxlength - getText().length());
            }
            super.replaceSelection(text.toUpperCase());
        }
    }

}
