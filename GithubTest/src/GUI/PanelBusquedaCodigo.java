/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Carrera;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juanc
 */
public class PanelBusquedaCodigo extends JPanel {

    private final JTextFieldAdaptado ingresoAño,
            ingresoMes,
            ingresoDia;
    private JComboBox carrera;
    private final JButton buscarCodigo;
    private final JLabel slash,
            slash2;

    public PanelBusquedaCodigo() {
        this.setLayout(new FlowLayout());
        ingresoAño = new JTextFieldAdaptado("Año", 5);
        ingresoMes = new JTextFieldAdaptado("Mes", 3);
        ingresoDia = new JTextFieldAdaptado("Dia", 3);
        slash = new JLabel("/");
        slash2 = new JLabel("/");
        carrera = new JComboBox<>();
        for (Carrera carrera1 : Main.getRegistroDeCarreras().getCarreras()) {
            carrera.addItem(carrera1.getNombre());
        }
        buscarCodigo = new JButton("Buscar Codigos De Asignatura Disponibles");
        this.add(carrera);
        this.add(ingresoAño);
        this.add(slash);
        this.add(ingresoMes);
        this.add(slash2);
        this.add(ingresoDia);
        this.add(buscarCodigo);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuscarCodigoAsignaturaActionListener(ingresoAño,
                ingresoMes, ingresoDia, carrera).actionPerformed(e);
            }
        };
        Enter enter = new Enter(buscarCodigo, action);
    }

}
