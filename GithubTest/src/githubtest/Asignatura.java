
package githubtest;

import java.util.List;
public class Asignatura {
  private int codigo,
          cargaHoraria;
  private String nombre;
  private PeriodoLectivoEnum periodoLectivo;
  private boolean promocional;
  private int cantidadParciales;
  private List<Alumno> alumosCursantes;

    public Asignatura(int codigo, int cargaHoraria, String nombre, PeriodoLectivoEnum periodoLectivo, boolean promocional, int cantidadParciales, List<Alumno> alumosCursantes) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.nombre = nombre;
        this.periodoLectivo = periodoLectivo;
        this.promocional = promocional;
        this.cantidadParciales = cantidadParciales;
        this.alumosCursantes = alumosCursantes;
    }

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
