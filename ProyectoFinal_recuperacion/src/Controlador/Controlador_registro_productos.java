
package Controlador;

import Modelo.Productos;
import Modelo.SistemaBD;
import Vistas.Registro_clientes;
import Vistas.Registro_producto;
import Vistas.Vista_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Gaona
 */
public class Controlador_registro_productos implements ActionListener{
                
        Registro_producto producto;
        SistemaBD abd;
        Productos a; 
        public Controlador_registro_productos(Registro_producto cli){
        this.producto=cli;
        }
        
        //acciones de la vista productos
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()== producto.getB_guardar()){
        System.out.println("Guardando..... ");
                //de la vista recibo un alumno
                a=producto.guardarProducto();
                //en la base de datos envio un alumno a guardar
                abd.guardarProductoBD(a);
        }
        if (event.getSource() == producto.getB_eliminar()) {
            if (JOptionPane.showConfirmDialog(null, "Quieres Eliminar el registro? ", " ", JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION){
                 abd.eliminarProductoBD( producto.eliminarProducto());     
                }else{
            JOptionPane.showMessageDialog(null, "No se a eliminado el registro ");
                     }   
        }
        if (event.getSource() == producto.getB_consultar()) {
            producto.actualizarProducto(abd.cargarProducto());
            
        }
        if (event.getSource() == producto.getB_editar()) {
            producto.desbloquearCampos();
            
      }
        if (event.getSource() == producto.getB_actualizar()) {
        if (JOptionPane.showConfirmDialog(null, "Quieres Actualizar el registro? ", " ", JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION){
                 abd.eliminarProductoBD( producto.eliminarProducto()); 
       JOptionPane.showMessageDialog(null, "Registro Actualizado con EXITO ");
                 abd.guardarProductoBD(producto.guardarProducto());           
        }else{
            JOptionPane.showMessageDialog(producto, "No se a actualizado el registro "); 
        }
        }
        if (event.getSource() == producto.getB_verificar()) {
            System.out.println("Verificando...");
            a=abd.buscarProducto(producto.verificarproducto());
        if(a.getCodigo()==null){
                // no esta llamar->
                producto.limpiarCampos();
                producto.desbloquearCampos();
        }else{
            // si esta llamar->>>>
             producto.bloquearCampos();
             JOptionPane.showMessageDialog(producto, "El Producto  "+a.getCodigo()+
                     " "+a.getArticulo()+"  ya se encuentra registrado");
              producto.cargarCampos(a);
                
        
        }
        }
        if (event.getSource() == producto.getB_atras()) {
            producto.Disposer();
            
      }
        
        
}
}
    

    


    
    
    
    
    
