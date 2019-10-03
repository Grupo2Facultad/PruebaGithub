/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Carrera;
import githubtest.PlanDeEstudio;
import githubtest.RegistroDeCarreras;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author juanc
 */ 

public class Main {
    public static void main(String[] args) {
    añadirInformacionPorDefecto();
    Frame frame=new Frame("TallerPOO");
    Container container=frame.getContentPane();
    container.setLayout(new BorderLayout());
    container.add(new PanelInfomesBedelia(),BorderLayout.WEST);
    container.add(new PanelIngresos(),BorderLayout.CENTER);
    container.add(new PanelInformesAlumnado(),BorderLayout.EAST);
    frame.setVisible(true); 
    }
    public static void añadirInformacionPorDefecto() { 
     RegistroDeCarreras registroDeCarreras=new RegistroDeCarreras(new ArrayList<>());
        ArrayList<Carrera>carreras= registroDeCarreras.getCarreras();
        carreras.add(new Carrera("LicenciaturaDeSistemas",1,LocalDate.of(2000,4,15),5,new ArrayList<>(),new ArrayList<>()));
    }
}
