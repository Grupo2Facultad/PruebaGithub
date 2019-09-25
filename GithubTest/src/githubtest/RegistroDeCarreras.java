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
            if (carrera1.getNombre().equals(nombreCarrera)
                    && carrera1.getPlanDeEstudio().getFechaDeImplementacion().isBefore(fechaParaPlanDeEstudio)
                    && carrera1.getPlanDeEstudio().getFechadeVigencia().isAfter(fechaParaPlanDeEstudio)) {
                e++;
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

    public static List<Asignatura> getAsigPorDNI(Asignatura a, String DNI) {
        ArrayList<Asignatura> asignaturas=new ArrayList<Asignatura>();    
        for (Carrera carrera : carreras) {
            ArrayList<Asignatura> b= carrera.getPlanDeEstudio().getAsignaturas();
            for (Asignatura asignatura : b) {
                ArrayList<Regimen> k= (ArrayList) asignatura.getCursantes();  
                for (Regimen regimen : k) {
                    if (regimen.getAlumno().getDNI().equals(DNI)){
                        asignaturas.add(asignatura);
                    }
                }
            }
        }
        return asignaturas;
    }
    public static String getDocentesAsignatura(Asignatura ag){
        for (Carrera carrera : carreras) {
            ArrayList<Asignatura> b= carrera.getPlanDeEstudio().getAsignaturas();
            for (Asignatura asignatura : b) {
                if(ag.equals(asignatura)){
                    return asignatura.getEquipo().toString();
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
