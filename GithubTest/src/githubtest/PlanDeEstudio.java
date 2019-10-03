package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public abstract class PlanDeEstudio {

    private LocalDate fechaDeImplementacion,
            fechadeVigencia;
    private Carrera carrera;
    private int añosCarrera;
    private ArrayList<Asignatura> Asignaturas;

    public PlanDeEstudio(LocalDate fechaDeImplementacion, LocalDate fechadeVigencia, Carrera carrera, int añosCarrera) {
        this.fechaDeImplementacion = fechaDeImplementacion;
        this.fechadeVigencia = fechadeVigencia;
        this.carrera = carrera;
        this.añosCarrera = añosCarrera;
        this.Asignaturas = new ArrayList<>();
    }

 

    public LocalDate getFechaDeImplementacion() {
        return fechaDeImplementacion;
    }

    public void setFechaDeImplementacion(LocalDate fechaDeImplementacion) {
        this.fechaDeImplementacion = fechaDeImplementacion;
    }

    public LocalDate getFechadeVigencia() {
        return fechadeVigencia;
    }

    public void setFechadeVigencia(LocalDate fechadeVigencia) {
        this.fechadeVigencia = fechadeVigencia;
    }

    public int getAñosCarrera() {
        return añosCarrera;
    }

    public void setAñosCarrera(int añosCarrera) {
        this.añosCarrera = añosCarrera;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> Asignaturas) {
        this.Asignaturas = Asignaturas;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.fechaDeImplementacion);
        hash = 29 * hash + Objects.hashCode(this.fechadeVigencia);
        hash = 29 * hash + Objects.hashCode(this.carrera);
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
        final PlanDeEstudio other = (PlanDeEstudio) obj;
        if (!Objects.equals(this.fechaDeImplementacion, other.fechaDeImplementacion)) {
            return false;
        }
        if (!Objects.equals(this.fechadeVigencia, other.fechadeVigencia)) {
            return false;
        }
        if (!Objects.equals(this.carrera, other.carrera)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlanDeEstudio{" + "fechaDeImplementacion=" + fechaDeImplementacion + ", fechadeVigencia=" + fechadeVigencia + ", carrera=" + carrera + ", a\u00f1osCarrera=" + añosCarrera + ", Asignaturas=" + Asignaturas + '}';
    }
    
    
   
}
