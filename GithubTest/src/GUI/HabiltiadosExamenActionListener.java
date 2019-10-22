/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Alumno;
import githubtest.Asignatura;
import githubtest.Examen;
import githubtest.Final;
import githubtest.InscripcionAExamen;
import githubtest.Parcial;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanc
 */
public class HabiltiadosExamenActionListener implements ActionListener{
private JTextField codigoAsig,
         ingresoAño,
            ingresoMes,
            ingresoDia;
    private JLabel slash,
            slash2;
    private boolean tipo;
private JButton ingresar;
class Ingresar implements ActionListener{
    private Examen ex;
        @Override
        public void actionPerformed(ActionEvent arg0) {
          int año=Integer.parseInt(ingresoAño.getText());
          int mes=Integer.parseInt(ingresoMes.getText());
          int dia=Integer.parseInt(ingresoDia.getText());
          ArrayList<InscripcionAExamen>habilitados=new ArrayList<>();
            LocalDate fecha=LocalDate .of(año,mes,dia); 
            ArrayList<Asignatura>asignaturas=Main.registroDeCarreras.getAsignaturasPorFechaPlanDeEstudio(fecha);
            boolean t=false;
            boolean f=false;
            for (Asignatura asignatura : asignaturas) {
                if(asignatura.getCodigo().equals(codigoAsig.getText())){
                   t=true;
                    ArrayList<Examen> examenes=(ArrayList)asignatura.getExamenes();
                    for (Examen examene : examenes) {
                        if(examene.getFecha().equals(fecha)){
                            ex=examene;
                            f=true;
                            if(tipo&& examene instanceof Parcial){
                            ex=examene;
                           habilitados=(ArrayList)examene.getActa().getHabilitados();
                            }
                            if(tipo&& examene instanceof Final){
                                JOptionPane.showMessageDialog(null,"Ese Examen es de tipo Final");
                                return;
                            }
                            if(!tipo&&examene instanceof Final){
                            ex=examene;
                           habilitados=(ArrayList)examene.getActa().getHabilitados();
                            }
                            if(!tipo && examene instanceof Parcial){
                                JOptionPane.showMessageDialog(null,"Ese Examen es de tipo Parcial");
                                return;
                            }
                        }
                    }
                }
            }
            if(!t){
                JOptionPane.showMessageDialog(null,"ese codigo no es valido");
                return;
            }
            if(!f){
                JOptionPane.showMessageDialog(null,"esa Asignatura no tiene un examen en esa fecha");
                return;
            } 
            if(!habilitados.isEmpty()){
            ImpresionListadoExamen imp= new ImpresionListadoExamen(habilitados);
            imp.Imprimir( ex);
            }
            else{
                ImpresionListado.Imprimir(null,"no hay nadie habilitado");
            }
            
        }
}

    public HabiltiadosExamenActionListener(boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
       Frame frame=new Frame("Habilitados al Examen");
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setBounds(300, 200, 600, 500);
        Container container=frame.getContentPane();
        container.setLayout(null);
        codigoAsig=new JTextField("Codigo de Asignatura",20);
        codigoAsig.setBounds(50, 200, 130, 25);
        ingresar = new JButton("Ingresar");
        ingresar.setBounds(400, 198, 120, 30);
        ingresoAño=new JTextField("Año",5);
        ingresoAño.setBounds(200, 200, 50, 25);
        ingresoMes=new JTextField("Mes",3);
        ingresoMes.setBounds(270, 200,40, 25);
        ingresoDia=new JTextField("Dia",3);
        ingresoDia.setBounds(330,200,40,25);
        slash=new JLabel("/");
        slash.setBounds(255, 198,15, 25);
        slash2=new JLabel("/");
        slash2.setBounds(315, 198,15, 25);
        ingresar.addActionListener(new Ingresar());
        container.add(codigoAsig);
        container.add(ingresoAño);
        container.add(slash);
        container.add(ingresoMes);
        container.add(slash2);
        container.add(ingresoDia);
        container.add(ingresar);
    }
    
}
