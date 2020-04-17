
package Controlador;

import Modelo.Clientes;
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
public class Controlador_registro_clientes implements ActionListener{
                
        Registro_clientes Clientes;
        SistemaBD abd;
        Clientes a; 
        public Controlador_registro_clientes(Registro_clientes cli){
        this.Clientes=cli;
        }
        
        //acciones de la vista clientes
    @Override
    public void actionPerformed(ActionEvent event) {//accion boton guardar de la vista clientes
        if(event.getSource()== Clientes.getB_guardar()){
        System.out.println("Guardando..... ");
                //de la vista recibo un alumno
                a=Clientes.guardarCliente();
                //en la base de datos envio un alumno a guardar
                abd.guardarClienteBD(a);
        }
        if (event.getSource() == Clientes.getB_eliminar()) {//accion boton eliminar 
            if (JOptionPane.showConfirmDialog(null, "Quieres Eliminar el registro? ", " ", JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION){
                 abd.eliminar( Clientes.eliminarCliente());     
                }else{
            JOptionPane.showMessageDialog(null, "No se a eliminado el registro ");
      }   
        }
        if (event.getSource() == Clientes.getB_consultar())
            System.out.println("Consultando....");{
            Clientes.actualizarCliente(abd.cargar());
            
      }
        if (event.getSource() == Clientes.getB_editar()) {
            Clientes.desbloquearCampos();
            
      }
        if (event.getSource() == Clientes.getB_atras()) {
            Clientes.Disposer();
            
      }
        if (event.getSource() == Clientes.getB_actualizar()) {
        if (JOptionPane.showConfirmDialog(null, "Quieres Actualizar el registro? ", " ", JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION){
                 abd.eliminar( Clientes.eliminarCliente()); 
       JOptionPane.showMessageDialog(null, "Registro Actualizado con EXITO ");
                 abd.guardarClienteBD(Clientes.guardarCliente());           
        }else{
            JOptionPane.showMessageDialog(Clientes, "No se a actualizado el registro "); 
        }
        }
        if (event.getSource() == Clientes.getB_verificar()) {
            System.out.println("Verificando...");
            a=abd.buscarCliente(Clientes.verificarCliente());
        if(a.getCedula()==null){
                // no esta llamar->
                Clientes.limpiarCampos();
                Clientes.desbloquearCampos();
        }else{
            // si esta llamar->>>>
             Clientes.bloquearCampos();
             JOptionPane.showMessageDialog(Clientes, "El Alumno  "+a.getNombres()+
                     " "+a.getApellidos()+"  ya se encuentra registrado");
              Clientes.cargarCampos(a);
                
        
        }
            
      }
        
}
}
    

    


    
    
    
    
    
