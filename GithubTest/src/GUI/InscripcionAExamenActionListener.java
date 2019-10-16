/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Carrera;
import java.awt.Container;
import java.awt.*;
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
        frame.setBounds(250, 200, 800, 500);
        Container container = frame.getContentPane();
        container.setLayout(null);
        alumnoDNI=new JTextField("DNI",20);
        alumnoDNI.setBounds(270, 200, 100, 25);
        ingresoAño=new JTextField("Año",5);
        ingresoAño.setBounds(390, 200, 50, 25);
        ingresoMes=new JTextField("Mes",3);
        ingresoMes.setBounds(460, 200, 50, 25);
        ingresoDia=new JTextField("Dia",3);
        ingresoDia.setBounds(530, 200, 50, 25);
        slash=new JLabel("/");
        slash.setBounds(445, 197, 15, 30);
        slash2=new JLabel("/");
        slash2.setBounds(515, 197, 15, 30);
        asignaturaCod = new JTextField("Codigo de Asignatura",20);
        asignaturaCod.setBounds(80,200, 170,25);
        inscribirse=new JButton("Ingresar");
        inscribirse.setBounds(600, 198, 140, 30);
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
