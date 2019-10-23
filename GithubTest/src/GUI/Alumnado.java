/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author juanc
 */
public class Alumnado implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
            JButton cantidadAlumnosCarreraPeriodo,
            carrerasPorDNI,
            ingresarAlumno,
            ingresarDocente;
         Frame frame = new Frame("Alumnado");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension mip = pantalla.getScreenSize();
        int h = mip.height;
        int w = mip.width;
        frame.setBounds(200, h/4, 1080, h/2);
        Container container = frame.getContentPane();
        container.setLayout(null);
        cantidadAlumnosCarreraPeriodo=new JButton("Cantidad De Alumnos Carrera Periodo");
        cantidadAlumnosCarreraPeriodo.addActionListener(new CantidadAlumnosCarreraPeriodoActionListener());
        cantidadAlumnosCarreraPeriodo.setBounds(50, 150, 290, 30);
        carrerasPorDNI=new JButton("Carreras Por DNI");
        carrerasPorDNI.addActionListener(new CarrerasPorDNI());
        carrerasPorDNI.setBounds(390, 150, 170, 30);
        ingresarAlumno = new JButton("Ingresar alumno");
        ingresarAlumno.addActionListener(new IngresarAlumno());
        ingresarAlumno.setBounds(610, 150, 170, 30);
        ingresarDocente = new JButton("Ingresar docente");
        ingresarDocente.addActionListener(new IngresarDocente());
        ingresarDocente.setBounds(830, 150, 170, 30);
        container.add(cantidadAlumnosCarreraPeriodo);
        container.add(carrerasPorDNI);
        container.add(ingresarAlumno);
        container.add(ingresarDocente);
        Escape escape = new Escape(frame);
        escape.setKey();

    }
    
}
