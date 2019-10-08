/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import GUI.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class ActaFinal extends Acta{
    private boolean cerrada;

    public ActaFinal( Examen examen) {
        super(examen);
        this.cerrada = false;
    }

    public boolean isCerrada() {
        return cerrada;
    }

    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }
  
    public void cerrarActa() {
        boolean existen=existenDocentes();
        System.out.println("Existen?"+existen);
        if(existen){
            cerrada=true;
        }
        else{
            cerrada=false;
            JOptionPane.showMessageDialog(null,"Por lo menos un Docente es invalido");
        }
       
    }
   private  boolean existenDocentes() {
        boolean existen=true;
        Final fin=(Final)super.getExamen();
        ArrayList<DocenteExamen>docentes=(ArrayList)fin.getDocenteExamen(); 
        if(docentes.size()<3){
        existen=false;
        }
        for (DocenteExamen docentex : docentes) {
            boolean existe=false;
          Docente doc=docentex.getDocente();
            System.out.println("El profesor es"+doc);
           List<Carrera>carreras=Main.getRegistroDeCarreras().getCarreras();
            for (Carrera carrera1 : carreras) {
                Set<Docente>profesores=carrera1.getDocentes();
                for (Docente profesor : profesores) {
                    if(profesor.equals(doc)){
                        existe=true;
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
     System.out.println("Cerrada?"+cerrada);
     if (cerrada){
         JOptionPane.showMessageDialog(null,super.toString());
     }
    }
}
