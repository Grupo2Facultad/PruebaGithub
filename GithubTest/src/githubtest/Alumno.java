
package githubtest;
import java.time.LocalDate;
import java.util.ArrayList;

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
    public void InscribirseAAsignaturaComoRegular(Asignatura ag,RegistroDeCarreras registro) {
        ArrayList<Carrera> carreras = registro.getCarreras();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanesDeEstudio();
            for (PlanDeEstudio plan : planes) {
                if (plan.getFechaDeImplementacion().getYear() < ag.getPeriodoLectivo().getAño() && plan.getFechadeVigencia().getYear() > ag.getPeriodoLectivo().getAño()) {
                    ArrayList<Asignatura> a = plan.getAsignaturas();
                    for (Asignatura asignatura : a) { 
                        if (ag.equals(asignatura)) {
                            Cursada i = new Cursada(LocalDate.now(), new PeriodoLectivoConAño(ag.getPeriodoLectivo().getPeriodoLectivo(), ag.getPeriodoLectivo().getAño()), this, asignatura, true);
                            asignatura.getCursantes().add(i);

                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param ag
     * @param año
     * @param registro
     */
    public void InscribirseAAsignaturaComoLibre(Asignatura ag,int año,RegistroDeCarreras registro) {
        ArrayList<Carrera> carreras = registro.getCarreras();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanesDeEstudio();
            for (PlanDeEstudio plan : planes) {
                if (plan.getFechaDeImplementacion().getYear() < año && plan.getFechadeVigencia().getYear() > año) {
                    ArrayList<Asignatura> a = plan.getAsignaturas();
                    for (Asignatura asignatura : a) {
                        if (ag.equals(asignatura)) {
                            Regimen i = new Regimen(this, asignatura, false);
                            asignatura.getCursantes().add(i);
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param ag
     * @param registro
     */
    public void DarseDeBaja(Asignatura ag,RegistroDeCarreras registro) {
        ArrayList<Carrera> carreras = registro.getCarreras();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanesDeEstudio();
            for (PlanDeEstudio plan : planes) {
                ArrayList<Asignatura> a = plan.getAsignaturas();
                for (Asignatura asignatura : a) {
                    if (ag.equals(asignatura)) {
                        ArrayList<Regimen> r = (ArrayList) asignatura.getCursantes();
                        for (Regimen regimen : r) {
                            if (regimen.getAlumno().equals(this)) {
                                r.remove(regimen);
                            }
                        }
                    }
                }
            }
        }
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
