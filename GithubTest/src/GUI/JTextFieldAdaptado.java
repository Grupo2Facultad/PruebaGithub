/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class JTextFieldAdaptado extends JTextField{

    public JTextFieldAdaptado(String text, int columns) {
        super(text, columns);
           this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                setText("");
            }
        });
        
    }

    public JTextFieldAdaptado(String text) {
        super(text);
          this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                setText("");
            }
        });
    }
   @Override
   public String getText(){
       return super.getText();
   }
}
