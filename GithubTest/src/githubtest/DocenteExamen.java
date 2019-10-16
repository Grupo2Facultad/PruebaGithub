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
public class DocenteExamen {
    private RolExamenEnum rol;
    private Docente docente;

    /**
     *
     * @param rol
     * @param docente
     */
    public DocenteExamen(RolExamenEnum rol, Docente docente) {
        this.rol = rol;
        this.docente = docente;
    }

    /**
     *
     * @return El rol del docente en el examen
     */
    public RolExamenEnum getRol() {
        return rol;
    }

    /**
     *
     * @param rol
     */
    public void setRol(RolExamenEnum rol) {
        this.rol = rol;
    }

    /**
     *
     * @return Un docente presente en el examen
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     *
     * @param docente
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     *
     * @return el hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.rol);
        hash = 53 * hash + Objects.hashCode(this.docente);
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
        final DocenteExamen other = (DocenteExamen) obj;
        if (this.rol != other.rol) {
            return false;
        }
        if (!Objects.equals(this.docente, other.docente)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con el rol y el numero de legajo de un docente
     */
    @Override
    public String toString() {
        return "DocenteExamen{" + "rol=" + rol + ", docente=" + docente + '}';
    }
    
}
