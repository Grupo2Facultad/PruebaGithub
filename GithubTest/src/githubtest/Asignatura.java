
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
public class Asignatura {
  private String  codigo,
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

    public Asignatura(String  codigo, String cargaHoraria, String nombre, PlanDeEstudio planDeEstudio, Carrera carrera, int añoDeCarreraAlQuePertenece, PeriodoLectivoConAño periodoLectivo, boolean promocional, int cantidadParciales, Equipo equipo, BitacoraFinal bitacora) {
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

    public Asignatura(String  codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String  getCodigo() {
        return codigo;
    }

    public void setCodigo(String  codigo) {
        this.codigo = codigo;
    }

    public String  getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PlanDeEstudio getPlanDeEstudio() {
        return planDeEstudio;
    }

    public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getAñoDeCarreraAlQuePertenece() {
        return añoDeCarreraAlQuePertenece;
    }

    public void setAñoDeCarreraAlQuePertenece(int añoDeCarreraAlQuePertenece) {
        this.añoDeCarreraAlQuePertenece = añoDeCarreraAlQuePertenece;
    }
    
    public PeriodoLectivoConAño getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivoConAño periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    public boolean isPromocional() {
        return promocional;
    }

    public void setPromocional(boolean promocional) {
        this.promocional = promocional;
    }

    public int getCantidadParciales() {
        return cantidadParciales;
    }

    public void setCantidadParciales(int cantidadParciales) {
        this.cantidadParciales = cantidadParciales;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }


    public BitacoraFinal getBitacora() {
        return bitacora;
    }

    public void setBitacora(BitacoraFinal bitacora) {
        this.bitacora = bitacora;
    }

    public List<TrabajoPractico> getListadoTrabajosPracticos() {
        return listadoTrabajosPracticos;
    }

    public void setListadoTrabajosPracticos(List<TrabajoPractico> listadoTrabajosPracticos) {
        this.listadoTrabajosPracticos = listadoTrabajosPracticos;
    }

    public List<Examen>  getExamenes() {
        return examenes;
    }
    public List<Regimen> getCursantes() {
        return cursantes;
    }

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.nombre);
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
        final Asignatura other = (Asignatura) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return "Asignatura{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }

   


  
  
}
