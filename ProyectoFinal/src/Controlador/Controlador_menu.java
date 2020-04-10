
package Controlador;

import Vistas.login;
import Vistas.Registro_clientes;
import Vistas.Registro_producto;
import Vistas.Vista_Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import lol.Generar_factura;

public class Controlador_menu implements ActionListener{
    Vista_Principal menu=new Vista_Principal();
    public Controlador_menu(Vista_Principal menu){
            this.menu=menu;
    }
    @Override
    public void actionPerformed(ActionEvent event) {//accion para abrir la ventana producto
      if (event.getSource() == menu.getRegistro_producto()) {
            new Registro_producto().Iniciar_Componentes();
             //menu.Disposer(); 
        }
      if(event.getSource()== menu.getRegistro_clientes()){//accion para abrir la ventana clientes
          new Registro_clientes().Iniciar_Componentes();
          //menu.Disposer();
      }
       if(event.getSource()== menu.getNueva_factura()){//accion para abrir la ventana factura
          new Generar_factura().Iniciar_Componentes();
          //menu.Disposer();
      }
      if(event.getSource()==menu.getSalir()){//accion para salir del programa
        if (JOptionPane.showConfirmDialog(null, "Quieres salir del sistema ", " ", JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION){
                      System.exit(0);
                }
        }
    }
}

