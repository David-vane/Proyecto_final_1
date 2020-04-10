package lol;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Erick Gaona
 */
public class Generar_factura extends JFrame{
    JFrame factura=new JFrame();
    JPanel p_factura=new JPanel();
    JLabel l_numerofact=new JLabel("Numero");
    JLabel l_nombres=new JLabel("Nombres");
    JLabel l_apellidos=new JLabel("Apellidos");
    JLabel l_cedula=new JLabel("Cedula");
    JLabel l_fecha=new JLabel("Fecha");
    JLabel l_direccion=new JLabel("Direcion");
    JPanel p_factura2=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JTable tablaproducto=new JTable();
    
    
    JTextField txt_numerofact=new JTextField(10);
    JTextField txt_nombres=new JTextField(10);
    JTextField txt_apellidos=new JTextField(10);
    JTextField txt_cedula=new JTextField(10);
    JTextField txt_fecha=new JTextField(10);
    JTextField txt_direccion=new JTextField(10);
    JTextField txt_vendedor=new JTextField(10);
    
    JButton b_guardar=new JButton("Generar Factura");
    JButton b_editar=new JButton("Editar");
    JButton b_eliminar=new JButton("Eliminar");
    JButton b_atras=new JButton("Atras"); 
    JButton b_consultar = new JButton("Enviar consulta");
    
public void Iniciar_Componentes(){
    GridBagLayout v_producto =new GridBagLayout();
    GridBagConstraints p_principal= new GridBagConstraints ();
    p_factura.setLayout(v_producto);
    //agregamos labels
    p_principal.gridx=1;
    p_principal.gridy=0;
    p_factura.add(l_numerofact,p_principal);
    
    p_principal.gridx=3;
    p_principal.gridy=0;
    p_factura.add(l_nombres,p_principal);
    
    p_principal.gridx=5;
    p_principal.gridy=0;
    p_factura.add(l_apellidos,p_principal);
    
    p_principal.gridx=7;
    p_principal.gridy=0;
    p_factura.add(l_cedula,p_principal);
    
    p_principal.gridx=9;
    p_principal.gridy=0;
    p_factura.add(l_fecha,p_principal);
    
    p_principal.gridx=10;
    p_principal.gridy=0;
    p_factura.add(l_direccion,p_principal);
    
   
    //agregar los texfield
    
    p_principal.gridx=1;
    p_principal.gridy=2;
    p_factura.add(txt_numerofact,p_principal);
    
    
    
    p_principal.gridx=3;
    p_principal.gridy=2;
    p_factura.add(txt_nombres,p_principal);
    
    p_principal.gridx=5;
    p_principal.gridy=2;
    p_factura.add(txt_apellidos,p_principal);
    
    p_principal.gridx=7;
    p_principal.gridy=2;
    p_factura.add(txt_cedula,p_principal);
    
    p_principal.gridx=9;
    p_principal.gridy=2;
    p_factura.add(txt_fecha,p_principal);
    
    p_principal.gridx=10;
    p_principal.gridy=2;
    p_factura.add(txt_direccion,p_principal);
    
    p_principal.gridx=10;
    p_principal.gridy=2;
    p_factura.add(txt_vendedor,p_principal);
    //botones
    
    p_principal.gridx=11;
    p_principal.gridy=2;
    p_factura.add(b_guardar,p_principal);
    
    p_principal.gridx=10;
    p_principal.gridy=10;
    p_factura.add(b_editar,p_principal);
    
    p_principal.gridx=11;
    p_principal.gridy=10;
   p_factura.add(b_eliminar,p_principal);
    
    p_principal.gridx=0;
    p_principal.gridy=10;
    p_factura.add(b_atras,p_principal);
    
    p_principal.gridx=0;
    p_principal.gridy=11;
    p_factura.add(b_consultar,p_principal);
    
   
    
    p_factura2.add(tablaproducto);
       
     factura.add(p_factura,BorderLayout.NORTH);
     factura.add(p_factura2,BorderLayout.CENTER);
     factura.add(p_factura);
     factura.setVisible(true);
     factura.setSize(800, 500);
     factura.setLocationRelativeTo(null);
     factura.pack();
    }
public void Mostrar(){
    Iniciar_Componentes();
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

    public JLabel getL_apellidos() {
        return l_apellidos;
    }

    public void setL_apellidos(JLabel l_apellidos) {
        this.l_apellidos = l_apellidos;
    }

    public JLabel getL_cedula() {
        return l_cedula;
    }

    public void setL_cedula(JLabel l_cedula) {
        this.l_cedula = l_cedula;
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

    public JPanel getP_factura2() {
        return p_factura2;
    }

    public void setP_factura2(JPanel p_factura2) {
        this.p_factura2 = p_factura2;
    }

    public JTable getTablaproducto() {
        return tablaproducto;
    }

    public void setTablaproducto(JTable tablaproducto) {
        this.tablaproducto = tablaproducto;
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

    public JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public void setTxt_cedula(JTextField txt_cedula) {
        this.txt_cedula = txt_cedula;
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

    public JTextField getTxt_vendedor() {
        return txt_vendedor;
    }

    public void setTxt_vendedor(JTextField txt_vendedor) {
        this.txt_vendedor = txt_vendedor;
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

    public JButton getB_consultar() {
        return b_consultar;
    }

    public void setB_consultar(JButton b_consultar) {
        this.b_consultar = b_consultar;
    }
 
}