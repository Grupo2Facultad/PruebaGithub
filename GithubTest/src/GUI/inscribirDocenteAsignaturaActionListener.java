/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Asignatura;
import githubtest.Docente;
import githubtest.Rol;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class inscribirDocenteAsignaturaActionListener implements ActionListener {

    private JButton inscribir;
    private JTextFieldAdaptado legajo,
            codigoAsig,
            dedicacion,
            cargo,
            fechaIngreso,
            fechaFinal;
    private Frame frame;

    public class Inscribir implements ActionListener {

        private Asignatura seleccionadaA;

        @Override
        public void actionPerformed(ActionEvent ae) {
            ArrayList<Asignatura> asignaturas = Main.registroDeCarreras.getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
            boolean e = false;
            for (Asignatura asignatura : asignaturas) {
                if (asignatura.getCodigo().equals(codigoAsig.getText())) {
                    boolean yaExiste = false;
                    for (Rol rol : asignatura.getEquipo().getRoles()) {
                        if (rol.getDocente().getNumeroLegajo().equals(legajo.getText())) {
                            yaExiste = true;
                        }
                    }
                    if (!yaExiste) {
                        e = true;
                        seleccionadaA = asignatura;
                        Set<Docente> profesores = asignatura.getCarrera().getDocentes();
                        boolean t = false;
                        for (Docente profesore : profesores) {
                            t = true;
                            boolean i = false;
                            if (profesore.getNumeroLegajo().equals(legajo.getText())) {
                                i = true;
                                asignatura.getEquipo().getRoles().add(new Rol(profesore, dedicacion.getText(), cargo.getText(), fechaIngreso.getText(), fechaFinal.getText()));
                                JOptionPane.showMessageDialog(null, "Operacion Exitosa");
                            }
                            if (!i) {
                                JOptionPane.showMessageDialog(null, "Ese Docente No Dicta En Esa Carrera");
                            }
                        }
                        if (!t) {
                            JOptionPane.showMessageDialog(null, "Numero de Matricula Invalido");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ese Docente ya dicta en esa Asignatura");
                    }
                }
            }
            if (!e) {
                JOptionPane.showMessageDialog(null, "Codigo Invalido");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        frame = new Frame("Ingreso De Docente",inscribir);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(250, 200, 650, 450);
        Container container = frame.getContentPane();
        container.setLayout(null);
        this.inscribir = new JButton("Ingresar");
        inscribir.setBounds(270, 300, 120, 30);
        legajo = new JTextFieldAdaptado("Matricula");
        legajo.setBounds(100, 100, 120, 25);
        cargo = new JTextFieldAdaptado("Cargo");
        cargo.setBounds(270, 100, 120, 25);
        dedicacion = new JTextFieldAdaptado("Dedicacion");
        dedicacion.setBounds(430, 100, 120, 25);
        codigoAsig = new JTextFieldAdaptado("Codigo de Asignatura");
        codigoAsig.setBounds(100, 200, 120, 25);
        fechaIngreso = new JTextFieldAdaptado("Fecha de Ingreso");
        fechaIngreso.setBounds(270, 200, 120, 25);
        fechaFinal = new JTextFieldAdaptado("Fecha de Final");
        fechaFinal.setBounds(430, 200, 120, 25);
        container.add(legajo);
        container.add(codigoAsig);
        container.add(fechaIngreso);
        container.add(fechaFinal);
        container.add(dedicacion);
        container.add(cargo);
        container.add(inscribir);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new inscribirDocenteAsignaturaActionListener.Inscribir().actionPerformed(e);
            }
        };
        Enter enter = new Enter(inscribir, action);
    }
}
