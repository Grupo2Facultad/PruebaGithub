
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
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.numeroLegajo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Docente other = (Docente) obj;
        if (this.numeroLegajo != other.numeroLegajo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Docente{" + "numeroLegajo=" + numeroLegajo + ", ingresoADocencia=" + ingresoADocencia + '}';
    }
    
    
}
