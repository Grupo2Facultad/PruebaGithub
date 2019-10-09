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

    public DocenteExamen(RolExamenEnum rol, Docente docente) {
        this.rol = rol;
        this.docente = docente;
    }

    public RolExamenEnum getRol() {
        return rol;
    }

    public void setRol(RolExamenEnum rol) {
        this.rol = rol;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.rol);
        hash = 53 * hash + Objects.hashCode(this.docente);
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
        final DocenteExamen other = (DocenteExamen) obj;
        if (this.rol != other.rol) {
            return false;
        }
        if (!Objects.equals(this.docente, other.docente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocenteExamen{" + "rol=" + rol + ", docente=" + docente + '}';
    }
    
}
