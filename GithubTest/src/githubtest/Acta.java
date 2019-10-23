/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *Clase abstracta de un Acta
 * @author juanc
 */
public abstract class Acta {
    private String algo;
    private List<InscripcionAExamen> inscripciones;
    private Examen examen;

    /**
     *
     * @param examen
     */
    public Acta(Examen examen) {
        this.examen = examen;
        this.inscripciones=new ArrayList<>();  
    }

    /**
     *
     */
    public abstract void imprimirActa();

    /**
     *
     * @return Lista de habilitados a examen

     */
    public List<InscripcionAExamen> getHabilitados() {
        ArrayList<InscripcionAExamen> habilitados = new ArrayList<>();
        for (InscripcionAExamen inscripcion : inscripciones) {
            if (inscripcion.isHabilitado()) {
                habilitados.add(inscripcion);
            }
        }
        return habilitados;
    }

    /**
     *

     * @return Lista de inscriptos al examen
     */
    public List<InscripcionAExamen> getInscripciones() {
        return inscripciones;
    }

    /**
     *
     * @param inscripciones
     */
    public void setInscripciones(List<InscripcionAExamen> inscripciones) {
        this.inscripciones = inscripciones;
    }

    /**
     *
     * @return Examen al que corresponde el acta
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
     * @return Acta en forma de cadena de caracteres
     */
    @Override
    public String toString() {
        String s = "Examen de" + examen.getAsignatura() + "realizado el dia" + examen.getFecha() + "\n";
        for (InscripcionAExamen inscripcione : inscripciones) {
            s = s + " "+ inscripcione.getAlumno()+" " +"Nota: "+inscripcione.getNotaObtenida()+ "\n";
        }
        return s;

    }

    /**
     *
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.inscripciones);
        hash = 23 * hash + Objects.hashCode(this.examen);
        return hash;
    }

    /**
     *
     * @param obj
     * @return Booleano sobre la igualdad del objeto acta
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
        final Acta other = (Acta) obj;
        if (!Objects.equals(this.inscripciones, other.inscripciones)) {
            return false;
        }
        if (!Objects.equals(this.examen, other.examen)) {
            return false;
        }
        return true;
    }

}
