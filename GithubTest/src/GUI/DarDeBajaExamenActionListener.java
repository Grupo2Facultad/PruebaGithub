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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class DarDeBajaExamenActionListener implements ActionListener{
private JTextFieldAdaptado alumnoDNI,
            asignaturaCod;
private FechaComboBox fecha;
    private JButton darDeBaja;
    private Frame frame;
    class DarseDeBaja implements ActionListener{
            @Override
        public void actionPerformed(ActionEvent arg0) {
            String DNI = alumnoDNI.getText();
            ArrayList<Carrera> carreras = Main.registroDeCarreras.getCarreras();
            boolean e = false;
            for (Carrera carrera : carreras) {
                Set<Alumno> alumnos = carrera.getAlumnos();
                for (Alumno alumno : alumnos) {
                    if (alumno.getDNI().equals(DNI)) {
                        try{
                        if (alumno.DarseDeBaja(fecha.armado(),asignaturaCod.getText())) {
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
    public void actionPerformed(ActionEvent ae) {
        frame = new Frame("Darse de baja",darDeBaja);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(250, 200, 700, 200);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        alumnoDNI=new JTextFieldAdaptado("AlumnoDNI",20);
        fecha= new FechaComboBox();
        asignaturaCod = new JTextFieldAdaptado("Codigo de Asignatura");
        darDeBaja=new JButton("Ingresar");
        container.add(alumnoDNI);
        container.add(asignaturaCod);
        container.add(fecha);
        container.add(darDeBaja);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DarseDeBaja().actionPerformed(e);
            }
        };
        Enter enter = new Enter(darDeBaja, action);
    }
    
}
