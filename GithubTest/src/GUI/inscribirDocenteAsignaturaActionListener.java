/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Asignatura;
import githubtest.Docente;
import githubtest.Rol;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alumno
 */
public class inscribirDocenteAsignaturaActionListener implements ActionListener{
private JButton inscribir;
private JTextField matricula,
                 codigoAsig,
        dedicacion,
        cargo,
        fechaIngreso,
        fechaFinal;
    private Frame frame;

    class Inscribir implements ActionListener {

        private Asignatura seleccionadaA;

        @Override
        public void actionPerformed(ActionEvent ae) {
            ArrayList<Asignatura> asignaturas = Main.registroDeCarreras.getAsignaturasPorFechaPlanDeEstudio(LocalDate.now());
            for (Asignatura asignatura : asignaturas) {
                boolean e=false;
                if (asignatura.getCodigo().equals(codigoAsig.getText())) {
                    e=true;
                    seleccionadaA = asignatura;
                    Set<Docente>profesores =asignatura.getCarrera().getDocentes();
                    boolean t=false;
                    for (Docente profesore : profesores) {
                        t=true;
                        boolean i=false;
                       if(profesore.getNumeroLegajo().equals(matricula.getText())){
                           i=true;
                           asignatura.getEquipo().getRoles().add(new Rol(profesore,dedicacion.getText(),cargo.getText(),fechaIngreso.getText(),fechaFinal.getText()));
                           JOptionPane.showMessageDialog(null,"Operacion Exitosa");
                       } 
                       if(!i){
                           JOptionPane.showMessageDialog(null,"Ese Docente No Dicta En Esa Carrera");
                       }
                    }
                    if(t=false){
                        JOptionPane.showMessageDialog(null,"Numero de Matricula Invalido");
                    }
                }
                if(e=false){
                    JOptionPane.showMessageDialog(null,"Codigo Invalido");
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

            frame = new Frame("Ingreso De Docente");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setBounds(250, 200, 650, 450);
            Container container=frame.getContentPane();
            container.setLayout(null);
            this.inscribir=new JButton("Ingresar");
            inscribir.setBounds(270, 300, 120, 30);
            inscribir.addActionListener(new Inscribir());
            matricula = new JTextField("Matricula",5);
            matricula.setBounds(100, 100, 120, 25);
            cargo= new JTextField("Cargo",20);
            cargo.setBounds(270, 100, 120, 25);
            dedicacion=new JTextField("Dedicacion", 20);
            dedicacion.setBounds(430, 100, 120, 25);
            codigoAsig = new JTextField("Codigo de Asignatura",20);
            codigoAsig.setBounds(100, 200, 120, 25);
            fechaIngreso = new JTextField("Fecha de Ingreso",20);
            fechaIngreso.setBounds(270, 200, 120, 25);
            fechaFinal = new JTextField("Fecha de Final",20);
            fechaFinal.setBounds(430, 200, 120, 25);
            container.add(matricula);
            container.add(codigoAsig);
            container.add(fechaIngreso);
            container.add(fechaFinal);
            container.add(dedicacion);
            container.add(cargo);
            container.add(inscribir);
    }    
}
