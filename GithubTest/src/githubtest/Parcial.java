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
public class Parcial extends Examen{
    private boolean recuperatorio;
    private boolean primeroTrueSegundoFalse;

    public boolean isRecuperatorio() {
        return recuperatorio;
    }

    public void setRecuperatorio(boolean recuperatorio) {
        this.recuperatorio = recuperatorio;
    }

    public boolean isPrimeroTrueSegundoFalse() {
        return primeroTrueSegundoFalse;
    }

    public void setPrimeroTrueSegundoFalse(boolean primeroTrueSegundoFalse) {
        this.primeroTrueSegundoFalse = primeroTrueSegundoFalse;
    }

    @Override
    public Acta HacerActa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean controlarNotas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
