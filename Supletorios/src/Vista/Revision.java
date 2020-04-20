
package Vista;

import Main.M_Vehiculo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Revision extends JFrame {

    public static String verificarPersona;

    JFrame Persona = new JFrame();
    JPanel P_persona = new JPanel();
    JPanel P_persona_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

   //JLabels
    JLabel l_placa = new JLabel("Placa");
    JLabel l_fecha= new JLabel("Fecha");
    JLabel l_descripcion = new JLabel("Descripcion");
    JLabel l_Imagen = new JLabel();

    //TextField
    JTextField txt_placa = new JTextField(10);
    JTextField txt_fecha = new JTextField(10);
    JTextField txt_descripcion = new JTextField(10);
    

    //JButton
    JButton b_editar = new JButton("Editar");
    JButton b_verificar = new JButton("Verificar");
    JButton b_guardar = new JButton("Guardar");
    

    ImageIcon image = new ImageIcon(getClass().getResource("/Imagenes/7.png"));
    M_Vehiculo persona;
    

    public void Iniciar_Componentes() {
        GridBagLayout v_producto = new GridBagLayout();
        GridBagConstraints p_principal = new GridBagConstraints();
        P_persona.setLayout(v_producto);
        p_principal.insets = new Insets(1, 2, 5, 5);
       
        //agregamos labels
        p_principal.gridx = 0;
        p_principal.gridy = 3;
        P_persona.add(l_placa, p_principal);

        p_principal.gridx = 1;
        p_principal.gridy = 3;
        P_persona.add(txt_placa, p_principal);

        p_principal.gridx = 0;
        p_principal.gridy = 5;
        P_persona.add(l_fecha, p_principal);

        p_principal.gridx = 1;
        p_principal.gridy = 5;
        P_persona.add(txt_fecha, p_principal);

        p_principal.gridx = 0;
        p_principal.gridy = 6;
        P_persona.add(l_descripcion, p_principal);

        p_principal.gridx = 1;
        p_principal.gridy = 6;
        P_persona.add(txt_descripcion, p_principal);

       
        p_principal.insets = new Insets(3, 3, 3,5);
        p_principal.gridx = 3;
        p_principal.gridy = 0;
        P_persona.add(l_Imagen, p_principal);

        //botones
        

        p_principal.gridx = 0;
        p_principal.gridy = 10;
        P_persona.add(b_editar, p_principal);

        p_principal.gridx = 2;
        p_principal.gridy = 10;
        P_persona.add(b_verificar, p_principal);

        p_principal.gridx = 5;
        p_principal.gridy = 10;
        P_persona.add(b_guardar, p_principal);
        

        
       Persona.add(P_persona, BorderLayout.NORTH);
        Persona.add(P_persona_1, BorderLayout.CENTER);
        Persona.setVisible(true);
       //alto y ancho de la ventana
        Persona.setSize(600, 300);
        Persona.setLocationRelativeTo(null);
        //El setdefault nos permite cerrar la aplicacion completamente cuando cerramos 
        Persona.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        P_persona.setBackground(Color.PINK);
        Persona.setTitle("Mi programacion 'Rafael Rodriguez'");
       txt_fecha.setText(fechaactual());
//     
    }
    //Nos une todos los metodos hechos oh que queremos añadir en una sola
    public void Mostrar() {
        Iniciar_Componentes();
        ventana();
        fechaactual();
    }
    
    
    //Habre la en una etiqueta una imagen
    public void ventana() {
        l_Imagen.setIcon(image);
        
    }
  
    //Bloqueara los campos
    public void bloquearCampos() {

        
        txt_fecha.setEditable(false);
        txt_descripcion.setEditable(false);
        b_guardar.setEnabled(false);

    }
    //desbloqueara los campos
    public void desbloquearCampos() {

        
        txt_fecha.setEditable(true);
        txt_descripcion.setEditable(true);
        b_guardar.setEnabled(true);
    }
    
   
    //Guardar campos
    public M_Vehiculo GuardarPersona(){
        
        persona= new M_Vehiculo();
        persona.setPlaca(txt_placa.getText());
        persona.setFecha(txt_fecha.getText());
        persona.setModelo(txt_descripcion.getText());
       

        return persona;
    
    
    }
    //Eliminar campos
   

    
    public String verificarPersona() {
        return txt_placa.getText();

    }
    

    public void cargarCampos(M_Vehiculo vehiculo){
           
   
    txt_fecha.setText(vehiculo.getFecha());
    txt_descripcion.setText(vehiculo.getModelo());
             
    }

    public JTextField getTxt_placa() {
        return txt_placa;
    }

    public JTextField getTxt_fecha() {
        return txt_fecha;
    }

    public JTextField getTxt_descripcion() {
        return txt_descripcion;
    }
    
    
    public static String fechaactual(){
      Date fecha= new Date();
      SimpleDateFormat formatofecha= new     SimpleDateFormat("dd/MM/YYYY");
      
       return formatofecha.format(fecha);
    }
   

}