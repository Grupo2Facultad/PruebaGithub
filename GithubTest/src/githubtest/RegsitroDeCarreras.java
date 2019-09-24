/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class RegsitroDeCarreras {

    private ArrayList<Carrera> carreras;

    public RegsitroDeCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public int getAlumnosPorCarrera(String nombreCarrera, LocalDate fechaParaPlanDeEstudio) {
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

    public  ArrayList<Carrera>  getCarreraPorDNI(String DNI) {
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
}
