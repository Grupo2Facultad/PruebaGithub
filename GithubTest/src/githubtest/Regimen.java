/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.util.Objects;

/**
 *
 * @author juanc
 */
public class Regimen {

    private Alumno alumno;
    private Asignatura asignatura;
    private boolean regularidad;

    public Regimen(Alumno alumno, Asignatura asignatura, boolean regularidad) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.regularidad = regularidad;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public boolean isRegularidad() {
        return regularidad;
    }

    public void setRegularidad(boolean regularidad) {
        this.regularidad = regularidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.alumno);
        hash = 37 * hash + Objects.hashCode(this.asignatura);
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
        final Regimen other = (Regimen) obj;
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.asignatura, other.asignatura)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Regimen{" + "alumno=" + alumno + ", asignatura=" + asignatura + ", regularidad=" + regularidad + '}';
    }


}
