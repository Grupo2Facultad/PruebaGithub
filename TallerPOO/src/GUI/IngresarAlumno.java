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
import ClasesLogicas.Carrera;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IngresarAlumno implements ActionListener {

    private JTextFieldAdaptado ingresoNombre,
            ingresoApellido,
            ingresoDNI,
            ingresoNumeroMatricula,
            //Desde aca no son obligatorios el ingreso
            ingresoDomicilio,
            ingresoLocalidad,
            ingresoProvincia,
            ingresoPaisDeResidencia,
            ingresoCorreoElectronico,
            ingresoFechaNacimiento,
            ingresoFechaInscripcion;
    private JLabel obligatorios;
    private JComboBox carrera;
    private JButton ingresar;
    private Frame frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        frame = new Frame("Ingreso De Alumno");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(150, 100, 1387, 700);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        this.ingresar = new JButton("Ingresar");
        this.ingresoApellido = new JTextFieldAdaptado("Apellido*", 20);
        this.ingresoNombre = new JTextFieldAdaptado("Nombre*", 20);
        this.ingresoDNI = new JTextFieldAdaptado("DNI*", 9);
        this.ingresoNumeroMatricula = new JTextFieldAdaptado("Numero Matricula*", 12);
        this.ingresoDNI = new JTextFieldAdaptado("DNI*",9);
        this.ingresoNumeroMatricula = new JTextFieldAdaptado("Numero Matricula*",12);
        carrera = new JComboBox<>();
        for (Carrera carrera1 : Main.getRegistroDeCarreras().getCarreras()) {
            carrera.addItem(carrera1.getNombre());
        }
        this.ingresoDomicilio = new JTextFieldAdaptado("domicilio", 20);
        this.ingresoLocalidad = new JTextFieldAdaptado("localidad", 20);
        this.ingresoCorreoElectronico = new JTextFieldAdaptado("Correro electronico", 20);
        this.ingresoPaisDeResidencia = new JTextFieldAdaptado("pais de residencia", 20);
        this.ingresoProvincia = new JTextFieldAdaptado("provincia",20);
        this.ingresoFechaInscripcion = new JTextFieldAdaptado("fecha de inscripcion", 11);
        this.ingresoFechaNacimiento = new JTextFieldAdaptado("fecha de nacimiento", 11);
        obligatorios = new JLabel("Campos Obligatorios: Apellido, Nombre,DNI,NumeroMatricula, Carrera (Marcados con *)");
        container.add(this.ingresar);
        container.add(this.ingresoNombre);
        container.add(this.ingresoApellido);
        container.add(this.ingresoDNI);
        container.add(this.ingresoNumeroMatricula);
        container.add(this.carrera);
        container.add(this.ingresoDomicilio);
        container.add(this.ingresoLocalidad);
        container.add(this.ingresoProvincia);
        container.add(this.ingresoPaisDeResidencia);
        container.add(this.ingresoCorreoElectronico);
        container.add(this.ingresoFechaInscripcion);
        container.add(this.ingresoFechaNacimiento);
        container.add(obligatorios);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IngresarAlumnoActionListener(IngresarAlumno.this).actionPerformed(e);
            }
        };
        Enter enter= new Enter(ingresar,action);
    }

    public JTextFieldAdaptado getIngresoNombre() {
        return ingresoNombre;
    }

    public JTextFieldAdaptado getIngresoApellido() {
        return ingresoApellido;
    }

    public JTextFieldAdaptado getIngresoDNI() {
        return ingresoDNI;
    }

    public JTextFieldAdaptado getIngresoNumeroMatricula() {
        return ingresoNumeroMatricula;
    }

    public JComboBox getCarrera() {
        return carrera;
    }

    public JTextFieldAdaptado getIngresoDomicilio() {
        return ingresoDomicilio;
    }

    public JTextFieldAdaptado getIngresoLocalidad() {
        return ingresoLocalidad;
    }

    public JTextFieldAdaptado getIngresoProvincia() {
        return ingresoProvincia;
    }

    public JTextFieldAdaptado getIngresoPaisDeResidencia() {
        return ingresoPaisDeResidencia;
    }

    public JTextFieldAdaptado getIngresoCorreoElectronico() {
        return ingresoCorreoElectronico;
    }

    public JTextFieldAdaptado getIngresoFechaNacimiento() {
        return ingresoFechaNacimiento;
    }

    public JTextFieldAdaptado getIngresoFechaInscripcion() {
        return ingresoFechaInscripcion;
    }

    public JButton getIngresar() {
        return ingresar;
    }

    public Frame getFrame() {
        return frame;
    }

}
