
package githubtest;

import java.time.LocalDate;
import java.util.List;

public class BitacoraDiaria {
    private LocalDate fechaClase;
    private String TemaClase;
    private List<Asistencia> listadoAsistencias;

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
    
    
}
