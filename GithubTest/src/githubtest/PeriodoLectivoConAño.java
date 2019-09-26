/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

/**
 *
 * @author juanc
 */
public class PeriodoLectivoConAño {
    private PeriodoLectivoEnum periodoLectivo;
    private int año;

    public PeriodoLectivoConAño(PeriodoLectivoEnum periodoLectivo, int año) {
        this.periodoLectivo = periodoLectivo;
        this.año = año;
    }
    

    public PeriodoLectivoEnum getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivoEnum periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
}
