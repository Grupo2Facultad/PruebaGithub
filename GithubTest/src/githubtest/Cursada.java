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

    public Cursada(LocalDate fechaDeInscripcion, PeriodoLectivoConAño periodoLectivo, Alumno alumno, Asignatura asignatura, boolean regularidad) {
        super(alumno, asignatura, regularidad);
        this.fechaDeInscripcion = fechaDeInscripcion;
        this.periodoLectivo = periodoLectivo;
    }

    public LocalDate getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public void setFechaDeInscripcion(LocalDate fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public PeriodoLectivoConAño getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivoConAño periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    public int getNotaFinalCurso() {
        return notaFinalCurso;
    }

    public void setNotaFinalCurso(int notaFinalCurso) {
        this.notaFinalCurso = notaFinalCurso;
    }

    

  


     
}
