
package githubtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *Contiene un listado con todos los alumnos y sus respectivas notas
 * @author Alumno
 */
public class TrabajoPractico {
    private List<TrabajoDeAlumno> notasIndividuales;

    /**
     *
     */
    public TrabajoPractico() {
        this.notasIndividuales = new ArrayList<>()  ;
    }

    /**
     *
     * @return Un listado con las notas de los trabajos de los alumnos
     */
    public List<TrabajoDeAlumno> getNotasIndividuales() {
        return notasIndividuales;
    }

    /**
     *
     * @param notasIndividuales
     */
    public void setNotasIndividuales(List<TrabajoDeAlumno> notasIndividuales) {
        this.notasIndividuales = notasIndividuales;
    }

    /**
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.notasIndividuales);
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
        final TrabajoPractico other = (TrabajoPractico) obj;
        if (!Objects.equals(this.notasIndividuales, other.notasIndividuales)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con caracteristicas de un trabajo practico
     */
    @Override
    public String toString() {
        return "TrabajoPractico{" + "notasIndividuales=" + notasIndividuales + '}';
    }
    
}
