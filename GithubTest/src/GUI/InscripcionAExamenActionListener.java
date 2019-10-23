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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class InscripcionAExamenActionListener implements ActionListener {

    private JTextFieldAdaptado alumnoDNI,
            asignaturaCod;
    private FechaComboBox fecha;
   private JLabel paraFinales;
    private JButton inscribirse;
    private JRadioButton libre;
    private Frame frame;

    class Inscribirse implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                String DNI = alumnoDNI.getText();
                ArrayList<Carrera> carreras = Main.registroDeCarreras.getCarreras();
                boolean e = false;
                for (Carrera carrera : carreras) {
                    Set<Alumno> alumnos = carrera.getAlumnos();
                    for (Alumno alumno : alumnos) {
                        if (alumno.getDNI().equals(DNI)) {
                            boolean noRegular = false;
                            if (libre.getSelectedObjects() != null) {
                                noRegular = true;
                            }
                            if (alumno.InscibirseAExamen(fecha.armado(), asignaturaCod.getText(), noRegular)) {
                                JOptionPane.showMessageDialog(null, "Operacion Exitosa");
                            }
                            e = true;
                        }

                    }
                }

                if (!e) {
                    JOptionPane.showMessageDialog(null, "Ese Alumno no se encuentra en el Sistema");
                }
            } catch (NoSeInscribioException e) {

            }
        }

    }

    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        frame = new Frame("Insribirse a Examen",inscribirse);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(250, 200, 800, 500);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        alumnoDNI=new JTextFieldAdaptado("DNI");
        fecha= new FechaComboBox();
        asignaturaCod = new JTextFieldAdaptado("Codigo de Asignatura");
        libre = new JRadioButton("libre");
        libre.setBounds(170,260,170,25);
        paraFinales = new JLabel("Para Finales: ");
        inscribirse=new JButton("Ingresar");
        container.add(alumnoDNI);
        container.add(asignaturaCod);
        container.add(fecha);
        container.add(libre);
        container.add(paraFinales);
        container.add(inscribirse);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inscribirse().actionPerformed(e);
            }
        };
        Enter enter = new Enter(inscribirse, action);
    }
    
}
