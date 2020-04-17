/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

/**
 *
 * @author mariopalma
 */

// metodo para la obtencion de datos en tabla
public class ClientesBD  implements TableModel{
    private List <Clientes> la;
    
    public ClientesBD (List<Clientes> Lista){
        la=Lista;
    }
    @Override
    public int getRowCount() {
        return la.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        
        String titulo=null;
        switch(columnIndex){
            case 0:{
                titulo="Cédula";
                break;
            }
             case 1:{
                titulo="Nombre";
                break;
            }
              case 2:{
                titulo="Apellidos";
                break;
            }
               case 3:{
                titulo="Direccion";
                break;
            }
                case 4:{
                titulo="Telefono";
                break;
            }
                 case 5:{
                titulo="Correo";
                break;
            }
                
        }
        return titulo;
      
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clientes e= la.get(rowIndex);
        String valor=null;
        
        switch(columnIndex){
            case 0:{
               valor=e.getCedula();
                break;
            }
             case 1:{
                valor=e.getNombres();
                break;
            }
              case 2:{
                valor=e.getApellidos();
                break;
            }
               case 3:{
               valor=e.getDireccion();
                break;
            }
                case 4:{
                valor=e.getTeléfono();
                break;
            }
                 case 5:{
                valor=e.getCorreo();
                break;
            }
                
        }
        return valor;
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       //sirve si en caso modifica de la tabla
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
