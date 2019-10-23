/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author juanc
 */
public class ImpresionListado {

    public static void Imprimir(ArrayList array,String s) {
        Frame frame = new Frame("Impresion");
        Escape escape = new Escape(frame);
        escape.setKey();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension mip = pantalla.getScreenSize();
        int h = mip.height;
        int w = mip.width;
        frame.setBounds(0, 0, w, h);
        Container con = frame.getContentPane();
        con.setLayout(new BoxLayout(con,BoxLayout.Y_AXIS));
        con.add(new JLabel(s));
        for (Object object : array) {
            con.add(new JLabel(object.toString()));
        }
   }
    
}
