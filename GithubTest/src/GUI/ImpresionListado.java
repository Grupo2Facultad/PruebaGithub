/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class ImpresionListado{

   public static void Imprimir(String alumnos){
       System.out.println("llego aca");
            JTextField texto= new JTextField(alumnos);
             texto.setSize(750, 545);
            Frame fra= new Frame("Imresion");
            fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fra.setVisible(true);
            fra.setSize(550,800);
            Container con=fra.getContentPane();
            con.setLayout(new FlowLayout());
            con.add(texto);
   }
    
}
