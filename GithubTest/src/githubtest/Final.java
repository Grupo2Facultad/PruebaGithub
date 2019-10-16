/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;

/**
 *
 * @author juanc
 */
public class Final extends Examen {
    private boolean puedenRegulares;
    private boolean puedenLibres;

    /**
     *
     * @param puedenRegulares
     * @param puedenLibres
     * @param asignatura
     * @param periodo
     * @param fecha
     * @param horario
     */
    public Final(boolean puedenRegulares, boolean puedenLibres, Asignatura asignatura, PeriodoLectivoEnum periodo, LocalDate fecha, int horario) {
        super(asignatura, periodo, fecha, horario);
        this.puedenRegulares = puedenRegulares;
        this.puedenLibres = puedenLibres;
    }

    /**
     *
     * @return Un booleano sobre si el examen está habilitado para alumnos regulares
     */
    public boolean isPuedenRegulares() {
        return puedenRegulares;
    }

    /**
     *
     * @param puedenRegulares
     */
    public void setPuedenRegulares(boolean puedenRegulares) {
        this.puedenRegulares = puedenRegulares;
    }

    /**
     *
     * @return Un booleano sobre si el examen está habilitado para alumnos libres
     */
    public boolean isPuedenLibres() {
        return puedenLibres;
    }

    /**
     *
     * @param puedenLibres
     */
    public void setPuedenLibres(boolean puedenLibres) {
        this.puedenLibres = puedenLibres;
    }

}
