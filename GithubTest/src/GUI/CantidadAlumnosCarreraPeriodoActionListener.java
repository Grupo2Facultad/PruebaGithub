/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Carrera;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        slash2,
        carrerasDisponibles;
          
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
        ingresar.addActionListener(new MostrarCantidadAlumnos());
        this.carrerasDisponibles=new JLabel();
        carrerasDisponibles.setBounds(100, 200, 600, 25);
            String disponibles="Carreras Disponibles: ";
            ArrayList<Carrera>carreras=Main.registroDeCarreras.getCarreras();
            for (Carrera carrera : carreras) {
               disponibles+=carrera+"\n";
           }
            this.carrerasDisponibles.setText(disponibles);
        container.setLayout(new FlowLayout());
        container.add(carrera);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(ingresar);
        container.add(carrerasDisponibles);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
