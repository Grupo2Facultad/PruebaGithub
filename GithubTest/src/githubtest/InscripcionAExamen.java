/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import GUI.NoSeInscribioException;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private boolean asitioAlExamen;

    /**
     *
     * @param alumno
     * @param examen
     * @throws NoSeInscribioException
     */
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
    /**
     * @throws NoSeInscribioException 
     * Habilita al alumno para rendir un examen final
     */

    private void verificarFinal() throws NoSeInscribioException{
        if (DAYS.between(examen.getFecha(), LocalDate.now()) < 3) {
            boolean regular;
            if (getNotaCurso() >= 6) {
                regular = true;
            } else {
                regular = false;
            }
            if (((Final) examen).isPuedenRegulares() && regular) {
                JOptionPane.showMessageDialog(null,"Regular");
                habilitado = true;
            } else {
                habilitado = false;
            }
            if (((Final) examen).isPuedenLibres()&&notaObtenida==null) {
                JOptionPane.showMessageDialog(null,"Libre");
                habilitado = true;
            }
  
            
        } else {
            JOptionPane.showMessageDialog(null, "el periodo de Inscripcion ya finalizo");
        }
    }
 
    /**
     *
     * @return La nota del Curso del alumno que se quiere inscribir
     */
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
  
    /**
     *
     * @return Una lista con el resto de examenes de esa Asignatura
     */
    public List<Examen> getElRestoDeExamenes() {
        return this.examen.getAsignatura().getExamenes();
    }
        /**
         * Verifica si el alumno se encuentra habilitado para rendir un parcial
         */
       private  void verificarParcial() {
        BitacoraFinal bitacora;
        List<TrabajoPractico> trabajos;
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

    /**
     * Habilita a un alumno a rendir un parcial
     */
    public void habilitarParcial() {
        if (asistencia && notasPracticosBuenas && !tiene2Parciales) {
            this.habilitado = true;
            System.out.println("Nota btenida"+notaObtenida);
        }
        if (tiene2Parciales&&asistencia&&notasPracticosBuenas&&aproboPrimerParcial) {
            this.habilitado=true;
        }
    }

    /**
     *
     * @param examenes
     *Verifica si el alumno aprobó el primer parcial
     */
    public void verificarPrimero(List<Examen>examenes) {
        for (Examen examene : examenes) {
            if (((Parcial)examene).isPrimeroTrueSegundoFalse()){
                ArrayList<InscripcionAExamen> inscripciones= (ArrayList)examene.getActa().getInscripciones();
                boolean l=false;
                for (InscripcionAExamen inscripcione : inscripciones) {
                    if(inscripcione.getAlumno().equals(alumno)&&!l){
                        if (Double.parseDouble(inscripcione.getNotaObtenida())>6){
                            this.aproboPrimerParcial=true;                                   
                        }
                        else{
                            this.aproboPrimerParcial=false;
                        }
                    }
                    if(inscripcione.getAlumno().equals(alumno)&&((Parcial)examene).isRecuperatorio()){
                        if (Double.parseDouble(inscripcione.getNotaObtenida())>6){
                            l=true;
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

    /**
     *
     * @param trabajos
     *Verifica si tiene bien los trabajos practicos
     */
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

    /**
     *
     * @param bitacora
     *Verifica que la cantidad de asistencias sean las que se necesitan para inscribirse a un examen
     */
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

    /**
     *
     * @return El alumno inscripto
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     *
     * @param alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     *
     * @return La fecha de inscripcion
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
     * @return El examen al que se inscribe
     */
    public Examen getExamen() {
        return examen;
    }

    /**
     *
     * @param examen
     */
    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    /**
     *
     * @return Si el alumno se encuentra habilitado para rendir el examen
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     *
     * @param habilitado
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    /**
     *
     * @return Si las notas de los practicos son buenas
     */
    public boolean isNotas() {
        return notasPracticosBuenas;
    }

    /**
     *
     * @return Si el alumno asistió al examen
     */
    public boolean isAsitioAlExamen() {
        return asitioAlExamen;
    }

    /**
     *
     * @param asitioAlExamen
     */
    public void setAsitioAlExamen(boolean asitioAlExamen) {
        this.asitioAlExamen = asitioAlExamen;
    }

    /**
     *
     * @param notas
     */
    public void setNotas(boolean notas) {
        this.notasPracticosBuenas = notas;
    }

    /**
     *
     * @return Un booleano sobre si el alumno que desea inscribirse aprobo el primer parcial
     */
    public boolean isPrimerParcial() {
        return aproboPrimerParcial;
    }

    /**
     *
     * @param primerParcial
     */
    public void setPrimerParcial(boolean primerParcial) {
        this.aproboPrimerParcial = primerParcial;
    }

    /**
     *
     * @return Un booleano sobre la asistencia al examen
     */
    public boolean isAsistencia() {
        return asistencia;
    }

    /**
     *
     * @param asistencia
     */
    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    /**
     *
     * @return La nota obtenida en el examen
     */
    public String  getNotaObtenida() {
        return notaObtenida;
    }

    /**
     *
     * @param notaObtenida
     */
    public void setNotaObtenida(String  notaObtenida) {
        this.notaObtenida = notaObtenida;
    }

    /**
     *
     * @return Si las notas de los practicos del alumno que se inscribe son buenas
     */
    public boolean isNotasPracticosBuenas() {
        return notasPracticosBuenas;
    }

    /**
     *
     * @param notasPracticosBuenas
     */
    public void setNotasPracticosBuenas(boolean notasPracticosBuenas) {
        this.notasPracticosBuenas = notasPracticosBuenas;
    }

    /**
     *
     * @return Un booleano sobre si el alumno que desea inscribirse aprobo el primer parcial
     */
    public boolean isAproboPrimerParcial() {
        return aproboPrimerParcial;
    }

    /**
     *
     * @param aproboPrimerParcial
     */
    public void setAproboPrimerParcial(boolean aproboPrimerParcial) {
        this.aproboPrimerParcial = aproboPrimerParcial;
    }

    /**
     *
     * @return Si el examen al que se inscribe tiene un parcial anterior
     */
    public boolean isTiene2Parciales() {
        return tiene2Parciales;
    }

    /**
     *
     * @param tiene2Parciales
     */
    public void setTiene2Parciales(boolean tiene2Parciales) {
        this.tiene2Parciales = tiene2Parciales;
    }

    /**
     *
     * @return El hashCode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.alumno);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.examen);
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
        final InscripcionAExamen other = (InscripcionAExamen) obj;
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con caracteristicas de la inscripcion
     */
    @Override
    public String toString() {
        return "InscripcionAExamen{" + "alumno=" + alumno + ", fecha=" + fecha + ", habilitado=" + habilitado + ", notasPracticosBuenas=" + notasPracticosBuenas + ", aproboPrimerParcial=" + aproboPrimerParcial + ", asistencia=" + asistencia + ", notaObtenida=" + notaObtenida + ", tiene2Parciales=" + tiene2Parciales + '}';
    }



}
