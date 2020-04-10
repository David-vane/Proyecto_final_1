
package Vistas;


import Controlador.Controlador_registro_clientes;
import Controlador.Controlador_registro_productos;
import Modelo.Clientes;
import Modelo.ClientesBD;
import Modelo.ProductoBD;
import Modelo.Productos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Registro_producto extends JFrame{
    private Productos productos;
    private ProductoBD modeloDatos;
    JFrame registro_producto = new JFrame("Registrar Producto");;//creamos un jframe
    JPanel panel_producto=new  JPanel();// creamos un panel primario 
    JPanel panel_clientes2=new JPanel(new FlowLayout(FlowLayout.CENTER));//panel secundario, esto con el fin de enviar 2 paneles en un mismo frame 
    JTable tablaProductos=new JTable();// creacion de una tabla para poder visualizar mas adelante
    JLabel jlistas=new JLabel("LISTA DE PRODUCTOS");
    //creacion de los labels
    JLabel lb_codigo=new JLabel("Codigo");
    JLabel lb_articulo=new JLabel("Articulo");
    JLabel lb_descripcion=new JLabel("Descripcion");
    JLabel lb_valor=new JLabel("Valor");
    JLabel lb_iva=new JLabel("Iva");
    JLabel lb_cantidad=new JLabel("Cantidad");
    //Creacion de los Texfield
    JTextField txt_codigo=new JTextField(10);
    JTextField txt_articulo=new JTextField(10);
    JTextField txt_descripcion=new JTextField(10);
    JTextField txt_valor=new JTextField(10);
    JTextField txt_iva=new JTextField(10);
    JTextField txt_cantidad=new JTextField(10);
    // creacion de diversos botones
    JButton b_consultar = new JButton( "Enviar consulta" );
    JButton b_guardar=new JButton("Guardar");
    JButton b_verificar=new JButton("Verificar");
    JButton b_editar=new JButton("Editar");
    JButton b_eliminar=new JButton("Eliminar");
    JButton b_atras=new JButton("Atras");
    JButton b_actualizar=new JButton("Actualizar");
    
    //creacion de combo box para añadir varios articulos
    JComboBox jcb_articulo=new JComboBox();
    
     public void Mostrar(){
         Iniciar_Componentes();
         guardarProducto();
         controler();
         //Disposer();
         
    
    }
     //daremos direcciones a los labels, texfield, tablas, combobox, es decir generaremos una vista 
    public void Iniciar_Componentes(){
    GridBagLayout v_producto =new GridBagLayout();
    GridBagConstraints p_principal= new GridBagConstraints ();
    panel_producto.setLayout(v_producto);
    //agregamos labels
    p_principal.gridx=1;
    p_principal.gridy=0;
    panel_producto.add(lb_codigo,p_principal);
    
    p_principal.gridx=3;
    p_principal.gridy=0;
    panel_producto.add(lb_articulo,p_principal);
    
    p_principal.gridx=5;
    p_principal.gridy=0;
    panel_producto.add(lb_descripcion,p_principal);
    
    p_principal.gridx=7;
    p_principal.gridy=0;
    panel_producto.add(lb_valor,p_principal);
    
    p_principal.gridx=9;
    p_principal.gridy=0;
    panel_producto.add(lb_iva,p_principal);
    
    p_principal.gridx=10;
    p_principal.gridy=0;
    panel_producto.add(lb_cantidad,p_principal);
    
    //agregar los texfield
    
    p_principal.gridx=1;
    p_principal.gridy=2;
    panel_producto.add(txt_codigo,p_principal);
    
    p_principal.gridx=3;
    p_principal.gridy=2;
    panel_producto.add(jcb_articulo,p_principal);
        jcb_articulo.addItem("Tarjeta de video");
        jcb_articulo.addItem("Motherboard");
        jcb_articulo.addItem("Memoria Ram");
        jcb_articulo.addItem("Fuente de poder");
        panel_producto.add(jcb_articulo,p_principal);
    
    p_principal.gridx=5;
    p_principal.gridy=2;
    panel_producto.add(txt_descripcion,p_principal);
    
    p_principal.gridx=7;
    p_principal.gridy=2;
    panel_producto.add(txt_valor,p_principal);
    
    p_principal.gridx=9;
    p_principal.gridy=2;
    panel_producto.add(txt_iva,p_principal);
    
    p_principal.gridx=10;
    p_principal.gridy=2;
    panel_producto.add(txt_cantidad,p_principal);
    
    //botones
    
    p_principal.gridx=11;
    p_principal.gridy=2;
    panel_producto.add(b_guardar,p_principal);
    
    p_principal.gridx=12;
    p_principal.gridy=2;
    panel_producto.add(b_editar,p_principal);
    
    p_principal.gridx=13;
    p_principal.gridy=2;
    panel_producto.add(b_eliminar,p_principal);
    
    p_principal.gridx=0;
    p_principal.gridy=10;
    panel_producto.add(b_atras,p_principal);
    
    p_principal.gridx=-1;
    p_principal.gridy=3;
    panel_producto.add(b_actualizar,p_principal);
    
    p_principal.gridx=-1;
    p_principal.gridy=3;
    panel_producto.add(b_verificar,p_principal);
    
    p_principal.gridx=0;
    p_principal.gridy=11;
    panel_producto.add(b_consultar,p_principal);
    
    p_principal.gridx=0;
    p_principal.gridy=12;
    panel_producto.add(jlistas,p_principal);
    panel_clientes2.add(tablaProductos);
    
       
    
    registro_producto.add(panel_producto,BorderLayout.NORTH);
    registro_producto.add(panel_clientes2,BorderLayout.CENTER);
    registro_producto.setVisible(true);
    registro_producto.setSize(800, 500);
    registro_producto.setLocationRelativeTo(null);
    registro_producto.pack();
    registro_producto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
//METODOS

    }public void actualizarProducto(ArrayList lis){
                
                 modeloDatos= new ProductoBD(lis);
                 tablaProductos.setModel(modeloDatos);
   
    }
    public void controler(){ //Botones de la vista produto
        b_guardar.addActionListener(new Controlador_registro_productos(this));
        b_eliminar.addActionListener(new Controlador_registro_productos(this));
        b_consultar.addActionListener(new Controlador_registro_productos(this));
        b_atras.addActionListener(new Controlador_registro_productos(this));
        b_verificar.addActionListener(new Controlador_registro_productos(this));
        b_editar.addActionListener(new Controlador_registro_productos(this));
        b_actualizar.addActionListener(new Controlador_registro_productos(this));
    }
    public String eliminarProducto(){
            return txt_codigo.getText();
        
        }
    public Productos guardarProducto(){
	 	
                productos=new Productos();
                productos.setCodigo(txt_codigo.getText());
		productos.setArticulo((String)jcb_articulo.getSelectedItem());
		productos.setDescripcion(txt_descripcion.getText());
		productos.setValor(txt_valor.getText());
		productos.setIva(txt_iva.getText());
                productos.setCantidad(txt_cantidad.getText());
                
                return productos;
		
	}
    public String verificarproducto(){
            return txt_codigo.getText();
        
        }
    public void limpiarCampos(){
        
                
                txt_codigo.setText("");
                txt_articulo.setText("");
                txt_descripcion.setText("");
                txt_valor.setText("");
                txt_iva.setText("");
                txt_cantidad.setText("");
        
        }
        
        public void bloquearCampos(){
        
            
                txt_codigo.setEditable(false);
                txt_articulo.setEditable(false);
                txt_descripcion.setEditable(false);
                txt_valor.setEnabled(false);
                txt_iva.setEnabled(false);
                txt_cantidad.setEnabled(false);
                b_guardar.setEnabled(false);
        }
        
        public void desbloquearCampos(){
        
            
                txt_codigo.setEditable(true);
                txt_articulo.setEditable(true);
                txt_descripcion.setEditable(true);
                txt_valor.setEnabled(true);
                txt_iva.setEnabled(true);
                txt_cantidad.setEnabled(true);
                b_guardar.setEnabled(true);
        }
        public void cargarCampos(Productos producto){
        
                
                txt_codigo.setText(producto.getCodigo());
                txt_articulo.setText(producto.getArticulo());
                txt_descripcion.setText(producto.getDescripcion());
                txt_valor.setText(producto.getValor());
                txt_iva.setText(producto.getIva());
                txt_cantidad.setText(producto.getCantidad());
        
        }
    public void Disposer(){ // metodo para cerrar solo la venta producto

      registro_producto.setVisible(false);
    }
    

    public JButton getB_consultar() {
        return b_consultar;
    }

    public JTextField getTxt_codigo() {
        return txt_codigo;
    }

    public JTextField getTxt_articulo() {
        return txt_articulo;
    }

    public JTextField getTxt_descripcion() {
        return txt_descripcion;
    }

    public JButton getB_verificar() {
        return b_verificar;
    }

    public JTextField getTxt_valor() {
        return txt_valor;
    }

    public JTextField getTxt_iva() {
        return txt_iva;
    }

    public JTextField getTxt_cantidad() {
        return txt_cantidad;
    }

    public JButton getB_guardar() {
        return b_guardar;
    }

    public JButton getB_editar() {
        return b_editar;
    }

    public JButton getB_eliminar() {
        return b_eliminar;
    }

    public JButton getB_actualizar() {
        return b_actualizar;
    }

    public JButton getB_atras() {
        return b_atras;
    }

    public JComboBox getJcb_articulo() {
        return jcb_articulo;
    }

    
    
    }
