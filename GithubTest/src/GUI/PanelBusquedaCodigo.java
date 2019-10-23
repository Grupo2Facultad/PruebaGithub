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

/**
 *
 * @author juanc
 */
public class PanelBusquedaCodigo extends JPanel {

    private  final JTextFieldAdaptado ingresoAño,
            ingresoMes,
            ingresoDia,
            carrera;
    private final JButton buscarCodigo;
    private final JLabel slash,
                  slash2;

    public PanelBusquedaCodigo() {
        this.setLayout(new FlowLayout());
        ingresoAño = new JTextFieldAdaptado("Año",5);
        ingresoMes = new JTextFieldAdaptado("Mes",3);
        ingresoDia = new JTextFieldAdaptado("Dia",3);
        slash = new JLabel("/");
        slash2 = new JLabel("/");
        carrera = new JTextFieldAdaptado("Carrera",20);
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
