/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Carrera;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class CarrerasPorDNI implements ActionListener{
private JTextField ingresarDNI;
private JButton ingresar;
class GetCarreras implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String DNI=ingresarDNI.getText();
            Set<Carrera> carreras=Main.registroDeCarreras.getCarreraPorDNI(DNI);
            String carrerasConFormato="Carreras:";
            for (Carrera carrera : carreras) {
                carrerasConFormato+=carrera;
            }
            if(!carreras.isEmpty()){
            JOptionPane.showMessageDialog(null,carrerasConFormato);
            }
            else{
            JOptionPane.showMessageDialog(null,"Dni invalido o no esta inscripto a ninguna carrera");
            }
        }
    
}
    @Override
    public void actionPerformed(ActionEvent arg0) {
         Frame frame=new Frame("Carreras Cursadas Por El Alumno con Determinado DNI" );
        Container container=frame.getContentPane();
        frame.setBounds(350, 250, 700, 400);
        ingresarDNI=new JTextFieldAdaptado("DNI");
        ingresar=new JButton("Ingesar DNI");
        ingresar.addActionListener(new GetCarreras());
        container.setLayout(new FlowLayout());
        container.add(ingresarDNI);
        container.add(ingresar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
