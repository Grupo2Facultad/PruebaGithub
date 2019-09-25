
package githubtest;

import java.time.LocalDate;
import java.util.List;

public class Carrera {
   private String nombre;
   private int codigo;
   private LocalDate fechaCreacion;
   private int cantidadAños;
   private List<PlanDeEstudio> planesDeEstudio;
   private List<Alumno> alumnos;

    public Carrera(String nombre, int codigo, LocalDate fechaCreacion, int cantidadAños, List<PlanDeEstudio> planesDeEstudio, List<Alumno> alumnos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.cantidadAños = cantidadAños;
        this.planesDeEstudio = planesDeEstudio;
        this.alumnos = alumnos;
    }
   
   
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCantidadAños() {
        return cantidadAños;
    }

    public void setCantidadAños(int cantidadAños) {
        this.cantidadAños = cantidadAños;
    }

    public List<PlanDeEstudio> getPlanDeEstudio() {
        return planesDeEstudio;
    }

    public void setPlanDeEstudio(List<PlanDeEstudio> planDeEstudio) {
        this.planesDeEstudio = planDeEstudio;
    }
    
}
