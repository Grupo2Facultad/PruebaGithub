
package githubtest;

import java.util.Objects;

public class TrabajoDeAlumno {
    private Alumno alumnoQueHizoElTrabajo;
    private int nota;

    public TrabajoDeAlumno(Alumno alumnoQueHizoElTrabajo, int nota) {
        this.alumnoQueHizoElTrabajo = alumnoQueHizoElTrabajo;
        this.nota = nota;
    }

    public Alumno getAlumnoQueHizoElTrabajo() {
        return alumnoQueHizoElTrabajo;
    }

    public void setAlumnoQueHizoElTrabajo(Alumno alumnoQueHizoElTrabajo) {
        this.alumnoQueHizoElTrabajo = alumnoQueHizoElTrabajo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.alumnoQueHizoElTrabajo);
        hash = 19 * hash + this.nota;
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
        final TrabajoDeAlumno other = (TrabajoDeAlumno) obj;
        if (this.nota != other.nota) {
            return false;
        }
        if (!Objects.equals(this.alumnoQueHizoElTrabajo, other.alumnoQueHizoElTrabajo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrabajoDeAlumno{" + "alumnoQueHizoElTrabajo=" + alumnoQueHizoElTrabajo + ", nota=" + nota + '}';
    }
    
}
