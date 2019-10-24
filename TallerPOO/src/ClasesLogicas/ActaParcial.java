/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesLogicas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanc
 */
public class ActaParcial extends Acta{

    public ActaParcial(Examen examen) {
        super(examen);
    }
    /**
     * No se implementa porque no se usa
     */
    @Override
    public void imprimirActa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
