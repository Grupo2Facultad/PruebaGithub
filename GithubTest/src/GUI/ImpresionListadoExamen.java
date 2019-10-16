/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Examen;
import githubtest.InscripcionAExamen;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class ImpresionListadoExamen{
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
                System.out.println("la nota sacada es "+ alumno.getNotaObtenida());
                System.out.println("no esta vacio");
                if(alumno.getNotaObtenida()==null){
                    e=false;
                    frame=new Frame("poner nota");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(500, 200);
                    JTextField nota= new JTextField("nota");
                    JButton poner=new JButton("confirmar");
                    poner.addActionListener(new Confirmar(alumno,nota));
                    Container con=frame.getContentPane();
                    con.setLayout(new FlowLayout());
                    con.add(nota);
                    con.add(poner);
                }
            }
            if(e){
            JOptionPane.showMessageDialog(null,"no hay alumnos sin notas");
            }
        }
        class Confirmar implements ActionListener{
private InscripcionAExamen alumno;
private JTextField nota;

            public Confirmar(InscripcionAExamen alumno, JTextField nota) {
                this.alumno = alumno;
                this.nota = nota;
            }
            @Override
            public void actionPerformed(ActionEvent arg0) {
                alumno.setNotaObtenida(nota.getText());
                frame.setVisible(false);
            }
            
        }
    }
      public  void Imprimir(String alumnos,Examen ex){
       System.out.println("llego aca");
            JTextField texto= new JTextField(alumnos);
            texto.setSize(750, 545);
            JButton ponerNotas=new JButton("Poner notas");
            ponerNotas.setSize(45,50);
            ponerNotas.addActionListener(new PonerNotas(ex));
            Frame fra= new Frame("Impresion");
            fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fra.setVisible(true);
            Toolkit pantalla = Toolkit.getDefaultToolkit();
            Dimension mip = pantalla.getScreenSize();
            int h = mip.height;
            int w = mip.width;
            fra.setBounds(0, 0, w, h);
            Container con=fra.getContentPane();
            con.setLayout(new FlowLayout());
            con.add(texto);
            con.add(ponerNotas);
   }
}
