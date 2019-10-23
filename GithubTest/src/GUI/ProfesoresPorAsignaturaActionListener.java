/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Docente;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class ProfesoresPorAsignaturaActionListener implements ActionListener {

    private Frame frame;
    private JTextFieldAdaptado asignaturaCod;
    private FechaComboBox fecha;
    private JButton ingresar;

    class Ingresar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            Set<Docente> docentes = Main.getRegistroDeCarreras().getDocentesAsignatura(asignaturaCod.getText(), fecha.armado());
            if (docentes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Esa asignatura no tiene docentes");
            } else {
                if (docentes != null) {
                    String docentesConFormato = "";
                    for (Docente docente : docentes) {
                        docentesConFormato += "\n" + docente;
                    }
                    JOptionPane.showMessageDialog(null, docentesConFormato);
                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        frame = new Frame("Profesores Por Asignatura",ingresar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(250, 200, 800, 500);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        ingresar = new JButton("Ingresar");
        asignaturaCod = new JTextFieldAdaptado("Codigo");
        fecha= new FechaComboBox();
        container.add(asignaturaCod);
        container.add(fecha);
        container.add(ingresar);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ingresar().actionPerformed(e);
            }
        };
        Enter enter = new Enter(ingresar, action);
    }

}
