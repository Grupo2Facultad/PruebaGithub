
package githubtest;

import java.time.LocalDate;
public class Docente extends Persona {
   private String  numeroLegajo;
   //No necesita ser LcoalDate, no se utiliza para nada
   private String  ingresoADocencia;

    public Docente(String  numeroLegajo, String  ingresoADocencia, String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
        this.numeroLegajo = numeroLegajo;
        this.ingresoADocencia = ingresoADocencia;
    }

    public Docente(String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
    }
    

    public String  getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(String  numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public String  getIngresoADocencia() {
        return ingresoADocencia;
    }

    public void setIngresoADocencia(String  ingresoADocencia) {
        this.ingresoADocencia = ingresoADocencia;
    }

    @Override
    public String toString() {
        return super.toString()+"Docente{" + "numeroLegajo=" + numeroLegajo + '}';
    }


   


 
    
    
}
