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
 *
 * @author juanc
 */
public abstract class Acta {
    private List<InscripcionAExamen> inscripciones;
    private Examen examen;

    public Acta(Examen examen) {
        this.examen = examen;
        this.inscripciones=new ArrayList<>();  
    }

    

    public abstract void imprimirActa();

    public List<Alumno> getHabilitados() {
        ArrayList<Alumno> habilitados = new ArrayList<Alumno>();
        for (InscripcionAExamen inscripcion : inscripciones) {
            if (inscripcion.isHabilitado()) {
                habilitados.add(inscripcion.getAlumno());
            }
        }
        return habilitados;
    }

    public List<InscripcionAExamen> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionAExamen> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public String toString() {
        String s = "Examen de" + examen.getAsignatura() + "realizado el dia" + examen.getFecha() + "\n";
        for (InscripcionAExamen inscripcione : inscripciones) {
            s = s + inscripcione + "\n";
        }
        return s;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.inscripciones);
        hash = 23 * hash + Objects.hashCode(this.examen);
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
