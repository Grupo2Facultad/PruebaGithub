/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author juanc
 */
public class Enter {

    private JButton boton;
    private Action accion;

    public Enter(JButton boton, Action accion) {
        this.boton = boton;
        this.accion = accion;
        accion.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ENTER"));
        boton.setAction(accion);
        boton.getActionMap().put("setOneAction", accion);
        boton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) accion.getValue(Action.ACCELERATOR_KEY), "setOneAction");
    }
}
