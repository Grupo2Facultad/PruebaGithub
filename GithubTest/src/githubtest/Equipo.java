
package githubtest;

import java.util.List;

public class Equipo {
    private List<Rol> roles;

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    
    
    @Override
    public String toString() {
        return "Equipo{" + "roles=" + roles + '}';
    }
    
    
    
    
}
