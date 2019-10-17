
package githubtest;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alumno
 */
public class Asistencia {
    private Alumno alumno;
    private boolean asistio;
/**
 * @param alumno
 * @param asistio 
 */
    public Asistencia(Alumno alumno, boolean asistio) {
        this.alumno = alumno;
        this.asistio = asistio;
    }

 /**
  * 
  * @return Si el alumno asistió a clase
  */
    public boolean isAsistio() {
        return asistio;
    }
 
    /**
     *
     * @return Un alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     *
     * @param alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     *
     * @return Si el alumno asistió a clase
     */
    public boolean getAsistio() {
        return asistio;
    }

    /**
     *
     * @param asistio
     */
    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    /**
     *
     * @return El hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.alumno);
        hash = 11 * hash + (this.asistio ? 1 : 0);
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
        final Asistencia other = (Asistencia) obj;
        if (this.asistio != other.asistio) {
            return false;
        }
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con la identidad del objeto
     */
    @Override
    public String toString() {
        return "Asistencia{" + "alumno=" + alumno + ", asistio=" + asistio + '}';
    }
    
}
