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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        cantidadAlumnosCarreraPeriodo=new JButton("CantidadDeAlumnosCarreraPeriodo");
        cantidadAlumnosCarreraPeriodo.addActionListener(new CantidadAlumnosCarreraPeriodoActionListener());
        carrerasPorDNI=new JButton("CarrerasPorDNI");
        carrerasPorDNI.addActionListener(new CarrerasPorDNI());
         ingresarAlumno = new JButton("ingresarAlumno");
        ingresarAlumno.addActionListener(new IngresarAlumno());
        ingresarDocente = new JButton("ingresarDocente");
        ingresarDocente.addActionListener(new IngresarDocente());
        container.add(cantidadAlumnosCarreraPeriodo);
        container.add(carrerasPorDNI);
        container.add(ingresarAlumno);
        container.add(ingresarDocente);

    }
    
}
