
package githubtest;

import java.util.ArrayList;
import java.util.List;
public class Asignatura {

  private int codigo,
          cargaHoraria;
  private String nombre;
  private int añoalQuePertenece;
  private PeriodoLectivoEnum periodoLectivo;
  private boolean promocional;
  private int cantidadParciales;
  private Equipo equipo;
  private List<Alumno> alumnosCursantes;
  private BitacoraFinal bitacora;
  private List<TrabajoPractico> listadoTrabajosPracticos;
  private List<Examen> examenes; 
  private List<Regimen>cursantes;

    public Asignatura(int codigo, int cargaHoraria, String nombre, int añoalQuePertenece, PeriodoLectivoEnum periodoLectivo, boolean promocional, int cantidadParciales, Equipo equipo, List<Alumno> alumnosCursantes, BitacoraFinal bitacora, List<TrabajoPractico> listadoTrabajosPracticos, List<Examen> examenes, List<Regimen> cursantes) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.nombre = nombre;
        this.añoalQuePertenece = añoalQuePertenece;
        this.periodoLectivo = periodoLectivo;
        this.promocional = promocional;
        this.cantidadParciales = cantidadParciales;
        this.equipo = equipo;
        this.alumnosCursantes = alumnosCursantes;
        this.bitacora = bitacora;
        this.listadoTrabajosPracticos = listadoTrabajosPracticos;
        this.examenes = examenes;
        this.cursantes = cursantes;
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

    public int getAñoalQuePertenece() {
        return añoalQuePertenece;
    }

    public void setAñoalQuePertenece(int añoalQuePertenece) {
        this.añoalQuePertenece = añoalQuePertenece;
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

    public List<Alumno> getAlumnosCursantes() {
        return alumnosCursantes;
    }

    public void setAlumnosCursantes(List<Alumno> alumnosCursantes) {
        this.alumnosCursantes = alumnosCursantes;
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


  
  
}
