/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author juanc
 */
public class Frame extends JFrame {

    private JComponent boton;

    public Frame(String s, JComponent boton) {
        super(s);
        this.setFocusTraversalPolicy(new FocusTraversalPolicyAdaptado(boton));
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Escape escape = new Escape(this);
        escape.setKey();
    }

    public Frame(String s) {
        super(s);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Escape escape = new Escape(this);
        escape.setKey();
    }
}
