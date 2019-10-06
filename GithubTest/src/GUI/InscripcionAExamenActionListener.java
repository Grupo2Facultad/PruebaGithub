/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Carrera;
import githubtest.NoSeInscribioException;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class InscripcionAExamenActionListener implements ActionListener {

    private JTextField alumnoDNI,
            asignaturaCod,
            ingresoAño,
            ingresoMes,
            ingresoDia;
    private JLabel slash,
            slash2;
    private JButton inscribirse;
    private Frame frame;

    class Inscribirse implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String DNI = alumnoDNI.getText();
           int año=Integer.parseInt(ingresoAño.getText());
          int mes=Integer.parseInt(ingresoMes.getText());
          int dia=Integer.parseInt(ingresoDia.getText());
            LocalDate fecha=LocalDate .of(año,mes,dia); 
            ArrayList<Carrera> carreras = Main.registroDeCarreras.getCarreras();
            boolean e = false;
            for (Carrera carrera : carreras) {
                Set<Alumno> alumnos = carrera.getAlumnos();
                for (Alumno alumno : alumnos) {
                    if (alumno.getDNI().equals(DNI)) {
                        try{
                        if (alumno.InscibirseAExamen(fecha,asignaturaCod.getText())) {
                            JOptionPane.showMessageDialog(null, "Operacion Exitosa");
                            frame.setVisible(false);
                        }
                        }
                        catch(NoSeInscribioException t){
                        }
                        e = true;
                    }

                }
            }

            if (!e) {
                JOptionPane.showMessageDialog(null, "Ese Alumno no se encuentra en el Sistema");
            }
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        frame = new Frame("Insribirse a Examen");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
         alumnoDNI=new JTextField("AlumnoDNI",20);
         ingresoAño=new JTextField("año",5);
        ingresoMes=new JTextField("mes",3);
        ingresoDia=new JTextField("dia",3);
        slash=new JLabel("/");
        slash2=new JLabel("/");
        asignaturaCod = new JTextField("Codigo de Asignatura",20);
        inscribirse=new JButton("ingresar");
        inscribirse.addActionListener(new Inscribirse());
        container.add(alumnoDNI);
        container.add(asignaturaCod);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(inscribirse);
    }
    
}
