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

    public Parcial(boolean recuperatorio, boolean primeroTrueSegundoFalse, Asignatura asignatura, PeriodoLectivoEnum periodo, LocalDate fecha, int horario, Acta acta) {
        super(asignatura, periodo, fecha, horario, acta);
        this.recuperatorio = recuperatorio;
        this.primeroTrueSegundoFalse = primeroTrueSegundoFalse;
    }
    

    public boolean isRecuperatorio() {
        return recuperatorio;
    }

    public void setRecuperatorio(boolean recuperatorio) {
        this.recuperatorio = recuperatorio;
    }

    public boolean isPrimeroTrueSegundoFalse() {
        return primeroTrueSegundoFalse;
    }

    public void setPrimeroTrueSegundoFalse(boolean primeroTrueSegundoFalse) {
        this.primeroTrueSegundoFalse = primeroTrueSegundoFalse;
    }

}
