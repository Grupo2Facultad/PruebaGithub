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
public abstract class Examen {
    private Asignatura asignatura;
    private int numero;
    private String periodo;
    private LocalDate fecha;
   private int horario;
   private Acta acta;

    public Examen(Asignatura asignatura, int numero, String periodo, LocalDate fecha, int horario, Acta acta) {
        this.asignatura = asignatura;
        this.numero = numero;
        this.periodo = periodo;
        this.fecha = fecha;
        this.horario = horario;
        this.acta = acta;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
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
        hash = 83 * hash + this.numero;
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
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Examen{" + "asignatura=" + asignatura + ", numero=" + numero + ", periodo=" + periodo + ", fecha=" + fecha + ", horario=" + horario + ", acta=" + acta + '}';
    }
    
    
    
}
