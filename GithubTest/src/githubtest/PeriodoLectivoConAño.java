/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.periodoLectivo);
        hash = 73 * hash + this.año;
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
        final PeriodoLectivoConAño other = (PeriodoLectivoConAño) obj;
        if (this.año != other.año) {
            return false;
        }
        if (this.periodoLectivo != other.periodoLectivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PeriodoLectivoConA\u00f1o{" + "periodoLectivo=" + periodoLectivo + ", a\u00f1o=" + año + '}';
    }
    
}
