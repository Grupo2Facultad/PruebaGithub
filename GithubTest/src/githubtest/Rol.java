
package githubtest;

import java.time.LocalDate;

public class Rol {
    private Docente docente;
    private String dedicacion;
    private String cargo;
    private LocalDate fechaDeComienzo,
            fechaFinCargo;

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
    public String toString() {
        return "Rol{" + "docente=" + docente + ", dedicacion=" + dedicacion + ", cargo=" + cargo + ", fechaDeComienzo=" + fechaDeComienzo + ", fechaFinCargo=" + fechaFinCargo + '}';
    }
    
    
    
    
    
}
