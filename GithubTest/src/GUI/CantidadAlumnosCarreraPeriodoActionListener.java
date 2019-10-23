/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Carrera;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author juanc
 */
public class CantidadAlumnosCarreraPeriodoActionListener implements ActionListener{
private JButton ingresar;
private JComboBox<String > carrera;
private JTextFieldAdaptado ingresoAño;
private JTextFieldAdaptado ingresoMes;
private JTextFieldAdaptado ingresoDia;
private JLabel slash,
        slash2;
          
class MostrarCantidadAlumnos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            try{
           String ingresoNombre=(String)carrera.getSelectedItem();
          int año=Integer.parseInt(ingresoAño.getText());
          int mes=Integer.parseInt(ingresoMes.getText());
          int dia=Integer.parseInt(ingresoDia.getText());
          int cantidad= Main.getRegistroDeCarreras().getAlumnosPorCarrera(ingresoNombre,LocalDate.of(año,mes,dia));
            System.out.println("cantidad"+cantidad);
          String cantidadEs="La cantidad de alumnos es "+cantidad;
          JOptionPane.showMessageDialog(null,cantidadEs);
            }
            catch(Exception e){
            }
        }
}

    /**
     *
     * @param arg0
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Frame frame=new Frame("Cantidad De Alumnos Por Carrera en un Periodo");
        frame.setBounds(200, 150, 1080, 600);
        Container container=frame.getContentPane();
        carrera=new JComboBox<>();
        for (Carrera carrera1 : Main.getRegistroDeCarreras().getCarreras()) {
            carrera.addItem(carrera1.getNombre());
        }
        carrera.setBounds(100, 150, 120, 25);
        ingresoAño=new JTextFieldAdaptado("Año",5);
        ingresoAño.setBounds(240, 150, 50, 25);
        ingresoMes=new JTextFieldAdaptado("Mes",3);
        ingresoMes.setBounds(310, 150, 40, 25);
        ingresoDia=new JTextFieldAdaptado("Dia",3);
        ingresoDia.setBounds(370, 150, 40, 25);
        ingresar=new JButton("Ingresar");
        ingresar.setBounds(430, 148, 100, 30);
        slash=new JLabel("/");
        slash2=new JLabel("/");
        container.setLayout(new FlowLayout());
        container.add(carrera);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(ingresar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostrarCantidadAlumnos().actionPerformed(e);
            }
        };
        Enter enter = new Enter(ingresar, action);
        Escape escape = new Escape(frame);
        escape.setKey();
    }
    
}
