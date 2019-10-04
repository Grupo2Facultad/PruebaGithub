/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Asignatura;
import githubtest.BitacoraFinal;
import githubtest.Carrera;
import githubtest.Equipo;
import githubtest.PeriodoLectivoConAño;
import githubtest.PeriodoLectivoEnum;
import githubtest.PlanDeEstudio;
import githubtest.RegistroDeCarreras;
import java.awt.BorderLayout;
import java.awt.Container;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
/**
 *
 * @author juanc
 */ 

public class Main {
    static RegistroDeCarreras registroDeCarreras;
    static Asignatura POO;
    static Carrera LicenciaturaEnSistemas;
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
        registroDeCarreras=new RegistroDeCarreras();
        ArrayList<Carrera>carreras= registroDeCarreras.getCarreras();
        LicenciaturaEnSistemas=new Carrera("LicenciaturaSistemas",1,LocalDate.of(2000,4,15),5);
        PlanDeEstudio DosMilQuince=new PlanDeEstudio(LocalDate.of(2015, Month.JANUARY, 14),
                LocalDate.of(2020, Month.DECEMBER, 31),LicenciaturaEnSistemas,5);

        LicenciaturaEnSistemas.getPlanesDeEstudio().add(DosMilQuince);

        POO= new Asignatura(1,300,"Programacion Orientada a Objetos",DosMilQuince,LicenciaturaEnSistemas,
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.Anual,2018),true,4,new Equipo(),new BitacoraFinal());
        DosMilQuince.getAsignaturas().add(POO);
        carreras.add(LicenciaturaEnSistemas);
    }

    public static Carrera getLicenciaturaEnSistemas() {
        return LicenciaturaEnSistemas;
    }

    public static Asignatura getPOO() {
        return POO;
    }

    public static RegistroDeCarreras getRegistroDeCarreras() {
        return registroDeCarreras;
    }
    
}
