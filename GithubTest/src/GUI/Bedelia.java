/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alumno
 */
public class Bedelia implements ActionListener {
public Bedelia(){
    super();
}
   
    @Override
    public void actionPerformed(ActionEvent ae) {
         JButton habilitadosParcial,
            habilitadosFinal,
            asignaturasPorDNI,
            profesoresProAsignatura,
            imprimirActa,
            inscribirAAsignatura,
            inscribirAExamen,
            anotarDocenteEnExamen;
        Frame frame = new Frame("Bedelia");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        habilitadosParcial = new JButton("HabiltiadosParcial");
        habilitadosParcial.addActionListener(new HabiltiadosExamenActionListener());
        habilitadosFinal = new JButton("HabilitadosFinal");
        habilitadosFinal.addActionListener(new HabiltiadosExamenActionListener());
        asignaturasPorDNI = new JButton("AsignaturasPorDNI");
        asignaturasPorDNI.addActionListener(new AsignaturasPorDni());
        profesoresProAsignatura = new JButton("ProfesoesAsignatura");
        profesoresProAsignatura.addActionListener(new ProfesoresPorAsignaturaActionListener ());
        inscribirAExamen = new JButton("Inscribir a Examen");
        inscribirAExamen.addActionListener(new InscripcionAExamenActionListener ());
        inscribirAAsignatura = new JButton("Inscribir a Asignatura");
        inscribirAAsignatura.addActionListener(new InscribirseAAsignaturaActionListener());
        anotarDocenteEnExamen= new JButton ("Anotar Docente En Examen");
        anotarDocenteEnExamen.addActionListener(new AnotarDocenteActionListener());
        imprimirActa = new JButton("ImprimirActa");
        imprimirActa.addActionListener(new ImprimirActaActionListener());
        container.add(habilitadosParcial);
        container.add(habilitadosFinal);
        container.add(asignaturasPorDNI);
        container.add(profesoresProAsignatura);
        container.add(imprimirActa);
         container.add(inscribirAAsignatura);
        container.add(inscribirAExamen);
        container.add(anotarDocenteEnExamen);
        container.add(new PanelBusquedaCodigo());
    }
    
}
