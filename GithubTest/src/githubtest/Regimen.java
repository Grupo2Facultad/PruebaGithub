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

    /**
     *
     * @param alumno
     * @param asignatura
     * @param regularidad
     */
    public Regimen(Alumno alumno, Asignatura asignatura, boolean regularidad) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.regularidad = regularidad;
    }

    /**
     *
     * @return Alumno
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
     * @return Asignatura a la que corresponde el regimen
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     *
     * @param asignatura
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     *
     * @return La regularidad del alumno
     */
    public boolean isRegularidad() {
        return regularidad;
    }

    /**
     *
     * @param regularidad
     */
    public void setRegularidad(boolean regularidad) {
        this.regularidad = regularidad;
    }

    /**
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.alumno);
        hash = 37 * hash + Objects.hashCode(this.asignatura);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
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
        final Regimen other = (Regimen) obj;
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.asignatura, other.asignatura)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con las caracteristicas del regimen
     */
    @Override
    public String toString() {
        return "Regimen{" + "alumno=" + alumno + ", asignatura=" + asignatura + ", regularidad=" + regularidad + '}';
    }


}
