/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author juanc
 */
public class RegistroDeCarreras {

    private  ArrayList<Carrera> carreras;

    public RegistroDeCarreras() {
        this.carreras = new ArrayList<>()  ;
    }
     

    public  int getAlumnosPorCarrera(String nombreCarrera, LocalDate fechaParaPlanDeEstudio) {
        //Hay que mejorar para que considere Asignaturas  y no repita Alumnos
        int e = 0;
        for (Carrera carrera1 : carreras) {
            ArrayList<PlanDeEstudio> planes=(ArrayList) carrera1.getPlanesDeEstudio();
            for (PlanDeEstudio plan : planes) {
                  if (carrera1.getNombre().equals(nombreCarrera)
                    && plan.getFechaDeImplementacion().isBefore(fechaParaPlanDeEstudio)
                    && plan.getFechadeVigencia().isAfter(fechaParaPlanDeEstudio)) {
                e++;
            }
            }
          
        }
        return e;
    }

    public   ArrayList<Carrera>  getCarreraPorDNI(String DNI) {
        ArrayList<Carrera> carrerasPorDNI = new ArrayList<Carrera>();  
         for (Carrera carrera : carrerasPorDNI) {
             ArrayList<Alumno> alumnos=(ArrayList)carrera.getAlumnos();
             for (Alumno alumno : alumnos) {
                 if (alumno.getDNI().equals(DNI)){
                     carrerasPorDNI.add(carrera);
                 }
             }
        }
        return carrerasPorDNI; 
    } 

    public  List<Asignatura> getAsigPorDNI(Asignatura a, String DNI, int año) {
        ArrayList<Asignatura> asignaturas=new ArrayList<Asignatura>();    
        for (Carrera carrera : carreras) {
         ArrayList<PlanDeEstudio> planes=(ArrayList) carrera.getPlanesDeEstudio();
            for (PlanDeEstudio plan : planes) {
                if(plan.getFechaDeImplementacion().getYear() < año && plan.getFechadeVigencia().getYear() > año){
              ArrayList<Asignatura> b=plan.getAsignaturas();
            for (Asignatura asignatura : b) {
                ArrayList<Regimen> k= (ArrayList) asignatura.getCursantes();  
                for (Regimen regimen : k) {
                    if (regimen.getAlumno().getDNI().equals(DNI)&&((Cursada)regimen).getPeriodoLectivo().getAño()==año){
                        asignaturas.add(asignatura);
                    }
                }
            }
            }
            }
          
        }
        return asignaturas;
    }
    public  String getDocentesAsignatura(Asignatura ag, int año) {
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanesDeEstudio();
            for (PlanDeEstudio plane : planes) {
                if (plane.getFechaDeImplementacion().getYear() < año && plane.getFechadeVigencia().getYear() > año) {
                    ArrayList<Asignatura> b = plane.getAsignaturas();
                    for (Asignatura asignatura : b) {
                        if (ag.equals(asignatura)) {
                            return asignatura.getEquipo().toString();
                        }
                    }
                }
            }
        }
        return "error al buscar el equipo";
    }
    public List<Alumno> HabilitadosParcial(Asignatura asignatura,PeriodoLectivoEnum periodo, boolean isPrimeroTrueSegundoFalse) {
        //Una asignatura de por si pertenece a una carrera y plan de estudio,y se desarrolla en un año determinado
        ArrayList<Examen>examenes= (ArrayList)asignatura.getExamenes();
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
