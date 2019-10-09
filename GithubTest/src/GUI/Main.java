/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.ActaFinal;
import githubtest.ActaParcial;
import githubtest.Asignatura;
import githubtest.BitacoraFinal;
import githubtest.Carrera;
import githubtest.Equipo;
import githubtest.Final;
import githubtest.Parcial;
import githubtest.PeriodoLectivoConAño;
import githubtest.PeriodoLectivoEnum;
import githubtest.PlanDeEstudio;
import githubtest.RegistroDeCarreras;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JButton;
/**
 *
 * @author juanc
 */ 

public class Main {
    static RegistroDeCarreras registroDeCarreras;
    private static Asignatura POO;
    private static Carrera LicenciaturaEnSistemas;
    private static Parcial parcial;
    private static Final eFinal;
    private static JButton bedelia;
    private static JButton alumnado;
    public static void main(String[] args) {
    añadirInformacionPorDefecto();
    Frame frame=new Frame("TallerPOO");
    Container container=frame.getContentPane();
    container.setLayout(new FlowLayout());
    bedelia=new JButton("Bedelia");
    bedelia.addActionListener((ActionListener)new Bedelia());
    alumnado= new JButton("Alumnado");
    alumnado.addActionListener(new Alumnado());
    container.add(bedelia);
    container.add(alumnado);
    frame.setVisible(true); 
    }
    public static void añadirInformacionPorDefecto() { 
        registroDeCarreras=new RegistroDeCarreras();
        //Comienza zona LicenciaturaSistemas
        LicenciaturaEnSistemas=new Carrera("LicenciaturaSistemas",1,LocalDate.of(2000,4,15),5);
        PlanDeEstudio DosMilQuince=new PlanDeEstudio(LocalDate.of(2015, Month.JANUARY, 14),
                LocalDate.of(2020, Month.DECEMBER, 31),LicenciaturaEnSistemas,5);
        LicenciaturaEnSistemas.getPlanesDeEstudio().add(DosMilQuince);
        POO= new Asignatura("POO","300","Programacion Orientada A Objetos",DosMilQuince,LicenciaturaEnSistemas,
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.Anual,2019),true,4,new Equipo(),new BitacoraFinal());
        Asignatura OE= new Asignatura("OE","250","Organizacion De Empresas",DosMilQuince,LicenciaturaEnSistemas,
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.Anual,2019),true,4,new Equipo(),new BitacoraFinal());
        Asignatura AM= new Asignatura("AM","400","Analisis Matematico",DosMilQuince,LicenciaturaEnSistemas,
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.Anual,2019),true,4,new Equipo(),new BitacoraFinal());
        Asignatura IN= new Asignatura("IN","200","Ingles Tecnico",DosMilQuince,LicenciaturaEnSistemas,
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.Anual,2019),true,4,new Equipo(),new BitacoraFinal());
        Asignatura ED= new Asignatura("ED","100","Estructura De Datos",DosMilQuince,LicenciaturaEnSistemas,
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.segundoCuatrimestre,2019),true,4,new Equipo(),new BitacoraFinal());
        Asignatura AC= new Asignatura("AC","100","Arquitectura De Computadoras",DosMilQuince,LicenciaturaEnSistemas,
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.segundoCuatrimestre,2019),true,4,new Equipo(),new BitacoraFinal());
        parcial=new Parcial(false,true,POO,PeriodoLectivoEnum.primerCuatrimestre,LocalDate.of(2019, Month.NOVEMBER,1),18);
        eFinal=new Final(true,false,POO,PeriodoLectivoEnum.Anual,LocalDate.of(2019,Month.NOVEMBER,5),18);
        POO.getExamenes().add(parcial);
        POO.getExamenes().add(eFinal);
        ActaParcial acta=new ActaParcial(parcial);
        ActaFinal actaFinal=new ActaFinal(eFinal);
        parcial.setActa(acta);
        eFinal.setActa(actaFinal);
        DosMilQuince.getAsignaturas().add(POO);
        DosMilQuince.getAsignaturas().add(ED);
        DosMilQuince.getAsignaturas().add(OE);
        DosMilQuince.getAsignaturas().add(AM);
        DosMilQuince.getAsignaturas().add(IN);
        DosMilQuince.getAsignaturas().add(AC);
        registroDeCarreras.getCarreras().add(LicenciaturaEnSistemas);
        //Finaliza zona LicenciaturaSistemas
        Carrera ContadorPublico=new Carrera("ContadorPublico",2,LocalDate.of(2000,3,15),5);
        registroDeCarreras.getCarreras().add(ContadorPublico);
        ///
         Carrera LicenciaturaAdministracion=new Carrera("LicenciaturaAdministracion",3,LocalDate.of(1985,3,15),5);
        registroDeCarreras.getCarreras().add(LicenciaturaAdministracion);
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
