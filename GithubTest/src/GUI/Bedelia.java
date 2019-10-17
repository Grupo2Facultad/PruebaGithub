/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;
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
            anotarDocenteEnExamen,
             inscribirDocenteAsignatura,
                 darAlumnoDeBaja;
        Frame frame = new Frame("Bedelia");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension mip = pantalla.getScreenSize();
        int h = mip.height;
        int w = mip.width;
        frame.setBounds(200, h/4, 1080, h/2);
        Container container = frame.getContentPane(); 
        container.setLayout(null);
        darAlumnoDeBaja=new JButton("Dar de Baja de Examen");
        darAlumnoDeBaja.addActionListener(new DarDeBajaExamenActionListener());
        darAlumnoDeBaja.setBounds(490, 210, 170, 30);
        habilitadosParcial = new JButton("Habiltiados al parcial");
        habilitadosParcial.addActionListener(new HabiltiadosExamenActionListener(true));
        habilitadosParcial.setBounds(50, 50, 170, 30);
        habilitadosFinal = new JButton("Habilitados al final");
        habilitadosFinal.addActionListener(new HabiltiadosExamenActionListener(false));
        habilitadosFinal.setBounds(270, 50, 170, 30);
        asignaturasPorDNI = new JButton("Asignaturas por DNI");
        asignaturasPorDNI.addActionListener(new AsignaturasPorDni());
        asignaturasPorDNI.setBounds(490, 50, 170, 30);
        inscribirDocenteAsignatura= new JButton("Inscribir docente a asignatura");
        inscribirDocenteAsignatura.addActionListener(new inscribirDocenteAsignaturaActionListener());
        inscribirDocenteAsignatura.setBounds(710, 50, 220, 30);
        profesoresProAsignatura = new JButton("Profesoes Asignatura");
        profesoresProAsignatura.addActionListener(new ProfesoresPorAsignaturaActionListener ());
        profesoresProAsignatura.setBounds(710, 130, 220, 30);
        inscribirAExamen = new JButton("Inscribir a examen");
        inscribirAExamen.addActionListener(new InscripcionAExamenActionListener ());
        inscribirAExamen.setBounds(270, 130, 170, 30);
        inscribirAAsignatura = new JButton("Inscribir a asignatura");
        inscribirAAsignatura.addActionListener(new InscribirseAAsignaturaActionListener());
        inscribirAAsignatura.setBounds(490, 130, 170, 30);
        anotarDocenteEnExamen= new JButton ("Anotar docente en examen");
        anotarDocenteEnExamen.addActionListener(new AnotarDocenteActionListener());
        anotarDocenteEnExamen.setBounds(50, 130, 170, 30);
        imprimirActa = new JButton("Imprimir acta");
        imprimirActa.addActionListener(new ImprimirActaActionListener());
        imprimirActa.setBounds(270, 210, 170, 30);
        container.add(habilitadosParcial);
        container.add(habilitadosFinal);
        container.add(asignaturasPorDNI);
        container.add(profesoresProAsignatura);
        container.add(imprimirActa);
        container.add(inscribirAAsignatura);
        container.add(inscribirAExamen);
        container.add(anotarDocenteEnExamen);
        container.add(inscribirDocenteAsignatura);
        container.add(darAlumnoDeBaja);
        container.add(new PanelBusquedaCodigo());
        container.getComponent(10).setBounds(100, 290, 800, 50);
        
    }
    
}
