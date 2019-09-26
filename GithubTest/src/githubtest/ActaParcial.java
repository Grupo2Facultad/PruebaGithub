/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanc
 */
public class ActaParcial extends Acta{
    
    

//    public List<Alumno> getHabilitados(Carrera carrera, PlanDeEstudio planDeEstudio, Asignatura asignatura,PeriodoLectivoConAño periodo,int numeroDeParcial) {
//        ArrayList<PlanDeEstudio> planes=(ArrayList)carrera.getPlanDeEstudio();
//        for (PlanDeEstudio plane : planes) {
//            if (plane.equals(planDeEstudio)){
//                ArrayList<Asignatura> asignaturas= plane.getAsignaturas();
//                for (Asignatura asignatura1 : asignaturas) {
//                    if (asignatura1.equals(asignatura)){
//                        
//                    }
//                }
//            }
//        }
//    }
    //No Listo
    public boolean verificarParcialAnterior () {
        return false;
    }

    @Override
    public void imprimirActa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
