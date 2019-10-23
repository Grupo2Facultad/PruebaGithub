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
    private JTextFieldAdaptado asignaturaCod,
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
           Set<Docente> docentes= Main.getRegistroDeCarreras().getDocentesAsignatura(asignaturaCod.getText(),LocalDate.of(año,mes,dia));
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
        frame.setBounds(250, 200, 800, 500);
        Container container = frame.getContentPane();
        container.setLayout(null);
        ingresar = new JButton("Ingresar");
        ingresar.addActionListener(new Ingresar ());
        ingresar.setBounds(530, 198, 125,30);
        asignaturaCod = new JTextFieldAdaptado("Codigo");
        asignaturaCod.setBounds(200, 200,100 ,25);
        ingresoAño = new JTextFieldAdaptado("Año");
        ingresoAño.setBounds(320, 200,50, 25);
        ingresoMes = new JTextFieldAdaptado("Mes"); 
        ingresoMes.setBounds(390,200,50,25);
        ingresoDia = new JTextFieldAdaptado("Dia"); 
        ingresoDia.setBounds(460,200,50,25);
        slash = new JLabel("/");
        slash.setBounds(378, 197, 15, 30);
        slash2 = new JLabel("/");
        slash2.setBounds(448, 197, 15, 30);
        container.add(asignaturaCod);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(ingresar);
    }

}
