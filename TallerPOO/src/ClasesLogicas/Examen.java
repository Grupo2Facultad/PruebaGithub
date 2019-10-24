/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesLogicas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author juanc
 */
public abstract class Examen {
    
    private Asignatura asignatura;
    private PeriodoLectivoEnum periodo;
    private LocalDate fecha;
   private int horario;
   private List<DocenteExamen> docenteExamen;
   private Acta acta;

    /**
     *
     * @param asignatura
     * @param periodo
     * @param fecha
     * @param horario
     */
    public Examen(Asignatura asignatura, PeriodoLectivoEnum periodo, LocalDate fecha, int horario) {
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.fecha = fecha;
        this.horario = horario;
        this.docenteExamen=new ArrayList<>();  
    }

    /**
     *
     * @return un listado con los docentes en el examen
     */
    public List<DocenteExamen> getDocenteExamen() {
        return docenteExamen;
    }

    /**
     *
     * @param docenteExamen
     */
    public void setDocenteExamen(List<DocenteExamen> docenteExamen) {
        this.docenteExamen = docenteExamen;
    }

    /**
     *
     * @return La asignatura sobre la que es el examen
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     *
     * @param asignatura
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     *
     * @return El periodo lectivo al que pertecene el examen
     */
    public PeriodoLectivoEnum  getPeriodo() {
        return periodo;
    }

    /**
     *
     * @param periodo
     */
    public void setPeriodo(PeriodoLectivoEnum  periodo) {
        this.periodo = periodo;
    }

    /**
     *
     * @return La fecha del examen
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return El horario del examen
     */
    public int getHorario() {
        return horario;
    }

    /**
     *
     * @param horario
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     *
     * @return Un acta del examen
     */
    public Acta getActa() {
        return acta;
    }

    /**
     *
     * @param acta
     */
    public void setActa(Acta acta) {
        this.acta = acta;
    }

    /**
     *
     * @return el hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.asignatura);
        hash = 23 * hash + Objects.hashCode(this.fecha);
        hash = 23 * hash + Objects.hashCode(this.acta);
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
        final Examen other = (Examen) obj;
        if (!Objects.equals(this.asignatura, other.asignatura)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.acta, other.acta)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Examen{" + "asignatura=" + asignatura + ", periodo=" + periodo + ", fecha=" + fecha + ", horario=" + horario + ", acta=" + acta + '}';
    }



   
    
    
    
}
