/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanc
 */
public class RegistroDeCarreras {

    private static ArrayList<Carrera> carreras;


    public static int getAlumnosPorCarrera(String nombreCarrera, LocalDate fechaParaPlanDeEstudio) {
        int e = 0;
        for (Carrera carrera1 : carreras) {
            ArrayList<PlanDeEstudio> planes=(ArrayList) carrera1.getPlanDeEstudio();
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

    public  static ArrayList<Carrera>  getCarreraPorDNI(String DNI) {
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

    public static List<Asignatura> getAsigPorDNI(Asignatura a, String DNI, int año) {
        ArrayList<Asignatura> asignaturas=new ArrayList<Asignatura>();    
        for (Carrera carrera : carreras) {
         ArrayList<PlanDeEstudio> planes=(ArrayList) carrera.getPlanDeEstudio();
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
    public static String getDocentesAsignatura(Asignatura ag, int año) {
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanDeEstudio();
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

    public static ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public static void setCarreras(ArrayList<Carrera> carreras) {
        RegistroDeCarreras.carreras = carreras;
    }   

}
