/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juanc
 */
public class PanelIngresos extends JPanel {

    protected JLabel label3;
    protected JButton ingresarAlumno,
            ingresarDocente;

    public PanelIngresos() {
        super();
        this.setLayout(new FlowLayout());
        label3 = new JLabel("Ingresos");
        ingresarAlumno = new JButton("ingresarAlumno");
        ingresarDocente = new JButton("ingresarDocente");
        this.add(label3);
        this.add(ingresarAlumno);
        this.add(ingresarDocente);
    }

}
