/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ClasesLogicas.Alumno;
import ClasesLogicas.Asignatura;
import ClasesLogicas.Carrera;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
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
    private JTextFieldAdaptado alumnoDNI,
            asignaturaCod;
    private JButton inscribirse;
    private JRadioButton radioButton;
    private Frame frame;

    class Ingresar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            try{
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
                else {
                    JOptionPane.showMessageDialog(null, "El alumno ya esta inscripto");
                }

            } catch (Alumno.NoInscritoException e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }

        public boolean check() {
            boolean e = false;
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
        frame = new Frame("Insribirse a Asignatura",inscribirse);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(250, 250, 700, 400);
        Container container = frame.getContentPane();
        container.setLayout(null);
        alumnoDNI = new JTextFieldAdaptado("AlumnoDNI");
        alumnoDNI.setBounds(50, 150, 120, 25);
        asignaturaCod = new JTextFieldAdaptado("Codigo");
        asignaturaCod.setBounds(190, 150, 120, 25);
        this.radioButton = new JRadioButton("Regular");
        radioButton.setBounds(330, 150, 120, 25);
        radioButton.setSelected(true);
        inscribirse = new JButton("Ingresar");
        inscribirse.setBounds(450, 148, 120, 30);
        container.add(alumnoDNI);
        container.add(asignaturaCod);
        container.add(radioButton);
        container.add(inscribirse);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ingresar().actionPerformed(e);
            }
        };
        Enter enter = new Enter(inscribirse, action);
        }
    }

