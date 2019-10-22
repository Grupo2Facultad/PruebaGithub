/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Alumno
 */

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class HintTextField extends JTextField {

private String hint;
private Color cForeground;
private Color cHint;

public void setHint(String s) {
    hint = s;
    cForeground = getForeground();

    setText(hint);
    cHint = new Color(cForeground.getRed(), cForeground.getGreen(),
            cForeground.getBlue(), cForeground.getAlpha() / 2);

    addFocusListener(new FocusListener() {

        @Override
        public void focusLost(FocusEvent arg0) {
            if (getText().equals(hint)) {
                setForeground(cHint);
                setText(hint);
            }
        }

        @Override
        public void focusGained(FocusEvent arg0) {
            if (getText().equals(hint)) {
                setText(" ");
                setForeground(cHint);
            }
        }
    });
}
}