/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Carrera;
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
            asignaturaCod,
            ingresoAño,
            ingresoMes,
            ingresoDia;
    private JLabel slash,
            slash2,
            paraFinales;
    private JButton inscribirse;
    private JRadioButton libre;
    private Frame frame;

    class Inscribirse implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                String DNI = alumnoDNI.getText();
                int año = Integer.parseInt(ingresoAño.getText());
                int mes = Integer.parseInt(ingresoMes.getText());
                int dia = Integer.parseInt(ingresoDia.getText());
                LocalDate fecha = LocalDate.of(año, mes, dia);
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
                            if (alumno.InscibirseAExamen(fecha, asignaturaCod.getText(), noRegular)) {
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
        frame = new Frame("Insribirse a Examen");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(250, 200, 800, 500);
        Container container = frame.getContentPane();
        container.setLayout(null);
        alumnoDNI=new JTextFieldAdaptado("DNI");
        alumnoDNI.setBounds(270, 200, 100, 25);
        ingresoAño=new JTextFieldAdaptado("Año");
        ingresoAño.setBounds(390, 200, 50, 25);
        ingresoMes=new JTextFieldAdaptado("Mes");
        ingresoMes.setBounds(460, 200, 50, 25);
        ingresoDia=new JTextFieldAdaptado("Dia");
        ingresoDia.setBounds(530, 200, 50, 25);
        slash=new JLabel("/");
        slash.setBounds(445, 197, 15, 30);
        slash2=new JLabel("/");
        slash2.setBounds(515, 197, 15, 30);
        asignaturaCod = new JTextFieldAdaptado("Codigo de Asignatura");
        asignaturaCod.setBounds(80,200, 170,25);
        libre = new JRadioButton("libre");
        libre.setBounds(170,260,170,25);
        paraFinales = new JLabel("Para Finales: ");
        paraFinales.setBounds(80, 260, 170, 25);
        inscribirse=new JButton("Ingresar");
        inscribirse.setBounds(600, 198, 140, 30);
        container.add(alumnoDNI);
        container.add(asignaturaCod);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
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
