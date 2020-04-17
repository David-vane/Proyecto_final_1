
package Vistas;

import Controlador.Controlador_Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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


public class login {
    JFrame v_login=new JFrame("Ingresar al sistema");
    JPanel p_login=new JPanel();
    JPanel p_botones=new JPanel();
    JLabel logo=new JLabel();
    JLabel usuario=new JLabel("Usuario");
    JLabel contraseña=new JLabel("Contraseña");
    JTextField t_usuario=new JTextField(15);
    JPasswordField t_contraseña=new JPasswordField(15);
    JButton ingresar=new JButton("Ingresar");
    JButton salir=new JButton("Salir");
    JTable tabla=new JTable();
    ImageIcon image =  new ImageIcon(getClass().getResource("/Imagenes/1.png"));

    
   public void Mostrar(){
    tamaño();
    posicion();
    controler();
    ventana();
    }
            

public void posicion(){
    GridBagLayout v_posicion =new GridBagLayout();
    GridBagConstraints v_posicion1= new GridBagConstraints ();
    p_login.setLayout(v_posicion);
    
    v_posicion1.insets= new Insets(5, 5, 5, 5); 
    v_posicion1.gridx=0;
    v_posicion1.gridy=0;
    p_login.add(logo,v_posicion1);

    v_posicion1.gridx=0;
    v_posicion1.gridy=1;
    p_login.add(usuario,v_posicion1);
    
    v_posicion1.gridx=0;
    v_posicion1.gridy=2;
    p_login.add(t_usuario,v_posicion1);
    
    v_posicion1.gridx=0;
    v_posicion1.gridy=3;
    p_login.add(contraseña,v_posicion1);
    
    v_posicion1.gridx=0;
    v_posicion1.gridy=4;
    p_login.add(t_contraseña,v_posicion1);
    
    v_posicion1.gridx=0;
    v_posicion1.gridy=5;
    p_login.add(tabla,v_posicion1);
    /*
    v_posicion1.gridx=1;
    v_posicion1.gridy=4;
    p_login.add(cancelar,v_posicion1);
    */
    
    
}
public void  ventana(){ // crea el metodo, dar tamaño ala ventana y agrego botones al panel
    
logo.setIcon(image);
v_login.setBounds(450, 150, 550, 360);
v_login.getContentPane().add(p_login);
v_login.setVisible(true);
p_botones.add(ingresar);
p_botones.add(salir);
p_login.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED)
,"Bienvenido ingrese sus datos para continuar",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION));
v_login.add(p_botones,BorderLayout.SOUTH);
p_login.setBackground(Color.white);
v_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public  void tamaño(){
        ingresar.setPreferredSize(new Dimension(100,30));
        salir.setPreferredSize(new Dimension(100,30));

}
public void controler(){
ingresar.addActionListener(new Controlador_Login(this));
salir.addActionListener(new Controlador_Login(this));
}
    public JTextField getT_usuario() {
        return t_usuario;
    }

    public JTextField getT_contraseña() {
        return t_contraseña;
    }

    public JButton getAceptar() {
        return ingresar;
    }

    public JButton getCancelar() {
        return salir;
    }

}