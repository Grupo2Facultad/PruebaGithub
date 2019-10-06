/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Asignatura;
import githubtest.Carrera;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class InscribirseAAsignaturaActionListener implements ActionListener{
    private JTextField alumnoDNI,
            asignaturaCod;
    private JButton inscribirse;
    private JRadioButton radioButton;
    private Frame frame;

    class Ingresar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(!check()){
            String DNI=alumnoDNI.getText();
            ArrayList<Carrera>carreras= Main.registroDeCarreras.getCarreras();
            boolean e=false;
            for (Carrera carrera : carreras) {
               Set<Alumno>alumnos= carrera.getAlumnos();
                for (Alumno alumno : alumnos) {
                    if (alumno.getDNI().equals(DNI)) {
                        if (radioButton.getSelectedObjects() != null) {
                            if (alumno.InscribirseAAsignaturaComoRegular(asignaturaCod.getText(), Main.registroDeCarreras)) {
                                JOptionPane.showMessageDialog(null, "Operacion Exitosa");
                                frame.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Codigo Invalido");
                            }
                            e = true;
                        }
                        else{
                            if (alumno.InscribirseAAsignaturaComoLibre(asignaturaCod.getText(), Main.registroDeCarreras)) {
                                JOptionPane.showMessageDialog(null, "Operacion Exitosa");
                                frame.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Codigo Invalido");
                            }
                            e = true;
                            
                        }
                    }
                }
            }
            if (!e) {
                JOptionPane.showMessageDialog(null,"Ese Alumno no se encuentra en el Sistema");
            }
            }
            else{
                JOptionPane.showMessageDialog(null,"el alumno ya esta inscripto");
            }
            
        }
        public boolean  check(){
            boolean e=false;
           Set<Asignatura>asignaturas= Main.registroDeCarreras.getAsigPorDNI(alumnoDNI.getText(), LocalDate.now());
            for (Asignatura asignatura : asignaturas) {
                if(asignatura.getCodigo().equals(asignaturaCod.getText())){
                    e=true;
                }
            }
            return e;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {

        frame = new Frame("Insribirse a Asignatura");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        alumnoDNI = new JTextField("AlumnoDNI", 20);
        asignaturaCod = new JTextField("Codigo", 6);
        this.radioButton = new JRadioButton("Regular");
        inscribirse = new JButton("ingresar");
        inscribirse.addActionListener(new Ingresar());
        Panel panel2 = new Panel();
        panel2.setLayout(new FlowLayout());
        panel2.add(alumnoDNI);
        panel2.add(asignaturaCod);
        panel2.add(radioButton);
        panel2.add(inscribirse);
        Panel panel=new Panel();
        panel.setLayout(new FlowLayout());
        container.add(panel2,BorderLayout.NORTH);
        container.add(panel,BorderLayout.SOUTH);
        }
    }

