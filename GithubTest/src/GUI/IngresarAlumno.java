/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author juanc
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

   public class IngresarAlumno implements ActionListener {
       private TextField ingresoNombre,
               ingresoApellido,
               ingresoDNI,
               ingresoNumeroMatricula,
               ingresoCarrera;
       private JButton ingresar;
       private Frame frame;

        @Override
        public void actionPerformed(ActionEvent e){
            frame = new Frame("IngresoDeAlumno");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Container container=frame.getContentPane();
            container.setLayout(new FlowLayout());
            this.ingresar=new JButton("INGRESAR");
            this.ingresar.addActionListener(new IngresarAlumnoActionListener(this));
            this.ingresoApellido=new TextField(20);
            this.ingresoApellido.setText("Apellido");
            this.ingresoNombre=new TextField(20);
            this.ingresoNombre.setText("Nombre");
            this.ingresoDNI=new TextField(20);
            this.ingresoDNI.setText("DNI");
            this.ingresoNumeroMatricula=new TextField(20);
            this.ingresoNumeroMatricula.setText("Numero Matricula");
            this.ingresoCarrera=new TextField(20);
            this.ingresoCarrera.setText("Carrera");
            container.add(this.ingresar);
            container.add(this.ingresoNombre);
            container.add(this.ingresoApellido);
            container.add(this.ingresoDNI);
            container.add(this.ingresoNumeroMatricula);
            container.add(this.ingresoCarrera);
            }

    public TextField getIngresoNombre() {
        return ingresoNombre;
    }

    public TextField getIngresoApellido() {
        return ingresoApellido;
    }

    public TextField getIngresoDNI() {
        return ingresoDNI;
    }

    public TextField getIngresoNumeroMatricula() {
        return ingresoNumeroMatricula;
    }

    public TextField getIngresoCarrera() {
        return ingresoCarrera;
    }

    public Frame getFrame() {
        return frame;
    }
    
        
        }
    
