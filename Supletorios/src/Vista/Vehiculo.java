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

public class Vehiculo extends JFrame {

    public static String verificarPersona;

    JFrame Persona = new JFrame();
    JPanel P_persona = new JPanel();
    JPanel P_persona_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

   //JLabels
    JLabel l_placa = new JLabel("Placa");
    JLabel l_color = new JLabel("Color");
    JLabel l_fecha= new JLabel("Fecha");
    JLabel l_marca = new JLabel("Marca");
    JLabel l_modelo = new JLabel("Modelo");
    JLabel l_Imagen = new JLabel();

    //TextField
    JTextField txt_placa = new JTextField(10);
    JTextField txt_color = new JTextField(10);
    JTextField txt_fecha = new JTextField(10);
    JTextField txt_marca = new JTextField(10);
    JTextField txt_modelo = new JTextField(10);
   

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
        p_principal.gridy = 4;
        P_persona.add(l_color, p_principal);

        p_principal.gridx = 1;
        p_principal.gridy = 4;
        P_persona.add(txt_color, p_principal);
        
        p_principal.gridx = 0;
        p_principal.gridy = 5;
        P_persona.add(l_fecha, p_principal);

        p_principal.gridx = 1;
        p_principal.gridy = 5;
        P_persona.add(txt_fecha, p_principal);

        p_principal.gridx = 0;
        p_principal.gridy = 6;
        P_persona.add(l_marca, p_principal);

        p_principal.gridx = 1;
        p_principal.gridy = 6;
        P_persona.add(txt_marca, p_principal);

        p_principal.gridx = 0;
        p_principal.gridy = 7;
        P_persona.add(l_modelo, p_principal);

        p_principal.gridx = 1;
        p_principal.gridy = 7;
        P_persona.add(txt_modelo, p_principal);

        

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

        txt_color.setEditable(false);
        txt_fecha.setEditable(false);
        txt_marca.setEditable(false);
        txt_modelo.setEnabled(false);
        b_guardar.setEnabled(false);

    }
    //desbloqueara los campos
    public void desbloquearCampos() {

        txt_color.setEditable(true);
        txt_fecha.setEditable(true);
        txt_marca.setEditable(true);
        txt_modelo.setEnabled(true);
        b_guardar.setEnabled(true);
    }
    
   
    //Guardar campos
    public M_Vehiculo GuardarPersona(){
        
        persona= new M_Vehiculo();
        persona.setPlaca(txt_placa.getText());
        persona.setColor(txt_color.getText());
        persona.setFecha(txt_fecha.getText());
        persona.setMarca(txt_marca.getText());
        persona.setModelo(txt_modelo.getText());

        return persona;
    
    
    }
    //Eliminar campos
   

    
    public String verificarPersona() {
        return txt_placa.getText();

    }
    

    public void cargarCampos(M_Vehiculo supletorio){
           
    txt_color.setText(supletorio.getColor());
    txt_fecha.setText(supletorio.getFecha());
    txt_marca.setText(supletorio.getMarca());
    txt_modelo.setText(supletorio.getModelo());
                    
    }
    public static String fechaactual(){
      Date fecha= new Date();
      SimpleDateFormat formatofecha= new     SimpleDateFormat("dd/MM/YYYY");
      
       return formatofecha.format(fecha);
    }
   

    public JFrame getPersona() {
        return Persona;
    }

    public void setPersona(JFrame Persona) {
        this.Persona = Persona;
    }

    public JPanel getP_persona() {
        return P_persona;
    }

    public void setP_persona(JPanel P_persona) {
        this.P_persona = P_persona;
    }

    public JLabel getL_placa() {
        return l_placa;
    }

    public void setL_placa(JLabel l_placa) {
        this.l_placa = l_placa;
    }

    public JLabel getL_color() {
        return l_color;
    }

    public void setL_color(JLabel l_color) {
        this.l_color = l_color;
    }

    public JLabel getL_fecha() {
        return l_fecha;
    }

    public void setL_fecha(JLabel l_fecha) {
        this.l_fecha = l_fecha;
    }

    public JLabel getL_marca() {
        return l_marca;
    }

    public void setL_marca(JLabel l_marca) {
        this.l_marca = l_marca;
    }

    public JLabel getL_modelo() {
        return l_modelo;
    }

    public void setL_modelo(JLabel l_modelo) {
        this.l_modelo = l_modelo;
    }

    public JLabel getL_Imagen() {
        return l_Imagen;
    }

    public void setL_Imagen(JLabel l_Imagen) {
        this.l_Imagen = l_Imagen;
    }

    public JTextField getTxt_placa() {
        return txt_placa;
    }

    public void setTxt_placa(JTextField txt_placa) {
        this.txt_placa = txt_placa;
    }

    public JTextField getTxt_color() {
        return txt_color;
    }

    public void setTxt_color(JTextField txt_color) {
        this.txt_color = txt_color;
    }

    public JTextField getTxt_marca() {
        return txt_marca;
    }

    public void setTxt_marca(JTextField txt_marca) {
        this.txt_marca = txt_marca;
    }

    public JTextField getTxt_modelo() {
        return txt_modelo;
    }

    public void setTxt_modelo(JTextField txt_modelo) {
        this.txt_modelo = txt_modelo;
    }

    public JButton getB_editar() {
        return b_editar;
    }

    public void setB_editar(JButton b_editar) {
        this.b_editar = b_editar;
    }

    public JButton getB_verificar() {
        return b_verificar;
    }

    public void setB_verificar(JButton b_verificar) {
        this.b_verificar = b_verificar;
    }

    public JButton getB_guardar() {
        return b_guardar;
    }

    public void setB_guardar(JButton b_guardar) {
        this.b_guardar = b_guardar;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
 }

 
  
    