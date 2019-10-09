
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Carrera {
   private String nombre;
   private int codigo;
   private LocalDate fechaCreacion;
   private int cantidadAños;
   private List<PlanDeEstudio> planesDeEstudio;
   private Set<Alumno> alumnos;
   private Set<Docente> docentes;

    public Carrera(String nombre, int codigo, LocalDate fechaCreacion, int cantidadAños) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.cantidadAños = cantidadAños;
        this.planesDeEstudio = new ArrayList<>();
        this.alumnos = new HashSet<>()  ;
        this.docentes = new HashSet<>()  ;
    }
   
   
    public Set<Alumno> getAlumnos() {
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

    public void setPlanDeEstudio(List<PlanDeEstudio> planDeEstudio) {
        this.planesDeEstudio = planDeEstudio;
    }

    public List<PlanDeEstudio> getPlanesDeEstudio() {
        return planesDeEstudio;
    }

    public void setPlanesDeEstudio(List<PlanDeEstudio> planesDeEstudio) {
        this.planesDeEstudio = planesDeEstudio;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + this.codigo;
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
        final Carrera other = (Carrera) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }

  
    
}
