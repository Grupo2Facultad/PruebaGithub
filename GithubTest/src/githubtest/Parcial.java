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
public class Parcial extends Examen{
    private boolean recuperatorio;
    private boolean primeroTrueSegundoFalse;

    /**
     *
     * @param recuperatorio
     * @param primeroTrueSegundoFalse
     * @param asignatura
     * @param periodo
     * @param fecha
     * @param horario
     */
    public Parcial(boolean recuperatorio, boolean primeroTrueSegundoFalse, Asignatura asignatura, PeriodoLectivoEnum periodo, LocalDate fecha, int horario) {
        super(asignatura, periodo, fecha, horario);
        this.recuperatorio = recuperatorio;
        this.primeroTrueSegundoFalse = primeroTrueSegundoFalse;
    }
    
    /**
     *
     * @return Si el parcial es o no es un recuperatorio
     */
    public boolean isRecuperatorio() {
        return recuperatorio;
    }

    /**
     *
     * @param recuperatorio
     */
    public void setRecuperatorio(boolean recuperatorio) {
        this.recuperatorio = recuperatorio;
    }

    /**
     *
     * @return Si es el primer parcial
     */
    public boolean isPrimeroTrueSegundoFalse() {
        return primeroTrueSegundoFalse;
    }

    /**
     *
     * @param primeroTrueSegundoFalse
     */
    public void setPrimeroTrueSegundoFalse(boolean primeroTrueSegundoFalse) {
        this.primeroTrueSegundoFalse = primeroTrueSegundoFalse;
    }

}
