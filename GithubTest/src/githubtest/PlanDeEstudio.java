package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class PlanDeEstudio {

    private LocalDate fechaDeImplementacion,
            fechadeVigencia;
    private int añosCarrera;

    private ArrayList<Asignatura> Asignaturas;

    public PlanDeEstudio(ArrayList<Asignatura> listAsignatura) {
        this.Asignaturas = listAsignatura;
    }
    public PlanDeEstudio(){}

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
    
    
   
}
