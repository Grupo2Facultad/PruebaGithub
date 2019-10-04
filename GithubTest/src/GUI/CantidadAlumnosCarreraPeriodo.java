/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class CantidadAlumnosCarreraPeriodo implements ActionListener{
private JButton ingresar;
private JTextField ingresoNombre;
private JTextField ingresoAño;
private JTextField ingresoMes;
private JTextField ingresoDia;
private String carrera;
class MostrarCantidadAlumnos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
          carrera=ingresoNombre.getText();
          int año=Integer.parseInt(ingresoAño.getText());
          int mes=Integer.parseInt(ingresoMes.getText());
          int dia=Integer.parseInt(ingresoDia.getText());
          int cantidad= Main.getRegistroDeCarreras().getAlumnosPorCarrera(carrera,LocalDate.of(año,mes,dia));
          String cantidadEs="La cantidad de alumnos es "+cantidad;
          JOptionPane.showMessageDialog(null,cantidadEs);
        }
}

    /**
     *
     * @param arg0
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Frame frame=new Frame("Cantidad De Alumnos Por Carrera en un Periodo");
        Container container=frame.getContentPane();
        ingresoNombre=new JTextField(20);
        ingresoAño=new JTextField(20);
        ingresoMes=new JTextField(20);
        ingresoDia=new JTextField(20);
        ingresar=new JButton("inrgesar");
        ingresar.addActionListener(new MostrarCantidadAlumnos());
        container.setLayout(new FlowLayout());
        container.add(ingresoNombre);
        container.add(ingresoAño);
        container.add(ingresoMes);
        container.add(ingresoDia);
        container.add(ingresar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
