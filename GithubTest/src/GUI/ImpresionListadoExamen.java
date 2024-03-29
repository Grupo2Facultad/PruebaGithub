/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Examen;
import githubtest.InscripcionAExamen;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class ImpresionListadoExamen{
    protected final ArrayList<InscripcionAExamen>lista;

    public ImpresionListadoExamen(ArrayList<InscripcionAExamen> lista) {
        this.lista = lista;
    }
    
    class PonerNotas implements ActionListener{
        private Examen ex;
        Frame frame;
        public PonerNotas(Examen ex) {
            this.ex = ex;
        }
        

        @Override
        public void actionPerformed(ActionEvent arg0) {
            ArrayList<InscripcionAExamen>alumnos=(ArrayList)ex.getActa().getHabilitados();
            boolean e=true;
            for (InscripcionAExamen alumno : alumnos) {
                if(alumno.getNotaObtenida()==null){
                    e=false;
                    frame = new Frame("poner nota");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(800, 200);
                    JLabel label=new JLabel(alumno.getAlumno().toString());
                    JComboBox nota= new JComboBox();
                    for (int i = 2; i < 20; i++) {
                      nota.addItem(new Double((double)i/2));
                    }
                    JRadioButton boton=new JRadioButton("Asistió");
                    boton.setSelected(true);
                    JButton poner=new JButton("confirmar");
                    Container con=frame.getContentPane();
                    con.setLayout(new FlowLayout());
                    con.add(label);
                    con.add(nota);
                    con.add(boton);
                    con.add(poner);
                    Action action = new AbstractAction("Ingresar") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new Confirmar(alumno,nota,boton,frame).actionPerformed(e);
                        }
                    };
                    Enter enter = new Enter(poner, action);
                }
            }
            if(e){
            JOptionPane.showMessageDialog(null,"no hay alumnos sin notas");
            }
        }
        class Confirmar implements ActionListener{

private final InscripcionAExamen alumno;
private final JComboBox nota;
private final JRadioButton boton;
private final Frame frame;

            public Confirmar(InscripcionAExamen alumno, JComboBox nota, JRadioButton boton,Frame frame) {
                this.boton=boton;
                this.alumno = alumno;
                this.nota = nota;
                this.frame=frame;
            }
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(boton.getSelectedObjects()!=null){
                   alumno.setNotaObtenida(Double.toString((Double)nota.getSelectedItem()));
                }
                else{
                    alumno.setNotaObtenida("no se presento");                    
                }
                frame.setVisible(false);
            }
            
        }
    }
      public  void Imprimir(Examen ex){
            JButton ponerNotas=new JButton("Poner notas");
            ponerNotas.setSize(45,50);
            Frame fra= new Frame("Impresion");
            fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fra.setVisible(true);
            Toolkit pantalla = Toolkit.getDefaultToolkit();
            Dimension mip = pantalla.getScreenSize();
            int h = mip.height;
            int w = mip.width;
            fra.setBounds(0, 0, w, h);
        Container con = fra.getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        if (!lista.isEmpty()) {
            con.add(ponerNotas);
            for (InscripcionAExamen habilitado : lista) {
                con.add(new JLabel(habilitado.getAlumno().toString()));
            }
        } else {
            con.add(new JLabel("No hay nadie Habilitado"));
        }
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PonerNotas(ex).actionPerformed(e);
            }
        };
        Enter enter = new Enter(ponerNotas, action);

    }
}
