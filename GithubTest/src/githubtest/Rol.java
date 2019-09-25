
package githubtest;

import java.time.LocalDate;

public class Rol {
    private Docente docente;
    private String dedicacion;
    private String cargo;
    private LocalDate fechaDeComienzo,
            fechaFinCargo;

    @Override
    public String toString() {
        return "Rol{" + "docente=" + docente + ", dedicacion=" + dedicacion + ", cargo=" + cargo + ", fechaDeComienzo=" + fechaDeComienzo + ", fechaFinCargo=" + fechaFinCargo + '}';
    }
    
    
    
    
    
}
