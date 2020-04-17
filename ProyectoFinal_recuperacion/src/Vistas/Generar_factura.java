package Vistas;

import Controlador.Controlador_factura;
import Controlador.Controlador_registro_clientes;
import Modelo.Clientes;
import Modelo.ClientesBD;
import Modelo.Factura;
import Modelo.FacturaBD;
import Modelo.SistemaBD;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick Gaona
 */
public class Generar_factura extends JFrame {

    public static String verificarClientes;
    private FacturaBD modeloDatos;
    JPanel panel_clientes2=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JFrame factura=new JFrame();
    JPanel p_factura=new JPanel();
    JLabel l_numerofact=new JLabel("N° Factura ");
    JLabel l_nombres=new JLabel("Nombres ");
    JLabel l_apellidos=new JLabel("Apellidos");
    JLabel l_cedula=new JLabel("Cedula");
    JLabel l_producto=new JLabel("Producto");
    JLabel l_fecha=new JLabel("Fecha");
    JLabel l_direccion=new JLabel("Direcion");
    JLabel l_vendedor=new JLabel("Telefono");
    JTable tablaClientes=new JTable();
    Box boxNorte = Box.createHorizontalBox();
    JLabel jlistas=new JLabel("LISTA DE PRODUCTOS");

    
    
    JTextField txt_numerofact=new JTextField(10);
    JTextField txt_nombres=new JTextField(10);
    JTextField txt_apellidos=new JTextField(10);
    JComboBox txt_cedula= new JComboBox();
    JTextField txt_cedula1=new JTextField(10);
    JComboBox txt_producto= new JComboBox();
    JTextField txt_fecha=new JTextField(10);
    JTextField txt_direccion=new JTextField(10);
    JTextField txt_telefono=new JTextField(10);
    
    JButton b_guardar=new JButton("Generar Factura");
    JButton b_editar=new JButton("Editar");
    JButton b_eliminar=new JButton("Eliminar");
    JButton b_atras=new JButton("Atras"); 
    JButton b_clientes=new JButton("Consultar"); 
    JButton b_producto=new JButton("Agregar Producto"); 
    private JLabel lblMsj;
    
    
    
public void Iniciar_Componentes(){
    GridBagLayout v_producto =new GridBagLayout();
    GridBagConstraints p_principal= new GridBagConstraints ();
    p_factura.setLayout(v_producto);
    p_principal.insets= new Insets(5, 5, 5, 5); 
    
    
//agregamos labels
    
   p_principal.gridx=8;
    p_principal.gridy=1;
    p_factura.add(l_numerofact,p_principal);

    p_principal.gridx=7;
    p_principal.gridy=1;
    p_factura.add(txt_numerofact,p_principal);
    
    
    p_principal.gridx=0;
    p_principal.gridy=3;
    p_factura.add(l_nombres,p_principal);
   
    p_principal.gridx=1;
    p_principal.gridy=3;
    p_factura.add(txt_nombres,p_principal);
    
    p_principal.gridx=2;
    p_principal.gridy=3;
    p_factura.add(l_apellidos,p_principal);
    
    p_principal.gridx=3;
    p_principal.gridy=3;
    p_factura.add(txt_apellidos,p_principal);
    
     p_principal.gridx=0;
    p_principal.gridy=4;
    p_factura.add(l_cedula,p_principal);
    
    p_principal.gridx=1;
    p_principal.gridy=4;
     
     
    p_factura.add(txt_cedula1,p_principal);
    
     p_principal.gridx=0;
    p_principal.gridy=5;
    p_factura.add(l_producto,p_principal);
    
    p_principal.gridx=1;
    p_principal.gridy=5;
     
     
    p_factura.add(txt_producto,p_principal);
    
    
    
     p_principal.gridx=0;
    p_principal.gridy=6;
    p_factura.add(l_direccion,p_principal);
    
    p_principal.gridx=1;
    p_principal.gridy=6;
    p_factura.add(txt_direccion,p_principal);
    
     p_principal.gridx=0;
    p_principal.gridy=7;
    p_factura.add(l_vendedor,p_principal);
    
    p_principal.gridx=1;
    p_principal.gridy=7;
    p_factura.add(txt_telefono,p_principal);
    
     p_principal.gridx=8;
    p_principal.gridy=2;
    p_factura.add(l_fecha,p_principal);
    
    p_principal.gridx=7;
    p_principal.gridy=2;
    p_factura.add(txt_fecha,p_principal);

    



//agregamos labels
    
    //botones
    
    p_principal.gridx=8;
    p_principal.gridy=6;
    p_factura.add(b_guardar,p_principal);
    
    p_principal.gridx=0;
    p_principal.gridy=10;
    p_factura.add(b_editar,p_principal);
    
    p_principal.gridx=1;
    p_principal.gridy=10;
   p_factura.add(b_eliminar,p_principal);
    
    p_principal.gridx=2;
    p_principal.gridy=10;
    p_factura.add(b_atras,p_principal);
    
    
    p_principal.gridx=3;
    p_principal.gridy=4;
    p_factura.add(b_clientes,p_principal);
    
    p_principal.gridx=3;
    p_principal.gridy=5;
    p_factura.add(b_producto,p_principal);
    
    p_principal.gridx=3;
    p_principal.gridy=5;
    p_factura.add(jlistas,p_principal);
    panel_clientes2.add(tablaClientes);
    
   
    
    
       
     //factura.add(p_factura,BorderLayout.NORTH);
     //factura.add(p_factura2,BorderLayout.CENTER);
     factura.add(p_factura,BorderLayout.NORTH);
     factura.add(panel_clientes2,BorderLayout.CENTER);
     factura.setVisible(true);
     factura.setBounds(300, 100, 400,600);
     //factura.setLocationRelativeTo(null);
     factura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     factura.pack();
     
    }
public void Mostrar(){
    Muestra();
    Iniciar_Componentes();
    buscar();
    buscar_producto();
    controler();
}
public void controler(){ //Botones de la vista clientes
        b_guardar.addActionListener(new Controlador_factura(this));
        b_eliminar.addActionListener(new Controlador_factura(this));
        b_clientes.addActionListener(new Controlador_factura (this));
        b_editar.addActionListener(new Controlador_factura(this));
        b_atras.addActionListener(new Controlador_factura(this));
        b_producto.addActionListener(new Controlador_factura(this));
        

}
    
public void Muestra(){
    
             int t =0;
             String b = "";
             t++;
            b=Integer.toString(t);
            
        txt_numerofact.setText(b);
}

public String verificarClientes(){
            return txt_cedula1.getText();
        
        }
public void bloquearCampos(){
        
            
                txt_nombres.setEditable(false);
                txt_apellidos.setEditable(false);
                txt_direccion.setEditable(false);
                txt_telefono.setEnabled(false);
                b_guardar.setEnabled(false);
        }
public void desbloquearCampos(){
        
            
                txt_nombres.setEditable(true);
                txt_apellidos.setEditable(true);
                txt_direccion.setEditable(true);
                txt_telefono.setEnabled(true);
                b_guardar.setEnabled(true);
        }
public void limpiarCampos(){
        
                
                txt_nombres.setText("");
                txt_apellidos.setText("");
                txt_direccion.setText("");
                txt_telefono.setText("");
                
        
        }
public void cargarCampos(Factura factura){
       
                txt_nombres.setText(factura.getNombres());
                txt_apellidos.setText(factura.getApellidos());
                txt_direccion.setText(factura.getDireccion());
                txt_telefono.setText(factura.getTeléfono());
                
        
        }
public void actualizarClientefact(ArrayList lis){
                
                 modeloDatos= new FacturaBD(lis);
                 tablaClientes.setModel(modeloDatos);
   
                
	}
public void Disposer(){
    factura.setVisible(false);
    }

    public JFrame getFactura() {
        return factura;
    }

    public void setFactura(JFrame factura) {
        this.factura = factura;
    }

    public JPanel getP_factura() {
        return p_factura;
    }

    public void setP_factura(JPanel p_factura) {
        this.p_factura = p_factura;
    }

    public JLabel getL_numerofact() {
        return l_numerofact;
    }

    public void setL_numerofact(JLabel l_numerofact) {
        this.l_numerofact = l_numerofact;
    }

    public JLabel getL_nombres() {
        return l_nombres;
    }

    public void setL_nombres(JLabel l_nombres) {
        this.l_nombres = l_nombres;
    }

    

    public JLabel getL_cedula() {
        return l_cedula;
    }

    public void setL_cedula(JLabel l_cedula) {
        this.l_cedula = l_cedula;
    }

    public JComboBox getTxt_cedula() {
        return txt_cedula;
    }

    public JTextField getTxt_cedula1() {
        return txt_cedula1;
    }

    public void setTxt_cedula1(JTextField txt_cedula1) {
        this.txt_cedula1 = txt_cedula1;
    }

    
    public JLabel getL_fecha() {
        return l_fecha;
    }

    public void setL_fecha(JLabel l_fecha) {
        this.l_fecha = l_fecha;
    }

    public JLabel getL_direccion() {
        return l_direccion;
    }

    public void setL_direccion(JLabel l_direccion) {
        this.l_direccion = l_direccion;
    }

    public JTextField getTxt_numerofact() {
        return txt_numerofact;
    }

    public void setTxt_numerofact(JTextField txt_numerofact) {
        this.txt_numerofact = txt_numerofact;
    }

    public JTextField getTxt_nombres() {
        return txt_nombres;
    }

    public void setTxt_nombres(JTextField txt_nombres) {
        this.txt_nombres = txt_nombres;
    }

    public JTextField getTxt_apellidos() {
        return txt_apellidos;
    }

    public void setTxt_apellidos(JTextField txt_apellidos) {
        this.txt_apellidos = txt_apellidos;
    }

   

    public JTextField getTxt_fecha() {
        return txt_fecha;
    }

    public void setTxt_fecha(JTextField txt_fecha) {
        this.txt_fecha = txt_fecha;
    }

    public JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public void setTxt_direccion(JTextField txt_direccion) {
        this.txt_direccion = txt_direccion;
    }

    public JTextField getTxt_telefono() {
        return txt_telefono;
    }

    public void setTxt_telefono(JTextField txt_vendedor) {
        this.txt_telefono = txt_telefono;
    }

    public JButton getB_guardar() {
        return b_guardar;
    }

    public void setB_guardar(JButton b_guardar) {
        this.b_guardar = b_guardar;
    }

    public JButton getB_editar() {
        return b_editar;
    }

    public void setB_editar(JButton b_editar) {
        this.b_editar = b_editar;
    }

    public JButton getB_eliminar() {
        return b_eliminar;
    }

    public void setB_eliminar(JButton b_eliminar) {
        this.b_eliminar = b_eliminar;
    }

    public JButton getB_atras() {
        return b_atras;
    }

    public void setB_atras(JButton b_atras) {
        this.b_atras = b_atras;
    }
    public JButton getB_clientes() {
        return b_clientes;
    }

    public void setB_clientes(JButton b_clientes) {
        this.b_clientes = b_clientes;
    }

    public JButton getB_producto() {
        return b_producto;
    }

    public void setB_producto(JButton b_producto) {
        this.b_producto = b_producto;
    }
    
    

    public void buscar(){
        try {
        Connection Conexion= null ;
        Class.forName("com.mysql.jdbc.Driver");
        Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema","root","1234");
        Statement ST = Conexion.createStatement();
        ResultSet RS = ST.executeQuery("select cedula from clientes");
       
        txt_cedula.removeAllItems();
        
        while(RS.next()){
            txt_cedula.addItem(RS.getString(1));
        }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generar_factura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generar_factura.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void buscar_producto(){
        try {
        Connection Conexion= null ;
        Class.forName("com.mysql.jdbc.Driver");
        Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema","root","1234");
        Statement ST = Conexion.createStatement();
        ResultSet RS = ST.executeQuery("select articulo from productos");
       
        txt_producto.removeAllItems();
        
        while(RS.next()){
            txt_producto.addItem(RS.getString(1));
        }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generar_factura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generar_factura.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

   

   
}
//    public JButton getB_consultar() {
//        return b_consultar;
//    }
//
//    public void setB_consultar(JButton b_consultar) {
//        this.b_consultar = b_consultar;
//    }
// 
//}