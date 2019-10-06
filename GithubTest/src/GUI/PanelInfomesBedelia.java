/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juanc
 */
public class PanelInfomesBedelia extends JPanel{
    protected JButton habilitadosParcial,
            habilitadosFinal,
            asignaturasPorDNI,
            profesoresProAsignatura,
            imprimirActa;
    protected JLabel label2;

    public PanelInfomesBedelia() {
        super();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        label2 = new JLabel("Informes Bedelia");
        habilitadosParcial = new JButton("HabiltiadosParcial");
        habilitadosParcial.addActionListener(new HabiltiadosExamenActionListener());
        habilitadosFinal = new JButton("HabilitadosFinal");
        habilitadosFinal.addActionListener(new HabiltiadosExamenActionListener());
        asignaturasPorDNI = new JButton("AsignaturasPorDNI");
        asignaturasPorDNI.addActionListener(new AsignaturasPorDni());
        profesoresProAsignatura = new JButton("ProfesoesAsignatura");
        profesoresProAsignatura.addActionListener(new ProfesoresPorAsignaturaActionListener ());
        imprimirActa = new JButton("ImprimirActa");
        this.add(label2);
        this.add(habilitadosParcial);
        this.add(habilitadosFinal);
        this.add(asignaturasPorDNI);
        this.add(profesoresProAsignatura);
        this.add(imprimirActa);
    }

}
