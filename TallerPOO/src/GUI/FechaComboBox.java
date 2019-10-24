/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ClasesLogicas.Carrera;
import java.awt.FlowLayout;
import java.time.DateTimeException;
import java.time.LocalDate;
import static java.time.LocalDate.of;
import java.time.Month;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Alumno
 */
public class FechaComboBox extends JPanel{
private JComboBox años,
        meses,
        dias;
private JLabel slash,
        slash2;
          
    public FechaComboBox() {
        this.setLayout(new FlowLayout());
        slash=new JLabel("/");
        slash2=new JLabel("/");
        años=new JComboBox();
        meses=new JComboBox();
        dias=new JComboBox();
        this.add(años);
        this.add(slash);
        this.add(meses);
        this.add(slash);
        this.add(dias);
        create();
         }
    public void create() {
        for (int i =LocalDate.now().getYear(); i > 1990; i--) {
            años.addItem(i);
        }
        for (int j = 1; j < 13; j++) {
            meses.addItem(j);
        }
        for (int j = 1; j < 32; j++) {
            dias.addItem(j);
        }
    }
    public LocalDate armado(){
        
        try{
       LocalDate date =LocalDate.of((int)años.getSelectedItem(),(int)meses.getSelectedItem(),(int)dias.getSelectedItem());
         return date;
        }
        catch(DateTimeException d){
            JOptionPane.showMessageDialog(null," fecha Invalida");
        }
       return null;
    }
}

