
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
     * Constructor totalmente parametrizado de la clase asignatura
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
     */
    public List<Examen>  getExamenes() {
        return examenes;
    }

    /**
     *
     * @return
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
    private void generarBitacora(){
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,1),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,2),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,3),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,4),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,5),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,6),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,7),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,8),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,9),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,10),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,11),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,12),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,13),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,14),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,17),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,18),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,19),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,20),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,21),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,24),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,25),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,27),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),3,30),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),4,12),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),4,13),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),4,14),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),4,15),"tema"));
        this.bitacora.getBitacorasDiarias().add(new BitacoraDiaria(LocalDate.of(this.periodoLectivo.getAño(),4,16),"tema"));
    }
    private  void generarPracticos() {
        getListadoTrabajosPracticos().add(new TrabajoPractico());
        getListadoTrabajosPracticos().add(new TrabajoPractico());
        getListadoTrabajosPracticos().add(new TrabajoPractico());
        getListadoTrabajosPracticos().add(new TrabajoPractico());
        getListadoTrabajosPracticos().add(new TrabajoPractico());
    }

    /**
     *
     * @return
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
     * @return
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
     * @return
     */
    @Override
    public String toString() {
        return nombre + "{codigo=" + codigo + "}";
    }

   


  
  
}
