/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

import java.util.List;

/**
 *
 * @author juanc
 */
public class Final extends Examen {
//Este atributo es nuevo(no esta en UML)

    private boolean regular;
//
    private List<DocenteExamen> docenteExamen;

    /*
    public List<Docente> getDocentes() {
    }
     */
    @Override
    public Acta HacerActa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean controlarNotas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
