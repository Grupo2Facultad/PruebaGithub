/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juanc
 */
public class PanelInformesAlumnado extends JPanel{
   protected JButton cantidadAlumnosCarreraPeriodo,
            carrerasPorDNI;
    protected JLabel label1;
    public PanelInformesAlumnado() {
        super();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        cantidadAlumnosCarreraPeriodo=new JButton("CantidadDeAlumnosCarreraPeriodo");
        cantidadAlumnosCarreraPeriodo.addActionListener(new CantidadAlumnosCarreraPeriodo());
        carrerasPorDNI=new JButton("CarrerasPorDNI");
        carrerasPorDNI.addActionListener(new CarrerasPorDNI());
        label1=new JLabel("Informes Alumnado");
        this.add(label1);
        this.add(cantidadAlumnosCarreraPeriodo);
        this.add(carrerasPorDNI);
       
    }
    
}
