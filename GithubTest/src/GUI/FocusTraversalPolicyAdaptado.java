/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.DefaultFocusTraversalPolicy;
import javax.swing.JComponent;

/**
 *
 * @author juanc
 */
public class FocusTraversalPolicyAdaptado extends DefaultFocusTraversalPolicy {

    private final JComponent boton;

    public FocusTraversalPolicyAdaptado(JComponent boton) {
        this.boton = boton;
    }

    @Override
    public Component getDefaultComponent(Container aContainer) {
      return boton;
    }

}
