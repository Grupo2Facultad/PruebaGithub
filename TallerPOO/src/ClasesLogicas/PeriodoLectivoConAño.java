/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesLogicas;

import java.util.Objects;

/**
 *Contiene un periodo Lectivo Enum (Anual, Primer Cuatrimestre o Segundo Cuatrimestere) y un año
 * @author juanc
 */
public class PeriodoLectivoConAño {
    private PeriodoLectivoEnum periodoLectivo;
    private int año;

    /**
     *
     * @param periodoLectivo
     * @param año
     */
    public PeriodoLectivoConAño(PeriodoLectivoEnum periodoLectivo, int año) {
        this.periodoLectivo = periodoLectivo;
        this.año = año;
    }
    
    /**
     *
     * @return El periodo lectivo 
     */
    public PeriodoLectivoEnum getPeriodoLectivo() {
        return periodoLectivo;
    }

    /**
     *
     * @param periodoLectivo
     */
    public void setPeriodoLectivo(PeriodoLectivoEnum periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    /**
     *
     * @return El año
     */
    public int getAño() {
        return año;
    }

    /**
     *
     * @param año
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.periodoLectivo);
        hash = 73 * hash + this.año;
        return hash;
    }

    /**
     *
     * @param obj
     * @return La igualad entre este objeto y otro del mismo tipo
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
        final PeriodoLectivoConAño other = (PeriodoLectivoConAño) obj;
        if (this.año != other.año) {
            return false;
        }
        if (this.periodoLectivo != other.periodoLectivo) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con caracteristicas del periodo lectivo
     */
    @Override
    public String toString() {
        return "PeriodoLectivoConA\u00f1o{" + "periodoLectivo=" + periodoLectivo + ", a\u00f1o=" + año + '}';
    }
    
}
