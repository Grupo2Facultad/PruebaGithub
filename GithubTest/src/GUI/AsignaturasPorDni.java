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
public class AsignaturasPorDni implements ActionListener{
    private JButton ingresar;
    private JTextField ingresoDNI,
            ingresoAño,
            ingresoMes,
            ingresoDia;
    private JLabel slash,
            slash2;
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
        Frame frame=new Frame("Asignaturas Cursadas Por El Alumno con Determinado DNI en una determinada Fecha");
        frame.setBounds(300, 200, 600, 500);
        Container container=frame.getContentPane();
        ingresar=new JButton("Ingresar");
        ingresar.addActionListener(new MostrarCantidadAlumnos ());
        ingresar.setBounds(400, 198, 120, 30);
        ingresoDNI=new JTextField("DNI",20);
        ingresoDNI.setBounds(40,200, 125,25);
        ingresoAño=new JTextField("Año",5);
         ingresoAño.setBounds(185, 200,50 ,25);
        ingresoMes=new JTextField("Mes",3);
        ingresoMes.setBounds(255, 200,70, 25);
        ingresoDia=new JTextField("Dia",3);
        ingresoDia.setBounds(345,200,35,25);
        slash=new JLabel("/");
        slash.setBounds(240, 198,15, 25);
        slash2=new JLabel("/");
        slash2.setBounds(330,198,15,25);
        container.setLayout(null);
        container.add(ingresoDNI);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(ingresar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
     }
    
}
