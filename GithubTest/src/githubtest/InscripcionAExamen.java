/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanc
 */
public class InscripcionAExamen {

    private Alumno alumno;
    private LocalDate fecha;
    private Examen examen;
    private boolean habilitado,
            notas,
            aproboPrimerParcial,
            asistencia;
    private double notaObtenida;
           private boolean hayPrimero;

    

    public InscripcionAExamen(Alumno alumno, LocalDate fecha, Examen examen) {
        this.alumno = alumno;
        this.fecha = fecha;
        this.examen = examen;
    }

    public void verificar() {
        BitacoraFinal bitacora=null;
        List<TrabajoPractico> trabajos=null;
        ArrayList<Carrera> carreras = RegistroDeCarreras.getCarreras();
        for (Carrera carrera : carreras) {
            ArrayList<PlanDeEstudio> planes = (ArrayList) carrera.getPlanDeEstudio();
            for (PlanDeEstudio plane : planes) {
                ArrayList<Asignatura> asig = plane.getAsignaturas();
                for (Asignatura asignatura : asig) {
                    ArrayList<Examen> examenes = (ArrayList) asignatura.getExamenes();
                    for (Examen examene : examenes) {
                        if(examene instanceof Parcial){
                            if (!((Parcial)examene).isPrimeroTrueSegundoFalse()){
                              verificarPrimero(examenes);
                            }                               
                        }
                        if (examene.equals(examen)) {
                            bitacora = asignatura.getBitacora();
                            trabajos=(ArrayList)asignatura.getListadoTrabajosPracticos();
                        }
                    }
                }
            }
        }
        verificarAsistencia(bitacora);
        verificarNotasPracticos(trabajos);
        habilitar();
       
    }

    public void habilitar() {
        if (asistencia && notas && !hayPrimero) {
            this.habilitado = true;
        }
        if (hayPrimero&&asistencia&&notas&&aproboPrimerParcial) {
            this.habilitado=true;
        }
    }

    public void verificarPrimero(List<Examen>examenes) {
        for (Examen examene : examenes) {
            if (((Parcial)examene).isPrimeroTrueSegundoFalse()){
                ArrayList<InscripcionAExamen> inscripciones= (ArrayList)examene.getActa().getInscripciones();
                for (InscripcionAExamen inscripcione : inscripciones) {
                    if(inscripcione.getAlumno().equals(alumno)){
                        if (inscripcione.getNotaObtenida()>6){
                            this.aproboPrimerParcial=true;                                   
                        }
                        else{
                            this.aproboPrimerParcial=false;
                        }
                    }
                }
            }
        }
      
    }
    public void verificarNotasPracticos(List<TrabajoPractico> trabajos) {
       int totalTrabajos=0;
       int notas=0;
        for (TrabajoPractico trabajo : trabajos) {
            ArrayList<TrabajoDeAlumno> trabajosAlumnos=(ArrayList)trabajo.getNotasIndividuales();
            for (TrabajoDeAlumno trabajoAlumno : trabajosAlumnos) {
                if (trabajoAlumno.getAlumnoQueHizoElTrabajo().equals(alumno)){
                    totalTrabajos+=1;
                    notas+=trabajoAlumno.getNota();
                }
            }
        }
        double promedio=notas/totalTrabajos;
        if(promedio>=6){
            this.notas=true;
        }
        else{
            this.notas=false;
        }
    }
    public void verificarAsistencia(BitacoraFinal bitacora) {
                int asistio = 0;
        int asistenciasTotal = 0;
        ArrayList<BitacoraDiaria> bitac = (ArrayList) bitacora.getBitacorasDiarias();
        for (BitacoraDiaria bitacoraDiaria : bitac) {
            ArrayList<Asistencia> listadoAsistencias = (ArrayList) bitacoraDiaria.getListadoAsistencias();
            for (Asistencia asistencia : listadoAsistencias) {
                if (asistencia.getAlumno().equals(alumno)) {
                    if (asistencia.getAsistio() == false) {
                        asistenciasTotal += 1;
                    } else {
                        asistenciasTotal += 1;
                        asistio += 1;
                    }
                }
            }
        }
        double calculo = asistio / asistenciasTotal;
        if (calculo >= 0.75) {
            this.asistencia = true;
        } else {
            this.asistencia = false;
        }
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isNotas() {
        return notas;
    }

    public void setNotas(boolean notas) {
        this.notas = notas;
    }

    public boolean isPrimerParcial() {
        return aproboPrimerParcial;
    }

    public void setPrimerParcial(boolean primerParcial) {
        this.aproboPrimerParcial = primerParcial;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public double getNotaObtenida() {
        return notaObtenida;
    }

    public void setNotaObtenida(double notaObtenida) {
        this.notaObtenida = notaObtenida;
    }


}
