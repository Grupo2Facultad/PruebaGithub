/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class SobreEscribirActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        Frame frame = new Frame("Insribirse a Asignatura");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
    }
    
}
