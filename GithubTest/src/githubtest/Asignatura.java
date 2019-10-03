
package githubtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Asignatura {

  private int codigo,
          cargaHoraria;
  private String nombre;
  private PlanDeEstudio planDeEstudio;
  private Carrera carrera;
  private int añoDeCarreraAlQuePertenece;
  private PeriodoLectivoEnum periodoLectivo;
  private boolean promocional;
  private int cantidadParciales;
  private Equipo equipo;
  private BitacoraFinal bitacora;
  private List<TrabajoPractico> listadoTrabajosPracticos;
  private List<Examen> examenes;
  private List<Regimen>cursantes;

    public Asignatura(int codigo, int cargaHoraria, String nombre, PlanDeEstudio planDeEstudio, Carrera carrera, int añoDeCarreraAlQuePertenece, PeriodoLectivoEnum periodoLectivo, boolean promocional, int cantidadParciales, Equipo equipo, BitacoraFinal bitacora) {
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
        this.listadoTrabajosPracticos = new ArrayList<>()  ;
        this.examenes =new ArrayList<>()  ;
        this.cursantes = new ArrayList<>()  ;
    }


  

 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
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
    

    public int getAñoalQuePertenece() {
        return añoDeCarreraAlQuePertenece;
    }

    public void setAñoalQuePertenece(int añoalQuePertenece) {
        this.añoDeCarreraAlQuePertenece = añoalQuePertenece;
    }

    public PeriodoLectivoEnum getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivoEnum periodoLectivo) {
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

    public List<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }

    public List<Regimen> getCursantes() {
        return cursantes;
    }

    public void setCursantes(List<Regimen> cursantes) {
        this.cursantes = cursantes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "codigo=" + codigo + ", cargaHoraria=" + cargaHoraria + ", nombre=" + nombre + ", planDeEstudio=" + planDeEstudio + ", carrera=" + carrera + ", a\u00f1oDeCarreraAlQuePertenece=" + añoDeCarreraAlQuePertenece + ", periodoLectivo=" + periodoLectivo + ", promocional=" + promocional + ", cantidadParciales=" + cantidadParciales + ", equipo=" + equipo + ", bitacora=" + bitacora + ", listadoTrabajosPracticos=" + listadoTrabajosPracticos + ", examenes=" + examenes + ", cursantes=" + cursantes + '}';
    }


  
  
}
