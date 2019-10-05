/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Acta;
import githubtest.Asignatura;
import githubtest.BitacoraFinal;
import githubtest.Carrera;
import githubtest.Equipo;
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
        //Comienza zona LicenciaturaSistemas
        LicenciaturaEnSistemas=new Carrera("LicenciaturaSistemas",1,LocalDate.of(2000,4,15),5);
        PlanDeEstudio DosMilQuince=new PlanDeEstudio(LocalDate.of(2015, Month.JANUARY, 14),
                LocalDate.of(2020, Month.DECEMBER, 31),LicenciaturaEnSistemas,5);
        LicenciaturaEnSistemas.getPlanesDeEstudio().add(DosMilQuince);
        POO= new Asignatura("1","300","POO",DosMilQuince,LicenciaturaEnSistemas,
                2,new PeriodoLectivoConAño(PeriodoLectivoEnum.Anual,2018),true,4,new Equipo(),new BitacoraFinal());
        Parcial parcial=new Parcial(false,true,POO,PeriodoLectivoEnum.primerCuatrimestre,LocalDate.of(2018, Month.MARCH, 5),18);
        POO.getExamenes().add(parcial);
        DosMilQuince.getAsignaturas().add(POO);
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
