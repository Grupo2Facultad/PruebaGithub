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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author juanc
 */
public class IngresarDocente implements ActionListener {

    private JTextFieldAdaptado ingresoNombre,
            ingresoApellido,
            ingresoDNI,
            ingresoNumeroLegajo,
            ingresoADocencia;
    private JComboBox carrera;
    private JLabel obligatorios;
    private JButton ingresar;
    private Frame frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        frame = new Frame("IngresoDeDocente");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(150, 100, 1200, 700);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        this.ingresar = new JButton("INGRESAR");
        this.ingresar.addActionListener(new IngresarDocenteActionListener(this));
        this.ingresoApellido = new JTextFieldAdaptado("Apellido*", 20);
        this.ingresoNombre = new JTextFieldAdaptado("Nombre*", 20);
        this.ingresoDNI = new JTextFieldAdaptado("DNI*", 15);
        this.ingresoNumeroLegajo = new JTextFieldAdaptado("Numero Legajo*", 15);
        carrera = new JComboBox<>();
        for (Carrera carrera1 : Main.getRegistroDeCarreras().getCarreras()) {
            carrera.addItem(carrera1.getNombre());
        }
        this.ingresoADocencia = new JTextFieldAdaptado("ingreso A Docencia");
        obligatorios = new JLabel("Campos Obligatorios: Apellido, Nombre,DNI,NumeroMatricula, Carrera (Marcados con *)");
        container.add(this.ingresar);
        container.add(this.ingresoNombre);
        container.add(this.ingresoApellido);
        container.add(this.ingresoDNI);
        container.add(this.ingresoNumeroLegajo);
        container.add(this.carrera);
        container.add(ingresoADocencia);
        container.add(obligatorios);

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

    public JTextFieldAdaptado getIngresoNumeroLegajo() {
        return ingresoNumeroLegajo;
    }


    public JTextFieldAdaptado getIngresoADocencia() {
        return ingresoADocencia;
    }

    public JComboBox getCarrera() {
        return carrera;
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

