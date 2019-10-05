/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Carrera;
import githubtest.Docente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class IngresarDocenteActionListener implements ActionListener{

private final IngresarDocente info;   
private Carrera seleccionada;

    public IngresarDocenteActionListener(IngresarDocente info) {
        this.info = info;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            check();
            Docente docente = new Docente(info.getIngresoNumeroLegajo().getText(), info.getIngresoADocencia().getText(),
                    info.getIngresoNombre().getText(), info.getIngresoApellido().getText(), info.getIngresoDNI().getText());
            
            JOptionPane.showMessageDialog(null, "operacion exitosa");
            info.getFrame().setVisible(false);
        } catch (YaExisteException ex) {
            JOptionPane.showMessageDialog(null, "Ese Docente ya existe en esa Carrera");
        } catch (CodigoIDentificacionYaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falto Ingresar Algo o la Carrera es Invalida");
        }
    }
    
    public void check() throws Exception {
        boolean e = true;
        if (info.getIngresoApellido().getText().equals("Apellido*") || info.getIngresoApellido().getText().equals("")) {
            e = false;
        }
        if (info.getIngresoNombre().getText().equals("Nombre*")||info.getIngresoNombre().getText().equals("")){
            e=false;
        }
        if (info.getIngresoDNI().getText().equals("DNI*")||info.getIngresoDNI().getText().equals("")){
            e=false;
        }
        if (info.getIngresoNumeroLegajo().getText().equals("Numero Legajo*")||info.getIngresoNumeroLegajo().getText().equals("")){
            e=false;
        }
        //MAl
        ArrayList<Carrera> carreras=Main.getRegistroDeCarreras().getCarreras();
        boolean t=false;
        for (Carrera carrera : carreras) {
            if(carrera.getNombre().equals(info.getIngresoCarrera().getText())){
                Set<Docente>yaExiste=carrera.getDocentes();
                for (Docente docente : yaExiste) {
                    if(docente.equals(new Docente (info.getIngresoNombre().getText(),info.getIngresoApellido().getText(),
                            info.getIngresoDNI().getText()))){
                        throw new YaExisteException("ya existe ese Docente");
                    }
                      if(docente.getNumeroLegajo().equals(info.getIngresoNumeroLegajo().getText())){
                        throw new CodigoIDentificacionYaExisteException("Ese numero de Legajo ya existe");
                    }
                }
                t=true;
                seleccionada=carrera;
            }
        }
        if(!e||!t){
            throw new Exception();
        }
 
    }
    
    
}
