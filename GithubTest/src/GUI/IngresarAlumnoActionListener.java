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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
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
            info.getFrame().setVisible(false);
        } catch (YaExisteException ex) {
            JOptionPane.showMessageDialog(null, "Ese alumno ya existe en esa Carrera");
        } catch (CodigoIDentificacionYaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (FaltaIngresoOCarreraInvalidaException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws Exception
     */
    public void check() throws Exception{
        boolean e=true;
        if (info.getIngresoApellido().getText().equals("Apellido*")||info.getIngresoApellido().getText().equals("")){
            e=false;
        }
        if (info.getIngresoNombre().getText().equals("Nombre*")||info.getIngresoNombre().getText().equals("")){
            e=false;
        }
        if (info.getIngresoDNI().getText().equals("DNI*")||info.getIngresoDNI().getText().equals("")){
            e=false;
        }
        if (info.getIngresoNumeroMatricula().getText().equals("Numero Matricula*")||info.getIngresoNumeroMatricula().getText().equals("")){
            e=false;
        }
        ArrayList<Carrera> carreras=Main.getRegistroDeCarreras().getCarreras();
        boolean t=false;
        for (Carrera carrera : carreras) {
            if(carrera.getNombre().equals(info.getIngresoCarrera().getText())){
                Set<Alumno>yaExiste=carrera.getAlumnos();
                for (Alumno alumno : yaExiste) {
                    if(alumno.equals(new Alumno (info.getIngresoNombre().getText(),info.getIngresoApellido().getText(),
                            info.getIngresoDNI().getText()))){
                        throw new YaExisteException("ya existe ese alumno");
                    }
                    if(alumno.getNumeroMatricula().equals(info.getIngresoNumeroMatricula().getText())){
                        throw new CodigoIDentificacionYaExisteException("Ese numero de Matricula ya existe");
                    }
                }
                t=true;
                seleccionada=carrera;
            }
        }
        if(!e||!t){
            throw new FaltaIngresoOCarreraInvalidaException("Falto Ingresar Algo o la Carrera es Invalida");
        }
 
    }
    
}
