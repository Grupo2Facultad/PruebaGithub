
package githubtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *Listado de Docentes con sus respectivos roles
 * @author Alumno
 */
public class Equipo {
    private List<Rol> roles;

    /**
     *
     */
    public Equipo() {
        this.roles = new ArrayList<>();
    }
    
    /**
     *
     * @return Un listado con los roles del equipo docente
     */
    public List<Rol> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    /**
     *
     * @return el hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.roles);
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
        final Equipo other = (Equipo) obj;
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con los roles del equipo docente
     */
    @Override
    public String toString() {
        return "Equipo{" + "roles=" + roles + '}';
    }
    
    
    
    
}
