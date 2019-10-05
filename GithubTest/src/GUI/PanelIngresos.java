/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            ingresarDocente,
            inscribirAAsignatura,
            inscribirAExamen;


    
    public PanelIngresos() {
        super();
        this.setLayout(new FlowLayout());
        label3 = new JLabel("Ingresos");
        ingresarAlumno = new JButton("ingresarAlumno");
        ingresarAlumno.addActionListener(new IngresarAlumno());
        ingresarDocente = new JButton("ingresarDocente");
        inscribirAExamen = new JButton("Inscribir a Examen");
        inscribirAExamen.addActionListener(new InscripcionAExamenActionListener ());
        ingresarDocente.addActionListener(new IngresarDocente ());
        inscribirAAsignatura = new JButton("Inscribir a Asignatura");
        inscribirAAsignatura.addActionListener(new InscribirseAAsignaturaActionListener());
        this.add(label3);
        this.add(ingresarAlumno);
        this.add(ingresarDocente);
        this.add(inscribirAAsignatura);
        this.add(inscribirAExamen);
    }
 

}
