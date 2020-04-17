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
 * @author erickgaona
 */

// metodo para la obtencion de datos en tabla
public class FacturaBD  implements TableModel{
    private List <Factura> la;
    
    public FacturaBD (List<Factura> Lista){
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
                titulo="Codigo";
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
        Factura e= la.get(rowIndex);
        String valor=null;
        
        switch(columnIndex){
            case 0:{
               valor=e.getCodigo();
                break;
            }
             case 1:{
                valor=e.getArticulo();
                break;
            }
              case 2:{
                valor=e.getDescripcion();
                break;
            }
               case 3:{
               valor=e.getValor();
                break;
            }
                case 4:{
                valor=e.getIva();
                break;
            }
                 case 5:{
                valor=e.getCantidad();
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
