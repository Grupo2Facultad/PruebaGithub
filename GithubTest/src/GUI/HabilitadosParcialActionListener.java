/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Asignatura;
import githubtest.Examen;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class HabilitadosParcialActionListener implements ActionListener{
private JTextField codigoAsig,
         ingresoAño,
            ingresoMes,
            ingresoDia;
    private JLabel slash,
            slash2;
private JButton ingresar;
class Ingresar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            int año=Integer.parseInt(ingresoAño.getText());
          int mes=Integer.parseInt(ingresoMes.getText());
          int dia=Integer.parseInt(ingresoDia.getText());
          ArrayList<Alumno>habilitados=new ArrayList<>();
            LocalDate fecha=LocalDate .of(año,mes,dia); 
            ArrayList<Asignatura>asignaturas=Main.registroDeCarreras.getAsignaturasPorFechaPlanDeEstudio(fecha);
            boolean t=false;
            boolean f=false;
            for (Asignatura asignatura : asignaturas) {
                if(asignatura.getCodigo().equals(codigoAsig.getText())){
                   t=true;
                    ArrayList<Examen> examenes=(ArrayList)asignatura.getExamenes();
                    for (Examen examene : examenes) {
                        if(examene.getFecha().equals(fecha)){
                            f=true;
                           habilitados=(ArrayList)examene.getActa().getHabilitados();
                        }
                    }
                }
            }
            if(!t){
                JOptionPane.showMessageDialog(null,"ese codigo no es valido");
                return;
            }
            if(!f){
                JOptionPane.showMessageDialog(null,"esa Asignatura no tiene un examen en esa fecha");
                return;
            } 
            String alumnos="Alumnos:";
            if(!habilitados.isEmpty()){
            for (Alumno habilitado : habilitados) {            
                alumnos+=habilitado;
            }
            JOptionPane.showMessageDialog(null,alumnos);
             System.out.println(habilitados);
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay nadie habilitado");
            }
            
        }
}
    @Override
    public void actionPerformed(ActionEvent arg0) {
       Frame frame=new Frame("Habilitados al Parcial");
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container=frame.getContentPane();
        container.setLayout(new FlowLayout());
        codigoAsig=new JTextField("Codigo de Asignatura",20);
        ingresar = new JButton("ingresar");
        ingresoAño=new JTextField("año",5);
        ingresoMes=new JTextField("mes",3);
        ingresoDia=new JTextField("dia",3);
        slash=new JLabel("/");
        slash2=new JLabel("/");
        ingresar.addActionListener(new Ingresar());
        container.add(codigoAsig);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(ingresar);
    }
    
}
