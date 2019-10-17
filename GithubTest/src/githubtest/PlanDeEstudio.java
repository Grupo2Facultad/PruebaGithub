package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Alumno
 */
public class PlanDeEstudio {

    private LocalDate fechaDeImplementacion,
            fechadeVigencia;
    private Carrera carrera;
    private int añosCarrera;
    private ArrayList<Asignatura> Asignaturas;

    /**
     *
     * @param fechaDeImplementacion
     * @param fechadeVigencia
     * @param carrera
     * @param añosCarrera
     */
    public PlanDeEstudio(LocalDate fechaDeImplementacion, LocalDate fechadeVigencia, Carrera carrera, int añosCarrera) {
        this.fechaDeImplementacion = fechaDeImplementacion;
        this.fechadeVigencia = fechadeVigencia;
        this.carrera = carrera;
        this.añosCarrera = añosCarrera;
        this.Asignaturas = new ArrayList<>();
    }

    /**
     *
     * @return La fecha de implementacion del plan de estudio
     */
    public LocalDate getFechaDeImplementacion() {
        return fechaDeImplementacion;
    }

    /**
     *
     * @param fechaDeImplementacion
     */
    public void setFechaDeImplementacion(LocalDate fechaDeImplementacion) {
        this.fechaDeImplementacion = fechaDeImplementacion;
    }

    /**
     *
     * @return La fecha de vigencia del plan
     */
    public LocalDate getFechadeVigencia() {
        return fechadeVigencia;
    }

    /**
     *
     * @param fechadeVigencia
     */
    public void setFechadeVigencia(LocalDate fechadeVigencia) {
        this.fechadeVigencia = fechadeVigencia;
    }

    /**
     *
     * @return La cantidad de años que tiene la carrera
     */
    public int getAñosCarrera() {
        return añosCarrera;
    }

    /**
     *
     * @param añosCarrera
     */
    public void setAñosCarrera(int añosCarrera) {
        this.añosCarrera = añosCarrera;
    }

    /**
     *
     * @return Las asignaturas que tiene el plan de estudio de la carrera
     */
    public ArrayList<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    /**
     *
     * @param Asignaturas
     */
    public void setAsignaturas(ArrayList<Asignatura> Asignaturas) {
        this.Asignaturas = Asignaturas;
    }

    /**
     *
     * @return La carrera a la que pertenece el plan
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     *
     * @param carrera
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.fechaDeImplementacion);
        hash = 29 * hash + Objects.hashCode(this.fechadeVigencia);
        hash = 29 * hash + Objects.hashCode(this.carrera);
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

    /**
     * 
     * @return Una cadena de caracteres con las caracteristicas del plan
     */
    @Override
    public String toString() {
        return "PlanDeEstudio{" + "fechaDeImplementacion=" + fechaDeImplementacion + ", fechadeVigencia=" + fechadeVigencia + ", carrera=" + carrera + ", a\u00f1osCarrera=" + añosCarrera + ", Asignaturas=" + Asignaturas + '}';
    }
    
    
   
}
