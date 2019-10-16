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
public class Cursada 
extends Regimen{
    private LocalDate fechaDeInscripcion;
  private PeriodoLectivoConAño periodoLectivo;
  private int notaFinalCurso;

    /**
     *
     * @param fechaDeInscripcion
     * @param periodoLectivo
     * @param alumno
     * @param asignatura
     * @param regularidad
     */
    public Cursada(LocalDate fechaDeInscripcion, PeriodoLectivoConAño periodoLectivo, Alumno alumno, Asignatura asignatura, boolean regularidad) {
        super(alumno, asignatura, regularidad);
        this.fechaDeInscripcion = fechaDeInscripcion;
        this.periodoLectivo = periodoLectivo;
    }

    /**
     *
     * @return La fecha de inscripcion de un alumno a la asignatura
     */
    public LocalDate getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    /**
     *
     * @param fechaDeInscripcion
     */
    public void setFechaDeInscripcion(LocalDate fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    /**
     *
     * @return El periodo lectivo de la cursada
     */
    public PeriodoLectivoConAño getPeriodoLectivo() {
        return periodoLectivo;
    }

    /**
     *
     * @param periodoLectivo
     */
    public void setPeriodoLectivo(PeriodoLectivoConAño periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    /**
     *
     * @return La nota final de un ciclo lectivo
     */
    public int getNotaFinalCurso() {
        return notaFinalCurso;
    }

    /**
     *
     * @param notaFinalCurso
     */
    public void setNotaFinalCurso(int notaFinalCurso) {
        this.notaFinalCurso = notaFinalCurso;
    }

    

  


     
}
