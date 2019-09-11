
package githubtest;
import java.time.LocalDate;

public class Alumno extends Persona{
        private String pablo;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPaisDeResidencia() {
        return paisDeResidencia;
    }

    public void setPaisDeResidencia(String paisDeResidencia) {
        this.paisDeResidencia = paisDeResidencia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
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
