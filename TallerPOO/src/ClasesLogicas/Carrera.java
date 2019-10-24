
package ClasesLogicas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Alumno
 */
public class Carrera {
   private String nombre;
   private int codigo;
   private LocalDate fechaCreacion;
   private int cantidadAños;
   private List<PlanDeEstudio> planesDeEstudio;
   private Set<Alumno> alumnos;
   private Set<Docente> docentes;

    /**
     *
     * @param nombre
     * @param codigo
     * @param fechaCreacion
     * @param cantidadAños
     */
    public Carrera(String nombre, int codigo, LocalDate fechaCreacion, int cantidadAños) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.cantidadAños = cantidadAños;
        this.planesDeEstudio = new ArrayList<>();
        this.alumnos = new HashSet<>()  ;
        this.docentes = new HashSet<>()  ;
    }
   
    /**
     *
     * @return Un listado con los alumnos pertenecientes a la carrera
     */
    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     *
     * @return el nombre de la carrera
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return el codigo de la carrera
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return La fecha de creacion de la carrera
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     *
     * @param fechaCreacion
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     *
     * @return La cantidad de años que dura la carrera
     */
    public int getCantidadAños() {
        return cantidadAños;
    }

    /**
     *
     * @param cantidadAños
     */
    public void setCantidadAños(int cantidadAños) {
        this.cantidadAños = cantidadAños;
    }

    /**
     *
     * @param planDeEstudio
     */
    public void setPlanDeEstudio(List<PlanDeEstudio> planDeEstudio) {
        this.planesDeEstudio = planDeEstudio;
    }

    /**
     *
     * @return Los planes de estudio de la carrera
     */
    public List<PlanDeEstudio> getPlanesDeEstudio() {
        return planesDeEstudio;
    }

    /**
     *
     * @param planesDeEstudio
     */
    public void setPlanesDeEstudio(List<PlanDeEstudio> planesDeEstudio) {
        this.planesDeEstudio = planesDeEstudio;
    }

    /**
     *
     * @param alumnos
     */
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     *
     * @return Un listado con los docentes de la carrera
     */
    public Set<Docente> getDocentes() {
        return docentes;
    }

    /**
     *
     * @param docentes
     */
    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }
    
    /**
     *
     * @return el hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + this.codigo;
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
        final Carrera other = (Carrera) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadera de caracteres con la identidad de este objeto
     */
    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }

  
    
}
