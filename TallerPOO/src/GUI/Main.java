/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ClasesLogicas.ActaFinal;
import ClasesLogicas.ActaParcial;
import ClasesLogicas.Asignatura;
import ClasesLogicas.BitacoraFinal;
import ClasesLogicas.Carrera;
import ClasesLogicas.Equipo;
import ClasesLogicas.Final;
import ClasesLogicas.Parcial;
import ClasesLogicas.PeriodoLectivoConAño;
import ClasesLogicas.PeriodoLectivoEnum;
import ClasesLogicas.PlanDeEstudio;
import ClasesLogicas.RegistroDeCarreras;
import java.awt.Container;
import java.awt.*;
import java.awt.Toolkit;
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
    private static Parcial parcialRecuperatorio;
    private static Final eFinal;
    private static JButton bedelia;
    private static JButton alumnado;
    public static void main(String[] args) {
    añadirInformacionPorDefecto();
    Frame frame=new Frame("TallerPOO");
    Toolkit pantalla = Toolkit.getDefaultToolkit();
    Dimension mip = pantalla.getScreenSize();
    int h = mip.height;
    int w = mip.width;
    frame.setBounds(w/4, h/4, w/2, h/2);
    Container container=frame.getContentPane();
    container.setLayout(null);
    bedelia=new JButton("Bedelia");
    bedelia.addActionListener((ActionListener)new Bedelia());
    bedelia.setBounds(150, frame.getHeight()/4, frame.getWidth()/4, frame.getHeight()/4);
    alumnado= new JButton("Alumnado");
    alumnado.addActionListener(new Alumnado());
    alumnado.setBounds(450, frame.getHeight()/4, frame.getWidth()/4, frame.getHeight()/4);
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
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.primerCuatrimestre,2019),true,4,new Equipo(),new BitacoraFinal());
        parcial=new Parcial(false,true,POO,PeriodoLectivoEnum.segundoCuatrimestre,LocalDate.of(2019, Month.NOVEMBER,1),18);
        parcialRecuperatorio=new Parcial(true,true,POO,PeriodoLectivoEnum.segundoCuatrimestre,LocalDate.of(2019, Month.NOVEMBER,2),18);
        Parcial parcial2=new Parcial(false,false,POO,PeriodoLectivoEnum.segundoCuatrimestre,LocalDate.of(2019, Month.NOVEMBER,3),18);
        Parcial parcialRecuperatorio2=new Parcial(true,false,POO,PeriodoLectivoEnum.segundoCuatrimestre,LocalDate.of(2019, Month.NOVEMBER,4),18);
        eFinal=new Final(true,true,POO,PeriodoLectivoEnum.Anual,LocalDate.of(2019,Month.NOVEMBER,5),18);
        POO.getExamenes().add(parcial);
        POO.getExamenes().add(parcial2);
        POO.getExamenes().add(parcialRecuperatorio);
        POO.getExamenes().add(parcialRecuperatorio2);
        POO.getExamenes().add(eFinal);
        ActaParcial acta=new ActaParcial(parcial);
        ActaParcial acta2=new ActaParcial(parcial2);
        ActaParcial actaRecuperatorio=new ActaParcial(parcialRecuperatorio);
        ActaParcial actaRecuperatorio2=new ActaParcial(parcialRecuperatorio2);
        ActaFinal actaFinal=new ActaFinal(eFinal);
        parcial.setActa(acta);
        parcial2.setActa(acta2);
        parcialRecuperatorio.setActa(actaRecuperatorio);
        parcialRecuperatorio2.setActa(actaRecuperatorio2);
        eFinal.setActa(actaFinal);
        DosMilQuince.getAsignaturas().add(POO);
        DosMilQuince.getAsignaturas().add(ED);
        DosMilQuince.getAsignaturas().add(OE);
        DosMilQuince.getAsignaturas().add(AM);
        DosMilQuince.getAsignaturas().add(IN);
        DosMilQuince.getAsignaturas().add(AC);
        registroDeCarreras.getCarreras().add(LicenciaturaEnSistemas);
        ///Finaliza zona LicenciaturaSistemas
        Carrera ContadorPublico=new Carrera("ContadorPublico",2,LocalDate.of(2000,3,15),5);
        registroDeCarreras.getCarreras().add(ContadorPublico);
        ///
         Carrera LicenciaturaAdministracion=new Carrera("LicenciaturaAdministracion",3,LocalDate.of(1985,3,15),5);
        registroDeCarreras.getCarreras().add(LicenciaturaAdministracion);
        ///
        Carrera Turismo=new Carrera("Turismo",4,LocalDate.of(2010,6,17),4);
        registroDeCarreras.getCarreras().add(Turismo);
        
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
