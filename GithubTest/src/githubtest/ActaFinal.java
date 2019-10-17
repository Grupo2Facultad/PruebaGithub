/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import GUI.ImpresionListado;
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

    /**
     * @param examen
     */
    public ActaFinal( Examen examen) {
        super(examen);
        this.cerrada = false;
    }

    /**
     *
     * @return Retorna si está cerrado
     */
    public boolean isCerrada() {
        return cerrada;
    }

    /**
     *
     * @param cerrada
     */
    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }
  
    /**
     *Intenta cerrar el Acta
     */
    public void cerrarActa() {
        boolean existen=existenDocentesYNotas();
        System.out.println("Existen?"+existen);
        if(existen){
            cerrada=true;
        }
        else{
            cerrada=false;
            JOptionPane.showMessageDialog(null,"Por lo menos un Docente es invalido");
        }
       
    }
    /**
  *    Retorna un booleano sobre la existencia de los docentes que se declararon en el acta y chequea que se hayan puesto todas las notas 
*/
   private  boolean existenDocentesYNotas() {
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
        for (InscripcionAExamen habilitado : super.getHabilitados()) {
           if(habilitado.getNotaObtenida()==null){
               JOptionPane.showMessageDialog(null,"falta poner notas");
               existen=false;
               break;
           }
       }
        return existen;
    }
   /** 
    * Imprime el Acta
    */ 
   @Override
    public void imprimirActa() {
        String s="Acta del examen "+super.getExamen()+ "\n";
        for (InscripcionAExamen habilitado : super.getHabilitados()) {
           s=s+habilitado+"\n" ;
       }
     if (cerrada){
         ImpresionListado.Imprimir(s);
     }
    }
}
