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
enum RolExamenEnum {
    TITULAR("titular"),
    VVOCAL1("Vocal1"),
    VOCAL2("Vocal2"),
    SUPLENTE("Suplente");
    
    private String descripcion;

    private RolExamenEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "RolExamenEnum{" + "descripcion=" + descripcion + '}';
    }
    
    
    
}
