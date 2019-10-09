/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubtest;

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
    

    @Override
    public void imprimirActa() {
        //Esto va a cambiar cuando se pase a Swing
        System.out.println(this);
    }
    
}
