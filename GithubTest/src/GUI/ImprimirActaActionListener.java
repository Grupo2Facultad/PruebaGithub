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
import static java.time.temporal.ChronoUnit.HOURS;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class ImprimirActaActionListener implements ActionListener {

    private JTextField codigoAsig,
            ingresoAño,
            ingresoMes,
            ingresoDia;
    private JLabel slash,
            slash2;
    private JButton ingresar;

    class ImprimirActa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            int año = Integer.parseInt(ingresoAño.getText());
            int mes = Integer.parseInt(ingresoMes.getText());
            int dia = Integer.parseInt(ingresoDia.getText());
            ArrayList<Alumno> habilitados = new ArrayList<>();
            LocalDate fecha = LocalDate.of(año, mes, dia);
            ArrayList<Asignatura> asignaturas = Main.registroDeCarreras.getAsignaturasPorFechaPlanDeEstudio(fecha);
            boolean t = false;
            boolean f = false;
            boolean s = false;
            for (Asignatura asignatura : asignaturas) {
                if (asignatura.getCodigo().equals(codigoAsig.getText())) {
                    t = true;
                    ArrayList<Examen> examenes = (ArrayList) asignatura.getExamenes();
                    for (Examen examene : examenes) {
                        if (examene.getFecha().equals(fecha)) {
                            f=true;
                            if (examene instanceof Final) {
                                s=true;
                                    ActaFinal actaFinal = (ActaFinal) examene.getActa();
                                    actaFinal.cerrarActa();
                                    actaFinal.imprimirActa();

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
                if(!s){
                    JOptionPane.showMessageDialog(null,"Ese Examen no es un Final");
                }

            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
         Frame frame=new Frame("Imprimir Acta");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(300, 250, 600, 400);
        Container container=frame.getContentPane();
        container.setLayout(null);
        codigoAsig=new JTextField("Codigo de Asignatura",20);
        codigoAsig.setBounds(100, 100, 150, 25);
        ingresar = new JButton("Ingresar");
        ingresar.setBounds(190, 160, 150, 30);
        ingresoAño=new JTextField("Año",5);
        ingresoAño.setBounds(270, 100, 50, 25);
        ingresoMes=new JTextField("Mes",3);
        ingresoMes.setBounds(340, 100, 40, 25);
        ingresoDia=new JTextField("Dia",3);
        ingresoDia.setBounds(400, 100, 40, 25);
        slash=new JLabel("/");
        slash.setBounds(325, 98, 15, 25);
        slash2=new JLabel("/");
        slash2.setBounds(385, 98, 15, 25);
        ingresar.addActionListener(new ImprimirActa ());
        container.add(codigoAsig);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(ingresar);
    }
    
}
