/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class ImpresionListado {

    public static void Imprimir(ArrayList<Object> array,String s) {
        Dimension dimension = new Dimension(1000, 1000);
        Frame fra = new Frame("Imresion");
        fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fra.setVisible(true);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension mip = pantalla.getScreenSize();
        int h = mip.height;
        int w = mip.width;
        fra.setBounds(0, 0, w, h);
        Container con = fra.getContentPane();
        con.setLayout(new BoxLayout(con,BoxLayout.Y_AXIS));
        con.add(new JLabel(s));
        for (Object object : array) {
            con.add(new JLabel(object.toString()));
        }
   }
    
}
