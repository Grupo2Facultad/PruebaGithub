
package githubtest;

import java.util.List;
import java.util.Objects;


 public class Asistencia {
    private Alumno alumno;
    private boolean asistio;

    public Asistencia(Alumno alumno, boolean asistio) {
        this.alumno = alumno;
        this.asistio = asistio;
    }

    public boolean isAsistio() {
        return asistio;
    }
 

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.alumno);
        hash = 11 * hash + (this.asistio ? 1 : 0);
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
        final Asistencia other = (Asistencia) obj;
        if (this.asistio != other.asistio) {
            return false;
        }
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "alumno=" + alumno + ", asistio=" + asistio + '}';
    }
    
}
