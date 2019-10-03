/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author juanc
 */ 

public class Main {
    static JLabel label1,
            label2,
            label3;
    static JButton cantidadAlumnosCarreraPeriodo,
            carrerasPorDNI;
    static JButton habilitadosParcial,
            habilitadosFinal,
            asignaturasPorDNI,
            profesoresProAsignatura,
            imprimirActa;
    static JButton ingresarAlumno,
            ingresarDocente;
    public static void main(String[] args) {
    Frame frame=new Frame("TallerPOO");
    JPanel panelInformesALumnado= new JPanel();
    JPanel panelInformesBedelia= new JPanel();
    JPanel panelIngresos= new JPanel();
    panelInformesALumnado.setLayout(new BoxLayout(panelInformesALumnado,BoxLayout.Y_AXIS));
    panelInformesBedelia.setLayout(new BoxLayout(panelInformesBedelia,BoxLayout.Y_AXIS));
    panelIngresos.setLayout(new FlowLayout());
    Container container=frame.getContentPane();
    label1=new JLabel("Informes Alumnado");
    label2=new JLabel("Informes Bedelia");
    label3=new JLabel("Ingresos");
    cantidadAlumnosCarreraPeriodo=new JButton("CantidadDeAlumnosCarreraPeriodo");
    carrerasPorDNI=new JButton("CarrerasPorDNI");
     habilitadosParcial=new JButton("HabiltiadosParcial");
    habilitadosFinal=new JButton("HabilitadosFinal");
    asignaturasPorDNI=new JButton("AsignaturasPorDNI");
    profesoresProAsignatura=new JButton("ProfesoesAsignatura");
    imprimirActa=new JButton("ImprimirActa");
    ingresarAlumno=new JButton("ingresarAlumno");
    ingresarDocente=new JButton("ingresarDocente");
    panelInformesBedelia.add(label2);
    panelInformesBedelia.add(habilitadosParcial);
    panelInformesBedelia.add(habilitadosFinal);
    panelInformesBedelia.add(asignaturasPorDNI);
    panelInformesBedelia.add(profesoresProAsignatura);
    panelInformesBedelia.add(imprimirActa);
    panelIngresos.add(label3);
    panelIngresos.add(ingresarAlumno);
    panelIngresos.add(ingresarDocente);
    panelInformesALumnado.add(label1);
    panelInformesALumnado.add(cantidadAlumnosCarreraPeriodo);
    panelInformesALumnado.add(carrerasPorDNI);
    container.setLayout(new BorderLayout());
    container.add(panelInformesBedelia,BorderLayout.WEST);
    container.add(panelIngresos,BorderLayout.CENTER);
    container.add(panelInformesALumnado,BorderLayout.EAST);
    frame.setVisible(true);
    }
    
}
