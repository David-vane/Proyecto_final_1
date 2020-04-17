
package Controlador;

import Modelo.Factura;
import Modelo.SistemaBD;
import Vistas.Generar_factura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Gaona
 */
public class Controlador_factura implements ActionListener{
                
        Generar_factura Factura;
        SistemaBD abd;
        Factura a; 
        public Controlador_factura(Generar_factura fac){
        this.Factura=fac;
        }
        //acciones de la vista clientes
    @Override
    public void actionPerformed(ActionEvent e) {//accion boton guardar de la vista clientes
        
        if (e.getSource() == Factura.getB_clientes()) {
            a=abd.buscarClienteFact(Factura.verificarClientes());
            //System.out.println("zd:"+Generar_factura.verificarClientes);
        if(a.getCedula()==null){
                // no esta llamar->
                Factura.limpiarCampos();
                Factura.desbloquearCampos();
        }else{
            // si esta llamar->>>>
             Factura.bloquearCampos();
             JOptionPane.showMessageDialog(Factura, "El Alumno  "+a.getNombres()+
                     " "+a.getApellidos()+"  ya se encuentra registrado");
              Factura.cargarCampos(a);
        }
        
        }
        if (e.getSource() == Factura.getB_producto()){
            System.out.println("Consultando....");
            Factura.actualizarClientefact(abd.cargarFact());
            
      }
        if (e.getSource() == Factura.getB_atras()) {
            Factura.Disposer();
            
      }
        if (e.getSource() == Factura.getB_editar()) {
            Factura.desbloquearCampos();
            
      }
    }
    
}
    /*if(event.getSource()== Clientes.getB_guardar()){
        System.out.println("Guardando..... ");
                //de la vista recibo un alumno
                a=Clientes.guardarCliente();
                //en la base de datos envio un alumno a guardar
                abd.guardarClienteBD(a);
        if (event.getSource() == Clientes.getB_eliminar()) {//accion boton eliminar 
            if (JOptionPane.showConfirmDialog(null, "Quieres Eliminar el registro? ", " ", JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION){
                 abd.eliminar( Clientes.eliminarCliente());     
                }else{
            JOptionPane.showMessageDialog(null, "No se a eliminado el registro ");
      }   
        }
        if (event.getSource() == Clientes.getB_consultar()) {
            Clientes.actualizarCliente(abd.cargar());
            
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
*/

    

    


    
    
    
    
    
