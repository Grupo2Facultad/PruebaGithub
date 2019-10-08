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
import java.time.LocalDate;
import java.time.Month;
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
    public static void main(String[] args) {
    añadirInformacionPorDefecto();
    Frame frame=new Frame("TallerPOO");
    Container container=frame.getContentPane();
    container.setLayout(new BorderLayout());
    container.add(new PanelInfomesBedelia(),BorderLayout.WEST);
    container.add(new PanelIngresos(),BorderLayout.CENTER);
    container.add(new PanelInformesAlumnado(),BorderLayout.EAST);
    container.add(new PanelBusquedaCodigo(),BorderLayout.SOUTH);
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
