
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
private int numeroMatricula;
private ArrayList<Cursada> cursadas;  

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

    public void InscribirseAAsignaturaComoRegular(Asignatura ag, int año) {
        ArrayList<Carrera> carreras = RegistroDeCarreras.getCarreras();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanDeEstudio();
            for (PlanDeEstudio plan : planes) {
                if (plan.getFechaDeImplementacion().getYear() < año && plan.getFechadeVigencia().getYear() > año) {
                    ArrayList<Asignatura> a = plan.getAsignaturas();
                    for (Asignatura asignatura : a) {
                        if (ag.equals(asignatura)) {
                            Cursada i = new Cursada(LocalDate.now(), new PeriodoLectivoConAño(ag.getPeriodoLectivo(), año), this, asignatura, true);
                            asignatura.getCursantes().add(i);

                        }
                    }
                }
            }
        }
    }
    public void InscribirseAAsignaturaComoLibre(Asignatura ag,int año) {
        ArrayList<Carrera> carreras = RegistroDeCarreras.getCarreras();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanDeEstudio();
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
    public void DarseDeBaja(Asignatura ag) {
        ArrayList<Carrera> carreras = RegistroDeCarreras.getCarreras();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanDeEstudio();
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

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
        
    

    
}
