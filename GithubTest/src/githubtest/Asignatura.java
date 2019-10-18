
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alumno
 */
public class Asignatura {
  private String codigo,
          cargaHoraria;
  private String nombre;
  private PlanDeEstudio planDeEstudio;
  private Carrera carrera;
  private int añoDeCarreraAlQuePertenece;
  private PeriodoLectivoConAño periodoLectivo;
  private boolean promocional;
  private int cantidadParciales;
  private Equipo equipo;
  private BitacoraFinal bitacora;
  private List<TrabajoPractico> listadoTrabajosPracticos;
  private List<Examen> examenes;
  private List<Regimen>cursantes;

    /**
     *
     * @param codigo
     * @param cargaHoraria
     * @param nombre
     * @param planDeEstudio
     * @param carrera
     * @param añoDeCarreraAlQuePertenece
     * @param periodoLectivo
     * @param promocional
     * @param cantidadParciales
     * @param equipo
     * @param bitacora
     */
    public Asignatura(String  codigo, String cargaHoraria, String nombre, PlanDeEstudio planDeEstudio, Carrera carrera,
            int añoDeCarreraAlQuePertenece, PeriodoLectivoConAño periodoLectivo, boolean promocional,
            int cantidadParciales, Equipo equipo, BitacoraFinal bitacora) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.nombre = nombre;
        this.planDeEstudio = planDeEstudio;
        this.carrera = carrera;
        this.añoDeCarreraAlQuePertenece = añoDeCarreraAlQuePertenece;
        this.periodoLectivo = periodoLectivo;
        this.promocional = promocional;
        this.cantidadParciales = cantidadParciales;
        this.equipo = equipo;
        this.bitacora = bitacora;
        generarBitacora();
        this.listadoTrabajosPracticos = new ArrayList<>();
        generarPracticos();
        this.examenes =new ArrayList<>();
        this.cursantes = new ArrayList<>();
    }

    /**
     *
     * @param codigo
     * @param nombre
     
     */
    public Asignatura(String  codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     *
     * @return El codigo de la Asignatura
     */
    public String  getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String  codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return La carga horaria de la asignatura
     */
    public String  getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     *
     * @param cargaHoraria
     */
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     *
     * @return El nombre de la asignatura
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return El plan de estudio de la asignatura
     */
    public PlanDeEstudio getPlanDeEstudio() {
        return planDeEstudio;
    }

    /**
     *
     * @param planDeEstudio
     */
    public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }

    /**
     *
     * @return La carrera a la que pertenece la Asignatura
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     *
     * @param carrera
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     *
     * @return El año de carrera al que pertenece la Asignatura
     */
    public int getAñoDeCarreraAlQuePertenece() {
        return añoDeCarreraAlQuePertenece;
    }

    /**
     *
     * @param añoDeCarreraAlQuePertenece
     */
    public void setAñoDeCarreraAlQuePertenece(int añoDeCarreraAlQuePertenece) {
        this.añoDeCarreraAlQuePertenece = añoDeCarreraAlQuePertenece;
    }
    
    /**
     *
     * @return El periodo lectivo al que pertenece la Asignatura
     */
    public PeriodoLectivoConAño getPeriodoLectivo() {
        return periodoLectivo;
    }

    /**
     *
     * @param periodoLectivo
     */
    public void setPeriodoLectivo(PeriodoLectivoConAño periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    /**
     *
     * @return Si la asignatura es promocionable
     */
    public boolean isPromocional() {
        return promocional;
    }

    /**
     *
     * @param promocional
     */
    public void setPromocional(boolean promocional) {
        this.promocional = promocional;
    }

    /**
     *
     * @return La cantidad de parciales que posee la Asignatura
     */
    public int getCantidadParciales() {
        return cantidadParciales;
    }

    /**
     *
     * @param cantidadParciales
     */
    public void setCantidadParciales(int cantidadParciales) {
        this.cantidadParciales = cantidadParciales;
    }

    /**
     *
     * @return El equipo docente perteneciente a la asignatura
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     *
     * @param equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     *
     * @return La bitacora completa de una asignatura
     */
    public BitacoraFinal getBitacora() {
        return bitacora;
    }

    /**
     *
     * @param bitacora
     */
    public void setBitacora(BitacoraFinal bitacora) {
        this.bitacora = bitacora;
    }

    /**
     *
     * @return Un listado con los trabajos practicos de una asignatura
     */
    public List<TrabajoPractico> getListadoTrabajosPracticos() {
        return listadoTrabajosPracticos;
    }

    /**
     *
     * @param listadoTrabajosPracticos
     */
    public void setListadoTrabajosPracticos(List<TrabajoPractico> listadoTrabajosPracticos) {
        this.listadoTrabajosPracticos = listadoTrabajosPracticos;
    }

    /**
     *
     * @return Un listado con los examenes de la Asignatura
     */
    public List<Examen>  getExamenes() {
        return examenes;
    }

    /**
     *
     * @return Los alumnos cursantes de la Asignatura
     */
    public List<Regimen> getCursantes() {
        return cursantes;
    }

    /**
     *
     * @param cursantes
     */
    public void setCursantes(List<Regimen> cursantes) {
        this.cursantes = cursantes;
    }
/**
 * Crea bitacoras diarias con una cantidad de clases aproximada a la que corresponde segun el periodo en el que se desarrolla la asignatura
 */
    private void generarBitacora(){
        if(this.periodoLectivo.getPeriodoLectivo().equals(PeriodoLectivoEnum.primerCuatrimestre)){
            for (int i = 3; i < 6; i++) {
                for (int j = 1; j < 30; j++) {
                  this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),i,j),"tema"));
                }
            }
        }
        if(this.periodoLectivo.getPeriodoLectivo().equals(PeriodoLectivoEnum.segundoCuatrimestre)){
            for (int i = 7; i < 10; i++) {
                for (int j = 1; j < 30; j++) {
                  this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),i,j),"tema"));
                }
            }
        }
        if(this.periodoLectivo.getPeriodoLectivo().equals(PeriodoLectivoEnum.Anual)){
            for (int i = 3; i < 10; i++) {
                for (int j = 1; j < 30; j++) {
                  this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),i,j),"tema"));
                }
            }
        }
    }
    /**
     * Genera trabajos practicos 
     */
    private  void generarPracticos() {
        for (int i = 0; i <10; i++) {
            getListadoTrabajosPracticos().add(new TrabajoPractico());
        }
    }

    /**
     *
     * @return El hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     *
     * @param obj
     * @return La igualdad entre este objeto y otro del mismo tipo
     */
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
        final Asignatura other = (Asignatura) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con algunas de las caracteristicas de la Asignatura
     */
    @Override
    public String toString() {
        return nombre + "{codigo=" + codigo + "}";
    }

   


  
  
}
