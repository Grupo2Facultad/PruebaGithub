/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Acta;
import githubtest.ActaParcial;
import githubtest.Alumno;
import githubtest.Carrera;
import githubtest.InscripcionAExamen;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class IngresarAlumnoActionListener implements ActionListener {

    private final IngresarAlumno info;
    private Carrera seleccionada;


    /**
     *
     * @param info
     */
    public IngresarAlumnoActionListener(IngresarAlumno info) {

        this.info = info;
    }

    /**
     *
     * @param arg0
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            check();
            Alumno alumno = new Alumno(info.getIngresoDomicilio().getText(), info.getIngresoLocalidad().getText(),
                    info.getIngresoProvincia().getText(), info.getIngresoPaisDeResidencia().getText(), info.getIngresoCorreoElectronico().getText(),
                    info.getIngresoFechaNacimiento().getText(), info.getIngresoFechaInscripcion().getText(), info.getIngresoNumeroMatricula().getText(),
                    info.getIngresoNombre().getText(), info.getIngresoApellido().getText(), info.getIngresoDNI().getText());
            seleccionada.getAlumnos().add(alumno);
            JOptionPane.showMessageDialog(null, "operacion exitosa");
        } catch (YaExisteException ex) {
            JOptionPane.showMessageDialog(null, "Ese alumno ya existe en esa Carrera");
        } catch (CodigoIDentificacionYaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (FaltaIngresoOCarreraInvalidaException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (NoException e) {
            JOptionPane.showMessageDialog(null, "Operacion Cancelada");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @throws Exception
     */
    public void check() throws Exception {
        boolean e = true;
        if (info.getIngresoApellido().getText().equals("Apellido*") || info.getIngresoApellido().getText().equals("")) {
            e = false;
        }
        if (info.getIngresoNombre().getText().equals("Nombre*") || info.getIngresoNombre().getText().equals("")) {
            e = false;
        }
        if (info.getIngresoDNI().getText().equals("DNI*") || info.getIngresoDNI().getText().equals("")) {
            e = false;
        }
        if (info.getIngresoNumeroMatricula().getText().equals("Numero Matricula*") || info.getIngresoNumeroMatricula().getText().equals("")) {
            e = false;
        }
        ArrayList<Carrera> carreras = Main.getRegistroDeCarreras().getCarreras();
        boolean t = false;
        for (Carrera carrera : carreras) {
            if (carrera.getNombre().equals(info.getIngresoCarrera().getText())) {
                Set<Alumno> yaExiste = carrera.getAlumnos();
                for (Alumno alumno : yaExiste) {
                    Alumno definitivo = new Alumno(info.getIngresoNombre().getText(), info.getIngresoApellido().getText(),
                            info.getIngresoDNI().getText(),info.getIngresoNumeroMatricula().getText());
                    if (alumno.getNumeroMatricula().equals(info.getIngresoNumeroMatricula().getText())) {
                        JLabel label = new JLabel("Desea sobreescribir el alumno?");
                        JLabel alumnoViejo = new JLabel("Informacion del alumno" + alumno.toString());
                        JButton boton1 = new JButton("guardar");
                        JButton boton2 = new JButton("no");
                        Frame frame = new Frame("SobreEscribir Alumno");
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        boton1.addActionListener(new Guardar(carrera,alumno,definitivo, frame));
                        boton2.addActionListener(new No(frame));
                        Container container = frame.getContentPane();
                        container.setLayout(new FlowLayout());
                        container.add(alumnoViejo);
                        container.add(label);
                        container.add(boton1);
                        container.add(boton2);
                    }
                }
                t = true;
                seleccionada = carrera;
            }
        }
        if (!e || !t) {
            throw new FaltaIngresoOCarreraInvalidaException("Falto Ingresar Algo o la Carrera es Invalida");
        }

    }

    class Guardar implements ActionListener {

        private final Carrera carrera;
        private final Alumno alumno,
                definitivo;
        private final Frame frame;
        

        public Guardar(Carrera carrera, Alumno alumno,Alumno definitivo, Frame frame) {
            this.definitivo=definitivo;
            this.carrera = carrera;
            this.alumno = alumno;
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            HashSet<Alumno> alumnos = (HashSet)carrera.getAlumnos();
            for (Alumno alumno1 : alumnos) {
                if (alumno1.getDNI().equals(alumno.getDNI())) {
                    carrera.getAlumnos().remove(alumno);
                    carrera.getAlumnos().add(definitivo);
                    JOptionPane.showMessageDialog(null, "Guardado Exitosamente");
                    frame.setVisible(false);
                }
            }
        }
    }

    class No implements ActionListener {

        Frame frame;

        public No(Frame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
        }
    }

    class NoException extends Exception {

    }

}
