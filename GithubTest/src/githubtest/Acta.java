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
public abstract class Acta {
    private List<InscripcionAExamen> inscripciones;
    
    public abstract void imprimirActa();
    public  List<Alumno> getHabilitados(){
        return null;
    }  

    public List<InscripcionAExamen> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionAExamen> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
}
