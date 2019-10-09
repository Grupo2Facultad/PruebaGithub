
package githubtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TrabajoPractico {
    private List<TrabajoDeAlumno> notasIndividuales;

    public TrabajoPractico() {
        this.notasIndividuales = new ArrayList<>()  ;
    }

    public List<TrabajoDeAlumno> getNotasIndividuales() {
        return notasIndividuales;
    }

    public void setNotasIndividuales(List<TrabajoDeAlumno> notasIndividuales) {
        this.notasIndividuales = notasIndividuales;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.notasIndividuales);
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
        final TrabajoPractico other = (TrabajoPractico) obj;
        if (!Objects.equals(this.notasIndividuales, other.notasIndividuales)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrabajoPractico{" + "notasIndividuales=" + notasIndividuales + '}';
    }
    
}
