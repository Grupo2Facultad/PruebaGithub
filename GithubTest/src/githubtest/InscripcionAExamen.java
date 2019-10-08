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
import java.util.Objects;
import java.util.Random;
import javax.swing.JOptionPane;

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
    private String notaObtenida;
    private boolean tiene2Parciales;

    public InscripcionAExamen(Alumno alumno, Examen examen) throws NoSeInscribioException{
        this.alumno = alumno;
        this.fecha = LocalDate.now();
        this.examen = examen;
        this.habilitado = false;
        if (examen instanceof Parcial) {
            verificarParcial();
        } else {
            verificarFinal();
        }
    }

    private void verificarFinal() throws NoSeInscribioException{
        if (DAYS.between(examen.getFecha(), LocalDate.now()) < 3) {
            boolean regular;
            System.out.println(getNotaCurso());
            if (getNotaCurso() >= 6) {
                regular = true;
            } else {
                regular = false;
            }
            if (((Final) examen).isPuedenRegulares() && regular) {
                JOptionPane.showMessageDialog(null,"InsciptoComoRegular");
                habilitado = true;
                setNotaObtenida();
            } else {
                habilitado = false;
            }
            if (((Final) examen).isPuedenLibres()&&notaObtenida==null) {
                JOptionPane.showMessageDialog(null,"InsciptoComoLibre");
                habilitado = true;
                setNotaObtenida();
            }
            if(notaObtenida==null){
                JOptionPane.showMessageDialog(null,"No se puede inscibir");
                throw new NoSeInscribioException("no se pudo inscribir");
                 
            }
        } else {
            JOptionPane.showMessageDialog(null, "el periodo de Inscripcion ya finalizo");
        }
    }
    public void setNotaObtenida() {
        Random r=new Random();
        int  ran=r.nextInt(9)+1;
        this.notaObtenida=Integer.toString(ran);
    }
    public Double getNotaCurso() {
        double notaPrimero = 0,
                notaSegundo = 0;
        double notaCurso;
        List<Examen> examenes = getElRestoDeExamenes();
        for (Examen examene : examenes) {
            if (examene instanceof Parcial) {
                if (!((Parcial) examene).isPrimeroTrueSegundoFalse()) {
                    this.tiene2Parciales = true;
                    ArrayList<InscripcionAExamen> inscripciones = (ArrayList) examene.getActa().getInscripciones();
                    for (InscripcionAExamen inscripcione : inscripciones) {
                        if (this.alumno.equals(inscripcione.alumno)) {
                            notaSegundo = Double.parseDouble(inscripcione.notaObtenida);
                        }
                    }
                }
                if (((Parcial) examene).isPrimeroTrueSegundoFalse()) {
                    ArrayList<InscripcionAExamen> inscripciones = (ArrayList) examene.getActa().getInscripciones();
                    for (InscripcionAExamen inscripcione : inscripciones) {
                        if (this.alumno.equals(inscripcione.alumno)) {
                            notaPrimero = Double.parseDouble(inscripcione.notaObtenida);
                            System.out.println("notaPrimero"+notaPrimero);
                        }
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
        System.out.println("notacurso"+notaCurso);
        return notaCurso;
    }
  
       
    public List<Examen> getElRestoDeExamenes() {
        return this.examen.getAsignatura().getExamenes();
    }
        
       private  void verificarParcial() {
        BitacoraFinal bitacora = new BitacoraFinal();
        List<TrabajoPractico> trabajos = new ArrayList<>()  ;
        List<Examen> examenes = getElRestoDeExamenes();
        for (Examen examene : examenes) {
            if (examene instanceof Parcial) {
                if (examene.getAsignatura().equals(examen.getAsignatura())) {
                    if (!((Parcial) examene).isPrimeroTrueSegundoFalse()) {
                        verificarPrimero(examenes);
                        this.tiene2Parciales = true;
                    } 
                }
            }
        }
        bitacora = this.examen.getAsignatura().getBitacora();
        trabajos = (ArrayList) this.examen.getAsignatura().getListadoTrabajosPracticos();
        verificarAsistencia(bitacora);
        verificarNotasPracticos(trabajos);
        habilitarParcial();
    }

    public void habilitarParcial() {
        if (asistencia && notasPracticosBuenas && !tiene2Parciales) {
            this.habilitado = true;
            setNotaObtenida();
            System.out.println("Nota btenida"+notaObtenida);
        }
        if (tiene2Parciales&&asistencia&&notasPracticosBuenas&&aproboPrimerParcial) {
            this.habilitado=true;
            setNotaObtenida();
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
        System.out.println("promedio"+promedio);
        if(promedio>=6){
            this.notasPracticosBuenas=true;
        }
        else{
            this.notasPracticosBuenas=false;
        }
    }
    public void verificarAsistencia(BitacoraFinal bitacora){
        double asistio = 0;
        double asistenciasTotal = 0;
        ArrayList<BitacoraDiaria> bitac = (ArrayList) bitacora.getBitacorasDiarias();
        for (BitacoraDiaria bitacoraDiaria : bitac) {
            ArrayList<Asistencia> listadoAsistencias = (ArrayList) bitacoraDiaria.getListadoAsistencias();
            for (Asistencia asistencia : listadoAsistencias) {
                if (asistencia.getAlumno().equals(alumno)) {
                    System.out.println(asistencia.getAsistio());
                    if (!asistencia.getAsistio()) {
                        asistenciasTotal += 1;
                    } else {
                        asistenciasTotal += 1;
                        asistio += 1;
                    }
                }
            }
        }
        double calculo = asistio / asistenciasTotal;
        System.out.println("asistencias total"+asistenciasTotal);
        System.out.println("asistio"+asistio);
        System.out.println(calculo);
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

    public boolean isNotasPracticosBuenas() {
        return notasPracticosBuenas;
    }

    public void setNotasPracticosBuenas(boolean notasPracticosBuenas) {
        this.notasPracticosBuenas = notasPracticosBuenas;
    }

    public boolean isAproboPrimerParcial() {
        return aproboPrimerParcial;
    }

    public void setAproboPrimerParcial(boolean aproboPrimerParcial) {
        this.aproboPrimerParcial = aproboPrimerParcial;
    }

    public boolean isTiene2Parciales() {
        return tiene2Parciales;
    }

    public void setTiene2Parciales(boolean tiene2Parciales) {
        this.tiene2Parciales = tiene2Parciales;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.alumno);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.examen);
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
        final InscripcionAExamen other = (InscripcionAExamen) obj;
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InscripcionAExamen{" + "alumno=" + alumno + ", fecha=" + fecha + ", habilitado=" + habilitado + ", notasPracticosBuenas=" + notasPracticosBuenas + ", aproboPrimerParcial=" + aproboPrimerParcial + ", asistencia=" + asistencia + ", notaObtenida=" + notaObtenida + ", tiene2Parciales=" + tiene2Parciales + '}';
    }



}
