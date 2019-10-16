
package githubtest;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Alumno
 */
public class Rol {
    private Docente docente;
    private String dedicacion;
    private String cargo;
    private String fechaDeComienzo,
            fechaFinCargo;

    /**
     *
     * @param docente
     * @param dedicacion
     * @param cargo
     * @param fechaDeComienzo
     * @param fechaFinCargo
     */
    public Rol(Docente docente, String dedicacion, String cargo, String fechaDeComienzo, String fechaFinCargo) {
        this.docente = docente;
        this.dedicacion = dedicacion;
        this.cargo = cargo;
        this.fechaDeComienzo = fechaDeComienzo;
        this.fechaFinCargo = fechaFinCargo;
    }

    /**
     *
     * @return El docente que pertenece al rol
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     *
     * @param docente
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     *
     * @return La dedicacion del docente que pertenece al rol
     */
    public String getDedicacion() {
        return dedicacion;
    }

    /**
     *
     * @param dedicacion
     */
    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    /**
     *
     * @return El cargo al que pertenece el docente del Rol
     */
    public String getCargo() {
        return cargo;
    }

    /**
     *
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @return La fecha de comienzo del cargo del docente en el Rol
     */
    public String getFechaDeComienzo() {
        return fechaDeComienzo;
    }

    /**
     *
     * @param fechaDeComienzo
     */
    public void setFechaDeComienzo(String fechaDeComienzo) {
        this.fechaDeComienzo = fechaDeComienzo;
    }

    /**
     *
     * @return La fecha de fin del cargo del docente en el Rol
     */
    public String getFechaFinCargo() {
        return fechaFinCargo;
    }

    /**
     *
     * @param fechaFinCargo
     */
    public void setFechaFinCargo(String fechaFinCargo) {
        this.fechaFinCargo = fechaFinCargo;
    }

    /**
     *
     * @return hashCode
     */
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

    /**
     *
     * @param obj
     * @return La igualdad entre este objeto y otro del mismo tipo
     */
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

    /**
     *
     * @return Una cadena de caracteres con caracteristicas del Rol
     */
    @Override
    public String toString() {
        return "Rol{" + "docente=" + docente + ", dedicacion=" + dedicacion + ", cargo=" + cargo + ", fechaDeComienzo=" + fechaDeComienzo + ", fechaFinCargo=" + fechaFinCargo + '}';
    }
    
    
    
    
    
}
