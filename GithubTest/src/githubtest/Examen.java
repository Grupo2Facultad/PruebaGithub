/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;

/**
 *
 * @author juanc
 */
public abstract class Examen {
    private String periodo;
    private LocalDate fecha;
   private int horario;
   
   //sets-gets
   public abstract Acta HacerActa();// acta todavia no existe
   public abstract boolean controlarNotas();
    
    
    
}
