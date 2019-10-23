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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class BuscarCodigoAsignaturaActionListener implements ActionListener {
private FechaComboBox fecha;
    private JComboBox carrera;

    public BuscarCodigoAsignaturaActionListener(FechaComboBox fecha, JComboBox carrera) {
        this.fecha = fecha;
        this.carrera = carrera;
    }

   

    @Override
    public void actionPerformed(ActionEvent arg0) {
        check();
        ArrayList<Asignatura> asignaturas = Main.getRegistroDeCarreras().getAsignaturasPorFechaPlanDeEstudio(fecha.armado());
        ArrayList<Asignatura> coincidencias = new ArrayList<>();
        for (Asignatura asignatura1 : asignaturas) {
            System.out.println("llego acaasignatura");
            if (asignatura1.getPeriodoLectivo().getAño() == fecha.armado().getYear()&& asignatura1.getCarrera().getNombre().equals(carrera.getSelectedItem())) {
                System.out.println("llego a las opciones");
                if (asignatura1.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.primerCuatrimestre) && fecha.armado().getMonthValue() <= 6) {
                    coincidencias.add(asignatura1);
                }
                if (asignatura1.getPeriodoLectivo().getPeriodoLectivo().equals(PeriodoLectivoEnum.segundoCuatrimestre) && fecha.armado().getMonthValue()> 6) {
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
            if (carrera1.getNombre().equals(carrera.getSelectedItem())) {
                e = true;
            }
        }
        if (!e) {
            JOptionPane.showMessageDialog(null, "Carrera no existente");
        }
    }
    
}
