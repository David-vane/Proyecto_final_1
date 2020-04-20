package Vista;

import Controlador.Controlador_principal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class V_principal extends JFrame {

    JFrame v_principal = new JFrame("Ingresar al sistema");
    //Paneles
    JPanel p_principal= new JPanel();
    
    //JLabels
    JLabel logo = new JLabel();
   
    
    //JBotones
    JButton b_formulario = new JButton("Formulario");
    JButton b_revision = new JButton("Revision");
    
    ImageIcon image = new ImageIcon(getClass().getResource("/Imagenes/7.png"));

    public void Mostrar() {
        tamaño();
        posicion();
        //controler();
        ventana();
        controlador();
        
    }

    public void posicion() {
        GridBagLayout v_posicion = new GridBagLayout();
        GridBagConstraints v_posicion1 = new GridBagConstraints();
        p_principal.setLayout(v_posicion);

        v_posicion1.insets = new Insets(3, 3, 3, 3);
        v_posicion1.gridx = 0;
        v_posicion1.gridy = 0;
        p_principal.add(logo, v_posicion1);

        v_posicion1.gridx = 0;
        v_posicion1.gridy = 1;
        p_principal.add(b_formulario, v_posicion1);

      
        v_posicion1.gridx = 0;
        v_posicion1.gridy = 3;
        p_principal.add(b_revision, v_posicion1);
        
      
    }

    public JButton getB_formulario() {
        return b_formulario;
    }
    public void controlador(){
      b_formulario.addActionListener(new Controlador_principal(this));
       b_revision.addActionListener(new Controlador_principal(this));
    }

    public JButton getB_revision() {
        return b_revision;
    }

    
    public void ventana() { // crea el metodo, dar tamaño ala ventana y agrego botones al panel

        logo.setIcon(image);
        v_principal.setBounds(450, 150, 550, 360);
        v_principal.getContentPane().add(p_principal);
        v_principal.setVisible(true);
     
        p_principal.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                 "Ingresar al sistema ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        
        p_principal.setBackground(Color.pink);
        v_principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void tamaño() {
        b_formulario.setPreferredSize(new Dimension(100, 30));
        b_revision.setPreferredSize(new Dimension(100, 30));

    }
   
//    public void controler(){
//    b_ingresar.addActionListener(new Controlador_principal(this));
//    b_salir.addActionListener(new Controlador_principal(this));
//    }

    

    
}
