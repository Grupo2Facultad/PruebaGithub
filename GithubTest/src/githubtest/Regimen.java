/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

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


}
