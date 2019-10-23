/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.ActaFinal;
import githubtest.Alumno;
import githubtest.Asignatura;
import githubtest.Examen;
import githubtest.Final;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class ImprimirActaActionListener implements ActionListener {

    private JTextFieldAdaptado codigoAsig;
    private FechaComboBox fecha;
    private JButton ingresar;

    class ImprimirActa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            ArrayList<Asignatura> asignaturas = Main.registroDeCarreras.getAsignaturasPorFechaPlanDeEstudio(fecha.armado());
            boolean t = false;
            boolean f = false;
            boolean s = false;
            for (Asignatura asignatura : asignaturas) {
                if (asignatura.getCodigo().equals(codigoAsig.getText())) {
                    t = true;
                    ArrayList<Examen> examenes = (ArrayList) asignatura.getExamenes();
                    for (Examen examene : examenes) {
                        if (examene.getFecha().equals(fecha.armado())) {
                            f = true;
                            if (examene instanceof Final) {
                                s = true;
                                ActaFinal actaFinal = (ActaFinal) examene.getActa();
                                actaFinal.cerrarActa();
                                actaFinal.imprimirActa();
                            }
                        }
                    }
                }
            }
            if (!t) {
                JOptionPane.showMessageDialog(null, "ese codigo no es valido");
                return;
            }
            if (!f) {
                JOptionPane.showMessageDialog(null, "esa Asignatura no tiene un examen en esa fecha");
                return;
            }
            if (!s) {
                JOptionPane.showMessageDialog(null, "Ese Examen no es un Final");
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        Frame frame=new Frame("Imprimir Acta",ingresar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(300, 250, 600, 400);
        Container container=frame.getContentPane();
        container.setLayout(new FlowLayout());
        codigoAsig=new JTextFieldAdaptado("Codigo de Asignatura");
        ingresar = new JButton("Ingresar");
        fecha= new FechaComboBox();
        container.add(codigoAsig);
        container.add(fecha);
        container.add(ingresar);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ImprimirActa().actionPerformed(e);
            }
        };
        Enter enter = new Enter(ingresar, action);
    }
    
}
