/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class PanelBusquedaCodigo extends JPanel {

    private JTextField ingresoAño,
            ingresoMes,
            ingresoDia,
            carrera;
    private JButton buscarCodigo;
    private JLabel slash,
            slash2;

    public PanelBusquedaCodigo() {
        this.setLayout(new FlowLayout());
        ingresoAño = new JTextField("Año", 5);
        ingresoMes = new JTextField("Mes", 3);
        ingresoDia = new JTextField("Dia", 3);
        slash = new JLabel("/");
        slash2 = new JLabel("/");
        carrera = new JTextField("Carrera", 20);
        buscarCodigo = new JButton("Buscar Codigos De Asignatura Disponibles");
        buscarCodigo.addActionListener(new BuscarCodigoAsignaturaActionListener(ingresoAño,
                ingresoMes, ingresoDia, carrera));
        this.add(carrera);
        this.add(ingresoAño);
        this.add(slash);
        this.add(ingresoMes);
        this.add(slash2);
        this.add(ingresoDia);
        this.add(buscarCodigo);
    }

}
