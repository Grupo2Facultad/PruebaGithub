
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *Listado de asistencias en una determinada clase
 * @author Alumno
 */
public class BitacoraDiaria {
    private LocalDate fechaClase;
    private String TemaClase;
    private List<Asistencia> listadoAsistencias;

    /**
     *
     * @param fechaClase
     * @param TemaClase
     */
    public BitacoraDiaria(LocalDate fechaClase, String TemaClase) {
        this.fechaClase = fechaClase;
        this.TemaClase = TemaClase;
        this.listadoAsistencias = new ArrayList<>() ;
    }
    
    /**
     *
     * @return La fecha de la clase
     */
    public LocalDate getFechaClase() {
        return fechaClase;
    }

    /**
     *
     * @param fechaClase
     */
    public void setFechaClase(LocalDate fechaClase) {
        this.fechaClase = fechaClase;
    }

    /**
     *
     * @return El tema de la clase
     */
    public String getTemaClase() {
        return TemaClase;
    }

    /**
     *
     * @param TemaClase
     */
    public void setTemaClase(String TemaClase) {
        this.TemaClase = TemaClase;
    }

    /**
     *
     * @return Un listado con las asistencias de esa clase
     */
    public List<Asistencia> getListadoAsistencias() {
        return listadoAsistencias;
    }

    /**
     *
     * @param listadoAsistencias
     */
    public void setListadoAsistencias(List<Asistencia> listadoAsistencias) {
        this.listadoAsistencias = listadoAsistencias;
    }

    /**
     *
     * @return el hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.fechaClase);
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
        final BitacoraDiaria other = (BitacoraDiaria) obj;
        if (!Objects.equals(this.fechaClase, other.fechaClase)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con la identidad del objeto
     */
    @Override
    public String toString() {
        return "BitacoraDiaria{" + "fechaClase=" + fechaClase + ", TemaClase=" + TemaClase + ", listadoAsistencias=" + listadoAsistencias + '}';
    }
    
    
}
