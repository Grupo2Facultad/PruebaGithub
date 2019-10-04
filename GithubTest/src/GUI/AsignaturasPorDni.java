/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Asignatura;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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
public class AsignaturasPorDni implements ActionListener{
    private JButton ingresar;
    private JTextField ingresoDNI,
            ingresoAño,
            ingresoMes,
            ingresoDia;
    private String DNI;
    class MostrarCantidadAlumnos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
          DNI=ingresoDNI.getText();
          int año=Integer.parseInt(ingresoAño.getText());
          int mes=Integer.parseInt(ingresoMes.getText());
          int dia=Integer.parseInt(ingresoDia.getText());
           Set<Asignatura> asignaturas=Main.getRegistroDeCarreras().getAsigPorDNI(DNI, LocalDate.of(año,mes,dia));
          String asignaturasDNI="Las asignaturas cursadas son"+asignaturas;
          JOptionPane.showMessageDialog(null,asignaturasDNI);
        }
}
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Frame frame=new Frame("Asignaturas Cursadas Por El Alumno con Determinado DNI en un Determinado Periodo");
        Container container=frame.getContentPane();
        ingresar=new JButton("ingresar");
        ingresar.addActionListener(new MostrarCantidadAlumnos ());
        ingresoDNI=new JTextField("dni",20);
        ingresoAño=new JTextField("año",4);
        ingresoMes=new JTextField("mes",2);
        ingresoDia=new JTextField("dia",2);
        container.setLayout(new FlowLayout());
        container.add(ingresoDNI);
        container.add(ingresoAño);
        container.add(ingresoMes);
        container.add(ingresoDia);
        container.add(ingresar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
     }
    
}
