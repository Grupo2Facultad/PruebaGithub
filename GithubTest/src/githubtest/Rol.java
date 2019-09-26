
package githubtest;

import java.time.LocalDate;
import java.util.Objects;

public class Rol {
    private Docente docente;
    private String dedicacion;
    private String cargo;
    private LocalDate fechaDeComienzo,
            fechaFinCargo;

    public Rol(Docente docente, String dedicacion, String cargo, LocalDate fechaDeComienzo, LocalDate fechaFinCargo) {
        this.docente = docente;
        this.dedicacion = dedicacion;
        this.cargo = cargo;
        this.fechaDeComienzo = fechaDeComienzo;
        this.fechaFinCargo = fechaFinCargo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFechaDeComienzo() {
        return fechaDeComienzo;
    }

    public void setFechaDeComienzo(LocalDate fechaDeComienzo) {
        this.fechaDeComienzo = fechaDeComienzo;
    }

    public LocalDate getFechaFinCargo() {
        return fechaFinCargo;
    }

    public void setFechaFinCargo(LocalDate fechaFinCargo) {
        this.fechaFinCargo = fechaFinCargo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.docente);
        hash = 29 * hash + Objects.hashCode(this.dedicacion);
        hash = 29 * hash + Objects.hashCode(this.cargo);
        hash = 29 * hash + Objects.hashCode(this.fechaDeComienzo);
        hash = 29 * hash + Objects.hashCode(this.fechaFinCargo);
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
        final Rol other = (Rol) obj;
        if (!Objects.equals(this.dedicacion, other.dedicacion)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.docente, other.docente)) {
            return false;
        }
        if (!Objects.equals(this.fechaDeComienzo, other.fechaDeComienzo)) {
            return false;
        }
        if (!Objects.equals(this.fechaFinCargo, other.fechaFinCargo)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Rol{" + "docente=" + docente + ", dedicacion=" + dedicacion + ", cargo=" + cargo + ", fechaDeComienzo=" + fechaDeComienzo + ", fechaFinCargo=" + fechaFinCargo + '}';
    }
    
    
    
    
    
}
