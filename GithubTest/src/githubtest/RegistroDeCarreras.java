/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *Listado de Todas las Carreras y metodos de uso general para generacion de informes, etc, que se beneficien del acceso a dicho listado
 * @author juanc
 */
public class RegistroDeCarreras {

    private ArrayList<Carrera> carreras;

    /**
     * Crea una lista con las carreras que posee la facultad
     */
    public RegistroDeCarreras() {
        this.carreras = new ArrayList<>();
    }

    /**
     *
     * @param nombreCarrera
     * @param fechaParaPeriodo
     * @return La cantidad de alumnos de la carrera pasada por parametro que se encuentran cursando alguna asignatura en la fecha dada
     * @throws java.lang.Exception
     */
    public int getAlumnosPorCarrera(String  nombreCarrera, LocalDate fechaParaPeriodo)throws Exception{
        boolean r=false;
        for (Carrera carrera : carreras) {
            if(carrera.getNombre().equals(nombreCarrera)){
               r=true;
            }
        }
        if(!r){
            JOptionPane.showMessageDialog(null,"Esa carrera no existe");
            throw new Exception("Esa carrera no existe");
        }
        Set<Alumno> e = new HashSet();
                    ArrayList<Asignatura> asignaturas = getAsignaturasPorFechaPlanDeEstudio(fechaParaPeriodo);
                    for (Asignatura asignatura : asignaturas){
                       if(asignatura.getCarrera().getNombre().equals(nombreCarrera)){
                        if (asignatura.getPeriodoLectivo().getAño() == fechaParaPeriodo.getYear()) {
                            if (fechaParaPeriodo.getMonthValue() <= 6) {
                                if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.primerCuatrimestre)) {
                                    ArrayList<Regimen> alumnos = (ArrayList) asignatura.getCursantes();
                                    for (Regimen alumno : alumnos) {
                                        e.add(alumno.getAlumno());
                                    }
                                }
                                } else {
                                    if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.segundoCuatrimestre)) {
                                        ArrayList<Regimen> alumnos = (ArrayList) asignatura.getCursantes();
                                        for (Regimen alumno : alumnos) {
                                            e.add(alumno.getAlumno());
                                        }
                                    }
                                }
                                if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.Anual)) {
                                    ArrayList<Regimen> alumnos = (ArrayList) asignatura.getCursantes();
                                    for (Regimen alumno : alumnos) {
                                        e.add(alumno.getAlumno());
                                    }
                                }
                            }
                        }
                    }
        int y = e.size();
        return y;
    }

    /**
     *
     * @param DNI
     * @return Las carreras que se encuentra cursando el alumno con el DNI pasado por parametro
     */

    public Set<Carrera> getCarreraPorDNI(String DNI) {
        Set<Carrera> carrerasPorDNI = new HashSet<>();
        for (Carrera carrera : this.carreras) {
            Set<Alumno> alumnos = carrera.getAlumnos();
            for (Alumno alumno : alumnos) {
                if (alumno.getDNI().equals(DNI)) {
                    carrerasPorDNI.add(carrera);
                }
            }
        }
        return carrerasPorDNI;
    }

    /**
     *
     * @param DNI
     * @param date
     * @return Las asignaturas que se encuentra cursando el alumno con el DNI pasado por parametro
     */
    public Set<Asignatura> getAsigPorDNI(String DNI, LocalDate date) {
        Set<Asignatura> asignaturas = new HashSet<>();
                    ArrayList<Asignatura> b = getAsignaturasPorFechaPlanDeEstudio(date);
                    for (Asignatura asignatura : b) {
                        if (asignatura.getPeriodoLectivo().getAño() == date.getYear()) {
                            if (date.getMonthValue() <= 6) {
                                if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.primerCuatrimestre)) {
                                    ArrayList<Regimen> alumnos = (ArrayList) asignatura.getCursantes();
                                    for (Regimen alumno : alumnos) {
                                        if (alumno.getAlumno().getDNI().equals(DNI)) {
                                            asignaturas.add(asignatura);
                                        }
                                    }
                                }
                                } else {
                                    if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.segundoCuatrimestre)) {
                                        ArrayList<Regimen> alumnos = (ArrayList) asignatura.getCursantes();
                                        for (Regimen alumno : alumnos) {
                                            if (alumno.getAlumno().getDNI().equals(DNI)) {
                                                asignaturas.add(asignatura);
                                            }
                                        }
                                    }
                                }
                                if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.Anual)) {
                                    ArrayList<Regimen> alumnos = (ArrayList) asignatura.getCursantes();
                                    for (Regimen alumno : alumnos) {
                                        if (alumno.getAlumno().getDNI().equals(DNI)) {
                                            asignaturas.add(asignatura);
                                        }
                                    }
                                }
                            }
                        } 
        return asignaturas;
    }
 
    /**
     *
     * @param cod
     * @param date
     * @return Los docentes que pertenecen a la asignatura pasada por parametro
     */
    public Set<Docente> getDocentesAsignatura(String cod, LocalDate date) {
        Set<Docente> docentes = new HashSet<>();
                    ArrayList<Asignatura> asignaturas = getAsignaturasPorFechaPlanDeEstudio(date);
                    boolean x=false;
                    for (Asignatura asignatura : asignaturas) {
                        if (asignatura.getCodigo().equals(cod)) {
                            x=true;
                            if (asignatura.getPeriodoLectivo().getAño() == date.getYear()) {
                                if (date.getMonthValue() <= 6) {
                                    if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.primerCuatrimestre)) {
                                        ArrayList<Rol> profesores = (ArrayList) asignatura.getEquipo().getRoles();
                                        for (Rol docente :profesores) {
                                            docentes.add(docente.getDocente());
                                        }
                                    }
                                    } else {
                                        if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.segundoCuatrimestre)) {
                                           ArrayList<Rol> profesores = (ArrayList) asignatura.getEquipo().getRoles();
                                        for (Rol docente : profesores) {
                                           docentes.add(docente.getDocente());
                                        }
                                        }
                                    }
                                    if (asignatura.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.Anual)) {
                                        ArrayList<Rol> profesores = (ArrayList) asignatura.getEquipo().getRoles();
                                        for (Rol docente : profesores) {
                                         docentes.add(docente.getDocente());
                                        }
                                    }
                                }
                            }
                        }
                    if(!x){
                        JOptionPane.showMessageDialog(null, "Codigo Invalido");
                        return null;
                    }
        return docentes;
    }

    /**
     *
     * @param fecha
     * @return Las asignaturas correspondientes a la fecha del plan de estudio pasado por parametro
     */
    public ArrayList<Asignatura>  getAsignaturasPorFechaPlanDeEstudio(LocalDate fecha) {
        ArrayList<Asignatura>asigPorFecha=new ArrayList<>();    
        for (Carrera carrera1 : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera1.getPlanesDeEstudio();
            for (PlanDeEstudio plan : planes) {
                if (plan.getFechaDeImplementacion().isBefore(fecha)
                        && plan.getFechadeVigencia().isAfter(fecha)) {
                    asigPorFecha.addAll(plan.getAsignaturas());
                }
            }
        }
        return asigPorFecha;
    }
    /**
     *
     * @return Las carreras
     */
    public  ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    /**
     *
     * @param carreras
     */
    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }   

    /**
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.carreras);
        return hash;
    }

    /**
     *
     * @param obj
     * @return La igualdad entre este objeto y otro del mismo tipo
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistroDeCarreras other = (RegistroDeCarreras) obj;
        if (!Objects.equals(this.carreras, other.carreras)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadera de caracteres con las caracteristicas del registro de carreras
     */
    @Override
    public String toString() {
        return "RegistroDeCarreras{" + "carreras=" + carreras + '}';
    }

    /**
     *
     * @param s
     * @return Los docnetes por legajo
     */
    public Docente getDocentesPorLegajo(JTextField s) {
        for (Carrera carrera : carreras) {
            Set<Docente>docentes = carrera.getDocentes();  
            System.out.println(docentes);
            for (Docente docente : docentes) {
                System.out.println("Llego aca");
                System.out.println(docente);
                if(docente.getNumeroLegajo().equals(s.getText())){
                    return docente;
                }
            }
        }
        return null;
    }



}
