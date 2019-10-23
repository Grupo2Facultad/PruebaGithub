/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import githubtest.Asignatura;
import githubtest.Examen;
import githubtest.Final;
import githubtest.InscripcionAExamen;
import githubtest.Parcial;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class HabiltiadosExamenActionListener implements ActionListener{
private JTextFieldAdaptado codigoAsig;
private FechaComboBox fecha;
    private final boolean tipo;
private JButton ingresar;
class Ingresar implements ActionListener{
    private Examen ex;
        @Override
        public void actionPerformed(ActionEvent arg0) {
          ArrayList<InscripcionAExamen>habilitados=new ArrayList<>();
            ArrayList<Asignatura>asignaturas=Main.registroDeCarreras.getAsignaturasPorFechaPlanDeEstudio(fecha.armado());
            boolean t=false;
            boolean f=false;
            for (Asignatura asignatura : asignaturas) {
                if(asignatura.getCodigo().equals(codigoAsig.getText())){
                   t=true;
                    ArrayList<Examen> examenes=(ArrayList)asignatura.getExamenes();
                    for (Examen examene : examenes) {
                        if(examene.getFecha().equals(fecha.armado())){
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
       Frame frame=new Frame("Habilitados al Examen",ingresar);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       Toolkit pantalla = Toolkit.getDefaultToolkit();
    Dimension mip = pantalla.getScreenSize();
    int h = mip.height;
    int w = mip.width;
    frame.setBounds(w/4, h/4, w/2, h/2);
        Container container=frame.getContentPane();
        container.setLayout(new FlowLayout());
        codigoAsig=new JTextFieldAdaptado("Codigo de Asignatura");
        ingresar = new JButton("Ingresar");
        fecha=new FechaComboBox();
        container.add(codigoAsig);
        container.add(fecha);
        container.add(ingresar);
        Action action = new AbstractAction("Ingresar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ingresar().actionPerformed(e);
            }
        };
        Enter enter = new Enter(ingresar, action);
        
    }
    
}
