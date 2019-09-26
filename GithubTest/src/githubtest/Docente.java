
package githubtest;

import java.time.LocalDate;
public class Docente extends Persona {
   private int numeroLegajo;
   private LocalDate ingresoADocencia;

    public Docente(int numeroLegajo, LocalDate ingresoADocencia, String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
        this.numeroLegajo = numeroLegajo;
        this.ingresoADocencia = ingresoADocencia;
    }

    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public LocalDate getIngresoADocencia() {
        return ingresoADocencia;
    }

    public void setIngresoADocencia(LocalDate ingresoADocencia) {
        this.ingresoADocencia = ingresoADocencia;
    }


    @Override
    public String toString() {
        return "Docente{" + "numeroLegajo=" + numeroLegajo + ", ingresoADocencia=" + ingresoADocencia + '}';
    }


 
    
    
}
