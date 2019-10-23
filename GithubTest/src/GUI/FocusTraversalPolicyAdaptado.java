/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author juanc
 */
public class FocusTraversalPolicyAdaptado extends FocusTraversalPolicy{
private JComponent boton;

    public FocusTraversalPolicyAdaptado(JComponent boton) {
        this.boton = boton;
    }


    @Override
    public Component getComponentAfter(Container arg0, Component arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getComponentBefore(Container arg0, Component arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getFirstComponent(Container arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getLastComponent(Container arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getDefaultComponent(Container arg0) {
        return boton;
    }
    
}
