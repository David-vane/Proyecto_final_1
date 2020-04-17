
package Vistas;


import Controlador.Controlador_registro_clientes;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Modelo.Clientes;
import Modelo.ClientesBD;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Registro_clientes extends JFrame{
    
    
    private ClientesBD modeloDatos;
    JFrame registro_clientes =new JFrame("Registrasr clientes");//crear jframe
    JPanel panel_clientes=new JPanel();// crear panel
    JPanel panel_clientes2=new JPanel(new FlowLayout(FlowLayout.CENTER));
    //creamos labels segun el diseño
    JTable tablaClientes=new JTable();
    Box boxNorte = Box.createHorizontalBox();
    JLabel jlistas=new JLabel("LISTA DE CLIENTES");
    JLabel lb_cedula=new JLabel("Cedula");
    JLabel lb_nombres=new JLabel("Nombres");
    JLabel lb_apellidos=new JLabel("Apellidos");
    JLabel lb_direccion=new JLabel("Direccion");
    JLabel lb_telefono=new JLabel("Telefono");
    JLabel lb_correo=new JLabel("Correo");
    //crear los texfield
    JTextField txt_cedula=new JTextField(10);
    JTextField txt_nombres=new JTextField(10);
    JTextField txt_apellidos=new JTextField(10);
    JTextField txt_direccion=new JTextField(10);
    JTextField txt_telefono=new JTextField(10);
    JTextField txt_correo=new JTextField(10);
    //creamos botones
    JButton b_guardar=new JButton("Guardar");
    JButton b_verificar=new JButton("Verificar");
    JButton b_editar=new JButton("Editar");
    JButton b_actualizar=new JButton("Actualizar");
    JButton b_eliminar=new JButton("Eliminar");
    JButton b_atras=new JButton("Atras"); 
    JButton b_consultar = new JButton("Enviar consulta");
    private Clientes cliente;
      
   public void Mostrar(){
    Iniciar_Componentes();
    controler();
    guardarCliente();
   
    }
    
    
    
    public void Iniciar_Componentes(){
        GridBagLayout v_clientes=new GridBagLayout();
        GridBagConstraints v_cliente1=new GridBagConstraints();
        panel_clientes.setLayout(v_clientes);
        //agregamos labels
        v_cliente1.gridx=1;
        v_cliente1.gridy=0;
        panel_clientes.add(lb_cedula,v_cliente1);
        
        v_cliente1.gridx=3;
        v_cliente1.gridy=0;
        panel_clientes.add(lb_nombres,v_cliente1);
        
        v_cliente1.gridx=5;
        v_cliente1.gridy=0;
        panel_clientes.add(lb_apellidos,v_cliente1);
        
        v_cliente1.gridx=7;
        v_cliente1.gridy=0;
        panel_clientes.add(lb_direccion,v_cliente1);
        
        v_cliente1.gridx=9;
        v_cliente1.gridy=0;
        panel_clientes.add(lb_telefono,v_cliente1);
        
        v_cliente1.gridx=10;
        v_cliente1.gridy=0;
        panel_clientes.add(lb_correo,v_cliente1);
        
        //agregamos los texfields 
        
        v_cliente1.gridx=1;
        v_cliente1.gridy=2;
        panel_clientes.add(txt_cedula,v_cliente1);
        
        v_cliente1.gridx=3;
        v_cliente1.gridy=2;
        panel_clientes.add(txt_nombres,v_cliente1);
        
        v_cliente1.gridx=5;
        v_cliente1.gridy=2;
        panel_clientes.add(txt_apellidos,v_cliente1);
        
        v_cliente1.gridx=7;
        v_cliente1.gridy=2;
        panel_clientes.add(txt_direccion,v_cliente1);
        
        v_cliente1.gridx=9;
        v_cliente1.gridy=2;
        panel_clientes.add(txt_telefono,v_cliente1);
        
        v_cliente1.gridx=10;
        v_cliente1.gridy=2;
        panel_clientes.add(txt_correo,v_cliente1);
        //agregar botones
        v_cliente1.gridx=11;
        v_cliente1.gridy=2;
        panel_clientes.add(b_guardar,v_cliente1);
        
        v_cliente1.gridx=12;
        v_cliente1.gridy=2;
        panel_clientes.add(b_editar,v_cliente1);
        
        v_cliente1.gridx=-1;
        v_cliente1.gridy=3;
        panel_clientes.add(b_verificar,v_cliente1);
        
        v_cliente1.gridx=-1;
        v_cliente1.gridy=3;
        panel_clientes.add(b_actualizar,v_cliente1);
        
        v_cliente1.gridx=13;
        v_cliente1.gridy=2;
        panel_clientes.add(b_eliminar,v_cliente1);
        
        v_cliente1.gridx=0;
        v_cliente1.gridy=10;
        panel_clientes.add(b_atras,v_cliente1);
        
        v_cliente1.gridx=0;
        v_cliente1.gridy=11;
        panel_clientes.add(b_consultar,v_cliente1);
        
        
        
        v_cliente1.gridx=3;
        v_cliente1.gridy=5;
        panel_clientes.add(jlistas,v_cliente1);
        panel_clientes2.add(tablaClientes);
        
        
        
        registro_clientes.add(panel_clientes,BorderLayout.NORTH);
        registro_clientes.add(panel_clientes2,BorderLayout.CENTER);
        registro_clientes.setVisible(true);
        registro_clientes.setSize(800, 500);
        registro_clientes.setLocationRelativeTo(null);
        registro_clientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registro_clientes.pack();
        
            
}
    public void controler(){ //Botones de la vista clientes
        b_guardar.addActionListener(new Controlador_registro_clientes(this));
        b_eliminar.addActionListener(new Controlador_registro_clientes(this));
        b_consultar.addActionListener(new Controlador_registro_clientes(this));
        b_verificar.addActionListener(new Controlador_registro_clientes(this));
        b_editar.addActionListener(new Controlador_registro_clientes(this));
        b_atras.addActionListener(new Controlador_registro_clientes(this));
        b_actualizar.addActionListener(new Controlador_registro_clientes(this));

}

    public JButton getB_actualizar() {
        return b_actualizar;
    }
    public String verificarCliente(){
            return txt_cedula.getText();
        
        }
    public void limpiarCampos(){
        
                
                txt_nombres.setText("");
                txt_apellidos.setText("");
                txt_direccion.setText("");
                txt_telefono.setText("");
                txt_correo.setText("");
        
        }
        
        public void bloquearCampos(){
        
            
                txt_nombres.setEditable(false);
                txt_apellidos.setEditable(false);
                txt_direccion.setEditable(false);
                txt_telefono.setEnabled(false);
                txt_correo.setEnabled(false);
                b_guardar.setEnabled(false);
        }
        
        public void desbloquearCampos(){
        
            
                txt_nombres.setEditable(true);
                txt_apellidos.setEditable(true);
                txt_direccion.setEditable(true);
                txt_telefono.setEnabled(true);
                txt_correo.setEnabled(true);
                b_guardar.setEnabled(true);
        }
        public void cargarCampos(Clientes clientes){
        
                
                txt_nombres.setText(clientes.getNombres());
                txt_apellidos.setText(clientes.getApellidos());
                txt_direccion.setText(clientes.getDireccion());
                txt_telefono.setText(clientes.getTeléfono());
                txt_correo.setText(clientes.getCorreo());
        
        }
    public void actualizarCliente(ArrayList lis){
                
                 modeloDatos= new ClientesBD(lis);
                 tablaClientes.setModel(modeloDatos);
   
                
	}
    public String eliminarCliente(){
            return txt_cedula.getText();
        
        }
    public Clientes guardarCliente(){
	 	
                cliente=new Clientes();
                cliente.setCedula(txt_cedula.getText());
		cliente.setNombres(txt_nombres.getText());
		cliente.setApellidos(txt_apellidos.getText());
		cliente.setDireccion(txt_direccion.getText());
		cliente.setTeléfono(txt_telefono.getText());
                cliente.setCorreo(txt_correo.getText());
                
                return cliente;
		
	}
    public void Disposer(){
    registro_clientes.setVisible(false);
    }
    

    public JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public JTextField getTxt_nombres() {
        return txt_nombres;
    }

    public JTextField getTxt_apellidos() {
        return txt_apellidos;
    }

    public JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public JTextField getTxt_telefono() {
        return txt_telefono;
    }

    public JTextField getTxt_correo() {
        return txt_correo;
    }

    public JButton getB_guardar() {
        return b_guardar;
    }

    public JButton getB_verificar() {
        return b_verificar;
    }

    public JButton getB_consultar() {
        return b_consultar;
    }

    public JButton getB_editar() {
        return b_editar;
    }

    public JButton getB_eliminar() {
        return b_eliminar;
    }

    public JButton getB_atras() {
        return b_atras;
    }

    
    
}

