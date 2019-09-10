package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
//prubea branches;


public abstract class PlanDeEstudio {

    private LocalDate fechaDeImplementacion,
            fechadeVigencia;
    private int añosCarrera;
    /*Opciones para asignatura: 
    1)Hacer una clase AsignaturaAño que tenga como atributos una asignatura y un año, y tener como atributo de plan de Estudio un ArrayList<AsignaturaAño>
    2)Hacer una matriz con las asinaturas segun su respectivo año
    Mi favortita: 1;
    */
    private ArrayList<Asignatura> listAsignatura;

    public PlanDeEstudio(ArrayList<Asignatura> listAsignatura) {
        this.listAsignatura = listAsignatura;
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
    
    
   
}
