/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Carrera;
import java.awt.*;
import java.awt.event.*;
import java.time.DateTimeException;
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
private FechaComboBox fecha;
          
    class MostrarCantidadAlumnos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                String ingresoNombre = (String) carrera.getSelectedItem();
                LocalDate date = fecha.armado();
                int cantidad = Main.getRegistroDeCarreras().getAlumnosPorCarrera(ingresoNombre, date);
                System.out.println("cantidad" + cantidad);
                String cantidadEs = "La cantidad de alumnos es " + cantidad;
                JOptionPane.showMessageDialog(null, cantidadEs);
            } catch (DateTimeException d) {
                JOptionPane.showMessageDialog(null,"Fecha Invalida");
            } catch (Exception e) {
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
        frame.setBounds(200, 150, 800, 200);
        Container container=frame.getContentPane();
        carrera=new JComboBox<>();
        for (Carrera carrera1 : Main.getRegistroDeCarreras().getCarreras()) {
            carrera.addItem(carrera1.getNombre());
        }
        carrera.setBounds(100, 150, 120, 25);
        ingresar=new JButton("Ingresar");
        ingresar.setBounds(430, 148, 100, 30);
        fecha= new FechaComboBox();
        container.setLayout(new FlowLayout());
        container.add(carrera);
        container.add(ingresar);
        container.add(fecha);
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
