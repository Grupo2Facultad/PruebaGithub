
package githubtest;

import java.time.LocalDate;

/**
 *
 * @author Alumno
 */
public class Docente extends Persona {
   private String  numeroLegajo;
   //No necesita ser LcoalDate, no se utiliza para nada
   private String  ingresoADocencia;

    /**
     *
     * @param numeroLegajo
     * @param ingresoADocencia
     * @param nombre
     * @param apellido
     * @param DNI
     */
    public Docente(String  numeroLegajo, String  ingresoADocencia, String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
        this.numeroLegajo = numeroLegajo;
        this.ingresoADocencia = ingresoADocencia;
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @param DNI
     */
    public Docente(String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
    }
    
    /**
     *
     * @return El numero de legajo
     */
    public String  getNumeroLegajo() {
        return numeroLegajo;
    }

    /**
     *
     * @param numeroLegajo
     */
    public void setNumeroLegajo(String  numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    /**
     *
     * @return El ingreso a la docencia
     */
    public String  getIngresoADocencia() {
        return ingresoADocencia;
    }

    /**
     *
     * @param ingresoADocencia
     */
    public void setIngresoADocencia(String  ingresoADocencia) {
        this.ingresoADocencia = ingresoADocencia;
    }

    /**
     *
     * @return Una cadena de caracteres con una caracteristica del docente
     */
    @Override
    public String toString() {
        return super.toString()+"Docente{" + "numeroLegajo=" + numeroLegajo + '}';
    }


   


 
    
    
}
