/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ClasesLogicas.Acta;
import ClasesLogicas.ActaParcial;
import ClasesLogicas.Alumno;
import ClasesLogicas.Carrera;
import ClasesLogicas.InscripcionAExamen;
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
    private boolean sobreescrito;


    /**
     *
     * @param info
     */
    public IngresarAlumnoActionListener(IngresarAlumno info) {
       this.sobreescrito=false;
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
            if(!sobreescrito){
            Alumno alumno = new Alumno(info.getIngresoDomicilio().getText(), info.getIngresoLocalidad().getText(),
                    info.getIngresoProvincia().getText(), info.getIngresoPaisDeResidencia().getText(), info.getIngresoCorreoElectronico().getText(),
                    info.getIngresoFechaNacimiento().getText(), info.getIngresoFechaInscripcion().getText(), info.getIngresoNumeroMatricula().getText(),
                    info.getIngresoNombre().getText(), info.getIngresoApellido().getText(), info.getIngresoDNI().getText());
            seleccionada.getAlumnos().add(alumno);
            }
            JOptionPane.showMessageDialog(null, "operacion exitosa");
        } catch (YaExisteException ex) {
            JOptionPane.showMessageDialog(null, "Ese alumno ya existe en esa Carrera");
        } catch (CodigoIDentificacionYaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (FaltaIngresoOCarreraInvalidaException e) {
            JOptionPane.showMessageDialog(null, e);
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
         if (!e) {
            throw new FaltaIngresoOCarreraInvalidaException("Falto Ingresar Algo");
        }
        for (Carrera carrera : carreras) {
            if (carrera.getNombre().equals(info.getCarrera().getSelectedItem())) {
                Set<Alumno> yaExiste = carrera.getAlumnos();
                for (Alumno alumno : yaExiste) {
                    Alumno definitivo = new Alumno(info.getIngresoNombre().getText(), info.getIngresoApellido().getText(),
                            info.getIngresoDNI().getText(),info.getIngresoNumeroMatricula().getText());
                    if (alumno.getNumeroMatricula().equals(definitivo.getNumeroMatricula())||
                         alumno.getDNI().equals(definitivo.getDNI())) {
                        JLabel label = new JLabel("Desea sobreescribir el alumno?");
                        JLabel alumnoViejo = new JLabel("Informacion del alumno" + alumno.toString());
                        JButton boton1 = new JButton("guardar");
                        Frame frame = new Frame("SobreEscribir Alumno");
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        boton1.addActionListener(new Guardar(carrera,alumno,definitivo,frame));
                        Container container = frame.getContentPane();
                        container.setLayout(new FlowLayout());
                        container.add(alumnoViejo);
                        container.add(label);
                        container.add(boton1);
                        break;
                    }
                }
                t = true;
                seleccionada = carrera;
            }
        }
        if (!t) {
            throw new FaltaIngresoOCarreraInvalidaException("Falto Ingresar Algo");
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
            Set<Alumno> alumnos =carrera.getAlumnos();
            for (Alumno alumno1 : alumnos) {
                if (alumno1.getDNI().equals(alumno.getDNI())||alumno1.getNumeroMatricula().equals(alumno.getNumeroMatricula())) {
                    if(!carrera.getAlumnos().remove(alumno)){
                        JOptionPane.showMessageDialog(null, "Fallo al remover");
                        return;
                    }
                    carrera.getAlumnos().add(definitivo);
                    JOptionPane.showMessageDialog(null, "Guardado Exitosamente");
                    frame.setVisible(false);
                    sobreescrito=true;
                    break;
                }
            }
        }
    }


}
