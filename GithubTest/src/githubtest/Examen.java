/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

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

    public Examen(Asignatura asignatura, PeriodoLectivoEnum periodo, LocalDate fecha, int horario) {
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.fecha = fecha;
        this.horario = horario;
        this.docenteExamen=new ArrayList<>();  
    }

    public List<DocenteExamen> getDocenteExamen() {
        return docenteExamen;
    }

    public void setDocenteExamen(List<DocenteExamen> docenteExamen) {
        this.docenteExamen = docenteExamen;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public PeriodoLectivoEnum  getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLectivoEnum  periodo) {
        this.periodo = periodo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.asignatura);
        hash = 23 * hash + Objects.hashCode(this.fecha);
        hash = 23 * hash + Objects.hashCode(this.acta);
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

    @Override
    public String toString() {
        return "Examen{" + "asignatura=" + asignatura + ", periodo=" + periodo + ", fecha=" + fecha + ", horario=" + horario + ", acta=" + acta + '}';
    }



   
    
    
    
}
