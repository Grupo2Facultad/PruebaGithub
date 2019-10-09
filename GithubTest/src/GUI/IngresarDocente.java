/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Carrera;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author juanc
 */
public class IngresarDocente implements ActionListener {
     private TextField ingresoNombre,
               ingresoApellido,
               ingresoDNI,
               ingresoNumeroLegajo,
               ingresoCarrera,
               ingresoADocencia;
      private JLabel obligatorios,
              carrerasDisponibles;
       private JButton ingresar;
       private Frame frame;
        @Override
        public void actionPerformed(ActionEvent e){
            frame = new Frame("IngresoDeDocente");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Container container=frame.getContentPane();
            container.setLayout(new FlowLayout());
            this.ingresar=new JButton("INGRESAR");
            this.ingresar.addActionListener(new IngresarDocenteActionListener(this)) ;
            this.ingresoApellido=new TextField(20);
            this.ingresoApellido.setText("Apellido*");
            this.ingresoNombre=new TextField(20);
            this.ingresoNombre.setText("Nombre*");
            this.ingresoDNI=new TextField(20);
            this.ingresoDNI.setText("DNI*");
            this.ingresoNumeroLegajo=new TextField(20);
            this.ingresoNumeroLegajo.setText("Numero Legajo*");
            this.ingresoCarrera=new TextField(20);
            this.ingresoCarrera.setText("Carrera*");
            this.ingresoADocencia=new TextField("ingreso A Docencia",20);
            this.carrerasDisponibles=new JLabel();
            String disponibles="Carreras Disponibles: ";
            ArrayList<Carrera>carreras=Main.registroDeCarreras.getCarreras();
            for (Carrera carrera : carreras) {
               disponibles+=carrera+"\n";
           }
            this.carrerasDisponibles.setText(disponibles);
            obligatorios=new JLabel("Campos Obligatorios: Apellido, Nombre,DNI,NumeroMatricula, Carrera (Marcados con *)");
            container.add(this.ingresar);
            container.add(this.ingresoNombre);
            container.add(this.ingresoApellido);
            container.add(this.ingresoDNI);
            container.add(this.ingresoNumeroLegajo);
            container.add(this.ingresoCarrera);
            container.add(ingresoADocencia);
            container.add(obligatorios);
            container.add(carrerasDisponibles);
            
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

    public TextField getIngresoNumeroLegajo() {
        return ingresoNumeroLegajo;
    }

    public TextField getIngresoCarrera() {
        return ingresoCarrera;
    }

    public TextField getIngresoADocencia() {
        return ingresoADocencia;
    }

    public JLabel getObligatorios() {
        return obligatorios;
    }

    public JButton getIngresar() {
        return ingresar;
    }

    public Frame getFrame() {
        return frame;
    }
    }

