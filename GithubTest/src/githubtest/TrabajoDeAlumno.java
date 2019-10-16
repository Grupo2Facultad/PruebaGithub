
package githubtest;

import java.util.Objects;

/**
 *
 * @author Alumno
 */
public class TrabajoDeAlumno {
    private Alumno alumnoQueHizoElTrabajo;
    private int nota;

    /**
     *
     * @param alumnoQueHizoElTrabajo
     * @param nota
     */
    public TrabajoDeAlumno(Alumno alumnoQueHizoElTrabajo, int nota) {
        this.alumnoQueHizoElTrabajo = alumnoQueHizoElTrabajo;
        this.nota = nota;
    }

    /**
     *
     * @return El alumno que realizó el trabajo
     */
    public Alumno getAlumnoQueHizoElTrabajo() {
        return alumnoQueHizoElTrabajo;
    }

    /**
     *
     * @param alumnoQueHizoElTrabajo
     */
    public void setAlumnoQueHizoElTrabajo(Alumno alumnoQueHizoElTrabajo) {
        this.alumnoQueHizoElTrabajo = alumnoQueHizoElTrabajo;
    }

    /**
     *
     * @return La nota del trabajo del alumno
     */
    public int getNota() {
        return nota;
    }

    /**
     *
     * @param nota
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.alumnoQueHizoElTrabajo);
        hash = 19 * hash + this.nota;
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
        final TrabajoDeAlumno other = (TrabajoDeAlumno) obj;
        if (this.nota != other.nota) {
            return false;
        }
        if (!Objects.equals(this.alumnoQueHizoElTrabajo, other.alumnoQueHizoElTrabajo)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con caracteristicas del trabajo del alumno
     */
    @Override
    public String toString() {
        return "TrabajoDeAlumno{" + "alumnoQueHizoElTrabajo=" + alumnoQueHizoElTrabajo + ", nota=" + nota + '}';
    }
    
}
