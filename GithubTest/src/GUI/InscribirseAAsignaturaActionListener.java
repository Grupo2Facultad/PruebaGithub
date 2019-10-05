/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Carrera;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class InscribirseAAsignaturaActionListener implements ActionListener{
    private JTextField alumnoDNI,
            asignaturaCod;
    private JButton inscribirse;
    private Frame frame;
    class Ingresar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String DNI=alumnoDNI.getText();
            ArrayList<Carrera>carreras= Main.registroDeCarreras.getCarreras();
            boolean e=false;
            for (Carrera carrera : carreras) {
               Set<Alumno>alumnos= carrera.getAlumnos();
                for (Alumno alumno : alumnos) {
                    if(alumno.getDNI().equals(DNI)){
                        if(alumno.InscribirseAAsignaturaComoRegular(asignaturaCod.getText(),Main.registroDeCarreras)){
                        JOptionPane.showMessageDialog(null,"Operacion Exitosa");
                         frame.setVisible(false);  
                        }
                        else{
                        JOptionPane.showMessageDialog(null,"Codigo Invalido");
                    }
                        e=true;                                          
                    }
                }
            }
            if(!e){
                JOptionPane.showMessageDialog(null,"Ese Alumno no se encuentra en el Sistema");
            }
            
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        frame = new Frame("Insribirse a Asignatura");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        alumnoDNI=new JTextField("AlumnoDNI",20);
        asignaturaCod=new JTextField("Codigo",6);
        inscribirse=new JButton("ingresar");
        inscribirse.addActionListener(new Ingresar());
        container.add(alumnoDNI);
        container.add(asignaturaCod);
        container.add(inscribirse);
        }
    }

