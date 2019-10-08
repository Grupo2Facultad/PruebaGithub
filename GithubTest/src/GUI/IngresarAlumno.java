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

   public class IngresarAlumno implements ActionListener {
       private TextField ingresoNombre,
               ingresoApellido,
               ingresoDNI,
               ingresoNumeroMatricula,
               ingresoCarrera,
               //Desde aca no son obligatorios el ingreso
               ingresoDomicilio,
               ingresoLocalidad,
               ingresoProvincia,
               ingresoPaisDeResidencia,
               ingresoCorreoElectronico,
               ingresoFechaNacimiento,
               ingresoFechaInscripcion;
       private JLabel obligatorios,
               carrerasDisponibles;
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
            this.ingresoApellido.setText("Apellido*");
            this.ingresoNombre=new TextField(20);
            this.ingresoNombre.setText("Nombre*");
            this.ingresoDNI=new TextField(20);
            this.ingresoDNI.setText("DNI*");
            this.ingresoNumeroMatricula=new TextField(20);
            this.ingresoNumeroMatricula.setText("Numero Matricula*");
            this.ingresoCarrera=new TextField(20);
            this.ingresoCarrera.setText("Carrera*");
            this.ingresoDomicilio=new TextField(20);
            this.ingresoDomicilio.setText("domicilio");
            this.ingresoLocalidad=new TextField(20);
            this.ingresoLocalidad.setText("localidad");
            this.ingresoCorreoElectronico=new TextField(20);
            this.ingresoCorreoElectronico.setText("Correro electronico");
            this.ingresoPaisDeResidencia=new TextField(20);
            this.ingresoPaisDeResidencia.setText("pais de residencia");
            this.ingresoProvincia=new TextField(20);
            this.ingresoProvincia.setText("provincia");
            this.ingresoFechaInscripcion=new TextField("fecha de inscripcion",20);
            this.ingresoFechaNacimiento=new TextField("fecha de nacimiento", 20);
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
            container.add(this.ingresoNumeroMatricula);
            container.add(this.ingresoCarrera);
            container.add(this.ingresoDomicilio);
            container.add(this.ingresoLocalidad);
            container.add(this.ingresoProvincia);
            container.add(this.ingresoPaisDeResidencia);
            container.add(this.ingresoCorreoElectronico);
            container.add(this.ingresoFechaInscripcion);
            container.add(this.ingresoFechaNacimiento);
            container.add(obligatorios);
            container.add(carrerasDisponibles);
            }

    public TextField getIngresoDomicilio() {
        return ingresoDomicilio;
    }

    public TextField getIngresoLocalidad() {
        return ingresoLocalidad;
    }

    public TextField getIngresoProvincia() {
        return ingresoProvincia;
    }

    public TextField getIngresoPaisDeResidencia() {
        return ingresoPaisDeResidencia;
    }

    public TextField getIngresoCorreoElectronico() {
        return ingresoCorreoElectronico;
    }

    public TextField getIngresoFechaNacimiento() {
        return ingresoFechaNacimiento;
    }

    public TextField getIngresoFechaInscripcion() {
        return ingresoFechaInscripcion;
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
    
