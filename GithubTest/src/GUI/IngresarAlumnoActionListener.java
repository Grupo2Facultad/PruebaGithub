/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Carrera;
import githubtest.Regimen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class IngresarAlumnoActionListener implements ActionListener{
   private final IngresarAlumno info;
   private  Carrera seleccionada;

    public IngresarAlumnoActionListener(IngresarAlumno info) {
        this.info = info;
    }
   
    @Override
    public void actionPerformed(ActionEvent arg0) {
         try{
             check();
             Alumno alumno=new Alumno(info.getIngresoNombre().getText(),info.getIngresoApellido().getText(),
                     info.getIngresoDNI().getText(),info.getIngresoNumeroMatricula().getText());
             seleccionada.getAlumnos().add(alumno);
             //Testeando añadir un alumno para probar informes
             Main.POO.getCursantes().add(new Regimen(alumno,Main.POO,true));
             JOptionPane.showMessageDialog(null,"operacion exitosa");
             info.getFrame().setVisible(false);
       
         } 
         catch(Exception e){
             JOptionPane.showMessageDialog(null,"Falto Ingresar Algo o la Carrera es Invalida");
         }
    }
    public void check() throws Exception{
        boolean e=true;
        if (info.getIngresoApellido().getText().equals("Apellido")||info.getIngresoApellido().getText().equals("")){
            e=false;
        }
        if (info.getIngresoNombre().getText().equals("Nombre")||info.getIngresoNombre().getText().equals("")){
            e=false;
        }
        if (info.getIngresoDNI().getText().equals("DNI")||info.getIngresoDNI().getText().equals("")){
            e=false;
        }
        if (info.getIngresoNumeroMatricula().getText().equals("Numero Matricula")||info.getIngresoNumeroMatricula().getText().equals("")){
            e=false;
        }
        ArrayList<Carrera> carreras=Main.getRegistroDeCarreras().getCarreras();
        boolean t=false;
        for (Carrera carrera : carreras) {
            if(carrera.getNombre().equals(info.getIngresoCarrera().getText())){
                t=true;
                seleccionada=carrera;
            }
        }
        if(!e||!t){
            throw new Exception();
        }
 
    }
    
}
