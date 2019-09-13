
package githubtest;
import java.time.LocalDate;

public class Alumno extends Persona{

private String domicilio,
        localidad,
        provincia,
        paisDeResidencia,
        correoElectronico;
private LocalDate fechaNacimiento,
        fechaInscripcion;
private int numeroMatricula;

    public Alumno(String domicilio, String localidad, String provincia, String paisDeResidencia, String correoElectronico, LocalDate fechaNacimiento, LocalDate fechaInscripcion, int numeroMatricula, String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.paisDeResidencia = paisDeResidencia;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInscripcion = fechaInscripcion;
        this.numeroMatricula = numeroMatricula;
    }

    public void Inscribirse() {
        
    }
    public void DarseDeBaja() {
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.numeroMatricula;
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
        final Alumno other = (Alumno) obj;
        if (this.numeroMatricula != other.numeroMatricula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumno{" + "domicilio=" + domicilio + ", localidad=" + localidad + ", provincia=" + provincia + ", paisDeResidencia=" + paisDeResidencia + ", correoElectronico=" + correoElectronico + ", fechaNacimiento=" + fechaNacimiento + ", fechaInscripcion=" + fechaInscripcion + ", numeroMatricula=" + numeroMatricula + '}';
    }
    
}
