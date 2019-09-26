
package githubtest;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BitacoraDiaria {
    private LocalDate fechaClase;
    private String TemaClase;
    private List<Asistencia> listadoAsistencias;

    public BitacoraDiaria(LocalDate fechaClase, String TemaClase, List<Asistencia> listadoAsistencias) {
        this.fechaClase = fechaClase;
        this.TemaClase = TemaClase;
        this.listadoAsistencias = listadoAsistencias;
    }
    

    public LocalDate getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(LocalDate fechaClase) {
        this.fechaClase = fechaClase;
    }

    public String getTemaClase() {
        return TemaClase;
    }

    public void setTemaClase(String TemaClase) {
        this.TemaClase = TemaClase;
    }

    public List<Asistencia> getListadoAsistencias() {
        return listadoAsistencias;
    }

    public void setListadoAsistencias(List<Asistencia> listadoAsistencias) {
        this.listadoAsistencias = listadoAsistencias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.fechaClase);
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
        final BitacoraDiaria other = (BitacoraDiaria) obj;
        if (!Objects.equals(this.fechaClase, other.fechaClase)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BitacoraDiaria{" + "fechaClase=" + fechaClase + ", TemaClase=" + TemaClase + ", listadoAsistencias=" + listadoAsistencias + '}';
    }
    
    
}
