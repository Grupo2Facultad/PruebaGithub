/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ClasesLogicas.Asignatura;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author juanc
 */
public class AsignaturasPorDni implements ActionListener{
    private JButton ingresar;
    private JTextFieldAdaptado ingresoDNI;
    private FechaComboBox fecha;
    private String DNI;
    class MostrarCantidadAlumnos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
          DNI=ingresoDNI.getText();
            LocalDate date=fecha.armado();
           Set<Asignatura> asignaturas=Main.getRegistroDeCarreras().getAsigPorDNI(DNI, date);
           ArrayList<Asignatura>asig = new ArrayList<>();
           asig.addAll(asignaturas);
          String asignaturasDNI="Las asignaturas cursadas son";
          ImpresionListado.Imprimir(asig,asignaturasDNI);
        }
}
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Frame frame=new Frame("Asignaturas Cursadas Por El Alumno con Determinado DNI en una determinada Fecha",ingresar);
        frame.setBounds(300, 200, 600, 500);
        Container container=frame.getContentPane();
        container.setLayout(new FlowLayout());
        ingresar=new JButton("Ingresar");
        ingresoDNI=new JTextFieldAdaptado("DNI",9);
        fecha=new FechaComboBox();
        container.add(ingresoDNI);
        container.add(fecha);
        container.add(ingresar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostrarCantidadAlumnos().actionPerformed(e);
            }
        };
        Enter enter = new Enter(ingresar, action);
        Escape escape = new Escape(frame);
        escape.setKey();
        
     }
    
}
