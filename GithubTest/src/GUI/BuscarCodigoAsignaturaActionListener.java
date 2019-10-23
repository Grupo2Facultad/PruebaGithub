/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Asignatura;
import githubtest.Carrera;
import githubtest.PeriodoLectivoEnum;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class BuscarCodigoAsignaturaActionListener implements ActionListener {

    private JTextFieldAdaptado año,
            mes,
            dia;

    private JTextFieldAdaptado carrera;

    public BuscarCodigoAsignaturaActionListener(JTextFieldAdaptado año, JTextFieldAdaptado mes, JTextFieldAdaptado dia, JTextFieldAdaptado carrera) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        this.carrera = carrera;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println(carrera.getText());
        check();
        System.out.println("la"+this.año.getText()+"aasd");
        int añoF = Integer.parseInt(this.año.getText());
        int mesF = Integer.parseInt(this.mes.getText());
        int diaF = Integer.parseInt(this.dia.getText());
        ArrayList<Asignatura> asignaturas = Main.getRegistroDeCarreras().getAsignaturasPorFechaPlanDeEstudio(LocalDate.of(añoF, mesF, diaF));
        ArrayList<Asignatura> coincidencias = new ArrayList<>();
        for (Asignatura asignatura1 : asignaturas) {
            System.out.println("llego acaasignatura");
            if (asignatura1.getPeriodoLectivo().getAño() == añoF && asignatura1.getCarrera().getNombre().equals(carrera.getText())) {
                System.out.println("llego a las opciones");
                if (asignatura1.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.primerCuatrimestre) && mesF <= 6) {
                    coincidencias.add(asignatura1);
                }
                if (asignatura1.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.segundoCuatrimestre) && mesF > 6) {
                    coincidencias.add(asignatura1);
                }
                if (asignatura1.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.Anual)) {
                    coincidencias.add(asignatura1);
                }
            }

        }
        String todas = "Asignaturas disponibles: ";
        System.out.println(todas);
       ImpresionListado.Imprimir((ArrayList)coincidencias,todas);
       
    }

    public void check() {
        boolean e = false;
        ArrayList<Carrera> carreras = (ArrayList) Main.getRegistroDeCarreras().getCarreras();
        for (Carrera carrera1 : carreras) {
            if (carrera1.getNombre().equals(carrera.getText())) {
                e = true;
            }
        }
        if (!e) {
            JOptionPane.showMessageDialog(null, "Carrera no existente");
        }
    }
    
}
