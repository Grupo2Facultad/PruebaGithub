/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.util.List;

/**
 *
 * @author juanc
 */
public class ActaParcial extends Acta{

    public List<Alumno> getHabilitados(Carrera carrera, PlanDeEstudio planDeEstudio, Asignatura asignatura,PeriodoLectivoConAño periodo,int numeroDeParcial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //No Listo
    public boolean verificarParcialAnterior () {
        return false;
    }

    @Override
    public void imprimirActa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
