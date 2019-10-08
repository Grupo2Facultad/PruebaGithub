/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Asignatura;
import githubtest.Docente;
import githubtest.DocenteExamen;
import githubtest.Examen;
import githubtest.RolExamenEnum;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class AnotarDocenteActionListener implements ActionListener {

    private JButton ingresar;
    private JTextField numeroLegajo,
            asignaturaCod,
            ingresoAño,
            ingresoMes,
            ingresoDia;
    private JLabel slash,
            slash2;
    private JComboBox box;

    class Ingresar implements ActionListener {
   
        @Override
        public void actionPerformed(ActionEvent arg0) {
           RolExamenEnum rol=(RolExamenEnum)box.getSelectedItem();
            try {
                int año = Integer.parseInt(ingresoAño.getText());
                int mes = Integer.parseInt(ingresoMes.getText());
                int dia = Integer.parseInt(ingresoDia.getText());
                LocalDate fecha = LocalDate.of(año, mes, dia);
                ArrayList<Asignatura> asignaturas = Main.registroDeCarreras.getAsignaturasPorFechaPlanDeEstudio(fecha);
                Docente docente=Main.getRegistroDeCarreras().getDocentesPorLegajo(numeroLegajo);
                if(docente==null){
                    throw new DocenteException("ese docente no existe");
                }
                boolean v=false;
                for (Asignatura asignatura : asignaturas) {
                    if (asignatura.getCodigo().equals(asignaturaCod.getText())) {
                       v=true;
                        ArrayList<Examen> examenes = (ArrayList) asignatura.getExamenes();
                        for (Examen examene : examenes) {
                            if (examene.getFecha().equals(fecha)) {
                                check(examene,rol);
                                examene.getDocenteExamen().add(new DocenteExamen(rol,docente));
                                JOptionPane.showMessageDialog(null,"operacion exitosa");
                             }
                        }
                    }
                }
                if(!v){
                    JOptionPane.showMessageDialog(null,"Codigo Invalido");
                }
            } catch (DocenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        public void check(Examen exa,RolExamenEnum rol) throws DocenteException {
            ArrayList<DocenteExamen> docentes = (ArrayList) exa.getDocenteExamen();
            for (DocenteExamen docente : docentes) {
                if (docente.getDocente().getNumeroLegajo().equals(numeroLegajo.getText())) {
                    throw new DocenteException("ese docente ya esta en el examen");
                }
                if (rol.equals(docente.getRol())) {
                    throw new DocenteException("ya existe ese puesto");
                }
            }
        }

        class DocenteException extends Exception {

            public DocenteException(String message) {
                super(message);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Frame frame = new Frame("Anotar Docente En Examen");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        ingresar = new JButton("ingresar");
        ingresar.addActionListener(new Ingresar());
        numeroLegajo = new JTextField("numero de legajo", 20);
        asignaturaCod = new JTextField("Codigo Asignatura", 15);
        ingresoAño = new JTextField("año", 5);
        ingresoMes = new JTextField("mes", 3);
        ingresoDia = new JTextField("dia", 3);
        slash = new JLabel("/");
        slash2 = new JLabel("/");
        box = new JComboBox();
        box.addItem(RolExamenEnum.TITULAR);
        box.addItem(RolExamenEnum.VVOCAL1);
        box.addItem(RolExamenEnum.VOCAL2);
        box.addItem(RolExamenEnum.SUPLENTE);
        container.add(numeroLegajo);
        container.add(asignaturaCod);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(box);
        container.add(ingresar);

    }
}
