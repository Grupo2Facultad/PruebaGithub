/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
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
            notasPracticosBuenas,
            aproboPrimerParcial,
            asistencia;
    private String  notaObtenida;
    private boolean tiene2Parciales;

    

    public InscripcionAExamen(Alumno alumno, LocalDate fecha, Examen examen) {
        this.alumno = alumno;
        this.fecha = fecha;
        this.examen = examen;
        this.habilitado=false;
        if(examen instanceof Parcial){
            verificarParcial();
        }
        else{
            verificarFinal();
        }
    }

    public void verificarFinal() {
        if(DAYS.between(examen.getFecha(),LocalDate.now())<=3){
        boolean regular;
        if(getNotaCurso()>=6){
        regular=true;
    }
        else{
            regular=false;
        }
        if (((Final)examen).isPuedenRegulares()&&regular){
        habilitado=true;
    }
        else{
            habilitado=false;
        }
        if(((Final)examen).isPuedenLibres()){
        habilitado=true;
    }
    }
    }
    public Double getNotaCurso() {
        double notaPrimero=0,
                notaSegundo=0;
        double notaCurso;
        List<Examen> examenes = getElRestoDeExamenes();
        for (Examen examene : examenes) {
            if (!((Parcial) examene).isPrimeroTrueSegundoFalse()) {
                this.tiene2Parciales = true;
                ArrayList<InscripcionAExamen> inscripciones=(ArrayList)examene.getActa().getInscripciones();
                for (InscripcionAExamen inscripcione : inscripciones) {
                    if(this.alumno.equals(inscripcione.alumno)){
                        notaSegundo=Double.parseDouble(inscripcione.notaObtenida);
                    }
                }
            }
            if(((Parcial) examene).isPrimeroTrueSegundoFalse()){
                   ArrayList<InscripcionAExamen> inscripciones=(ArrayList)examene.getActa().getInscripciones();
                    for (InscripcionAExamen inscripcione : inscripciones) {
                    if(this.alumno.equals(inscripcione.alumno)){
                        notaPrimero=Double.parseDouble(inscripcione.notaObtenida);
                    }
                }
            }
        }
        if (this.tiene2Parciales){
            notaCurso=(notaPrimero + notaSegundo)/2;
        }
        else{
            notaCurso=notaPrimero;
        }
        return notaCurso;
    }
  
       
    public List<Examen> getElRestoDeExamenes() {
        return this.examen.getAsignatura().getExamenes();
    }
        
    public void verificarParcial() {
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
                              this.tiene2Parciales=true;
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
        habilitarParcial();
    }

    public void habilitarParcial() {
        if (asistencia && notasPracticosBuenas && !tiene2Parciales) {
            this.habilitado = true;
        }
        if (tiene2Parciales&&asistencia&&notasPracticosBuenas&&aproboPrimerParcial) {
            this.habilitado=true;
        }
    }

    public void verificarPrimero(List<Examen>examenes) {
        for (Examen examene : examenes) {
            if (((Parcial)examene).isPrimeroTrueSegundoFalse()){
                ArrayList<InscripcionAExamen> inscripciones= (ArrayList)examene.getActa().getInscripciones();
                for (InscripcionAExamen inscripcione : inscripciones) {
                    if(inscripcione.getAlumno().equals(alumno)){
                        if (Double.parseDouble(inscripcione.getNotaObtenida())>6){
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
            this.notasPracticosBuenas=true;
        }
        else{
            this.notasPracticosBuenas=false;
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
        return notasPracticosBuenas;
    }

    public void setNotas(boolean notas) {
        this.notasPracticosBuenas = notas;
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

    public String  getNotaObtenida() {
        return notaObtenida;
    }

    public void setNotaObtenida(String  notaObtenida) {
        this.notaObtenida = notaObtenida;
    }


}
