/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Docente;
import githubtest.Rol;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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
public class ProfesoresPorAsignaturaActionListener implements ActionListener {

    private Frame frame;
    private JTextField asignaturaNom,
            asignaturaCod,
            ingresoAño,
            ingresoMes,
            ingresoDia;
    private JLabel slash,
            slash2;
    private JButton ingresar;

    class Ingresar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
          int año=Integer.parseInt(ingresoAño.getText());
          int mes=Integer.parseInt(ingresoMes.getText());
          int dia=Integer.parseInt(ingresoDia.getText());
           Set<Docente> docentes= Main.getRegistroDeCarreras().getDocentesAsignatura(asignaturaNom.getText(),asignaturaCod.getText(),LocalDate.of(año,mes,dia));
           String docentesConFormato="";
            for (Docente docente : docentes) {
               docentesConFormato+="\n"+docente;
            }
            JOptionPane.showMessageDialog(null,docentesConFormato);
        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        frame = new Frame("Profesores Por Asignatura");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        ingresar = new JButton("ingresar");
        ingresar.addActionListener(new Ingresar ());
        asignaturaNom = new JTextField("asiganatura", 20);
        asignaturaCod = new JTextField("Codigo", 20);
        ingresoAño = new JTextField("año", 5);
        ingresoMes = new JTextField("mes", 3);
        ingresoDia = new JTextField("dia", 3);
        slash = new JLabel("/");
        slash2 = new JLabel("/");
        container.add(asignaturaNom);
        container.add(asignaturaCod);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(ingresar);
    }

}
