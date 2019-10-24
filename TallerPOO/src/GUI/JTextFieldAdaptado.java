/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class JTextFieldAdaptado extends JTextField {

    public JTextFieldAdaptado(String text, int columns) {
        super(text, columns);
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setText("");
            }
        });
        this.setToolTipText(text);
    }

    public JTextFieldAdaptado(String text) {
        super(text);
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setText("");
            }
        });
        this.setToolTipText(text);
    }

    @Override
    public String getText() {
        return super.getText();
    }
}
