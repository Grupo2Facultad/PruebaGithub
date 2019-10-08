
package githubtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
    private List<Rol> roles;

    public Equipo() {
        this.roles = new ArrayList<>();
    }
    

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.roles);
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
        final Equipo other = (Equipo) obj;
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Equipo{" + "roles=" + roles + '}';
    }
    
    
    
    
}
