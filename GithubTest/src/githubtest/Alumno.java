
package githubtest;
import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona{
private String domicilio,
        localidad,
        provincia,
        paisDeResidencia,
        correoElectronico;
private LocalDate fechaNacimiento,
        fechaInscripcion;
private String  numeroMatricula;

    public Alumno(String domicilio, String localidad, String provincia, String paisDeResidencia, String correoElectronico, LocalDate fechaNacimiento, LocalDate fechaInscripcion, String  numeroMatricula, String nombre, String apellido, String DNI) {
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

    public Alumno(String nombre, String apellido, String DNI,String  numeroMatricula) {
        super(nombre, apellido, DNI);
        this.numeroMatricula = numeroMatricula;
    }
    

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

    public String  getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String  numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public String toString() {
        return super.toString()+"Alumno{" + "numeroMatricula=" + numeroMatricula + '}';
    }
        
    

    
}
