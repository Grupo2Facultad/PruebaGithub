/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author juanc
 */
public class Final extends Examen {
    private boolean puedenRegulares;
    private boolean puedenLibres;
    private List<DocenteExamen> docenteExamen;

    public Final(boolean puedenRegulares, boolean puedenLibres, List<DocenteExamen> docenteExamen, Asignatura asignatura, int numero, String periodo, LocalDate fecha, int horario, Acta acta) {
        super(asignatura, numero, periodo, fecha, horario, acta);
        this.puedenRegulares = puedenRegulares;
        this.puedenLibres = puedenLibres;
        this.docenteExamen = docenteExamen;
    }

    public boolean isPuedenRegulares() {
        return puedenRegulares;
    }

    public void setPuedenRegulares(boolean puedenRegulares) {
        this.puedenRegulares = puedenRegulares;
    }

    public boolean isPuedenLibres() {
        return puedenLibres;
    }

    public void setPuedenLibres(boolean puedenLibres) {
        this.puedenLibres = puedenLibres;
    }


    public List<DocenteExamen> getDocenteExamen() {
        return docenteExamen;
    }

    public void setDocenteExamen(List<DocenteExamen> docenteExamen) {
        this.docenteExamen = docenteExamen;
    }

}
