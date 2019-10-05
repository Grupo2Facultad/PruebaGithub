/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author juanc
 */
public class RegistroDeCarreras {

    private ArrayList<Carrera> carreras;

    public RegistroDeCarreras() {
        this.carreras = new ArrayList<>();
    }

    public int getAlumnosPorCarrera(String nombreCarrera, LocalDate fechaParaPeriodo){
        Set<Alumno> e = new HashSet();
        for (Carrera carrera1 : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera1.getPlanesDeEstudio();
            for (PlanDeEstudio plan : planes) {
                if (carrera1.getNombre().equals(nombreCarrera)
                        && plan.getFechaDeImplementacion().isBefore(fechaParaPeriodo)
                        && plan.getFechadeVigencia().isAfter(fechaParaPeriodo)) {
                    ArrayList<Asignatura> asignaturas = plan.getAsignaturas();
                    for (Asignatura asignatura : asignaturas) {
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
                }
            }
        int y = e.size();
        return y;
    }

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

    public Set<Asignatura> getAsigPorDNI(String DNI, LocalDate date) {
        Set<Asignatura> asignaturas = new HashSet<>();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanesDeEstudio();
            for (PlanDeEstudio plan : planes) {
                if (plan.getFechaDeImplementacion().isBefore(date) && plan.getFechadeVigencia().isAfter(date)) {
                    ArrayList<Asignatura> b = plan.getAsignaturas();
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
                    }
                }
            }

        
        return asignaturas;
    }
 
    public Set<Docente> getDocentesAsignatura(String nom, String cod, LocalDate date) {
        Set<Docente> docentes = new HashSet<>();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanesDeEstudio();
            for (PlanDeEstudio plane : planes) {
                if (plane.getFechaDeImplementacion().isBefore(date) && plane.getFechadeVigencia().isAfter(date)) {
                    ArrayList<Asignatura> asignaturas = plane.getAsignaturas();
                    for (Asignatura asignatura : asignaturas) {
                        if (asignatura.equals(new Asignatura(cod, nom))) {
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
                    }
                }
            }
        
        return docentes;
    }

    public List<Alumno> HabilitadosParcial(Asignatura asignatura, PeriodoLectivoEnum periodo, boolean isPrimeroTrueSegundoFalse) {
        //Una asignatura de por si pertenece a una carrera y plan de estudio,y se desarrolla en un año determinado
        ArrayList<Examen> examenes = (ArrayList) asignatura.getExamenes();
        for (Examen examene : examenes) {
            if (examene.getPeriodo().equals(periodo)){
            if (((Parcial)examene).isPrimeroTrueSegundoFalse()==isPrimeroTrueSegundoFalse){
                return examene.getActa().getHabilitados();
            }
            }
        }
        return null;
    }
    public List<Alumno> HabilitadosFinal(Asignatura asignatura,LocalDate fecha) {
        //Una asignatura de por si pertenece a una carrera y plan de estudio
        ArrayList<Examen>examenes= (ArrayList)asignatura.getExamenes();
        for (Examen examene : examenes) {
        if (examene instanceof Final){
            if (examene.getFecha().equals(fecha)){
                return examene.getActa().getHabilitados();
            }
        }
       
    }
         return null;
    }
    public  ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.carreras);
        return hash;
    }

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

    @Override
    public String toString() {
        return "RegistroDeCarreras{" + "carreras=" + carreras + '}';
    }



}
