
package Vistas;

import Controlador.Controlador_menu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class Vista_Principal extends JFrame{
    JFrame vista_principal = new JFrame("Sistema de facturacion");
    JPanel panel_menu= new JPanel();
    JButton  registro_producto = new JButton("Registro Productos");
    JButton registro_clientes = new JButton("Registro Clientes");
    JButton nueva_factura = new JButton("Agregar nueva factura");
    JButton  salir= new JButton("Salir");
    JLabel fondo= new JLabel();
    ImageIcon image =  new ImageIcon(getClass().getResource("/Imagenes/istl.png"));
    
    
    

    
     public void Mostrar(){
         Tamaño();
         ventana();
         Iniciar_Componentes();
         controler();
         
    
    }
    
    
public void Iniciar_Componentes(){
    
   
     GridBagLayout v_principal=new GridBagLayout();
     GridBagConstraints v_principal1=new GridBagConstraints();
     
     panel_menu.setLayout(v_principal);
     v_principal1.insets=new Insets(5, 5, 5, 5);
     v_principal1.gridx=0;
     v_principal1.gridy=0;
     panel_menu.add(fondo,v_principal1);
     
     v_principal1.gridx=0;
     v_principal1.gridy=1;
     panel_menu.add(registro_producto,v_principal1);
     
     v_principal1.gridx=0;
     v_principal1.gridy=2;
     panel_menu.add(registro_clientes,v_principal1);
     
     
     v_principal1.gridx=0;
     v_principal1.gridy=4;
     panel_menu.add(nueva_factura,v_principal1);
     
     
     v_principal1.gridx=0;
     v_principal1.gridy=6;
     panel_menu.add(salir,v_principal1);
     
        
        
}   
public void ventana(){
        fondo.setIcon(image);
        vista_principal.add(panel_menu);
        vista_principal.setBounds(700, 150, 450, 580);
        vista_principal.setVisible(true);
        vista_principal.setLocationRelativeTo(null);
        panel_menu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Bienvenido al Sistema",
        TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION));
        panel_menu.setBackground(Color.white);
        vista_principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
 public void Disposer(){
      vista_principal.setVisible(false);
    }
public  void Tamaño(){
        registro_producto.setPreferredSize(new Dimension(300, 30));
        registro_clientes.setPreferredSize(new Dimension(300,30));
        nueva_factura.setPreferredSize(new Dimension(300,30));
        salir.setPreferredSize(new Dimension(300,30));

}

public void controler(){
registro_producto.addActionListener(new Controlador_menu(this));
registro_clientes.addActionListener(new Controlador_menu(this));
nueva_factura.addActionListener(new Controlador_menu(this));
salir.addActionListener(new Controlador_menu(this));

}

    public JButton getRegistro_producto() {
        return registro_producto;
    }

    public JButton getRegistro_clientes() {
        return registro_clientes;
    }

    

    public JButton getNueva_factura() {
        return nueva_factura;
    }

    

    public JButton getSalir() {
        return salir;
    }

}
