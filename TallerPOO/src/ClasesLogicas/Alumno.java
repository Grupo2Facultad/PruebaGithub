
package ClasesLogicas;
import GUI.NoSeInscribioException;
import GUI.Main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;

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
            String fechaNacimiento, String fechaInscripcion, String numeroMatricula, String nombre, String apellido, String DNI) {
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
    public Alumno(String nombre, String apellido, String DNI, String numeroMatricula) {
        super(nombre, apellido, DNI);
        this.numeroMatricula = numeroMatricula;
    }

    public Alumno(String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
    }

    /**
     * Genera notas de los trabajos practicos y las asistencias en la clase Cursada, inscribe alumnos en la modalidad regular a las asignaturas 
     * @param Cod
     * @param registro
     * @return Booleano sobre si existe la materia en la que se desea inscribir al alumno
     * @throws NoInscritoException (Una excepcion en el caso de que el alumno no se encuentre cursando la carrera a la que pertenece la materia)
    
     */
    public boolean InscribirseAAsignaturaComoRegular(String Cod, RegistroDeCarreras registro)throws NoInscritoException{
        Random r = new Random();
        boolean e = false;
        ArrayList<Asignatura> asignaturas = registro.getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(Cod)) {
                if (asignatura.getPeriodoLectivo().getAño() == LocalDate.now().getYear()) {
                    Set<Carrera> carreras = carrerasQueCursa();
                    boolean w = false;
                    for (Carrera carrera : carreras) {
                        if (carrera.equals(asignatura.getCarrera())) {
                            w = true;
                        }
                    }
                    if (!w) {
                       throw new NoInscritoException("El alumno no esta cursando esa carrera");
                    }
                    Cursada i = new Cursada(LocalDate.now(), new PeriodoLectivoConAño(asignatura.getPeriodoLectivo().getPeriodoLectivo(),
                            asignatura.getPeriodoLectivo().getAño()), this, asignatura, true);
                    System.out.println(i);
                    asignatura.getCursantes().add(i);
                    ArrayList<TrabajoPractico> trabajos = (ArrayList) asignatura.getListadoTrabajosPracticos();
                    for (TrabajoPractico trabajo : trabajos) {
                        int y = r.nextInt(5) + 5;
                        System.out.println("nota" + y);
                        trabajo.getNotasIndividuales().add(new TrabajoDeAlumno(this, y));
                    }
                    ArrayList<BitacoraDiaria> bitacoras = (ArrayList) asignatura.getBitacora().getBitacorasDiarias();
                    for (BitacoraDiaria bitacora : bitacoras) {
                        boolean n;
                        int x = r.nextInt(10);
                        System.out.println(x);
                        if (x == 0) {
                            n = false;
                        } else {
                            n = true;
                        }
                        bitacora.getListadoAsistencias().add(new Asistencia(this, n));
                    }
                    e = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ese Codigo Corresponde a una Asignatura de Años Anteriores");
                }
            }
        }
        return e;
    }

    /**
     *Inscribe alumnos en modalidad libre a las asignaturas 
     * @param Cod
     * @param registro
     * @return Booleano sobre si existe la materia en la que se desea inscribir al alumno
     * @throws NoInscritoException (Una excepcion en el caso de que el alumno no se encuentre cursando la carrera a la que pertenece la materia)
     */
    public boolean InscribirseAAsignaturaComoLibre(String Cod, RegistroDeCarreras registro) throws NoInscritoException{
        boolean e = false;
        ArrayList<Asignatura> asignaturas = registro.getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(Cod)) {
                if (asignatura.getPeriodoLectivo().getAño() == LocalDate.now().getYear()) {
                    Set<Carrera> carreras = carrerasQueCursa();
                    boolean w = false;
                    for (Carrera carrera : carreras) {
                        if (carrera.equals(asignatura.getCarrera())) {
                            w = true;
                        }
                    }
                    if (!w) {
                      throw new NoInscritoException("El alumno no esta cursando esa carrera");
                    }
                    Regimen i = new Regimen(this, asignatura, false);
                    System.out.println(i);
                    asignatura.getCursantes().add(i);
                    e = true;
                }
                else{
                  JOptionPane.showMessageDialog(null, "Ese Codigo Corresponde a una Asignatura de Años Anteriores");
                }
            }
        }
        return e;
    }

    /**
     * Da de baja a un alumno de un examen
     * @param fecha
     * @param asignaturaCod
     * @throws NoSeInscribioException
     * @return Booleano que indica si la o peracion dar de baja a un alumno de un examen fue exitosa
     * 
     */
    public boolean DarseDeBaja(LocalDate fecha,String asignaturaCod)throws NoSeInscribioException {
       Asignatura asig=null;
        Examen exa=null;
        ArrayList<Asignatura> asignaturas=Main.getRegistroDeCarreras().getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
        for (Asignatura asignatura : asignaturas) {
              if(asignatura.getCodigo().equals(asignaturaCod)){
                  ArrayList<Examen> examenes=(ArrayList)asignatura.getExamenes();
                  for (Examen examen : examenes) {
                      if(examen.getFecha().equals(fecha)){
                          exa=examen;
                      }
                  }
              }
        }
        if(exa==null){
            JOptionPane.showMessageDialog(null,"Ese Examen no existe");
        }
        else{
           if(exa.getFecha().isAfter(LocalDate.now())){
            Acta acta=exa.getActa();
               for (InscripcionAExamen inscripcione : acta.getInscripciones()) {
                   if(inscripcione.getAlumno().equals(this)){
                       acta.getInscripciones().remove(inscripcione);
                       return true;
                   }
               }
                JOptionPane.showMessageDialog(null,"Ese alumno no se encuentra inscripto en ese examen");
           }
           else{
               JOptionPane.showMessageDialog(null,"Examen Viejo,no puede Darse de Baja");
           }
        }
        return false;
    }
    /**
     * @param libre
     * @param fecha
     * @param asignaturaCod
     * @return Booleano que indica si la operacion Inscribirse a examen fue exitosa
     * @throws GUI.NoSeInscribioException
     * 
     */
    public boolean InscibirseAExamen(LocalDate fecha,String asignaturaCod, boolean libre)throws NoSeInscribioException{
        Asignatura asig=null;
        Examen exa=null;
        ArrayList<Asignatura> asignaturas=Main.getRegistroDeCarreras().getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
        for (Asignatura asignatura : asignaturas) {
              if(asignatura.getCodigo().equals(asignaturaCod)){
                  ArrayList<Examen> examenes=(ArrayList)asignatura.getExamenes();
                  for (Examen examen : examenes) {
                      if(examen.getFecha().equals(fecha)){
                        exa = examen;
                    }
                }
            }
        }
        if (exa == null) {
            JOptionPane.showMessageDialog(null, "Ese Examen no existe");
        } else {
            if (exa.getFecha().isAfter(LocalDate.now())) {
                for (InscripcionAExamen inscripcione : exa.getActa().getInscripciones()) {
                    if (inscripcione.getAlumno().equals(this)) {
                        JOptionPane.showMessageDialog(null, "Ese alumno ya se encuentra inscripto a ese Examen");
                        return false;
                    }
                }
                System.out.println(exa);
                Acta acta = exa.getActa();
                    try {
                        acta.getInscripciones().add(new InscripcionAExamen(this, exa, libre));
                        return true;
                    } catch (NoSeInscribioException e) {
                        throw new NoSeInscribioException("no quedo habilitado");
                    }
            } else {
                JOptionPane.showMessageDialog(null, "Examen Viejo,no puede inscribirse");
            }
        }
        return false;
    }

    /**
     *
     * @return Domicilio
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
     * @return Localidad
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
     * @return Provincia
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
     * @return Pais de residencia
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
     * @return Correo Electronico
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
     * @return Fecha nacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * 
     * @return Las carreras que cursa un alumno
     */
    public Set<Carrera> carrerasQueCursa() {
        return Main.getRegistroDeCarreras().getCarreraPorDNI(super.getDNI());
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return La fecha de inscripcion a la carrera
     */
    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     *
     * @param fechaInscripcion 
     */
    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     *
     * @return El numero de matricula de un alumno
     */
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    /**
     *
     * @param numeroMatricula
     */
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    /**
     *
     * @return Los datos del alumno concatenados en un String
     */
    @Override
    public String toString() {
        return super.toString() + "Alumno{" + "numeroMatricula=" + numeroMatricula + '}';
    }

    public class NoInscritoException extends Exception {

        public NoInscritoException(String string) {
            super(string);
        }

    }

}
