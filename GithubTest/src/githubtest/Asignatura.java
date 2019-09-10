
package githubtest;

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
  private List<Alumno> alumosCursantes;
  private BitacoraFinal bitacora;
  private List<TrabajoPractico> listadoTrabajosPracticos;
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.codigo;
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
        return true;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "codigo=" + codigo + ", cargaHoraria=" + cargaHoraria + ", nombre=" + nombre + ", periodoLectivo=" + periodoLectivo + ", promocional=" + promocional + ", cantidadParciales=" + cantidadParciales + ", alumosCursantes=" + alumosCursantes + '}';
    }
  
  
}
