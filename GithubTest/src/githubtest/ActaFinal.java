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
public class ActaFinal extends Acta{
    private boolean cerrada;

    public ActaFinal(boolean cerrada, Examen examen) {
        super(examen);
        this.cerrada = cerrada;
    }

    public boolean isCerrada() {
        return cerrada;
    }

    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }
  
    public void cerrarActa() {
        boolean existen=existenDocentes();
        if(existen){
            cerrada=true;
        }
        else{
            cerrada=false;
        }
       
    }
    public boolean existenDocentes() {
        boolean existen=true;
        Final fin=(Final)super.getExamen();
        ArrayList<DocenteExamen>docentes=(ArrayList)fin.getDocenteExamen();  
        Carrera carrera=fin.getAsignatura().getCarrera();
        List<PlanDeEstudio> planes=carrera.getPlanDeEstudio();
        for (DocenteExamen docentex : docentes) {
            boolean existe=false;
          Docente doc=docentex.getDocente();
            for (PlanDeEstudio plane : planes) {
                ArrayList<Asignatura> asig=plane.getAsignaturas();
                for (Asignatura asignatura : asig) {
                    ArrayList<Rol> roles=(ArrayList)asignatura.getEquipo().getRoles();
                    for (Rol rol : roles) {
                        if (doc.equals(rol.getDocente())){
                            existe=true;
                        }
                    }
                }
            }
            if(!existe){
                existen=false;
            }
        }
        return existen;
    }
    @Override
    public void imprimirActa() {
     //Esto va a cambiar cuando se pase a Swing
     if (cerrada){
         System.out.println(this);
     }
     else{
         System.out.println("todavia no esta cerrada");
     }
    }
    
}
