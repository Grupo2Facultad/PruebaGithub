
package githubtest;
import GUI.Main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author juanc
 */
public class Alumno extends Persona{
private String domicilio,
        localidad,
        provincia,
        paisDeResidencia,
        correoElectronico;
//No necesitan ser LocalDate, no se utilizan para ningun metodo
private String fechaNacimiento,
        fechaInscripcion;
private String  numeroMatricula;

    /**
     *
     * @param domicilio
     * @param localidad
     * @param provincia
     * @param paisDeResidencia
     * @param correoElectronico
     * @param fechaNacimiento
     * @param fechaInscripcion
     * @param numeroMatricula
     * @param nombre
     * @param apellido
     * @param DNI
     */
    public Alumno(String domicilio, String localidad, String provincia, String paisDeResidencia, String correoElectronico,
            String  fechaNacimiento, String  fechaInscripcion, String  numeroMatricula, String nombre, String apellido, String DNI) {
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
    
    /**
     *
     * @param nombre
     * @param apellido
     * @param DNI
     * @param numeroMatricula
     */
    public Alumno(String nombre, String apellido, String DNI,String  numeroMatricula) {
        super(nombre, apellido, DNI);
        this.numeroMatricula = numeroMatricula;
    }

    public Alumno(String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
    }
    
    
    /**
     *
     * @param ag
     * @param registro
     */
    public boolean  InscribirseAAsignaturaComoRegular(String Cod, RegistroDeCarreras registro) {
        boolean e=false;
        ArrayList<Asignatura> asignaturas = registro.getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(Cod)) {
                Cursada i = new Cursada(LocalDate.now(), new PeriodoLectivoConAño(asignatura.getPeriodoLectivo().getPeriodoLectivo(), asignatura.getPeriodoLectivo().getAño()), this, asignatura, true);
                asignatura.getCursantes().add(i);
                e=true;
            }
        }
        return e;
    }

    /**
     *
     * @param ag
     * @param año
     * @param registro
     */
    public boolean InscribirseAAsignaturaComoLibre(String Cod, RegistroDeCarreras registro) {
        boolean e=false;
        ArrayList<Asignatura> asignaturas = registro.getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(Cod)) {
                Regimen i = new Regimen(this, asignatura, false);
                asignatura.getCursantes().add(i);
                e=true;
            }
        }
        return e;
    }

    /**
     *
     * @param ag
     * @param registro
     */
    public boolean DarseDeBaja(String Cod, RegistroDeCarreras registro) {
        boolean e = false;
        ArrayList<Asignatura> asignaturas = registro.getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(Cod)) {
                List<Regimen> regimenes = asignatura.getCursantes();
                for (Regimen regimen : regimenes) {
                    if (regimen.getAlumno().equals(this)) {
                        regimenes.remove(regimen);
                    }
                }
            }
        }
        return e;
    }
    
    /**
     *
     * @return
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     *
     * @param domicilio
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     *
     * @return
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     *
     * @param localidad
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     *
     * @return
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     *
     * @param provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     *
     * @return
     */
    public String getPaisDeResidencia() {
        return paisDeResidencia;
    }

    /**
     *
     * @param paisDeResidencia
     */
    public void setPaisDeResidencia(String paisDeResidencia) {
        this.paisDeResidencia = paisDeResidencia;
    }

    /**
     *
     * @return
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     *
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     *
     * @return
     */
    public String  getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public Set<Carrera> carrerasQueCursa() {
        return Main.getRegistroDeCarreras().getCarreraPorDNI(super.getDNI());
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String  fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public String  getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     *
     * @param fechaInscripcion
     */
    public void setFechaInscripcion(String  fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     *
     * @return
     */
    public String  getNumeroMatricula() {
        return numeroMatricula;
    }

    /**
     *
     * @param numeroMatricula
     */
    public void setNumeroMatricula(String  numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+"Alumno{" + "numeroMatricula=" + numeroMatricula + '}';
    }
        
    

    
}
