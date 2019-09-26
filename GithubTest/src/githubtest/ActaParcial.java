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
    
    

public List<Alumno> getHabilitados(){
    ArrayList<Alumno> habilitados=new ArrayList<Alumno>();  
    for (InscripcionAExamen inscripcion : super.getInscripciones()) {
        if (inscripcion.isHabilitado()){
            habilitados.add(inscripcion.getAlumno());
        }
    }
    return habilitados;
}
    @Override
    public void imprimirActa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
