/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class HabilitadosParcialActionListener implements ActionListener{
private JTextField codigoParcial;
private JButton ingresar;
class Ingresar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            ArrayList<Alumno> habilitados=(ArrayList)Main.parcial.getActa().getHabilitados();
            String alumnos="";
            for (Alumno habilitado : habilitados) {            
                alumnos+="\n"+habilitado;
            }
            JOptionPane.showMessageDialog(null,alumnos);
        }
    
}
    @Override
    public void actionPerformed(ActionEvent arg0) {
       Frame frame=new Frame("Habilitados al Parcial");
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container=frame.getContentPane();
        container.setLayout(new FlowLayout());
        codigoParcial=new JTextField("Codigo de Parcial",20);
        ingresar = new JButton("ingresar");
        ingresar.addActionListener(new Ingresar());
        container.add(codigoParcial);
        container.add(ingresar);
    }
    
}
