/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ClasesLogicas.Carrera;
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

private FechaComboBox fecha;
    private JComboBox carrera;
    private final JButton buscarCodigo;


    public PanelBusquedaCodigo() {
        this.setLayout(new FlowLayout());
        carrera = new JComboBox<>();
        fecha= new FechaComboBox();
        for (Carrera carrera1 : Main.getRegistroDeCarreras().getCarreras()) {
            carrera.addItem(carrera1.getNombre());
        }
        buscarCodigo = new JButton("Buscar Codigos De Asignatura Disponibles");
        this.add(carrera);
        this.add(fecha);
        this.add(buscarCodigo);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuscarCodigoAsignaturaActionListener(fecha, carrera).actionPerformed(e);
            }
        };
        Enter enter = new Enter(buscarCodigo, action);
    }

}
